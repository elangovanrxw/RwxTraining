package com.reactiveworks.stocktrade.dao.exception;

/**
 * A exception class which is expected to thrown 
 * when performing any operations that are not supported.
 * @author Elangovan
 *
 */
public class OperationNotSupportedException extends Exception {

	/**
	 * Default Constructor
	 */
	public OperationNotSupportedException() {
		super();
		 
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public OperationNotSupportedException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public OperationNotSupportedException(String message) {
		super(message);
		 
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public OperationNotSupportedException(Throwable cause) {
		super(cause);
		 
	}


	
}
