package gluecode;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class EditRouteGlue extends Kernel {


	String editrouteFirstCity;



	/*Remove the first city in edit route modal and validate that the first city
    is removed from your route modal and from the itinerary card */


	@Then("^Click on customize option and validate if the city is removed or not$")
	public boolean remove_city() throws Throwable {

		String cityName = "";
		String beforeDeleteYourRoute;
		String beforeDeleteItnCard;
		String afterDeleteYourRoute;
		String afterDeleteItnCard;
        boolean actualResult = false;
        beforeDeleteYourRoute = getText(ed.getFirstCityInYourRoute());
		beforeDeleteItnCard =  getText(ed.getFirstCityInItnCard());
		clickAction(ed.getEditRouteCustomize());

		// cityName = getText(ed.getFirstCityInEditRoute()); //City Name in the first card of the edit route modal
		//System.out.println(cityName);

		if(elementDisplayed(ed.getDelete())) {
			clickAction(ed.getDelete());
		}

		clickAction(ed.getUpdateItinerary());

		Thread.sleep(2000);      //Wait until the next city is updated in the itinerary page

		afterDeleteYourRoute= getText(ed.getFirstCityInYourRoute());
		afterDeleteItnCard =  getText(ed.getFirstCityInItnCard());

		if( beforeDeleteYourRoute !=  afterDeleteYourRoute ) /*Verify before deleting the city from your route modal is not same as after deletion
			the city*/
		{
			if( beforeDeleteItnCard != afterDeleteItnCard ) /*Verify before deleting the city in the Itinerary card is not same as after deletion
			the city*/
			{
				System.out.println("pass");
				actualResult = true;
			}
		}
		return actualResult;
	}


	/*Add the first city in edit route modal and validate that the first city
    is added into your route modal and the itinerary card */

	@Then("^Click on customize option and validate if the city is added or not$")
	public boolean  add_city() throws Throwable {
		boolean actualResult = false;
		String  alternateCity;
		String editRouteAlternateCity;
		String yourRouteAlternateCity;
		String itnRowAlternateCity;

		clickAction(ed.getEditRouteCustomize());

		clickAction(ed.getAddCityInEditRoute());

		alternateCity =	getAttribute(ed.getAddAlternateCity(), "alt");

		clickAction(ed.getAddAlternateCity());

		Thread.sleep(2000);

		editRouteAlternateCity = getText(ed.getFirstCityInEditRoute());

		if( alternateCity.equals(editRouteAlternateCity)) 		//Validate that the added city is showing in edit route modal

		{
			clickAction(ed.getUpdateItinerary());

			Thread.sleep(2000);

			yourRouteAlternateCity =	getText(ed.getFirstCityInYourRoute());

			if( alternateCity.equals(yourRouteAlternateCity)) //Validate that the added city is showing in Your route modal
			{
				itnRowAlternateCity = getText(ed.getFirstCityInItnCard());
	            if( alternateCity.equals(itnRowAlternateCity)) //Validate that the added city is showing in Itinerary row
				{
					actualResult = true;
				}
			}
		}

		return actualResult;
	}

	/*Replace the city from edit route modal and validate that the replaced city is shown in
	 edit route modal,Your route and the itinerary card */

	@Then("^Click on customize option and validate if the city is replaced by another city or not$")
	public boolean replace_City() throws Throwable {

		boolean actualResult = false;
		String  alternateCity;
		String editRouteAlternateCity;
		String yourRouteAlternateCity;
		String itnRowAlternateCity;

        clickAction(ed.getEditRouteCustomize());
		clickAction(ed.getReplaceCity());

		alternateCity =	getAttribute(ed.getAddAlternateCity(), "alt");

		clickAction(ed.getAddAlternateCity());

		Thread.sleep(2000);
		editRouteAlternateCity = getText(ed.getFirstCityInEditRoute());

		if( alternateCity.equals(editRouteAlternateCity)) //Validate if the replaced city is showing in edit route modal
		{
			clickAction(ed.getUpdateItinerary());
			Thread.sleep(2000);
			yourRouteAlternateCity =	getText(ed.getFirstCityInYourRoute());

			if( alternateCity.equals(yourRouteAlternateCity)) //Validate  if the replaced city is showing in Your route modal
			{
				itnRowAlternateCity = getText(ed.getFirstCityInItnCard());

				if( alternateCity.equals(itnRowAlternateCity)) //Validate if the replaced city is showing in Itinerary row
				{
					actualResult = true;
				}
			}
		}

		return actualResult;
	}



	/* Add a night in edit route modal and validate that the same night is added into your route
	 modal and the itinerary card */

	@Then("^Click on customize option and validate if the night is added or not$")
	public boolean add_Night() throws Throwable {

		boolean actualResult = false;
		String beforeAddNightsCount;
		String afterAddNightsCount;



		clickAction(ed.getEditRouteCustomize());

		beforeAddNightsCount = getText(ed.getCountOfNights());
		System.out.println(beforeAddNightsCount);

		if(verifyEnabled(ed.getAddNight()))
		{
			clickAction(ed.getAddNight());

			afterAddNightsCount = getText(ed.getCountOfNights());
			System.out.println(afterAddNightsCount);

			if(beforeAddNightsCount != afterAddNightsCount) {
				clickAction(ed.getUpdateItinerary());
				Thread.sleep(2000);
				hoverWebelement(ed.getCountOfNightsInYourRoute());

				if(afterAddNightsCount.equals(getText(ed.getCountOfNightsInYourRoute()))) {
					if(afterAddNightsCount.equals(getText(ed.getCountOfNightsInItnCard()))) {
						actualResult = true;
					}
				}
			}

		}
		return actualResult;
	}



	/* Remove a night in edit route modal and validate that the same night is removed from your route
	modal and the itinerary card */

	@Then("^Click on customize option and validate if the night is removed or not$")
	public boolean remove_Night() throws Throwable {

		boolean actualResult = false;

		String beforeRemovalNightsCount;
		String afterRemovalNightsCount;


		clickAction(ed.getEditRouteCustomize());

		beforeRemovalNightsCount = getText(ed.getCountOfNights());
		System.out.println(beforeRemovalNightsCount);

		if(verifyEnabled(ed.getRemoveNight()))
		{
			clickAction(ed.getRemoveNight());

			afterRemovalNightsCount = getText(ed.getCountOfNights());
			System.out.println(afterRemovalNightsCount);

			if(beforeRemovalNightsCount != afterRemovalNightsCount) {
				clickAction(ed.getUpdateItinerary());
				Thread.sleep(2000);
				hoverWebelement(ed.getCountOfNightsInYourRoute());

				if(afterRemovalNightsCount.equals(getText(ed.getCountOfNightsInYourRoute()))) {
					if(afterRemovalNightsCount.equals(getText(ed.getCountOfNightsInItnCard()))) {
						actualResult = true;
					}
				}
			}

		}
		return actualResult;


	}





}
































