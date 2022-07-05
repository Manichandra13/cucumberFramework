package gluecode;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class AdminGlue extends Kernel {
	@Then("^Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin$")
	public void user_clicks_continue_to_book() throws Throwable {
		clickAction(adminPage.getadminOptionsDropdown(), "Clicking Admin Dropdown Admin features");
		elementExist(adminPage.getAdminSendToPlatoOption());
		elementExist(adminPage.getAdminShareItinerary());
		elementExist(adminPage.getAdminGetBetterCost());
		elementExist(adminPage.getAdminSharePDF());
		scrolltoElement(adminPage.getAdminSplitPricingForCustomers());
		elementExist(adminPage.getAdminSplitPricingForCustomers());
	}

	@Then("^Validate the share itinerary workflow$")
	public void validate_the_share_itinerary_workflow() throws Throwable {
		clickAction(adminPage.getAdminShareItinerary(), "User clicks the admin share itinerary");
		typeText(adminPage.getShareMobNo(), "9789781211");
		clickAction(adminPage.getSharefetchAcc(), "User clicks the fetch acc no");
		clickAction(adminPage.getShareExistemailId(), "click existing email acc");
		clickAction(adminPage.getShareleadStatusDropDown(), "selcts the drop down to select for lead status");
		clickAction(adminPage.getShareleadStatusinTalks(), "Click inTalks ID");
		clickAction(adminPage.getShareContinueButton(), "User Clicks continue button after sharing the itinerary");
		elementExist(adminPage.getShareAlertMessage());

	}

	@Then("^Validate the split pricing workflow$")
	public void validate_the_share_pricing_workflow() throws Throwable {
		// clickAction(adminPage.getAdminShareItinerary(), "User clicks the admin share
		// itinerary");

		elementExist(adminPage.getAdminSplitPricingForCustomers());
	}


}
