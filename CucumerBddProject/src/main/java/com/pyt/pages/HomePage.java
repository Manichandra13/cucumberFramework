package com.pyt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//User initial after login 
	@FindBy(xpath="//span[@class='user-initials']")
	private WebElement userInitialPostLogin;

	public WebElement getUserInitialPostLogin() {
		return userInitialPostLogin;
	}

	// PICK YOUR TRAIL LOGO
	@FindBy(xpath = "//a[contains(@class,'pytlogo')]")
	private WebElement PytLogo;
	

	//
	@FindBy(linkText = "Login")
	private WebElement login;

	@FindBy(linkText = "Testimonials")
	private WebElement testimonials;

	@FindBy(linkText = "Guides")
	private WebElement guides;

	@FindBy(linkText = "About us")
	private WebElement aboutUs;

	@FindBy(linkText = "Careers")
	private WebElement careers;

	@FindBy(linkText = "Blog")
	private WebElement blog;

	@FindBy(xpath = "//i[@class='vehoicon-ion-more']")
	private WebElement vehoIcon;

	@FindBy(linkText = "Visa")
	private WebElement visa;

	@FindBy(linkText = "FAQ")
	private WebElement faq;

	@FindBy(linkText = "Contact us")
	private WebElement contactUs;

	@FindBy(xpath = "//button[text()='Start Planning'] | //i[contains(@class,'pyt-search')]")
	private WebElement startPlanningNowButton;

	@FindBy(linkText = "+91 9790733699")
	private WebElement callNumber;

	// recently booked itinerary

	@FindBy(xpath = "(//div[contains(@class,'emojiMapMarker')]/span)[1]")
	private WebElement recentlyBookedItinerary;
	
	@FindBy(xpath = "//*[contains(@class,'PromoSection__PromoContainer')]")
	private WebElement promoSection;
	
	// visa on arrival card

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-visaonarrival-card'])[1]")
	private WebElement visaOnArrivalItinerary;

	// Great family 👪 holidays

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-familyholidays-card'])[1]")
	private WebElement familVacationItinerary;

	@FindBy(xpath = "(//*[@class='pull-right btn btn-default btn-outline btn-sm n-tracker-familyholidays-exploremore'])")
	private WebElement familyVacationExplore;
	
	// Romantic 💑 holidays

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-romanticholidays-card'])[1]")
	private WebElement romanticHolidaysItinerary;

	// Adventure 🏄‍ trips
	@FindBy(xpath = "//a[contains(@class,'adventuretrip-exploremore')]")
	private WebElement adventureTripsItinerary;

	// Beach 🏖️ vacations

	@FindBy(xpath = "(//*[@class='holiday-card n-tracker-beachvacations-card'])[2]")
	private WebElement beachVacationItinerary;
	
	//Paid Campaign Page for Australia
	
	@FindBy(xpath = "//a[contains(text(),'Explore Australia')]")
	private WebElement auspkg;
	
	@FindBy(xpath ="//a[contains(@class,'adventuretrip-exploremore')]")
	   public WebElement adventureTripsPackages;
	
	@FindBy(xpath ="//a[@class='n-tracker-yourvacations']")
	   public WebElement yourVacationsFromHomePage;
	
	
	@FindBy(xpath ="//span[@class='user-initials']")
	public WebElement userLoggedInitial;
	
	@FindBy(xpath ="//p[@class='booked-txt']")
	public WebElement bookedItinerayFromHomePage;
	
	@FindBy(xpath ="//i[contains(@class,'pyt-search')]")
	public WebElement searchDestination;
	
	@FindBy(xpath="(//*[contains(@class,'PackageGrid__PackageColumn')])[1]")
	public WebElement packageSlugItineraryHomePage;
	
	public WebElement getPackageSlugItineraryHomePage() {
		return packageSlugItineraryHomePage;
	}

	public WebElement getSearchDestination() {
        return searchDestination;
    }
	
	public WebElement getUserLoggedInitial() {
        return userLoggedInitial;
    }

	public WebElement getAdventureTripsPackages() {
        return  adventureTripsPackages;
    }

	// recently booked itinerary
	public WebElement getrecentlyBookedItinerary() {
		return recentlyBookedItinerary;
	}

//visaOnArrivalItinerary
	public WebElement getvisaOnArrivalItinerary() {
		return visaOnArrivalItinerary;
	}

	// familVacationItinerary
	public WebElement getfamilVacationItinerary() {
		return familVacationItinerary;
	}

//romanticHolidaysItinerary
	public WebElement getromanticHolidaysItinerary() {
		return romanticHolidaysItinerary;
	}

	// adventureTripsItinerary
	public WebElement getadventureTripsItinerary() {
		return adventureTripsItinerary;
	}

	// beachVacationItinerary
	public WebElement getbeachVacationItinerary() {
		return beachVacationItinerary;
	}

	public WebElement getstartPlanningNowButton() {
		return startPlanningNowButton;
	}

	public WebElement getPytLogo() {
		return PytLogo;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getTestimonials() {
		return testimonials;
	}

	public WebElement getGuides() {
		return guides;
	}

	public WebElement getAboutUs() {
		return aboutUs;
	}

	public WebElement getCareers() {
		return careers;
	}

	public WebElement getBlog() {
		return blog;
	}

	public WebElement getVehoIcon() {
		return vehoIcon;
	}

	public WebElement getVisa() {
		return visa;
	}

	public WebElement getFaq() {
		return faq;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getCallNumber() {
		return callNumber;
	}

	public WebElement getExploreFamilyVacations()
	{
		return familyVacationExplore;
	}
	
	public WebElement goToAusPaidCampaignPage()
	{
		return auspkg;
	}
	
	public WebElement getYourVactionsFromHomePage()
	{
		return yourVacationsFromHomePage;
	}
	
	public WebElement getBookedItinerayFromHomePage()
	{
		return bookedItinerayFromHomePage;
	}
	
	public WebElement getPromoSection()
	{
		return promoSection;
	}
	
}
