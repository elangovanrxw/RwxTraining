package com.reactiveworks.jaxbexercise.main;


 //import com.reactiveworks.jaxbexercise.ownbean.*;  //Own written JAXB classes.
import com.reactiveworks.jaxbexercise.util.JAXBUtility;

import com.reactiveworks.jaxbexercise.generatedbean.*;   //Generated JAXB classes.

public class LeapDataServicesMain {
	
	 public static void main(String[] args) {
		 
		LeapDataServices lds = new LeapDataServices();
		
		lds=(LeapDataServices) JAXBUtility.doUnmarshalling(lds,"Entity.xml");
		
		JAXBUtility.doMarshalling(lds, "Gen_Entity_new.xml");
	
		
	}
}
