
package gluecode;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class ActivitiesGlue extends Kernel {

	public static String activity="";

	@And("validate the activity removal flow")
	public void navigates_InclusionPage() throws Throwable {
		popupClosure();
		popupClosure();

		clickAction(activityPage.getActivity_viewDetails(), "User views the activity Details");
		clickAction(activityPage.getActivity_ChangeButton(), "User changes the activity ");
		popupClosure();

		clickAction(activityPage.getActivity_ChangeAlternateActivity(), "User selects the alternate activity ");
		popupClosure();
		clickAction(activityPage.getActivity_AddToItineraryButton(),
				"User adds the selected activity to the itinerary ");
		clickAction(activityPage.getActivity_viewDetails(), "User views the activity Details");
		clickAction(activityPage.getActivity_RemoveButton(), "User Removes the activity ");
	}

	@Then("^validate the activity slider in the itinerary page$")
	public void validate_the_activity_slider_in_the_itinerary_page() throws Throwable {
		if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
			String activityquar = getText(activityPage.getActivity_FirstQuarterDaySlot());

			if (!activityquar.contains("At leisure")&& !activityquar.contains("Add activity")) {
				waitForMe(activityPage.getActivity_FirstQuarterDaySlot());
				clickAction(activityPage.getActivity_FirstQuarterDaySlot());
				validate_String_Contains(getCurrentUrl(), "activity-preview/");
			}
			else if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {
				String activityhalf = getText(activityPage.getActivity_FirstHalfDaySlot());

				if (!activityhalf.contains("At leisure")&& !activityhalf.contains("Add activity")) {
					waitForMe(activityPage.getActivity_FirstHalfDaySlot());
					clickAction(activityPage.getActivity_FirstHalfDaySlot());
					validate_String_Contains(getCurrentUrl(), "activity-preview/");
				}
			} else if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {
				String activity = getText(activityPage.getActivity_FirstFullDaySlot());

				if (!activity.contains("At leisure")&& !activity.contains("Add activity")) {
					waitForMe(activityPage.getActivity_FirstFullDaySlot());
					clickAction(activityPage.getActivity_FirstFullDaySlot());
					validate_String_Contains(getCurrentUrl(), "activity-preview/");
				}

			}
		}
		else {

			//ReporteraddStepLog("The itinerary contains no activity");

		}


	}

	public String activity_FD;
	public String activityChange_FD;
	public String activity_HD;
	public String activityChange_HD;
	public String activity_QD;
	public String activityChange_QD;

	@Then("^user change and validate the activity in full day slot$")
	public void user_change_the_activity_in_full_slot() throws Throwable {
      try {
    	  
			if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {

				// Getting the text of the acivity using slot xpath and verifying the slot
				// contains activity if the slot having activity making click action
				activity_FD = getText(activityPage.getActivity_FirstFullDaySlot());

				if (!activity_FD.contains("At leisure") && !activity_FD.contains("Add activity")) {
					clickAction(activityPage.getActivity_FirstFullDaySlot(),
							"User click on full day_slot activity in itinerary page to open activity slider  ");
					clickAction(activityPage.getActivitySlider_ViewSimilar(),
							"user opens activity alternate page from slider");
					while (elementDisplayed(ip.getgotItPopup())) {
						clickAction(ip.getgotItPopup());
					}
					hoverWebelement(activityPage.getActivityAlternate_Cards());
					clickAction(activityPage.getActivityAlternate_Choose(),
							"Choosing the first activity in the alternate page");
					activityChange_FD = getText(activityPage.getActivity_FirstFullDaySlot());
					validateAssertion(!activity_FD.equalsIgnoreCase(activityChange_FD));

				} else {
					System.out.println("There is no Full day activity in this itinerary");
					//ReporteraddStepLog("There is no Full day activity in this itinerary ");
				}
			}
      }
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("There is no full day slot in the itinerary ");
		}
	}

	@Then("^user change and validate the activity in half day slot$")
	public void validate_the_user_change_the_activity_in_half_slot() throws Throwable {
    try {
		if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {
			// Getting the text of the acivity using slot xpath and verifying the slot
			// contains activity if the slot having activity making click action
			activity_HD = getText(activityPage.getActivity_FirstHalfDaySlot());

			if (!activity_HD.contains("At leisure")&& !activity_HD.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstHalfDaySlot(),
						"User click on half day_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_ViewSimilar(), "Activity alternate page from slider");
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
				activityChange_HD = getText(activityPage.getActivity_FirstHalfDaySlot());
				validateAssertion(!activity_HD.equalsIgnoreCase(activityChange_HD));
				
			} else {
				System.out.println("There is no Half day activity in this itinerary");
				//ReporteraddStepLog("There is no half day activity in the itinerary ");
			}
		}
}
		catch(NoSuchElementException e) {
			System.out.println("There is no half day slot in this itinerary");
			//ReporteraddStepLog("There is no half day slot in the itinerary ");
		}

	}

	@Then("^user change and validate the activity in quater day slot$")
	public void user_change_the_activity_in_quater_day_slot() throws Throwable {
       try {
		if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
			// Getting the text of the acivity using slot xpath and verifying the slot
			// contains activity if the slot having activity making click action
			activity_QD = getText(activityPage.getActivity_FirstQuarterDaySlot());

			if (!activity_QD.contains("At leisure")&& !activity_QD.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstQuarterDaySlot(),
						"User click on full_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_ViewSimilar(), "Activity alternate page from slider");
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
				activityChange_QD = getText(activityPage.getActivity_FirstQuarterDaySlot());
				validateAssertion(!activity_QD.equalsIgnoreCase(activityChange_QD));

			}
		
		else {
			System.out.println("There is no Quarter day activity in this itinerary");
			//ReporteraddStepLog("There is no Quarter day activity in the itinerary ");
		}
		}
       }
       catch(NoSuchElementException e) {
    	   //ReporteraddStepLog("There is no Quarter day slot in the itinerary ");
       }
	}


	@And("^user add the activity in full day slot$")
	public void user_add_the_activity_in_full_day_slot() throws Throwable {
		try {
		if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstFullDaySlot());

			if ("At leisure".equals(activity) && "Add activity".equals(activity)) {
				clickAction(activityPage.getActivity_FirstFullDaySlot(),
						"Activity alternate page open to add activity");
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
			}
		}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("There is no full day slot in the itinerary ");
		}
	}

	@And("^user add the activity in half day slot$")
	public void user_add_the_activity_in_half_day_slot() throws Throwable {
		try {
		if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstHalfDaySlot());
			if(activity.contains("At leisure") && (activity.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstHalfDaySlot(),
						"Activity alternate page open to add activity");
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
			}
		}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("There is no half day slot in the itinerary ");
		}
	}
	

	@And("^user add the activity in quarter day slot$")
	public void user_add_the_activity_in_quarter_day_slot() throws Throwable {
      try {
		if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstQuarterDaySlot());

			if ("At leisure".equals(activity) && "Add activity".equals(activity)) {
				clickAction(activityPage.getActivity_FirstQuarterDaySlot(),
						"Activity alternate page open to add activity");
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
			}
		}
      }
      catch(NoSuchElementException e) {
    	  //ReporteraddStepLog("There is no quarter day slot in the itinerary ");
      }
	}

	@Then("^validate the activity added in itinerary successfully$")
	public void validate_the_activity_added_in_itinerary_successfully() throws Throwable {
		validate_String_Contains(getCurrentUrl(), "view/");
	}

	@Given("^user land on home page without login$")
	public void user_land_on_home_page_without_login() throws Throwable {
		waitForMe(hp.getLogin());
		elementExist(hp.getLogin());
		//ReporteraddStepLog("user didn't log");
	}


	@And("^user remove the full day activity and validate the activity removed$")
	public void user_remove_the_full_day_activity() throws Throwable {
		try {
		if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {

			activity = getText(activityPage.getActivity_FirstFullDaySlot());

			if (!activity.contains("At leisure")&& !activity.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstFullDaySlot(),
						"User click on full day_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_Remove());
				
				validate_the_activity_removed_successfully();
				
             
			}

		}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("There is no full day slot in the itinerary ");
			System.out.println("There is no full day slot in the itinerary ");
		}

	}

	
	public void validate_the_activity_removed_successfully() throws Throwable {
		boolean isReomved = verifyExactText(activityPage.getActivitySlider_AfterRemove(), "Activity Removed!");
		Assert.assertTrue(isReomved);
		clickAction(activityPage.getActivity_SliderClose(),"User clicks on out side the silder to close");
	}

	@And("^user remove the half day activity and validate the activity removed$")
	public void user_remove_the_half_day_activity() throws Throwable {
       try {
		if (elementExist(activityPage.getActivity_FirstHalfDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstHalfDaySlot());

			if (!activity.contains("At leisure")&& !activity.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstHalfDaySlot(),
						"User click on full day_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();
			}
		}
       }
		catch(NoSuchElementException e)
       {
			//ReporteraddStepLog("There is no half day slot in the itinerary ");
			System.out.println("There is no half day slot in the itinerary ");
			
       }
	}

	@And("^user remove the quarter day activity and validate the activity removed$")
	public void user_remove_the_quarter_day_activity() throws Throwable {
		try {
		
		
		if (elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {

			String activity = getText(activityPage.getActivity_FirstQuarterDaySlot());

			if (!activity.contains("At leisure")&& !activity.contains("Add activity")) {
				clickAction(activityPage.getActivity_FirstQuarterDaySlot(),
						"User click on full day_slot activity in itinerary page to open activity slider  ");
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();

			}
		}
		}catch(NoSuchElementException e) {
			//ReporteraddStepLog("There is no quarter day slot in the itinerary ");
			System.out.println("There is no quarter day slot in the itinerary ");
		}
	}

	@Then("^Add activity using slider from itinerary$")
	public void add_activity_using_slider_from_itinerary() throws Throwable {
		clickAction(activityPage.getActivitySlider_AddActivity(),
				"User clicks on Add acitvity button in the activity slider after removed the activity");
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		hoverWebelement(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivityAlternate_Choose(), "Choosing the first activity in the alternate page");
	}

	@And("^user change the activity from inclusions via alternate page$")
	public void user_change_the_activity_from_inclusions() throws Throwable {
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		clickAction(activityPage.getActivity_InclusionsfirstCard(),
				"user clicks on the 1st activity card in the inclusion page ");
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		hoverWebelement(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivityAlternate_Choose(),
				"User click choose the first activity in the alternate page");
	}

	@Then("^validate the activity added from inclusions successfully$")
	public void validate_the_activity_added_from_inclusions_successfully() throws Throwable {
		validate_String_Contains(getCurrentUrl(), "inclusion");
	}

	@Then("^user change the activity from inclusions via details page$")
	public void user_change_the_activity_from_inclusions_via_details_page() throws Throwable {
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		clickAction(activityPage.getActivity_InclusionsfirstCard(),
				"user clicks on the 1st activity card in the inclusion page ");
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		clickAction(activityPage.getActivityAlternate_Cards());
		clickAction(activityPage.getActivity_AddToItineraryButton(),"User change activity via details modal");
	}

	@Then("^user navigate to alternate page from inclusions$")
	public void user_navigate_to_alternate_page() throws Throwable {
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
	}

	@Then("^user clicks the view similar to view the alternate page$")
	public void user_clicks_the_view_similar() throws Throwable {

		clickJavaScriptElement(activityPage.getActivitySlider_ViewSimilar());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		validate_String_Contains(getCurrentUrl(),"alternate-activities/");
	}



	@And("^user clicks the empty slot in the itinerary$")
	public void user_clicks_the_empty_slot_in_the_itinerary() throws Throwable {
		if (elementExist(activityPage.getActivity_FirstFullDaySlot())) {
			String activityFull = getText(activityPage.getActivity_FirstFullDaySlot());
			if(activityFull.contains("At leisure") && (activityFull.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstFullDaySlot());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				validate_String_Contains(getCurrentUrl(),"alternate-activities/");
			}


		}
		else if(elementExist(activityPage.getActivity_FirstHalfDaySlot())) {

			String activityHalf = getText(activityPage.getActivity_FirstHalfDaySlot());
			if(activityHalf.contains("At leisure") && (activityHalf.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstHalfDaySlot());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				validate_String_Contains(getCurrentUrl(),"alternate-activities/");
			}

		}
		else if(elementExist(activityPage.getActivity_FirstQuarterDaySlot())) {
			String activityQuar = getText(activityPage.getActivity_FirstQuarterDaySlot());
			if(activityQuar.contains("At leisure") && (activityQuar.contains("Add activity"))){
				clickAction(activityPage.getActivity_FirstQuarterDaySlot());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				validate_String_Contains(getCurrentUrl(),"alternate-activities/");
			}
		}
		else {
			//ReporteraddStepLog("The itinerary has no empty slot");
		}

	}

	@Then("^apply smart filter and validate the filter applied successfully$")
	public void apply_smart_filter_and_validate_the_filter_applied_successfully() throws Throwable {

		try {

			clickAction(activityPage.getActivity_SmartFilter(),"User click the smart filter");
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"User click choose the first activity in the alternate page");
				validate_String_Contains(getCurrentUrl(),"view");

			}
		}catch(NoSuchElementException e) {
			//			//ReporteraddStepLog("Applied filter doesn't have result");
			clickAction(activityPage.getBackToItineraryButtonInAlternate(),"User clicks the back to itinerary button due to no result found for the smart filter");

		}


	}

	@Then("^apply \"([^\"]*)\" filter and validate the filter applied successfully$")
	public void apply_morning_filter_and_validate_the_filter_applied_successfully(String slot) throws Throwable {

				try {
					if (slot.equalsIgnoreCase("noon")) {
						driver.findElement(By.xpath("//a[text()='After" + slot + "']")).click();
					} else {
						driver.findElement(By.xpath("//a[text()='" + slot + "']")).click();
					}
				
					if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0) {
						clickAction(activityPage.getActivityAlternate_Cards(),
								"User clicks on the activity card in the alternate");
						clickAction(activityPage.getActivity_AddToItineraryButton());
					}else {
						clickAction(activityPage.getBackToItineraryButtonInAlternate());
					}
				} catch (NoSuchElementException e) {
					//ReporteraddStepLog("Applied filter doesn't have result");
					clickAction(activityPage.getBackToItineraryButtonInAlternate());
				}
		}


	@Then("^apply afternoon filter and validate the filter applied successfully$")
	public void apply_afternoon_filter_and_validate_the_filter_applied_successfully() throws Throwable {

		clickAction(activityPage.getActivity_AfternoonTimeSlotFilter(),"User clicks on the Afternoon slot filter");
		validate_the_filter_applied_successfully("Afternoon");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");
		}
	}

	@Then("^apply evening filter and validate the filter applied successfully$")
	public void apply_evening_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_EveningTimeSlotFilter(),"User clicks on the evening slot filter"); 
		validate_the_filter_applied_successfully("Evening");
		try {


			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply quarter day filter and validate the filter applied successfully$")
	public void apply_quarter_day_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_QuarterDayDurationFilter(),"User clicks on the Quarter day filter");
		validate_the_filter_applied_successfully("Quarter Day");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply half day filter and validate the filter applied successfully$")
	public void apply_half_day_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_HalfDayDurationFilter(),"User clicks on the half day filter");
		validate_the_filter_applied_successfully("Half Day");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply full day filter and validate the filter applied successfully$")
	public void apply_full_day_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_FullDayDurationFilter(),"User clicks on the full day filter");
		validate_the_filter_applied_successfully("Full Day");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply transfer included filter and validate the filter applied successfully$")
	public void apply_transfer_included_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_TranferIncludedFilter(),"User clicks on the transfer included filter");
		validate_the_filter_applied_successfully("Included");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply transfer not included filter and validate the filter applied successfully$")
	public void apply_transfer_not_included_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_TranferNotIncludedFilter(),"User clicks on the transfer included filter");
		validate_the_filter_applied_successfully("Not Included");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply art and culture filter and validate the filter applied successfully$")
	public void apply_art_and_culture_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_ArtAndCulture(),"User clicks on the  art and culture filter");
		validate_the_filter_applied_successfully("Art & Culture");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply adventure and outdoor filter and validate the filter applied successfully$")
	public void apply_adventure_and_outdoor_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_AdventureAndOutdoor(),"User clicks on the adventure and outdoor filter");
		validate_the_filter_applied_successfully("Adventure & Outdoor");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply food and nightlife filter and validate the filter applied successfully$")
	public void apply_food_and_nightlife_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_FoodAndNightlife(),"User clicks on the  art and culture filter");
		validate_the_filter_applied_successfully("Food & Nightlife");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply shopping and leisure filter and validate the filter applied successfully$")
	public void apply_shopping_and_leisure_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_ShoppingAndLeisure(),"User clicks on the  art and culture filter");
		validate_the_filter_applied_successfully("Shopping & Leisure");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply top highlight filter and validate the filter applied successfully$")
	public void apply_top_highlight_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_TopHighlightsFilter(),"User clicks on the top highlight filter");
		validate_the_filter_applied_successfully("Top Highlight"); 
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply Kid friendly filter and validate the filter applied successfully$")
	public void apply_Kid_friendly_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_KidFriendlyFilter(),"User clicks on the kid friendly filter");
		validate_the_filter_applied_successfully("Kid Friendly"); 
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply fast selling filter and validate the filter applied successfully$")
	public void apply_fast_selling_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_FastSellingFilter(),"User clicks on the fast selling filter");
		validate_the_filter_applied_successfully("Fast Selling");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply less exploration filter and validate the filter applied successfully$")
	public void apply_less_exploration_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_LessExploredGemsFilter(),"User clicks on the less exploration gems filter");
		validate_the_filter_applied_successfully("Less explored gems");
		try {

			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply self exploration filter and validate the filter applied successfully$")
	public void apply_self_exploration_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_SelfExplorationFilter(),"User clicks on the self exploration filter");
		validate_the_filter_applied_successfully("Self Exploration");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				elementExist(activityPage.getSelfExplorationTag());
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}

	@Then("^apply shared filter and validate the filter applied successfully$")
	public void apply_shared_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_SharedFilter(),"User clicks on the shared filter under group type");
		validate_the_filter_applied_successfully("Shared");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}

	}

	@Then("^apply private filter and validate the filter applied successfully$")
	public void apply_private_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		clickAction(activityPage.getActivity_PrivateFilter(),"User clicks on the private filter under group type");
		validate_the_filter_applied_successfully("Private");
		try {
			if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
				clickAction(activityPage.getActivityAlternate_Cards(),"User clicks on the activity card in the alternate");
				clickAction(activityPage.getActivity_AddToItineraryButton());

			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("Applied filter doesn't have result");

		}
	}


	@And("^user navigate to activity alternate page from the inclusions page$")
	public void user_navigate_to_activity_alternate_page_from_the_inclusions_page() throws Throwable {
		waitForMe(inclusion.getActivityTabInclusions());
		clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
		waitForMe(activityPage.getActivity_ExpandActivityInclusions());
		clickAction(activityPage.getActivity_ExpandActivityInclusions());
		waitForMe(activityPage.getActivity_InclusionsfirstCard());
		clickAction(activityPage.getActivity_InclusionsfirstCard(),
				"user clicks on the 1st activity card in the inclusion page ");
		clickAction(activityPage.getActivity_ChangeButton());
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}


	}
	@Then("^user search for the activity$")
	public void user_search_for_the_activity() throws Throwable {
		clickAction(activityPage.getActivitySlider_AddActivity(),
				"User clicks on Add acitvity button in the activity slider after removed the activity");
		while(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		typeText(activityPage.getActivityAlternate_SearchBox(),activity);


	}

	@Then("^validate the activity search box$")
	public void validate_the_activity_search_box() throws Throwable {
		if (driver.findElements(By.xpath("//div[contains(@class,'activity-alter-card')]")).size() > 0 ) {
			String name = getText(activityPage.getNameOfActivityFirstCardAlternate());
			compareTwoStrings(activity,name);		

		} 



	}
//	@And("^user clicks the recently booked itinerary$") 
//	public void user_clicks_the_recently_booked_itinerary() throws InterruptedException {
//		scrolltoElement(hp.getrecentlyBookedItinerary());
//		clickAction(hp.getrecentlyBookedItinerary(),"User clicks the recently booked itinerary from home page");
//		while(elementDisplayed(ip.getgotItPopup())) {
//			clickAction(ip.getgotItPopup());
//		}
//	}

	@And("^user clicks the activity slot \"([^\"]*)\"$")
	public void user_clicks_the_activity_slot(String slot) throws Throwable {
		activityEmptySlot(slot);
	}

	@And("^user clicks the empty slot in the itinerary \"([^\"]*)\"$")
	public void user_clicks_the_empty_slot_in_the_itinerary_with_slot(String slot) throws Throwable {
		activityEmptySlot(slot);
	}

	@And("^user clicks recently booked itinerary$")
	public void user_clicks_recently_booked_itinerary() throws InterruptedException {
		Thread.sleep(2000);
		scrolltoElement(hp.getPromoSection());
		Thread.sleep(2000);
		scrolltoElement(hp.getrecentlyBookedItinerary());
		Thread.sleep(2000);
		clickAction(hp.getBookedItinerayFromHomePage());
		Thread.sleep(1000);
		switchWindows();
		Thread.sleep(3000);
		clickAction(ip.getgotItPopup());

	}
	
	@Given("^user clicks the package itinerary from home page$")
	public void user_clicks_the_package_itinerary_from_home_page() {
		
	try {
		Thread.sleep(1000);
//		scrolltoElement(hp.getPackageSlugItineraryHomePage());
		scrollDown();
        clickAction(hp.getPackageSlugItineraryHomePage());
        Thread.sleep(1000);
		switchWindows();
		Thread.sleep(3000);
		clickAction(ip.getgotItPopup());


	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@And("^verify all filters from \"([^\"]*)\"$")
	public void verify_all_filters_from(String type) throws Throwable {
		verifyingTimeSlotActivity(type);
	}


}
