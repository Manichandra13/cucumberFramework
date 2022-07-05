package gluecode;

import cucumber.api.java.en.And;
import utils.SeWrappers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.itextpdf.text.log.SysoCounter;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class UrlValidationGlue {
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	WebDriver driver;
	private int invalidImageCount;

	NodeList listOfurls;
	List<String> urlList;
	List<String> builder= new ArrayList<String>();
	public static String startTime="";
	public static String path="";
	public static String path1="";
	public static int sNo = 0;
	public StringBuilder html = new StringBuilder();
	public StringBuilder html1 = new StringBuilder();

	String brokenUrlText="Fail";
	String brokenImageText="Yes";
	String validURL="No";
	String validImage="No";
	List<Integer> urlCount= new ArrayList<Integer>();
	String ignoreImage="";
	public static int urlsScanned;
	public static int urlsPassed;
	public static int urlsFailed;


	// @Test
	public void sitemapURLupdate(String url) {

		// String url = "https://pickyourtrail.com/sitemap.xml";

//		System.out.println("Test");

		try {

			if(url.endsWith("sitemap.xml"))
			{

				startTime = new SimpleDateFormat("dd-MMM-yyyy_h.mma").format(new Date());
				path=System.getProperty("user.dir")+"/urlvalidation/sitemap"+startTime+".xml";
//				path="/Users/mac/Desktop/UrlValidation/sitemap"+startTime+".xml";
				File file= new File (path.trim());	
				downloadUsingNIO(url,file);
			}
			//			else if (url.matches("sitemap-itineraries.xml"))
			else
			{
				startTime = new SimpleDateFormat("dd-MMM-yyyy_h.mma").format(new Date());
				path=System.getProperty("user.dir")+"/urlvalidation/sitemapitineraries"+startTime+".xml";
//				path="/Users/mac/Desktop/UrlValidation/sitemapitineraries"+startTime+".xml";
				File file1= new File (path.trim());	
				downloadUsingNIO(url,file1);
			}

			// downloadUsingStream(url, "/Users/pankaj/sitemap_stream.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void downloadUsingStream(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while ((count = bis.read(buffer, 0, 1024)) != -1) {
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}

	private static void downloadUsingNIO(String urlStr, File file) throws IOException {
//		System.out.println("Test dwnload");
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}

	// @Test
	public List<String> xmlExtract() {
		urlList = new ArrayList<String>();
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(path));

			// normalize text representation
			doc.getDocumentElement().normalize();
			//System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			listOfurls = doc.getElementsByTagName("url");
			int totalurls = listOfurls.getLength();

			urlCount.add(totalurls);
//						System.out.println("Total no of URL : " + totalurls);

			for (int s = 0; s < listOfurls.getLength(); s++) {

				Node firsturlNode = listOfurls.item(s);
				if (firsturlNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firsturlElement = (Element) firsturlNode;

					// -------
					NodeList firstNameList = firsturlElement.getElementsByTagName("loc");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					// System.out.println("First Name : " +
					// ((Node)textFNList.item(0)).getNodeValue().trim());
					String url = ((Node) textFNList.item(0)).getNodeValue().trim();
					urlList.add(url);



				} // end of if clause

			} // end of for loop with s var

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return urlList;

	}

	public void linkvalidation(List<String> li) {

		try {
			for (int i = 0; i <= li.size() - 1; i++) {

				url = li.get(i);
//				driver.get(url);
//				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();
				// 200 - Pass
				// 302 - warning - temp redirect
				// 301 - permanent redirect
				// 404 not found - error
				// 500 - Critical error - server error
				// 503 - critical error - server down
				// 401 - not authorized
				//				System.out.println("Response code: "+respCode);
				
				/*
				if (respCode == 200) {
					//					System.out.println(url + " is a broken link" + respCode);
					//					System.out.println("Broken link: "+url);
					if(driver.findElements(By.xpath("//h1[@class='vmargin-medium bold']")).size() > 0)
					{
					String urlText=driver.findElement(By.xpath("//h1[@class='vmargin-medium bold']")).getText();
					System.out.println(urlText);
					if(urlText.equalsIgnoreCase("Oops! We don't do trails to outer space (yet)."))
					{
					sNo++;
					html.append("<tr><td align='center'>" + sNo + "</td><td align='left' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+url+"\'>" + url + "</a></td><td align='center' bgcolor=\"#FF0000\">"+brokenUrlText+"</td></tr>");
					}
					}
				} else if (respCode != 200) {
					
				
					//					System.out.println("Correct Url: "+url);
					sNo++;
					html.append("<tr><td align='center'>" + sNo + "</td><td align='left' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+url+"\'>" + url + "</a></td><td align='center' bgcolor=\"#FF0000\">"+brokenUrlText+"</td></tr>");
				}
				*/
				
				if (respCode >= 400)
				{
					sNo++;
					html.append("<tr><td align='center'>" + sNo + "</td><td align='left' style = \"padding:8px;\" cellspacing=\"0\"> <a href=\'"+url+"\'>" + url + "</a></td><td align='center' style='font-size:25px;'>&#x274C;</td><td align='center'>" + respCode + "</td></tr>");
				}
			}
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@And("^initiate URL validation script on product$")
	public void brokenlinksCheck() {
		
		try {
			Hooks hook= new Hooks();
			
			createDirectory();
			startTime = new SimpleDateFormat("dd-MMM-yyyy_h.mma").format(new Date());
//			String path3="/Users/mac/Desktop/UrlValidation/UrlValidationReport"+startTime+".html";
			String path3=System.getProperty("user.dir")+"/urlvalidation/UrlValidationReport"+startTime+".html";

			File file3= new File (path3.trim());
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(file3)),true));

			manipaluteTableHead();
			tableHead();
			
			if(hook.configuration == "chrome")
			{
//				System.out.println("chrome local");
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("headless");
				chromeOptions.addArguments("window-size=1200x600");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver= new ChromeDriver(chromeOptions);
//					driver = new ChromeDriver();
			}
			else if( hook.configuration == "chromeLocal" )
			{
				System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("headless");
				chromeOptions.addArguments("window-size=1200x600");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver= new ChromeDriver(chromeOptions);
			}
			List<String> urlParameterList = new ArrayList<String>();
			urlParameterList.add("https://pickyourtrail.com/sitemap.xml");
//		urlParameterList.add("https://pickyourtrail.com/sitemap.xml");

			urlParameterList.add("https://pickyourtrail.com/sitemap-itineraries.xml");

			for (int i = 0; i < urlParameterList.size(); i++) {

				//			System.out.println("URL :" + urlParameterList.indexOf(i));
				//			
				//			if(i<1)
				//			{
				//				System.out.println("Value of i: "+i);
				sitemapURLupdate(urlParameterList.get(i));
//				System.out.println("Downloading and extracting the sitemap xml ");
				List<String> urllist = xmlExtract();
				linkvalidation(urllist);

				//			break;
				//			}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	private void reportBuilder() {
		// TODO Auto-generated method stub

		builder.add(html1.toString());
		builder.add(html.toString());

	}


	private void manipaluteValues() {

		urlsScanned=urlCount.get(0)+urlCount.get(1);
		urlsFailed=sNo;
		urlsPassed=urlsScanned-urlsFailed;

	}


	public void manipaluteTableHead()
	{

		html1.append("<html>");
		html1.append("<body>");
		html1.append(
				"<table align=\"center\" width=\"40%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" bordercolor=\"#000\"style=\"font: 11pt Arial;border-collapse:collapse;\">");
		html1.append("<tr valign= \"top\">");
		html1.append(
				"<td colspan=\"4\" align=\"center\" valign=\"middle\" style=\"font-weight: bold\" height=\"24\" font face=\"Arial\" bgcolor=\"#26cf96\"> Report for URL Validation Automation </th>");
		html1.append("</tr>");
		html1.append("<tbody>");


	}

	public void manipaluteTableTail()
	{
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"2\" width=\"80%\" align='left'>Total no. of URLs Scanned </td> <td align='center' width=\"20%\"> "+urlsScanned+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"2\" width=\"80%\" align='left'>Total no. of URLs Passed </td> <td align='center' width=\"20%\"> "+urlsPassed+"</td>");
		html1.append("</tr>");
		html1.append("<tr valign= \"top\">");
		html1.append("<td colspan=\"2\" width=\"80%\" align='left'>Total no. of URLs Failed </td> <td align='center' width=\"20%\"> "+urlsFailed+"</td>");
		html1.append("</tr>");
		html1.append("</tbody>");
		html1.append("</table>");
		html1.append("</body>");
		html1.append("</html>");
		System.out.println(html1.toString());
	}


	public void tableHead() {

		html.append("<html>");
		html.append("<body>");
		html.append("<p><font face=\"Arial\" size='4'>Below is the detailed report on the Failed URLs,</font></p>");
		html.append(
				"<table align=\"center\" width=\"90%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" bordercolor=\"#000\"style=\"font: 11pt Arial;border-collapse:collapse;\">");
		//		html.append("<tr valign= \"top\">");
		//		html.append(
		//				"<td colspan=\"3\" align=\"center\" valign=\"middle\" style=\"font-weight: bold\" height=\"24\" font face=\"Arial\" bgcolor=\"#26cf96\"> Report for URL Validation Automation </th>");
		//		html.append("</tr>");
		html.append("<tr bgcolor=\"#26cf96\">");
		html.append("<th scope=\"col\" width=\"8%\">S.No</th>");
		html.append("<th scope=\"col\" width=\"75%\">URL</th>");
		html.append("<th scope=\"col\" width=\"30%\">Status</th>");
		html.append("<th scope=\"col\" width=\"30%\">Response Code</th>");
		html.append("<tbody>");

	}


	public void tableTail() {

		if (sNo == 0) {
			html.append("<tr valign= \"top\">");
			html.append("<th colspan=\"4\" > There are No Broken URLs at this time </th>");
			html.append("</tr>");
			html.append("<tr valign= \"top\">");
			html.append("<th colspan=\"4\" bgcolor=\"#26cf96\">Total no. of URLs analyzed for sitemap.xml: "+urlCount.get(0)+"</th>");
			html.append("</tr>");
			html.append("<tr valign= \"top\">");
			html.append("<th colspan=\"4\" bgcolor=\"#26cf96\">Total no. of URLs analyzed for sitemap-itineraries.xml: "+urlCount.get(1)+"</th>");
			html.append("</tr>");
			html.append("</tbody>");
			html.append("</table>");
			html.append("</body>");
			html.append("</html>");
			System.out.println(html.toString());
		} else {
			html.append("<tr valign= \"top\">");
			html.append("<th colspan=\"4\" bgcolor=\"#26cf96\">Total no. of URLs analyzed for sitemap.xml: "+urlCount.get(0)+"</th>");
			html.append("</tr>");
			html.append("<tr valign= \"top\">");
			html.append("<th colspan=\"4\" bgcolor=\"#26cf96\">Total no. of URLs analyzed for sitemap-itineraries.xml: "+urlCount.get(1)+"</th>");
			html.append("</tr>");
			html.append("</tbody>");
			html.append("</table>");
			html.append("</body>");
			html.append("</html>");
			System.out.println(html.toString());
		}
	}


	public void sendMail()
	{
		Mail mail= new Mail();

		Email fromEmail = new Email();
		fromEmail.setName("QA Team");
		fromEmail.setEmail("qa@pickyourtrail.com");
		mail.setFrom(fromEmail);

		mail.setSubject("URL Validation Report");

		Personalization personalization = new Personalization();
		Email to = new Email();
//		to.setName("Marketing Team");
		
		to.setEmail("divya@pickyourtrail.com");
		personalization.addTo(to);
		Email cc = new Email();
//		cc.setName("CC User");
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


	@And("^send the report to all stakeholders$")
	public void tearDown()
	{

//		driver.quit();
		manipaluteValues();
		manipaluteTableTail();
		tableTail();
//		reportBuilder();
		sendMail();
	}


/*
	public void sendMail()
	{
		Email from = new Email("sai.v@pickyourtrail.com");
	    String subject = "URL Validation Report";
	    Email to = new Email("sai.v@pickyourtrail.com");
	    Content content = new Content("text/html", html1.toString()+html.toString());
	    Mail mail = new Mail(from, subject, to, content);
	    SendGrid sg = new SendGrid("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");
	    sg.addRequestHeader("X-Mock", "true");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
//	      System.out.println(response.getStatusCode());
//	      System.out.println(response.getBody());
//	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
	}
*/	
	
	public void createDirectory()
	{
		try {
			File file = new File(System.getProperty("user.dir")+"/urlvalidation");
			if (!file.exists()) {
			    if (file.mkdir()) {
			        System.out.println("Directory is created!");
			    } else {
			        System.out.println("Failed to create directory!");
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Problem while creating directory ");
			e.printStackTrace();
		}
	}
	
}
