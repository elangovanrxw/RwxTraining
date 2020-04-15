package com.reactiveworks.jsonexercise.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityFields")

public class EntityFields {

	private List<EntityField> entityField;

	public EntityFields() {
	
	}
	
	@XmlElement(name="EntityField",required=true)
	public List<EntityField> getEntityField() {
		return entityField;
	}

	public void setEntityField(List<EntityField> entityFields) {
		this.entityField = entityFields;
	}
	
}
