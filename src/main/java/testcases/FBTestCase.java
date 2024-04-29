package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fbtestcase.HomePage;
import wrappers.GenericWrappers;
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
		excelfilepath = "./testdata/FBTest.xlsx";
		excelsheetnumber = "0";
	}
	
	@Test
	(description="FBRegistration",enabled=true,priority = 0,dataProvider = "ExcelDataProvider",dataProviderClass = GenericWrappers.class)
	public void FBRegistration(String firstname, String lastname, String emailid, String password, String birthdate, String gender) throws InterruptedException
	{
		new HomePage(driver, test)
		.ClickOnCreateNewAccount()
		.enterFirstName(firstname)
		.enterLastName(lastname)
		.enterEmailId(emailid)
		.enterPassword(password)
		.setBirthDate(birthdate)
		.setGender(gender);	
	}
	
//	@Test
//	(description="FBRegistration",enabled=true,priority = 1)
//	public void validateLogin()
//	{
//		
//	}


}
