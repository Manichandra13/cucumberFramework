package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizePage {

	
	@FindBy(xpath="//input[contains(@placeholder,'Search from over 3000 cities')]")
	private WebElement landingSearchBox;
	
	@FindBy(xpath="//div[contains(@class,'search-suggestions')]/div/div")
	private WebElement regionSelection;
	
	//Recently Booked Itinerary
	@FindBy(xpath="(//div[@class='booking-card n-tracker-rb-itinerary'])[1]")
	private WebElement rbItinerary;
	
	//Visa on arrival 🚀 destinations
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-visaonarrival-card'])[1]")
	private WebElement visaOnArriItinerary;
	
	//Great family 👪 holidays
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-familyholidays-card'])[1]")
	private WebElement familyHolidaysItinerary;
	
	// Romantic 💑 holidays
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-romanticholidays-card'])[1]")
	private WebElement romanticHolidaysItineary;
	
	//Adventure 🏄‍ trips
			
	@FindBy(xpath="(//div[@class='holiday-card n-tracker-adventuretrip-card'])[1]")
	private WebElement adventureTrips;
	
	@FindBy(xpath="//span[@class='pos-r anchor-link']/span")
	private WebElement departureCityLink;
	

	
	public WebElement getlandingSearchBox() {
		return landingSearchBox;
	}
	public WebElement getregionSelection() {
		return regionSelection;
	}
	
	public WebElement getDepartureCitySelection() {
		return departureCityLink;
	}
}
