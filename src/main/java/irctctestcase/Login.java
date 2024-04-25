package irctctestcase;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class Login extends GenericWrappers{
	
	public Login(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}
	
	
	public Registration clickOnRegistorBtn() throws InterruptedException
	{
		clickByXPath(prop.getProperty("IRCTC.RegistorBtn.XPath"));
		
		return new Registration(driver, test);
	}
	
	
}