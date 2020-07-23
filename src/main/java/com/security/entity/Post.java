package com.security.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.springframework.security.core.userdetails.User;
@Entity
@Table(name="post",schema="blogdb")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")

	int postId;
	
	@Column(name="title")
	String title;
	
	@Column(name="body")
	String body;

	@Column(name="post_date")
	Date postDate;
//	@Column(name="user_id")
//	int user_id;
	 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	Users userPost;
//	
	public Post()
	{
		
	}
	public Post(String title, String body, Date postDate) {
		//super();
		this.title = title;
		this.body = body;
		this.postDate = postDate;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
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
	
	
	
	public Users getUserPost() {
		return userPost;
	}
	public void setUserPost(Users userPost) {
		this.userPost = userPost;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", body=" + body + ", postDate=" + postDate
				+ ", userPost=" + userPost + "]";
	}
	
	

	
	
	
}
