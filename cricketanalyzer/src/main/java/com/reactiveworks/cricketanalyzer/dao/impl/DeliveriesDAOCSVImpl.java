package com.reactiveworks.cricketanalyzer.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.reactiveworks.cricketanalyzer.dao.IReaderDAO;
import com.reactiveworks.cricketanalyzer.dao.exception.FileAccessFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.FileOperationFailureException;
import com.reactiveworks.cricketanalyzer.dao.exception.InputFormatException;
import com.reactiveworks.cricketanalyzer.pojo.Deliveries;
import com.reactiveworks.cricketanalyzer.pojo.Matches;


public class DeliveriesDAOCSVImpl implements IReaderDAO<Deliveries> {

	/**
	 * A logger for logging the data for debugging purposes.
	 */
	private static final Logger LOGGER = Logger.getLogger(DeliveriesDAOCSVImpl.class);
	
	/**
	 * A constant which contains the file name.
	 */
	public static final String FILE_NAME = "deliveries.csv";
	
	/**
	 * This method is used to seperate the line string into parts
	 * and to return it as an Deliveries class object.
	 * @param lineString contains the data in the entire line.
	 * @return	Deliveries class object contains the delivery data.
	 * @throws InputFormatException if any format in error is occured.
	 */
	private Deliveries parseDeliveryData(String lineString) throws InputFormatException {
			
			String values[] = lineString.split(",");
			
			Deliveries deliveryData = new Deliveries();		
			try {
				deliveryData.setMatchId(Integer.parseInt(values[0]));
				deliveryData.setInning(Integer.parseInt(values[1]));
				deliveryData.setBattingTeam(values[2]);
				deliveryData.setBowlingTeam(values[3]);
				deliveryData.setOver(Integer.parseInt(values[4]));
				deliveryData.setBall(Integer.parseInt(values[5]));
				deliveryData.setBatsman(values[6]);
				deliveryData.setBowler(values[7]);
				deliveryData.setWideRuns(Integer.parseInt(values[8]));
				deliveryData.setByeRuns(Integer.parseInt(values[9]));
				deliveryData.setLegbyeRuns(Integer.parseInt(values[10]));
				deliveryData.setNoballRuns(Integer.parseInt(values[11]));
				deliveryData.setPenaltyRuns(Integer.parseInt(values[12]));
				deliveryData.setBatsmanRuns(Integer.parseInt(values[13]));
				deliveryData.setExtraRuns(Integer.parseInt(values[14]));
				deliveryData.setTotalRuns(Integer.parseInt(values[15]));
			}
			catch(NumberFormatException nfeExp) {
				throw new InputFormatException("Incorrect format : ",nfeExp);
			}
			
			return deliveryData;
		}
	
	/**
	 * A method which is responsible for the file reading operation.
	 * Reads the data form the file, and store it to an list.
	 * @return a list of Deliveries data in a list.
	 * @throws FileAccessFailureException if any error in accessing file.
	 * @throws FileOperationFailureException if any error when performing operations on file.
	 */
	@Override
	public List<Deliveries> readFromCSVFile() throws FileAccessFailureException, FileOperationFailureException {
		
		try {
			
			URI file = this.getClass().getResource("/"+FILE_NAME).toURI();		//Converting to URI	
			LOGGER.info("Deliveries file is found at location : "+file);
			
			BufferedReader reader = Files.newBufferedReader(Paths.get(file));	//Getting BufferedReader
			
			reader.readLine();			//To neglect the heading title. (like MATCH_ID,INNING,BATTING_TEAM, etc..)
			
			List<Deliveries> deliveryList = reader.lines()
												  .map(line -> {
													try {
														return parseDeliveryData(line);
													} catch (InputFormatException ie) {
														LOGGER.error("Exception occured when parsing: ",ie);
													}
													return null;
												})
												  .collect(Collectors.toList());
			
			return deliveryList;
			
		}catch (FileNotFoundException fileNotFoundExp) {
			LOGGER.error("Deliveries file is not present at the given path",fileNotFoundExp);
			throw new FileAccessFailureException("Deliveries file is not present at given classpath",fileNotFoundExp);
		} catch (IOException ioexp) {
			LOGGER.error("Deliveries file is not readable. ",ioexp);
			throw new FileOperationFailureException("Deliveries file is not readable. ",ioexp);
		} catch (URISyntaxException uriExp) {
			LOGGER.error("Given path string could not be parsed as a URI reference. ",uriExp);
			throw new FileOperationFailureException("Given path string could not be parsed as a URI reference. ",uriExp);
		} 
	}

}
