package in.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting {

	WebDriver driver;

	@BeforeTest
	@Parameters({"browser"})
	public void setup(String br) {
		
		switch(br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver(); break;
		case "edge":driver = new EdgeDriver(); break;
		default: System.out.println("Invalid browser"); return;
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@Test(priority = 1)
	public void testlogin() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("jay123@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		WebElement loginmsg = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
		Assert.assertEquals(loginmsg.getText(), "Login Successfully");

	}

	@Test(priority = 2)
	public void testcurreturl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/test/newtours/login_sucess.php");

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}
}
