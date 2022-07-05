package gluecode;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Kernel;

public class CbrValidationGlue extends Kernel {


	@Then("^User performs CBR validation after GCM$")
	public void user_performs_CBR_validation_after_GCM() throws Throwable {
		cbrValidationAfterGCM("itinerary");
		Assert.fail();
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^user click on talk to us button in lading page$")
	public void user_click_on_talk_to_us_button_in_lading_page() throws Throwable {
		waitForMe(cbr.getCustomerStory());
		scrolltoElement(cbr.getCustomerStory());
		Thread.sleep(1000);
		clickAction(cbr.getHomePageCbr());
	}

	@And("^verify the name email and mobile number field disabled$")
	public void verify_the_name_email_and_mobile_number_field_disabled() throws Throwable {
	  boolean name = verifyEnabled(cbr.getUsername());
	  boolean email = verifyEnabled(cbr.getEmail());
	  boolean num  = verifyEnabled(cbr.getPhonenumber());
	   if(name==false && email==false && num==false) {
		   System.out.println("The name number and email field successfully disabled for existing user");
	   }
	}

	@And("^post cbr form$")
	public void post_cbr_form() throws Throwable {
		selectDropDownUsingVisibleText(cbr.getPreferredTime(), "Call me anytime");	
		clickAction(cbr.getcBrSubmitButton(),"User submitting landing page CBR form ");
	}

	@Then("^Verify the cbr posted successfully$")
	public void verify_the_cbr_posted_successfully() throws Throwable {
	   // compareTwoStrings(getCurrentUrl(),"https://"+Hooks.configuration+".longweekend.co.in/");
		waitForMe(hp.getstartPlanningNowButton());
		validateAssertion(elementExist(hp.getstartPlanningNowButton()));
		
	}
	
//	@And("^new user fill the CBR form $")
//	public void user_fill_the_CBR_form() throws Throwable {
//	   enterFieldsexceptTime();
//	  }
	
	@Then("^verify the user should logged in successfully$")
	public void verify_the_user_should_logged_in_successfully() throws Throwable {
	    if(elementExist(hp.getUserInitialPostLogin()))
	    {
	    System.out.println("User logged in successfully");
	    	}
	    else {
	    	System.out.println("User failed to log in");
	    }
	    
	}
	
	@Then("^Validate the alert message$")
	public void validate_the_alert_message() throws Throwable {
		waitForMe(cbr.getAlertMsgCbrExisting());
	   if(elementExist(cbr.getAlertMsgCbrExisting())){
		   verifyPartialText(cbr.getAlertMsgCbrExisting(),"An account with the given credentials already exists please login or provide different credentials to continue.");
		   clickAction(cbr.getOkButtonInAlert(),"User click on Ok button in the alert");
		   clickAction(cbr.getCloseCbrModal(),"User closes the CBR modal");
	   }
	}
	@Then("^validate the alert message in vacations cbr$")
	public void validate_the_alert_message_in_vacations_cbr() throws Throwable {
		try {
			if (elementExist(cbr.getVactionCbrAlertMsg())) {
				assertTrue(cbr.getCbrCloseVacations().isDisplayed());
				clickAction(cbr.getCbrCloseVacations());
			}
		} catch (Exception e) {
			
		}
	}
	@And("^user opens the cbr from itinerary$")
	public void user_opens_the_cbr_from_itinerary() throws Throwable {
	    scrolltoElement(cbr.getItineraryTravelCons());
	    clickAction(cbr.getItineraryTravelCons(),"User clicks the Talk to an expert button in itinerary page");
	}

	@Then("^Verify the cbr posted successfully from itinerary$")
	public void verify_the_cbr_posted_successfully_from_itinerary() throws Throwable {
//	String cbrSuccessMsg =	activityPage.getActivity_CrudSuccessMsgNoti().getText();
//	System.out.println("============================"+cbrSuccessMsg);
//	verifyExactText(activityPage.getActivity_CrudSuccessMsgNoti(),"Thanks! We will call you within 48 hours.");
    validateAssertion(elementDisplayed(intpag.getItineraryH1Element()));
		
	}

	@Then("^user navigate to itinerary page$")
	public void user_navigate_to_itinerary_page() throws Throwable {
		String url = getCurrentUrl();
		System.out.println(url);
		waitUntil(inclusion.getBookNow(),100);
		clickAction(inclusion.getitineraryTab(),"user navigate to Itinerary tab");
	  }
	@Then("^user opens the cbr from inclusions$")
	public void user_opens_the_cbr_from_inclusions() throws Throwable {
	  clickAction(cbr.getCbrFromInclusions(),"User clicks on inclusions page CBR");
	}

	
	public static String packagesUrl = "";
	@Given("^user navigate to packages page$")
	public void user_navigate_to_packages_page() throws Throwable {
		String currentUrl = driver.getCurrentUrl();
		packagesUrl = currentUrl + "packages";
		driver.navigate().to(packagesUrl);
		Thread.sleep(5000);
	}

	@When("^user click on packages page cbr$")
	public void user_click_on_packages_page_cbr() throws Throwable {

		scrollDown();
		pollingWait(cbr.getPackagesCbr(),25);
		clickJavaScriptElement(cbr.getPackagesCbr());
	}

	@When("^user click on vacations page cbr$")
	public void user_click_on_vacations_page_cbr() throws Throwable {

		scrollDown();
		Thread.sleep(1000);
		scrollUp();
		pollingWait(cbr.getVacationsCbr(),30);
		clickJavaScriptElement(cbr.getVacationsCbr());
	}
	
	@Then("^validate the user submitted the cbr successfully$")
	public void validate_the_user_submitted_the_cbr_successfully() throws Throwable {
		Assert.assertTrue(elementExist(cbr.getPackagesCbr()));			
		}
	  @And("^user moves the cursor to url tab$")
	  public void user_moves_the_cursor_to_url_tab() {
		  moveToUrl(driver);
		  try {
			Thread.sleep(9000);
			validate_String_Contains(getCurrentUrl(),"request-callback");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		  
	  }

	  @When("^user fill the cbr value in the form\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	  public void user_fill_the_cbr_value_in_the_form(String arg1, String arg2, String arg3) throws Throwable {
		  typeText(cbr.getUsername(),arg1);
			typeText(cbr.getPhonenumber(),arg2);
			typeText(cbr.getEmail(),arg3);
	  }


}
