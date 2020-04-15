package com.reactiveworks.stocktrade.dao.exception;

/**
 * A exception class which is expected to thrown 
 * when there is a format error when reading the data.
 * @author Elangovan
 *
 */
public class StockTradeInValidFormatException extends StockTradeDAOException {
	
	/**
	 * Default Constructor
	 */
	public StockTradeInValidFormatException() {
		super();
	}
	
	/**
	 * Constructor with message and cause.
	 * @param message user-defined message to be printed
	 * @param cause reason that cause the exception
	 */
	public StockTradeInValidFormatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Constructor with message 
	 * @param message user-defined message to be printed
	 */
	public StockTradeInValidFormatException(String arg0) {
		super(arg0);
	
	}

	/**
	 * Constructor with cause
	 * @param cause reason that cause the exception
	 */
	public StockTradeInValidFormatException(Throwable arg0) {
		super(arg0);
	
	}

}
