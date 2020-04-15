package com.reactiveworks.jsonexercise.model;

import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LeapDataServices")

public class LeapDataServices {
	
	private double version;
	
	private List<Entity> entity;	
	
	public LeapDataServices() {
		
	}
	
	@XmlElement(name="Entity",required=true)
	public List<Entity> getEntity() {
		return entity;
	}

	public void setEntity(List<Entity> entity) {
		this.entity = entity;
	}

	@XmlAttribute(name="version",required=true)
	public double getVersion() {
		return version;
	}

	
	public void setVersion(double version) {
		this.version = version;
	}


}
