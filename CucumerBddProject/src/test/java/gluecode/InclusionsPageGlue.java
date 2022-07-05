package gluecode;

import org.openqa.selenium.NoSuchElementException;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class InclusionsPageGlue extends Kernel {

	@And("^user clicks inclusion page")
	public void navigates_InclusionPage() throws Throwable {
		waitUntil(inclusionNew.getInclusionsTabLink(), 25);
		waitUntil(inclusionNew.getHotelSection(), 25);
		clickAction(inclusionNew.getInclusionsTabLink(), "User Navigates to Inclusions  page");

	}

	@Then("^validate that the Flight section is displayed")
	public void validate_FlightsPanel() throws Throwable {
		waitForMe(inclusionNew.getFlightSection());
		elementExist(inclusionNew.getFlightSection());
	}

	@Then("^validate that the Activity section is displayed")
	public void validate_ActivityPanel() throws Throwable {
		// scrolltoElement(inclusionNew.getActivitySection());
		// waitForMe(inclusionNew.getInclusionsTabLink());
		elementExist(inclusionNew.getActivitySection());
	}

	@Then("^validate that the Transfer section is displayed")
	public void validate_TransferPanel() throws Throwable {
		elementExist(inclusionNew.getTransferSection());
	}

	@Then("^validate that the Hotel section is displayed")
	public void validate_HotelPanel() throws Throwable {
		try {

			validateAssertion(elementDisplayed(inclusionNew.getHotelSection()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^validate that the Visa and insurance section is displayed")
	public void validate_VisHotePanel() throws Throwable {
		elementExist(inclusionNew.getVisaSection());
	}

	@Then("^validate that the Pass section is displayed")
	public void validate_PassPanel() throws Throwable {
		elementExist(inclusionNew.getPassSection());
	}

	@Then("^validate that the Summary section is displayed")
	public void validate_SummaryPanelPanel() throws Throwable {
		elementExist(inclusionNew.getSummarySection());
	}

	@Then("^validate whether Flight change is selected$")
	public void validate_whether_Flight_change_is_selected() throws Throwable {
		try {
			waitForMe(inclusion.getFlightChangeButton());
			clickAction(inclusion.getFlightChangeButton());
			pollingWait(ip.getgotItPopup(), 120);
			// elementExist(inclusion.getFlightChangeButton());
			// elementExist(inclusionNew.getFlightSection());
		} catch (NoSuchElementException e) {

			clickAction(inclusionNew.getRetryFlight());
			pollingWait(ip.getgotItPopup(), 60);

		} catch (Exception ex) {
			System.out.println("There are no Flights displayed ");
			// ReporteraddStepLog("There are no Flights displayed ");
		}
	}

}
