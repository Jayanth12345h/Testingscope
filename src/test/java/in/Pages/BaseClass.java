package in.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import in.utilities.BrowserFactory;
import in.utilities.ConfigurationData;



public class BaseClass {

	public WebDriver driver;
	public ConfigurationData config = new ConfigurationData();

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());

	}

	@AfterClass
	public void finish() {
		BrowserFactory.quitBrowser(driver);
	}
}
