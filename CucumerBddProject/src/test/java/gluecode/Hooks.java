package gluecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Kernel;
import utils.SeWrappers;

public class Hooks extends SeWrappers {
	SeWrappers se = new SeWrappers();
	Kernel kn= new Kernel();

	public static String configuration = "";
	public static String featureName = "";
	public static String scenarioName="";
	public static long threadId=0;

	@Before
	public void beforeScenario(Scenario scenario) {
		
		threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
		
		configuration = System.getProperty("configEnv");
		featureName = scenario.getId().split(";")[0];
		scenarioName= scenario.getName();
		System.out.println("Feature Name --> "+featureName);
		System.out.println("Scenario Name --> "+scenario.getName());
		se.startApp(browserName, "staging");
//		se.startApp(browserName, configuration);
		
		//To initiate browser sessions using Selenium Grid 
//		se.startApp(browserName, true, configuration);

		kn.closeStaycationModal();


	}

//	@Before
//	public void before() {
//		threadId = Thread.currentThread().getId();
//		String processName = ManagementFactory.getRuntimeMXBean().getName();
//		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
//	}

	@After()
	public void embedScreenshot(Scenario scenario) throws Exception {
		try {
			
			System.out.println("Scenario Status :" + scenario.getStatus());

			if(! (scenario.isFailed()) )
			{
				kn.writeToFile(featureName, scenarioName, "pass");
			}
			else if (scenario.isFailed())
			{
				String sc = getScreenshot(driver, scenario.getName());
				//ReporteraddScreenCaptureFromPath(sc);
				
				kn.writeToFile(featureName, scenarioName, "fail");

			}

		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			scenario.write(somePlatformsDontSupportScreenshots.getMessage());
		} finally {
			System.out.println("Closing all the browsers !!!!");
			 se.closeAllBrowsers();
		}
	}
}
