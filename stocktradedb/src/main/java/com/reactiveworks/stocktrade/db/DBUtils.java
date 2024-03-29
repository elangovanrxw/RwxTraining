package com.reactiveworks.stocktrade.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.reactiveworks.stocktrade.db.exception.DatabaseAccessFailureException;

/**
 * A class to use for accessing database utilities.
 * @author Elangovan
 *
 */
public class DBUtils {

	/**
	 * Implementation of Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(DBUtils.class);
	
	private static final String DB_FILE_NAME = "db.properties";
	private static final String DB_URL = "dbUrl";
	private static final String DB_USER = "dbUser";
	private static final String DB_PASS = "dbPass";
	private static final String DB_MIN_IDLE = "dbMinIdle";
	private static final String DB_MAX_IDLE = "dbMaxIdle";
	private static final String DB_MAX_PREP_STMTS = "dbMaxOpenPrepStmts";
	
	private static BasicDataSource dataSource;
//	private static MysqlDataSource mySqlDS;
	
	/**
	 *  default constructor with private access.
	 */
	private DBUtils() {
		
	}
	
	/**
	 * A static method to get the connection established to Database.
	 * @return Connection object  which contains the connection info.
	 * @throws DatabaseAccessFailureException if there is a failure in establishing connection to DB.
	 */
	public static synchronized Connection getDBConnection() throws DatabaseAccessFailureException {
		
		if (dataSource == null)
		{
			dataSource = new BasicDataSource();
			try 
			{
				String file = DBUtils.class.getResource("/" + DB_FILE_NAME).getFile();
				Properties prop = new Properties();
				prop.load(new FileInputStream(file));
				LOGGER.debug("INITIALIZING DATABASE PROPERTIES");
				dataSource.setUrl(prop.getProperty(DB_URL));
				dataSource.setUsername(prop.getProperty(DB_USER));
				dataSource.setPassword(prop.getProperty(DB_PASS));
				dataSource.setMinIdle(Integer.valueOf(prop.getProperty(DB_MIN_IDLE)));
				dataSource.setMaxIdle(Integer.valueOf(prop.getProperty(DB_MAX_IDLE)));
				dataSource.setMaxOpenPreparedStatements(Integer.valueOf(prop.getProperty(DB_MAX_PREP_STMTS)));
				
			} catch (FileNotFoundException fnfExp) {
				throw new DatabaseAccessFailureException("Database properties file is not found in classpath.", fnfExp);
			} catch (IOException ioExp) {
				throw new DatabaseAccessFailureException("File is not readable.", ioExp);
			} 
		}
		try
		{
			Connection con = dataSource.getConnection();
			return con;
		}
		catch (SQLException sqlExp) {
			throw new DatabaseAccessFailureException("Exception occured when esablishing connection.",sqlExp);
		}
	}

	public static void closeResources(Connection con,PreparedStatement pstmt,ResultSet rs) throws DatabaseAccessFailureException {
		
		try {
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}
		catch(SQLException sqlExp) {
			LOGGER.error("Cannot close the resource : ",sqlExp);
			throw new DatabaseAccessFailureException("Cannot close the resource : ",sqlExp);
		}
	}
	
	
	
	
	
	
	
/*	/**
	 * Returns the instance of MysqlDataSource which is used to get connection.
	 * 
	 * @return object of MysqlDataSource
	 * @throws StockFileNotFoundException if stock file is not found.
	 * @throws FileNotReadableException   if file is found, but not readable.
	 * @throws ConnectionException        if there is any error in connection
	 *                                    properties.
	 *
	public MysqlDataSource getMySqlDataSource()
			throws StockFileNotFoundException, FileNotReadableException, DatabaseException
	{
		if (mySqlDS == null) {
			mySqlDS = new MysqlDataSource();
			try {
				String file = this.getClass().getResource("/" + DB_FILE_NAME).getFile();
				Properties prop = new Properties();
				prop.load(new FileInputStream(file));
				mySqlDS.setURL(prop.getProperty(DB_URL));
				mySqlDS.setUser(prop.getProperty(DB_USER));
				mySqlDS.setPassword(prop.getProperty(DB_PASS));

				mySqlDS.setCachePrepStmts(true);
				mySqlDS.setPrepStmtCacheSize(100);

			} catch (FileNotFoundException fnfExp) {
				throw new StockFileNotFoundException("File is not found in the given classpath", fnfExp);
			} catch (IOException ioExp) {
				throw new FileNotReadableException("File is not readable.", ioExp);
			} catch (SQLException sqlExp) {
				throw new DatabaseException("Exception occured : " + sqlExp);
			}
		}
		return mySqlDS;
	}*/
}
