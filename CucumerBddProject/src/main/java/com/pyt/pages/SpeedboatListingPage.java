package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpeedboatListingPage {
	
	@FindBy(xpath = "//button[contains(text(),'Unlock deal')]")
	WebElement sbUnlockDeal;
	
	@FindBy(xpath = "(//span[@class='dropdown-toggle'])[1]")
	WebElement sbGcmPill;
	
	@FindBy(xpath = "//button[contains(text(),'Search for packages')]")
	WebElement sbSearchAvailablePackages;
	
	@FindBy(xpath = "//input[@placeholder='Departing from']")
	WebElement sbListingDepCity;
	
	@FindBy(xpath = "//span[contains(text(),'Price')]")
	WebElement sbPriceFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Star Category')]")
	WebElement sbStarFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Villa')]")
	WebElement sbVillaFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Meal')]")
	WebElement sbMealFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Others')]")
	WebElement sbOthersFilter;
	
	@FindBy(xpath = "//span[contains(text(),'50k - ')]")
	WebElement sb50to70kFilter;
	
	@FindBy(xpath = "//span[contains(text(),'70k - ')]")
	WebElement sb70to80kFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Above')]")
	WebElement sbAbove80kFilter;
	
	@FindBy(xpath = "//span[contains(text(),'3 Star')]")
	WebElement sb3StarFilter;
	
	@FindBy(xpath = "//span[contains(text(),'4 Star')]")
	WebElement sb4StarFilter;
	
	@FindBy(xpath = "//span[contains(text(),'5 Star')]")
	WebElement sb5StarFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Water Villa')]")
	WebElement sbWaterVillaFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Beach Bungalow')]")
	WebElement sbBeachBungalowFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Split Stay')]")
	WebElement sbSplitStayFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Family Villa')]")
	WebElement sbFamilyVillaFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Garden Villa')]")
	WebElement sbGardenVillaFilter;
	
	@FindBy(xpath = "//span[contains(text(),'For the Honeymooners')]")
	WebElement sbHoneymooners;
	
	@FindBy(xpath = "//span[contains(text(),'Best Overwater Villa')]")
	WebElement sbOverwater;
	
	@FindBy(xpath = "//span[contains(text(),'Seaplane Only')]")
	WebElement sbSeaplaneOnly;
	
	@FindBy(xpath = "//span[contains(text(),'Kid Friendly Resorts')]")
	WebElement sbKidFriendly;
	
	@FindBy(xpath = "//span[contains(text(),'Great Indian Food')]")
	WebElement sbGreatIndianFood;
	
	@FindBy(xpath = "//span[contains(text(),'Closest to Airport')]")
	WebElement sbClosestToAirport;
	
	@FindBy(xpath = "//span[contains(text(),'Half Board')]")
	WebElement sbHalfBoard;
	
	@FindBy(xpath = "//span[contains(text(),'Full Board')]")
	WebElement sbFullBoard;
	
	@FindBy(xpath = "//span[contains(text(),'Breakfast Only')]")
	WebElement sbBreakfastOnly;
	
	@FindBy(xpath = "//span[contains(text(),'All Inclusive')]")
	WebElement sbAllInclusive;
	
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement sbApplyFilter;
	
	public WebElement getUnlockDeal() {
		return sbUnlockDeal;
	}
	
	public WebElement getGCMPill() {
		return sbGcmPill;
	}
	
	public WebElement getSelectAvailablePackages() {
		return sbSearchAvailablePackages;
	}
	
	public WebElement getListingGCMDepartureCity() {
		return sbListingDepCity;
	}
	
	public WebElement getPriceFilter() {
		return sbPriceFilter;
	}
	
	public WebElement getStarFilter() {
		return sbStarFilter;
	}
	
	public WebElement getVillaFilter() {
		return sbVillaFilter;
	}
	
	public WebElement getMealFilter() {
		return sbMealFilter;
	}
	
	public WebElement getOthersFilter() {
		return sbOthersFilter;
	}
	
	public WebElement get50to70kPriceFilter() {
		return sb50to70kFilter;
	}
	
	public WebElement get70to80kPriceFilter() {
		return sb70to80kFilter;
	}
	
	public WebElement getAbove80kPriceFilter() {
		return sbAbove80kFilter;
	}
	
	public WebElement get3StarFilter() {
		return sb3StarFilter;
	}
	
	public WebElement get4StarFilter() {
		return sb4StarFilter;
	}
	
	public WebElement get5StarFilter() {
		return sb5StarFilter;
	}
	
	public WebElement getWaterVillaFilter() {
		return sbWaterVillaFilter;
	}
	
	public WebElement getBeachBungalowFilter() {
		return sbBeachBungalowFilter;
	}
	
	public WebElement getSplitStayFilter() {
		return sbSplitStayFilter;
	}
	
	public WebElement getFamilyVillaFilter() {
		return sbFamilyVillaFilter;
	}
	
	public WebElement getGardenVillaFilter() {
		return sbGardenVillaFilter;
	}
	
	public WebElement getForHoneymoonersFilter() {
		return sbHoneymooners;
	}
	
	public WebElement getBestOverwaterVillaFilter() {
		return sbOverwater;
	}
	
	public WebElement getKidFriendlyResortsFilter() {
		return sbKidFriendly;
	}
	
	public WebElement getGreatIndianFoodFilter() {
		return sbGreatIndianFood;
	}
	
	public WebElement getSeaplaneOnlyFilter() {
		return sbSeaplaneOnly;
	}
	
	public WebElement getClosestToAirportFilter() {
		return sbClosestToAirport;
	}
	
	public WebElement getHalfBoardFilter() {
		return sbHalfBoard;
	}
	
	public WebElement getFullBoardFilter() {
		return sbFullBoard;
	}
	
	public WebElement getBreakfastOnlyFilter() {
		return sbBreakfastOnly;
	}
	
	public WebElement getAllInclusiveFilter() {
		return sbAllInclusive;
	}
	
	public WebElement getApplyChosenFilter() {
		return sbApplyFilter;
	}

}
