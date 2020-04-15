package com.reactiveworks.jsonexercise.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LDCSchema")
public class LDCSchema {

	private boolean required;
	private String schemaFileName;
	
	@XmlAttribute(name="required",required=true)
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	@XmlAttribute(name="schemaFileName",required=true)
	public String getSchemaFileName() {
		return schemaFileName;
	}
	public void setSchemaFileName(String schemaFileName) {
		this.schemaFileName = schemaFileName;
	}
	
	
	
	
}
