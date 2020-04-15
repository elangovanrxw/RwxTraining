package com.reactiveworks.usercrudsoap.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A general POJO class which is containing the user details.
 * @author Elangovan
 *
 */
@XmlRootElement(name="user")
@XmlType(propOrder= {"userId","username","email","phone","city"})
public class User {

	/*
	 * Instance variables for the user. 
	 */
	private String userId;
	private String username;
	private String email;
	private String phone;
	private String city;
	
	/*
	 * Getters and setters to initialize the instance variables.
	 */
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
