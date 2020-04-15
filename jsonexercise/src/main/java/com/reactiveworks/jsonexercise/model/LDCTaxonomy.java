package com.reactiveworks.jsonexercise.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LDCTaxonomy")
public class LDCTaxonomy {

	private boolean required;

	@XmlAttribute(name="required",required=true)
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	
}
