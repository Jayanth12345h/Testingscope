package in.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestActions {
	WebDriver driver;
	// Actions action;

	@BeforeTest
	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void clickon_Fashion() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//img[@alt='Fashion']")).click();
		Actions actions = new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//span[normalize-space()='Men']"));
		actions.moveToElement(men).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Sweater']")).click();

	}

	@Test
	public void doubleclick() throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/#");
		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		//actions.scrollByAmount(0, 5);
		Thread.sleep(3000);
		actions.doubleClick(ele);  //doubleclick
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement ele2 = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(ele1,ele2); //drag and drop
		
		 WebElement targetElement = driver.findElement(By.id("someElementId"));
	       // Actions actions = new Actions(driver);
	        actions.contextClick(targetElement).perform(); //to right click 

	}

	@AfterTest
	public void closebrowser() {
		driver.close();
	}

}
