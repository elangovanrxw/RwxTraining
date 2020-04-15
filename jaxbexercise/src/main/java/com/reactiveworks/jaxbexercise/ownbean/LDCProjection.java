package com.reactiveworks.jaxbexercise.ownbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LDCProjection")
public class LDCProjection {

	private String projectionFileName;
	private String projectionSource;
	private boolean required;
	
	@XmlAttribute(name="projectionFileName",required=true)
	public String getProjectionFileName() {
		return projectionFileName;
	}
	public void setProjectionFileName(String projectionFileName) {
		this.projectionFileName = projectionFileName;
	}
	
	@XmlAttribute(name="projectionSource",required=true)
	public String getProjectionSource() {
		return projectionSource;
	}
	public void setProjectionSource(String projectionSource) {
		this.projectionSource = projectionSource;
	}
	
	@XmlAttribute(name="required",required=true)
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	
}
