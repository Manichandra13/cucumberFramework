package com.pyt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {

	@FindBy(xpath="//a[contains(text(),'Login')]")
    private WebElement landingPageLogin;

	//@FindBy(xpath="//*/div/*[contains(text(),'Login')]")
	//private WebElement login;

	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@placeholder='Your name']")
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	private WebElement mobileno;

	@FindBy(xpath = "//*/button[contains(text(),'Sign up to get free quotes')]")
	private WebElement initsignup;

	@FindBy(xpath = "//*[@class='btn btn-primary btn-lg btn-block']")
	private WebElement signup;

	@FindBy(xpath = "//*[@class='btn btn-primary btn-lg btn-block tracker-get-cost-modal-get-cost']")
	private WebElement gcmsignup;

	@FindBy(xpath = "//*/button[contains(text(),'Get Cost')]")
	private WebElement ausSubmit;

	@FindBy(xpath = "//*/p[@class='fine-text light color-grey']")
	private WebElement loginmodal;

//	@FindBy(css = "button.btn-link:nth-child(2)")
	@FindBy(xpath = "//*/button[contains(text(),'Sign up to get free quotes')]")
	private WebElement loginfromsignup;

	@FindBy(xpath = "//*/button[contains(text(),'Already have an account?')]")
	private WebElement alreadygotaccount;

	@FindBy(css = ".btns-row > button:nth-child(2)")
	private WebElement loginsignuppkg;

	@FindBy(css = ".btns-row > button:nth-child(2)")
	private WebElement existingaccpkg;

	@FindBy(css = ".btn-lg")
	private WebElement vacationsignup;

	@FindBy(xpath = "//button[contains(text(),'Create my account')]")
	private WebElement createMyAcc;

	@FindBy(xpath = "//*[text()='Account exists']")
	private WebElement accountExists;

	public WebElement getAccountExists() {
		return accountExists;
	}


	public WebElement getcreateMyAcc()
	{
		return createMyAcc;
	}


	public WebElement getLandingPageLogin()
	{
		return landingPageLogin;
	}

	public WebElement getUsername()
	{
		return username;
	}

	public WebElement getEmail()
	{
		return email;
	}

	public WebElement getMobileNumber()
	{
		return mobileno;
	}

	public WebElement getInitSignup()
	{
		return initsignup;
	}

	public WebElement getSignup()
	{
		return ausSubmit;
	}




	/*public WebElement getLogin()
	{
		return login;
	}*/

	public WebElement getLoginButton()
	{
		return loginButton;
	}

	public WebElement getLoginModal()
	{
		return loginmodal;
	}

	public WebElement getLoginFromSignup()
	{
		return loginfromsignup;
	}

	public WebElement getAlreadyGotAccount()
	{
		return alreadygotaccount;
	}

	public WebElement getVacationPkgSignup()
	{
		return loginsignuppkg;
	}

	public WebElement getVacationPkgAlreadyGotAcc()
	{
		return existingaccpkg;
	}

	public WebElement getVacationPkgSignupButton()
	{
		return vacationsignup;
	}

	public WebElement getGCMSignup()
	{
		return gcmsignup;
	}

}
