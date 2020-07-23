package com.security.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//import com.mysql.cj.xdevapi.SessionFactory;
import com.security.commandform.CommentCommandForm;
import com.security.entity.Comment;
import com.security.entity.Post;
import com.security.entity.Users;
import com.security.service.BlogService;
import com.security.service.UserService;

@Repository
@Component
public class CommentDaoImp implements CommentDao {

	@Autowired
	public SessionFactory sessionFactory;
	@Autowired
	UserService userService;
	@Autowired
	BlogService blogService;

	@Transactional
	@Override
	public void saveComment(CommentCommandForm c2) {
		Session session = sessionFactory.getCurrentSession();
		Users u = userService.findByUserName(c2.getUsername());

		Comment com = new Comment();
		com.setBody(c2.getBody());
		Date date = new Date();
		com.setComment_date(date);
		com.setPostId(c2.getPostId());
		// com.setUser_id(c2.getUser_id());
		// com.setPostcomment(postcomment);
		com.setUsercomment(u);
		// Post p1=blogService.getPosts(p1.getPostId());

		// com.setPostcomment(p1.getPostId());
		// Post p1=new Post();
		// com.setPostcomment(p1);
		session.save(com);

	}

	@Transactional
	@Override

	public List<Comment> getComments() {
		Session session = sessionFactory.getCurrentSession();

		Query<Comment> q2 = session.createQuery("from Comment", Comment.class);
		List<Comment> commentList = q2.getResultList();

		System.out.println("Total posts returne from DB : " + commentList.size());

		return commentList;
	}

	@Transactional

	@Override
	public List<Comment> findCommentbyPostId(int postid) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Comment> theQuery = currentSession.createQuery("from Comment where postId=:upost", Comment.class);
		theQuery.setParameter("upost", postid);
		List<Comment> commentList = null;
		try {
			commentList = theQuery.getResultList();
		} catch (Exception e) {
			commentList = null;
		}

		return commentList;

	}

	@Transactional
	@Override
	public long getTotalComment(int postid) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("SELECT count() FROM Comment where postId=:upost", Comment.class);
		theQuery.setParameter("upost", postid);

		Long count = (Long) theQuery.uniqueResult();
		return count;
	}

}
