package com.reactiveworks.restiplexercise.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Deliveries class contains all the delivery parameters
 * @author Elangovan
 *
 */
@XmlRootElement(name="delivery")
@XmlType(propOrder= {"matchId","inning","battingTeam","bowlingTeam","over","ball",
		"batsman","bowler","wideRuns","byeRuns","legbyeRuns","noballRuns","penaltyRuns",
		"batsmanRuns","extraRuns","totalRuns"})
public class Deliveries {
	
	/*
	 * Instance variables of delivery properties.
	 */

	private int matchId;
	private int inning;
	private String battingTeam;
	private String bowlingTeam;
	private int over;
	private int ball;
	private String batsman;
	private String bowler;
	private int wideRuns;
	private int byeRuns;
	private int legbyeRuns;
	private int noballRuns;
	private int penaltyRuns;
	private int batsmanRuns;
	private int extraRuns;
	private int totalRuns;
	
	/*
	 * Getters and setters for deliveries properties.
	 * 
	 */

	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public String getBattingTeam() {
		return battingTeam;
	}
	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}
	public String getBowlingTeam() {
		return bowlingTeam;
	}
	public void setBowlingTeam(String bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public String getBatsman() {
		return batsman;
	}
	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public int getWideRuns() {
		return wideRuns;
	}
	public void setWideRuns(int wideRuns) {
		this.wideRuns = wideRuns;
	}
	public int getByeRuns() {
		return byeRuns;
	}
	public void setByeRuns(int byeRuns) {
		this.byeRuns = byeRuns;
	}
	public int getLegbyeRuns() {
		return legbyeRuns;
	}
	public void setLegbyeRuns(int legbyeRuns) {
		this.legbyeRuns = legbyeRuns;
	}
	public int getNoballRuns() {
		return noballRuns;
	}
	public void setNoballRuns(int noballRuns) {
		this.noballRuns = noballRuns;
	}
	public int getPenaltyRuns() {
		return penaltyRuns;
	}
	public void setPenaltyRuns(int penaltyRuns) {
		this.penaltyRuns = penaltyRuns;
	}
	public int getBatsmanRuns() {
		return batsmanRuns;
	}
	public void setBatsmanRuns(int batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}
	public int getExtraRuns() {
		return extraRuns;
	}
	public void setExtraRuns(int extraRuns) {
		this.extraRuns = extraRuns;
	}
	public int getTotalRuns() {
		return totalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	
	/**
	 * To return the data in the specified format
	 * for the user to explore it.
	 */
	public String toString() {
		return matchId+", "+inning+", "+battingTeam+", "+bowlingTeam+", "+over+", "+ball+", "+
				batsman+", "+bowler+", "+wideRuns+", "+byeRuns+", "+legbyeRuns+", "+noballRuns+", "+penaltyRuns+", "+
				batsmanRuns+", "+extraRuns+", "+totalRuns;
	}
	
}
