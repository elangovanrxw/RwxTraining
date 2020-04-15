package com.reactiveworks.stocktrade.db.exception;

import com.reactiveworks.stocktrade.exception.AccessFailureException;

/**
 * A exception class which is expected to thrown 
 * when there is any failure in access to the database.
 * @author Elangovan
 *
 */
public class DatabaseAccessFailureException extends AccessFailureException  {

	/**
	 * Default Constructor
	 */
	public DatabaseAccessFailureException() {
		super();

	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public DatabaseAccessFailureException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public DatabaseAccessFailureException(String arg0) {
		super(arg0);

	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public DatabaseAccessFailureException(Throwable arg0) {
		super(arg0);

	}

	
	

}
