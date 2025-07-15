package in.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	Actions actions;

	//constructor
	public LoginPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		PageFactory.initElements(driver,this);
		actions = new Actions(driver);
	}
	
	@FindBy(xpath ="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath ="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath ="//button[normalize-space()='Login']") WebElement signin;
	
	
	public void enterusername(String uname) {
		username.sendKeys(uname);
	}
	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickonlogin() {
		signin.click();
	}
	
}
