package com.reactiveworks.jaxbexercise.util;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;


public class JAXBUtility {

	private static final Logger LOGGER = Logger.getLogger(JAXBUtility.class);
	
	/**
	 * Method to do Marshalling operation. (To convert object to xml file.)
	 * @param obj object that need to convert as XML file.
	 */
	public static void doMarshalling(Object obj, String fileName) {
		
		LOGGER.debug("Converting Object to XML File ...");
		File file = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			JAXBContext contextObj = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = contextObj.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "enity.xsd");
	//		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
			marshaller.marshal(obj,fos);
			LOGGER.debug("Successfully Converted as file...");
		}
		catch(FileNotFoundException fnfexp) {
			LOGGER.error("Cannot create the file "+fileName,fnfexp);
		} catch (JAXBException e) {
			LOGGER.error("Exception occured : ",e);
		}		
	}
	
	/**
	 * Method to do UnMarshalling operation. (To convert xml to Object.)
	 * @param obj object that need to convert as XML file.
	 */
	public static Object doUnmarshalling(Object obj, String fileName) {

		LOGGER.debug("Converting XML File to object ...");
		File file = new File(fileName);
		LOGGER.debug(file.getAbsolutePath());
		try {
			FileInputStream fis = new FileInputStream(file);
			JAXBContext contextObj = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmarshaller = contextObj.createUnmarshaller();
			Object unmarshalObj = unmarshaller.unmarshal(fis);
			LOGGER.debug("Successfully Converted as object...");
			return unmarshalObj;
		}
		catch(FileNotFoundException fnfexp) {
			LOGGER.error("Cannot create the file "+fileName,fnfexp);
		} catch (JAXBException e) {
			LOGGER.error("Exception occured : ",e);
		}	
		return null;
	}
	
}
