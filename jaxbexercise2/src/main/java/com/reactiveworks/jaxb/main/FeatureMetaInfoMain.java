package com.reactiveworks.jaxb.main;

import com.reactiveworks.jaxb.bean.FeatureMetainfo;
import com.reactiveworks.jaxb.util.JAXBUtility;

public class FeatureMetaInfoMain {
	
	 public static void main(String[] args) {
		 
		FeatureMetainfo fmi = new FeatureMetainfo();
		
		fmi = (FeatureMetainfo) JAXBUtility.doUnmarshalling(fmi, "featureMetaInfo.xml");
		
		JAXBUtility.doMarshalling(fmi, "featureMetaInfo_new.xml");
	}
}
