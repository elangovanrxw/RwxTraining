package com.reactiveworks.restiplexercise.model;

public class ScoreDetailParameters {

	private String teamOneName;
	private int teamOneFourCount;
	private int teamOneSixCount;
	private int teamOneTotalRuns;
	
	private String teamTwoName;
	private int teamTwoFourCount;
	private int teamTwoSixCount;
	private int teamTwoTotalRuns;
	
	
	public String getTeamOneName() {
		return teamOneName;
	}
	public void setTeamOneName(String teamOneName) {
		this.teamOneName = teamOneName;
	}
	public int getTeamOneFourCount() {
		return teamOneFourCount;
	}
	public void setTeamOneFourCount(int teamOneFourCount) {
		this.teamOneFourCount = teamOneFourCount;
	}
	public int getTeamOneSixCount() {
		return teamOneSixCount;
	}
	public void setTeamOneSixCount(int teamOneSixCount) {
		this.teamOneSixCount = teamOneSixCount;
	}
	public int getTeamOneTotalRuns() {
		return teamOneTotalRuns;
	}
	public void setTeamOneTotalRuns(int teamOneTotalRuns) {
		this.teamOneTotalRuns = teamOneTotalRuns;
	}
	public String getTeamTwoName() {
		return teamTwoName;
	}
	public void setTeamTwoName(String teamTwoName) {
		this.teamTwoName = teamTwoName;
	}
	public int getTeamTwoFourCount() {
		return teamTwoFourCount;
	}
	public void setTeamTwoFourCount(int teamTwoFourCount) {
		this.teamTwoFourCount = teamTwoFourCount;
	}
	public int getTeamTwoSixCount() {
		return teamTwoSixCount;
	}
	public void setTeamTwoSixCount(int teamTwoSixCount) {
		this.teamTwoSixCount = teamTwoSixCount;
	}
	public int getTeamTwoTotalRuns() {
		return teamTwoTotalRuns;
	}
	public void setTeamTwoTotalRuns(int teamTwoTotalRuns) {
		this.teamTwoTotalRuns = teamTwoTotalRuns;
	}
	
	public String toString() {
		return "TEAM1="+teamOneName+","+teamOneFourCount+","+teamOneSixCount+","+teamOneTotalRuns+"||"
				+"TEAM2="+teamTwoName+","+teamTwoFourCount+","+teamTwoSixCount+","+teamTwoTotalRuns;
	}
	public boolean ifInningTwoHappened() {
		
		return teamTwoName!=null;
	}
	
	
}
