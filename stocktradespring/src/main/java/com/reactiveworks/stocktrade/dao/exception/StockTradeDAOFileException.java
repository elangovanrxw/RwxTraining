package com.reactiveworks.stocktrade.dao.exception;

/**
 * A exception class which is expected to thrown 
 * when performing any file related operations 
 * when the implementation type is CSV
 * @author Elangovan
 *
 */
public class StockTradeDAOFileException extends StockTradeDAOException {

	/**
	 * Default Constructor
	 */
	public StockTradeDAOFileException() {
		super();
		
	}

	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public StockTradeDAOFileException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public StockTradeDAOFileException(String message) {
		super(message);
		
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public StockTradeDAOFileException(Throwable cause) {
		super(cause);
		
	}


	

}
