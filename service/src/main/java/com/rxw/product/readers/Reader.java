package com.rxw.product.readers;

import java.io.*;

import com.rxw.product.exception.FileHandlingException;

public class Reader {

	BufferedReader br;

	public BufferedReader getBufferredReader(String filename) throws FileHandlingException 
	{
		try
		{
			String file= filename.getClass().getResource("/"+filename).getFile();
			br = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e)
		{
			throw new FileHandlingException("System cannot find given file.",e);
		}
		return br;
	}
}
