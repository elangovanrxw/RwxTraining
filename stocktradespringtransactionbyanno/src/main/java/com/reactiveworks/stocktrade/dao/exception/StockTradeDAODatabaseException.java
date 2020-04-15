package com.reactiveworks.stocktrade.dao.exception;

/**
 * A exception class which is expected to thrown 
 * when performing any file related operations 
 * when the implementation type is any database type.
 * @author Elangovan
 *
 */
public class StockTradeDAODatabaseException extends StockTradeDAOException {

	/**
	 * Default Constructor
	 */
	public StockTradeDAODatabaseException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public StockTradeDAODatabaseException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public StockTradeDAODatabaseException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public StockTradeDAODatabaseException(Throwable cause) {
		super(cause);
		
	}

	


}
