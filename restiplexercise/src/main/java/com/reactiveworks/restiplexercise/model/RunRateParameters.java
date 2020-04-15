package com.reactiveworks.restiplexercise.model;
/**
 * A class for storing the run rate calculation parameters
 * before calculating the run rate.
 * @author Elangovan
 *
 */
public class RunRateParameters {

	/*
	 * Instance variables for run rate parameters.
	 */
	int year;
	String teamName;
	double totalOvers;
	int totalRuns;
	
	/*
	 * Getters and setters for the run rate parameters.
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
	public double getTotalOvers() {
		return totalOvers;
	}
	public void setTotalOvers(double totalOvers) {
		this.totalOvers = totalOvers;
	}
	public int getTotalRuns() {
		return totalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	
	public String toString() {
		return year+", "+teamName+", "+totalOvers+", "+totalRuns;
	}
}
