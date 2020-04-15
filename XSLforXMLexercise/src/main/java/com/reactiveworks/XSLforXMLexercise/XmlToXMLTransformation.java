package com.reactiveworks.XSLforXMLexercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

public class XmlToXMLTransformation {
	
	private static final Logger LOGGER = Logger.getLogger(XmlToXMLTransformation.class);
	/**
	 * Constants for input xml,xsl file.
	 */
	public static final String XML_FILE = "XmlRequest1.xml";
	public static final String XSL_FILE = "XmlResponse1.xsl";
	/**
	 * Constant for output file name.
	 */
	public static final String OUTPUT_FILE = "NewXMLResponse1.xml";
	
	/**
	 * Method used to transform the XML as per the XSL.
	 * @param xmlFile XML Input file path 
	 * @param XSLPath XSL input file path
	 */
	public void doXMLtoXML(String xmlFile, String XSLPath) {
		
		LOGGER.debug("Initiating Transformation...");
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			
			Transformer transformer = factory.newTransformer(new StreamSource(new File(XSLPath)));
			transformer.transform(new StreamSource(new File(xmlFile)),
					new StreamResult(new FileOutputStream(OUTPUT_FILE)));
			LOGGER.debug("Transformation Success...");
		}
		catch(TransformerException | IOException exp) {
			LOGGER.error("Not Transformed because : "+exp.getMessage());
		}
		
	}
	/**
	 * To initiate the transformation and load the resources.
	 * @param args
	 */
	public static void main(String[] args) {
		
		XmlToXMLTransformation transform = new XmlToXMLTransformation();
		
		String xmlFile = XmlToXMLTransformation.class.getResource("/"+XML_FILE).getFile();
		String xslFile = XmlToXMLTransformation.class.getResource("/"+XSL_FILE).getFile();
		
		transform.doXMLtoXML(xmlFile, xslFile);
	}
}
