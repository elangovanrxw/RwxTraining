package com.reactiveworks.restiplexercise.dao.exception;

public class DatabaseDAOException extends DAOException {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public DatabaseDAOException() {
		super();

	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public DatabaseDAOException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public DatabaseDAOException(String message) {
		super(message);
	
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public DatabaseDAOException(Throwable cause) {
		super(cause);
	
	}
	
	

}
