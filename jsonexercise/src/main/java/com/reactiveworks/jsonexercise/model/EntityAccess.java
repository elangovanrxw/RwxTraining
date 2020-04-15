package com.reactiveworks.jsonexercise.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityAccess")
public class EntityAccess {
	
	//Attributes
	private String accessMethod;
	private String accessType;
	private String authorizedResource;
	private boolean isCollection;
	
	//Elements
	private EntityReadKeysMapping entityReadKeysMapping;
	private EntityInsertKeysMapping entityInsertKeysMapping;
	private EntityUpdateKeysMapping entityUpdateKeysMapping;
	private EntityFilterKeysMapping entityFilterKeysMapping;
	private LDCResponseConfigs ldcResponseConfigs;
	
	public EntityAccess() {
	
	}
	
	@XmlAttribute(name="accessMethod",required=true)
	public String getAccessMethod() {
		return accessMethod;
	}
	public void setAccessMethod(String accessMethod) {
		this.accessMethod = accessMethod;
	}
	
	@XmlAttribute(name="accessType",required=true)
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	
	@XmlAttribute(name="authorizedResource",required=true)
	public String getAuthorizedResource() {
		return authorizedResource;
	}
	public void setAuthorizedResource(String authorizedResource) {
		this.authorizedResource = authorizedResource;
	}
	
	@XmlAttribute(name="isCollection")
	public boolean isCollection() {
		return isCollection;
	}
	public void setCollection(boolean isCollection) {
		this.isCollection = isCollection;
	}
	
	@XmlElement(name="EntityReadKeysMapping",type=EntityReadKeysMapping.class)
	public EntityReadKeysMapping getEntityReadKeysMapping() {
		return entityReadKeysMapping;
	}
	public void setEntityReadKeysMapping(EntityReadKeysMapping entityReadKeysMapping) {
		this.entityReadKeysMapping = entityReadKeysMapping;
	}
	
	@XmlElement(name="EntityInsertKeysMapping",type=EntityInsertKeysMapping.class)
	public EntityInsertKeysMapping getEntityInsertKeysMapping() {
		return entityInsertKeysMapping;
	}

	public void setEntityInsertKeysMapping(EntityInsertKeysMapping entityInsertKeysMapping) {
		this.entityInsertKeysMapping = entityInsertKeysMapping;
	}
	
	@XmlElement(name="EntityUpdateKeysMapping",type=EntityUpdateKeysMapping.class)
	public EntityUpdateKeysMapping getEntityUpdateKeysMapping() {
		return entityUpdateKeysMapping;
	}

	public void setEntityUpdateKeysMapping(EntityUpdateKeysMapping entityUpdateKeysMapping) {
		this.entityUpdateKeysMapping = entityUpdateKeysMapping;
	}
	
	@XmlElement(name="EntityFilterKeysMapping",type=EntityFilterKeysMapping.class)
	public EntityFilterKeysMapping getEntityFilterKeysMapping() {
		return entityFilterKeysMapping;
	}
	public void setEntityFilterKeysMapping(EntityFilterKeysMapping entityFilterKeysMapping) {
		this.entityFilterKeysMapping = entityFilterKeysMapping;
	}
	
	@XmlElement(name="LDCResponseConfigs",type=LDCResponseConfigs.class)
	public LDCResponseConfigs getLdcResponseConfigs() {
		return ldcResponseConfigs;
	}
	public void setLdcResponseConfigs(LDCResponseConfigs ldcResponseConfigs) {
		this.ldcResponseConfigs = ldcResponseConfigs;
	}
}
