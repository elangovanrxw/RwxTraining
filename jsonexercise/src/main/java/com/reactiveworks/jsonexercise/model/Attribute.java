package com.reactiveworks.jsonexercise.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Attribute")
public class Attribute {

	private String name;
	private String value;
	private String attributeDatatype;
	private String type;
	private int size;
	
	public Attribute() {
	
	}
	@XmlAttribute(name="size")
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@XmlAttribute(name="name",required=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="value",required=true)
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@XmlAttribute(name="attributeDatatype")
	public String getAttributeDatatype() {
		return attributeDatatype;
	}
	public void setAttributeDatatype(String attributeDatatype) {
		this.attributeDatatype = attributeDatatype;
	}
	
	@XmlAttribute(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
