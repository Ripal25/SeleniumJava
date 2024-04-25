package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fbtestcase.HomePage;
import wrappers.ProjectWrappers;

public class FBTestCase extends ProjectWrappers{
	
	@BeforeClass
	public void beforeClass()
	{
		testCaseName = "FBTestCase";
		testCaseDescription="To Verify Facebook Regsitartaion Page.";
		author="Ripal";
		category="Smoke";
		browser="chrome";
		appname="Facebook";
	}
	
	@Test
	(description="FBRegistration",enabled=true,priority = 0)
	public void FBRegistration() throws InterruptedException
	{
		new HomePage(driver, test)
		.ClickOnCreateNewAccount()
		.enterFirstName("Ripal")
		.enterLastName("Patel")
		.enterEmailId("ripalpatel2594@gmail.com")
		.enterPassword("Rip@l0908")
		.setBirthDate(3, "25", "1994")
		.setGender("Female");	
	}
	
//	@Test
//	(description="FBRegistration",enabled=true,priority = 1)
//	public void validateLogin()
//	{
//		
//	}


}
