package in.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationData {
	Properties prop;
	//public Config config;
	
	public ConfigurationData()
	
	{
		File src = new File("./src/test/resources/config.properties");

		try {
			FileInputStream fis= new FileInputStream(src);
			prop= new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		}
	}


	public String getBrowser() {
		return prop.getProperty("browser");
	}


	public String getStagingUrl() {
		return prop.getProperty("appUrl");
	}

}
