package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop;
	
	static {
		try {
			FileInputStream file = new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(file);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}

}
