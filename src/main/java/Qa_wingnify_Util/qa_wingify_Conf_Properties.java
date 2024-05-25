
package Qa_wingnify_Util;


import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.events.EventFiringWebDriver;

@SuppressWarnings("deprecation")
public class qa_wingify_Conf_Properties {
	Properties properties;
    EventFiringWebDriver e_driver;
	String path = "/Users/yogeshadke/Documents/Qawingify/Configration_Properties/Configration File";

	// Create constructor of a class
	public qa_wingify_Conf_Properties() {
		// create object of properties
		properties = new Properties();
		// create program for import config.Properties file
		FileInputStream fis = null;
		// insert path into varieable- "fis"(clicl on surounded with try-catch option)
		try {
			fis = new FileInputStream(path);
			// load the values in "fis
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// create method to get url from config properties folder
	public String getBaseURL() // add return statement
	{
		// store this value into the String variable
		String urlvalue = properties.getProperty("BaseURL");
		if (urlvalue != null)
			return urlvalue;

		else
			throw new RuntimeException("Url not present in config");
	}

	public String getBrowsr() // add return statement
	{
		// store this value into the String variable
		String urlvalue = properties.getProperty("browser");
		if (urlvalue != null)
			return urlvalue;

		else
			throw new RuntimeException("brower not present in config");
	}

	public String getusername() {
		String username = properties.getProperty("username");
		if (username != null)
		return username;

	else
		throw new RuntimeException("Invalid Username");
}
	public String getpassword() {
		String password = properties.getProperty("password");
		if (password != null)
		return password;

	else
		throw new RuntimeException("Invalid Password");
}
	
	
	
	
}



