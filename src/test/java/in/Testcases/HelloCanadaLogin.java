package in.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import in.Pages.BaseClass;

public class HelloCanadaLogin extends BaseClass {

	@Test
	public void testEmptySubmission() {
		WebElement loginbtn = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		loginbtn.click();
		WebElement emailerror = driver.findElement(By.xpath("//div[contains(text(),'Email is required')]"));
		// Assert.assertTrue(emailerror.isDisplayed(),"Email error message not
		// displayed");
		Assert.assertEquals(emailerror.getText(), "Email is required");
		WebElement passworderror = driver.findElement(By.xpath("//div[contains(text(),'Password is required')]"));
		Assert.assertEquals(passworderror.getText(), "Password is required");

	}

	@Test
	public void testInvalidData() {
		driver.findElement(By.id("iuname")).sendKeys("jay76");
		WebElement emailerror = driver.findElement(By.xpath("//div[contains(text(),'Please enter valid Email Id')]"));
		Assert.assertEquals(emailerror.getText(), "Please enter valid Email Id");
		driver.findElement(By.id("ipwd")).sendKeys("jayfg");
		WebElement pwderror = driver
				.findElement(By.xpath("//div[contains(text(),'Password length should be between 8 to 20 characte')]"));
		  if(pwderror.isDisplayed()) {
			  System.out.println("pwderror is displayed:"+pwderror.getText());
		  } else {
			  System.out.println("No error message dispalyed");
		  }
		
		//Assert.assertEquals(pwderror.getText(), "Password length should be between 8 to 20 characters");
	}

}
