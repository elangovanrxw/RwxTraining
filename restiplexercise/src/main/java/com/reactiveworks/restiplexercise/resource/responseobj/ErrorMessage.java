package com.reactiveworks.restiplexercise.resource.responseobj;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class which instance has to be returned as a response when any exception occurs.
 * @author Elangovan
 *
 */
@XmlRootElement
public class ErrorMessage {

	/**
	 * Status code for the response.
	 */
	private int statusCode;
	
	/**
	 * Error message for the response.
	 */
	private String errorMessage;

	/*
	 * Getters and setters for the instance variables.
	 */
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}
