package testrunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.Kernel;

@RunWith(Cucumber.class)

@CucumberOptions(features = "@target/rerun.txt", glue = {
"gluecode" }, plugin = {
"rerun:target/rerun.txt", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/FailedScenariosReReunReport.html" },monochrome = true, dryRun = false)


public class TestrunnerFailedTestcases {
	
	public static String timeStamp = "";

        	
	@AfterClass
	public static void writeExtentReport() throws Exception {
		Kernel kn = new Kernel();
		timeStamp=kn.getTime();
		
		System.out.println("Time Stamp: "+timeStamp);
		kn.sendMail();
//		kn.mergeAllTextFileContents();
	}
        
 }
        
