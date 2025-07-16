package in.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {
	WebDriver driver;

	@BeforeTest
	public void browsersetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test (dataProvider = "dp")
	public void loginTest(String email, String pwd) throws InterruptedException {
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		WebElement loginmsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
		Assert.assertEquals(loginmsg.getText(), "Login Successfully");
		boolean status = driver.findElement(By.xpath("//a[normalize-space()='SIGN-OFF']")).isDisplayed();
		
		if(status==true) {			
		driver.findElement(By.xpath("//a[normalize-space()='SIGN-OFF']")).click();
		Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}

	}

	@AfterTest
	public void browserteardown() {
		driver.close();

	}
	
	@DataProvider (name="dp", indices = {0,1})
	Object[][] loginData() {
		Object Data[][]= { 
				           {"jay123@gmail.com", "12345"},
				           {"jay1234@gmail.com", "12345"},
				           {"jay12345@gmail.com", "12345"},
				
		                 };
		return Data;
		
	}
}
