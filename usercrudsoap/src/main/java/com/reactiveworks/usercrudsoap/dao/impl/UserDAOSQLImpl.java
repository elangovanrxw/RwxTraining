package com.reactiveworks.usercrudsoap.dao.impl;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.reactiveworks.usercrudsoap.dao.UserDAO;
import com.reactiveworks.usercrudsoap.dao.exception.UserDAOException;
import com.reactiveworks.usercrudsoap.model.User;
import com.reactiveworks.usercrudsoap.spring.mapper.UserRowMapper;
import com.reactiveworks.usercrudsoap.webservice.exception.InvalidRequestException;

/**
 * An actual implementation class for the web service.
 * @author Elangovan
 *
 */
public class UserDAOSQLImpl implements UserDAO  {

	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = Logger.getLogger(UserDAOSQLImpl.class);
	
	/**
	 * Default constructor to load the database properties and assigning the 
	 *  {@link JdbcTemplate}
	 */
	public UserDAOSQLImpl() {
		
		/*String file = this.getClass().getResource("/"+DB_FILE_NAME).getFile();
		try {
			FileReader fr = new FileReader(file);
			Properties prop = new Properties();
			prop.load(fr);
			BasicDataSource ds = new BasicDataSource();
			ds.setUrl(prop.getProperty("db.url"));
			ds.setUsername(prop.getProperty("db.username"));
			ds.setPassword(prop.getProperty("db.password"));
			ds.setMinIdle(Integer.parseInt(prop.getProperty("db.minIdle")));
			this.jdbcTemplate = new JdbcTemplate(ds);
			
		} catch (IOException e) {
			LOGGER.error("Database properties file cannot be loaded.");
		}
		*/
	}
	
	/**
	 * Setter based Dependency injection for spring to inject the {@link JdbcTemplate} instance.
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		LOGGER.debug("Setting JdbcTemplate : "+jdbcTemplate);
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 * Service method to create a new user in the SQL database.
	 * @param user The new user which is to be created in the SQL database.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public String createUser(User user) throws UserDAOException {
		
		LOGGER.debug("Inside Service createUser() implementation");
		LOGGER.debug(user.getUserId());
		String returnMsg = "";
		int rows=0;
		try {
			LOGGER.debug("jdbctemplate is :"+jdbcTemplate);
			rows = jdbcTemplate.update(INSERT, user.getUserId(), user.getUsername(), user.getEmail(),
										user.getPhone(),user.getCity());
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to create user because : "+dae.getMessage(),dae);
			throw new UserDAOException("Unable to create user because : "+dae.getMessage(),dae);
		}
		catch(Exception e) {
			LOGGER.error("Unable to create user because : "+e.getMessage(),e);
			throw new UserDAOException("Unable to create user because : "+e.getMessage(),e);
		}
		if(rows==1) {
			returnMsg = "The user is created successfully with username '"+user.getUsername()+"' and userId '"+user.getUserId()+"'.";
		}
	
		return returnMsg;		//returning return message.
	}

	/**
	 * Service method to update the existing user in the SQL database.
	 * @param user The new user which is to be created.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public String updateUser(User user) throws UserDAOException {

		LOGGER.debug("Inside Service updateUser() implementation");
		String returnMsg = "";
		int rows=0;
		try {
			rows = jdbcTemplate.update(getUpdateQuery(user), getUpdatingFieldValues(user));
			
		}catch(DataAccessException dae) {
			LOGGER.error("Unable to update user because :"+dae.getMessage(),dae);
			throw new UserDAOException("Unable to update user because :"+dae.getMessage(),dae);
		}
		catch(Exception e) {
			LOGGER.error("Unable to update user because :"+e.getMessage(),e);
			throw new UserDAOException("Unable to update user because :"+e.getMessage(),e);
		}
		if(rows==1) {
			returnMsg = "The user is updated successfully with data.";
		}		
		return returnMsg;		//returning return message.
	}

	/**
	 * A helper method to determine which field of user has values to update.
	 * @param user user object which is to be determined.
	 * @return an array of values which are not null and are to be updated.
	 */
	private Object[] getUpdatingFieldValues(User user) {
		
		List<String> values = new ArrayList<String>();
		if(user.getUsername()!= null && !user.getUsername().isEmpty()) {
			values.add(user.getUsername());
		}
		if(user.getPhone()!= null && !user.getPhone().isEmpty()) {
			values.add(user.getPhone());
		}
		if(user.getEmail()!= null && !user.getEmail().isEmpty()) {
			values.add(user.getEmail());
		}
		if(user.getCity()!= null && !user.getCity().isEmpty()) {
			values.add(user.getCity());
		}
		values.add(user.getUserId());
		
		LOGGER.debug(Arrays.toString(values.toArray()));
		return values.toArray();
	}

	/**
	 * A helper method to construct the update query according to the 
	 * values that contains inside the user object.
	 * @param user which is to be determined.
	 * @return the constructed update query.
	 * @throws InvalidRequestException when the request to the server is invalid.
	 */
	private String getUpdateQuery(User user) throws InvalidRequestException {
		String fields ="";
		boolean containsAtleastOneField = false;
		
		if(user.getUsername()!= null && !user.getUsername().isEmpty()) {
			containsAtleastOneField=true;
			fields+="USERNAME=?,";
		}
		if(user.getPhone()!= null && !user.getPhone().isEmpty()) {
			containsAtleastOneField=true;
			fields+="PHONE=?,";
		}
		if(user.getEmail()!= null && !user.getEmail().isEmpty()) {
			containsAtleastOneField=true;
			fields+="EMAIL=?,";
		}
		if(user.getCity()!= null && !user.getCity().isEmpty()) {
			containsAtleastOneField=true;
			fields+="CITY=?,";
		}
		if(containsAtleastOneField) {
			fields = fields.substring(0, fields.length()-1);		//To ignore the last ',' character.
		}
		else {
			LOGGER.error("Minimum one field value is required for Update Functionality");
			throw new InvalidRequestException("Minimum one field value is required for Update Functionality");
		}
		String updateQuery = "UPDATE USER SET "+fields+" WHERE USERID=?";
		LOGGER.debug("Gen Query : "+updateQuery);
		return updateQuery;
	}

	/**
	 * Service method to get the user from the database by passing userID.
	 * @param userId The userId of the user which needs to be fetched from database.
	 * @throws UserDAOException if any database operations fails.
	 */

	@Override
	public User getUserByUserID(String userId) throws UserDAOException {
		
		LOGGER.debug("Inside Service getUserByUserID() implementation");
		try {			
			User user = jdbcTemplate.queryForObject(GET_BY_USERID, new UserRowMapper(), userId);
			return user;
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to fetch user for userId '"+userId+"' because : "+dae.getMessage(),dae);
			throw new UserDAOException("Unable to fetch user for userId '"+userId+"' because : "+dae.getMessage(),dae);
		}
		catch (Exception e) {
			LOGGER.error("Unable to fetch user for userId '"+userId+"' because : "+e.getMessage(),e);
			throw new UserDAOException("Unable to fetch user for userId '"+userId+"' because : "+e.getMessage(),e);
		}
	}
	
	/**
	 * Service method to get the user from the database by passing user name.
	 * @param username The name of the user which needs to be fetched from database.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public User getUserByUserName(String userName) throws UserDAOException {
		
		LOGGER.debug("Inside Service getUserByUserName() implementation");
		try {
			
			User user = jdbcTemplate.queryForObject(GET_BY_USERNAME, new UserRowMapper(), userName);
			return user;
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to fetch user for username '"+userName+"' because : "+dae.getMessage(),dae);
			throw new UserDAOException("Unable to fetch user for username '"+userName+"' because : "+dae.getMessage(),dae);
		}
		catch (Exception e) {
			LOGGER.error("Unable to fetch user for username '"+userName+"' because : "+e.getMessage(),e);
			throw new UserDAOException("Unable to fetch user for username '"+userName+"' because : "+e.getMessage(),e);
		}
	}// ..end of the method getUserByUserName

	/**
	 * Service method to delete the user from the database by passing userID.
	 * @param userId The userId of the user which needs to be deleted from database.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public String deleteUserByUserId(String userId) throws UserDAOException {
		
		LOGGER.debug("Inside Service deleteUserByUserId() implementation");
		int rows =0;
		String returnMsg="";
		try {
			rows = jdbcTemplate.update(DELETE, userId);
		}
		catch(DataAccessException dae) {
			LOGGER.error("Unable to delete user for userid '"+userId+"' because : "+dae.getMessage(),dae);
			throw new UserDAOException("Unable to delete user for userid '"+userId+"' because : "+dae.getMessage(),dae);
		}
		catch (Exception e) {
			LOGGER.error("Unable to delete user for userid '"+userId+"' because : "+e.getMessage(),e);
			throw new UserDAOException("Unable to delete user for userid '"+userId+"' because : "+e.getMessage(),e);
		}
		if(rows ==1) {
			returnMsg = "User '"+userId+"' is deleted successfully";
		}
		return returnMsg;
	}
		
	
}
