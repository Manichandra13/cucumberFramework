package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

//Will change the xpath after getting the tracker class

public class SandunePage {

	@FindBy(xpath = "//span[contains(text(),'Done! Build itinerary')]")
	WebElement dubaiBuildItinerary;

	@FindBy(xpath = "//button[contains(text(),'Review Inclusions')]")
	WebElement dubaiReviewInclusions;

	@FindBy(xpath = "//*[contains(text(),\"What’s included?\")]")
	WebElement dubaiInclusionsTab;

	@FindBy(xpath = "//span[contains(text(),'Add split stay')]")
	WebElement dubaiSplitStay;

	@FindBy(xpath = "//select[contains(@class,'order-select')]")
	WebElement orderOfStay;

	@FindBy(xpath = "//select[contains(@class,'order-select')]//option[@value='START']")
	WebElement beginningStay;

	@FindBy(xpath = "//select[contains(@class,'order-select')]//option[@value='END']")
	WebElement endStay;

	@FindBy(xpath = "(//*[@class='pyt-close-16'])[1]")
	WebElement pytClose;

	@FindBy(xpath = "//select[contains(@class,'days-select')]")
	WebElement durationOfStay;

	@FindBy(xpath = "//select[contains(@class,'days-select')]//option[2]")
	WebElement durationOfDay;

	@FindBy(xpath = "//button[contains(text(),'Find hotels')]")
	WebElement findHotels;

	@FindBy(xpath = "//section[@class='hotel_card'][1]")
	WebElement hotelCard;

	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement addToItineraryCta;

	@FindBy(xpath = "//div[@name='all-hotel-panels']//i[contains(@class,'pyt-delete')]")
	WebElement deleteSplitStayHotel;

	@FindBy(xpath = "//div[contains(@class,'sweet-alert')]")
	WebElement deleteHotelAlert;

	@FindBy(xpath = "//div[contains(@class,'sweet-alert')]//button[@class='confirm']")
	WebElement deleteHotelConfirmButton;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'activity-header')]/following-sibling::p"))
	private List<WebElement> activityCardList;

	@FindBy(xpath = "//span[contains(@class,'pos-r')]")
	WebElement depCityLink;

	@FindBy(xpath = "//button[text()='View Similar']")
	WebElement activitySimiliarCta;

	@FindBy(xpath = "(//div[@name='all-transfer-panels']//button[contains(text(),'Change to shared')])[1]")
	WebElement airportHotelTransfer;

	@FindBy(xpath = "(//div[@name='all-transfer-panels']//button[contains(text(),'Change to shared')])[2]")
	WebElement hotelAirportTransfer;
	
	@FindBy(xpath = "//a[contains(text(),'Hotel')]/span")
	WebElement hotelCount;
	

	public WebElement getHotelAirportTransfer() {
		return hotelAirportTransfer;

	}

	public WebElement getAirportHotelTransfer() {
		return airportHotelTransfer;

	}

	public WebElement getActivitySimiliarCta() {
		return activitySimiliarCta;

	}

	public WebElement getDepCityLink() {
		return depCityLink;
	}

	public List<WebElement> getActivityCardList() {
		return activityCardList;
	}

	public WebElement getDeleteHotelConfirm() {
		return deleteHotelConfirmButton;
	}

	public WebElement getDeleteHotelAlert() {
		return deleteHotelAlert;
	}

	public WebElement getDeleteHotel() {
		return deleteSplitStayHotel;
	}

	public WebElement getAddToItineraryCta() {
		return addToItineraryCta;
	}

	public WebElement getHotelCard() {
		return hotelCard;
	}

	public WebElement getFindHotels() {
		return findHotels;
	}

	public WebElement getDurationOfDay() {
		return durationOfDay;
	}

	public WebElement getDurationOfStay() {
		return durationOfStay;
	}

	public WebElement getPytClose() {
		return pytClose;
	}

	public WebElement getOrderOfStay() {
		return orderOfStay;
	}

	public WebElement getBeginningStay() {
		return beginningStay;
	}

	public WebElement getEndStay() {
		return endStay;
	}

	public WebElement getAddSplitStay() {
		return dubaiSplitStay;
	}

	public WebElement getInclusionHeader() {
		return dubaiInclusionsTab;
	}

	public WebElement getBuildItinerary() {
		return dubaiBuildItinerary;
	}

	public WebElement getReviewInclusions() {
		return dubaiReviewInclusions;
	}
	
	public WebElement getHotelCount() {
		return hotelCount;
	}
}
