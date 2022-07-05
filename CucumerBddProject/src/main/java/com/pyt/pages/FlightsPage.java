package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage {
	
	@FindBy(xpath = "(//div[@name='all-flight-panels']//i[contains(@class,'pyt-serif-info')])[1]")
	WebElement flightViewDetails;
	
	@FindBy(xpath="//div[@name='all-flight-panels']//section[2]//div//button[1]")
	WebElement internalFlightViewDetails;

	@FindBy(xpath = "//button[text()='Change Flight']")
	WebElement flightChangeButton;

	@FindBy(xpath = "(//div[@name='all-flight-panels']//i[contains(@class,'pyt-serif-info')])[2]")
	WebElement intlFlightViewDetails;

	@FindBy(xpath = "(//section[@class='flight-card '])[1]")
	WebElement flightReplaceFirstFlight;

	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement flightAddToItineraryButton;
	
	@FindBy(xpath = "//div[contains(@class,'smart-filter')]/*/span")
	WebElement flightSmartFilter;
	
	@FindBy(xpath = "//div/a[@title='Direct']")
	WebElement directFlightsFilter;
	
	@FindBy(xpath = "//div/a[@title='1 stop']")
	WebElement oneStopFlightsFilter;
	
	@FindBy(xpath = "//div/a[@title='2 stops']")
	WebElement twoStopsFlightFilter;

//	@FindBy(xpath = "//div[contains(text(),'Onward departure')]/following-sibling::*//a[@title='Early Morning']")
//	WebElement depEarlyMorningFlights;

	@FindBy(xpath = "(//a[@title='Early Morning'])[1]")
	WebElement depEarlyMorningFlights;

	@FindBy(xpath = "(//a[@title='Early Morning'])[2]")
	WebElement arrEarlyMorningFlights;
	
	@FindBy(xpath = "//button[@class='confirm']")
	WebElement arrivalDateChanged;
	
	@FindBy(xpath = "(//a[@title='Morning'])[1]")
	WebElement depMorningFlights;

	@FindBy(xpath = "(//a[@title='Morning'])[2]")
	WebElement arrMorningFlights;

	@FindBy(xpath = "(//a[@title='Mid-Day'])[1]")
	WebElement depMiddayFlights;

	@FindBy(xpath = "(//a[@title='Mid-Day'])[2]")
	WebElement arrMiddayFlights;

	@FindBy(xpath = "(//a[@title='Night'])[1]")
	WebElement depNightFlights;

	@FindBy(xpath = "(//a[@title='Night'])[2]")
	WebElement arrNightFlights;

	@FindBy(xpath = "//a[@title='Refundable']")
	WebElement refundableFlights;

	@FindBy(xpath = "//a[@title='Non Refundable']")
	WebElement nonRefundableFlights;

	@FindBy(xpath = "//li[contains(text(),'more flight options')]")
	WebElement moreFlightOptions;

	@FindBy(xpath = "//section[@class='flight-card  active']/following-sibling::*//input[@id='option_1']/../label/i")
	WebElement flightOpt;

	@FindBy(xpath = "//section[@class='flight-card  active']//*/button[contains(text(),'Replace')]")
	WebElement sameFlightReplace;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong)[1]")
	WebElement flightCardOnwDepTime;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong/span)[1]")
	WebElement flightCardOnwDepCity;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong)[2]")
	WebElement flightCardOnwArrTime;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong/span)[2]")
	WebElement flightCardOnwArrCity;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong)[3]")
	WebElement flightCardRetDepTime;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong/span)[3]")
	WebElement flightCardRetDepCity;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong)[4]")
	WebElement flightCardRetArrTime;

	@FindBy(xpath = "(//section[@class='flight-card ']//*/p[@class='split-width']/strong/span)[4]")
	WebElement flightCardRetArrCity;

	@FindBy(xpath = "//div[contains(text(),'Provider')]/following-sibling::*//a[(contains(@class,'active'))]")
	WebElement changeProvider;
	
	@FindBy(xpath = "//div[@class='option-header']/p")
	WebElement availableAlternateFlightsCount;
	
	@FindBy(xpath="//div[@name='all-flight-panels']//section[2]//button[(text()='Add')]")
	WebElement internalFlightAddButton;
	
	@FindBy(xpath="//div[@name='all-flight-panels']//button[(text()='Add')]")
	WebElement internationalFlightAddButton;
	
	@FindBy(xpath="//div[contains(@class,'NoItems__NoItems')]")
	WebElement noItemsAvailable;

	@FindBy(xpath= "//span[contains(text(),'SKYPICKER')] | //span[contains(text(),'PYTON')]")
	WebElement internalFlightApi;
	
	public WebElement getInternalFlightAPI() {
		return internalFlightApi;
	
	}
	public WebElement getInternationalFlightAddButton() {
		return internationalFlightAddButton;
	}

	public WebElement getInternalFlightAddButton() {
		return internalFlightAddButton;
	}

	public WebElement getInternalFlightViewDetails() {
		return internalFlightViewDetails;
	}
	
	public WebElement getAvailableAlternateFlightsCount() {
		return availableAlternateFlightsCount;
	}

	public WebElement getFlightViewDetails() {
		return flightViewDetails;
	}

	public WebElement getFlightChangeButton() {
		return flightChangeButton;
	}

	public WebElement getFlightReplaceFirstFlight() {
		return flightReplaceFirstFlight;
	}

	public WebElement getflightAddToItineraryButton() {
		return flightAddToItineraryButton;
	}
	
	public WebElement getFlightSmartFilter() {
		return flightSmartFilter;
	}
	
	public WebElement getDirectFlights() {
		return directFlightsFilter;
	}
	
	public WebElement getOneStopFlights() {
		return oneStopFlightsFilter;
	}
	
	public WebElement getTwoStopFlights() {
		return twoStopsFlightFilter;
	}

	public WebElement getOnwardEarlyMorningFlights() {
		return depEarlyMorningFlights;
	}

	public WebElement getReturnEarlyMorningFlights() {
		return arrEarlyMorningFlights;
	}

	public WebElement getOnwardMorningFlights() {
		return depMorningFlights;
	}

	public WebElement getReturnMorningFlights() {
		return arrMorningFlights;
	}

	public WebElement getOnwardMiddayFlights() {
		return depMiddayFlights;
	}

	public WebElement getReturnMiddayFlights() {
		return arrMiddayFlights;
	}

	public WebElement getOnwardNightFlights() {
		return depNightFlights;
	}

	public WebElement getReturnNightFlights() {
		return arrNightFlights;
	}

	public WebElement getRefundableFlights() {
		return refundableFlights;
	}

	public WebElement getNonRefundableFlights() {
		return nonRefundableFlights;
	}

	public WebElement getMoreFlightOpts() {
		return moreFlightOptions;
	}

	public WebElement chooseFlightOption() {
		return flightOpt;
	}

	public WebElement replaceWithinSameFlight() {
		return sameFlightReplace;
	}

	public WebElement getOnwDepTimeFromFlightCard() {
		return flightCardOnwDepTime;
	}

	public WebElement getOnwDepCityFromFlightCard() {
		return flightCardOnwDepCity;
	}

	public WebElement getOnwArrTimeFromFlightCard() {
		return flightCardOnwArrTime;
	}

	public WebElement getOnwArrCityFromFlightCard() {
		return flightCardOnwArrCity;
	}

	public WebElement viewInternalFlightDetails() {
		return intlFlightViewDetails;
	}

	public WebElement changeInternalFlightProvider() {
		return changeProvider;
	}
	
	public WebElement getArrivalDateChanged() {
		return arrivalDateChanged;
	}
	
	public WebElement getNoItemsAvailable() {
		return noItemsAvailable;
	}

}
