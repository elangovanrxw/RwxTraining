package com.reactiveworks.stocktrade.exception;

/**
 * A generic exception class which is expected to thrown 
 * when there is any failure when performing any
 * operations on any resources.
 * @author Elangovan
 *
 */
public class OperationFailureException extends Exception {

	/**
	 * Default Constructor
	 */
	public OperationFailureException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public OperationFailureException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public OperationFailureException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public OperationFailureException(Throwable cause) {
		super(cause);
		
	}

	
}
