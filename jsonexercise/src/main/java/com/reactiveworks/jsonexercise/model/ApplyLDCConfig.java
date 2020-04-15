package com.reactiveworks.jsonexercise.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ApplyLDCConfig")
@XmlType(propOrder= {"ldcSchema","ldcProjection","ldcTaxonomy"})
public class ApplyLDCConfig {

    private	String applyAt;
	private int sequence;
	private LDCSchema ldcSchema;
	private LDCProjection ldcProjection;
	private LDCTaxonomy ldcTaxonomy;
	
	@XmlAttribute(name="applyAt",required=true)
	public String getApplyAt() {
		return applyAt;
	}
	public void setApplyAt(String applyAt) {
		this.applyAt = applyAt;
	}
	
	@XmlAttribute(name="sequence",required=true)
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	@XmlElement(name="LDCSchema",nillable=false)
	public LDCSchema getLdcSchema() {
		return ldcSchema;
	}
	public void setLdcSchema(LDCSchema ldcSchema) {
		this.ldcSchema = ldcSchema;
	}
	
	@XmlElement(name="LDCProjection",nillable=false)
	public LDCProjection getLdcProjection() {
		return ldcProjection;
	}
	public void setLdcProjection(LDCProjection ldcProjection) {
		this.ldcProjection = ldcProjection;
	}
	
	@XmlElement(name="LDCTaxonomy",nillable=false)
	public LDCTaxonomy getLdcTaxonomy() {
		return ldcTaxonomy;
	}
	public void setLdcTaxonomy(LDCTaxonomy ldcTaxonomy) {
		this.ldcTaxonomy = ldcTaxonomy;
	}
	
	
}
