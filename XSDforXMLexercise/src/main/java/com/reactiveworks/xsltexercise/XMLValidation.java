package com.reactiveworks.xsltexercise;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

//entity eventframework  featureMetaInfo 

public class XMLValidation {

	private static final Logger LOGGER = Logger.getLogger(XMLValidation.class);
	/**
	 * Constants file name variables.
	 */
	public static final String xmlFileName = "Entity.xml";
	public static final String xsdFileName = "entity.xsd";
	
	/**
	 * Method to validate xml file and xsd file
	 * @param xml The xml file needs to be validated.
	 * @param xsd The xsd file for the xml file
	 * @return true if the xml file is valid, else false.
	 */
	public static boolean doXMLValidation(String xml, String xsd) {
	
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsd));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xml)));
		}
		catch(IOException | SAXException e) {
			LOGGER.error("Exception : "+e.getMessage());
			return false;
		}
		
		return true;
	}
	public static void main(String[] args) {

		String xmlPathFile = XMLValidation.class.getResource("/"+xmlFileName).getFile();
		String xsdPathFile = XMLValidation.class.getResource("/"+xsdFileName).getFile();
		boolean result = doXMLValidation(xmlPathFile, xsdPathFile);

		LOGGER.debug("Validation Result :"+result);
	}
}
