package com.rxw.product.base;

import com.rxw.product.exception.InvalidDataException;

public class User {
  
	private String userId;
	private String userName;
	private String email;
	private String phoneNumber;
	private String city;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws InvalidDataException {
		if(email.contains("@"))
		     this.email = email;
		else
			throw new InvalidDataException("Invalid email id "+email);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString()
	{
		return userId+" "+userName+" "+email+" "+phoneNumber+" "+city;
	}
	
}
