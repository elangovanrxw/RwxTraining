package com.reactiveworks.jsonexercise.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



public class EntityCollection {

	private String collectionName;
	private String collectionType;
	
	public EntityCollection() {
	
	}
	
	public EntityCollection(String collectionName, String collectionType) {
		super();
		this.collectionName = collectionName;
		this.collectionType = collectionType;
	}

	@XmlAttribute(name="collectionName",required=true)
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
	@XmlAttribute(name="collectionType",required=true)
	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	
	
}
