package com.reactiveworks.productwithsoapserver.dao.exception;

/**
 * An expection class which is expected to be thrown 
 * when performing any database related operations.
 * @author Elangovan
 *
 */
public class ProductDAOException extends Exception {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public ProductDAOException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public ProductDAOException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public ProductDAOException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public ProductDAOException(Throwable cause) {
		super(cause);
		
	}

	
}
