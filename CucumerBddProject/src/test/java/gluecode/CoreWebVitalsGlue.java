package gluecode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pyt.pages.CoreWebVitalsPage;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Kernel;

public class CoreWebVitalsGlue extends Kernel{

	public static String mobilePoorURLs, mobileImprovementURLs, mobileGoodURLs, desktopPoorURLs, desktopImprovementURLs, desktopGoodURLs, webVitalTypeUrl,noMetricUrl,noMetricContent,noUrlCount;
	List<WebElement> metricType= new ArrayList<>();
	List<WebElement> urlCount= new ArrayList<>();
	List<WebElement> urlWebElements= new ArrayList<>();
	List<String> allUrlValues = new ArrayList<>();
	String eachUrlValue, metricValue, urlValue="";
	String urlValues= "";
	String mDevice="Mobile";
	String dDevice="Desktop";
	int urls,metricsCount,urlnos=0;

	//Login to the Google search console but OTP should be manually entered
	
	@Given("^Login to Google Search Console and navigate to Core Web Vitals section$")
	public void login_to_Google_Search_Console_and_navigate_to_Core_Web_Vitals_section() throws Throwable {

		try
		{
			//			navigateToUrl(googleSearchConsoleUrl);
			driver.navigate().to(googleSearchConsoleUrl);
			typeText(webVitals.getUsername(), "nirmal@pickyourtrail.com");
			Thread.sleep(2000);
			clickJavaScriptElement(webVitals.getNextButton());
			Thread.sleep(2000);
			typeText(webVitals.getPassword(), "Sh0uldachieve@158");
			Thread.sleep(2000);
			clickJavaScriptElement(webVitals.getNextButton());
			Thread.sleep(10000);

		}
		catch(Exception ex)
		{
			System.out.println("Problem while navigating to Core Web Vital Section after logging in "+ex.getMessage());
		}


	}

	@When("^Capture the Core Web Vitals metrics for both Desktop and Mobile$")
	public void capture_the_Core_Web_Vitals_metrics_for_both_Desktop_and_Mobile() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		try
		{
			urlMetrics();
			manipaluteTableHead();
			tableHead();
			//To wait and click on the Mobile Open Report button
			waitForMe(webVitals.getMobileOpenReport());
			clickJavaScriptElement(webVitals.getMobileOpenReport());
			
			fetchData("mobile");
			
			//To navigate to the home page of Search console
			clickJavaScriptElement(webVitals.getCoreWebVitals());
			
			//To wait and click on the Desktop Open Report button
			waitForMe(webVitals.getDesktopOpenReport());
			clickJavaScriptElement(webVitals.getDesktopOpenReport());
			
			fetchData("desktop");
		}
		catch(Exception ex)
		{
			
			System.out.println("Problem while generating report for Core Web Vitals for both Mobile and Desktop "+ex.getMessage());
		}

	}
	
	
	@And("^mail the report to all stakeholders$")
	public void tearDown()
	{

		tableTail();
		mailSend();
	}


	
	//Fetch the data for each metric type both Mobile and Desktop
	private void fetchData(String device) {

		try
		{
			
			waitForMe(webVitals.getStatus());
			
			metricsCount=driver.findElements(By.xpath("(//div[@jscontroller='NTeeme'])")).size();

			
			metricType= driver.findElements(By.xpath("(//div[@jscontroller='NTeeme'])["+metricsCount+"]//td[@data-toggle-label='ERROR']/../td[2]"));
			urlCount= driver.findElements(By.xpath("(//div[@jscontroller='NTeeme'])["+metricsCount+"]//td[@data-toggle-label='ERROR']/../td[5]"));


			if (metricType.size()>0)
			{


				for(int i=0; i < metricType.size();i++)
				{
					
					metricValue=metricType.get(i).getText();
					System.out.println("Metric Text: "+metricValue);
					urlValue=urlCount.get(i).getText();
					System.out.println("Url Value: "+urlValue);

					clickAction(metricType.get(i));
					waitForMe(webVitals.getAffectedURLs(), 5);
					webVitalTypeUrl=getCurrentUrl();

					urls=driver.findElements(By.xpath("(//div[@jscontroller='NTeeme'])")).size();

					urlWebElements=driver.findElements(By.xpath("(//div[@jscontroller='NTeeme'])["+urls+"]//td[1]"));
					
					for (WebElement eachUrlWebElement : urlWebElements) {
						
						eachUrlValue=eachUrlWebElement.getText();
						allUrlValues.add(eachUrlValue);
						
					}
					
					urlValues=allUrlValues.toString().replaceAll("[\\[\\](){}]","");

					if(device.equalsIgnoreCase("mobile"))
					{

						html.append("<tr><td align='center'>" + mDevice + "</td><td align='left' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+webVitalTypeUrl+"\'>" + metricValue + "</a></td><td align='center'>" + urlValue + "</td><td align='center'>" + urlValues + "</td></tr>");

					}
					else if (device.equalsIgnoreCase("desktop"))
					{
						html.append("<tr><td align='center'>" + dDevice + "</td><td align='left' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+webVitalTypeUrl+"\'>" + metricValue + "</a></td><td align='center'>" + urlValue + "</td><td align='center'>" + urlValues + "</td></tr>");

					}

					driver.navigate().back();
					Thread.sleep(3000);
					allUrlValues.clear();
				}

			}
			else
			{
				noMetricUrl="";
				noMetricContent="There is no Web Vital Metric";
				noUrlCount="0";

				if(device.equalsIgnoreCase("mobile"))
				{

					html.append("<tr><td align='center'>" + mDevice + "</td><td align='center' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+noMetricUrl+"\'>" + noMetricContent + "</a></td><td align='center'>" + noUrlCount + "</td><td align='center'>" + noMetricUrl + "</td></tr>");

				}
				else if (device.equalsIgnoreCase("desktop"))
				{
					html.append("<tr><td align='center'>" + dDevice + "</td><td align='center' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+noMetricUrl+"\'>" + noMetricContent + "</a></td><td align='center'>" + noUrlCount + "</td><td align='center'>" + noMetricUrl + "</td></tr>");

				}
			}


		}
		catch(Exception ex)
		{
			System.out.println("Problem while fetching the Core Web Vitals Metrics "+ex.getMessage());
		}


	}

	//Fetch the URL Count for the first table in the report
	public void urlMetrics() throws InterruptedException
	{
		Thread.sleep(4000);
		mobilePoorURLs=getText(webVitals.getMobilePoorURLs()).split(" ")[0];
		Thread.sleep(1000);
		mobileImprovementURLs=getText(webVitals.getMobileImprovementURLs()).split(" ")[0];
		Thread.sleep(1000);
		mobileGoodURLs=getText(webVitals.getMobileGoodURLs()).split(" ")[0];
		Thread.sleep(1000);
		desktopPoorURLs=getText(webVitals.getDesktopPoorURLs()).split(" ")[0];
		Thread.sleep(1000);
		desktopImprovementURLs=getText(webVitals.getDesktopImprovementURLs()).split(" ")[0];
		Thread.sleep(1000);
		desktopGoodURLs=getText(webVitals.getDesktopGoodURLs()).split(" ")[0];
		Thread.sleep(1000);
	}
	
	//Generate the first table in the report

	public void manipaluteTableHead() throws InterruptedException
	{
		Thread.sleep(3000);
		html1.append("<html>");
		html1.append("<body>");
		html1.append(
				"<table align=\"center\" width=\"60%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" bordercolor=\"#000\"style=\"font: 11pt Arial;border-collapse:collapse;\">");
		html1.append("<tr valign= \"top\">");
		html1.append(
				"<td colspan=\"5\" align=\"center\" valign=\"middle\" style=\"font-weight: bold\" height=\"24\" font face=\"Arial\" bgcolor=\"#26cf96\"> Core Web Vitals Metrics </th>");
		html1.append("</tr>");
		html1.append("<tbody>");

		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"1\" width=\"20%\" align='center'> Mobile </td> <td colspan=\"2\" width=\"60%\" align='center'>Poor URLs </td> <td align='center' width=\"20%\"> "+mobilePoorURLs+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"1\" width=\"20%\" align='center'> Mobile </td> <td colspan=\"2\" width=\"60%\" align='center'>Need's Improvement URLs </td> <td align='center' width=\"20%\"> "+mobileImprovementURLs+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"1\" width=\"20%\" align='center'> Mobile </td> <td colspan=\"2\" width=\"60%\" align='center'>Good URLs </td> <td align='center' width=\"20%\"> "+mobileGoodURLs+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"1\" width=\"20%\" align='center'> Desktop </td> <td colspan=\"2\" width=\"60%\" align='center'>Poor URLs </td> <td align='center' width=\"20%\"> "+desktopPoorURLs+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"1\" width=\"20%\" align='center'> Desktop </td> <td colspan=\"2\" width=\"60%\" align='center'>Need's Improvement URLs </td> <td align='center' width=\"20%\"> "+desktopImprovementURLs+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"1\" width=\"20%\" align='center'> Desktop </td> <td colspan=\"2\" width=\"60%\" align='center'>Good URLs </td> <td align='center' width=\"20%\"> "+desktopGoodURLs+"</td>");
		html1.append("</tr>");
		html1.append("</tbody>");
		html1.append("</table>");
		html1.append("</body>");
		html1.append("</html>");
		System.out.println(html1.toString());

	}


	//Print the body of the report along with Second table headers
	public void tableHead() {

		html.append("<html>");
		html.append("<body>");
		html.append("<p><font face=\"Arial\" size='4'>Below is the detailed report on Poor URLs for both Mobile and Desktop,</font></p>");
		html.append(
				"<table align=\"center\" width=\"90%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" bordercolor=\"#000\"style=\"font: 11pt Arial;border-collapse:collapse;\">");
		//		html.append("<tr valign= \"top\">");
		//		html.append(
		//				"<td colspan=\"3\" align=\"center\" valign=\"middle\" style=\"font-weight: bold\" height=\"24\" font face=\"Arial\" bgcolor=\"#26cf96\"> Report for URL Validation Automation </th>");
		//		html.append("</tr>");
		html.append("<tr bgcolor=\"#26cf96\">");
		html.append("<th scope=\"col\" width=\"15%\">Device Type</th>");
		html.append("<th scope=\"col\" width=\"40%\">Web Vital Type</th>");
		html.append("<th scope=\"col\" width=\"15%\">URLs Count </th>");
		html.append("<th scope=\"col\" width=\"50%\">Sample URLs</th>");
		html.append("<tbody>");

	}


	public void tableTail() {

			html.append("</tbody>");
			html.append("</table>");
			html.append("</body>");
			html.append("</html>");
			System.out.println(html.toString());
		
	}
	
	public void mailSend()
	{
		Mail mail= new Mail();

		Email fromEmail = new Email();
		fromEmail.setName("QA Team");
		fromEmail.setEmail("qa@pickyourtrail.com");
		mail.setFrom(fromEmail);

		mail.setSubject("Core Web Vitals Metrics Report");

		Personalization personalization = new Personalization();
		Email to = new Email();
//		to.setName("Marketing Team");
		
//		to.setEmail("nirmal@pickyourtrail.com");
//		personalization.addTo(to);
		to.setEmail("divya@pickyourtrail.com");
		personalization.addTo(to);
		Email cc = new Email();
		cc.setEmail("sreeram.krishna@pickyourtrail.com");
		personalization.addCc(cc);
		cc.setEmail("nirmal@pickyourtrail.com");
		personalization.addCc(cc);
		cc.setEmail("sharmila@pickyourtrail.com");
		personalization.addCc(cc);
		cc.setEmail("meenatchi@pickyourtrail.com");
		personalization.addCc(cc);
		cc.setEmail("saravana@pickyourtrail.com");
		personalization.addCc(cc);
		mail.addPersonalization(personalization);
		
		Content content = new Content();
		content.setType("text/html");
		content.setValue(html1.toString()+html.toString());
		mail.addContent(content);

		SendGrid sg = new SendGrid("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");
		sg.addRequestHeader("X-Mock", "true");
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			//			System.out.println(response.getStatusCode());
			//			System.out.println(response.getBody());
			//			System.out.println(response.getHeaders());

			System.out.println("Script has successfully completed its execution and identified the failing URLs");

		} catch (IOException ex) {

			System.out.println("Problem while sending mail to the required stakeholders");
		}
	}

}
