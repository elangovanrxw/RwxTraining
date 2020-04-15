package com.rxw.product.exception;

/**
 * A custom exception class which handles
 * in price related operations.
 * @author Elangovan
 *
 */
public class InvalidPriceException extends Exception {

	public InvalidPriceException() {
		super();

	}

	public InvalidPriceException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public InvalidPriceException(String arg0) {
		super(arg0);

	}

	public InvalidPriceException(Throwable arg0) {
		super(arg0);

	}

}
