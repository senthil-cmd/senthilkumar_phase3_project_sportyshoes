package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	private String UserName;
	@Id
	private String uname;
	private String password;
	private String email;

	public User(String userName, String uname, String password, String email) {
		super();
		UserName = userName;
		this.uname = uname;
		this.password = password;
		this.email = email;
	}

	public User() {
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUname() {
		return uname;
	}

	public void setUnmae(String uname) {
		this.uname = uname;
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

	public User(int userId, String userName, String uname, String password, String email) {
		super();
		UserId = userId;
		UserName = userName;
		this.uname = uname;
		this.password = password;
		this.email = email;
	}

}
