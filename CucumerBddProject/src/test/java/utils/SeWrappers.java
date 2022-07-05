package utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;

import gluecode.Hooks;




public class SeWrappers {

	//	public static WebDriver driver;
	String browser = null;
	//Base class configuration file
	//	protected static Properties prop = new Properties();
	//packages page configuration file 
	protected static Properties packagesProperties = new Properties();

	File baseConfigFile = new File("configuration/config.properties");
	File packageConfig = new File("configuration/packages.properties");
	public WebDriverWait wait;
	WebElement highlightElement;
	// protected ITestContext suites;
	public static String environment= null;

	// public static ExtentReports extentReport;

	// public static ExtentTest extentTest;
	FluentWait<WebDriver> waiter;

	// Reports ;
	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;
	public static String reportlocation = "/reports/";

	//Packages page input
	protected static String packagesPageEnv = null;
	protected static int packageItineraries,vacationItineraries=0;
	public static RemoteWebDriver driver1;
	public static WebDriver driver;
	public static String sUrl,pUrl,uUrl,dUrl,sHubUrl,sHubPort,regname,username,pass,browserName,
	regemail,newuser,newemail,newmobile,invalidUser,invalidPassword,
			addluser, addlemail, addlmobile, cbrName, cbrMobile, cbrMail, vacationsNo, changeName, address1, address2,
			address3, state, pincode, adminUser, adminPassword, fromMail, toMail1, toMail2, toMail3, toMail4,toMail5, ccMail1,
			ccMail2, sendGridKey,automationUrl,localEnvUrl,costedItineraryPrice,costedItineraryPriceCompare,bookedItineraryPrice,bookedItineraryPriceCompare,deltaUrl,googleSearchConsoleUrl;

	protected Properties prop;
	public static boolean browserVal=false;



	public SeWrappers() {
		prop = new Properties();
		try {
			
			prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"/configuration/config.properties")));
			//			System.out.println("Properties loaded");
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("stageUrl");
			pUrl = prop.getProperty("prodUrl");
			uUrl = prop.getProperty("uatUrl");
			dUrl = prop.getProperty("devUrl");
			automationUrl = prop.getProperty("automationUrl");
			browserName=prop.getProperty("browser");
			adminUser = prop.getProperty("Admin_User");
			adminPassword = prop.getProperty("Admin_Password");
			username=prop.getProperty("Registered_User");
			pass=prop.getProperty("Registered_Password");
			regname=prop.getProperty("Registered_Name");
			regemail=prop.getProperty("Registered_Email");
			newuser = prop.getProperty("New_Username");
			newemail = prop.getProperty("New_Email");
			newmobile = prop.getProperty("New_Mobile");
			addluser = prop.getProperty("New_Addl_User");
			addlemail = prop.getProperty("New_Addl_Email");
			addlmobile = prop.getProperty("New_Addl_Mobile");
			invalidUser = prop.getProperty("Invalid_User");
			invalidPassword = prop.getProperty("Invalid_Password");
			cbrName=prop.getProperty("cbrName");
			cbrMobile=prop.getProperty("cbrMobileNumber");
			cbrMail=prop.getProperty("cbrEmail");
			vacationItineraries=Integer.parseInt(prop.getProperty("vacationsItinerariesNumber"));
			packageItineraries=Integer.parseInt(prop.getProperty("packageItinerariesNumber"));
			changeName=prop.getProperty("newName");
			address1=prop.getProperty("address1");
			address2=prop.getProperty("address2");
			address3=prop.getProperty("address3");
			state=prop.getProperty("state");
			pincode=prop.getProperty("pincode");
			fromMail = prop.getProperty("fromMail");
			toMail1 = prop.getProperty("toMail1");
			toMail2 = prop.getProperty("toMail2");
			toMail3 = prop.getProperty("toMail3");
			toMail4 = prop.getProperty("toMail4");
			toMail5 = prop.getProperty("toMail5");
			ccMail1 = prop.getProperty("ccMail1");
			ccMail2 = prop.getProperty("ccMail2");
			sendGridKey = prop.getProperty("sendGridKey");
			costedItineraryPrice=prop.getProperty("costedItineraryPrice");
			costedItineraryPriceCompare=prop.getProperty("costedItineraryPriceCompare");
			bookedItineraryPrice=prop.getProperty("bookedItineraryPrice");
			bookedItineraryPriceCompare=prop.getProperty("bookedItineraryPriceCompare");
			deltaUrl = prop.getProperty("deltaUrl");
			googleSearchConsoleUrl=prop.getProperty("googleSearchConsoleUrl");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void startApp(String browser, boolean bRemote, String env) {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
//			dc.setBrowserName(browser);
			dc.setBrowserName(BrowserType.CHROME);
//			dc.setPlatform(Platform.MAC);
			System.out.println("Hub: "+sHubUrl);
			System.out.println("Port: "+sHubPort);
			// this is for grid run
			if(bRemote)
			{
				try {
					driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				} 
				catch (MalformedURLException e) {
				}
			}
			else{ // this is for local run
				
				
				if(sUrl == null)
				{
				
					//Give you set of Threads
					Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();
					
					System.out.println("Live threads"+setOfThread.size());
	
					//Iterate over set to find yours
					for(Thread thread : setOfThread){
					    if(thread.getId()==Hooks.threadId){
					        thread.interrupt();
					    }
					}
				}
				
				
				
				if(browser.equalsIgnoreCase("chrome")){
//					System.setProperty("webdriver.chrome.driver","driver/chromedriver");
//					ChromeOptions chromeOptions = new ChromeOptions();
//					chromeOptions.addArguments("headless");
//					chromeOptions.addArguments("window-size=1200x600");
//					System.setProperty("webdriver.chrome.silentOutput", "true");
//					driver= new ChromeDriver(chromeOptions);
					//driver= new ChromeDriver();
					
					

				System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver= new ChromeDriver(chromeOptions);
					//System.out.println("Launched chrome");
					browserVal=true;

				}
			else if(browser.equalsIgnoreCase("chromeLocal")){
					System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("headless");
					chromeOptions.addArguments("window-size=1200x600");
					chromeOptions.addArguments("--disable-notifications");
					System.setProperty("webdriver.chrome.silentOutput", "true");
					driver= new ChromeDriver(chromeOptions);
////					driver= new ChromeDriver();
//					
//					
//
////					System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
////					driver = new ChromeDriver();
//					
//					//					System.out.println("Launched chrome");
//					browserVal=true;
//
				}
//				
				else if (browser.equalsIgnoreCase("mobchrome")) {// This for mobile web
					String DeviceName = "Galaxy S5";
					System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

					Map<String, Object> mobileEmulation = new HashMap<String, Object>();
					mobileEmulation.put("deviceName", "Galaxy S5");
					Map<String, Object> chromeOptions = new HashMap<String, Object>();
					chromeOptions.put("mobileEmulation", mobileEmulation);
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
					driver = new ChromeDriver(capabilities);
				}else if (browser.equalsIgnoreCase("firefox")) {

					System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
					driver = new FirefoxDriver();
					browserVal=true;

				}
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			switch(env.toLowerCase()) {
			case "staging":
			{
				System.out.println(env+" Environment URL is "+sUrl);
				if(sUrl!=null)
				{
					driver.get(sUrl);
					localEnvUrl=sUrl;
					break;
				}
				else
				{
					System.out.println("Staging Environment Url is Null");
					break;
				}
			}
			case "prod":
			{
				System.out.println(env+" Environment URL is "+pUrl);
				if(pUrl != null)
				{
					driver.get(pUrl);
					localEnvUrl=pUrl;
					break;
				}
				else
				{
					System.out.println("Prod Environment Url is Null");
					break;
				}
	
			}
			case "uat":{
				System.out.println(env+" Environment URL is "+uUrl);
				if(uUrl != null)
				{
					driver.get(uUrl);
					localEnvUrl=uUrl;
					break;
				}
				else
				{
					System.out.println("Uat Environment Url is Null");
					break;
				}
			}
			case "dev":{
				System.out.println(env+" Environment URL is "+dUrl);
				if(dUrl != null)
				{
					driver.get(dUrl);
					localEnvUrl=dUrl;
					break;
				}
				else
				{
					System.out.println("Dev Environment Url is Null");
					break;
				}
			}
			case "qa":{
				System.out.println(env+" Environment URL is "+automationUrl);
				if(automationUrl != null)
				{
					driver.get(automationUrl);
					localEnvUrl=automationUrl;
					break;
				}
				else
				{
					System.out.println("QA Environment Url is Null");
					break;
				}
			}
			case "delta":{
				System.out.println(env+" Environment URL is "+deltaUrl);
				if(deltaUrl != null)
				{
					driver.get(deltaUrl);
					localEnvUrl=deltaUrl;
					break;
				}
				else
				{
					System.out.println("delta Environment Url is Null");
					break;
				}
			}
			default:
			{
				//ReporteraddStepLog("Please Enter valid Environment");
			}
			}
			
			//// Reports.reportStep("The browser: "+browser+" launched successfully",
			//// "PASS");
		} catch (WebDriverException e) {
			//// Reports.reportStep("The browser: "+browser+" could not be launched",
			//// "FAIL");
			System.out.println("The browser: "+browser+" could not be launched");
			browserVal=false;
		}
	}


	public void startApp(String browser, String env) {
//				System.out.println(browser);
		startApp(browser, false, env);
	}

	public void setTCNameDesc(String tcName,String tcDescription)
	{
		if(browserVal)
		{
			// Reports.startTestCase(tcName,tcDescription);
			// Reports.reportStep("The browser: "+browserName+" launched successfully",
			// "PASS");
		}
		else
		{
			// Reports.reportStep("The browser: "+browserName+" could not be launched",
			// "FAIL");

		}
	}




	/*
	 * Before suite method will run first in the suite were it will initializes
	 * WebDriver Extent Reports Synchronization waits Properties File
	 *
	 */

	/*

//	@BeforeSuite(alwaysRun = true)
	public void startUp(ITestContext suites) throws Exception {
		// Properties File Configuration
		FileInputStream baseConfig = new FileInputStream(baseConfigFile);
		prop.load(baseConfig);

		FileInputStream packagesPageConfig = new FileInputStream(packageConfig);
		packagesProperties.load(packagesPageConfig);

		//Packages page inputs

		packagesPageEnv = packagesProperties.getProperty("environment");
		noOfitineariesToTest= Integer.parseInt(packagesProperties.getProperty("noOfItineraries"));


		browser = prop.getProperty("browser");
		System.out.println("Browser : " + browser);
		String url = prop.getProperty("url");
		System.out.println("Browser :" + browser);
		String region = "";
		environment = prop.getProperty("environment");;
		String suiteName = "";
		util = new Utility();
		this.suites = suites;



		if (!(suites.getCurrentXmlTest().getParameter("sRegion") == null))

			region = suites.getCurrentXmlTest().getParameter("sRegion");

		if (!(suites.getCurrentXmlTest().getParameter("sBrowser") == null))

			browser = suites.getCurrentXmlTest().getParameter("sBrowser");

		if (!(suites.getSuite().getXmlSuite().getName() == null))

			suiteName = suites.getSuite().getXmlSuite().getName() + "_" + region;



		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Driver : " + driver);
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "driver/chromedriver");
			driver = new InternetExplorerDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile mypprofile =profile.getProfile("default");
			DesiredCapabilities dc = new DesiredCapabilities().firefox();
			dc.setCapability(FirefoxDriver.PROFILE, mypprofile);
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver();
			break;

		default :
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Driver from default : " + driver);
			break;
		}

		// Synchronization statements

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

	}

	 */

	public WebDriver getDriver() {
		return driver;
	}




	public void typeText(WebElement element, String msg) {
		try
		{
			//			System.out.println("Message:"+msg);
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
			//			waitForMe(element);
			//			scrolltoElement(element);
			element.clear();
			//			System.out.println("Typed : " + msg);
			element.sendKeys(msg);
			// Reports.reportStep("The data "+msg+" was entered successfully in field ",
			// "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the Webelement "+element, "FAIL");
			ex.printStackTrace();

		}

	}

	public void forceClick(WebElement ele) {
//		WebElement element = driver.findElement(By.id("navigationPageButton"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).click().build().perform();
	}

	public WebElement waitForMe(WebElement element)
	{
		try
		{
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
			// wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the Webelement: "+element, "FAIL");

		}
		return element;

	}


	public void waitForMe(WebElement first, WebElement second)
	{
		try
		{
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(first));
			wait.until(ExpectedConditions.visibilityOf(first));

			wait.until(ExpectedConditions.elementToBeClickable(second));
			wait.until(ExpectedConditions.visibilityOf(second));
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the
			// Webelements("+first.getText()+","+second.getText()+")", "FAIL");

		}

	}

	public void clickAction(WebElement element) throws InterruptedException {

		try {
			waitForMe(element);
			// scrolltoElement(element);
			element.click();
			// Reports.reportStep("Successfully clicked the WebElement: "+element, "INFO");

		}
		catch(ElementNotInteractableException ex)
		{
			Thread.sleep(3000);
			// Reports.reportStep("Unable to click for the first time and trying one more
			// time for "+element, "PASS");
			element.click();
		}
		catch (Exception ex) {
			// Reports.reportStep("Failed to click the Webelement "+element, "FAIL");
			ex.printStackTrace();
		}
	}

	public void clickActionFailure(WebElement element) throws InterruptedException {

		try {
			Thread.sleep(3000);
			element.click();
			// Reports.reportStep("Successfully clicked the WebElement: "+element, "PASS");

		}
		catch(ElementNotInteractableException ex)
		{
			Thread.sleep(3000);
			// Reports.reportStep("Unable to click the "+element, "INFO");
			element.click();
		}
		catch (Exception ex) {
			// Reports.reportStep("Failed to click the Webelement "+element, "FAIL");
			ex.printStackTrace();
		}
	}




	public void clickAction(WebElement element, String msg) throws InterruptedException {

		try {
			waitForMe(element);
			// scrolltoElement(element);
			//ReporteraddStepLog(msg);
			element.click();
			// Reports.reportStep("Successfully clicked the Webelement", "PASS");

		}
		catch(ElementNotInteractableException ex)
		{
			Thread.sleep(2000);
			// Reports.reportStep("Unable to click for the first time and trying one more
			// time", "PASS");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);

		}
		catch (Exception ex) {
			// Reports.reportStep("Failed to click the Webelement "+element.getText(),
			// "FAIL");
		}
	}


	public String getText(WebElement element) {

		String eleText="";
		try
		{
			//			waitForMe(element);
			Thread.sleep(2000);
			eleText=element.getText();
			// Reports.reportStep("Successfully read text for the given Webelement
			// "+eleText, "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to read text for the given webelement "+eleText,
			// "FAIL");
		}
		return eleText;
	}


	public boolean compareTwoStrings(String actual, String expected) throws Exception
	{
		boolean retVal=false;
		//ReporteraddStepLog("Comparing " + actual + "Vs" + expected);

		Assert.assertEquals(expected, actual);

		if (expected.toLowerCase().contentEquals(actual.toLowerCase())) {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are matching ", "PASS");
			retVal = true;
		} else {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are not matching ", "FAIL");
			retVal = false;

		}
		return retVal;

	}

	public boolean compareTwoStringsPartially(String actual, String expected) throws Exception
	{
		boolean retVal=false;

		if (expected.toLowerCase().contains(actual.toLowerCase())) {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are partially matching ", "PASS");
			retVal=true;
		} else {
			// Reports.reportStep("Both the actual \""+actual+"\" and expected
			// \""+expected+"\" Strings are not partially matching ", "FAIL");
			retVal=false;

		}
		return retVal;

	}



	public boolean compareTwoWebElements(WebElement e1, WebElement e2)
	{
		boolean retVal = false;
		try
		{
			String firstElement=e1.getText().toLowerCase();
			String secondElement=e2.getText().toLowerCase();
			if(firstElement.contentEquals(secondElement))
			{
				// Reports.reportStep("Text of both the Webelements are matching ", "PASS");
				retVal=true;
			}
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Text of both the Webelements are not matching ", "FAIL");
			retVal=false;
		}
		return retVal;
	}


	public boolean compareOneWebElementWithString(WebElement ele, String message, boolean showMessage)
	{
		boolean retVal=false;
		waitForMe(ele);
		if (ele != null && ele.isDisplayed()) {
			retVal = true;
			if (ele.getText() != null &&	ele.getText().length() > 0 && !ele.getText().equals(message)) {// use message if value = *
				//				pass("Verification Pass:  Element Found On UI : " + ele.getText());
				// Reports.reportStep("Value between the Webelement("+ele.getText()+") and the
				// given String("+message+") matches", "PASS");
			}
			else
			{
				retVal=false;
				//				pass("Verification Pass:  Element Found On UI : " + message);
				// Reports.reportStep("Value between the Webelement("+ele.getText()+") and the
				// given String("+message+") doesn't match", "FAIL");
			}

		}
		return retVal;

	}













	public String switchWindows() {
		String currentWindowHandle="";
		try {
			// Store the current window handle
			currentWindowHandle = driver.getWindowHandle();
			// Switch to new window opened

			Set<String> allWindows= driver.getWindowHandles();
			for (String winHandle : allWindows) {
				if (!winHandle.equals(currentWindowHandle) ) {
					driver.switchTo().window(winHandle);
					// Reports.reportStep("Successfully traversed to the required window", "PASS");
					break;
				}
			}
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in navigating to different windows", "FAIL");

		}

		return currentWindowHandle;
	}



	public String switchWindowspackages(String pwindow) {
		// Store the current window handle
		String winHandleBefore="";
		try {
			winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				if (!winHandle.contentEquals(winHandleBefore) && !winHandle.contentEquals(pwindow)) {
					driver.switchTo().window(winHandle);
					// Reports.reportStep("Successfully traversed through other windows", "PASS");

				}
			}
			return winHandleBefore;

		}

		catch(Exception ex)
		{
			// Reports.reportStep("Problem in navigating to different windows", "FAIL");

		}

		return winHandleBefore;
	}

	public void closeSwittchParentWindow(String window) {

		try
		{
			// Perform the actions on new window
			// Close the new window, if that window no more required
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(window);
			// Reports.reportStep("Successfully closed the new window and switched to Parent
			// window", "PASS");

		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in closing the new window and unable to switch to
			// Parent window", "FAIL");

		}
	}

	// Creating a method getScreenshot and passing two parameters
	// driver and screenshotName
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String destination="";
		File finalDestination =null;
		try {
			// below line is just to append the date format with the screenshot name to
			// avoid duplicate names
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots" under src
			// folder
			
			screenshotName=screenshotName.replaceAll("\\s+", "");
//			destination = System.getProperty("user.dir")+"/reports/images/" + screenshotName + dateName+ ".jpg";
			destination = "./reports/images/" + screenshotName + dateName
					+ ".jpg";
			 finalDestination = new File(destination);
			 FileUtils.copyFile(source, finalDestination);
//			 Reports.reportStep("Captured the Failed TC screenshot successfully", "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in capturing Failed TC Screenshot", "FAIL");
		}
		// Returns the captured file path
		return destination;

	}

	public String getCurrentUrl() {

		String currentURL="";
		try
		{
			//ReporteraddStepLog("Capturing current URL");
			currentURL= driver.getCurrentUrl();
			// Reports.reportStep("Successfully captured the Current URL", "PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in fetching the current URL", "FAIL");

		}
		return currentURL;

	}



	/*    *//**
	 * Waits for given WebElement to be present and visible (height and length >
	 * 1px) in DOM.
	 *
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitUntil(WebElement element, long timeOutInSeconds) {
		try
		{
			new WebDriverWait(driver, timeOutInSeconds).ignoring(NoSuchElementException.class)
			.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
			waitForMe(element);
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to locate the Webelement: "+element, "FAIL");

		}


	}


	public boolean elementExist(WebElement ele) {
		waitForMe(ele);
		ele.isDisplayed();

		return true;

	}

	public void elementNotExist(WebElement ele) {

		try {
			if (ele.getTagName() != null) {

			} else
				Assert.fail();
		} catch (Exception e) {
			System.out.println("User Not able to remove the hotel as expexted");
		}



	}


	public Boolean elementDisplayed(WebElement ele) {
		try {
			waitUntil(ele, 3);
			// waitForMe(ele);
			if(ele.isDisplayed()) {
				// //Reports.reportStep("The element "+ele.getText()+" is displayed","INFO");

			}
		} catch (Exception e) {
			//// Reports.reportStep("The element "+ele.getText()+" is not
			//// displayed","INFO");
			return false;
		}
		return true;
	}



	//reports

	// @BeforeMethod

	//Navigate to different URl

	public void navigateToDiffUrlPackages(String environment)
	{
		try {

			if(packagesPageEnv.contentEquals("prod")) {
				driver.navigate().to("https://pickyourtrail.com/packages");
				// Reports.reportStep("Successfully navigated to
				// https://pickyourtrail.com/packages","PASS");

			}
			else if(packagesPageEnv.contentEquals("staging")) {
				driver.navigate().to("https://staging.pickyourtrail.com/packages");
				// Reports.reportStep("Successfully navigated to
				// https://staging.pickyourtrail.com/packages","PASS");

			}
			else if(packagesPageEnv.contentEquals("uat")) {
				driver.navigate().to("https://uat.pickyourtrail.com/packages");
				// Reports.reportStep("Successfully navigated to
				// https://uat.pickyourtrail.com/packages","PASS");

			}
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in navigating to Packages URL of
			// "+environment,"FAIL");

		}
	}


	public void navigateToEnvUrl(String url)
	{

		if(!(environment.contentEquals("prod")))
		{
			url = url.replace("env", environment);
		}

		driver.navigate().to(url);
	}

	public void navigateToUrl(String url)
	{
		try
		{
			driver.get(url);
			// Reports.reportStep("Navigated to "+url, "PASS");

		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem while navigating to "+url, "FAIL");
		}
	}



	public static void hoverWebelement(WebElement HovertoWebElement)
	{
		try
		{
			Actions builder = new Actions(driver);
			builder.moveToElement(HovertoWebElement).perform();
			Thread.sleep(2000);
			// Reports.reportStep("Successfully hovered to the given Webelement:
			// "+HovertoWebElement.getText(),"PASS");

		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in hovering to the given Webelement:
			// "+HovertoWebElement.getText(),"FAIL");

		}

	}
	public  void scrolltoElement(WebElement ScrolltoThisElement) {
		try {

			waitForMe(ScrolltoThisElement);
			Actions act = new Actions(driver);

			act.moveToElement(ScrolltoThisElement).build().perform();

		/*
			Coordinates coordinate = ((Locatable) ScrolltoThisElement)
					.getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();*/
			// Reports.reportStep("Successfully scrolled to the given Webelement:
			// "+ScrolltoThisElement,"INFO");

		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling to the given Webelement:
			// "+ScrolltoThisElement,"FAIL");
			ex.printStackTrace();
		}
	}
	public void scroll()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 300);");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public void scrollToReserveSlot()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 1000);");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public void scrollToEnd()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 4100);");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public void scrollToView(WebElement ScrolltoThisView)
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();",ScrolltoThisView );
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");

		}

	}


	public boolean verifyExistence(WebElement webElement, String message, boolean showMessage) throws Exception {

		boolean returnValue = false;

		try {

			highlightElement = null;

			if (webElement != null && webElement.isDisplayed()) {

				returnValue = true;

				if (webElement.getText() != null &&

						webElement.getText().length() > 0 &&

						!webElement.getText().equals("*")) {// use message if value = *



				} else {


				}

			} else {

				if (showMessage) {

					// fail("Verification Failed: Element Not Found On UI :" + message);

					// ScreenShot_Helper.capturefullPageScreenShot(driver, "i-" + message);

				} else {

					// reportLog("Verification Failed: Element Not Found On UI :"+message);

				}
			}
		} finally {

		}
		return returnValue;
	}




	public String getAttribute(WebElement ele, String attribute) {
		String bReturn = "";
		try {
			waitForMe(ele);
			bReturn=  ele.getAttribute(attribute);
			// Reports.reportStep("The element: "+ele+" was found.", "PASS");

		} catch (WebDriverException e) {
			// Reports.reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	// method to select values in drop down based on index
	public void selectDropDownUsingIndex(WebElement element, int indexer) {
		try
		{
			waitForMe(element);
			Select sel = new Select(element);
			sel.selectByIndex(indexer);
			// Reports.reportStep("The dropdown is selected with index: "+indexer,"PASS");
		}
		catch (WebDriverException e) {
			// Reports.reportStep("The element: "+element+" could not be found.", "FAIL");
		}

	}

	// method to select values in drop down based on Visible Text
	public void selectDropDownUsingVisibleText(WebElement element, String visibleText) {
		try
		{
			waitForMe(element);
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
			// Reports.reportStep("The dropdown is selected with visible text:
			// "+visibleText,"PASS");
		}
		catch (WebDriverException e) {
			// Reports.reportStep("The element: "+element+" could not be found.", "FAIL");
		}

	}


	// method to select values in drop down based on Value
	public void selectDropDownUsingValue(WebElement element, String value) {
		try
		{
			waitForMe(element);
			Select sel = new Select(element);
			sel.selectByValue(value);
			// Reports.reportStep("The dropdown is selected with value: "+value,"PASS");
		}
		catch (WebDriverException e) {
			// Reports.reportStep("The element: "+element+" could not be found.", "FAIL");
		}

	}


	public String getTitle() {
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		}
		return bReturn;
	}


	public boolean verifyTitle(String title) throws InterruptedException {
		boolean bReturn =false;
		try {
			Thread.sleep(3000);
			if(getTitle().equals(title)) {
				// Reports.reportStep("The title of the page matches with the value
				// :"+title,"PASS");
				bReturn= true;
			}else {
				// Reports.reportStep("The title of the page:"+driver.getTitle()+" did not match
				// with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the title",
			// "FAIL");
		}
		return bReturn;
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		boolean bReturn =false;
		try {
			waitForMe(ele);
			if(getText(ele).equals(expectedText)) {
				// Reports.reportStep("The text: "+getText(ele)+" matches with the value
				// :"+expectedText,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The text "+getText(ele)+" doesn't matches the actual
				// "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Text",
			// "FAIL");
		}
		return bReturn;

	}


	public boolean verifyPartialText(WebElement ele, String expectedText) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(getText(ele).contains(expectedText)) {
				// Reports.reportStep("The expected text contains the actual
				// "+expectedText,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The expected text doesn't contain the actual
				// "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Text",
			// "FAIL");
		}
		return bReturn;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(getAttribute(ele, attribute).equals(value)) {
				// Reports.reportStep("The expected attribute :"+attribute+" value matches the
				// actual "+value,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The expected attribute :"+attribute+" value does not
				// matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Attribute
			// Text", "FAIL");
		}

		return bReturn;

	}

	public boolean verifyPartialAttribute(WebElement ele, String attribute, String value) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(getAttribute(ele, attribute).contains(value)) {
				// Reports.reportStep("The expected attribute :"+attribute+" value contains the
				// actual "+value,"PASS");
				bReturn=true;
			}else {
				// Reports.reportStep("The expected attribute :"+attribute+" value does not
				// contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("Unknown exception occured while verifying the Attribute
			// Text", "FAIL");
		}
		return bReturn;
	}


	public boolean verifySelected(WebElement ele) {
		boolean bReturn =false;

		try {
			waitForMe(ele);
			if(ele.isSelected()) {
				// Reports.reportStep("The element "+ele+" is selected","PASS");
				bReturn=true;
			} else {
				// Reports.reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In verifySelected",
			// "FAIL");
		}
		return bReturn;
	}

	public boolean verifyEnabled(WebElement ele) {
		boolean retVal=false;
		try {
			//			waitForMe(ele);
			if(ele.isEnabled()) {
				// Reports.reportStep("The element "+ele+" is Enabled","INFO");
				retVal=true;
			} else {
				retVal=false;
				// Reports.reportStep("The element "+ele+" is not Enabled","INFO");
			}
		} catch (WebDriverException e) {
			retVal=false;
			// Reports.reportStep("WebDriverException as occured: In verifyEnabled",
			// "FAIL");
		}
		return retVal;
	}

	public void switchWindowByIndex(int index)
	{
		try
		{
			Set<String> allWindowHandles=driver.getWindowHandles();
			List<String> allWindows=new ArrayList<String>();
			allWindows.addAll(allWindowHandles);
			driver.switchTo().window(allWindows.get(index));
			// Reports.reportStep("Switched to the given window index: "+index,"PASS");
		}
		catch (NoSuchWindowException e) {
			// Reports.reportStep("The driver could not move to the given window by index
			// "+index,"FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In switchToWindow",
			// "FAIL");
		}
	}

	public void switchToFrameByWebElement(WebElement ele)
	{
		try
		{
			driver.switchTo().frame(ele);
			// Reports.reportStep("Switched to Frame by Webelement "+ele,"PASS");
		}
		catch (NoSuchFrameException e) {
			// Reports.reportStep("NoSuchFrameException occured ","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In
			// switchToFrameByWebelement", "FAIL");
		}
	}

	public void switchToFrameByName(String frameName_ID)
	{
		try
		{
			driver.switchTo().frame(frameName_ID);
			// Reports.reportStep("Switched to Frame by Name/ID "+frameName_ID,"PASS");
		}
		catch (NoSuchFrameException e) {
			// Reports.reportStep("NoSuchFrameException occured ","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In
			// switchToFrameByName/ID", "FAIL");
		}
	}

	public void switchToFrameByIndex(int index)
	{
		try
		{
			driver.switchTo().frame(index);
			// Reports.reportStep("Switched to Frame by Index "+index,"PASS");
		}
		catch (NoSuchFrameException e) {
			// Reports.reportStep("NoSuchFrameException occured ","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In switchToFrameByIndex",
			// "FAIL");
		}
	}

	public void acceptAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			// Reports.reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException ex) {
			// Reports.reportStep("There is no alert present","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In dismissAlert", "FAIL");
		}
	}

	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			// Reports.reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			// Reports.reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In dismissAlert", "FAIL");
		}

	}

	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			// Reports.reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			// Reports.reportStep("WebDriverException as occured: In getAlertText", "FAIL");
		}
		return text;
	}

	public void closeBrowser() {
		try {
			driver.close();
			// Reports.reportStep("The current browser session is closed","PASS");
		} catch (Exception e) {
			// Reports.reportStep("The current browser session could not be closed","FAIL");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			driver.manage().deleteAllCookies();
			// //Reports.reportStep("All the opened browsers are closed","INFO");
		} catch (Exception e) {
			// //Reports.reportStep("Unexpected error occurred while closing all the opened
			// browsers","FAIL");
		}
	}

	public void doubleClick(WebDriver driver, WebElement ele)
	{
		try
		{
			waitForMe(ele);
			Actions doubleClk = new Actions(driver);
			doubleClk.moveToElement(ele).doubleClick().build().perform();
			// Reports.reportStep("Double clicked the given
			// Webelement("+ele.getText()+")","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to double click the given
			// Webelement("+ele.getText()+")","FAIL");
		}
	}

	public void rightClick(WebDriver driver, WebElement ele)
	{
		try
		{
			waitForMe(ele);
			Actions rightClk = new Actions(driver);
			rightClk.moveToElement(ele).contextClick().build().perform();
			// Reports.reportStep("Right clicked the given
			// Webelement("+ele.getText()+")","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to right click the given
			// Webelement("+ele.getText()+")","FAIL");
		}
	}

	public void dragDropUsingClickAndHold(WebDriver driver, WebElement dragElement,WebElement dropElement)
	{
		try
		{
			waitForMe(dragElement, dropElement);
			Actions dragDrop = new Actions(driver);
			dragDrop.clickAndHold(dragElement).moveToElement(dropElement).build().perform();
			// Reports.reportStep("Drag and dropped using Click and Hold","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to drag and drop using Click and Hold","FAIL");
		}
	}

	public void moveToSubMenu(WebDriver driver, WebElement menu, WebElement subMenu)
	{
		try
		{
			waitForMe(menu, subMenu);
			Actions navigateSubMenu = new Actions(driver);
			navigateSubMenu.moveToElement(menu).moveToElement(subMenu).build().perform();
			// Reports.reportStep("Moved to the Sub Menu","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to move to the Sub menu","FAIL");
		}
	}

	public void dragDrop(WebDriver driver, WebElement dragElement,WebElement dropElement)
	{
		try
		{
			waitForMe(dragElement, dropElement);
			Actions dragDrop = new Actions(driver);
			dragDrop.dragAndDrop(dragElement,dropElement).build().perform();
			// Reports.reportStep("Drag and dropped the given Webelement to the target
			// element","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to drag and drop the given Webelement to the
			// target element","FAIL");
		}
	}

	public void moveTo(WebDriver driver, WebElement moveElement)
	{
		try
		{
			waitForMe(moveElement);
			Actions moveTo = new Actions(driver);
			moveTo.moveToElement(moveElement).build().perform();
			// Reports.reportStep("Moved to the given Webelement ","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to move to the given Webelement","FAIL");
		}
	}


	public void moveToUrl(WebDriver driver)
	{
		try
		{
			Thread.sleep(2000);
		    Dimension initial_size = driver.manage().window().getSize();
		    int ab =initial_size.getHeight();
		    System.out.println("Window size"+initial_size);
		    System.out.println(initial_size.getHeight());
//			moveToUrl.keyDown(Keys.CONTROL)
//			   .click(ele)
//			   .moveByOffset( 0, 20 )
//			   .keyUp(Keys.CONTROL).build().perform();
			Actions moveToUrl = new Actions(driver);
			moveToUrl.moveByOffset(0, -750).click().build().perform();
			// Reports.reportStep("Dragged the Mouse pointer to the Url","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to drag the Mouse pointer to the Url","FAIL");
		}
	}




	public boolean uploadFileUsingSendKeys(WebElement ele, String path)
	{
		boolean retVal=false;
		try
		{
			waitForMe(ele);



		}
		catch(Exception ex)
		{
			retVal=false;
		}
		return retVal;
	}

	/*
	 * Author : karthick Description : Following method will get the webelement and
	 * return total count as String Category : Validation
	 */
//
//	public void String (WebElement ele) {
//		driver.findElements(by)
//		Assert.assertTrue(actual.contains(expected));
//	}

	/*
	 * Author : karthick Description : Following method will check if expected sting
	 * in available in actual String Similar to contains method of String class
	 * Category : Validation
	 */

	public void validate_String_Contains(String actual, String expected) {
//		Reporter.addStepLog("Validating " + actual + " contains " + expected + "");
		System.out.println("Validating " + actual + " contains " + expected + "");
		Assert.assertTrue(actual.contains(expected));
	}
	
	//Assertions or validations

	public void validateAssertion(boolean value) {
		if(value == true)
		{
			Assert.assertTrue(value);
			//ReporteraddStepLog("Assertion Passed");
		}
		else
		{
			Assert.assertTrue(value);
			//ReporteraddStepLog("Assertion Failed");
		}
	}

	public void clickJavaScriptElement(WebElement element) throws InterruptedException {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", element);
//            System.out.println("Successfully clicked the Javascript Webelement");
        } catch (ElementNotInteractableException ex) {
            Thread.sleep(3000);
            System.out.println("Unable to click for the first time and trying one more time");
            element.click();
        } catch (Exception ex) {
            System.out.println("Failed to click the Javascript Webelement");
        }
    }
	
	public void clickDisbledJavaScriptElement(WebElement element) throws InterruptedException {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].removeAttribute(\"disabled\");", element);

//            System.out.println("Successfully clicked the Javascript Webelement");
        } catch (ElementNotInteractableException ex) {
            Thread.sleep(3000);
            System.out.println("Unable to click for the first time and trying one more time");
            element.click();
        } catch (Exception ex) {
            System.out.println("Failed to click the Javascript Webelement");
        }
    }
	
	public void pollingWait(WebElement element,int timeOut) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			//ReporteraddStepLog("Unable to locate Element : " + element);
		}
	}
	
	public void pollingWaitForCostingFlow(String element,int timeout) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.urlContains(element));
		} catch (NoSuchElementException e) {
			//ReporteraddStepLog("Unable to locate Element : " + element);
		}
	}	
	public boolean verifyStringNotEquals(String actual, String expected) {
		boolean retVal=false;

		try {
			//ReporteraddStepLog(actual + " string should not contain " + expected);
			Assert.assertFalse(actual.contains(expected));
			retVal=true;
		}
		catch(Exception ex)
		{
			//ReporteraddStepLog("Problem in comparing the strings "+actual+"--->"+expected);

		}
		return retVal;
	}
	
	public void actionsClick(WebDriver driver, WebElement ele)
	{
		try
		{
			waitForMe(ele);
			Actions singleClick = new Actions(driver);
			singleClick.moveToElement(ele).click().build().perform();
			// Reports.reportStep("Double clicked the given
			// Webelement("+ele.getText()+")","PASS");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to double click the given
			// Webelement("+ele.getText()+")","FAIL");
			//ReporteraddStepLog("Problem while clicking the Webelement "+ele);
		}
	}
	
	
	public void scrollUp()
	{
		try
		{
			//			WebDriver driver = new FirefoxDriver();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-750)"); 
			//ReporteraddStepLog("Successfully scrolled up the page");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");
			//ReporteraddStepLog("Problem while scrolling up the page");
		}
	}
	
	
	public void scrollByValue(int value)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,"+value+")"); 
			//ReporteraddStepLog("Successfully scrolled up the page");
			// Reports.reportStep("Successfully scrolled down to the page","INFO");
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Problem in scrolling down to the page","FAIL");
			//ReporteraddStepLog("Problem while scrolling up the page");
		}
	}

	public void scrollDown()
	{
		try
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,3000)");
			//ReporteraddStepLog("Successfully scroller down to the page");
			// Reports.reportStep(“Successfully scrolled down to the page”,“INFO”);
		}
		catch(Exception ex)
		{
			// Reports.reportStep(“Problem in scrolling down to the page”,“FAIL”);
			//ReporteraddStepLog("Problem in scrolling down to the page");
		}
	}
	
	public void actionTypeText( WebElement ele,String text) {
		try {
			waitForMe(ele);
			 Actions typeText = new Actions(driver);
			 typeText.sendKeys(ele,text).build().perform();

			
		}
		catch(Exception ex)
		{
			// Reports.reportStep("Unable to double click the given
			// Webelement("+ele.getText()+")","FAIL");
//			Reporter.addStepLog("Problem while clicking the Webelement "+ele);
			ex.printStackTrace();
		}
	}
			
		
	public boolean scrollTo(int val) {
		boolean flag = false;
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, " + val + ");");
			flag = true;
		} catch (Exception ex) {
			System.out.println("Failed to scroll");
		}
		return flag;
	}
	
	public WebElement waitForMe(WebElement element,int timeOut)
	{
		try
		{
			wait = new WebDriverWait(driver, timeOut);
			 wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception ex)
		{
			System.out.println("Unable to locate the Webelement: "+element);

		}
		return element;
	}
	public void pageRefresh() {
		driver.navigate().refresh();
	}

}
