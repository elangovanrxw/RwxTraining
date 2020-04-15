package com.reactiveworks.cricketanalyzer.pojo;

import java.util.List;
import java.util.Map;

/**
 * A class which is used to store the fielding count detail of the
 * teams with respect to the year.
 * @author Elangovan
 *
 */
public class CompleteFieldCountDetail {

	/*
	 * Instance variables for storing field count details.
	 */
	private int year;
	private String teamName;
	private int fieldCount;
	
	/*
	 * Getters and Setters for storing the field count details.
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
	public int getFieldCount() {
		return fieldCount;
	}
	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
	}
	
	public String toString() {
		return year+","+teamName+","+fieldCount;
	}
	
}
