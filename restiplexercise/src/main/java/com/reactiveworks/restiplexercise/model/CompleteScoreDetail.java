package com.reactiveworks.restiplexercise.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A normal pojo class which is used to store the complete details
 * of score list.
 * @author Elangovan
 *
 */

@XmlRootElement
@XmlType(propOrder= {"year","teamName","fourCount","sixCount","totalScore"})
public class CompleteScoreDetail {

	/*
	 * Instance variables for the properties.
	 */
	private int year;
	private String teamName;
	private int fourCount;
	private int sixCount;
	private int totalScore;
	
	
	/*
	 * Getters and Setter methods for the score details.
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
	public int getFourCount() {
		return fourCount;
	}
	public void setFourCount(int fourCount) {
		this.fourCount = fourCount;
	}
	public int getSixCount() {
		return sixCount;
	}
	public void setSixCount(int sixCount) {
		this.sixCount = sixCount;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return year+","+teamName+","+fourCount+","+sixCount+","+totalScore;				
	}
	
}
