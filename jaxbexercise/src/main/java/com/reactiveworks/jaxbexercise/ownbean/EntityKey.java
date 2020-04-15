package com.reactiveworks.jaxbexercise.ownbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityKey")
public class EntityKey {

	private String name;
	private int sequence;
	private String mappedTo;
	private String required;
	
	public EntityKey() {
	
	}
	
	@XmlAttribute(name="name",required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name="sequence")
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@XmlAttribute(name="mappedTo")
	public String getMappedTo() {
		return mappedTo;
	}

	public void setMappedTo(String mappedTo) {
		this.mappedTo = mappedTo;
	}

	@XmlAttribute(name="required")
	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}
	
	
}
