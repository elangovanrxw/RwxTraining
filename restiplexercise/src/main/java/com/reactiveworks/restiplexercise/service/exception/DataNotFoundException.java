package com.reactiveworks.restiplexercise.service.exception;

/**
 * A subclass of {@link ServiceException} which is to be thrown 
 * when no data is present on the instance after certain operation
 * is performed.

 * @author Elangovan
 *
 */
public class DataNotFoundException extends ServiceException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public DataNotFoundException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public DataNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public DataNotFoundException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public DataNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}
