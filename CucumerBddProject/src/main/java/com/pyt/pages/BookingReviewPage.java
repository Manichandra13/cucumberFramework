package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingReviewPage {

	@FindBy(xpath = "//section[@class='booking-pages-content']//a[contains(@href,'make-payment')]")
	private WebElement makePaymentButton;
    
	@FindBy(xpath = "//button[contains(text(),'Book now')]")
	private WebElement bookNowButton;
	
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement continueToBooking;
	
	@FindBy(xpath = "(//a[contains(text(),'Next, make payment')])[1]")
	private WebElement nextMakePayment;
	
	@FindBy(xpath = "//a[@class='btn btn-xl btn-primary']")
	private WebElement changeYourBookings;
	
	@FindBy(xpath = "//button[contains(@class,'itinerary-btn')]")
	private WebElement itineraryButton;
	
	@FindBy(xpath = "//button[contains(@class,'inclusion-btn')]")
	private WebElement inclusionButton;
	
	
	@FindBy(xpath = "//a[contains(text(),'Review Costs')]")
	private WebElement reviewCost;
	
	public WebElement getInclusionButton() {
		return inclusionButton;
		
	}
	
	public WebElement getReviewCost() {
		return reviewCost;
		
	}
	
	public WebElement getItineraryButton() {
		return itineraryButton;
		
	}
	
	
	public WebElement getChangeBooking() {
		return changeYourBookings;
		
	}
	
	public WebElement getmakePaymentButton() {
		return makePaymentButton;
	}
	
	public WebElement getbookNowButton() {
		return bookNowButton;
	}
	
	public WebElement getContinueToBooking() {
		return continueToBooking;
	}
	
	public WebElement getNextMakePayment() {
		return nextMakePayment;
	}


}
