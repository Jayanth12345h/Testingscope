package in.Testcases;

import org.testng.annotations.Test;

import in.Pages.BaseClass;
import in.Pages.LoginPage;

public class FirstTest extends BaseClass{
 //WebDriver driver;
 
 @Test
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.enterusername(" ");
		lp.enterpassword(" ");
		lp.clickonlogin();
		
		
		
	}
}	
