package twittertestcase;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrappers;

public class CreateNewAccount extends ProjectWrappers{
	
	public CreateNewAccount(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}

	public CreateNewAccount enterUserName(String username) throws InterruptedException
	{
		enterByXPath(prop.getProperty("Twitter.Registration.Name.XPath"), username);
		return this;
	}
	
	public CreateNewAccount enterEmail(String email) throws InterruptedException
	{
		enterByXPath(prop.getProperty("Twitter.Registration.Email.XPath"), email);
		return this;
	}
	
	public CreateNewAccount enterPhone(String phone) throws InterruptedException
	{
		enterByXPath(prop.getProperty("Twitter.Registration.Phone.XPath"), phone);
		return this;
	}
	
	public CreateNewAccount selectBirthMonth(Integer month) throws InterruptedException
	{
		selectIndexById(prop.getProperty("Twitter.Registration.BirthMonth.ID"), month);
		return this;
	}
	
	public CreateNewAccount selectBirthDay(String day) throws InterruptedException
	{
		selectValueById(prop.getProperty("Twitter.Registration.BirthDay.ID"), day);
		return this;
	}
	
	public CreateNewAccount selectBirthYear(String year) throws InterruptedException
	{
		selectVisibleTextById(prop.getProperty("Twitter.Registration.BirthYear.ID"), year);
		return this;
	}
	
	public CreateNewAccount clickNextBtn() throws InterruptedException
	{
		clickByXPath(prop.getProperty("Twitter.Registration.Next.XPath"));
		return this;
	}
	
	
}
