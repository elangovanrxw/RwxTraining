package com.reactiveworks.restiplexercise.deliveries.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.reactiveworks.restiplexercise.dao.exception.DatabaseDAOException;
import com.reactiveworks.restiplexercise.db.DBUtils;
import com.reactiveworks.restiplexercise.deliveries.dao.IDeliveriesDAO;
import com.reactiveworks.restiplexercise.model.Deliveries;

/**
 * An implementation class for the {@link IDeliveriesDAO} which deals with 
 * the database operations.
 * @author Elangovan
 *
 */
public class DeliveriesDAOSQLImpl implements IDeliveriesDAO {

	/**
	 * Logger Implementation.
	 */
	private static final Logger LOGGER = Logger.getLogger(DeliveriesDAOSQLImpl.class);
	
	public static final String SELECT_QUERY = "SELECT MATCH_ID,INNING,BATTING_TEAM,BOWLING_TEAM,OVER,BALL,BATSMAN,BOWLER,WIDE_RUNS,BYE_RUNS,LEGBYE_RUNS,NOBALL_RUNS,PENALTY_RUNS,BATSMAN_RUNS,EXTRA_RUNS,TOTAL_RUNS FROM DELIVERIES";
	
	public static final String SELECT_FOR_MATCH_ID =SELECT_QUERY+" WHERE MATCH_ID=?";

	/**
	 * This method is used to get all the deliveries data from the database.
	 * @throws DatabaseDAOException if any operations in the database fails.
	 * @return a list that contains all the deliveries data.
	 */
	@Override
	public List<Deliveries> getAllDeliveries() throws DatabaseDAOException {
	
//		Deliveries deliveries = new Deliveries();
		List<Deliveries> deliveriesList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(SELECT_QUERY);
			resultSet = pstmt.executeQuery();

			while(resultSet.next()) {
				Deliveries deliveries = new Deliveries();
				deliveries.setMatchId(resultSet.getInt(1));
				deliveries.setInning(resultSet.getInt(2));
				deliveries.setBattingTeam(resultSet.getString(3));
				deliveries.setBowlingTeam(resultSet.getString(4));
				deliveries.setOver(resultSet.getInt(5));
				deliveries.setBall(resultSet.getInt(6));
				deliveries.setBatsman(resultSet.getString(7));
				deliveries.setBowler(resultSet.getString(8));
				deliveries.setWideRuns(resultSet.getInt(9));
				deliveries.setByeRuns(resultSet.getInt(10));
				deliveries.setLegbyeRuns(resultSet.getInt(11));
				deliveries.setNoballRuns(resultSet.getInt(12));
				deliveries.setPenaltyRuns(resultSet.getInt(13));
				deliveries.setBatsmanRuns(resultSet.getInt(14));
				deliveries.setExtraRuns(resultSet.getInt(15));
				deliveries.setTotalRuns(resultSet.getInt(16));
				deliveriesList.add(deliveries);
			}
			return deliveriesList;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to get all the deliveries.",sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("Unable to get all the deliveries.",e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, resultSet);
		}
		
	}
	
	/**
	 * This method is used to get all the deliveries data from the database for the given matchid.
	 * @param matchId the deliveries data has to be fetched for this match id.
	 * @throws DatabaseDAOException if any operations in the database fails.
	 * @return a list that contains all the deliveries data.
	 */
	@Override
	public List<Deliveries> getDeliveryForMatchId(int matchId) throws DatabaseDAOException {
		
		
		List<Deliveries> deliveriesList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DBUtils.getDBConnection();
			pstmt = con.prepareStatement(SELECT_FOR_MATCH_ID);
			pstmt.setInt(1, matchId);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				Deliveries deliveries = new Deliveries();
				deliveries.setMatchId(resultSet.getInt(1));
				deliveries.setInning(resultSet.getInt(2));
				deliveries.setBattingTeam(resultSet.getString(3));
				deliveries.setBowlingTeam(resultSet.getString(4));
				deliveries.setOver(resultSet.getInt(5));
				deliveries.setBall(resultSet.getInt(6));
				deliveries.setBatsman(resultSet.getString(7));
				deliveries.setBowler(resultSet.getString(8));
				deliveries.setWideRuns(resultSet.getInt(9));
				deliveries.setByeRuns(resultSet.getInt(10));
				deliveries.setLegbyeRuns(resultSet.getInt(11));
				deliveries.setNoballRuns(resultSet.getInt(12));
				deliveries.setPenaltyRuns(resultSet.getInt(13));
				deliveries.setBatsmanRuns(resultSet.getInt(14));
				deliveries.setExtraRuns(resultSet.getInt(15));
				deliveries.setTotalRuns(resultSet.getInt(16));
				deliveriesList.add(deliveries);
			}
			return deliveriesList;
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Unable to get deliveries for matchId "+matchId,sqlExp);
			throw new DatabaseDAOException(sqlExp);
		}
		catch (Exception e) {
			LOGGER.error("Unable to get deliveries for matchId "+matchId,e);
			throw new DatabaseDAOException(e);
		}
		finally {
			DBUtils.closeResources(con, pstmt, resultSet);
		}
	}

	
}
