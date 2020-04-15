package com.reactiveworks.stocktrade.dao.impl;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.StockTradeDAODatabaseException;
import com.reactiveworks.stocktrade.pojo.StockTrade;
import com.reactiveworks.stocktrade.spring.mapper.StockTradeRowMapper;

/**
 * An implementation of the DAO interface to perform Database Operations.
 * @author Elangovan
 *
 */
public class StockTradeDAOSQLImpl  implements IStockTradeDAO {
	
	private JdbcTemplate jdbcTemplate;
		
	private static final Logger LOGGER = Logger.getLogger(StockTradeDAOSQLImpl.class);
	
	private static final String TABLE_NAME = "STOCKTRADE";
	
	private static final String INSERT_QUERY = "INSERT INTO "+TABLE_NAME+" (TRADE_ID,SECURITY,DATE_OPENED,OPEN,HIGH,LOW,CLOSE,VOLUME,ADJCLOSE) VALUES "+
													"(?,?,?,?,?,?,?,?,?)";
	private static final String READ_QUERY = "SELECT TRADE_ID,SECURITY,DATE_OPENED,OPEN,HIGH,LOW,CLOSE,VOLUME,ADJCLOSE FROM "+TABLE_NAME;
	
	private static final String READ_BY_ID = READ_QUERY+" WHERE TRADE_ID = ?";
	
	private static final String UPDATE_QUERY = "UPDATE "+TABLE_NAME+" SET SECURITY=? WHERE TRADE_ID=?";
	
	private static final String DELETE_QUERY = "DELETE FROM "+TABLE_NAME+" WHERE TRADE_ID=?";

	private static final String TRUNCATE_QUERY = "TRUNCATE TABLE "+TABLE_NAME;
	
	/**
	 * Constructor injection for Spring to initialize the jdbcTemplate instance
	 * that is required to perform the database operations.
	 * @param jdbcTemplate the jdbcTemplate that is to be injected.
	 */
	public StockTradeDAOSQLImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public StockTradeDAOSQLImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Insert data business object into the SQL database.
	 * @param stockTrade business object with specified details
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public int insertStockTrade (StockTrade stockTrade) throws StockTradeDAODatabaseException {
		
		LOGGER.debug("Inserting data: " +stockTrade);
		LOGGER.debug("Transaction Active for insertStockTrade() : "+TransactionSynchronizationManager.isActualTransactionActive());
		try {
			int rows  = jdbcTemplate.update(INSERT_QUERY,stockTrade.getTradeId(), stockTrade.getSecurity(),stockTrade.getDate(), stockTrade.getOpen(),
							stockTrade.getHigh(),stockTrade.getLow(),stockTrade.getClose(),stockTrade.getVolume(),stockTrade.getAdjClose());
			LOGGER.info("Inserted an entry into database.");
			return rows;

		}catch (DataAccessException dae) {
			LOGGER.error("Unable to insert this data into database : "+stockTrade,dae);
			throw new StockTradeDAODatabaseException("Unable to insert this data into database : "+stockTrade,dae);
		}catch (Exception e) {
			LOGGER.error("Exception occured when inserting data : "+stockTrade,e);
			throw new StockTradeDAODatabaseException("Exception occured when inserting data : "+stockTrade,e);
		}
			
	}
	
	/**
	 * Read the specific row from SQL database by passing the value of date.
	 * @param tradeId tradeId value for which other values are to be fetched.
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public StockTrade getStockTradeById(int tradeId) throws StockTradeDAODatabaseException {
			
		if(tradeId==0) {
			LOGGER.warn("The database might not contain an entry with tradeId '0' .");
		}
		else {
			LOGGER.debug("Reading DB for trade ID "+tradeId);
		}
		LOGGER.debug("Transaction Active for getStockTradeById() : "+TransactionSynchronizationManager.isActualTransactionActive());
		try {
			StockTrade trade = jdbcTemplate.query(READ_BY_ID, new StockTradeRowMapper(), tradeId).get(0);
			return trade;
		}catch (DataAccessException dae) {
			LOGGER.error("Unable to retrieve data from the database for tradeId : "+tradeId,dae);
			throw new StockTradeDAODatabaseException("Unable to retrieve data from the database for tradeId : "+tradeId, dae);
		}
		catch (Exception e) {
			LOGGER.error("Exception occured when getting data for : "+tradeId,e);
			throw new StockTradeDAODatabaseException("Exception occured when getting data for : "+tradeId,e);
		}
	}

	/**
	 * Update the security in SQL database by passing the value of date.
	 * @param tradeId tradeId value for which the security is going to update.
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public int updateStockTradeSecurity(int tradeId,String security) throws StockTradeDAODatabaseException {

		if(security==null) { 
			LOGGER.warn("Null entry might be updated in the database for security to tradeid "+tradeId);
		}
		LOGGER.debug("Transaction Active for updateStockTradeSecurity() : "+TransactionSynchronizationManager.isActualTransactionActive());
		LOGGER.debug("Updating security for tradeId: "+tradeId);
		try {
			int rows = jdbcTemplate.update(UPDATE_QUERY, security,tradeId);
			return rows;
		//	throw new RuntimeException();
		}catch(DataAccessException dae) {
			LOGGER.error("Unable to update the security '"+security+"' for tradeId '"+tradeId+"'",dae);
			throw new StockTradeDAODatabaseException("Unable to update the security '"+security+"' for tradeId '"+tradeId+"'",dae);
		}catch (Exception e) {
			LOGGER.error("Exception occured when updating stocktrade security for : "+tradeId,e);
			throw new StockTradeDAODatabaseException("Exception occured when updating stocktrade security for : "+tradeId,e);
		}
	}

	/**
	 * Delete the entire row from the SQL database for given tradeId.
	 * @param tradeId tradeId value for which the row is going to delete.
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public int deleteStockTradeById(int tradeId) throws StockTradeDAODatabaseException {

		LOGGER.debug("Transaction Active for deleteStockTradeById() : "+TransactionSynchronizationManager.isActualTransactionActive());
		LOGGER.debug("Deleting entry for tradeId :"+tradeId);
		try {
			int rows = jdbcTemplate.update(DELETE_QUERY, tradeId);
			LOGGER.info("Entry deleted for tradeId: "+tradeId);
			return rows;
	//		throw new RuntimeException();
		}catch(DataAccessException dae) {
			LOGGER.error("Unable to delete data from the database for tradeId : "+tradeId,dae);
			throw new StockTradeDAODatabaseException("Unable to delete data from the database for tradeId : "+tradeId,dae);
		}catch (Exception e) {
			LOGGER.error("Exception occured when deleting stocktrade for : "+tradeId,e);
			throw new StockTradeDAODatabaseException("Exception occured when deleting stocktrade for : "+tradeId,e);
		}
	}

	/**
	 * Reads the entire SQL database for stock trade data and convert it to a {@link List} 
	 * @return the list of database's business object entries.
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public List<StockTrade> getAllStockTrades() throws StockTradeDAODatabaseException {
		
		LOGGER.debug("Transaction Active for getAllStockTrades() : "+TransactionSynchronizationManager.isActualTransactionActive());
		LOGGER.debug("Reading database data as List");
		try {
			List<StockTrade> allTradesList = jdbcTemplate.query(READ_QUERY, new StockTradeRowMapper());
			return allTradesList;
		}catch(DataAccessException dae) {
			LOGGER.error("Unable to get all stocktrades data from the database.",dae);
			throw new StockTradeDAODatabaseException("Unable to get all stocktrades data from the database.",dae);
		}catch (Exception e) {
			LOGGER.error("Exception occured when getting all stocktrades.");
			throw new StockTradeDAODatabaseException("Exception occured when getting all stocktrades.");
		}
	}

	/**
	 * A method to perform the batch insert operation to the SQL database
	 * @param list the list of stock trade objects need to be inserted.
	 * @return an array of integers with number of rows updated.
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public int[] performBatchInsertStockTrade(List<StockTrade> list,int batchSize) throws StockTradeDAODatabaseException {
		

		LOGGER.debug("Transaction Active for performBatchInsertStockTrade() : "+TransactionSynchronizationManager.isActualTransactionActive());
		LOGGER.debug("Performing batch operations on database, batchsize = "+batchSize);
		int rows[] =null;
		
		for(int i=0 ;i<list.size(); i+= batchSize) {
			
			List<StockTrade> batchList = list.subList(i, (i+batchSize)>list.size()?list.size() : (i+batchSize));
			
			try {
					rows = jdbcTemplate.batchUpdate(INSERT_QUERY,new BatchPreparedStatementSetter() {
				
							@Override
							public void setValues(PreparedStatement ps, int j) throws SQLException {
			//					LOGGER.debug("j value : "+j);
								StockTrade trade = batchList.get(j);
								ps.setInt(1, trade.getTradeId());
								ps.setString(2, trade.getSecurity());
								ps.setDate(3, Date.valueOf(trade.getDate()));
								ps.setDouble(4, trade.getOpen());
								ps.setDouble(5, trade.getHigh());
								ps.setDouble(6, trade.getLow());
								ps.setDouble(7, trade.getClose());
								ps.setDouble(8, trade.getVolume());
								ps.setDouble(9, trade.getAdjClose());
							}
						
							@Override
							public int getBatchSize() {
								return batchList.size();
							}
						});
					
			}
			catch(DataAccessException dae) {
				LOGGER.error("Unable to perform batch operations on database.",dae);
				throw new StockTradeDAODatabaseException("Unable to perform batch operations on database.",dae);
			}
			catch (Exception e) {
				LOGGER.error("Exception occured when performing batch insert.",e);
				throw new StockTradeDAODatabaseException("Exception occured when performing batch insert.",e);
			}
		}
		LOGGER.info("Batch Operations to database are performed.");
		return rows;
	}

	/**
	 * A method to truncate the SQL database.
	 * @throws StockTradeDAODatabaseException if any DAO operations in database leads to failure.
	 */
	@Override
	public void cleanUp() throws StockTradeDAODatabaseException {
		try {
			jdbcTemplate.execute(TRUNCATE_QUERY);
		}
		catch (DataAccessException dae) {
			LOGGER.error("Unable to truncate the database.",dae);
			throw new StockTradeDAODatabaseException("Unable to truncate the database.",dae);
		}
	}

}
