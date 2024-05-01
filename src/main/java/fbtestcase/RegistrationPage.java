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
		enterByName(prop.getProperty("FBRegPage.Email.Namee"), email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) throws InterruptedException
	{
		enterByName(prop.getProperty("FBRegPage.NewPassword.Name"), password);
		return this;
	}
	
	public RegistrationPage setBirthDate(String birthdate)
	{
		String[] bdate = birthdate.split("/");
		selectVisibleTextById(prop.getProperty("FBRegPage.BirthMonth.ID"), bdate[0]);
		selectValueById(prop.getProperty("FBRegPage.BirthDay.ID"), bdate[1]);
		selectVisibleTextById(prop.getProperty("FBRegPage.BirthYear.ID"), bdate[2]);
		return this;
	}
	
	public RegistrationPage setGender(String gender) throws InterruptedException
	{
		clickByXPath(prop.getProperty("FBRegPage.Gender.Option.XPath").replace("$Option$", gender));
		return this;
	}
	
	

}
