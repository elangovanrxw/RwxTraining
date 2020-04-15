package com.reactiveworks.jsonexercise.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityColumns")
public class EntityColumns {

	private List<EntityColumn> entityColumn;
	
	public EntityColumns() {
		
	}
	
	@XmlElement(name="EntityColumn",type=EntityColumn.class)
	public List<EntityColumn> getEntityColumn() {
		return entityColumn;
	}

	public void setEntityColumn(List<EntityColumn> entityColumn) {
		this.entityColumn = entityColumn;
	}
	
	
}
