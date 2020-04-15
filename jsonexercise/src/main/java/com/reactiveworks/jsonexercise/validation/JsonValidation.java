package com.reactiveworks.jsonexercise.validation;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * A class that handles the validation of JSON against the JSON schema.
 * @author Elangovan
 *
 */
public class JsonValidation {

	/**
	 * Schema file name
	 */
	public static final String SCHEMA_FILE_NAME = "entitySchema.json";
	
	/**
	 * JSON file name.
	 */
	public static final String JSON_FILE_NAME ="entity.json";
	
	public static void main(String[] args) {
			
		doJsonValidation();
	}

	/**
	 * A method to validate the JSON data against the given schema
	 */
	private static void doJsonValidation() {
		
		JSONObject jsonSchema = new JSONObject(new JSONTokener(JsonValidation.class.getResourceAsStream("/"+SCHEMA_FILE_NAME)));
		
		JSONObject jsonData = new JSONObject(new JSONTokener(JsonValidation.class.getResourceAsStream("/"+JSON_FILE_NAME)));
		
		Schema schema = SchemaLoader.load(jsonSchema);
		
		schema.validate(jsonData);
		
		System.out.println("The JSON data is valid");
	}
}
