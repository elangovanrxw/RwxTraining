package com.reactiveworks.stocktrade.exception;

/**
 * A generic exception class which is expected to thrown 
 * when there is any failure in accessing resources.
 * @author Elangovan
 *
 */
public class AccessFailureException extends Exception {

	/**
	 * Default Constructor
	 */
	public AccessFailureException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public AccessFailureException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public AccessFailureException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public AccessFailureException(Throwable cause) {
		super(cause);
		
	}

	
}
