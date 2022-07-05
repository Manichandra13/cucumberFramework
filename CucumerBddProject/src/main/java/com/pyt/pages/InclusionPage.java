package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InclusionPage {

	// Inclusions Link
   // Please don't not change this xpath  
	@FindBy(xpath = "//*[contains(text(),\"What’s included?\")]")
	WebElement inclusionsTabLink;

	// Header Section of container which shows High level Number of flights hotels
	// associated with the itinerary

	@FindBy(xpath = "//section[@class='section-tab-links ']//li[1]/a")
	WebElement totalNoOfFlights;

	@FindBy(xpath = "//section[@class='section-tab-links ']//li[2]/a")
	WebElement totalNoOfHotels;

	@FindBy(xpath = "//section[@class='section-tab-links ']//li[3]/a")
	WebElement totalNoOfTransfers;

	@FindBy(xpath = "//section[@class='section-tab-links ']//li[4]/a")
	WebElement totalNoOfActivites;

	@FindBy(xpath = "//section[@class='section-tab-links ']//li[5]/a")
	WebElement totalNoOfVisas;
	// Sectionspanels for flights

	@FindBy(xpath = "//div[contains(@class,'clearfix fw incl-box-container')]//button[@class='btn btn-default btn-outline btn-outline-bg btn-sm'][contains(text(),'Change')]")
	WebElement changeButton;

	@FindBy(xpath = "//h3[contains(text(),'Flights')]")
	WebElement flightCard;
	
	@FindBy(xpath = "//button[contains(text(),'Retry')]")
	WebElement retryFlight;

	public WebElement getRetryFlight() {
		return retryFlight;
	}

	public WebElement getTotalNoOfFlights() {
		return totalNoOfFlights;
	}

	public void setTotalNoOfFlights(WebElement totalNoOfFlights) {
		this.totalNoOfFlights = totalNoOfFlights;
	}

	public WebElement getTotalNoOfHotels() {
		return totalNoOfHotels;
	}

	public void setTotalNoOfHotels(WebElement totalNoOfHotels) {
		this.totalNoOfHotels = totalNoOfHotels;
	}

	public WebElement getTotalNoOfTransfers() {
		return totalNoOfTransfers;
	}

	public void setTotalNoOfTransfers(WebElement totalNoOfTransfers) {
		this.totalNoOfTransfers = totalNoOfTransfers;
	}

	public WebElement getTotalNoOfActivites() {
		return totalNoOfActivites;
	}

	public void setTotalNoOfActivites(WebElement totalNoOfActivites) {
		this.totalNoOfActivites = totalNoOfActivites;
	}

	public WebElement getTotalNoOfVisas() {
		return totalNoOfVisas;
	}

	public void setTotalNoOfVisas(WebElement totalNoOfVisas) {
		this.totalNoOfVisas = totalNoOfVisas;
	}

	public void setPassSection(WebElement passSection) {
		this.passSection = passSection;
	}

	public void setSummarySection(WebElement summarySection) {
		this.summarySection = summarySection;
	}


	@FindBy(xpath = "//div[@name='all-flight-panels']")
	WebElement flightSection;

	// Sectionspanels for Hotels

	@FindBy(xpath = "//div[@name='all-hotel-panels']")
	WebElement hotelSection;

	// Sectionspanels for Transfers

	@FindBy(xpath = "//div[@name='all-transfer-panels']")
	WebElement transferSection;

	//SectionPanels for ferry
	@FindBy(xpath = "//section[contains(@class,'route-details')]//i[contains(@class,'pyt-ship')]")
	WebElement ferrySection;

	@FindBy(xpath = "(//div[@name='all-transfer-panels']//i[contains(@class,'pyt-train')])[4]")
	WebElement trainSection;


	// Sectionspanels for Activities

	@FindBy(xpath = "//div[@name='all-activity-panels']")
	WebElement activitySection;

	// Sectionspanels for Visa&Insurance

	@FindBy(xpath = "//div[@name='all-visa-panels']")
	WebElement visaSection;

	// Sectionspanels for pass
	@FindBy(xpath = "//div[@name='all-pass-panels']")
	WebElement passSection;

	// Sectionspanels for Summary

	@FindBy(xpath = "//div[@name='all-summary']")
	WebElement summarySection;

	public WebElement getSummarySection() {
		return summarySection;
	}

	public WebElement getPassSection() {
		return passSection;
	}

	public void setInclusionsTabLink(WebElement inclusionsTabLink) {
		this.inclusionsTabLink = inclusionsTabLink;
	}

	public void setFlightSection(WebElement flightSection) {
		this.flightSection = flightSection;
	}

	public void setHotelSection(WebElement hotelSection) {
		this.hotelSection = hotelSection;
	}

	public void setTransferSection(WebElement transferSection) {
		this.transferSection = transferSection;
	}

	public void setActivitySection(WebElement activitySection) {
		this.activitySection = activitySection;
	}

	public void setVisaSection(WebElement visaSection) {
		this.visaSection = visaSection;
	}

	public void setChangeButton(WebElement changeButton) {
		this.changeButton = changeButton;
	}

	public void setFlightCard(WebElement flightCard) {
		this.flightCard = flightCard;
	}

	public WebElement getInclusionsTabLink() {
		return inclusionsTabLink;
	}

	public WebElement getFlightSection() {
		return flightSection;
	}

	public WebElement getHotelSection() {
		return hotelSection;
	}

	public WebElement getTransferSection() {
		return transferSection;
	}

	public WebElement getActivitySection() {
		return activitySection;
	}

	public WebElement getVisaSection() {
		return visaSection;
	}

	public WebElement getChangeButton() {
		return changeButton;
	}

	public WebElement getFlightCard() {
		return flightCard;
	}

	public WebElement getFerrySection() {
		return ferrySection;
	}


	public WebElement getTrainSection() {
		return trainSection;
	}


}
