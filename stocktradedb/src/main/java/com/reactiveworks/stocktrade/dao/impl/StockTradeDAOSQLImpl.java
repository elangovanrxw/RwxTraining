package com.reactiveworks.stocktrade.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.db.DBUtils;
import com.reactiveworks.stocktrade.db.exception.DatabaseAccessFailureException;
import com.reactiveworks.stocktrade.db.exception.DatabaseOperationFailureException;
import com.reactiveworks.stocktrade.pojo.StockTrade;

/**
 * An implementation of the DAO interface to perform Database Operations.
 * @author Elangovan
 *
 */
public class StockTradeDAOSQLImpl  implements IStockTradeDAO {
	
	private static final Logger LOGGER = Logger.getLogger(StockTradeDAOSQLImpl.class);
	
	private static final String TABLE_NAME = "STOCKTRADE";
	
	private static final String INSERT_QUERY = "INSERT INTO "+TABLE_NAME+" (SECURITY,DATE_OPENED,OPEN,HIGH,LOW,CLOSE,VOLUME,ADJCLOSE) VALUES "+
													"(?,?,?,?,?,?,?,?)";
	private static final String READ_QUERY = "SELECT TRADE_ID,SECURITY,DATE_OPENED,OPEN,HIGH,LOW,CLOSE,VOLUME,ADJCLOSE FROM "+TABLE_NAME;
	
	private static final String READ_BY_ID = READ_QUERY+" WHERE TRADE_ID = ?";
	
	private static final String UPDATE_QUERY = "UPDATE "+TABLE_NAME+" SET SECURITY=? WHERE TRADE_ID=?";
	
	private static final String DELETE_QUERY = "DELETE FROM "+TABLE_NAME+" WHERE TRADE_ID=?";

	
	/**
	 * A helper method to create the preparedStatement.
	 * @param con Connection to which preparestatement is to be created.
	 * @param query query to prepare.
	 * @return PrepareStatement object 
	 * @throws DatabaseOperationFailureException if it is not able to create the prepared Statement.
	 */
	private static PreparedStatement createPreparedStatement(Connection con, String query) throws DatabaseOperationFailureException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			return pstmt;
		} catch (SQLException sqlExp) {
			LOGGER.error("Cannot create Prepared statement.",sqlExp);
			throw new DatabaseOperationFailureException("Cannot create Prepared statement.",sqlExp);
		}
	}
	
	/**
	 * Insert data business object into the database
	 * @param stockTrade business object with specified details
	 * @throws DatabaseOperationFailureException 
	 * @throws DatabaseAccessFailureException 
	 */
	@Override
	public int insert(StockTrade stockTrade) throws DatabaseOperationFailureException, DatabaseAccessFailureException {

		LOGGER.debug("Inserting data : "+stockTrade);
		Connection con = DBUtils.getDBConnection();
	
		PreparedStatement pstmt = createPreparedStatement(con, INSERT_QUERY);
		try {
			pstmt.setString(1, stockTrade.getSecurity());
			pstmt.setDate(2, stockTrade.getDate());
			pstmt.setDouble(3, stockTrade.getOpen());
			pstmt.setDouble(4, stockTrade.getHigh());
			pstmt.setDouble(5, stockTrade.getLow());
			pstmt.setDouble(6, stockTrade.getClose());
			pstmt.setDouble(7, stockTrade.getVolume());
			pstmt.setDouble(8, stockTrade.getAdjClose());
			int rows = pstmt.executeUpdate();
			return rows;

		} catch (SQLException sqlExp) {
			LOGGER.error("Cannot add data to database.",sqlExp);
			throw new DatabaseOperationFailureException("Cannot add data to database.",sqlExp);
		}
		finally {
			DBUtils.closeResources(con, pstmt, null);
		}
	}
	
	/**
	 * Read the specific row by passing the value of date.
	 * @param date date value for which other values are to be fetched.
	 * @throws DatabaseOperationFailureException 
	 * @throws DatabaseAccessFailureException 
	 */
	@Override
	public StockTrade readById(int tradeId) throws DatabaseOperationFailureException, DatabaseAccessFailureException {
			
		LOGGER.debug("Reading DB for trade ID "+tradeId);
		Connection con = DBUtils.getDBConnection();
		ResultSet rSet=  null;
			StockTrade trade = new StockTrade();
			PreparedStatement pstmt = createPreparedStatement(con,READ_BY_ID);
			try {
				pstmt.setInt(1, tradeId);
				rSet = pstmt.executeQuery();
				while(rSet.next())
				{
					trade.setSecurity(rSet.getString("security"));
					trade.setDate(rSet.getDate("date_opened"));
					trade.setOpen(rSet.getDouble("open"));
					trade.setHigh(rSet.getDouble("high"));
					trade.setLow(rSet.getDouble("low"));
					trade.setClose(rSet.getDouble("close"));
					trade.setVolume(rSet.getDouble("volume"));
					trade.setAdjClose(rSet.getDouble("adjClose"));
				}
				return trade;
			} catch (SQLException sqlExp) {
				LOGGER.error("Cannot execute the query.",sqlExp);
				throw new DatabaseOperationFailureException("Cannot execute the query.",sqlExp);
			}
			finally {
				DBUtils.closeResources(con, pstmt, rSet);
			}
			
	}

	/**
	 * Update the security by passing the value of date.
	 * @param date date value for which the security is going to update.
	 * @throws DatabaseOperationFailureException 
	 * @throws DatabaseAccessFailureException 
	 */
	@Override
	public int update(int tradeId,String security) throws DatabaseOperationFailureException, DatabaseAccessFailureException {

		LOGGER.debug("Updating security for tradeId: "+tradeId);
		Connection con = DBUtils.getDBConnection();
	
		PreparedStatement pstmt = createPreparedStatement(con,UPDATE_QUERY);
		
		try {
			pstmt.setString(1,security);
			pstmt.setInt(2, tradeId);
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (SQLException sqlExp) {
			LOGGER.error("Cannot execute the query.",sqlExp);
			throw new DatabaseOperationFailureException("Cannot execute the query.",sqlExp);
		}
		finally {
			DBUtils.closeResources(con, pstmt, null);
		}
		
	}

	/**
	 * Delete the entire row taking date as a condition.
	 * @param date date value for which the row is going to delete.
	 * @throws DatabaseAccessFailureException 
	 * @throws DatabaseOperationFailureException 
	 */
	@Override
	public int deleteById(int tradeId) throws DatabaseAccessFailureException, DatabaseOperationFailureException {

		LOGGER.debug("Deleting entry for tradeId :"+tradeId);
		Connection con = DBUtils.getDBConnection();

		PreparedStatement pstmt = createPreparedStatement(con, DELETE_QUERY);
		try {
			pstmt.setInt(1, tradeId);
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (SQLException sqlExp) {
			LOGGER.error("Cannot execute the query.",sqlExp);
			throw new DatabaseOperationFailureException("Cannot execute the query.",sqlExp);
		}
		finally {
			DBUtils.closeResources(con, pstmt, null);
		}
	}

	/**
	 * Reads the entire database and convert it to a {@link List} 
	 * @return the list of database's business object entries.
	 * @throws DatabaseOperationFailureException 
	 * @throws DatabaseAccessFailureException 
	 */
	@Override
	public List<StockTrade> readAsList() throws DatabaseOperationFailureException, DatabaseAccessFailureException {
		
		LOGGER.debug("Reading database data as List");
		Connection con = DBUtils.getDBConnection();
		LOGGER.debug("Connection info : "+con);
		PreparedStatement pstmt = createPreparedStatement(con, READ_QUERY);
		ResultSet rSet = null;
		try {
			rSet = pstmt.executeQuery();
		}
		catch(SQLException sqlExp) {
			LOGGER.error("Cannot execute the given query.",sqlExp);
			throw new DatabaseOperationFailureException("Cannot execute the given query.",sqlExp);
		}
		StockTrade trade;
		List<StockTrade> list = new ArrayList<StockTrade>();
		try
		{
			while(rSet.next())
			{
				trade = new StockTrade();
				trade.setSecurity(rSet.getString("security"));
				trade.setDate(rSet.getDate("date_opened"));
				trade.setOpen(rSet.getDouble("open"));
				trade.setHigh(rSet.getDouble("high"));
				trade.setLow(rSet.getDouble("low"));
				trade.setClose(rSet.getDouble("close"));
				trade.setVolume(rSet.getDouble("volume"));
				trade.setAdjClose(rSet.getDouble("adjClose"));
				list.add(trade);
			}
			return list;
		}
		catch(SQLException sqlExp) {
			LOGGER.error("Cannot read data from Resultset created for table : "+TABLE_NAME,sqlExp);
			throw new DatabaseOperationFailureException("Cannot read data from Resultset created for table : "+TABLE_NAME,sqlExp);
		}
		finally {
			DBUtils.closeResources(con, pstmt, rSet);
		}
	}

}
