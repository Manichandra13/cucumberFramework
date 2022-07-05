package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiscountPricingPage {

	// Hotel xpath
	
	@FindBy(xpath = "(//div[@name='all-hotel-panels']//b)[1]")
	private WebElement hotelPrice;

	@FindBy(xpath = "(//i[contains(@class,'pyt-edit')])[2]")
	private WebElement discountIcon;

	@FindBy(xpath = "(//div[@name='all-hotel-panels']//section[contains(@class,'inclusion-box')])[1]")
	private WebElement hotelPanel;

	@FindBy(xpath = "//div[contains(@class,'modal-header')]")
	private WebElement rateMatchPanel;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement adminPriceField;

	@FindBy(xpath = "//span[contains(text(),'Update')]")
	private WebElement rateMatchUpdate;

	@FindBy(xpath = "//span[contains(@class,'discount-ribbon')]")
	private WebElement adminPriceLabel;

	@FindBy(xpath = "//b[contains(@class,'itinerary-tracker')]")
	private WebElement ChangePassengerInfo;

	// Flight xpath

	@FindBy(xpath = "(//div[@name='all-flight-panels']//i[contains(@class,'pyt-edit')])[1]")
	private WebElement flightdiscountIcon;

	@FindBy(xpath = "(//div[@name='all-flight-panels']//b)[1]")
	private WebElement flightPrice;

	@FindBy(xpath = "//a[text()='Flight ']//span")
	private WebElement flightCount;

	@FindBy(xpath = "//a[text()='Activity ']//span")
	private WebElement activityCount;

	@FindBy(xpath = "//input[@placeholder='Type your other source']")
	private WebElement airportHotelSourceText;

	@FindBy(xpath = "//a[text()='Transfer ']//span")
	private WebElement transferCount;

	@FindBy(xpath = "//button[contains(text(),'Change to shared')]/../../div/following::i[contains(@class,'pyt-edit')]")
	private List<WebElement> transferEditOptions;
	
	@FindBy(xpath = "//span[contains(@class,'discount-ribbon')]/../../../../..//div[1]//button[2]")
	private WebElement transferType;

	public WebElement getTransferType() {
		return transferType;

	}


	public List<WebElement> getTransferEditOptions() {
		return transferEditOptions;

	}

	public WebElement getTransferCount() {
		return transferCount;

	}

	public WebElement getairportHotelSourceText() {
		return airportHotelSourceText;

	}

	public WebElement getActivityCount() {
		return activityCount;
	}

	public WebElement getFlightCount() {
		return flightCount;
	}

	public WebElement getFlightDiscountIcon() {
		return flightdiscountIcon;
	}

	public WebElement getChangePassengerInfo() {
		return ChangePassengerInfo;
	}

	public WebElement getAdminPricelabel() {
		return adminPriceLabel;
	}

	public WebElement getRateMatchUpdate() {
		return rateMatchUpdate;
	}

	public WebElement getAdminPriceField() {
		return adminPriceField;
	}

	public WebElement getDiscountIcon() {
		return discountIcon;
	}

	public WebElement getHotelPrice() {
		return hotelPrice;
	}

	public WebElement getHotelPanel() {
		return hotelPanel;
	}

	public WebElement getRateMatchPanel() {
		return rateMatchPanel;

	}

}
