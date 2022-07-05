package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	// Home Page Footer

	@FindBy(xpath = "//*[contains(text(),'Travel Troops Global Private Ltd')]")
	private WebElement footerLinkPyt;

	@FindBy(xpath="//a[@href='/login']")
	private WebElement login;

	@FindBy(xpath="//*/div/*[contains(text(),'Login')]")
	private WebElement gcmHeaderLogin;
	
	@FindBy(xpath="//input[contains(@placeholder,'Mobile Number')]")
	private WebElement userName;

	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(xpath="//button[contains(text(),'Sign up')]")
	private WebElement signupButton;

	@FindBy(xpath="//button[contains(text(),'Forgot')]")
	private WebElement forgotPasswordButton;

	@FindBy(className="user-initials")
	private WebElement menuButton;

	@FindBy(xpath="//a[text()='Logout' and @href='#' ]")
	private WebElement logoutButton;

	@FindBy(xpath="//span[text()='Registered mobile number is not valid']")
	private WebElement invalidUserAlert;

	@FindBy(xpath="//span[text()='Invalid username or password.']")
	private WebElement invalidPasswordAlert;

	@FindBy(xpath="//button[contains(@class,'login-cta-in-modal')]")
	private WebElement packCtaLogin;

	@FindBy(xpath="//button[contains(text(),'Get my personalized itinerary')]")
	private WebElement vacCtaLogin;

	public WebElement getvacCtaLogin()
	{
		return vacCtaLogin;
	}

	public WebElement getpackCtaLogin()
	{
		return packCtaLogin;
	}
	public WebElement getGCMHeaderLogin()
	{
		return gcmHeaderLogin;
	}

	public WebElement getfooterLinkPyt() {
		return footerLinkPyt;
	}
	public WebElement getLogin() {
		return login;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSignupButton() {
		return signupButton;
	}

	public WebElement getforgotPasswordButton() {
		return forgotPasswordButton;
	}

	public WebElement getmenuButton() {
		return menuButton;
	}

	public WebElement getlogoutButton() {
		return logoutButton;
	}

	public WebElement getInvalidUserAlert()
	{
		return invalidUserAlert;
	}

	public WebElement getInvalidPasswordAlert()
	{
		return invalidPasswordAlert;
	}
}
