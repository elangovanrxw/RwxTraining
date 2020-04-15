package com.reactiveworks.stocktrade.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.reactiveworks.stocktrade.pojo.StockTrade;

public class StockTradeRowMapper implements RowMapper<StockTrade> {

	@Override
	public StockTrade mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		StockTrade std = new StockTrade();
		std.setTradeId(rs.getInt(1));
		std.setSecurity(rs.getString(2));
		std.setDate(rs.getDate(3).toLocalDate()); 
		std.setOpen(rs.getDouble(4));
		std.setHigh(rs.getDouble(5));
		std.setLow(rs.getDouble(6));
		std.setClose(rs.getDouble(7));
		std.setVolume(rs.getDouble(8));
		std.setAdjClose(rs.getDouble(9));
		
		return std;
		
	}
	
	

}
