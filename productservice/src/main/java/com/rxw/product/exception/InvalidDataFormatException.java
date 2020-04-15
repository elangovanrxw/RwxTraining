package com.rxw.product.exception;

/**
 * A custom exception class which is handling
 * expections relating to the validation of 
 * data from CSV file.
 * @author Elangovan
 *
 */
public class InvalidDataFormatException extends Exception {

	public InvalidDataFormatException() {
		super();

	}

	public InvalidDataFormatException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public InvalidDataFormatException(String arg0) {
		super(arg0);

	}

	public InvalidDataFormatException(Throwable arg0) {
		super(arg0);

	}
	

}
