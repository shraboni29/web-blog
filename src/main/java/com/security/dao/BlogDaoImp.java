package com.security.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.security.commandform.CommentCommandForm;
import com.security.commandform.PostCommandForm;
import com.security.entity.Comment;
import com.security.entity.Post;
import com.security.entity.Users;
import com.security.service.UserService;

@Repository
@Component
public class BlogDaoImp implements BlogDao {

	// @Autowired
	// public SessionFactory sessionFactory;
	// @Transactional
	// @Override
	// public void saveBlog(Post p2) {
	//
	// Session session =sessionFactory.getCurrentSession();
	//
	// session.saveOrUpdate(p2);
	//
	//
	// // TODO Auto-generated method stub
	//
	// }

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	public UserService userService;

	@Transactional
	@Override

	public void saveBlog(PostCommandForm p2) {

		Session session = sessionFactory.getCurrentSession();
		Post p3 = new Post();
		Users u = userService.findByUserName(p2.getUsername());
		p3.setTitle(p2.getTitle());
		p3.setBody(p2.getBody());
		p3.setUserPost(u);
		p3.setPostId(p2.getPostId());
		Date postDate = new Date();
		p3.setPostDate(postDate);
		if (p3.getPostId() <= 0) {
			session.save(p3);
		} else {
			session.merge(p3);

		}
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public List<Post> getPosts() {
		Session session = sessionFactory.getCurrentSession();
		// create the query
		Query<Post> q1 = session.createQuery("from Post", Post.class);

		List<Post> postList = q1.getResultList();

		System.out.println("Total posts returne from DB : " + postList.size());

		return postList;
	}

	@Transactional
	@Override
	public Post getPost(int theid) {

		Session currentSession = sessionFactory.getCurrentSession();
		Post thePost = currentSession.get(Post.class, theid);

		// now retrieve/read from database using the primary key

		return thePost;
		
	}

	@Transactional
	@Override
	public List<Post> searchBlog(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (searchName != null && searchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery = session.createQuery("from Post where lower(title) like :theName",
					Post.class);
			theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");

		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = session.createQuery("from Post", Post.class);
		}

		// execute query and get result list
		List<Post> posts = theQuery.getResultList();

		// return the results
		return posts;

	}

	@Transactional
	@Override
	public List<Post> findPostByUserid(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Post> theQuery = currentSession.createQuery("from Post where userPost.user_id=:upost", Post.class);

		theQuery.setParameter("upost", userId);
		List<Post> blogList = null;
		try {
			blogList = theQuery.getResultList();
		} catch (Exception e) {
			blogList = null;
		}
		return blogList;
	}

	@Transactional
	@Override
	public void deletePostById(int postId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Post where postId=:delPost");
				theQuery.setParameter("delPost", postId);
				theQuery.executeUpdate();
		
	}

}
