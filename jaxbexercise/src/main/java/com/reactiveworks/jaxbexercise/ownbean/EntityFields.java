package com.reactiveworks.jaxbexercise.ownbean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityFields")

public class EntityFields {

	private List<EntityField> entityFields;

	public EntityFields() {
	
	}
	
	@XmlElement(name="EntityField",required=true)
	public List<EntityField> getEntityFields() {
		return entityFields;
	}

	public void setEntityFields(List<EntityField> entityFields) {
		this.entityFields = entityFields;
	}
	
}
