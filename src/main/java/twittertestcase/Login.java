package twittertestcase;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrappers;

public class Login extends ProjectWrappers{
	
	public Login(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}
	
	public CreateNewAccount createNewAccount() throws InterruptedException {
		
		clickByXPath(prop.getProperty("Twitter.Home.CreateNew.XPath"));		
		return new CreateNewAccount(driver, test);
	}


}
