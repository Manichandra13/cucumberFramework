package gluecode;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Kernel;

public class InsuranceGlue extends Kernel {

	@When("^Check an itinerary got successfully costed$")
	public void check_an_itinerary_got_successfully_costed() throws Throwable {
//		pollingWait(inclusion.getBookNow(),20);
		pollingWaitForCostingFlow("inclusions",150);
		System.out.println("Costing URL :" + getCurrentUrl());
		validate_String_Contains(getCurrentUrl(), "inclusions");
		System.out.println("Itinerary got successfully costed");
	}

	@When("^user scroll down and remove the insurance from the inclusions page$")
	public void user_scroll_down_and_remove_the_insurance_from_the_inclusions_page() throws Throwable {
		scrolltoElement(inclusion.getInsuranceDelete());
		clickAction(inclusion.getInsuranceDelete());
	}

	@Then("^validate the insurance got removed successfully$")
	public void validate_the_insurance_got_removed_successfully() throws Throwable {
		Assert.assertTrue(verifyExactText(inclusion.getBookNow(), "Book now"));
		

	}

	@When("^user click the change button in the insurance card$")
	public void user_click_the_change_button_in_the_insurance_card() throws Throwable {
		scrolltoElement(inclusion.getInsuranceChange());
		clickAction(inclusion.getInsuranceChange());
		boolean applyButton = verifyEnabled(inclusion.getInsuranceApply());
		if (applyButton) {
			System.out.println("The apply button is enabled");
		} else {
			System.out.println("The apply button is disabled");
		}

	}

	@When("^select the alternate insurance type$")
	public void select_the_alternate_insurance_type() throws Throwable {
		scrolltoElement(inclusion.getInsuranceType50kPlatinumPlan());
		clickAction(inclusion.getInsuranceType50kPlatinumPlan());
		boolean applyButton = verifyEnabled(inclusion.getInsuranceApply());
		if (applyButton) {
			System.out.println("The apply button is enabled");
			clickAction(inclusion.getInsuranceApply());
		} else {
			System.out.println("The apply button is disabled");
		}

	}

	@Then("^verify the insurance type changed successfully$")
	public void verify_the_insurance_type_changed_successfully() throws Throwable {
		verifyPartialText(inclusion.getInsuranceTypeInclusions(), "50k Platinum Plan");

	}

	@Then("^user add the insurance$")
	public void user_add_the_insurance() throws Throwable {

		clickAction(inclusion.getInsuranceAdd());

	}

	@Then("^verify insurance added successfully$")
	public void verify_insurance_added_successfully() throws Throwable {
		elementExist(inclusion.getInsuranceChange());

	}

}
