package com.reactiveworks.usercrudsoap.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.reactiveworks.usercrudsoap.model.User;;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		user.setUserId(rs.getString(1));
		user.setUsername(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setPhone(rs.getString(4));
		user.setCity(rs.getString(5));
		return user;

	}
	


	
}
