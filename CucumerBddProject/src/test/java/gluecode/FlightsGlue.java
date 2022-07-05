
package gluecode;

import static org.junit.Assume.assumeTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class FlightsGlue extends Kernel {

	protected void view_alternate_flights(String source) throws Throwable {

		if(source.contentEquals("International")) {

			try
			{
				waitForMe(flightPage.getFlightViewDetails());
				clickAction(flightPage.getFlightViewDetails(), "User views the Flight Details");
			}
			catch(NoSuchElementException e)
			{
				clickAction(inclusionNew.getRetryFlight());
				//ReporteraddStepLog("Retrying the International Flights");
				waitForMe(flightPage.getFlightViewDetails());
				clickAction(flightPage.getFlightViewDetails(), "User views the Flight Details");
			}
			catch(Exception ex)
			{
				//ReporteraddStepLog("There are no International Flights displayed even after retrying ");
			}

		}
		else if(source.contentEquals("Internal")){

			try
			{
				waitForMe(flightPage.viewInternalFlightDetails());
				clickAction(flightPage.viewInternalFlightDetails(), "User views the internal flight details");
			}
			catch(NoSuchElementException e)
			{
				scrollByValue(200);
				clickAction(inclusionNew.getRetryFlight());
				//ReporteraddStepLog("Retrying the Internal Flights");
				waitForMe(flightPage.viewInternalFlightDetails());
				clickAction(flightPage.viewInternalFlightDetails(), "User views the internal flight details");
			}
			catch(Exception ex)
			{
				//ReporteraddStepLog("There are no Internal Flights displayed even after retrying");
			}
		}

		try {
			waitForMe(inclusion.getFlightChangeButton());
			clickAction(inclusion.getFlightChangeButton());
		} catch (NoSuchElementException e) {

			//ReporteraddStepLog("Retrying the Flights");
			clickAction(inclusionNew.getRetryFlight());
		}
		catch (Exception ex)
		{
			//ReporteraddStepLog("There are no Flights displayed even after retrying");
		}

		//For closing the smart filter popup
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}

	}
	
	protected void select_alternate_flight() throws Throwable {
		
		try {
			try {
				if (elementDisplayed(ip.getgotItPopup())) {

					clickAction(ip.getgotItPopup());
				}
			} catch (NoSuchElementException e) {

			}
			
			try {
				pollingWait(flightPage.getAvailableAlternateFlightsCount(), 120);
			} catch (Exception e) {
				if (flightPage.getOnwardMiddayFlights().isDisplayed()) {
					pollingWait(flightPage.getNoItemsAvailable(), 30);
					if (elementDisplayed(flightPage.getNoItemsAvailable())) {
						System.out.println("Alternates are not available");
						assumeTrue(false);
					}
				}
			}
			
//			pollingWait(flightPage.getFlightReplaceFirstFlight());
//			popupClosure();
			
			if(driver.findElements(By.xpath("(//section[@class='flight-card '])[1]")).size() > 0)
			{
				System.out.println("Alternate count: "+getText(flightPage.getAvailableAlternateFlightsCount()));
			
				scrollByValue(-750);
				clickAction(flightPage.getFlightReplaceFirstFlight(), "User selects the alternate Flight");
				waitForMe(flightPage.getflightAddToItineraryButton());
				clickAction(flightPage.getflightAddToItineraryButton(), "User adds the selected Flight to the itinerary ");

				if (driver.findElements(By.xpath("//button[@class='confirm']")).size() > 0)
				{
					Thread.sleep(4000);
					waitForMe(flightPage.getArrivalDateChanged());
					clickAction(flightPage.getArrivalDateChanged());
					waitForMe(inclusion.getBookNow());
					if(verifyStringNotEquals(getCurrentUrl(), "alternate-flights"))
					{
						//ReporteraddStepLog("Alternate flights has been added in the Inclusions page");
					}
				}
				else
				{
					waitForMe(inclusion.getBookNow());
					if(verifyStringNotEquals(getCurrentUrl(), "alternate-flights"))
					{
						//ReporteraddStepLog("Alternate flights has been added in the Inclusions page");
					}
				}
			}
			else
			{
				//ReporteraddStepLog("There are no alternate flights to select");
				assumeTrue(false);
			}
			
		} catch (NoSuchElementException e) {
			System.out.println(("Alternate flights are not loading"));
			//ReporteraddStepLog("Alternate flights are not loading");
		}
	}
	
	
	protected void validate_selected_flight_details() throws Throwable {
		
		String onwDepTime = flightPage.getOnwDepTimeFromFlightCard().getText();
		String onwDepCity = flightPage.getOnwDepCityFromFlightCard().getText();
		String onwArrTime = flightPage.getOnwArrTimeFromFlightCard().getText();
		String onwArrCity = flightPage.getOnwArrCityFromFlightCard().getText();
		
		//div[@name='all-flight-panels']/div/section[1]//div[contains(@class,'mbottom')][1]//*/div[contains(@class,'route-details')]//*/div//b
	}
	
	@And("validate the flight change view")

	public void flight_Update() throws Throwable {

		view_alternate_flights("International");
		select_alternate_flight();

	}
	
	@And("^validate that smart filtered flight option is chosen succeffully$")
	
	public void select_smart_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		if(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		Thread.sleep(2000);
		
		clickJavaScriptElement(flightPage.getFlightSmartFilter());
		//ReporteraddStepLog("Enabled the Smart Filter Option");
//		clickAction(flightPage.getFlightSmartFilter(), "User enables smart filter for flights");
		select_alternate_flight();

	}
	
	@And("^validate that direct flight option is chosen succeffully$")
	
	public void select_direct_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
//		popupClosure();
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {
			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getDirectFlights());
		clickAction(flightPage.getDirectFlights(), "User chooses 'Direct' filter for flights");
		select_alternate_flight();

	}
	
	@And("^validate that one stop flight option is chosen succeffully$")
	
	public void select_one_stop_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getOneStopFlights());
		clickAction(flightPage.getOneStopFlights(), "User chooses '1 stop' filter for flights");
		select_alternate_flight();

	}
	
	@And("^validate that two stop flight option is chosen succeffully$")
	
	public void select_two_stop_flights_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getTwoStopFlights());
		clickAction(flightPage.getTwoStopFlights(), "User chooses '2 stops' filter for flights");
		select_alternate_flight();

	}
	
	@And("^validate that early morning flight option for onward journey is chosen succeffully$")
	
	public void select_dep_early_morning_flights_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getOnwardEarlyMorningFlights());
		clickAction(flightPage.getOnwardEarlyMorningFlights(), "User chooses 'Early morning' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that early morning flight option for return journey is chosen succeffully$")
	
	public void select_arr_early_morning_flights_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getReturnEarlyMorningFlights());
		clickAction(flightPage.getReturnEarlyMorningFlights(), "User chooses 'Early morning' filter for return flight");
		select_alternate_flight();

	}
	
	@And("^validate that morning flight option for onward journey is chosen succeffully$")
	
	public void select_dep_morning_flights_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		waitForMe(flightPage.getOnwardMorningFlights());
		clickAction(flightPage.getOnwardMorningFlights(), "User chooses 'Morning' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that morning flight option for return journey is chosen succeffully$")
	
	public void select_arr_morning_flights_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getReturnMorningFlights());
		clickAction(flightPage.getReturnMorningFlights(), "User chooses 'Morning' filter for return flight");
		select_alternate_flight();

	}
	
	@And("^validate that mid-day flight option for onward journey is chosen succeffully$")
	
	public void select_dep_midday_flights_filter() throws Throwable {
		waitForMe(ip.getgotItPopup());
//		view_alternate_flights("International");
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getOnwardMiddayFlights());
		clickAction(flightPage.getOnwardMiddayFlights(), "User chooses 'Mid-day' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that mid-day flight option for return journey is chosen succeffully$")
	
	public void select_arr_midday_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getReturnMiddayFlights());
		clickAction(flightPage.getReturnMiddayFlights(), "User chooses 'Mid-day' filter for return flight");
		select_alternate_flight();

	}

	@And("^validate that night flight option for onward journey is chosen succeffully$")
	
	public void select_dep_night_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getOnwardNightFlights());
		clickAction(flightPage.getOnwardNightFlights(), "User chooses 'Night' filter for onward flight");
		select_alternate_flight();

	}

	@And("^validate that night flight option for return journey is chosen succeffully$")
	
	public void select_arr_night_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getReturnNightFlights());
		clickAction(flightPage.getReturnNightFlights(), "User chooses 'Night' filter for return flight");
		select_alternate_flight();

	}
	
	@And("^validate that refundable option for flights is chosen succeffully$")
	
	public void select_refundable_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getRefundableFlights());
		clickAction(flightPage.getRefundableFlights(), "User chooses 'Refundable' filter for flights");
		select_alternate_flight();

	}

	@And("^validate that non refundable option for flights is chosen succeffully$")
	
	public void select_non_refundable_flights_filter() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getNonRefundableFlights());
		clickAction(flightPage.getNonRefundableFlights(), "User chooses 'Non Refundable' filter for flights");
		select_alternate_flight();

	}
	
	@And("^validate that more flight options in a flight card is displayed$")
	
	public void view_more_flight_options() throws Throwable {
		
//		view_alternate_flights("International");
		waitForMe(ip.getgotItPopup());
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		waitForMe(flightPage.getMoreFlightOpts());
		clickAction(flightPage.getMoreFlightOpts(), "User chooses '+ more flight options' in a flight card");
	}
	
	@And("^validate that flight is chosen from displayed options$")
	
	public void choose_from_more_flight_options() throws Throwable {
		
		scrollByValue(100);
		Thread.sleep(1000);
		clickAction(flightPage.chooseFlightOption(), "User chooses an option from '+ more flight options' in a flight card");
		Thread.sleep(1000);
		scrollTo(0);
		clickAction(flightPage.replaceWithinSameFlight(), "User clicks on 'Replace' after choosing flight from active flight card");
		
//		waitForMe(flightPage.getflightAddToItineraryButton());
//		clickAction(flightPage.getflightAddToItineraryButton(), "User adds the selected Flight to the itinerary ");

		if (driver.findElements(By.xpath("//button[@class='confirm']")).size() > 0)
		{

			Thread.sleep(5000);
			waitForMe(flightPage.getArrivalDateChanged());
			clickAction(flightPage.getArrivalDateChanged());
			waitForMe(inclusion.getBookNow());
			if(verifyStringNotEquals(getCurrentUrl(), "alternate-flights"))
			{
				//ReporteraddStepLog("Alternate flights has been added in the Inclusions page");
			}
		}
		else
		{
			waitForMe(inclusion.getBookNow());
			if(verifyStringNotEquals(getCurrentUrl(), "alternate-flights"))
			{
				//ReporteraddStepLog("Alternate flights has been added in the Inclusions page");
			}
		}

	}

	@And("^validate that internal flight is changed successfully$")
	
	public void change_internal_flight() throws Throwable {

				view_alternate_flights("Internal");
				select_alternate_flight();

	}
	
	@And("^validate that internal flight provider is changed successfully$")
	
	public void change_internal_flight_provider() throws Throwable {
		
		view_alternate_flights("Internal");
		
		waitForMe(flightPage.changeInternalFlightProvider());
		clickAction(flightPage.changeInternalFlightProvider(), "User changes source provider for internal flights");
		select_alternate_flight();
	}
	
	@And("^validate changing the flight is done$")

	public void validate_the_changing_the_flight() throws Throwable {
		
		if(elementDisplayed(ip.getgotItPopup())) {

			clickAction(ip.getgotItPopup());
		}
		
		select_alternate_flight();

	}
	
	
	@Then("^validate that internal flight section is displaying$")
	public void validate_that_internal_flight_section_is_displaying() throws Throwable {
		validateAssertion(elementDisplayed(flightPage.getInternalFlightAPI()));
		
	    
	}
	

}

