package gluecode;

import org.openqa.selenium.NoSuchElementException;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class FerryGlue extends Kernel {

	@Then("^user chooses the alternate transfer as ferry in the Itinerary page$")
	public void user_chooses_the_alternate_transfer_as_ferry_in_the_Itinerary_page() throws Throwable {
		try {

			hoverWebelement(ferryPage.getFlightInYourRoute());
			clickAction(ferryPage.getReplaceTransfer());
			if (elementExist(ferryPage.getAlternateFerry())) {
				clickAction(ferryPage.getAlternateFerry());
				Thread.sleep(2000);
				scrolltoElement(icm.getcalculateTripCostButton());
			}
		} catch (NoSuchElementException e) {
			//ReporteraddStepLog("No Alternate ferry is displaying");

		}
	}
		


	@Then("^validate that the Ferry section is displayed$")
	public void validate_that_the_Ferry_section_is_displayed() throws Throwable {
	    waitForMe(inclusionNew.getInclusionsTabLink());
		elementExist(inclusionNew.getFerrySection());
		}


	@Then("^validate the ferry is changed$")
	public void validate_the_ferry_change_view() throws Throwable {
	    clickAction(ferryPage.getFerrySection());
	    System.out.println("Ferry is validated");
	}






















}
