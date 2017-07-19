package com.revature.bean;

import java.io.Serializable;

public class Users implements Serializable {

	
	
	//Constructors
	
	public Users(){};
	
	public Users(int userId, int roleId, String email, String password, String firstName, String lastName) {
		this.userId = userId;
		this.roleId = roleId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	//State
	private int userId;
	private int roleId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;

	//Getters and Setters
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//toString()
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", roleId=" + roleId + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + "]";
	}

	

	
	
	
}
