package in.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFunctionalityTest {

	WebDriver driver;

	@BeforeTest
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}

	@Test(priority = 1)
	public void positive_LoginTest() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://practicetestautomation.com/logged-in-successfully/");

	}

	@Test(priority = 2)
	public void negative_UsernameTest() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("invalidstudent");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		WebElement errormsg = driver.findElement(By.id("error"));
		Assert.assertTrue(errormsg.isDisplayed(), "Your username is invalid!");
	}

	@Test(priority = 3)
	public void negative_PasswordTest() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("invalidPassword");
		driver.findElement(By.id("submit")).click();
		WebElement errormsg = driver.findElement(By.id("error"));
		Assert.assertTrue(errormsg.isDisplayed(), "Your password is invalid!");
	}

	@AfterTest
	public void browserclose() {
		driver.close();

	}

}
