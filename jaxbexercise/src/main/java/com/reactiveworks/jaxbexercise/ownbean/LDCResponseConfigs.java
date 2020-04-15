package com.reactiveworks.jaxbexercise.ownbean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="LDCResponseConfigs")
public class LDCResponseConfigs {

	private List<ApplyLDCConfig> applyLDCConfig;

	@XmlElement(name="ApplyLDCConfig",required=true)
	public List<ApplyLDCConfig> getApplyLDCConfig() {
		return applyLDCConfig;
	}

	public void setApplyLDCConfig(List<ApplyLDCConfig> applyLDCConfig) {
		this.applyLDCConfig = applyLDCConfig;
	}
	
	
}
