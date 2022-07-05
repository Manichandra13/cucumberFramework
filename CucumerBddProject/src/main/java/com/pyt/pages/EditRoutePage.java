package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditRoutePage {


	@FindBy(xpath ="//div/*/span[contains(text(),'Customize')]")
	WebElement editRouteCustomize;

    @FindBy(xpath ="//div[contains(@class,'active')]//i[contains(@class,'pyt-delete')]")
	WebElement delete;

    @FindBy(xpath ="//div[contains(@class,'active')]//p")
	WebElement firstCityInEditRoute;

	@FindBy(xpath ="//button[contains(text(),'Update itinerary')]")
	WebElement updateItinerary;

	@FindBy(xpath ="(//section[contains(@class,'timeline-content')]//p)[2]")
	WebElement firstCityInYourRoute;


	@FindBy(xpath ="(//div[@class='row activity-title']//b)[2]")
	WebElement firstCityInItnCard;


	@FindBy(xpath ="(//span[text()='City'])[1]")
	WebElement addCity;

	@FindBy(xpath ="(//div[contains(@class,'replace-city slide-in')]//*/img)[1]")
	WebElement addAlternateCity;


	@FindBy(xpath ="//div[contains(@class,'active')]//span[contains(text(),'Replace')]")
	WebElement replaceCity;

	@FindBy(xpath ="//div[contains(@class,'active')]//div[contains(@class,'days-counter')]//span[1]")
	WebElement countOfNights;

	@FindBy(xpath ="//div[contains(@class,'active')]//i[contains(@class,'pyt-plus')]")
	WebElement addNight;

	@FindBy(xpath ="//div[contains(@class,'active')]//i[contains(@class,'pyt-minus')]")
	WebElement removeNight;

	@FindBy(xpath ="(//div[contains(@class,'days-counter')]//span)[1]")
	WebElement countOfNightsInYourRoute;

	@FindBy(xpath ="(//div[contains(@class,'row activity-title')]//span)[1]")
	WebElement countOfNightsInItnCard;


	public WebElement getEditRouteCustomize() {
		return editRouteCustomize;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getFirstCityInEditRoute() {
		return firstCityInEditRoute;
	}

	public WebElement getUpdateItinerary() {
		return updateItinerary;
	}

	public WebElement getFirstCityInYourRoute() {
		return firstCityInYourRoute;
	}

	public WebElement getFirstCityInItnCard() {
		return firstCityInItnCard;
	}

	public WebElement getAddCityInEditRoute() {
		return  addCity;
	}

	public WebElement getAddAlternateCity() {
		return   addAlternateCity;
	}

	public WebElement getReplaceCity() {
		return  replaceCity;
	}

	public WebElement getAddNight() {
		return  addNight;
	}

	public WebElement getRemoveNight() {
		return  removeNight;
	}

	public WebElement getCountOfNights() {
		return countOfNights;
	}

	public WebElement getCountOfNightsInYourRoute() {
		return countOfNightsInYourRoute;
	}

	public WebElement getCountOfNightsInItnCard() {
		return countOfNightsInItnCard;
	}



}
