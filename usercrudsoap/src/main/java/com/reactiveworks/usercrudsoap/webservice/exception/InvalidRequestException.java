package com.reactiveworks.usercrudsoap.webservice.exception;

/**
 * An exception class which is required to be thrown to the client when an 
 * invalid request is made to the server.
 * @author Elangovan
 *
 */
public class InvalidRequestException extends Exception {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Default constructor
	 */
	public InvalidRequestException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public InvalidRequestException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public InvalidRequestException(Throwable cause) {
		super(cause);
		
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
}
