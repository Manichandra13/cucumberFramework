package gluecode;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pyt.pages.SandunePage;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class SanduneActivitiesGlue extends Kernel {

	public String activityChange_HD;

	@Then("^User navigates from itinerary to inclusion page$")
	public void user_navigates_from_itinerary_to_inclusion_page() throws Throwable {

		validateAssertion(elementDisplayed(dubaiPage.getInclusionHeader()));
			clickAction(dubaiPage.getInclusionHeader());
		

	}

	public void validate_the_activity_removed_successfully() throws Throwable {
		boolean isReomved = verifyExactText(activityPage.getActivitySlider_AfterRemove(), "Activity Removed!");
		Assert.assertTrue(isReomved);
		clickAction(activityPage.getActivity_SliderClose(), "User clicks on out side the silder to close");
	}

	@Then("^User replaces the activities in the itinerary page$")
	public void user_replaces_the_activities_in_the_itinerary_page() throws Throwable {

		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));
			if ((!activity_HD.equals("At leisure")) && (!activity_HD.contains("flight back"))
					&& (!activity_HD.contains("Arrive in Dubai airport"))) {
				clickAction(dubaiPage.getActivityCardList().get(i));
				clickAction(activityPage.getActivitySlider_ViewSimilar(), "Activity alternate page from slider");
				while (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
				activityChange_HD = getText(dubaiPage.getActivityCardList().get(i));
				validateAssertion(!activity_HD.equalsIgnoreCase(activityChange_HD));
				break;
			}
		}
	}

	@Then("^User adds the activities in the itinerary page$")
	public void user_adds_the_activities_in_the_itinerary_page() throws Throwable {

		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));

			if (activity_HD.equals("At leisure")) {

				clickAction(dubaiPage.getActivityCardList().get(i));
				while (elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
				}
				hoverWebelement(activityPage.getActivityAlternate_Cards());
				clickAction(activityPage.getActivityAlternate_Choose(),
						"Choosing the first activity in the alternate page");
				activityChange_HD = getText(dubaiPage.getActivityCardList().get(i));
				validateAssertion(!activity_HD.equalsIgnoreCase(activityChange_HD));
				break;

			}
		}
	}

	@Then("^User removes the activities in the itinerary page$")
	public void user_removes_the_activities_in_the_itinerary_page() throws Throwable {

		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));
			if ((!activity_HD.equals("At leisure")) && (!activity_HD.contains("flight back"))
					&& (!activity_HD.contains("Arrive in Dubai airport"))) {
				clickAction(dubaiPage.getActivityCardList().get(i));
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();
				break;
			}

		}
	}
	

	@Then("^user selects the activity slot for filter validation$")
	public void user_selects_the_activity_slot_for_filter_validation() throws Throwable {
		
		for (int i = 0; i < dubaiPage.getActivityCardList().size(); i++) {
			String activity_HD = getText(dubaiPage.getActivityCardList().get(i));
			if ((!activity_HD.equals("At leisure")) && (!activity_HD.contains("flight back"))
					&& (!activity_HD.contains("Arrive in Dubai airport"))) 
			{
				clickAction(dubaiPage.getActivityCardList().get(i));
				System.out.println("Activity card is clicked");
				clickAction(activityPage.getActivitySlider_ViewSimilar());
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
					
				}
			}
			else if(activity_HD.equals("At leisure")) {
				clickAction(dubaiPage.getActivityCardList().get(i));
				while(elementDisplayed(ip.getgotItPopup())) {
					clickAction(ip.getgotItPopup());
					
				}
	}
	
	}}	
	
	
}
