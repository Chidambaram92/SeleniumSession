package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties propObj;

	public Properties loadPropertyFile() {
		try {
			propObj = new Properties();
			FileInputStream inputOperation = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/properties/"
					+ "config.properties");
			propObj.load(inputOperation);	
		
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return propObj;
	}
	

}
