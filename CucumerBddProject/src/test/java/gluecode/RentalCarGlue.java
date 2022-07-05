package gluecode;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class RentalCarGlue extends Kernel{
	
	@And("^user click on transfer tab$")
	public void user_click_on_transfer_tab() throws Throwable {
	    
		
		scrolltoElement(rentalCarPage.getTranferButton());
		clickJavaScriptElement(rentalCarPage.getTranferButton());
		waitForMe(rentalCarPage.getRentalCarCardInAlternatePage());
		validate_String_Contains(getCurrentUrl(),"alternate-rental-cars/");
		
	   
	}

	@And("^change the rental car$")
	public void change_the_rental_car() throws Throwable {
		
		waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
		if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
			
	   hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
	   clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
		}
		else if(elementExist(rentalCarPage.getAlertCardIfNetworkFailedRentalCar())) {
			//ReporteraddStepLog("Something issue with loading rental car alternate page alert message is poping up...");
			clickAction(rentalCarPage.getOkButtonInAlertCard(),"User clicks the Ok button in the alert");
		}
		else {
			//ReporteraddStepLog("There is no alternate rental car in the itinerary");
		}
	}

	@Then("^validate the rental car changed succesfully$")
	public void validate_the_rental_car_changed_succesfully() throws Throwable {
	    pollingWait(rentalCarPage.getTranferButton(),60);
	    assertFalse(getCurrentUrl().contains("alternate-rental-cars/"), "Rental Car not changed");
	}

	@Then("^user change the insurance and validate the insurance applied successfully$")
	public void user_change_the_insurance_and_validate_the_insurance_applied_successfully() throws Throwable {
		
	  scrolltoElement(inclusion.getInsuranceChangeLinkInRentalCar());
	  clickJavaScriptElement(inclusion.getInsuranceChangeLinkInRentalCar());
	  validate_String_Contains(getCurrentUrl(),"change-rc-insurance/");
	  clickAction(rentalCarPage.getTotalProtectionPackageRentalCar(),"User selecting the Accident Damage Excess insurance type");
	  clickAction(rentalCarPage.getApplyButtonInChangeInsuranceModal(),"User clicks the selected insurance type to apply in the itinerary");
	  validate_String_Contains(getCurrentUrl(),"inclusions/");
	}
	
	@Then("^apply economy filter and validate the filter applied successfully$")
	public void apply_economy_filter_and_validate_the_filter_applied_successfully() throws InterruptedException {
		
		try {
			clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
			if(elementExist(rentalCarPage.getEconomyFilterRentalCar())) {
				clickAction(rentalCarPage.getEconomyFilterRentalCar(),"User clicks on the Economy filter");
				waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
				if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
					rentalCarFilterValidation("Economy");
					hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
					 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
					 validate_String_Contains(getCurrentUrl(),"inclusions/");
				}
				else {
					//ReporteraddStepLog("There is no result for the selected filter");
					clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
					validate_String_Contains(getCurrentUrl(),"inclusions/");
				}
				}
			
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}
	   	}
	@Then("^apply compact filter and validate the filter applied successfully$")
	public void apply_compact_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getCompactFilterRentalCar())) {
			System.out.println();
			clickAction(rentalCarPage.getCompactFilterRentalCar(),"User clicks on the Compact filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("Compact");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
		   //ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}
	}

	@Then("^apply value standard filter and validate the filter applied successfully$")
	public void apply_value_standard_filter_and_validate_the_filter_applied_successfully() throws Throwable {
	   try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getValueStandardFilterRentalCar())) {
			clickAction(rentalCarPage.getValueStandardFilterRentalCar(),"User clicks on the value standard filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("Value standard");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
	   }
	  catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}
	}

	@Then("^apply standard filter and validate the filter applied successfully$")
	public void apply_standard_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getStandardFilterRentalCar())) {
			clickAction(rentalCarPage.getStandardFilterRentalCar(),"User clicks on the standard filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("Standard");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}
	}

	@Then("^apply value suv \\(awd\\) filter and validate the filter applied successfully$")
	public void apply_value_suv_awd_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getValueSuvAwdFilterRentalCar())) {
			clickAction(rentalCarPage.getValueSuvAwdFilterRentalCar(),"User clicks on the value suv awd filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("Value");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}
	}

	@Then("^apply executive filter and validate the filter applied successfully$")
	public void apply_executive_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getExecutiveFilterRentalCar())) {
			clickAction(rentalCarPage.getExecutiveFilterRentalCar(),"User clicks on the executive filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("Executive");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}
	}

	@Then("^apply suv filter and validate the filter applied successfully$")
	public void apply_suv_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getSuvFilterRentalCar())) {
			clickAction(rentalCarPage.getSuvFilterRentalCar(),"User clicks on the SUV filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("SUV");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		} 
	}

	@Then("^apply intermediate filter and validate the filter applied successfully$")
	public void apply_intermediate_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getIntermediateFilterRentalCar())) {
			clickAction(rentalCarPage.getIntermediateFilterRentalCar(),"User clicks on the intermediate 4x4 filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("intermediate 4×4");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		} 
	}

	@Then("^apply large filter and validate the filter applied successfully$")
	public void apply_large_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getLargeFilterRentalCar())) {
			clickAction(rentalCarPage.getLargeFilterRentalCar(),"User clicks on the large 4x4 filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("Large 4x4");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		} 
	}

	@Then("^apply premium filter and validate the filter applied successfully$")
	public void apply_premium_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getPremiumFilterRentalCar())) {
			clickAction(rentalCarPage.getPremiumFilterRentalCar(),"User clicks on the premium 4x4 filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("premium 4x4");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks on the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks on the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		} 
	}

	@Then("^apply seater van filter and validate the filter applied successfully$")
	public void apply_seater_van_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTypecategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getSeaterVanFilterRentalCar())) {
			clickAction(rentalCarPage.getSeaterVanFilterRentalCar(),"User clicks on the 11 seater van filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("11 seater van");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		} 
	}

	@Then("^apply suited for five filter and validate the filter applied successfully$")
	public void apply_suited_for_five_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getSuitedForCategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getSuitedForFiveFilterRentalCar())) {
			clickAction(rentalCarPage.getSuitedForFiveFilterRentalCar(),"User clicks on the suited for 5  filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("5 people");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}  
	}

	@Then("^apply suited for seven filter and validate the filter applied successfully$")
	public void apply_suited_for_seven_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getSuitedForCategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getSuitedForSevenFilterRentalCar())) {
			clickAction(rentalCarPage.getSuitedForSevenFilterRentalCar(),"User clicks on the suited for 7 filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("7 people");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}  
	}

	@Then("^apply suited for eleven filter and validate the filter applied successfully$")
	public void apply_suited_for_eleven_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getSuitedForCategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getSuitedForElevenFilterRentalCar())) {
			clickAction(rentalCarPage.getSuitedForElevenFilterRentalCar(),"User clicks on the suited for 11 filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				rentalCarFilterValidation("11 people");
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}  
	}

	@Then("^apply automatic filter and validate the filter applied successfully$")
	public void apply_automatic_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTransmissionCategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getAutomaticFilterRentalCar())) {
			clickAction(rentalCarPage.getAutomaticFilterRentalCar(),"User clicks on the automatic filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}   
	}

	@Then("^apply air conditioning filter and validate the filter applied successfully$")
	public void apply_air_conditioning_filter_and_validate_the_filter_applied_successfully() throws Throwable {
		try {
		clickAction(rentalCarPage.getTransmissionCategoryFilterRentalCar());
		if(elementExist(rentalCarPage.getAirconditioningFilterRentalCar())) {
			clickAction(rentalCarPage.getAirconditioningFilterRentalCar(),"User clicks on the air conditioning filter");
			waitUntil(rentalCarPage.getRentalCarCardInAlternatePage(),40);
			if(elementExist(rentalCarPage.getRentalCarCardInAlternatePage())) {
				 hoverWebelement(rentalCarPage.getRentalCarCardAlternate());
				 clickAction(rentalCarPage.getReplaceButtonRentalCarAlternate());
				 validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			else {
				//ReporteraddStepLog("There is no result for the selected filter");
				clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
				validate_String_Contains(getCurrentUrl(),"inclusions/");
			}
			}
		}
		catch(NoSuchElementException e) {
			//ReporteraddStepLog("The filter type is not existing");
			clickAction(rentalCarPage.getBackToItineraryRentalCar(),"User Clicks the Back to itinerary in the rental car alternate page ");
			validate_String_Contains(getCurrentUrl(),"inclusions/");
		}   
	}


}
