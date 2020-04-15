package com.reactiveworks.stocktrade.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import com.reactiveworks.stocktrade.dao.impl.StockTradeDAOCSVImpl;
import com.reactiveworks.stocktrade.dao.impl.StockTradeDAOSQLImpl;

/**
 * Factory class to provide the instance of the required type.
 * @author Elangovan
 *
 */
public class StockTradeDAOFactory {

	/**
	 * Implementation of the Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(StockTradeDAOFactory.class);
	
	/**
	 * Static instance of {@link IStockTradeDAO}
	 */
	public static IStockTradeDAO daoInstance;
	
	/**
	 * Key value of database type.
	 */
	private static String dbType;
	
	/**
	 * Spring setter injection method to set the database implementation type
	 * @param type the type of database implementation.
	 */
	public void setDbType(String type) {
		LOGGER.debug("Setting DB implementation as '"+type+"'");
		StockTradeDAOFactory.dbType = type;
	}
	
	/**
	 * Instance of {@link JdbcTemplate} to perform database
	 * related operations.
	 */
	private static JdbcTemplate jdbcTemplate;
	
	/**
	 * Spring setter injection method to set the jdbcTemplate with particular datasource in it.
	 * @param jdbcTemplate jdbcTemplate whic contains the datasource.
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		StockTradeDAOFactory.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Providing instance when calling this method.
	 * @return daoInstance created for data access object.
	 * @throws FileAccessFailureException if any access in file leads to failure
	 * @throws OperationFailureException if performing operations on resource leads to failure.
	 *
	 */
	public static IStockTradeDAO getStockTradeDAOInstance() {
				
		if(dbType.equalsIgnoreCase("csv")) {
			daoInstance = new StockTradeDAOCSVImpl();
		}
		else if(dbType.equalsIgnoreCase("sql")) {
			daoInstance = new StockTradeDAOSQLImpl(jdbcTemplate);
		}
		LOGGER.debug("Returning instance from factory, Type: "+daoInstance.getClass().getName());
		return daoInstance;
	}
}
