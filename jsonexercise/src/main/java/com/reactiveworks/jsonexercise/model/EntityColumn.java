package com.reactiveworks.jsonexercise.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EntityColumn")
public class EntityColumn {

	private List<Attribute> attribute;
	private String entityFieldNameRef; 
	private boolean hasAutoIncrement;
	private String name;  
	private int sequence;
	
	public EntityColumn() {
		
	}
	
	@XmlAttribute(name="entityFieldNameRef",required=true)
	public String getEntityFieldNameRef() {
		return entityFieldNameRef;
	}

	public void setEntityFieldNameRef(String entityFieldNameRef) {
		this.entityFieldNameRef = entityFieldNameRef;
	}

	@XmlAttribute(name="hasAutoIncrement")
	public boolean isHasAutoIncrement() {
		return hasAutoIncrement;
	}

	public void setHasAutoIncrement(boolean hasAutoIncrement) {
		this.hasAutoIncrement = hasAutoIncrement;
	}

	@XmlAttribute(name="name",required=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name="sequence")
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	@XmlElement(name="Attribute",required=true)
	public List<Attribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}
	
	
}
