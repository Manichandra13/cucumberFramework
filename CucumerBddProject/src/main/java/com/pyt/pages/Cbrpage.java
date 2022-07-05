package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cbrpage {


	//Packages page CBR
//	@FindBy(xpath="(//button[contains(text(),'Reserve a slot')]")
//@FindBy(xpath="//button[@class='pull-right btn']")
	@FindBy(xpath="//*[text()='Need help? Talk to an expert']")
	WebElement packagesCbr;
	//button[@class='ml-auto btn']
	//Home Page CBR
	@FindBy(xpath="//button[contains(text(),'Talk to us')]")
//	@FindBy(linkText="Talk to us!")
	WebElement homePageCbr;
	
	@FindBy(xpath="//*[text()='Share Details']")
	WebElement vacationsCbr;
	
//	//Packages page CBR
//	@FindBy(xpath="(//a[@class='tracker-pkg-talkbtn'])[1]")
//	WebElement packagesCbr;


    // Name
	@FindBy(xpath="//input[@name='name']")
	WebElement username;
	
	//Phone Number
//	@FindBy(xpath="//input[contains(@class,'phone')]")
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	WebElement phonenumber;
	
	//Email
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	//Preferred Time 
	@FindBy(xpath="//select[@name='preferredTime']")
	WebElement preferredTime;
	
	//CBR submit button
	@FindBy(xpath="//button[contains(@class,'rcb-submit')]")
	WebElement cBrSubmitButton;
	

	@FindBy(xpath="//h5[@class='medium-heading bold fade mbottom-small']")
	WebElement successfulCBRPackage;
	
	@FindBy(xpath="//button[@class='btn btn-link no-padding']")
	WebElement keepBrowsing;
	
	@FindBy(xpath = "//a[@class='logo n-tracker-pytlogo']")
	WebElement pytLogo;
	
	@FindBy(xpath="//div[@class='col-md-12 logo-img']//span//img")
	WebElement vacationsPytLogo;

	@FindBy(xpath="//a[@class='logo n-tracker-pytlogo']//img")
	WebElement packagesPytLogo;
	
	@FindBy(xpath="//h3[@class='bold mt-0 fade']")
	WebElement happyToHelp;
	
	@FindBy(xpath="//div[@class='right-col vertical-center']/a")
	WebElement firstPackage;
	
	@FindBy(xpath="//input[@placeholder='Departing from']")
	WebElement departingFrom;
	
	@FindBy(xpath="//a[text()='Chennai, IN']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='departure-date-get-cost']")
	WebElement departureDate;

	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--wed react-datepicker__day--selected']")
	WebElement currentDate;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block tracker-get-cost-modal-update-cost']")
	WebElement getCost;
	
	@FindBy(xpath="//p[contains(text(),'Got a question? Talk to us!')]")
	WebElement inclusionTravelCons;
	
	//a[contains(text(),'Talk to our travel')]
	@FindBy(xpath="//span[contains(text(),'Talk to an Expert ')]")
	WebElement itineraryTravelCons;
	
	//Text message in the alert 
	@FindBy(xpath="//p[contains(text(),'An account with the given credentials already')]")
	WebElement alertMsgCbrExisting;
	
	//Text message in the vacation page alert 
		@FindBy(xpath="//*[text()='Thanks! We will call you within 48 hours.']")
		WebElement alertMsgVactionCbr;
		
	//Ok button in the Alert message user trying to submit CBR with existing credential
	@FindBy(xpath="//button[@class='confirm']")
	WebElement okButtonInAlert;
	
	//Close button in CBR modal
	@FindBy(xpath="(//i[contains(@class,'pyt-close')])[4]")
	WebElement closeCbrModal;
	
	//CBR from inclusions page
	@FindBy(xpath="//li[contains(text(),'Talk to us')]")
	WebElement cbrFromInclusions;
	
	@FindBy(xpath="//*[text()='As Seen On']")
	WebElement customerStories;
	
	@FindBy(xpath="//*[text()='Nah, keep browsing']")
	WebElement cbrCloseVacations;
	
	@FindBy(xpath="//div[contains(@class,'minimize')]")
	WebElement packagesChatClose;
	
	public WebElement getPackagesChatClose() {
		return packagesChatClose;
	}
	
	public WebElement getCbrFromInclusions() {
		return cbrFromInclusions;
	}

	public WebElement getAlertMsgCbrExisting() {
		return alertMsgCbrExisting;
	}

	public WebElement getOkButtonInAlert() {
		return okButtonInAlert;
	}

	public WebElement getCloseCbrModal() {
		return closeCbrModal;
	}
	
	
	public WebElement getItineraryTravelCons() {
		return itineraryTravelCons;
	}

	public WebElement getTravelConsultant() {
		return inclusionTravelCons;
	}

	public WebElement getGetCost() {
		return getCost;
	}

	public WebElement getCurrentDate() {
		return currentDate;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}
	
	public WebElement getCity() {
		return city;
	}

	public WebElement getDepartingFrom() {
		return departingFrom;
	}

	public WebElement getFirstPackage() {
		return firstPackage;
	}

	public WebElement getHappyToHelp() {
		return happyToHelp;
	}

	public WebElement getVacationsPytLogo() {
		return vacationsPytLogo;
	}

	public WebElement getPytLogo() {
		return pytLogo;
	}

	public WebElement getKeepBrowsing() {
		return keepBrowsing;
	}

	public WebElement getSuccessfulCBRPackage() {
		return successfulCBRPackage;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPreferredTime() {
		return preferredTime;
	}
	
	public WebElement getPackagesCbr() {
		return packagesCbr;
	}

	public WebElement getHomePageCbr() {
		return homePageCbr;
	}

	public WebElement getcBrSubmitButton() {
		return cBrSubmitButton;
	}

	public WebElement getPackagesPytLogo() {
		return packagesPytLogo;
	}

	public WebElement getCustomerStory() {
		return customerStories;
	}
	
	public WebElement getVacationsCbr() {
		return vacationsCbr;
	}
	
	public WebElement getVactionCbrAlertMsg() {
		return alertMsgVactionCbr;
	}
	public WebElement getCbrCloseVacations() {
		return cbrCloseVacations;
	}
	
}
