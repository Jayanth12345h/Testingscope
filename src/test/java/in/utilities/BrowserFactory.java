package in.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public WebDriver driver;

	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl)
	{

		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}

		else if(browserName.equals("EDGE"))
		{
			driver = new EdgeDriver();
		}

		else if(browserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}

		else
		{
			System.out.println("We do not support this browser ");
		}


		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;


	}

	public static void quitBrowser(WebDriver driver)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
		
	}

