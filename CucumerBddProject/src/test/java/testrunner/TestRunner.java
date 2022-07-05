package testrunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(strict = true, features = { "classpath:SmokeFeatures/" }, format = {
//		"json:target/cucumber-parallel/1.json",
//		"html:target/cucumber-parallel/1.html",
//		"pretty" }, monochrome = false, tags = { "~@ignored" }, glue = { "gluecode" })
import utils.Kernel;

@RunWith(Cucumber.class)

@CucumberOptions(features = "features/corewebvitals.feature", glue = {
"gluecode" }, plugin = {
"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/WebAutomationReport.html" }, monochrome = true, dryRun = false)


public class TestRunner {
	public static String timeStamp = "";
	
//	public static String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date()); 

	@AfterClass
	public static void writeExtentReport() throws Exception {
		Kernel kn = new Kernel();
		timeStamp=kn.getTime();
		
		System.out.println("Time Stamp: "+timeStamp);
		//ReporterloadXMLConfig(new File("configuration/Report.xml"));
//		kn.renameFile();
//		kn.copyFileUsingStream();
		kn.sendMail();
	}
	
	

}

