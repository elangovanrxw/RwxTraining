package com.reactiveworks.cricketanalyzer.dao.exception;


/**
 * A exception class which is expected to thrown 
 * when performing any file accessing related operations.
 * @author Elangovan
 *
 */
public class FileAccessFailureException extends Exception{

	/**
	 * Default Constructor
	 */
	public FileAccessFailureException() {
		super();
		 
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public FileAccessFailureException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public FileAccessFailureException(String message) {
		super(message);
		 
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public FileAccessFailureException(Throwable cause) {
		super(cause);
		 
	}

	
}
