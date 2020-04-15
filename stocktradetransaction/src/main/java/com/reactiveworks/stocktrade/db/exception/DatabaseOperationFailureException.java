package com.reactiveworks.stocktrade.db.exception;

import com.reactiveworks.stocktrade.exception.OperationFailureException;

/**
 * A exception class which is expected to thrown 
 * when there is any failure in performing operations into database.
 * @author Elangovan
 *
 */
public class DatabaseOperationFailureException extends OperationFailureException {

	/**
	 * Default Constructor
	 */
	public DatabaseOperationFailureException() {
		super();
		 
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public DatabaseOperationFailureException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		 
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public DatabaseOperationFailureException(String arg0) {
		super(arg0);
		 
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public DatabaseOperationFailureException(Throwable arg0) {
		super(arg0);
		 
	}

	
}
