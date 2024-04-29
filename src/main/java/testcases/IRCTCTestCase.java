package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import irctctestcase.Login;
import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class IRCTCTestCase extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass()
	{
		testCaseName = "IRCTCTestCase";
		testCaseDescription="To Verify IRCTC Regsitartaion Page.";
		author="Ripal";
		category="Smoke";
		browser="chrome";
		appname="IRCTC";
		excelfilepath="./testdata/IRCTCTest.xlsx";
	}
	
	@Test
	(description="IRCTCRegistration",enabled=true,priority = 0,dataProvider = "ExcelDataProvider",dataProviderClass = GenericWrappers.class)
	public void IRCTCRegistration() throws InterruptedException
	{
		new Login(driver, test)
		.clickOnRegistorBtn()
		.enterUserName("Ripal")
		.enterPassword("Rip@l0908")
		.selectPrefLang("English")
		.selectSecurityQue("Who was your Childhood hero?")
		.enterSecurityAns("Dad");
	}
	
}
