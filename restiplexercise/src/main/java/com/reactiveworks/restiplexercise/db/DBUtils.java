package com.reactiveworks.restiplexercise.db;

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

import com.reactiveworks.restiplexercise.dao.exception.DatabaseDAOException;

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
	private static final String DB_URL = "db.url";
	private static final String DB_USER = "db.username";
	private static final String DB_PASS = "db.password";
	private static final String DB_MIN_IDLE = "db.minIdle";
	private static final String DB_MAX_IDLE = "db.maxIdle";
	private static final String DB_MAX_PREP_STMTS = "db.maxOpenPrepStmts";
	private static final String TRX_REQUIRED = "db.transaction";
	
	
	private static BasicDataSource dataSource;
	
	/**
	 *  default constructor with private access.
	 */
	private DBUtils() {
		
	}
	
	/**
	 * A static method to get the connection established to Database.
	 * @return Connection object  which contains the connection info.
	 * @throws DatabaseDAOException if there is a failure in establishing connection to DB.
	 */
	public static synchronized Connection getDBConnection() throws DatabaseDAOException {
		
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
				dataSource.setDefaultAutoCommit(Boolean.valueOf(prop.getProperty(TRX_REQUIRED)));
				
			} catch (FileNotFoundException fnfExp) {
				throw new DatabaseDAOException("Database properties file is not found in classpath.", fnfExp);
			} catch (IOException ioExp) {
				throw new DatabaseDAOException("File is not readable.", ioExp);
			} 
		}
		try
		{
			Connection con = dataSource.getConnection();
//			System.out.println("Autocommit:"+con.getAutoCommit());
			return con;
		}
		catch (SQLException sqlExp) {
			throw new DatabaseDAOException("Exception occured when esablishing connection.",sqlExp);
		}
	}

	/**
	 * A static method which is used to close the resources.
	 * @param con a {@link Connection} instance.
	 * @param pstmt a {@link PreparedStatement} instance.
	 * @param rs a {@link ResultSet} instance.
	 * @throws DatabaseDAOException if any error occurs while closing the resources.
	 */
	public static void closeResources(Connection con,PreparedStatement pstmt,ResultSet rs) throws DatabaseDAOException {
		
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
			throw new DatabaseDAOException("Cannot close the resource : ",sqlExp);
		}
	}

}
