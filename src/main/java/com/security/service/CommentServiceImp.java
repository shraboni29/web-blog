package com.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.commandform.CommentCommandForm;
import com.security.dao.CommentDao;
import com.security.entity.Comment;
import com.security.entity.Post;

@Service
public class CommentServiceImp implements CommentService {
@Autowired
   public CommentDao commentDao;
	@Override
	
	public void saveComment(CommentCommandForm c2) {
		
		
		commentDao.saveComment(c2);
		
	}
	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return commentDao.getComments();
	}
	
	@Override
	public List<Comment> findCommentbyPostId(int postid) {
		// TODO Auto-generated method stub
		return commentDao.findCommentbyPostId(postid);
	}
	@Override
	public long getTotalComment(int postid) {
		// TODO Auto-generated method stub
		return commentDao.getTotalComment(postid);
	}

}
