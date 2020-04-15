package com.reactiveworks.jsonexercise;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reactiveworks.jsonexercise.model.LeapDataServices;

/**
 * A class that handles the conversion of the given XML document
 * to the JSON document.
 * @author Elangovan
 *
 */
public class XmlToJsonConverter {

	/**
	 * XML File name.
	 */
	public static final String XML_FILE = "Entity.xml";
	
	public static void main(String[] args) throws JAXBException, IOException {		
		convertXMLToJson();		
	}

	/**
	 * A method to convert the given XML document into the JSOn document.
	 * @throws JAXBException if any exception occurs while unmarshalling.
	 * @throws IOException if any exception occurs while processing the file read/write.
	 */
	private static void convertXMLToJson() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(LeapDataServices.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		LeapDataServices leapDataServices = (LeapDataServices) unmarshaller.unmarshal(XmlToJsonConverter.class.getResourceAsStream("/"+XML_FILE));
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		
		FileWriter fw = new FileWriter("entity.json");
		Gson gson = builder.create();
		String entityJson = gson.toJson(leapDataServices, LeapDataServices.class);
		fw.write(entityJson);
		fw.close();
		System.out.println("JSON Successfully created.");
	}

}
