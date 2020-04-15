package com.reactiveworks.jsonexercise.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="EntityAccessConfig")
@XmlType(propOrder= {"entityTable","entityAccess"})
public class EntityAccessConfig {
	
	private String type;
	private List<EntityTable> entityTable;
	private List<EntityAccess> entityAccess;
	
	public EntityAccessConfig() {
	
	}

	@XmlAttribute(name="type",required=true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name="EntityTable",required=true)
	public List<EntityTable> getEntityTable() {
		return entityTable;
	}

	public void setEntityTable(List<EntityTable> entityTable) {
		this.entityTable = entityTable;
	}

	@XmlElement(name="EntityAccess",required=true)
	public List<EntityAccess> getEntityAccess() {
		return entityAccess;
	}

	public void setEntityAccess(List<EntityAccess> entityAccess) {
		this.entityAccess = entityAccess;
	}
	
	
}
