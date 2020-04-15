package com.reactiveworks.restiplexercise.resource;

import javax.ws.rs.QueryParam;

/**
 * This class is used to filter the params that are given along with the request for deliveries.
 * @author Elangovan
 *
 */
public class DeliveriesFilterBean {

	/**
	 * Match-Id parameter.
	 */
	private @QueryParam("matchId") int matchId;
	
	/**
	 * Inning parameter.
	 */
	private @QueryParam("inning") int inning;
	
	
	/*
	 * Getters and setters for the params.
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
	
}
	
