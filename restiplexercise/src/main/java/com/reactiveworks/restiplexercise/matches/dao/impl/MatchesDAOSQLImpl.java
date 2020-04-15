package com.reactiveworks.restiplexercise.matches.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.dao.exception.DAOException;
import com.reactiveworks.restiplexercise.dao.exception.DatabaseDAOException;
import com.reactiveworks.restiplexercise.db.DBUtils;
import com.reactiveworks.restiplexercise.matches.dao.IMatchesDAO;
import com.reactiveworks.restiplexercise.model.Matches;

/**
 * An implementation class which performs the database related operations.
 * @author Elangovan
 *
 */
public class MatchesDAOSQLImpl implements IMatchesDAO {

	/**
	 * Logger Implementation
	 */
	private static final Logger LOGGER = Logger.getLogger(MatchesDAOSQLImpl.class);

	private static final String SELECT_QUERY = "SELECT MATCH_ID,SEASON,CITY,DATE,TEAM1,TEAM2,TOSS_WINNER,TOSS_DECISION,RESULT,WINNER FROM MATCHES";
	
	private static final String INSERT_QUERY = "INSERT INTO MATCHES2 VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_QUERY_MATCHID = SELECT_QUERY+" WHERE MATCH_ID=?";
	
	private static final String SELECT_QUERY_YEAR = SELECT_QUERY+" WHERE SEASON=?";
	
	private static final String SELECT_QUERY_CITY = SELECT_QUERY+" WHERE CITY=?";
	
	private static final String DELETE_QUERY = "DELETE FROM MATCHES2 WHERE MATCH_ID=?";
	
	
	/**
	 * This method is used to get all the matches data from the mysql database.
	 * @throws DatabaseDAOException if any operation performing in the database leads to failure.
	 * @return a list of all the matches data.
	 */
	@Override
	public List<Matches> getAllMatches() throws DatabaseDAOException {

//		Matches match = new Matches();
		List<Matches> matchesList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(SELECT_QUERY);
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				Matches match = new Matches();
				match.setMatchId(resultSet.getInt(1));
				match.setSeason(resultSet.getInt(2));
				match.setCity(resultSet.getString(3));
				match.setDate(resultSet.getDate(4).toLocalDate());
				match.setFirstTeam(resultSet.getString(5));
				match.setSecondTeam(resultSet.getString(6));
				match.setTossWinner(resultSet.getString(7));
				match.setTossDecision(resultSet.getString(8));
				match.setResult(resultSet.getString(9));
				match.setWinner(resultSet.getString(10));

				matchesList.add(match);
			}
			return matchesList;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to get all the matches.",sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("Unable to get all the matches.",e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, resultSet);
		}
	}

	/**
	 * This method is used to update the matches data to the mysql database.
	 * @throws DatabaseDAOException if any operation performing in the database leads to failure.
	 * @return number of rows affected.
	 */
	@Override
	public int updateMatch(int matchId,Matches match) throws DatabaseDAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(getUpdateQuery(match));
			Object[] updatingFieldValues = getUpdatingFieldValues(matchId,match);
			for(int i=0;i<updatingFieldValues.length;i++) {
				pstmt.setObject(i+1, updatingFieldValues[i]);
			}
			int rows = pstmt.executeUpdate();
			con.commit();
			return rows;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("UPDATE operation to database is failed, because: "+sqlExp.getMessage(),sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("UPDATE operation to database is failed, because: "+e.getMessage(),e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, null);
		}
	}

	/**
	 * A private helper method which creates the update query fromm the {@link Matches} instance
	 * i.e., The fields to be updated.
	 * @param match instance of {@link Matches}
	 * @return the update query in string.
	 * @throws DatabaseDAOException if the instance do not contains any fields to update.
	 */
	private String getUpdateQuery(Matches match) throws DatabaseDAOException {
		//MATCH_ID,SEASON,CITY,DATE,TEAM1,TEAM2,TOSS_WINNER,TOSS_DECISION,RESULT,WINNER
		String fields ="";
		boolean containsAtleastOneField = false;
		
		if(match.getSeason() !=0) {						
			containsAtleastOneField=true;
			fields+="SEASON=?,";
		}
		if(match.getCity()!=null && !match.getCity().isEmpty()) {
			containsAtleastOneField=true;
			fields+="CITY=?,";
		}
		if(match.getDate()!=null) {
			containsAtleastOneField=true;
			fields+="DATE=?,";
		}
		if(match.getFirstTeam()!=null && !match.getFirstTeam().isEmpty()) {
			containsAtleastOneField=true;
			fields+="TEAM1=?,";
		}
		if(match.getSecondTeam()!=null && !match.getSecondTeam().isEmpty()) {
			containsAtleastOneField=true;
			fields+="TEAM2=?,";
		}
		if(match.getTossWinner()!=null && !match.getTossWinner().isEmpty()) {
			containsAtleastOneField=true;
			fields+="TOSS_WINNER=?,";
		}
		if(match.getTossDecision()!=null && !match.getTossDecision().isEmpty()) {
			containsAtleastOneField=true;
			fields+="TOSS_DECISION=?,";
		}
		if(match.getResult()!=null && !match.getResult().isEmpty()) {
			containsAtleastOneField=true;
			fields+="RESULT=?,";
		}
		if(match.getWinner()!=null && !match.getWinner().isEmpty()) {
			containsAtleastOneField=true;
			fields+="WINNER=?,";
		}
		if(containsAtleastOneField) {
			fields = fields.substring(0, fields.length()-1);		//To ignore the last ',' character.
		}
		else {
			LOGGER.error("Minimum one field value is required for Update Functionality");
			throw new DatabaseDAOException("Minimum one field value is required for Update Functionality");
		}
		String updateQuery = "UPDATE MATCHES2 SET "+fields+" WHERE MATCH_ID=?";
		LOGGER.debug("Gen Query : "+updateQuery);
		return updateQuery;
	}

	/**
	 * A private helper method which examines what are all the values inside the instance is present.
	 * @param match instance of {@link Matches} to be examined.
	 * @return an object array that contains the values to update into the database.
	 */
	private Object[] getUpdatingFieldValues(int matchId,Matches match) {
		
		List<Object> values = new ArrayList<>();
		if(match.getSeason() !=0) {
			values.add(match.getSeason());
		}
		if(match.getCity()!=null && !match.getCity().isEmpty()) {
			values.add(match.getCity());
		}
		if(match.getDate()!=null) {
			values.add(match.getDate());
		}
		if(match.getFirstTeam()!=null && !match.getFirstTeam().isEmpty()) {
			values.add(match.getFirstTeam());
		}
		if(match.getSecondTeam()!=null && !match.getSecondTeam().isEmpty()) {
			values.add(match.getSecondTeam());
		}
		if(match.getTossWinner()!=null && !match.getTossWinner().isEmpty()) {
			values.add(match.getTossWinner());
		}
		if(match.getTossDecision()!=null && !match.getTossDecision().isEmpty()) {
			values.add(match.getTossDecision());
		}
		if(match.getResult()!=null && !match.getResult().isEmpty()) {
			values.add(match.getResult());
		}
		if(match.getWinner()!=null && !match.getWinner().isEmpty()) {
			values.add(match.getWinner());
		}
		values.add(matchId);
		
		return values.toArray();
	}
	
	/**
	 * This method is used to delete a particular match data from the database.
	 * @param matchId the match that needs to be deleted.
	 * @return number of rows affected.
	 */
	@Override
	public int deleteMatch(int matchId) throws DatabaseDAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, matchId);
			int rows = pstmt.executeUpdate();
			con.commit();
			return rows;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to delete the match for matchId : "+matchId,sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch(Exception e) {
			LOGGER.error("Unable to delete the match for matchId : "+matchId,e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, null);
		}
	}

	/**
	 * This method is used to get all the matches data from the mysql database.
	 * @param matchId The match id for that match has to be fetched.
	 * @throws DatabaseDAOException if any operation performing in the database leads to failure.
	 * @return the required match for the match id.
	 */
	@Override
	public Matches getMatchForId(int matchId) throws DatabaseDAOException {
		Matches match = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(SELECT_QUERY_MATCHID);
			pstmt.setInt(1, matchId);
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				match = new Matches();
				match.setMatchId(resultSet.getInt(1));
				match.setSeason(resultSet.getInt(2));
				match.setCity(resultSet.getString(3));
				match.setDate(resultSet.getDate(4).toLocalDate());
				match.setFirstTeam(resultSet.getString(5));
				match.setSecondTeam(resultSet.getString(6));
				match.setTossWinner(resultSet.getString(7));
				match.setTossDecision(resultSet.getString(8));
				match.setResult(resultSet.getString(9));
				match.setWinner(resultSet.getString(10));
			}
			return match;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to get match details for matchid "+matchId,sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("Unable to get match details for matchid "+matchId,e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, resultSet);
		}
	}

	/**
	 * This method is used to insert the match data into the database.
	 * @param match the {@link Matches} instance that needs to be inserted into the database.
	 * @return the number of rows affected.
	 * @throws SQLException 
	 */
	@Override
	public int insertMatch(Matches match) throws DatabaseDAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(INSERT_QUERY);
			pstmt.setInt(1, match.getMatchId());
			pstmt.setInt(2, match.getSeason());
			pstmt.setString(3, match.getCity());
			pstmt.setDate(4, Date.valueOf(match.getDate()));
			pstmt.setString(5, match.getFirstTeam());
			pstmt.setString(6, match.getSecondTeam());
			pstmt.setString(7, match.getTossWinner());
			pstmt.setString(8, match.getTossDecision());
			pstmt.setString(9, match.getResult());
			pstmt.setString(10, match.getWinner());
			
			int rows = pstmt.executeUpdate();

			con.commit();
			return rows;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to insert the data into database.",sqlExp);
			throw new DatabaseDAOException(sqlExp);
			
		}
		catch (Exception e) {
			LOGGER.error("Unable to insert the data into database.",e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, null);
		}
	}

	@Override
	public List<Matches> getMatchForYear(int year) throws DAOException {
		
		List<Matches> matchesForYear = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(SELECT_QUERY_YEAR);
			pstmt.setInt(1, year);
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				Matches match = new Matches();
				match.setMatchId(resultSet.getInt(1));
				match.setSeason(resultSet.getInt(2));
				match.setCity(resultSet.getString(3));
				match.setDate(resultSet.getDate(4).toLocalDate());
				match.setFirstTeam(resultSet.getString(5));
				match.setSecondTeam(resultSet.getString(6));
				match.setTossWinner(resultSet.getString(7));
				match.setTossDecision(resultSet.getString(8));
				match.setResult(resultSet.getString(9));
				match.setWinner(resultSet.getString(10));
				matchesForYear.add(match);
			}
			return matchesForYear;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to get match details for YEAR "+year,sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("Unable to get match details for YEAR "+year,e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, resultSet);
		}

	}

	@Override
	public List<Matches> getMatchForCity(String city) throws DAOException {
		List<Matches> matchesForCity = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(SELECT_QUERY_CITY);
			pstmt.setString(1, city);
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				Matches match = new Matches();
				match.setMatchId(resultSet.getInt(1));
				match.setSeason(resultSet.getInt(2));
				match.setCity(resultSet.getString(3));
				match.setDate(resultSet.getDate(4).toLocalDate());
				match.setFirstTeam(resultSet.getString(5));
				match.setSecondTeam(resultSet.getString(6));
				match.setTossWinner(resultSet.getString(7));
				match.setTossDecision(resultSet.getString(8));
				match.setResult(resultSet.getString(9));
				match.setWinner(resultSet.getString(10));
				matchesForCity.add(match);
			}
			return matchesForCity;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to get match details for city "+city,sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("Unable to get match details for city "+city,e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, resultSet);
		}
	}
}
