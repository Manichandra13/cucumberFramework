package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GCMSignupPage {
	
	@FindBy(xpath = "//input[@placeholder='Departing from']")
	private WebElement depbox;
	
	@FindBy(xpath = "//*/span[text()='MAA']")
	private WebElement depFrom;
	
	@FindBy(xpath = "//input[@placeholder='Departing on']")
	private WebElement datebox;
	
	@FindBy(xpath = "//button[text()='Get Cost']")
	private WebElement getCost;
	
	@FindBy(xpath = "//span[text()='Get latest cost']")
	private WebElement getLatestCost;
	
	@FindBy(xpath = "//div[@class='react-datepicker']/button[2]")
	private WebElement chooseNextMonth;
	
	@FindBy(xpath = "//div[@class='react-datepicker']/button")
	private WebElement chooseNextMonth1;

	@FindBy(xpath = "//label[@class='custom-options no-padding']/i")
	private WebElement intlFlights;

	@FindBy(xpath = "(//i[contains(@class,'pyt-close')])[4]")
	private WebElement closeGCMModal;
	
	@FindBy(xpath = "//div[@class='react-datepicker__month']/div[3]/div[1]")
	private WebElement chooseDate;
	
	@FindBy(xpath = "//*/p/a[text()='login to continue']")
	private WebElement gcmPageLogin;
	
	@FindBy(xpath = "//b[contains(text(),'adults')]")
	private WebElement editTrip;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block tracker-get-cost-modal-update-cost']")
	private WebElement updateCost;
	
	@FindBy(xpath= "//div[@class='animation-holder text-center']")
	private WebElement costingAnimation;
	
	@FindBy(xpath= "//button[contains(@class,'signup-cta-in-modal')]")
    private WebElement signUpCta;
	
	public WebElement getSignUpCta() {
        return signUpCta;
    }
	
	public WebElement getCostingAnimation() {
		return costingAnimation;
	}

	public WebElement goToDepartureSelection()
	{
		return depbox;
	}
	
	public WebElement getdepartureCity()
	{
		return depFrom;
	}
	
	public WebElement doGetCost()
	{
		return getCost;
	}
	
	public WebElement doGetLatestCost()
	{
		return getLatestCost;
	}
	
	public WebElement getDepartureDate()
	{
		return datebox;
	}
	
	public WebElement goToNextMonth()
	{
		return chooseNextMonth;
	}
	
	public WebElement goToNextMonth1() {
		return chooseNextMonth1;
	}
	
	public WebElement chooseDepartureDate()
	{
		return chooseDate;
	}
	
	public WebElement goToLogin()
	{
		return gcmPageLogin;
	}
	
	public WebElement closeGcmModal()
	{
		return closeGCMModal;
	}
	
	public WebElement getIntlFlights()
	{
		return intlFlights;
	}

	public WebElement getEditTrip()
	{
		return editTrip;
	}
	
	public WebElement getUpdateCost()
	{
		return updateCost;
	}
}
