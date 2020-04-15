package com.reactiveworks.usercrudsoap.dao.exception;
/**
 * An exception which is expected to be thrown when any
 * database relation operation results in failure.
 * @author Elangovan
 *
 */
public class UserDAOException extends Exception {

	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public UserDAOException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public UserDAOException(String message, Throwable cause) {
		super(message, cause);
		
	}


	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public UserDAOException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public UserDAOException(Throwable cause) {
		super(cause);
		
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
 
}
