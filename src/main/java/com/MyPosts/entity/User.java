package com.MyPosts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@Column(name="NAME")
	private String name;
	
	//TODO should be saved encoded
	@Column(name="PASSWORD")
	private String password;
	@Column(name="EMAIL")
	private String email;
	
	
	public User (String name, String password, String email){
		this.name = name;
		this.password = password;
		this.email = email;
		
	}
	 public User() {
	   }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return this.id;
	}
	

}
