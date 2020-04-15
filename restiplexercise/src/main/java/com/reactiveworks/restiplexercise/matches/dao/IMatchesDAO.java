package com.reactiveworks.restiplexercise.matches.dao;

import java.util.List;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.model.Matches;

/**
 * An interface which is containing the structure of matches DAO functions
 * that is to be performed on the data source.
 * @author Elangovan
 *
 */
public interface IMatchesDAO {

	/**
	 * This method is used to read the data from the datasource and convert that
	 * data into the form of List.
	 * @return a list of all matches for all match id.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	List<Matches> getAllMatches() throws DAOException;
	
	/**
	 * Used to update matches data into the datasource.
	 * @param match matches data to be updated.
	 * @return a count of number of rows affected.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	int updateMatch(int matchId,Matches match) throws DAOException;
	
	/**
	 * Used to delete matches data from the datasource.
	 * @param matchId matches data to be deleted for the given matchId.
	 * @return a count of nuumber of rows affected.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	int deleteMatch(int matchId) throws DAOException;
	
	/**
	 * Used to delete matches data from the datasource.
	 * @param matchId matches data to be fetched for the given matchId.
	 * @return a match for the given match id.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	Matches getMatchForId(int matchId) throws DAOException;
	
	/**
	 * Used to delete matches data from the datasource.
	 * @param year matches data to be fetched for the given year.
	 * @return a match for the given match id.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	List<Matches> getMatchForYear(int year) throws DAOException;
	
	/**
	 * Used to delete matches data from the datasource.
	 * @param city matches data to be fetched for the given city.
	 * @return a match for the given match id.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	List<Matches> getMatchForCity(String city) throws DAOException;
	/**
	 * Used to insert matches data into the datasource.
	 * @param match matches data to be inserted.
	 * @return a count of nuumber of rows affected.
	 * @throws DAOException if any exception occurs when performing DAO Operations.
	 */
	int insertMatch(Matches match) throws DAOException;
}
