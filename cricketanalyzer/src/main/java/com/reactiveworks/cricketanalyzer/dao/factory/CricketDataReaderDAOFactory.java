package com.reactiveworks.cricketanalyzer.dao.factory;

import org.apache.log4j.Logger;

import com.reactiveworks.cricketanalyzer.dao.IReaderDAO;
import com.reactiveworks.cricketanalyzer.dao.impl.DeliveriesDAOCSVImpl;
import com.reactiveworks.cricketanalyzer.dao.impl.MatchesDAOCSVImpl;
import com.reactiveworks.cricketanalyzer.pojo.Deliveries;
import com.reactiveworks.cricketanalyzer.pojo.Matches;

/**
 * A class to provide the instance of the required reader implementation.
 * @author Elangovan
 *
 */
public class CricketDataReaderDAOFactory {

	/**
	 * A logger for logging the data for debugging purposes.
	 */
	private static final Logger LOGGER = Logger.getLogger(CricketDataReaderDAOFactory.class);
	
	private static IReaderDAO<Deliveries> deliveryInstance;
	
	private static IReaderDAO<Matches> matchesInstance;
	
	/**
	 * A method to get the {@link DeliveriesDAOCSVImpl} instance
	 * to perform the required operations.
	 * @return
	 */
	public static IReaderDAO<Deliveries> getDeliveryInstance() {
		
		if(deliveryInstance==null) {
			LOGGER.debug("Creating new instance for delivery..");
			deliveryInstance = new DeliveriesDAOCSVImpl();
		}
		LOGGER.debug("Returning instance of delivery..");
		return deliveryInstance;
	}
	
	/**
	 * A method to get the {@link MatchesDAOCSVImpl} instance
	 * to perform the required operations.
	 * @return
	 */
	public static IReaderDAO<Matches> getMatchesInstance() {
		
		if(matchesInstance==null) {
			LOGGER.debug("Creating new instance for matches..");
			matchesInstance = new MatchesDAOCSVImpl();
		}
		LOGGER.debug("Returning instance of matches..");
		return matchesInstance;
	}
}
