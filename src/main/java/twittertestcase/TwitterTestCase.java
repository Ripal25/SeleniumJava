package twittertestcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import twittertestcase.Login;
import wrappers.ProjectWrappers;

public class TwitterTestCase extends ProjectWrappers {
	
	@BeforeClass
	public void beforeClass()
	{
		testCaseName = "TwitterTestCase";
		testCaseDescription="To Verify Twitter Create New User Page.";
		author="Ripal";
		category="Smoke";
		browser="chrome";
		appname="Twitter";
	}
	
	@Test
	public void TwitterCreateNewUser() throws InterruptedException
	{
		new Login(driver, test)
		.createNewAccount()
		.enterUserName("Ripal")
		.enterPhone("+919924202662")
		.selectBirthMonth(3)
		.selectBirthDay("25")
		.selectBirthYear("1994")
		.clickNextBtn();
	}

}
