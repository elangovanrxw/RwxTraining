package com.reactiveworks.usercrudsoap.dao;

import com.reactiveworks.usercrudsoap.dao.exception.UserDAOException;
import com.reactiveworks.usercrudsoap.model.User;

/**
 * A interface which contains the methods to be implemented in
 * the implementation class.
 * @author Elangovan
 *
 */
public interface UserDAO {

	String INSERT = "INSERT INTO USER(USERID,USERNAME,EMAIL,PHONE,CITY) VALUES(?,?,?,?,?)";
	String GET_BY_USERID = "SELECT * FROM USER WHERE USERID=?";
	String GET_BY_USERNAME = "SELECT * FROM USER WHERE USERNAME=?";
	String DELETE = "DELETE FROM USER WHERE USERID=?";
	String DB_FILE_NAME = "db.properties";

	/**
	 * Service method to create a new user.
	 * @param user The new user which is to be created.
	 * @throws UserDAOException if any database operations fails.
	 */
	String createUser(User user) throws UserDAOException;

	/**
	 * Service method to update the existing user.
	 * @param user The new user which is to be created.
	 * @throws UserDAOException if any database operations fails.
	 */
	String updateUser(User user) throws UserDAOException;

	/**
	 * Service method to get the user by passing userID.
	 * @param userId The userId of the user which needs to be fetched.
	 * @throws UserDAOException if any database operations fails.
	 */

	User getUserByUserID(String userId) throws UserDAOException;

	/**
	 * Service method to get the user by passing user name.
	 * @param username The name of the user which needs to be fetched.
	 * @throws UserDAOException if any database operations fails.
	 */
	User getUserByUserName(String userName) throws UserDAOException;

	/**
	 * Service method to delete the user by passing userID.
	 * @param userId The userId of the user which needs to be deleted.
	 * @throws UserDAOException if any database operations fails.
	 */
	String deleteUserByUserId(String userId) throws UserDAOException;

}