package com.reactiveworks.cricketanalyzer.dao;

import java.util.List;

import com.reactiveworks.cricketanalyzer.dao.exception.FileAccessFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.FileOperationFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.InputFormatException;

/**
 * An interface for the reader which contains the structure of the 
 * match details reader class implementation
 * @author Elangovan
 *
 */

@FunctionalInterface
public interface IReaderDAO<T> {

	/**
	 * This method is used to read the data and convert that
	 * data into the form of List.
	 * @return the list of contents which is read from the file.
	 * @throws InputFormatException if there is any error when converting formats.
	 * @throws FileAccessFailureException if any error in accessing file.
	 * @throws FileOperationFailureException if any error when performing operations on file.
	 */
	public List<T> readFromCSVFile() throws FileAccessFailureException,FileOperationFailureException, InputFormatException;
}
