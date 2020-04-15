package com.reactiveworks.usercrudsoap.webservice.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reactiveworks.usercrudsoap.dao.exception.UserDAOException;
import com.reactiveworks.usercrudsoap.dao.impl.UserDAOSQLImpl;
import com.reactiveworks.usercrudsoap.model.User;
import com.reactiveworks.usercrudsoap.webservice.UserOperation;

/**
 * A webservice class contains the list of webservice operations.
 * @author Elangovan
 *
 */
@WebService(targetNamespace="http://userdao.rxwwebservice.com",serviceName="UserOperationService"
			,endpointInterface="com.reactiveworks.usercrudsoap.webservice.UserOperation")
public class UserOperationImpl implements UserOperation{

	ApplicationContext context = new ClassPathXmlApplicationContext("springcfg.xml");
	
	UserDAOSQLImpl userDAO = context.getBean("daoSql",UserDAOSQLImpl.class);
	
	private static final Logger LOGGER = Logger.getLogger(UserOperationImpl.class);
	
	/**
	 * Web service method to create a new user.
	 * @param user The new user which is to be created.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public String createUser(User user) throws UserDAOException {
		LOGGER.debug("Inside webservice createuser() method..");
		return userDAO.createUser(user);
	}


	/**
	 * Web service method to update the existing user.
	 * @param user The new user which is to be created.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public String updateUser(User user) throws UserDAOException {
		return userDAO.updateUser(user);
	}

	/**
	 * Web service method to get the user by passing userID.
	 * @param userId The userId of the user which needs to be fetched from database.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public User getUserByUserID(String userId) throws UserDAOException {
		return userDAO.getUserByUserID(userId);
	}

	/**
	 * Web service method to get the user by passing user name.
	 * @param username The name of the user which needs to be fetched from database.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public User getUserByUserName(String userName) throws UserDAOException {
		return userDAO.getUserByUserName(userName);
	}

	/**
	 * Web service method to delete the user by passing userID.
	 * @param userId The userId of the user which needs to be deleted from database.
	 * @throws UserDAOException if any database operations fails.
	 */
	@Override
	public String deleteUserByUserId(String userId) throws UserDAOException {
		return userDAO.deleteUserByUserId(userId);
	}
}
