package com.security.service;

import java.util.List;

import com.security.commandform.CommentCommandForm;
import com.security.entity.Comment;
import com.security.entity.Post;

public interface CommentService {

	void saveComment(CommentCommandForm c2);

	List<Comment> getComments();

	List<Comment> findCommentbyPostId(int postid);

	long getTotalComment(int postid);

	

	
}
