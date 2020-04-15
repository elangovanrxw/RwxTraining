package com.reactiveworks.cricketanalyzer.service.impl;

public class AddTotalOvers {
	
	public static final double dOvers = 39.5;
	
	 public static void main(String[] args) {
		 
		String overs = String.valueOf(dOvers);
	//	 System.out.println(overs);
		String split[] = overs.split("\\.");
		double iOvers = Integer.parseInt(split[0]);
		double balls  = Integer.parseInt(split[1]);
		
		if(balls > 5) {
			iOvers++;
			balls-=6;
			iOvers += (0.1*balls);
		}
		else {
			iOvers += (0.1*balls);
		}
		
		System.out.println(iOvers);
	}
}
