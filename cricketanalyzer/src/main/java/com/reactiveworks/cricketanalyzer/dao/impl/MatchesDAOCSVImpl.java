package com.reactiveworks.cricketanalyzer.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.reactiveworks.cricketanalyzer.dao.IReaderDAO;
import com.reactiveworks.cricketanalyzer.dao.exception.FileAccessFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.FileOperationFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.InputFormatException;
import com.reactiveworks.cricketanalyzer.pojo.Matches;

public class MatchesDAOCSVImpl implements IReaderDAO<Matches> {

	/**
	 * A logger for logging the data for debugging purposes.
	 */
	private static final Logger LOGGER = Logger.getLogger(MatchesDAOCSVImpl.class);
	/**
	 * A constant which contains the file name.
	 */
	public static final String FILE_NAME = "matches.csv";

	/**
	 * This method is used to seperate the line string into parts
	 * and to return it as an Matches class object.
	 * @param lineString contains the data in the entire line.
	 * @return	Deliveries class object contains the delivery data.
	 */
	private Matches parseMatchData(String lineString) throws InputFormatException {
			
		String values[] = lineString.split(",");		
		Matches matches = new Matches();
		
		try {
			matches.setMatchId(Integer.parseInt(values[0]));
			matches.setSeason(Integer.parseInt(values[1]));
		
			matches.setCity(values[2]);
			matches.setDate(LocalDate.parse(values[3]));
			matches.setFirstTeam(values[4]);
	
			matches.setSecondTeam(values[5]);
			matches.setTossWinner(values[6]);
			matches.setTossDecision(values[7]);
			matches.setResult(values[8]);
			if(values.length==10) {
				matches.setWinner(values[9]);
			}
			else
				matches.setWinner(null);
			}
		catch(NumberFormatException formatExp) {
			throw new InputFormatException("Number format is incorrect.",formatExp);
		}
		return matches;
	}
	
	/**
	 * A method which is responsible for the file reading operation.
	 * Reads the data form the file, and store it to an list.
	 * @return a list of matches data in a list.
	 * @throws InputFormatException if there is any error when converting formats.
	 * @throws FileAccessFailureException if any error in accessing file.
	 * @throws FileOperationFailureException if any error when performing operations on file.
	 */
	@Override
	public List<Matches> readFromCSVFile() throws FileAccessFailureException, FileOperationFailureException {
	
		try {
			URI file = this.getClass().getResource("/"+FILE_NAME).toURI();		//Converting to URI
			LOGGER.info("Matches file is found at location : "+file);
			
			BufferedReader reader = Files.newBufferedReader(Paths.get(file));
			
			//To avoid the heading (MATCH_ID,SEASON,CITY,DATE, etc..)
			reader.readLine();
			
			List<Matches> matchList = reader.lines()
										  .map(line -> {
											try {
												return parseMatchData(line);
											} catch (InputFormatException ife) {
												LOGGER.error("Exception occured when parsing : ",ife);
											}
											return null;
										})
										  .collect(Collectors.toList());
			
			reader.close(); 			//Closing BufferedReader.
			
			return matchList;
			
		}catch (FileNotFoundException fileNotFoundExp) {
			LOGGER.error("Matches file is not present at given classpath",fileNotFoundExp);
			throw new FileAccessFailureException("Deliveries file is not present at given classpath",fileNotFoundExp);
		} catch (IOException ioexp) {
			LOGGER.error("Matches file is not readable. ",ioexp);
			throw new FileOperationFailureException("Matches file is not readable. ",ioexp);
		} catch (URISyntaxException uriExp) {
			LOGGER.error("Given path string could not be parsed as a URI reference. ",uriExp);
			throw new FileOperationFailureException("Given path string could not be parsed as a URI reference. ",uriExp);
		}
		
	}

}
