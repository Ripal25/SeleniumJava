package fbtestcase;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class RegistrationPage extends GenericWrappers {
	
	public RegistrationPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
	}
	
	public RegistrationPage enterFirstName(String firstname) throws InterruptedException
	{
		enterByXPath(prop.getProperty("FBRegPage.FirstName.XPath"), firstname);
		return this;
	}
	
	public RegistrationPage enterLastName(String lastname) throws InterruptedException
	{
		enterByName(prop.getProperty("FBRegPage.LastName.Name"), lastname);
		return this;
	}
	
	public RegistrationPage enterEmailId(String email) throws InterruptedException
	{
		enterByName(prop.getProperty("FBRegPage.Email.Name"), email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) throws InterruptedException
	{
		enterByName(prop.getProperty("FBRegPage.NewPassword.Name"), password);
		return this;
	}
	
	public RegistrationPage setBirthDate(Integer month,String day,String year)
	{
		selectIndexById(prop.getProperty("FBRegPage.BirthMonth.ID"), month);
		selectValueById(prop.getProperty("FBRegPage.BirthDay.ID"), day);
		selectVisibleTextById(prop.getProperty("FBRegPage.BirthYear.ID"), year);
		return this;
	}
	
	public RegistrationPage setGender(String gender) throws InterruptedException
	{
		clickByXPath(prop.getProperty("FBRegPage.Gender.Option.XPath").replace("$Option$", gender));
		return this;
	}
	
	

}
