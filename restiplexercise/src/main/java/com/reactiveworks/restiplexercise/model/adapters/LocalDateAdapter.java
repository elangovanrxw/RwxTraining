package com.reactiveworks.restiplexercise.model.adapters;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * A class which is used for the xml conversion for the LocalDate class.
 * @author Elangovan
 *
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	/**
	 * Overrided method to unmarshal the data.
	 * @param v the string to be unmarshalled.
	 */
	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	/**
	 * Overrided method to marshal the data.
	 * @param v the LocalDate which needs to be marshalled.
	 */
	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}

}
