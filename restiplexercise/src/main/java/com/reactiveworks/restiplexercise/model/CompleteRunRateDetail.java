package com.reactiveworks.restiplexercise.model;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.log4j.Logger;

/**
 * A class which is used to store the details of the run rates with team names
 * respect to years.
 * @author Elangovan
 *
 */
@XmlRootElement
@XmlType(propOrder= {"year","teamName","runRate"})
public class CompleteRunRateDetail {

	/*
	 * Instance variables for storing the run rate details.
	 */
	private int year;
	private String teamName;
	private double runRate;
		
	/*
	 * Getters and Setter methods for the run rate values.
	 */
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getRunRate() {
		return runRate;
	}
	public void setRunRate(double runRate) {
		this.runRate = runRate;
	}

	public String toString() {
		return year+","+teamName+","+runRate;
	}
}
