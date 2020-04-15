package com.reactiveworks.jaxbexercise.ownbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityField")

public class EntityField {
	
	private String name;
	private String type;
	
	public EntityField() {
	
	}
	
	
	public EntityField(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}


	@XmlAttribute(name="name", required=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="type", required=true)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
