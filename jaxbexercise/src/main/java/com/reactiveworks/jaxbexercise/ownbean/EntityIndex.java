package com.reactiveworks.jaxbexercise.ownbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityIndex")

public class EntityIndex {

	private String entityColumnRef;

	public EntityIndex() {
	
	}
	
	@XmlAttribute(name="entityColumnRef",required=true)
	public String getEntityColumnRef() {
		return entityColumnRef;
	}

	public void setEntityColumnRef(String entityColumnRef) {
		this.entityColumnRef = entityColumnRef;
	}
	
	
}
