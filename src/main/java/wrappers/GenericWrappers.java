package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reporting;

public class GenericWrappers extends Reporting implements wrappers {

	public static RemoteWebDriver driver;
	public static Properties prop;
	
	@Override
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.get(url);

			driver.manage().window().maximize();

			// System.out.println(browser + "launched succesfully");
			reportStep("The browser" + browser + "is launched with the given url " + url + " succesfully.", "Pass");

		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			// System.err.println(browser + " is not launched due to session not created
			// error.");
			reportStep("The Browser " + browser + " is not launched  with given url " + url
					+ " due to session not created error.", "Fail");
		} catch (InvalidArgumentException e) {
			// TODO: handle exception
			// System.err.println(browser + "is not launched because urlnot contains
			// https/http.");
			reportStep(
					"The Browser " + browser + " is not launched  with given url " + url + " not contains https/http.",
					"Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			// System.err.println(browser + "is not launched due to unknown error.");
			reportStep("The Browser " + browser + " is not launched  with given url " + url + " due to unknown error.",
					"Fail");
		}
	}

	@Override
	public void enterById(String IdVal, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(IdVal)).sendKeys(data);
			//System.out.println(data + "is entered in ID >> " + IdVal);
			reportStep("The element with ID "+IdVal+ " is entered with data "+data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not found. Please correct locator.");
			reportStep("The element with ID "+IdVal+ " is not found in the DOM.", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not intractable in the application.");
			reportStep("The element with ID "+IdVal+ " is not intractable in the application.", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not stale in the application.");
			reportStep("The element with ID "+IdVal+ " is not stale in the application.", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not entering value because of  unknown error.");
			reportStep("The element with ID "+IdVal+ " is not entering value because of  unknown error.", "Fail");
		}
	}

	@Override
	public void enterByName(String NameVal, String data) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
			driver.findElement(By.name(NameVal)).sendKeys(data);
			//System.out.println(data + "is entered in Name  >> " + NameVal);
			reportStep("The element with name"+NameVal+ " is entered with data "+data, "Pass");
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not found. Please correct locator.");
			reportStep("The element with Name "+NameVal+ " is not found in the DOM.", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not interactable in the application.");
			reportStep("The element with Name "+NameVal+ " is not interactable in the application.", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not stale in the application.");
			reportStep("The element with Name "+NameVal+ " is not stale in the application.", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
			reportStep("The element with Name "+NameVal+ " is not entering value because of  unknown error.", "Fail");
		}
	}

	@Override
	public void enterByXPath(String xpathVal, String data) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(xpathVal)).sendKeys(data);
			//System.out.println(data + "is entered in XPath >> " + xpathVal);
			reportStep("The element with XPath "+xpathVal+ " is entered with data "+data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not found. Please correct locator.");
			reportStep("The element with XPAth "+xpathVal+ " is not found in the DOM.", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not interactable in the application.");
			reportStep("The element with XPAth "+xpathVal+ " is not interactable in the application.", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not stale in the application.");
			reportStep("The element with XPAth "+xpathVal+ " is not stale in the application.", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
			reportStep("The element with XPAth "+xpathVal+ " is not entering value because of  unknown error.", "Fail");
		}
	}

	@Override
	public void clickById(String IdVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(IdVal)).click();
			//System.out.println("Element is clicakble with ID >> " + IdVal);
			reportStep("The element with ID "+IdVal+ " is clicked succesfully.", "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not found. Please correct locator.");
			reportStep("The element with ID "+IdVal+ " is not found in the DOM.", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not click Intercepted in the application.");
			reportStep("The element with ID "+IdVal+ " is not click Intercepted in the application.", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not interactable in the application.");
			reportStep("The element with ID "+IdVal+ " is not click interactable in the application.", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not stale in the application.");
			reportStep("The element with ID "+IdVal+ " is not click stale in the application.", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
			reportStep("The element with ID "+IdVal+ " is not entering value because of  unknown error.", "Fail");

		}
	}

	@Override
	public void clickByName(String NameVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(NameVal)).click();
			//System.out.println("Element is clicakble with Name >> " + NameVal);
			reportStep("The element with Name "+NameVal+ " is clicked succesfully.", "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not found. Please correct locator.");
			reportStep("The element with Name "+NameVal+ " is not found.", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not click interactable in the application.");
			reportStep("The element with Name "+NameVal+ " is not click interactable in the application.", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not interactable in the application.");
			reportStep("The element with Name "+NameVal+ " is not click interactable in the application.", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not stale in the application.");
			reportStep("The element with Name "+NameVal+ " is not stale in the application.", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
			reportStep("The element with Name "+NameVal+ " is not entering value beacuse of  unknown error.", "Fail");
		}
	}

	@Override
	public void clickByXPath(String xpathVal) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(xpathVal)).click();
			//System.out.println("Element is clicakble with XPath >> " + xpathVal);
			reportStep("The element with XPath "+xpathVal+ " is clicked succesfully.", "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not found. Please correct locator.");
			reportStep("The element with XPath "+xpathVal+ " is not found.", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not click interactable in the application.");
			reportStep("The element with XPath "+xpathVal+ " is not click interactable in the application.", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not interactable in the application.");
			reportStep("The element with XPath "+xpathVal+ " is not click interactable in the application.", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not stale in the application.");
			reportStep("The element with XPath "+xpathVal+ " is not stale in the application.", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
			reportStep("The element with XPath "+xpathVal+ " is not entering value beacuse of  unknown error.", "Fail");
		}
	}
	

	@Override
	public void clickByCssselVal(String cssselVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(cssselVal)).click();
			//System.out.println("Element is clicakble with XPath >> " + cssselVal);
			reportStep("The element with CSSSelVal "+cssselVal+ " is clicked succesfully.", "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not found. Please correct locator.");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not click interactable in the application.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(cssselVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectVisibleTextById(String IdVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.id(IdVal))).selectByVisibleText(data);
//		WebElement selwebelement = driver.findElement(By.id(IdVal));
//		Select selmonth = new Select(selwebelement);
//		selmonth.selectByVisibleText(data);
			//System.out.println("Element with" + IdVal + " is selected by VisibleText with " + data);
			reportStep("The element with ID "+IdVal+ " is selected by VisibleText with " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element Select by VisibleText is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectValueById(String IdVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.id(IdVal))).selectByValue(data);
			//System.out.println("Element with" + IdVal + " is selected using Value of " + data);
			reportStep("The element with ID "+IdVal+ " is selected by Value with " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element Select by Value is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectIndexById(String IdVal, int index) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.id(IdVal))).selectByIndex(index);
			//System.out.println("Element with" + IdVal + " is selected with index of " + index);
			reportStep("The element with ID "+IdVal+ " is selected with index of " + index, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element Select by Index is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(IdVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectVisibleTextByName(String NameVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.id(NameVal))).selectByVisibleText(data);
			//System.out.println("Element with" + NameVal + " is selected by VisibleText with " + data);
			reportStep("The element with Name "+NameVal+ " is selected by VisibleText with " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element Select by VisibleText is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectValueByName(String NameVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.name(NameVal))).selectByValue(data);
			//System.out.println("Element with" + NameVal + " is selected using Value of " + data);
			reportStep("The element with Name "+NameVal+ " is selected sing value of " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element Select by Value is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectIndexByName(String NameVal, int index) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.name(NameVal))).selectByIndex(index);
			//System.out.println("Element with" + NameVal + " is selected with index of " + index);
			reportStep("The element with Name "+NameVal+ " is selected with index of " + index, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element Select by Index is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(NameVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectVisibleTextByXPath(String xpathVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.xpath(xpathVal))).selectByVisibleText(data);
			//System.out.println("Element with" + xpathVal + " is selected by VisibleText with " + data);
			reportStep("The element with "+xpathVal+ " is selected by VisibleText with " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element Select by VisibleText is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectValueByXPath(String xpathVal, String data) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.xpath(xpathVal))).selectByValue(data);
			//System.out.println("Element with" + xpathVal + " is selected using Value of " + data);
			reportStep("The element with XPath "+xpathVal+ " is selected using value of " + data, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element Select by Value is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	@Override
	public void selectIndexByXPath(String xpathVal, int index) {
		// TODO Auto-generated method stub
		try {
			new Select(driver.findElement(By.xpath(xpathVal))).selectByIndex(index);
			//System.out.println("Element with" + xpathVal + " is selected with index of " + index);
			reportStep("The element with XPath "+xpathVal+ " is selected with index " + index, "Pass");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element Select by Index is not found. Please correct locator.");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not interactable in the application.");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not stale in the application.");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println(xpathVal + " Element is not entering value beacuse of  unknown error.");
		}
	}

	
	public void waitDriver(long time) {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(time);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
			//System.out.println("Diver Wait is performing with " + time);
			//reportStep("Diver Wait is performing with given time.", "Pass");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Something went wrong while waitngdriver.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Thread is intreptted.");

		}
	}

	@Override
	public void closeDriver() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			//System.out.println("Driver Quit Succefully.");
			//reportStep("Driver Quit Succefully.", "Pass");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Unknow error while quit driver.");
		}
	}

	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		long number = 0;

		try {

			number = (long) (Math.floor(Math.random() * 100000000) + 100000);
			File temp = driver.getScreenshotAs(OutputType.FILE);

			File dest = new File("./reports/screenshots/" + number + ".jpg");
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// System.err.println("I/O exception occurs due to unknown error");
			reportStep("I/O exception occurs due to unknown error", "fail");

		} catch (WebDriverException e) {
			// TODO: handle exception
			// System.err.println("The snap not taking due to unknown error");
			reportStep("The snap not taking due to unknown error", "fail");
		}
		return number;

	}
	
public void loadObjects(){
		
		try {
			 prop = new Properties();	
			prop.load(new FileInputStream("./src/test/java/object.properties"));
			//prop.load(new FileInputStream("C:/Users/nups1/eclipse-workspace/hybridmodel/src/test/java/object.properties"));
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void unloadObjects(){
		
		prop=null;
	}


}