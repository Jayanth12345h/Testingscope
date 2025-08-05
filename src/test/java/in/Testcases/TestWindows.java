package in.Testcases;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestWindows {
	WebDriver driver;

	@Test
	public void windowhandling() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
		driver.getWindowHandle();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[normalize-space()='API Testing'])[1]")).click();
		
		
	}
}
