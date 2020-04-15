package com.reactiveworks.jsonexercise.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class EntityUpdateKeysMapping {

private List<EntityKey> entityKey;
	
	@XmlElement(name="EntityKey")
	public List<EntityKey> getEntityKey() {
		return entityKey;
	}

	public void setEntityKey(List<EntityKey> entityKey) {
		this.entityKey = entityKey;
	}
}
