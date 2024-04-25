package irctctestcase;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class Registration extends GenericWrappers{
	
	public Registration(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}

	public Registration enterUserName(String userName) throws InterruptedException
	{
		enterByXPath(prop.getProperty("IRCTC.Registration.UserName.XPath"), userName);
		return this;
	}
	
	public Registration enterPassword(String pasword) throws InterruptedException
	{
		enterByXPath(prop.getProperty("IRCTC.Registration.Password.XPath"), pasword);
		
		enterByXPath(prop.getProperty("IRCTC.Registration.CnfPassword.XPath"), pasword);
		
		return this;
	}
	
	public Registration selectPrefLang(String language) throws InterruptedException
	{
		clickByXPath(prop.getProperty("IRCTC.Registration.PreferredLanguage.XPath"));
		clickByXPath(prop.getProperty("IRCTC.Registration.PreferredLanguage.Option.XPath").replace("$Option$", language));
		return this;
	}
	
	
	public Registration selectSecurityQue(String Secque) throws InterruptedException
	{
		clickByXPath(prop.getProperty("IRCTC.Registration.SecurityQue.XPath"));
		clickByXPath(prop.getProperty("IRCTC.Registration.SecurityQue.Option.XPath").replace("$Option$", Secque));
		return this;
	}
	
	public Registration enterSecurityAns(String Secans) throws InterruptedException
	{
		clickByXPath(prop.getProperty("IRCTC.Registration.SecurityQue.Option.XPath"));
		return this;
	}
	
}