package gluecode;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class LoginGlue extends Kernel {

	@Given("^Login as a authenticated user from GCM page with \"([^\"]*)\"$")
	public void login_as_a_authenticated_user_from_GCM_page_with(String region) throws Throwable {
		// ReporteraddScenarioLog("Login as a authenticated user from GCM page");
		validateAssertion(LoginThroughPage("GCM", "GCMSignup", region));
	}

	@Given("^Login as a authenticated user$")
	public void login_as_a_authenticated_user() throws Throwable {
		loginFunctionalityTest("Registered_User");
		homepageLanding();
	}

	@Given("^Login as a authenticated admin user$")
	public void login_as_a_authenticated_admin_user() throws Throwable {
		loginFunctionalityTest("admin");
		System.out.println("Login completed successfully");
		homepageLanding();
	}

//Login to the application from landing page via login modal with various credentials

	@Then("^Login to the application with valid username and password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_valid_credentials(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLogin(uName, passwd));
		validateAssertion(elementDisplayed(hp.getUserLoggedInitial()));
	}

	@Then("^Login to the application with valid username and invalid password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_invalid_password(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLoginWithInvalidPassword());
		validateAssertion(elementDisplayed(lp.getInvalidPasswordAlert()));
	}

	@Then("^Login to the application with invalid username and valid password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_invalid_username(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLoginWithInvalidUsername());
		validateAssertion(elementDisplayed(lp.getInvalidUserAlert()));
	}

	@Then("^Login to the application with invalid username and invalid password with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_invalid_credentials(String uName, String passwd) throws Throwable {
		clickAction(lp.getLogin());
		validateAssertion(doLoginWithInvalidCredentials());
		validateAssertion(elementDisplayed(lp.getInvalidUserAlert()));
	}

//Login to the application from landing page via sign-up modal by entering registered user credentials

	@Then("^Login from signup modal by entering registered user data and then logging in$")
	public void login_from_signup_modal() throws Throwable {
		validateAssertion(doLoginFromSignupModal("", "", "InputUserData", ""));
	}

//Login to the application from landing page via "already got an account" CTA with various credentials

	@Then("^Login from signup modal via Already have an account CTA with valid credentials$")
	public void login_via_Already_have_an_account_CTA_with_valid_credentials() throws Throwable {
		validateAssertion(doLoginFromSignupModal(username, pass, "CleanSignupForm", "ValidCredentials"));
	}

	@Then("^Login from signup modal via Already have an account CTA with invalid username$")
	public void login_via_Already_have_an_account_CTA_with_invalid_username() throws Throwable {
		validateAssertion(doLoginFromSignupModal(invalidUser, pass, "CleanSignupForm", "InvalidUsername"));
	}

	@Then("^Login from signup modal via Already have an account CTA with invalid password$")
	public void login_via_Already_have_an_account_CTA_with_invalid_password() throws Throwable {
		validateAssertion(doLoginFromSignupModal(username, invalidPassword, "CleanSignupForm", "InvalidPassword"));
	}

	@Then("^Login from signup modal via Already have an account CTA with invalid credentials$")
	public void login_via_Already_have_an_account_CTA_with_invalid_credentials() throws Throwable {
		validateAssertion(
				doLoginFromSignupModal(invalidUser, invalidPassword, "CleanSignupForm", "InvalidCredentials"));
	}

//Login validation from PDG flow using GCM

	@Given("^Login from PDG Flow using GCM via already got an account with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_GCM_via_already_got_an_account_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("GCM", "GCMLogin", region));
	}

	@Given("^Login from PDG Flow using GCM via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_GCM_via_Signup_as_existing_user_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("GCM", "ChooseSignup", region));
	}

	@Given("^Login from PDG Flow using GCM via GCM Signup with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_GCM_via_GCM_Signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("GCM", "GCMSignup", region));
	}

	// Login validation from PDG flow using CTC

	@Given("^Login from PDG Flow using Calculate trip cost via already got an account with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_Calculate_trip_cost_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughPage("CTC", "GCMLogin", region));
	}

	@Given("^Login from PDG Flow using Calculate trip cost via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_Calculate_trip_cost_via_Signup_as_existing_user_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughPage("CTC", "ChooseSignup", region));
	}

	@Given("^Login from PDG Flow using Calculate trip cost via GCM Signup with \"([^\"]*)\"$")
	public void login_from_PDG_Flow_using_Calculate_trip_cost_via_GCM_Signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("CTC", "GCMSignup", region));
	}

//Header Login Validation from itinerary page 

	@Given("^Login from Itinerary page using Header login via already got an account with \"([^\"]*)\"$")
	public void login_from_Itinerary_page_using_Header_login_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughHeader("ItineraryPage", "ExistingAccount", region));
	}

	@Given("^Regular login through headers login from Itinerary page with \"([^\"]*)\"$")
	public void regular_login_through_headers_login_from_Itinerary_page_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("ItineraryPage", "HeaderLogin", region));
	}

	@Given("^Login from Itinerary page using Header login via signup with \"([^\"]*)\"$")
	public void login_from_Itinerary_page_using_Header_login_via_signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("ItineraryPage", "HeaderSignup", region));
	}

//Header Login validation from packages pages

	@Given("^Login from package page using Header login via already got an account with \"([^\"]*)\"$")
	public void login_from_package_page_using_Header_login_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughHeader("Packages", "ExistingAccount", region));
	}

	@Given("^Regular login through headers login from packages page with \"([^\"]*)\"$")
	public void regular_login_through_headers_login_from_packages_page_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("Packages", "HeaderLogin", region));
	}

	// completed
	@Given("^Login from package page using Header login via signup with \"([^\"]*)\"$")
	public void login_from_package_page_using_Header_login_via_signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughHeader("Packages", "HeaderSignup", region));
	}

//	Login validation from GCM packages page

	@Given("^Login from packages page via GCM Signup with \"([^\"]*)\"$")
	public void login_from_packages_page_via_GCM_Signup_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("Packages", "ChooseSignup", region));
	}

	@Given("^Login from packages page using custiomize option via already got an account with \"([^\"]*)\"$")
	public void login_from_packages_page_using_custiomize_option_via_already_got_an_account_with(String region)
			throws Throwable {
		validateAssertion(LoginThroughPage("Packages", "GCMLogin", region));
	}

	@Given("^Login from packages page via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_packages_page_via_Signup_as_existing_user_with(String region) throws Throwable {
		validateAssertion(LoginThroughPage("Packages", "GCMSignup", region));
	}

//Login validation from GCM Paid campaign pages

	@Given("^Login from paid campaign page using custiomize option via already got an account with \"([^\"]*)\"$")
	public void login_from_paid_campaign_page_using_custiomize_option_via_already_got_an_account_with(String region)
			throws Throwable {
		LoginThroughPage("PaidCampaign", "GCMLogin", region);
	}

	@Given("^Login from paid campaign page via Signup as existing user with \"([^\"]*)\"$")
	public void login_from_paid_campaign_page_via_Signup_as_existing_user_with(String region) throws Throwable {
		LoginThroughPage("PaidCampaign", "ChooseSignup", region);
	}

	@Given("^Login from paid campaign page via GCM Signup with \"([^\"]*)\"$")
	public void login_from_paid_campaign_page_via_GCM_Signup_with(String region) throws Throwable {
		LoginThroughPage("PaidCampaign", "GCMSignup", region);
	}

}
