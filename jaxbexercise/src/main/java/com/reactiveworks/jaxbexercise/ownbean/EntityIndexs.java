package com.reactiveworks.jaxbexercise.ownbean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityIndexs")
public class EntityIndexs {

	private List<EntityIndex> entityIndex;
	
	public EntityIndexs() {
	
	}

	@XmlElement(name="EntityIndex",type=EntityIndex.class)
	public List<EntityIndex> getEntityIndex() {
		return entityIndex;
	}

	public void setEntityIndex(List<EntityIndex> entityIndex) {
		this.entityIndex = entityIndex;
	}
	
	
}
