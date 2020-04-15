package com.reactiveworks.restiplexercise.matches.dao.factory;

import org.apache.log4j.Logger;
import com.reactiveworks.restiplexercise.matches.dao.IMatchesDAO;
import com.reactiveworks.restiplexercise.matches.dao.impl.MatchesDAOSQLImpl;

/**
 * A factory class to provide the instance of the {@link IMatchesDAO}
 * 
 * @author Elangovan
 *
 */
public class MatchesDAOFactory {

	/**
	 * Logger Implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(MatchesDAOFactory.class);
	

	/**
	 * Instance of {@link IMatchesDAO}
	 */
	private static IMatchesDAO matchesDAOInstance;
	
	/**
	 * A static method which is used to get the instance.
	 * @return the instance of {@link IMatchesDAO}
	 */
	public static IMatchesDAO getMatchesInstance() {
		
		if(matchesDAOInstance == null) {
				matchesDAOInstance = new MatchesDAOSQLImpl();
		}
		LOGGER.debug("Returning instance from MatchesDAOFactory..");
		return matchesDAOInstance;
	}
}
