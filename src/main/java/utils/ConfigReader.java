package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties props;
	
	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config/Config.properties");
			props = new Properties();
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String Key) {
		return props.getProperty(Key);
	}

}
