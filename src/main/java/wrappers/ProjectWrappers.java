package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers {

	public String browser;
	public String appname;

	@BeforeSuite
	public void BeforeSuit() {
		StartReport();
	}

	@BeforeTest
	public void beforeTest() {
		loadObjects();
	}

	@BeforeMethod
	public void beforeMethod() {
		startTest(testCaseName, testCaseDescription);
		if(appname.equalsIgnoreCase("Facebook"))
		{
			invokeApp(browser, "https://www.facebook.com");
		}
		else if(appname.equalsIgnoreCase("IRCTC"))
		{
			invokeApp(browser, "https://www.irctc.co.in/nget/train-search");
		}
		else if(appname.equalsIgnoreCase("Twitter"))
		{
			invokeApp(browser, "https://twitter.com");	
		}
		//waitDriver(3000);
	}

	@AfterMethod
	public void afterMethod() {
		closeDriver();
	}

	@AfterClass
	public void afterClass() {
		endTest();
	}

	@AfterTest
	public void afterTest() {
		unloadObjects();
	}

	@AfterSuite
	public void afterSuit() {
		endReport();
	}

}
