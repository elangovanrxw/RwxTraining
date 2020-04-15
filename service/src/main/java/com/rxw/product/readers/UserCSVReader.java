package com.rxw.product.readers;

import java.util.*;
import java.io.*;
import com.rxw.product.base.User;
import com.rxw.product.exception.*;


public class UserCSVReader extends Reader {

	public static final String USER_FILENAME="User.csv";
	
	public List<User> getAllUsers() throws InvalidDataException, FileHandlingException
	{		
		ArrayList<User> userList = new ArrayList<User>();
		try
		{
			BufferedReader br = getBufferredReader(USER_FILENAME);
			String lineString = null;
			int count=0;
			while((lineString=br.readLine())!=null)
			{
				if(count>=1)
					userList.add(parseUserData(lineString));
				count++;
			}
		} 
		catch (FileNotFoundException fnfexp)
		{
			throw new FileHandlingException("File '"+USER_FILENAME+"' is not present in classpath.",fnfexp);
		} 
		catch (IOException ioexp) 
		{
			throw new FileHandlingException("[READING ERROR] Cannot read the given file : '"+USER_FILENAME+"'",ioexp);
		}
		return userList;		
	}

	private User parseUserData(String lineString) throws InvalidDataException  {
		
		String userDet[] = lineString.split(",");
		User  user = new User();
		user.setUserId(userDet[0]);
		user.setUserName(userDet[1]);
		user.setCity(userDet[4]);
		user.setEmail(userDet[2]);
		user.setPhoneNumber(userDet[3]);		
		return user;
	}

}
