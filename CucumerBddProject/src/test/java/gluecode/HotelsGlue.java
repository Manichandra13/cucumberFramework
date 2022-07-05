package gluecode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class HotelsGlue extends Kernel {

	public static String beforeRoomChange;
	public static String afterRoomChange;

	@Then("^user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary$")
	public void user_validates_the_hotels_count() throws Throwable {

		// ReporteraddScenarioLog("user validates the costing flow for : " + region);
		// driver.navigate().to("https://staging.pickyourtrail.com");
		System.out.println("Header hotels : " + getText(inclusion.getHotelTabInclusions()));

		// No of hotel cards in the itinerary
		List<WebElement> eles = driver
				.findElements(By.xpath("//div[@name='all-hotel-panels']//section[contains(@class,'inclusion-box')]"));
		Integer result = eles.size();
		System.out.println("Hotel Cards :" + result.toString());
		validate_String_Contains(getText(inclusion.getHotelTabInclusions()), result.toString());

		// ReporteraddScenarioLog("No of hotels added in this itinerary is : " +
		// result);

	}

	@Then("^user views the details of the hotel$")
	public void user_views_existing_hotel() throws Throwable {

		clickAction(hotelPage.getHotel_viewDetails(), "User clicks view hotel");

	}

	@Then("^user removes the hotel and confirms$")
	public void user_removes_the_existing_hotel_and_validates_the_alert_message_for_removal() throws Throwable {

		clickAction(hotelPage.getHotel_removeHotelButton(), "User removes the hotel");

	}

	@Then("^Validate user will not be allowed to remove an hotel$")
	public void validatee_will_not_be_allowed_to_remove_an_hotel() throws Throwable {
		elementNotExist(hotelPage.getHotel_hotelRemovedMessage());
	}

	@Then("^user Adds an hotel$")
	public void user_adds_hotel() throws Throwable {

		clickAction(hotelPage.getHotel_addHotelButton(), "User adds the hotel");
		clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
		clickAction(hotelPage.gethotel_detailsPageAddToItinneraryButton(), "Adding the hotel in Details page ");
	}

	@Then("^user changes the hotel and select an alternative$")
	public void user_changes_hotel_Select_Alternative() throws Throwable {
		clickAction(hotelPage.gethotel_ChangeHotelButton(), "User changes the hotel");
		clickAction(hotelPage.gethotel_replaceHotelCardAlternate(), "Selecting other hotel");
		clickAction(hotelPage.gethotel_detailsPageAddToItinneraryButton(), "Adding the hotel in Details page ");
	}

	@Then("^user changes the hotel$")
	public void user_changes_hotel() throws Throwable {
		clickAction(hotelPage.gethotel_ChangeHotelButton(), "User changes the hotel");

	}

	@Then("^user applies the pyt smart filters$")
	public void user_artFilter() throws Throwable {

		driver.navigate().refresh();
		Thread.sleep(5000);
		clickAction(hotelPage.getOurPickFilterHotel(), "User clicks the our pick filter");
		// elementDisplayed(hotelPage.getTopRecommendedTagFilterHotel());
		validateAssertion(elementDisplayed(hotelPage.getTopRecommendedTagFilterHotel()));
	}

	@Then("^validates hotel added succesfully$")
	public void validates_hotel_added_succesfully() throws Throwable {
		validateAssertion(elementDisplayed(hotelPage.getChangeHotelInclusion()));
	}

	/** Looping through the i value to get the dynamic web element of star filters and clicking the star filter based on that ,
	 *  validating using "validate_the_filter_applied_successfully" method ---> comparing the hotel pill text and applied filter 
	 *  text if both string equal scenario passed and getting the hotel option count for each filter application and printing it
	 *   */
	@Then("^apply the star filters and validate the filter applied succesfully$")
	public void apply_the_star_filters_and_validate_the_filter_applied_succesfully() throws Throwable {

		
		
		clickAction(hotelPage.getHeaderFilterHotelButton(),
				" User clicks the filter button in the hotel alternate header sticky bar");

		for (int i = 2; i <= 5; i++) {
			WebElement starFilter = driver.findElement(By.xpath("//*[contains(@title,'" + i + " star')]"));
			
			clickAction(starFilter);
			waitForMe(hotelPage.gethotel_replaceHotelCardAlternate(), 10);

			validate_the_filter_applied_successfully("" + i +" star");
			Thread.sleep(2000);

			int HotelOptions = hotelPage.getHotelCardInAlternate().size();
			System.out.println(HotelOptions);

			if (HotelOptions > 0) {
				System.out.println("There are " + HotelOptions + " hotel options available for  " + i + " Star filter");
			} else {
				System.out.println("There is no hotel option available for " + i + " Star filter");
			}

			clickAction(hotelPage.getCloseHotelFilterPill());
			waitForMe(hotelPage.gethotel_replaceHotelCardAlternate(), 10);

		}
	}
	
	/** Looping through the i value to get the dynamic web element of inclusions(free BF,AC,wifi) filters and clicking the star filter based on that ,
	 *  validating using "validate_the_filter_applied_successfully" method ---> comparing the hotel pill text and applied filter 
	 *  text if both string equal scenario passed and getting the hotel option count for each filter application and printing it
	 *   */
	@Then("^apply the inclusions filters in hotel alternate and validate the filter applied successfully$")
	public void apply_the_inclusions_filter_and_validate_the_filter_applied_succesfully() throws Throwable {

		clickAction(hotelPage.getHeaderFilterHotelButton(),
				" User clicks the filter button in the hotel alternate header sticky bar");

		for (int i = 1; i <= 3; i++) {
			// xpath for inclusions filter (BF, AC, wifi filter in hotel alternate)
			WebElement hotelInclusionsFilters = driver.findElement(By.xpath("(//label[@value='" + i + "']//span)[1]"));
			System.out.println("(//label[@value='" + i + "']//span)[1]");

			String filtersName = getText(hotelInclusionsFilters);
			System.out.println(filtersName);
			Thread.sleep(2000);
			clickAction(hotelInclusionsFilters, "user clicks the from the inclusions filter ");
			waitForMe(hotelPage.gethotel_replaceHotelCardAlternate(), 5);

			validate_the_filter_applied_successfully(filtersName);
			Thread.sleep(2000);
			int HotelOptions = hotelPage.getHotelCardInAlternate().size();
			System.out.println(HotelOptions);
			if (HotelOptions > 0) {
				System.out.println(
						"There are " + HotelOptions + " hotel options available for " + filtersName + " filter");
			} else {
				System.out.println("There is no hotel option available for " + filtersName + " filter");
			}
			clickAction(hotelPage.getCloseHotelFilterPill());
			waitForMe(hotelPage.gethotel_replaceHotelCardAlternate(), 5);

		}
	}

	/** Applying refundable filter and validating using refundable icon on the card and applying non refundable 
	 * filter and validating using non refundable icon in the hotel card  */
	@Then("^apply the refundable filter in map view and validate the filter applied succesfully$")
	public void apply_the_refundable_filter_in_map_view_and_validate_the_filter_applied_succesfully() throws Throwable {

		clickAction(hotelPage.getHeaderFilterHotelButton(),
				" User clicks the filter button in the hotel alternate header sticky bar");
		clickAction(hotelPage.getRefundableFilterMapHotel(),
				"User clicks the refundable filter in map view of hotel alternate page ");
		pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
		validate_the_filter_applied_successfully("Refundable");
		validateAssertion(elementExist(hotelPage.getRefundableHotelCardIcon()));
		clickAction(hotelPage.getCloseHotelFilterPill());
		pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
		clickAction(hotelPage.getNonRefundableFilterMapHotel(),
				"User clicks the non refundable filter in map view of hotel alternate page ");
		pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
		validate_the_filter_applied_successfully("Non Refundable");
		validateAssertion(elementExist(hotelPage.getNonRefundableHotelCardIcon()));
	}

	
	/** Looping through the i value to get the dynamic web element of type filters and clicking the star filter based on that ,
	 *  validating using "validate_the_filter_applied_successfully" method ---> comparing the hotel pill text and applied filter 
	 *  text if both string equal scenario passed and getting the hotel option count for each filter application and printing it
	 *   */
	@Then("^apply the hotel filter in map view and validate the filter applied succesfully$")
	public void apply_the_hotel_filter_in_map_view_and_validate_the_filter_applied_succesfully() throws Throwable {

		try {

			clickAction(hotelPage.getHeaderFilterHotelButton(),
					" User clicks the filter button in the hotel alternate header sticky bar");

			for (int i = 1; i <= 6; i++) {
				// xpath for hotel type filter (Hotel, budget, apartment, villa, unique
				// stay,private pool villa filter in hotel alternate)
				WebElement hotelTypeFilters = driver
						.findElement(By.xpath("//label[@value='" + i + "' and @name='hotel-type']"));

				System.out.println("//label[@value='" + i + "' and @name='hotel-type']");

				String filtersName = getText(hotelTypeFilters);
				System.out.println(filtersName);
				Thread.sleep(2000);

				clickAction(hotelTypeFilters, "user clicks the from the inclusions filter ");

				try {

					pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
				} catch (Exception e) {

					System.out.println("No filter option available for " + filtersName + " option ");
				}

				validate_the_filter_applied_successfully(filtersName);
				Thread.sleep(2000);
				int HotelOptions = hotelPage.getHotelCardInAlternate().size();
				System.out.println(HotelOptions);
				if (HotelOptions > 0) {
					System.out.println(
							"There are " + HotelOptions + " hotel options available for " + filtersName + " filter");
				} else {
					System.out.println("There is no hotel option available for " + filtersName + " filter");
				}
				clickAction(hotelPage.getCloseHotelFilterPill());
				try {

					pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
				} catch (Exception e) {

					System.out.println("No hotel available when you deselect the " + filtersName + " filter ");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^user change the room$")
	public void user_change_the_room() throws Throwable {
		clickAction(hotelPage.getRetainRoomOptionHotelDetails(),
				"User clicks the retain the room option in the hotel details page");
		beforeRoomChange = getText(hotelPage.getFirstRoomNameNoExpandViewHotel());
		clickAction(hotelPage.getChooseMoreOptionHotelDetails(),
				"User clicks the choose more room option in the hotel details page");
		clickAction(hotelPage.getSelectRoomButtonHotelDetails(), "User change the room ");
		afterRoomChange = getText(hotelPage.getFirstRoomNameNoExpandViewHotel());

	}

	@Then("^validate the room changed successfully$")
	public void validate_the_room_changed_successfully() throws Throwable {
		Assert.assertTrue(!beforeRoomChange.equalsIgnoreCase(afterRoomChange));
		compareTwoWebElements(hotelPage.getFirstRoomNameNoExpandViewHotel(),
				hotelPage.getFirstRoomNameSideCardHotelDetails());
	}

	@Then("^apply the exclusive filter and validate the filter applied succesfully$")
	public void apply_the_exclusive_filter_and_validate_the_filter_applied_succesfully() throws Throwable {

		clickAction(hotelPage.getPytExclusiveToggle());

		try {
//			validateAssertion(elementDisplayed(hotelPage.getPytExclusiveTagHotelCard()));
			pollingWait(hotelPage.getPytExclusiveTagHotelCard(),10);
		} catch (Exception e) {
			System.out.println("No hotel options available for exclusive filter");
		}

	}

	
	@Then("^apply sorting and validate the sort applied successfully$")
	public void apply_sorting_and_validate_the_sort_applied_successfully() throws Throwable {

		clickAction(hotelPage.getHeaderSortHotelButton());
		validateAssertion(elementExist(hotelPage.getHotel_replaceHotelCardAlternate()));
		clickAction(hotelPage.getRatingSortingHotel());
		pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
		validateAssertion(elementExist(hotelPage.getHotel_replaceHotelCardAlternate()));
		clickAction(hotelPage.getPriceSortingHotel());
		pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 10);
		validateAssertion(elementExist(hotelPage.getHotel_replaceHotelCardAlternate()));
		clickAction(hotelPage.getHeaderSortHotelButton());

	}

	@Then("^check hotel options available in the alternate$")
	public void check_hotel_options_available_in_the_alternate() throws Throwable {
		try {

			scrolltoElement(hotelPage.getChangeHotelInclusion());
			clickAction(hotelPage.getChangeHotelInclusion(),
					"User click the change button in the hotel card in inclusions page ");
			try {

				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 20);

			} catch (Exception e) {

				System.out.println("No hotel option available! ");
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("^apply source provider filter and validate the appropriate source provider selected$")
	public void apply_source_provider_filter_and_validate_the_appropriate_source_provider_selected() throws Throwable {
		try {

			validate_the_filter_applied_successfully("AGODA");
			Thread.sleep(5000);
			clickJavaScriptElement(hotelPage.getHeaderSourceProviderHotelButton());
			clickAction(hotelPage.getExpediaHotelFilter());
			try {
				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 5);
				hoverWebelement(hotelPage.getHotel_replaceHotelCardAlternate());
				validateAssertion(elementDisplayed(hotelPage.getOnTripAdvisorHotelIcon()));

			} catch (Exception e) {

				System.out.println("No Expedia hotel option available! ");

			}

			Thread.sleep(5000);
			clickAction(hotelPage.getAgodaHotelFilter());
			try {
				pollingWait(hotelPage.gethotel_replaceHotelCardAlternate(), 5);
				hoverWebelement(hotelPage.getHotel_replaceHotelCardAlternate());
				validateAssertion(elementDisplayed(hotelPage.getOnAgodaHotelIcon()));

			} catch (Exception e) {

				System.out.println("No Agoda hotel option available! ");

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
