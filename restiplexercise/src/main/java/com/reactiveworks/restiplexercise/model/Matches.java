package com.reactiveworks.restiplexercise.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.reactiveworks.restiplexercise.model.adapters.LocalDateAdapter;

/**
 * Deliveries class contains all the matches parameters
 * @author Elangovan
 *
 */
@XmlRootElement
@XmlType(propOrder= {"matchId","season","city","date","firstTeam","secondTeam","tossWinner","tossDecision","result","winner"})
public class Matches {

	/*
	 * Instance variables of Matches properties.
	 */
	private int matchId;
	private int season;
	private String city;
	private LocalDate date;
	private String firstTeam;
	private String secondTeam;
	private String tossWinner;
	private String tossDecision;
	private String result;
	private String winner;
	
	/*
	 * Getters and setters for matches properties.
	 */
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getFirstTeam() {
		return firstTeam;
	}
	public void setFirstTeam(String firstTeam) {
		this.firstTeam = firstTeam;
	}
	public String getSecondTeam() {
		return secondTeam;
	}
	public void setSecondTeam(String secondTeam) {
		this.secondTeam = secondTeam;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/**
	 * To return the data in the specified format 
	 * for the user to explore it.
	 */
	public String toString() {
		return matchId+", "+season+", "+city+", "+date+", "+firstTeam+", "+secondTeam+", "+
				tossWinner+", "+tossDecision+", "+result+", "+winner;			
	}
}
