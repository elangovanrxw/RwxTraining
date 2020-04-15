package com.reactiveworks.restiplexercise.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.matches.dao.IMatchesDAO;
import com.reactiveworks.restiplexercise.matches.dao.factory.MatchesDAOFactory;
import com.reactiveworks.restiplexercise.model.Matches;
import com.reactiveworks.restiplexercise.resource.MatchesFilterBean;
import com.reactiveworks.restiplexercise.service.exception.DataNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.RequiredFieldNotFoundException;
import com.reactiveworks.restiplexercise.service.exception.ServiceException;

public class MatchesService {

	/**
	 * Logger Implementation
	 */
	private static final Logger LOGGER = Logger.getLogger(MatchesService.class);
	
	/**
	 * DAO instance to perform operations.
	 */
	IMatchesDAO matchesDAO = MatchesDAOFactory.getMatchesInstance();
	
	/**
	 * This method is used to get all the matches according to the filter passed.
	 * @param filter filter that is containing year and city.
	 * @return a list of required matches
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public List<Matches> getAllMatches(MatchesFilterBean filter) throws ServiceException {
		List<Matches> matches = null;
		int year = filter.getYear();
		String city = filter.getCity();
		try {
			if(year != 0) {
				List<Matches> matchForYear = matchesDAO.getMatchForYear(year);
				if(matchForYear.size()==0) {
					LOGGER.debug("Throwing DataNotFoundExp because no matches data for year :"+year);
					throw new DataNotFoundException("No matches data found for the year : "+year);
				}else {
					matches = matchForYear;
				}
			}
			else if(city != null) {
				List<Matches> matchForCity = matchesDAO.getMatchForCity(city);
				if(matchForCity.size()==0) {
					LOGGER.debug("Throwing DataNotFoundExp because no matches data for year :"+year);
					throw new DataNotFoundException("No matches data found for the city : "+city);
				}else {
					matches = matchForCity;
				}
			}
			else {
				List<Matches> allMatches = matchesDAO.getAllMatches();
				matches=allMatches;
			}
			return matches;
		}
		catch (DAOException dae) {
			LOGGER.error("Unable to get the matches data from the database.",dae);
			throw new ServiceException(dae);
		}
		catch (RuntimeException re) {
			LOGGER.error("Unable to get the matches data from the database.",re);
			throw new ServiceException(re);
		}

	}

	/**
	 * This method is used to get all the matches according to the matchId passed.
	 * @param matchId matchID for which the data has to be fetched.
	 * @return the matches that is containing the details.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public Matches getMatchForId(int matchId) throws ServiceException {
		try {
			Matches match = matchesDAO.getMatchForId(matchId);
			if(match == null) {
				throw new DataNotFoundException("No matches data found for the matchId : "+matchId);
			}
			return match;
		} catch (DAOException dae) {
			LOGGER.error("Unable to get the matches data from the database for matchId: "+matchId,dae);
			throw new ServiceException(dae);
		}
		catch (RuntimeException re) {
			LOGGER.error("Unable to get the matches data from the database for matchId: "+matchId,re);
			throw new ServiceException(re);
		}
	}

	/**
	 * A helper method to check if empty/null fields are passed when inserting to database.
	 * @param match an instance which is to be checked.
	 * @throws RequiredFieldNotFoundException if any null value is passed.
	 */
	private void nullCheckFor(Matches match) throws RequiredFieldNotFoundException {

		if(match.getSeason() ==0) {						
			throw new RequiredFieldNotFoundException("Match-Id value is required.");
		}
		if(match.getCity()==null || match.getCity().isEmpty() || match.getCity().equals("null")) {
			throw new RequiredFieldNotFoundException("City value is required.");
		}
		if(match.getDate()==null ) {
			throw new RequiredFieldNotFoundException("Date value is required.");
		}
		if(match.getFirstTeam()==null || match.getFirstTeam().isEmpty() || match.getFirstTeam().isEmpty()) {
			throw new RequiredFieldNotFoundException("First team value is required.");
		}
		if(match.getSecondTeam()==null || match.getSecondTeam().isEmpty() ||match.getSecondTeam().equals("null")) {
			throw new RequiredFieldNotFoundException("Second team value is required.");
		}
		if(match.getTossWinner()==null && match.getTossWinner().isEmpty() || match.getTossWinner().equals("null")) {
			throw new RequiredFieldNotFoundException("Toss winner value is required.");
		}
		if(match.getTossDecision()==null || match.getTossDecision().isEmpty() || match.getTossDecision().equals("null")) {
			throw new RequiredFieldNotFoundException("Toss Decision value is required.");
		}
		if(match.getResult()==null || match.getResult().isEmpty() ||match.getResult().equals("null")) {
			throw new RequiredFieldNotFoundException("Result value is required.");
		}
		if(match.getWinner()==null && match.getWinner().isEmpty() ||match.getResult().equals("null")) {
			throw new RequiredFieldNotFoundException("Winner value is required.");
		}
	}
	
	/**
	 * This method is used to insert the data into the database.
	 * @param match the match data which is to be inserted.
	 * @return number of rows affected.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public int insertMatch(Matches match) throws ServiceException {
		nullCheckFor(match);
		try {
			int rows = matchesDAO.insertMatch(match);
			return rows;
		} catch (DAOException dae) {
			LOGGER.error("Unable to insert data into the database.",dae);
			throw new ServiceException(dae);
		}catch (RuntimeException re) {
			LOGGER.error("Cannot perform insert operation into database.",re);
			throw new ServiceException(re);
		}
	}

	/**
	 * This method is used to update the matches according to the matchId passed.
	 * @param matchId the id which is to be updated.
	 * @param match the instance which is to be updated.
	 * @return the number of rows affected.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public int updateMatch(int matchId, Matches match) throws ServiceException {
		try {
			int rows = matchesDAO.updateMatch(matchId, match);
			if(rows==0) {
				throw new DataNotFoundException("You are trying to update an non-existing record. [matchId="+matchId+"]");
			}
			return rows;
		} catch (DAOException dae) {
			LOGGER.debug("Unable to update the data for matchId: "+matchId);
			throw new ServiceException(dae);
		}catch (RuntimeException re) {
			LOGGER.error("Cannot perform update operation into database for matchId: "+matchId,re);
			throw new ServiceException(re);
		}
	}

	/**
	 * This method is used to delete the matches according to the matchId passed.
	 * @param matchId the id which is to be deleted.
	 * @return the number of rows affected.
	 * @throws ServiceException if any error occurs when performing the operation.
	 */
	public int deleteMatch(int matchId) throws ServiceException {
		try {
			int rows = matchesDAO.deleteMatch(matchId);
			if(rows==0) {
				throw new DataNotFoundException("You are trying to delete an non-existing record. [matchId="+matchId+"]");
			}
			return rows;
		} catch (DAOException dae) {
			LOGGER.debug("Unable to delete the data for matchId: "+matchId);
			throw new ServiceException(dae);
		}
		catch (RuntimeException re) {
			LOGGER.error("Cannot perform delete operation into database for matchId: "+matchId,re);
			throw new ServiceException(re);
		}
	}

	
	
}
