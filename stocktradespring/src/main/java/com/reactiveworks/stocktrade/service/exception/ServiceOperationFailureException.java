package com.reactiveworks.stocktrade.service.exception;

/**
 * An exception which is expected to thrown when 
 * any service method in the business logic 
 * unable to fully perform its operation.
 * @author Elangovan
 *
 */
public class ServiceOperationFailureException extends StockTradeServiceException {

	public ServiceOperationFailureException() {
		super();
		
	}

	public ServiceOperationFailureException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ServiceOperationFailureException(String message) {
		super(message);
		
	}

	public ServiceOperationFailureException(Throwable cause) {
		super(cause);
		
	}


	

}
