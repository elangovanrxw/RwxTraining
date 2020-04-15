package com.reactiveworks.jsonexercise.jsonpath;

import java.util.Scanner;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

/**
 * A class which handles the fetching of data from the JSON document 
 * for the given JSON path.
 * @author Elangovan
 *
 */
public class EntityJsonPath {

	/**
	 * JSON File name.
	 */
	public static final String JSON_FILE_NAME = "entity.json";
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter JSON path : ");
		String jsonPath = scan.next();
		scan.close();
		System.out.println(fetchDataForPath(jsonPath));
	}

	/**
	 * A method that returns the data from the JSON document
	 * for the given JSON path.
	 * @param jsonPath The JSON path to be passed inside this method.
	 * @return the data for the given JSON path.
	 */
	private static Object fetchDataForPath(String jsonPath) {
		DocumentContext jsonContext = JsonPath.parse(EntityJsonPath.class.getResourceAsStream("/"+JSON_FILE_NAME));
		JsonPath path = JsonPath.compile(jsonPath);		//Compile the given JSON path
		Object data = jsonContext.read(path); 		//Read data for the given JSON path.
		return data;
	}
}
