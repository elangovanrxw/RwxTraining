package com.reactiveworks.stocktrade.pojo;

import java.time.LocalDate;
/**
 * A basic/pojo class for the parameters of the stocktrade
 * @author Elangovan
 *
 */
public class StockTrade {

	/*
	 * Instance variables to store the StockTrade properties.
	 */
	private String security;
	private LocalDate date;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Double volume;
	private Double adjClose;
	private int tradeId;
	
	/*
	 * Getters and Setter methods to store get and set 
	 * the StockTrade properties.
	 */
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getAdjClose() {
		return adjClose;
	}
	public void setAdjClose(Double adjClose) {
		this.adjClose = adjClose;
	}
	
	public String toString()
	{
		return tradeId+" "+security+" "+date+" "+open+" "+high+" "+low+" "+close+" "+volume+" "+adjClose;
	}
	
}
