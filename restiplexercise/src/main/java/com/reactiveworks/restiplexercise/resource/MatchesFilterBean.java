package com.reactiveworks.restiplexercise.resource;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * This class is used to filter the params that are given along with the request for matches.
 * @author Elangovan
 *
 */
public class MatchesFilterBean {

	/**
	 * Season parameter to filter match that is containing this season.
	 */
	private @QueryParam("season") int year;
	
	/**
	 * City parameter to filter match that is containing this city.
	 */
	private @QueryParam("city") String city;
	
//	/**
//	 * Match-ID parameter to filter match that is containing this match-ID.
//	 */
//	private @PathParam("matchId") int matchId;
	
	/*
	 * Getters and setters for the params.
	 */
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	public int getMatchId() {
//		return matchId;
//	}
//	public void setMatchId(int matchId) {
//		this.matchId = matchId;
//	}
	
	
	
}
