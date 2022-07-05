package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PackagesPage {

//Packages Dropdown
	@FindBy(xpath = "//*[text()='Destinations']")
	WebElement packagesPageCityDropdown;

//Themes Dropdown

	@FindBy(xpath = "//*[text()='Interests']")
	WebElement packagesPageThemesDropdown;

//Themes options 

//Newly Weds

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='For the Newly weds']")
	WebElement packagesPageNewlyWeds;

//Family Specials

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Family Specials']")
	WebElement packagesPageFamilySpecials;
	
	@FindBy(xpath = "//*[@id='packagesContent']/div/section[2]/div[3]/a")
	WebElement selectedFamilyPkg;
	
	//*[@id="packagesContent"]/div/section[1]/div[3]/a
	
//Beach Lovers

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Beach Lovers']")
	WebElement packagesPageBeachLovers;

//adventure-packages

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Adrenaline Junkies']")
	WebElement packagesPageAdrenalineJunkies;

//visa-on-arrival-packages

	@FindBy(xpath = "//li[@class='tracker-pkg-themes']//input[@data-text='Visa on arrival']")
	WebElement packagesPageVisaonArrival;

//Destinations Options 

//City Destinarion -- Europe 
	@FindBy(xpath = "//li[@class='tracker-pkg-destination']//input[@value='europe']//following-sibling::span[1]")
	WebElement packagesPageCityEurope;

//City Destinarion -- Australia 
	@FindBy(xpath = "//li[@class='tracker-pkg-destination']//input[@value='australia']")
	WebElement packagesPageCityAustralia;

//City Destinarion -- New - Zealand 
	@FindBy(xpath = "//li[@class='tracker-pkg-destination']//input[@value='new-zealand']")
	WebElement packagesPageCityNweZealand;
	
//Aus paid campaign package choice
	@FindBy(xpath = "//a[@class='btn btn-primary tracker-campaign-custombtn']")
	WebElement auspaidpkg;
	
	@FindBy(xpath ="//section[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]")
	WebElement firstPackage;
	
	@FindBy(xpath ="//button[contains(text(),'Get Cost')]")
	WebElement PackageGetCost;

	@FindBy(xpath = "(//a[@class='btn btn-primary tracker-campaign-custombtn'])[1]")
	WebElement customizeButton;
	
	@FindBy(xpath="(//button[text()='Create your personalised itinerary'])[1]")
	WebElement pdgFlowLinkFromPackage;
	
	@FindBy(xpath="//img[contains(@alt,'PickYourTrail.com')]")
    WebElement vacationPagePytLogo;
	
	@FindBy(xpath="//div[@id='faq']")
	WebElement faqSectionVacations;
	
	@FindBy(xpath="//*[@class='trust-footer']")
	WebElement trustFooterInPackageVacations;
	
	@FindBy(xpath="//button[contains(text(),'Customise')][1]")
	WebElement customizeCta;
	
	@FindBy(xpath="//a[contains(text(),'Customize')][1]")
	WebElement vacationsCustomizeCta;
	
	public WebElement getVacationsCustomizeCta() {
		return vacationsCustomizeCta;
	}
	
	public WebElement getCustomizeCta() {
		return customizeCta;
	}

	public WebElement getTrustFooterInPackageVacations() {
		return trustFooterInPackageVacations;
	}

	public WebElement getFaqSectionVacations() {
		return faqSectionVacations;
	}

	public WebElement getPdgFlowLinkFromPackage() {
		return pdgFlowLinkFromPackage;
	}

	public WebElement getVacationPagePytLogo() {
		return vacationPagePytLogo;
	}

	public WebElement getCustomizeButton() {
		return customizeButton;
	}

	public WebElement getPackageGetCost() {
		return PackageGetCost;
	}
	
	public WebElement getFirstPackage() {
		return firstPackage;
	}

	public WebElement getCityDropdown() {
		return packagesPageCityDropdown;
	}

	public WebElement getCityEurope() {
		return packagesPageCityEurope;
	}
	
	public WebElement getPackagesPageCityDropdown() {
		return packagesPageCityDropdown;
	}

	public WebElement getPackagesPageThemesDropdown() {
		return packagesPageThemesDropdown;
	}

	public WebElement getPackagesPageNewlyWeds() {
		return packagesPageNewlyWeds;
	}

	public WebElement getPackagesPageFamilySpecials() {
		return packagesPageFamilySpecials;
	}

	public WebElement getPackagesPageBeachLovers() {
		return packagesPageBeachLovers;
	}

	public WebElement getPackagesPageAdrenalineJunkies() {
		return packagesPageAdrenalineJunkies;
	}

	public WebElement getPackagesPageVisaonArrival() {
		return packagesPageVisaonArrival;
	}

	public WebElement getPackagesPageCityEurope() {
		return packagesPageCityEurope;
	}

	public WebElement getPackagesPageCityAustralia() {
		return packagesPageCityAustralia;
	}

	public WebElement getPackagesPageCityNweZealand() {
		return packagesPageCityNweZealand;
	}
	
	public WebElement getFamilyVacationPackage()
	{
		return selectedFamilyPkg;
	}
	
	public WebElement getAusPaidPackage()
	{
		return auspaidpkg;
	}

}
