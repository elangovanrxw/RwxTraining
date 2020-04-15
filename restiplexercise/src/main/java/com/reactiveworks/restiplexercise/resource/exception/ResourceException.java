package com.reactiveworks.restiplexercise.resource.exception;

/**
 * An exception class which is thrown when any exception occurs in the 
 * resource class when performing the operations in the resources.
 * @author Elangovan
 *
 */
public class ResourceException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Response status code.
	 */
	private int responseStatusCode;

	public int getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(int responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	/**
	 * Default Constructor
	 */
	public ResourceException() {
		super();

	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public ResourceException(String message, Throwable cause,int statusCode) {
		super(message, cause);
		this.responseStatusCode = statusCode;
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 * @param statusCode the status code which is to be set.
	 */
	public ResourceException(String message,int statusCode) {
		super(message);	
		this.responseStatusCode = statusCode;
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public ResourceException(Throwable cause,int statusCode) {
		super(cause);
		this.responseStatusCode = statusCode;
	}

	
}
