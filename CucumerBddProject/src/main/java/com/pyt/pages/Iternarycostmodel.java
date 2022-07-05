package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Iternarycostmodel {
	
	@FindBy(xpath="//a[@id='calculate-trip-cost-btn']")
	WebElement TripCostButton;

	@FindBy(xpath="//input[@placeholder='Departing from']")
	WebElement departingCity;
	
	@FindBy(xpath="//input[@placeholder='Departing on']")
	WebElement departingOnCitydate;
	
	@FindBy(xpath="//input[@placeholder='Arrival on']")
	WebElement arrivalOn;
	
	@FindBy(xpath = "(//button[contains(text(),'Get Cost')])[1]")
    WebElement getCostinGCM;
	
	@FindBy(xpath="(//div[contains(@class,'react-datepicker') and text()='3'])[2]")
	WebElement departingOnCitydate20;
	
	@FindBy(xpath="//div[contains(@class,'keyboard-selected') or contains(@class,'day--selected')]")
	WebElement departingOnCurrentDate;	
	
	@FindBy(xpath="//input[@class = 'form-control react-datepicker-ignore-onclickoutside']")
	WebElement datePicker;
	
	@FindBy(xpath="//span[@class = 'Select-value-label']")
	WebElement numOfPassengers;
	
	@FindBy(xpath="//input[@placeholder = 'Your name']")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@placeholder = 'Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	
	@FindBy(xpath="//input[@placeholder = 'Email']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@placeholder = 'Mobile Number']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name = 'itinerary_name']")
	WebElement itineraryName;
	
	@FindBy(xpath=("(//div[@id='itinerary_page']//*/button[contains(text(),'Get trip cost')])[1] | (//div[@id='itinerary_page']//*/button[contains(text(),'Get latest cost')])[1]"))
	WebElement calculateTripCostButton;
	
	@FindBy(xpath="//li[contains(text(),'Chennai, IN')]")
	WebElement departingFromChennai;
	
	@FindBy(xpath="//button[contains(text(),'Outside India')]")
	WebElement departingOutsideindia;
	
	@FindBy(xpath="//*[contains(text(),'Coimbatore')]")
	WebElement departingFromCoimbatore;
	
	@FindBy(xpath="//div[contains(@class,'react-datepicker__input-container')]")
	WebElement datepickerContainer;
	
	@FindBy(xpath = "//button[contains(text(),‘Book your trip’)]")
    private WebElement costingDelay;
	
	
	@FindBy(xpath = "//button[contains(text(),'Couple')]")
	WebElement passengerDetails;
	
	@FindBy(xpath = "//button[contains(@class,'get-cost')]")
	WebElement gcmGetCost;
	
	@FindBy(xpath="//button[contains(@class,'update-cost')]")
	WebElement gcmUpdateCost;
	
	@FindBy(xpath="//span[text()='BLR']")
	WebElement DepartureCityBang;
	
	@FindBy(xpath="//label[contains(@class,'custom-options')]/i")
	WebElement arrivalCityCheckBox;
	
	@FindBy(xpath="//input[@placeholder='Arriving to']")
	WebElement arrivalCity;
	
	
	
	@FindBy(xpath="//*[contains(text(),'Bengaluru')]")
	WebElement departingFromBengaluru;
	
	public WebElement getdepartingFromBengaluru() {
		return departingFromCoimbatore;
	}
	
	public WebElement getArrivalCity() {
		return arrivalCity;
		 }
	
	public WebElement getArrivalCityCheckBox() {
		return arrivalCityCheckBox;
		 }
	
	public WebElement getGcmUpdateCost() {
		return gcmUpdateCost;
		 }
	
	public WebElement getGetCostContinue() {
		return gcmGetCost;
		 }
	
	
	public WebElement getTravellingPassengersType() {
		return passengerDetails;
		 }
		    
    public WebElement getCostingDelay() {
	return costingDelay;
	 }
	
	public WebElement getdatepickerContainer() {
		return datepickerContainer;
	}
	
	public WebElement getdepartingFromCoimbatore() {
		return departingFromCoimbatore;
	}
	
	public WebElement getdepartingOutsideindia() {
		return departingOutsideindia;
	}
	
	public WebElement getdepartingFromChennai() {
		return departingFromChennai;
	}

	public WebElement getcalculateTripCostButton() {
		return calculateTripCostButton;
	}
	public WebElement getTripCostButton() {
		return TripCostButton;
	}

	public WebElement getDepartingCity() {
		return departingCity;
	}

	public WebElement getDepartingOnCitydate() {
		return departingOnCitydate;
	}
	
	public WebElement getDepartingOnCitydate20() {
		return departingOnCitydate20;
	}
	
	public WebElement getDepartingOnCurrentDate() {
		return departingOnCurrentDate;
	}

	public WebElement getDatePicker() {
		return datePicker;
	}

	public WebElement getNumOfPassengers() {
		return numOfPassengers;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getItineraryName() {
		return itineraryName;
	}
	
	public WebElement getLogin() {
		return login;
	}
	
	
	public WebElement getPasssword() {
		return password;
	}
	
	public WebElement getArrivalOn() {
		return arrivalOn;
	}
	public WebElement getgetCostinGCM() {
        return getCostinGCM;
    }

}
