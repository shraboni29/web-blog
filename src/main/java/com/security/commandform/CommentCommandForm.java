package com.security.commandform;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class CommentCommandForm {
	

	
	@NotNull
	String body ;
	
	@NotNull
	Date comment_date;
	String username;
	
	int postId;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	


}
