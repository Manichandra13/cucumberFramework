package gluecode;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pyt.pages.FlightsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class BlockCardGlue extends Kernel {

	Actions performAct = new Actions(driver);

	boolean checkinDate = verifyEnabled(blockCard.getCheckInDateOfHotelFromBlockCard());
	boolean checkoutDate = verifyEnabled(blockCard.getCheckOutDateOfHotelFromBlockCard());
	boolean city = verifyEnabled(blockCard.getCityNameHotelBlockCard());

	public int i;
	public int dayNumber;
	public String formattedMonth;
	public String formattedDay;
	public String finalDate;
	public String year;
	public String checkInDate;
	public String checkOutDate;
	public String internalflightDate;

/*	User fills the block card form-
 * Checking the three field (Check in date,Check out date and city name field) 
 * are disabled and if yes, this method will proceed the user to fill the form and if the the provided hotel is not available, 
 * user should enter the TA rating and star rating 
*/
	@Then("^user adds the hotel custom card \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_adds_the_hotel_custom_card_with_DB_hotel(String hotelName, String provider, String reason,
			String roomName, String internetCost) {
		try {

			if (checkinDate == false && checkoutDate == false && city == false) {
				System.out.println("Checkin and checkout and City field got successfully disabled");
				clickAction(blockCard.getHotelNameBlockCard());
				actionTypeText(blockCard.getHotelNameBlockCard(), hotelName);
				Thread.sleep(2000);
				actionsClick(driver, blockCard.getDbHotelFirstElementBlockCard());
				actionTypeText(blockCard.getInternetProviderHotelBlockCard(), provider);
				Thread.sleep(1000);
				performAct.sendKeys(Keys.ENTER).build().perform();
				try {
					if (elementExist(blockCard.getTaRatingHotelBlockCard())
							&& elementExist(blockCard.getStarRatingHotelBlockCard())) {
						typeText(blockCard.getTaRatingHotelBlockCard(), "4.5");
						typeText(blockCard.getStarRatingHotelBlockCard(), "2");
					}
				} catch (Exception e) {

				}
				Thread.sleep(1000);
				clickAction(blockCard.getReasonSectionHotelBlockCard(), "user clicks the reason field in the form");
				actionTypeText(blockCard.getReasonSectionHotelBlockCard(), reason);

				Thread.sleep(1000);
				performAct.sendKeys(Keys.ENTER).build().perform();

				if (elementExist(blockCard.getRoomPanelCloseHotelBlockCard())) {
					clickAction(blockCard.getRoomPanelCloseHotelBlockCard());
					elementDisplayed(blockCard.getRoomPanelOpenHotelBlockCard());
				}

				clickAction(blockCard.getWirelessActiveHotelBlockCard());
				clickAction(blockCard.getBreakFastActiveHotelBlockCard());
				clickAction(blockCard.getRefundableActiveHotelBlockCard());
				clickAction(blockCard.getAcActiveHotelBlock());
				typeText(blockCard.getRoomCategoryHotelBlockCard(), roomName);
				typeText(blockCard.getInternetCostHotelBlockCard(), internetCost);
				clickAction(blockCard.getSaveHotelBlockCard());

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
/*Removing the hotel from the inclusions page -
 * After removal getting the city name from the card and 
 * user opening the custom card form and getting the city name from that form and 
 * Comparing both the city name is same 
 */
	@And("^validate the details and user removes the hotel$")
	public void validate_the_details_and_user_removes_the_hotel() throws Throwable {

		clickAction(hotelPage.getHotel_viewDetails(), "User clicks view hotel");
		clickAction(hotelPage.getHotel_removeHotelButton(), "User removes the hotel");
		String cityName = getText(blockCard.getHotelCityNameAfterRemoved_InclusionCard());
		System.out.println("City name in inclusion" + cityName);
		clickAction(blockCard.getBlockCardHotel());
		String cityNameInBlockcard = getAttribute(blockCard.getCityNameHotelBlockCard(), "value");
		System.out.println("City name in block card" + cityNameInBlockcard);
		boolean assertion = compareTwoStringsPartially(cityNameInBlockcard, cityName);
		System.out.println("validate the city name " + assertion);

	}

/*Checking the block card created successfully in the inclusions page by
 *  verifying  Edit card button existence in the hotel card 
 */
	@Then("^verify the block card posted successfully for hotel$")
	public void verify_the_block_card_posted_successfully_for_hotel() throws Throwable {
		validateAssertion(elementExist(blockCard.getEditCardButtonHotelBlockCard()));

	}
	
/*Removing the block card for hotel and verifying its removed successfully by existence of Add button in the card*/
	@Then("^remove the block card and verify it$")
	public void reomve_the_block_card_and_verify_it() throws Throwable {
		scrolltoElement(hotelPage.getHotel_viewDetails());
		clickAction(hotelPage.getHotel_viewDetails(), "User clicks view hotel");
		clickAction(hotelPage.getHotel_removeHotelButton(), "User removes the Block card for hotel");
		validateAssertion(elementExist(hotelPage.getHotel_addHotelButton()));
	}

/*Scroll to the other custom card button,user fills the other custom card and submitting the form*/
	public void othersBlockCard(String title, String source, String ourCost, String publishedCost, String reason) {

		try {
			scrolltoElement(blockCard.getOthersBlockCard());
			// pollingWait(blockCard.getOthersBlockCard());
			Thread.sleep(500);
			clickAction(blockCard.getOthersBlockCard(), "user clicks the add other custom button ");
			typeText(blockCard.getTitleFieldOtherBlockCard(), title);
			typeText(blockCard.getSourceFieldOtherBlockCard(), source);
			actionTypeText(blockCard.getDescFieldOtherBlockCard(),
					"A good example of a descriptive essay is an essay about 'my best teacher. ' In such as essay, in the introduction you should share a memory about the teacher that makes you adore him/her. From that, the reader would be able to ask themselves more about the described person, and tdecimalFormaterDay would anticipate for the body");
			typeText(blockCard.getCostFieldOtherBlockCard(), ourCost);
			typeText(blockCard.getPublishedCostFieldOtherBlockCard(), publishedCost);
			clickAction(blockCard.getReasonFieldOtherBlockCard(), "user clicks the reason field in the form");
			actionTypeText(blockCard.getReasonFieldOtherBlockCard(), reason);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();
			clickAction(blockCard.getSaveHotelBlockCard());

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


	@Then("^fill and post the other block cards form\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_and_post_the_other_block_cards_form(String title, String source, String ourCost,
			String publishedCost, String reason) throws Throwable {

		othersBlockCard(title, source, ourCost, publishedCost, reason);

	}

	/*Validating the other custom card form submitted successfully*/	
	@Then("^validate the other block card posted successfully$")
	public void validate_the_other_block_card_posted_successfully() throws Throwable {
		scrolltoElement(blockCard.getEditCardButtonOtherBlockCard());
		validateAssertion(elementExist(blockCard.getEditCardButtonOtherBlockCard()));

	}

/* Deleting the other block card in the inclusions page */
	@Then("^delete the other custom card and verify it$")
	public void delete_the_other_custom_card_and_verify_it() throws Throwable {
		clickAction(blockCard.getDeleteButtonOtherBlockCard());
		elementNotExist(blockCard.getEditCardButtonOtherBlockCard());
	}

	/*Checking the maximum possiblity of posting the other block card for one itinerary- 
	 * Admin not allowed to add more than 10 custom other card in single itinerary,
	 *  expected result is add custom card button should be disabled  */
	@Then("^fill and post the other block cards form for ten times \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_and_post_the_other_block_cards_form_for_ten_times(String title, String source, String ourCost,
			String publishedCost, String reason) throws Throwable {

		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			othersBlockCard(title, source, ourCost, publishedCost, reason);
		}

		validateAssertion(elementDisplayed(blockCard.getOtherBlockCardDisabled()));

	}
   /*Getting the checkin date from the inclusions page card and formatting the date based on the flight block card input date type
    *  because flight block card is based on 1st hotel checkin date and last hotel checkout date */
	@Then("^get the date checkin and format the date$")
	public void get_the_date_and_format_the_date() throws Throwable {
		String tripOneDateWeek = getText(blockCard.getHotelCheckinDateInclusionFlightBlockCard());
		System.out.println(tripOneDateWeek);
		String tripOneDate[] = tripOneDateWeek.split(",");
		System.out.println("===========" + tripOneDate.length);
		System.out.println(tripOneDate[0] + "==" + tripOneDate[1]);
		String date = tripOneDate[1];
		checkInDate = dateFormat(date);
		System.out.println(finalDate);

	}
	/*Getting the checkout date from the inclusions page card and formatting the date based on the flight block card input date type
	 *because flight block card is based on 1st hotel checkin date and last hotel checkout date */
	@Then("^get the date checkout and format the date$")
	public void get_the_date_checkout_and_format_the_date() throws Throwable {

		List<WebElement> cardList = driver.findElements(By.xpath("//div[@name='all-hotel-panels']/div/section"));
		String TripTwoDateWeek = driver
				.findElement(By.xpath(
						"(//div[@name='all-hotel-panels']/div/section[" + cardList.size() + "]//*/child::span)[3]"))
				.getText();

		String tripTwoDate[] = TripTwoDateWeek.split(",");
		System.out.println("===========" + tripTwoDate.length);
		System.out.println(tripTwoDate[0] + "==" + tripTwoDate[1]);
		String date = tripTwoDate[1];
		checkOutDate = dateFormat(date);
		System.out.println(finalDate);

	}

	/*User fills the international flight block card form and submitting the form*/
	@Then("^fill the details of the flight block card for the international flight-round trip \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void fill_the_details_of_the_flight_block_card_for_the_international_flight_round_trip(
			String departureCityRoute1, String arrivalCityRoute1, String departureCityRoute2, String arrivalCityRoute2)
			throws Throwable {
		System.out.println(getCurrentUrl());
		clickAction(flightPage.getFlightViewDetails());
		Thread.sleep(700);
		clickAction(hotelPage.getHotel_removeHotelButton());
		clickAction(blockCard.getBlockCardFlightInternational());
		clickAction(blockCard.getRoundTripFlightBlockCard());
		defultValueFlightBlockCard();
		routeFlight(0, departureCityRoute1, arrivalCityRoute1, departureCityRoute2, arrivalCityRoute2);
		routeFlight(1, departureCityRoute1, arrivalCityRoute1, departureCityRoute2, arrivalCityRoute2);
		clickAction(blockCard.getSaveHotelBlockCard());

	}
	
  /* Validating the flight block card is posted successfully*/
	@Then("^check the flight block card posted successfully$")
	public void check_the_flight_block_card_posted_successfully() throws Throwable {
		validateAssertion(elementDisplayed(blockCard.getEditCardButtonFlightBlockCard()));
	}

	/*Using decimal formatter to return the double digit number to use in the month field*/
	public void decimalFormaterDay(String day, int i) {
		DecimalFormat formatter = new DecimalFormat("00");
		formattedMonth = formatter.format(i);
		dayNumber = Integer.parseInt(day);
		formattedDay = formatter.format(dayNumber);
		year = getYear();
		finalDate = year + "-" + formattedMonth + "-" + formattedDay;

	}
	
	/*Date formatter based on flight departure and arrival date input field in flight block card*/
	public String dateFormat(String str) {
		String temp[] = str.split(" ");
		String day = temp[1];
		System.out.println(day);
		String month = temp[2];
		System.out.println(month);

		switch (month) {
		case "Jan":

			i = 1;
			decimalFormaterDay(day, i);
			break;

		case "Feb":

			i = 2;
			decimalFormaterDay(day, i);
			break;

		case "Mar":

			i = 3;
			decimalFormaterDay(day, i);
			break;

		case "Apr":

			i = 4;
			decimalFormaterDay(day, i);
			break;

		case "May":

			i = 5;
			decimalFormaterDay(day, i);
			break;

		case "Jun":

			i = 6;
			decimalFormaterDay(day, i);
			break;

		case "Jul":

			i = 7;
			decimalFormaterDay(day, i);
			break;

		case "Aug":

			i = 8;
			decimalFormaterDay(day, i);
			break;

		case "Sep":

			i = 9;
			decimalFormaterDay(day, i);
			break;

		case "Oct":

			i = 10;
			decimalFormaterDay(day, i);
			break;

		case "Nov":

			i = 11;
			decimalFormaterDay(day, i);
			break;

		case "Dec":

			i = 12;
			decimalFormaterDay(day, i);
			break;

		default:
			System.out.println("Invalid month");

		}
		return finalDate;

	}

	public String getYear() {
		String year = "2020";
		return year;
	}

	/*This method will take the route no and departure and arrival city from the flight block card scenario and fills the form*/
	public void routeFlighBlock(int routeNo, String departureCity, String arrivalCity) {
		try {
			clickAction(blockCard.getAirlineCodeFlightBlockCard().get(routeNo));
			actionTypeText(blockCard.getAirlineCodeFlightBlockCard().get(routeNo), "Blue Air");
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();

			actionTypeText(blockCard.getFlightNumberBlockCard().get(routeNo), "402");
			clickAction(blockCard.getDepartureCityFlightBlockCard().get(routeNo));
			actionTypeText(blockCard.getDepartureCityFlightBlockCard().get(routeNo), departureCity);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();

			clickAction(blockCard.getArrivalCityFlightBlockCard().get(routeNo));
			actionTypeText(blockCard.getArrivalCityFlightBlockCard().get(routeNo), arrivalCity);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();

			scrolltoElement(blockCard.getDepartureTimeFlightBlockCard().get(routeNo));
			blockCard.getDepartureTimeFlightBlockCard().get(routeNo).click();
			actionTypeText(blockCard.getTimeFlightBlockCard(), "01:11");
			driver.findElement(By.xpath("//div[@class='inner-content']")).click();

			Thread.sleep(500);
			scrolltoElement(blockCard.getArrivalTimeFlightBlockCard().get(routeNo));
			blockCard.getArrivalTimeFlightBlockCard().get(routeNo).click();
			actionTypeText(blockCard.getTimeFlightBlockCard(), "20:11");
			driver.findElement(By.xpath("//div[@class='inner-content']")).click();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
	
  /* Flight block card internal one way - this method have the use of filling the one way flight form for block card*/
	public void oneWayInternalFlight(int routeNo, String flightType) throws InterruptedException {
		routeFlighBlock(routeNo, "prague", "paris");
		if (flightType == "internal") {
			actionTypeText(blockCard.getDepartureDateFlightBlockCard().get(routeNo), internalflightDate);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();
			actionTypeText(blockCard.getArrivalDateFlightBlockCard().get(routeNo), internalflightDate);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();
		}
	}

	/*User fills the block card form for more than one route */
	public void routeFlight(int routeNo, String departureCityRoute1, String arrivalCityRoute1,
			String departureCityRoute2, String arrivalCityRoute2) throws InterruptedException {
		int routeNum = blockCard.getRouteCardBlockCard().size();
		System.out.println(routeNum);

		if (routeNum == 2 && routeNo == 0) {
			routeFlighBlock(routeNo, departureCityRoute1, arrivalCityRoute1);
			actionTypeText(blockCard.getDepartureDateFlightBlockCard().get(routeNo), checkInDate);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();
			actionTypeText(blockCard.getArrivalDateFlightBlockCard().get(routeNo), checkInDate);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();

		} else if (routeNum == 2 && routeNo == 1) {
			routeFlighBlock(routeNo, departureCityRoute2, arrivalCityRoute2);
			actionTypeText(blockCard.getDepartureDateFlightBlockCard().get(routeNo), checkOutDate);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();
			actionTypeText(blockCard.getArrivalDateFlightBlockCard().get(routeNo), checkOutDate);
			Thread.sleep(500);
			performAct.sendKeys(Keys.ENTER).build().perform();
		}

	}

	public void multiRoute(String routeType) throws InterruptedException {
		int routeNum = blockCard.getRouteCardBlockCard().size();
		System.out.println(routeNum);
		if (routeType == "multi" && routeNum == 4) {
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					routeFlighBlock(i, "chennai", "wanaka");
				} else if (i == 1) {
					routeFlighBlock(i, "wanaka", "Penang");
				}
				actionTypeText(blockCard.getDepartureDateFlightBlockCard().get(i), checkInDate);
				Thread.sleep(500);
				performAct.sendKeys(Keys.ENTER).build().perform();
				actionTypeText(blockCard.getArrivalDateFlightBlockCard().get(i), checkInDate);
				Thread.sleep(500);
				performAct.sendKeys(Keys.ENTER).build().perform();
			}

			for (int i = 2; i <= 3; i++) {
				if (i == 2) {
					routeFlighBlock(i, "penang", "wanaka");
				} else if (i == 3) {
					routeFlighBlock(i, "wanaka", "chennai");
				}
				actionTypeText(blockCard.getDepartureDateFlightBlockCard().get(i), checkOutDate);
				Thread.sleep(500);
				performAct.sendKeys(Keys.ENTER).build().perform();
				actionTypeText(blockCard.getArrivalDateFlightBlockCard().get(i), checkOutDate);
				Thread.sleep(500);
				performAct.sendKeys(Keys.ENTER).build().perform();
			}
		}

	}

	public void defultValueFlightBlockCard() {
		try {
			typeText(blockCard.getInternetCostFlightBlockCard(), "40000");
			clickAction(blockCard.getFlightBlockCardInternerSource());
			actionTypeText(blockCard.getFlightBlockCardInternerSource(),"Tbo");
			Thread.sleep(700);
			performAct.sendKeys(Keys.ENTER).build().perform();

			clickAction(blockCard.getReasonForFlightBlockCard(), "user clicks the reason field in the form");
			actionTypeText(blockCard.getReasonForFlightBlockCard(), "Not available on our product");
			Thread.sleep(2000);
			performAct.sendKeys(Keys.ENTER).build().perform();

			scrolltoElement(blockCard.getBaggageFlightBlockCard().get(0));
			typeText(blockCard.getBaggageFlightBlockCard().get(0), "3");
			typeText(blockCard.getBaggageFlightBlockCard().get(1), "3");
			typeText(blockCard.getBaggageFlightBlockCard().get(2), "3");
			typeText(blockCard.getBaggageFlightBlockCard().get(3), "3");
			driver.findElement(By.xpath("//div[@class='inner-content']")).click();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Then("^fill the details of the flight block card for the internal flight-one way$")
	public void fill_the_details_of_the_flight_block_card_for_the_internal_flight_one_way() throws Throwable {
		try {
			clickAction(flightPage.getInternalFlightViewDetails());
			Thread.sleep(700);
			clickAction(hotelPage.getHotel_removeHotelButton());
			clickAction(blockCard.getBlockCardFlightInternal());
			defultValueFlightBlockCard();
			oneWayInternalFlight(0, "internal");
			clickAction(blockCard.getSaveHotelBlockCard());
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("^get the internal date and format the date$")
	public void get_the_internal_date_and_format_the_date() throws Throwable {
		String internalFlightDeparture = getText(blockCard.getInternalFlightDepartureDate());
		System.out.println(internalFlightDeparture);
		String internalFlightDepartureDate[] = internalFlightDeparture.split(",");
		System.out.println("===========" + internalFlightDepartureDate.length);
		System.out.println(internalFlightDepartureDate[0] + "==" + internalFlightDepartureDate[1]);
		String date = internalFlightDepartureDate[1];
		internalflightDate = dateFormat(date);
		System.out.println(finalDate);
	}

	@Then("^remove the block car and verify removed successfully$")
	public void remove_the_block_card() throws Throwable {
		clickAction(flightPage.getFlightViewDetails());
		clickAction(hotelPage.getHotel_removeHotelButton());
		validateAssertion(elementDisplayed(flightPage.getInternationalFlightAddButton()));

	}

	@Then("^remove the block card for internal flight and verify removed successfully$")
	public void remove_the_block_card_for_internal_flight_and_verify_removed_successfully() throws Throwable {
		clickAction(flightPage.getInternalFlightViewDetails());
		clickAction(hotelPage.getHotel_removeHotelButton());
		validateAssertion(elementDisplayed(flightPage.getInternalFlightAddButton()));
	}

	@Then("^fill the details of the flight block card for the international flight-round trip with multiple route$")
	public void fill_the_details_of_the_flight_block_card_for_the_international_flight_round_trip_with_multiple_route()
			throws Throwable {
		System.out.println(getCurrentUrl());
		clickAction(flightPage.getFlightViewDetails());
		Thread.sleep(700);
		clickAction(hotelPage.getHotel_removeHotelButton());
		clickAction(blockCard.getBlockCardFlightInternational());
		clickAction(blockCard.getRoundTripFlightBlockCard());
		clickAction(blockCard.getAddRouteFlightBlockCard().get(0));
		clickAction(blockCard.getAddRouteFlightBlockCard().get(1));

		defultValueFlightBlockCard();

		multiRoute("multi");
		clickAction(blockCard.getSaveHotelBlockCard());

	}

	@Then("^click add button in international flight$")
	public void click_add_button_in_international_flight() throws Throwable {
		clickAction(flightPage.getInternationalFlightAddButton());

	}

}
