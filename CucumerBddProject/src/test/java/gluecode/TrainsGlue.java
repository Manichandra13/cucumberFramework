package gluecode;


import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class TrainsGlue extends Kernel {

	@Then("^validate that the Train section is displayed$")

	public void view_alternate_Trains() throws Throwable {
		try {
			Thread.sleep(5000);
			elementExist(trainsPage.getTrainChangeButton());
			scrolltoElement(trainsPage.getTrainChangeButton());
			} catch (NoSuchElementException e) {
			System.out.println("Alternative train option not available");
		}

	}



	@Then("^validate that the alternate train is selected$")

	public void select_alternate_Trains() throws Throwable {
		clickAction(trainsPage.getTrainChangeButton());
		Thread.sleep(1000);
		try {
			if (elementExist(trainsPage.getTrainReplaceButton())){
				clickAction(trainsPage.getTrainReplaceButton());
			}
		}catch(NoSuchElementException e) {
			System.out.println("No trains available to replace");
			//			e.printStackTrace();
		}
	}
	
	
	
	public void Validate_Filter_Options() throws Throwable {
		try {
		String noTrainCardText= getText(trainsPage.getNoTrainsOptions());
		System.out.println("no Train card Text: "+noTrainCardText);
		if( noTrainCardText.contains("No other trains") )
		{
			System.out.println("Inside no train");
			waitForMe(trainsPage.getBackToInclusions());
			clickAction(trainsPage.getBackToInclusions());
		}
		else if(elementExist(trainsPage.getTrainReplaceButton())){
			clickAction(trainsPage.getTrainReplaceButton());
		}
		String currentUrl = getCurrentUrl();
		validateAssertion(currentUrl.contains("alternate-trains"));
//		Assert.assertFalse(currentUrl.contains("alternate-trains"),"User in alternate-trains page");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}


	@Then("^validate that no stop Train option is chosen succeffully$")
	public void  select_no_stop_trains_filter() throws Throwable {
		clickAction(trainsPage.getNoStopTrains(), "User chooses 'no stop' filter for flights");
		Validate_Filter_Options();
	}


	@Then("^validate that one stop Train option is chosen$")
	public void validate_that_one_stop_Train_option_is_chosen() throws Throwable {
		clickAction(trainsPage.getOneStopTrains(), "User chooses 'one stop' filter for flights");
			Validate_Filter_Options();
		}
		

	

	@Then("^validate that two stop Train option is chosen succeffully$")
	public void validate_that_two_stop_Train_option_is_chosen_succeffully() throws Throwable {
        clickAction(trainsPage.getTwoStopTrains(), "User chooses 'two stop' filter for flights");
        Validate_Filter_Options();
	}

	@Then("^validate that early morning trains option for onward journey is chosen succeffully$")
	public void validate_that_early_morning_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardEarlyMorningTrains(), "User chooses 'Early morning' filter for onward train");
		Validate_Filter_Options();
	}

	@Then("^validate that early morning trains option for return journey is chosen succeffully$")
	public void validate_that_early_morning_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnEarlyMorningTrains(), "User chooses 'Early morning' filter for return train");
		Validate_Filter_Options();

	}

	@Then("^validate that morning trains option for onward journey is chosen succeffully$")
	public void validate_that_morning_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardMorningTrains(), "User chooses 'Morning' filter for onward train");
		Validate_Filter_Options();

	}

	@Then("^validate that morning trains option for return journey is chosen succeffully$")
	public void validate_that_morning_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnMorningTrains(), "User chooses 'Morning' filter for return trains");
		Validate_Filter_Options();

	}

	@Then("^validate that mid-day trains option for onward journey is chosen succeffully$")
	public void validate_that_mid_day_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardMiddayTrains(), "User chooses 'Mid-day' filter for onward trains");
		Validate_Filter_Options();

	}

	@Then("^validate that mid-day trains option for return journey is chosen succeffully$")
	public void validate_that_mid_day_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnMiddayTrains(), "User chooses 'Mid-day' filter for return trains");
		Validate_Filter_Options();

	}

	@Then("^validate that night trains option for onward journey is chosen succeffully$")
	public void validate_that_night_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardNightTrains(), "User chooses 'Night' filter for onward trains");
		Validate_Filter_Options();

	}

	@Then("^validate that night trains option for return journey is chosen succeffully$")
	public void validate_that_night_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnNightTrains(), "User chooses 'Night' filter for return trains");
		Validate_Filter_Options();
	}
	
	@Then("^validate that evening trains option for onward journey is chosen succeffully$")
	public void validate_that_evening_trains_option_for_onward_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getOnwardEveningTrains(), "User chooses 'Night' filter for return trains");
		Validate_Filter_Options();
	}

	@Then("^validate that evening trains option for return journey is chosen succeffully$")
	public void validate_that_evening_trains_option_for_return_journey_is_chosen_succeffully() throws Throwable {

		clickAction(trainsPage.getReturnEveningTrains(), "User chooses 'Night' filter for return trains");
		Validate_Filter_Options();
	}
	
	
	

}
