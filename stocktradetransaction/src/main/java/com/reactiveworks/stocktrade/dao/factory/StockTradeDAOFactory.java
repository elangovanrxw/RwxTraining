package com.reactiveworks.stocktrade.dao.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.reactiveworks.stocktrade.dao.IStockTradeDAO;
import com.reactiveworks.stocktrade.dao.exception.FileAccessFailureException;
import com.reactiveworks.stocktrade.dao.exception.FileOperationFailureException;
import com.reactiveworks.stocktrade.dao.impl.StockTradeDAOCSVImpl;
import com.reactiveworks.stocktrade.dao.impl.StockTradeDAOSQLImpl;
import com.reactiveworks.stocktrade.exception.OperationFailureException;

/**
 * Factory class to provide the instance of the required type.
 * @author Elangovan
 *
 */
public class StockTradeDAOFactory {

	private static final Logger LOGGER = Logger.getLogger(StockTradeDAOFactory.class);
	
	private static final String OBJ_FILE ="dbtype.properties";
	private static final String DB_TYPE = "dbType";
	
	private static Properties prop;
	
	/**
	 * Static instance of {@link IStockTradeDAO}
	 */
	private static IStockTradeDAO daoInstance;
	
	/**
	 * Providing instance when called.
	 * @return daoInstance created for data access object.
	 * @throws FileAccessFailureException if any access in file leads to failure
	 * @throws OperationFailureException if performing operations on resource leads to failure.
	 *
	 */
	public static IStockTradeDAO getStockTradeDAOInstance() throws FileAccessFailureException, OperationFailureException {
		
		String file = StockTradeDAOFactory.class.getResource("/"+OBJ_FILE).getFile();
		if(prop==null) 
		{
			prop = new Properties();
			try 
			{
				prop.load(new FileInputStream(file));
			} catch (FileNotFoundException fnfExp) {
				throw new FileAccessFailureException("Object properties file is not found.",fnfExp);
			} catch (IOException ioExp) {
				throw new FileOperationFailureException("Error in reading object properties file.",ioExp);
			}
		}
		String type = prop.getProperty(DB_TYPE);
		
		if(type.equalsIgnoreCase("csv"))
			daoInstance = new StockTradeDAOCSVImpl();
		else if(type.equalsIgnoreCase("sql"))
			daoInstance = new StockTradeDAOSQLImpl();
		else
			throw new OperationFailureException("Cannot create instance, Invalid object type :"+type);
		
		LOGGER.debug("Returing instance of "+type);
		return daoInstance;
	}
}
