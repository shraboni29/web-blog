package com.security.commandform;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.security.entity.Comment;
import com.security.entity.Users;

public class PostCommandForm {

	int postId;
	String title;
	String body;
	Date postDate;
	
	String username;
	List<CommentCommandForm> commentList = null;
	List<Comment> commentEList = null;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<CommentCommandForm> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentCommandForm> commentList) {
		this.commentList = commentList;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public List<Comment> getCommentEList() {
		return commentEList;
	}
	public void setCommentEList(List<Comment> commentEList) {
		this.commentEList = commentEList;
	}
	
}

