package com.reactiveworks.stocktrade.pojo;

import java.time.LocalDate;

/**
 * A class which is containing the date and difference of the 
 * stocktrade data. 
 * @author Elangovan
 *
 */
public class DailyTradingDifferential {

	/*
	 * Instance variables to store the data.
	 */
	private LocalDate date;
	private double difference;
	
	/*
	 * Getters and setters for the daily trading
	 * differential parameters. 
	 */
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getDifference() {
		return difference;
	}
	public void setDifference(double difference) {
		this.difference = difference;
	}
	
	public String toString() {
		return date+", "+difference;
	}
}
