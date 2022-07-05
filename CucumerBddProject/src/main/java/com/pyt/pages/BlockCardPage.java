package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlockCardPage {

	@FindBy(xpath = "//div[@class='clearfix']")
	private List<WebElement> routeCardBlockCard;

	@FindBy(xpath = "(//section[@class='inclusion-box   error']//button[contains(text(),'Add Custom Item')])[1]")
	private WebElement blockCardFlightInternational;

	@FindBy(xpath = "//div[@name='all-flight-panels']//section[2]//button[contains(text(),'Add Custom Item')]")
	private WebElement blockCardFlightInternal;

	@FindBy(xpath = "//button[contains(text(),'ROUND TRIP')]")
	private WebElement roundTripFlightBlockCard;

	@FindBy(xpath = "//button[contains(text(),'One Way')]")
	private WebElement oneWayFlightBlockCard;

	@FindBy(xpath = "//button[contains(text(),'Multi City')]")
	private WebElement multipleCityFlightBlockCard;

	@FindBy(xpath = "(//*[contains(text(),'Internet Source')]/..//div)[1]")
	private WebElement flightBlockCardInternerSource;

	@FindBy(xpath = "//*[text()='Reason for Block card']")
	private WebElement reasonForFlightBlockCard;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Internet Cost')]")
	private WebElement internetCostFlightBlockCard;

	@FindBy(xpath = "//input[contains(@name,'carrierName')]/../div")
	private List<WebElement> airlineCodeFlightBlockCard;

	@FindBy(xpath = "//input[@name='flightNumber']")
	private List<WebElement> flightNumberBlockCard;

	@FindBy(xpath = "//label[text()='Departure City']/../div")
	private List<WebElement> departureCityFlightBlockCard;

	@FindBy(xpath = "//input[@name='arrivalCity']/../div")
	private List<WebElement> arrivalCityFlightBlockCard;

	@FindBy(xpath = "(//div[@name='all-hotel-panels']//div/section[1]//span)[2]")
	private WebElement hotelCheckinDateInclusionFlightBlockCard;

	@FindBy(xpath = "//span[contains(text(),'Add Route')]")
	private List<WebElement> addRouteFlightBlockCard;

	@FindBy(xpath = "//label[text()='Departure Time']/..//input[@placeholder='HH:mm']")
	private List<WebElement> departureTimeFlightBlockCard;

	@FindBy(xpath = "//label[text()='Arrival Time']/..//input[@placeholder='HH:mm']")
	private List<WebElement> arrivalTimeFlightBlockCard;

	@FindBy(xpath = "//label[text()='Departure Date']/../div/input")
	private List<WebElement> departureDateFlightBlockCard;

	@FindBy(xpath = "//label[text()='Arrival Date']/../div/input")
	private List<WebElement> arrivalDateFlightBlockCard;

	@FindBy(xpath = "//input[@class='rc-time-picker-panel-input']")
	private WebElement timeFlightBlockCard;

	@FindBy(xpath = "//input[@type='number' and @placeholder='2']")
	private List<WebElement> baggageFlightBlockCard;

	@FindBy(xpath = "//div[@name='all-flight-panels']//button[contains(text(),'Edit Card')]")
	private WebElement editCardButtonFlightBlockCard;

	@FindBy(xpath = "(//div[@name='all-flight-panels']//section[2]//p/span)[1]")
	private WebElement internalFlightDepartureDate;

	// Xpath for hotel block card form
	@FindBy(xpath = "(//div[contains(@name,'all-hotel-panels')]//button[contains(text(),'Add Custom Item')])[1]")
	private WebElement blockCardHotel;

	// @FindBy(xpath="//input[@name='hotel-name']/../div")
	// @FindBy(xpath="//div[contains(text(),'Name of the hotel')]")
	@FindBy(xpath = "//div[contains(text(),'Name of the hotel')]/..")
	private WebElement hotelNameBlockCard;

	@FindBy(xpath = "//div[contains(text(),'Internet Provider')]/..")
	private WebElement internetProviderHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Free Wireless')]/..//button[contains(@class,'active')]")
	private WebElement wirelessActiveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Free Breakfast')]/..//button[contains(text(),'Yes')]")
	private WebElement breakFastActiveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Refundable')]/..//button[contains(text(),'Yes')]")
	private WebElement refundableActiveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'Ac Available')]/..//button[contains(text(),'Yes')]")
	private WebElement acActiveHotelBlock;

	@FindBy(xpath = "//button[contains(text(),'Save & Create')]")
	private WebElement saveHotelBlockCard;

	@FindBy(xpath = "//p[contains(text(),'* All the fileds are madatory')]")
	private WebElement alertHotelBlockCard;

	@FindBy(xpath = "//input[@placeholder='Check in Date' and contains(@disabled,'')]")
	private WebElement checkInDateOfHotelFromBlockCard;

	@FindBy(xpath = "//input[@placeholder='Check out Date' and contains(@disabled,'')]")
	private WebElement checkOutDateOfHotelFromBlockCard;

	@FindBy(xpath = "//input[@placeholder='City Name' and contains(@disabled,'')]")
	private WebElement cityNameHotelBlockCard;

	@FindBy(xpath = "//div[contains(@class,'Collapsible__trigger is-open  panel-heading accordion-toggle')]")
	private WebElement roomPanelOpenHotelBlockCard;

	@FindBy(xpath = "//div[contains(@class,'Collapsible__trigger is-closed  panel-heading accordion-toggle')]")
	private WebElement roomPanelCloseHotelBlockCard;

	@FindBy(xpath = "//input[@name='roomDescription']")
	private WebElement roomCategoryHotelBlockCard;

	@FindBy(xpath = "//input[contains(@placeholder,'Internet Cost')]")
	private WebElement internetCostHotelBlockCard;

	@FindBy(xpath = "//input[@name='taRating']")
	private WebElement taRatingHotelBlockCard;

	@FindBy(xpath = "//input[@name='starRating']")
	private WebElement starRatingHotelBlockCard;

	@FindBy(xpath = "//div[@name='all-hotel-panels']//button[contains(text(),'Edit Card')]")
	private WebElement editCardButtonHotelBlockCard;

	@FindBy(xpath = "//input[@name='reasonForBlockCard']/../div")
	private WebElement reasonSectionHotelBlockCard;

	@FindBy(xpath = "//section[@class='inclusion-box cursor-pointer  error']//div/h4")
	private WebElement hotelCityNameAfterRemoved_InclusionCard;

	@FindBy(xpath = "//section[@class='inclusion-box cursor-pointer  error']//div//p/span[1]")
	private WebElement checkInDateAfterRemoved_InclusionCard;

	@FindBy(xpath = "//section[@class='inclusion-box cursor-pointer  error']//div//p/span[2]")
	private WebElement checkOutDateAfterRemoved_InclusionCard;

	@FindBy(xpath = "//p[contains(text(),'* All the fileds are madatory')]")
	private WebElement mandatoryFieldAlertHotelBlockCard;

	@FindBy(xpath = "//div[contains(@class,'menu')]/div/div[1]")
	private WebElement dbHotelFirstElementBlockCard;

	// Xpath for other block card form
	@FindBy(xpath = "//div[@name='all-others-panels']/../div/button[contains(text(),'Add Custom Item')]")
	private WebElement othersBlockCard;

	@FindBy(xpath = "//div[@name='all-others-panels']/../div/button[contains(text(),'Add Custom Item') and @disabled]")
	private WebElement otherBlockCardDisabled;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleFieldOtherBlockCard;

	@FindBy(xpath = "//input[@name='source']")
	private WebElement sourceFieldOtherBlockCard;

	@FindBy(xpath = "//div[contains(@class,'DraftEditor-editorContainer')]")
	private WebElement descFieldOtherBlockCard;

	@FindBy(xpath = "//input[@name='ourCost']")
	private WebElement costFieldOtherBlockCard;

	@FindBy(xpath = "//input[@name='publishedCost']")
	private WebElement publishedCostFieldOtherBlockCard;

	@FindBy(xpath = "//div[@name='all-others-panels']//button[contains(text(),'Edit Card')]")
	private WebElement editCardButtonOtherBlockCard;

	@FindBy(xpath = "//*[text()='Reason']")
	private WebElement reasonFieldOtherBlockCard;

	@FindBy(xpath = "//div[@name='all-others-panels']//button/i")
	private WebElement deleteButtonOtherBlockCard;

	@FindBy(xpath = "//div[contains(@name,'all-others-panels')]")
	private WebElement otherBlockCardInclusion;

	public List<WebElement> getRouteCardBlockCard() {
		return routeCardBlockCard;
	}

	public WebElement getInternalFlightDepartureDate() {
		return internalFlightDepartureDate;
	}

	public List<WebElement> getBaggageFlightBlockCard() {
		return baggageFlightBlockCard;
	}

	public WebElement getTimeFlightBlockCard() {
		return timeFlightBlockCard;
	}

	public List<WebElement> getDepartureDateFlightBlockCard() {
		return departureDateFlightBlockCard;
	}

	public List<WebElement> getArrivalDateFlightBlockCard() {
		return arrivalDateFlightBlockCard;
	}

	public List<WebElement> getAddRouteFlightBlockCard() {
		return addRouteFlightBlockCard;
	}

	public List<WebElement> getDepartureTimeFlightBlockCard() {
		return departureTimeFlightBlockCard;
	}

	public WebElement getHotelCheckinDateInclusionFlightBlockCard() {
		return hotelCheckinDateInclusionFlightBlockCard;
	}

	public List<WebElement> getArrivalTimeFlightBlockCard() {
		return arrivalTimeFlightBlockCard;
	}

	public List<WebElement> getArrivalCityFlightBlockCard() {
		return arrivalCityFlightBlockCard;
	}

	public List<WebElement> getDepartureCityFlightBlockCard() {
		return departureCityFlightBlockCard;
	}

	public List<WebElement> getFlightNumberBlockCard() {
		return flightNumberBlockCard;
	}

	public List<WebElement> getAirlineCodeFlightBlockCard() {
		return airlineCodeFlightBlockCard;
	}

	public WebElement getOneWayFlightBlockCard() {
		return oneWayFlightBlockCard;
	}

	public WebElement getMultipleCityFlightBlockCard() {
		return multipleCityFlightBlockCard;
	}

	public WebElement getRoundTripFlightBlockCard() {
		return roundTripFlightBlockCard;
	}

	public WebElement getReasonForFlightBlockCard() {
		return reasonForFlightBlockCard;
	}

	public WebElement getInternetCostFlightBlockCard() {
		return internetCostFlightBlockCard;
	}

	public WebElement getOtherBlockCardDisabled() {
		return otherBlockCardDisabled;
	}

	public WebElement getPublishedCostFieldOtherBlockCard() {
		return publishedCostFieldOtherBlockCard;
	}

	public WebElement getOtherBlockCardInclusion() {
		return otherBlockCardInclusion;
	}

	public WebElement getDeleteButtonOtherBlockCard() {
		return deleteButtonOtherBlockCard;
	}

	public WebElement getReasonFieldOtherBlockCard() {
		return reasonFieldOtherBlockCard;
	}

	public WebElement getEditCardButtonOtherBlockCard() {
		return editCardButtonOtherBlockCard;
	}

	public WebElement getTitleFieldOtherBlockCard() {
		return titleFieldOtherBlockCard;
	}

	public WebElement getSourceFieldOtherBlockCard() {
		return sourceFieldOtherBlockCard;
	}

	public WebElement getDescFieldOtherBlockCard() {
		return descFieldOtherBlockCard;
	}

	public WebElement getCostFieldOtherBlockCard() {
		return costFieldOtherBlockCard;
	}

	public WebElement getOthersBlockCard() {
		return othersBlockCard;
	}

	public WebElement getDbHotelFirstElementBlockCard() {
		return dbHotelFirstElementBlockCard;
	}

	public WebElement getMandatoryFieldAlertHotelBlockCard() {
		return mandatoryFieldAlertHotelBlockCard;
	}

	public WebElement getHotelCityNameAfterRemoved_InclusionCard() {
		return hotelCityNameAfterRemoved_InclusionCard;
	}

	public WebElement getCheckInDateAfterRemoved_InclusionCard() {
		return checkInDateAfterRemoved_InclusionCard;
	}

	public WebElement getCheckOutDateAfterRemoved_InclusionCard() {
		return checkOutDateAfterRemoved_InclusionCard;
	}

	public WebElement getReasonSectionHotelBlockCard() {
		return reasonSectionHotelBlockCard;
	}

	public WebElement getEditCardButtonHotelBlockCard() {
		return editCardButtonHotelBlockCard;
	}

	public WebElement getStarRatingHotelBlockCard() {
		return starRatingHotelBlockCard;
	}

	public WebElement getTaRatingHotelBlockCard() {
		return taRatingHotelBlockCard;
	}

	public WebElement getSaveHotelBlockCard() {
		return saveHotelBlockCard;
	}

	public WebElement getBreakFastActiveHotelBlockCard() {
		return breakFastActiveHotelBlockCard;
	}

	public WebElement getRefundableActiveHotelBlockCard() {
		return refundableActiveHotelBlockCard;
	}

	public WebElement getAcActiveHotelBlock() {
		return acActiveHotelBlock;
	}

	public WebElement getAlertHotelBlockCard() {
		return alertHotelBlockCard;
	}

	public WebElement getCheckInDateOfHotelFromBlockCard() {
		return checkInDateOfHotelFromBlockCard;
	}

	public WebElement getCheckOutDateOfHotelFromBlockCard() {
		return checkOutDateOfHotelFromBlockCard;
	}

	public WebElement getCityNameHotelBlockCard() {
		return cityNameHotelBlockCard;
	}

	public WebElement getRoomPanelOpenHotelBlockCard() {
		return roomPanelOpenHotelBlockCard;
	}

	public WebElement getRoomPanelCloseHotelBlockCard() {
		return roomPanelCloseHotelBlockCard;
	}

	public WebElement getRoomCategoryHotelBlockCard() {
		return roomCategoryHotelBlockCard;
	}

	public WebElement getInternetCostHotelBlockCard() {
		return internetCostHotelBlockCard;
	}

	public WebElement getBlockCardFlightInternational() {
		return blockCardFlightInternational;
	}

	public WebElement getBlockCardFlightInternal() {
		return blockCardFlightInternal;
	}

	public WebElement getBlockCardHotel() {
		return blockCardHotel;
	}

	public WebElement getFlightBlockCardInternerSource() {
		return flightBlockCardInternerSource;
	}

	public WebElement getHotelNameBlockCard() {
		return hotelNameBlockCard;
	}

	public WebElement getInternetProviderHotelBlockCard() {
		return internetProviderHotelBlockCard;
	}

	public WebElement getWirelessActiveHotelBlockCard() {
		return wirelessActiveHotelBlockCard;
	}

	public WebElement getEditCardButtonFlightBlockCard() {
		return editCardButtonFlightBlockCard;
	}

}
