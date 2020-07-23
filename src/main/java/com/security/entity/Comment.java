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

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	int comment_id;

	@Column(name = "body")
	String body;

	@Column(name = "comment_date")
	Date comment_date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	Users usercomment;
	//
	//
	// @OneToOne(cascade=CascadeType.ALL)
	// @JoinColumn(name="post_id")
	// Post postcomment;
	// @Column(name="user_id")
	// int user_id;
	@Column(name = "post_id")
	int postId;

	public Comment() {

	}

	public Comment(String body, Date comment_date, Users usercomment, int postId) {
		super();
		this.body = body;
		this.comment_date = comment_date;
		this.usercomment = usercomment;
		this.postId = postId;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

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

	public Users getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(Users usercomment) {
		this.usercomment = usercomment;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", body=" + body + ", comment_date=" + comment_date
				+ ", usercomment=" + usercomment + ", postId=" + postId + "]";
	}

}
