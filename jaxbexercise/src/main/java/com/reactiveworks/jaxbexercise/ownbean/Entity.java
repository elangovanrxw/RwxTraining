package com.reactiveworks.jaxbexercise.ownbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Entity")
@XmlType(propOrder= {"entityFields","entityCollection","entityAccessConfig"})
public class Entity {
	
	private boolean isEnable;
	private String name;
	private EntityFields entityFields;
	private EntityCollection entityCollection;
	private EntityAccessConfig entityAccessConfig;
	
	public Entity() {
	
	}
	@XmlElement(name = "EntityFields", type = EntityFields.class,required=true)
	public EntityFields getEntityFields() {
		return entityFields;
	}
	public void setEntityFields(EntityFields entityFields) {
		this.entityFields = entityFields;
	}
	
	@XmlElement(name="EntityCollection", type= EntityCollection.class)
	public EntityCollection getEntityCollection() {
		return entityCollection;
	}
	public void setEntityCollection(EntityCollection entityCollection) {
		this.entityCollection = entityCollection;
	}
	
	@XmlElement(name="EntityAccessConfig", type = EntityAccessConfig.class,required= true)
	public EntityAccessConfig getEntityAccessConfig() {
		return entityAccessConfig;
	}
	public void setEntityAccessConfig(EntityAccessConfig entityAccessConfig) {
		this.entityAccessConfig = entityAccessConfig;
	}
	
	@XmlAttribute(name="isEnable",required=true)
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	@XmlAttribute(name="name",required=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
