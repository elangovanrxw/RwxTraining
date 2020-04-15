package com.reactiveworks.jaxbexercise.ownbean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityFilterKeysMapping")
public class EntityFilterKeysMapping {

	private List<EntityKey> entityKey;

	@XmlElement(name="EntityKey")
	public List<EntityKey> getEntityKey() {
		return entityKey;
	}

	public void setEntityKey(List<EntityKey> entityKey) {
		this.entityKey = entityKey;
	}
	
}
