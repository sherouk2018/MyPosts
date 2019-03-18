package com.MyPosts.entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@Column(name="USER_ID")
	private long userID;
	
	@Column(name="POST")
	private String post;

	@Column(name="STATUS")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name="TIMESTAMP")
	private LocalDateTime dateCreated;
	
	public Post(long userId, String post, String status) {
		this.post = post;
		this.userID = userId;
		this.status = status;
		dateCreated = LocalDateTime.now();
	}

	public Post() {

	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public long getId() {
		return this.id;
	}

}
