package com.reactiveworks.stocktrade.dao.impl;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.OperationNotSupportedException;
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

	private static final String TRUNCATE_QUERY = "TRUNCATE TABLE "+TABLE_NAME;
	/**
	 * A helper method to create the preparedStatement.
	 * @param con Connection to which preparestatement is to be created.
	 * @param query query to prepare.
	 * @return PrepareStatement object 
	 * @throws DatabaseOperationFailureException if it is not able to create the prepared Statement.
	 */
	private PreparedStatement createPreparedStatement(Connection con, String query) throws DatabaseOperationFailureException {
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
	 * Reads the entire database and convert it to a {@link List} 
	 * @return the list of database's business object entries.
	 * @throws DatabaseOperationFailureException 
	 * @throws DatabaseAccessFailureException 
	 */
	@Override
	public List<StockTrade> getAllStockTrades() throws DatabaseOperationFailureException, DatabaseAccessFailureException {
		
		LOGGER.debug("Reading database data as List");
		Connection con = DBUtils.getDBConnection();
		ResultSet rSet=null;
		PreparedStatement pstmt = createPreparedStatement(con, READ_QUERY);
		try {
			rSet = pstmt.executeQuery();		
			StockTrade trade;
			List<StockTrade> list = new ArrayList<StockTrade>();
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
			LOGGER.error("Exception occured during reading as list : ",sqlExp);
			throw new DatabaseOperationFailureException("Exception occured during reading as list : ",sqlExp);
		}
		finally {
			DBUtils.closeResources(con, pstmt);
		}
	}

	/**
	 * This function is used to insert a StockTrade object into the database.
	 * @param StockTrade object which is to be inserted.
	 * @throws DatabaseOperationFailureException if performing any operation in database is failure.
	 * @throws DatabaseAccessFailureException if acccessing any resource in database is failure.
	 * @throws OperationNotSupportedException in case the operation is not supported.
	 */
	@Override
	public int insertStockTrade(StockTrade trade) throws OperationNotSupportedException, DatabaseAccessFailureException, DatabaseOperationFailureException {
	//	LOGGER.debug("Writing data into database..."+trade);
		Connection con = DBUtils.getDBConnection();		
		PreparedStatement pstmt = createPreparedStatement(con, INSERT_QUERY);
		try {
			pstmt.setString(1, trade.getSecurity());
			pstmt.setDate(2, trade.getDate());
			pstmt.setDouble(3, trade.getOpen());
			pstmt.setDouble(4, trade.getHigh());
			pstmt.setDouble(5, trade.getLow());
			pstmt.setDouble(6, trade.getClose());
			pstmt.setDouble(7, trade.getVolume());
			pstmt.setDouble(8, trade.getAdjClose());		
			int rows = pstmt.executeUpdate();
			LOGGER.debug("Row inserted..."+trade);
			return rows;
		}
		catch(SQLException sqlExp) {
			LOGGER.error("Exception occured when inserting data : ",sqlExp);
			throw new DatabaseOperationFailureException("Exception occured when inserting data : ",sqlExp);
		}
		finally {
			DBUtils.closeResources(con, pstmt);
		}
		
	}
   
	/**
	 * This function is used to truncate the entire table.
	 * @throws DatabaseOperationFailureException if performing any operation in database is failure.
	 * @throws DatabaseAccessFailureException if acccessing any resource in database is failure.
	 */
	public void cleanUp() throws DatabaseAccessFailureException, DatabaseOperationFailureException {
		LOGGER.debug("Truncating table : "+TABLE_NAME);
		Connection con = DBUtils.getDBConnection();		
		PreparedStatement pstmt = createPreparedStatement(con, TRUNCATE_QUERY);
		try {
			pstmt.executeUpdate();
		}
		catch (SQLException sqlExp) {
			LOGGER.error("Exception occured when truncating table : ",sqlExp);
			throw new DatabaseOperationFailureException("Exception occured when truncating table : ",sqlExp);
		}
	}
}
