package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.commandform.CommentCommandForm;
import com.security.commandform.PostCommandForm;
import com.security.dao.BlogDao;
import com.security.entity.Post;
@Service
public class BlogServiceImp implements BlogService {

	@Autowired
	public BlogDao blogDao;
	
//	@Override
//	public void saveBlog(Post p2) {
//		Users u1=new Users();
//		
//		
//		Date postDate = new Date();
//		p2.setPostDate(postDate);
//		
//		p2.setPostDate(postDate);
//		p2.setUser(u1);
//		blogDao.saveBlog(p2);
//		
//	}

	@Override
	public void saveBlog(PostCommandForm p2) {
		
		blogDao.saveBlog(p2);
		
	}

	@Override
	public List<Post> getPosts() {
		
		return blogDao.getPosts();
	}

	@Override
	public Post getPost(int theid) {
		// TODO Auto-generated method stub
		return blogDao.getPost(theid);
	}

	@Override
	public List<Post> searchBlog(String searchName) {
		return blogDao.searchBlog(searchName);
	}

	@Override
	public List<Post> findPostByUserid(int userId) {
		// TODO Auto-generated method stub
		return blogDao.findPostByUserid(userId);
	}

	@Override
	public void deletePostById(int postId) {
		blogDao.deletePostById(postId);
	}

}
