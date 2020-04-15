package com.reactiveworks.usercrudsoap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.reactiveworks.usercrudsoap.dao.exception.UserDAOException;
import com.reactiveworks.usercrudsoap.model.User;

/**
 * A DAO interface to give structure of the DAO operations
 * that is done on the database.
 * @author Elangovan
 *
 */
@WebService(targetNamespace="http://userdao.rxwwebservice.com")
public interface UserOperation {

	/**
	 * A web service to create new user in the database.
	 * @param user which is to be created.
	 * @return response string 
	 * @throws UserDAOException throws when this operation fails.
	 */
	@WebMethod(operationName="createNewUserOperation")
	@WebResult(name="createUserResult")
	String createUser(User user) throws UserDAOException;
	
	
	/**
	 * A web service to update the existing user in the database.
	 * @param user which is to be updated.
	 * @return response string 
	 * @throws UserDAOException throws when this operation fails.
	 */
	@WebMethod(operationName="updateExistingUserOperation")
	@WebResult(name="updateUserResult")
	String updateUser(User user) throws UserDAOException;
	
	/**
	 * A web service to get the user in the database by passing user id.
	 * @param userId user id which is to be fetched.
	 * @return user instance contains all the details of the user. 
	 * @throws UserDAOException throws when this operation fails.
	 */
	@WebMethod(operationName="getUserByUserIdOperation")
	@WebResult(name="getUserByIdResult")
	User getUserByUserID(String userId) throws UserDAOException;
	
	/**
	 * A web service to get the user in the database by passing username.
	 * @param username user name which is to be fetched.
	 * @return user instance contains all the details of the user. 
	 * @throws UserDAOException throws when this operation fails.
	 */
	@WebMethod(operationName="getUserByUserNameOperation")
	@WebResult(name="getUserByNameResult")
	User getUserByUserName(String userName) throws UserDAOException;
	
	/**
	 * A web service to delete the user in the database by passing userId.
	 * @param userId user id which is to be fetched.
	 * @return response message.
	 * @throws UserDAOException throws when this operation fails.
	 */
	@WebMethod(operationName="deleteUserByUserIdOperation")
	@WebResult(name="deleteUserByIdResult")
	String deleteUserByUserId(String userId) throws UserDAOException;
}
