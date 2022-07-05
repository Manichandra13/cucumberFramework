package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpeedboatLandingPage {
	
	@FindBy(xpath = "//div[contains(text(),'Maldives')]")
	WebElement sbPdgMaldives;
	
	@FindBy(xpath = "//input[@placeholder='Departure city']")
	WebElement sbDepartureCity;
	
	@FindBy(xpath = "//input[@id='departure-date-get-cost']")
	WebElement sbTravelDate;
	
	@FindBy(xpath = "//input[@placeholder='Duration of stay']")
	WebElement sbDuration;
	
	@FindBy(xpath = "//input[@placeholder='Traveller details']")
	WebElement sbPax;
	
	@FindBy(xpath = "//*[contains(text(),'special one')]")
	WebElement sbHoneymoon;
	
	@FindBy(xpath = "//button[contains(text(),'Search for Packages')]")
	WebElement sbSearchPackages;
	
	@FindBy(xpath = "//button[contains(@class,'react-datepicker__navigation--next')]")
	WebElement sbNextMonth;
	
	@FindBy(xpath = "(//div[contains(@class,'react-datepicker__week')])[3]/div[3]")
	WebElement sbChooseDate;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-group-type')]//*[contains(text(),'Couple')]")
	WebElement sbChooseCouple;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-group-type')]//*[contains(text(),'Family')]")
	WebElement sbChooseFamily;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-group-type')]//*[contains(text(),'Friends')]")
	WebElement sbChooseFriends;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-group-type')]//*[contains(text(),'Solo')]")
	WebElement sbChooseSolo;
	
	@FindBy(xpath = "//div[contains(@class,'room-config')]//*/span[contains(text(),'Add room')]")
	WebElement sbAddRoom;
	
	@FindBy(xpath = "//div[contains(@class,'room-config')]//*/span[contains(text(),'Delete room')]")
	WebElement sbDeleteRoom;
	
	@FindBy(xpath = "//div[contains(@class,'room-config')]//*/a[contains(text(),'Done')]")
	WebElement sbSaveRoomConfig;
	
	@FindBy(xpath = "//div[contains(@class,'room-config')]//*/a[contains(text(),'Cancel')]")
	WebElement sbCancelRoomConfig;
	
	@FindBy(xpath = "(//div[contains(@class,'honeymoon-resorts')])[1]")
	WebElement sbChooseHoneymoonResort;
	
	@FindBy(xpath = "(//div[contains(@class,'overwater-villa-resorts')])[1]")
	WebElement sbChooseOverwaterResort;
	
	@FindBy(xpath = "(//div[contains(@class,'kid-friendly-resorts')])[1]")
	WebElement sbChooseKidFriendlyResort;
	
	@FindBy(xpath = "(//div[contains(@class,'indian-food-resorts')])[1]")
	WebElement sbChooseIndianFoodResort;
	
	@FindBy(xpath = "(//div[contains(@class,'sea-plane-resorts')])[1]")
	WebElement sbChooseSeaplaneResort;
	
	@FindBy(xpath = "(//div[contains(@class,'closest-to-airport-resorts')])[1]")
	WebElement sbChooseAirportResort;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Honeymooners')]/following-sibling::div/span")
	WebElement sbViewAllHoneymoonResorts;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Overwater')]/following-sibling::div/span")
	WebElement sbViewAllOverwaterResorts;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Kid Friendly')]/following-sibling::div/span")
	WebElement sbViewAllKidFriendlyResorts;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Indian Food')]/following-sibling::div/span")
	WebElement sbViewAllIndianFoodResorts;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Seaplane')]/following-sibling::div/span")
	WebElement sbViewAllSeaplaneResorts;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Closest to Airport')]/following-sibling::div/span")
	WebElement sbViewAllAirportResorts;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Honeymooners')]/parent::div/parent::div/following-sibling::div//*/div[contains(@class,'testimonial-card')]")
	WebElement sbHoneymoonTestimonial;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Overwater')]/parent::div/parent::div/following-sibling::div//*/div[contains(@class,'testimonial-card')]")
	WebElement sbOverwaterTestimonial;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Kid Friendly')]/parent::div/parent::div/following-sibling::div//*/div[contains(@class,'testimonial-card')]")
	WebElement sbKidFriendlyTestimonial;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Indian Food')]/parent::div/parent::div/following-sibling::div//*/div[contains(@class,'testimonial-card')]")
	WebElement sbIndianFoodTestimonial;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Seaplane')]/parent::div/parent::div/following-sibling::div//*/div[contains(@class,'testimonial-card')]")
	WebElement sbSeaplaneTestimonial;
	
	@FindBy(xpath = "//section//*/h2[contains(text(),'Closest to Airport')]/parent::div/parent::div/following-sibling::div//*/div[contains(@class,'testimonial-card')]")
	WebElement sbAirportTestimonial;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'1')]")
	WebElement sbDuration1n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'2')]")
	WebElement sbDuration2n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'3')]")
	WebElement sbDuration3n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(text(),'4')]")
	WebElement sbDuration4n;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-duration')]//*[contains(@class,'pyt-plus')]")
	WebElement sbAddCustomDuration;
	
	@FindBy(xpath = "//div[contains(@class,'duration')]//*[contains(@class,'pyt-minus')]")
	WebElement sbReduceCustomDuration;
	
	@FindBy(xpath = "//div[contains(@class,'gcm-room-config')]//*/i[contains(@class,'baby')]/parent::p/following-sibling::div/select")
	WebElement sbSelectChildAge;
	
	@FindBy(xpath = "(//div[contains(@class,'room-config')]//*[contains(@class,'plus')])[1]")
	WebElement sbAddAdult;
	
	@FindBy(xpath = "(//div[contains(@class,'room-config')]//*[contains(@class,'minus')])[1]")
	WebElement sbRemoveAdult;
	
	@FindBy(xpath = "(//div[contains(@class,'room-config')]//*[contains(@class,'plus')])[2]")
	WebElement sbAddChild;
	
	@FindBy(xpath = "(//div[contains(@class,'room-config')]//*[contains(@class,'minus')])[2]")
	WebElement sbRemoveChild;
	
	@FindBy(xpath = "//input[@placeholder='Search cities']")
	WebElement sbSearchCity;
	
	
	public WebElement getMaldivesInPdg()
	{
		return sbPdgMaldives;
	}
	
	public WebElement getSbDepartureCity()
	{
		return sbDepartureCity;
	}
	
	public WebElement getSbDepartureDate()
	{
		return sbTravelDate;
	}
	
	public WebElement getSbDuration()
	{
		return sbDuration;
	}
	
	public WebElement getSbPax()
	{
		return sbPax;
	}
	
	public WebElement chooseSearchForPackages()
	{
		return sbSearchPackages;
	}
	
	public WebElement sbGoToNextMonth()
	{
		return sbNextMonth;
	}
	
	public WebElement sbChooseTravelDate()
	{
		return sbChooseDate;
	}
	
	public WebElement sbChooseFamilyGcm()
	{
		return sbChooseFamily;
	}
	
	public WebElement sbChooseFriendsGcm()
	{
		return sbChooseFriends;
	}
	
	public WebElement sbChooseSoloGcm()
	{
		return sbChooseSolo;
	}
	
	public WebElement sbChooseCoupleGcm()
	{
		return sbChooseCouple;
	}
	
	public WebElement sbChooseHoneymoonResort()
	{
		return sbChooseHoneymoonResort;
	}
	
	public WebElement sbChooseOverwaterResort()
	{
		return sbChooseOverwaterResort;
	}
	
	public WebElement sbChooseKidFriendlyResort()
	{
		return sbChooseKidFriendlyResort;
	}
	
	public WebElement sbChooseIndianFoodResort()
	{
		return sbChooseIndianFoodResort;
	}
	
	public WebElement sbChooseSeaplaneResort()
	{
		return sbChooseSeaplaneResort;
	}
	
	public WebElement sbChooseAirportResort()
	{
		return sbChooseAirportResort;
	}
	
	public WebElement sbViewAllHoneymoonResorts()
	{
		return sbViewAllHoneymoonResorts;
	}
	
	public WebElement sbViewAllOverwaterResorts()
	{
		return sbViewAllOverwaterResorts;
	}
	
	public WebElement sbViewAllKidFriendlyResorts()
	{
		return sbViewAllKidFriendlyResorts;
	}
	
	public WebElement sbViewAllIndianFoodResorts()
	{
		return sbViewAllIndianFoodResorts;
	}
	
	public WebElement sbViewAllSeaplaneResorts()
	{
		return sbViewAllSeaplaneResorts;
	}
	
	public WebElement sbViewAllAirportResorts()
	{
		return sbViewAllAirportResorts;
	}
	
	public WebElement sbAddNewRoom()
	{
		return sbAddRoom;
	}
	
	public WebElement sbDeleteRoom()
	{
		return sbDeleteRoom;
	}
	
	public WebElement sbSaveRoomConfig()
	{
		return sbSaveRoomConfig;
	}
	
	public WebElement sbChooseHoneymoonTestimonial()
	{
		return sbHoneymoonTestimonial;
	}
	
	public WebElement sbChooseOverwaterTestimonial()
	{
		return sbOverwaterTestimonial;
	}
	
	public WebElement sbChooseKidFriendlyTestimonial()
	{
		return sbKidFriendlyTestimonial;
	}
	
	public WebElement sbChooseIndianFoodTestimonial()
	{
		return sbIndianFoodTestimonial;
	}
	
	public WebElement sbChooseSeaplaneTestimonial()
	{
		return sbSeaplaneTestimonial;
	}
	
	public WebElement sbChooseAirportTestimonial()
	{
		return sbAirportTestimonial;
	}
	
	public WebElement sbHoneymoonHeader()
	{
		return sbHoneymoon;
	}
	
	public WebElement sbChoose1Night()
	{
		return sbDuration1n;
	}
	
	public WebElement sbChoose2Nights()
	{
		return sbDuration2n;
	}
	
	public WebElement sbChoose3Nights()
	{
		return sbDuration3n;
	}
	
	public WebElement sbChoose4Nights()
	{
		return sbDuration4n;
	}
	
	public WebElement sbAddCustomDuration()
	{
		return sbAddCustomDuration;
	}
	
	public WebElement sbReduceCustomDuration()
	{
		return sbReduceCustomDuration;
	}
	
	public WebElement sbSetChildAge()
	{
		return sbSelectChildAge;
	}
	
	public WebElement sbSearchForCity()
	{
		return sbSearchCity;
	}
	
	public WebElement sbAddAdultToPax()
	{
		return sbAddAdult;
	}
	
	public WebElement sbRemoveAdultInPax()
	{
		return sbRemoveAdult;
	}
	
	public WebElement sbAddChildToPax()
	{
		return sbAddChild;
	}
	
	public WebElement sbRemoveChildFromPax() {
		return sbRemoveChild;
	}

}
