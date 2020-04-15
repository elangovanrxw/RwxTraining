package com.reactiveworks.restiplexercise.service.exception;

/**
 * An exception which is to be thrown from the service layer.
 * @author Elangovan
 *
 */
public class ServiceException extends Exception {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public ServiceException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public ServiceException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public ServiceException(Throwable cause) {
		super(cause);
		
	}

	
}
