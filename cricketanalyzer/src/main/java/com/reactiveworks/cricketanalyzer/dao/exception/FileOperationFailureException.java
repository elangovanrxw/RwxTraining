package com.reactiveworks.cricketanalyzer.dao.exception;


/**
 * A exception class which is expected to thrown 
 * when performing any file reading related operations.
 * @author Elangovan
 *
 */
public class FileOperationFailureException extends Exception {

	/**
	 * Default Constructor
	 */
	public FileOperationFailureException() {
		super();
		 
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public FileOperationFailureException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public FileOperationFailureException(String message) {
		super(message);
		 
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public FileOperationFailureException(Throwable cause) {
		super(cause);
		 
	}

	
}
