package gluecode;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pyt.pages.DiscountPricingPage;

import cucumber.api.java.en.Then;
import utils.Kernel;

public class DiscountPricingGlue extends Kernel {

	public static int adminPriceApply;
	public static int lineItemCost;
	public static String internalFlightPrice = "";
	public static String trainPrice = "";
	public static String AHPrice = "";
	public static String rentalCarPrice = "";
	public static String activityPrice = "";
	public static String adminPriceAmount = "";
	public static String overallPrice = "";
	int totalAdminPrice;

	/*
	 * Parameters used all over the class
	 * 
	 * lineitem,category,field,value lineitem means Hotel,flight transfer category
	 * means division part of line item [ eg; Flight -> International , Internal ]
	 * Rate match modal [discount modal] contains fiels and value
	 */

	/*
	 * This function get the total price of a line item and calculate the admin
	 * discount price needs to be applied
	 */

	public int adminPriceCalculation(String lineitem, String category) {

		String totalPrice = null;

		switch (category) {

		case "common": {
			WebElement price = driver.findElement(By.xpath("(//div[@name='" + lineitem + "']//b)[1]"));
			totalPrice = price.getText();
			break;
		}
		case "activity": {
			totalPrice = activityPrice;
			break;
		}
		case "internal": {
			totalPrice = internalFlightPrice;
			break;
		}
		case "train": {
			totalPrice = trainPrice;
			break;
		}
		case "AHtransfer": {
			totalPrice = AHPrice;
			break;
		}
		case "rentalcar": {
			totalPrice = rentalCarPrice;
			break;
		}
		case "price": {
			totalPrice = overallPrice;
			break;

		}
		}
		System.out.println(totalPrice);
		String priceStr = totalPrice.replaceAll("[^\\d]", "");

		int lineItemCost = Integer.parseInt(priceStr.trim());
		System.out.println("lineItemCost--" + lineItemCost);
		int discountPrice = (lineItemCost / 1000) * 1000;
		System.out.println(discountPrice);
		if (category.equals("price")) {

			totalAdminPrice = (int) discountPrice;
			System.out.println("totalAdminPrice--" + totalAdminPrice);
			adminPriceApply = lineItemCost - totalAdminPrice;
			System.out.println(adminPriceApply);

		} else {
			adminPriceApply = (int) discountPrice;
			System.out.println(adminPriceApply);

		}
		System.out.println(adminPriceApply);
		return adminPriceApply;

	}

	// This function is to verify and validate edit icon for hotel line item

	@Then("^Validate that the edit icon is showing for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_for_applying_admin_price() throws Throwable {
		clickAction(adminPrice.getHotelPanel());
		Thread.sleep(1000);
		clickAction(adminPrice.getDiscountIcon());
		Thread.sleep(1000);
		validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
	}

	public void rateMatchFields(String field, String value) {
		WebElement rateMatchFields = driver.findElement(By.xpath("//span[text()='" + field + "']/../select"));
		selectDropDownUsingValue(rateMatchFields, value);

	}

	@Then("^verify the admin price label is showing$")
	public void verify_the_admin_price_label_is_showing() throws Throwable {
		waitForMe(booingReview.getbookNowButton());
		validateAssertion(elementDisplayed(adminPrice.getAdminPricelabel()));

	}

	/*
	 * This function is used to verify the update cost scenario's here we change the
	 * departure city and update cost the itinerary and wait for costed itinerary
	 */

	@Then("^change the departure city and update cost$")
	public void change_the_departure_city_and_update_cost() throws Throwable {
		clickAction(adminPrice.getChangePassengerInfo());
		Thread.sleep(1000);
		clickAction(icm.getDepartingCity());
		clickAction(icm.getdepartingFromBengaluru());
		clickAction(icm.getGcmUpdateCost());
		pollingWait(inclusion.getBookNow(), 100);
	}

	/*
	 * This function is to verify if user applied discount is getting retained for
	 * all lineitems except flight
	 * 
	 */

	@Then("^validate that the applied discount got retained for a line item$")
	public void validate_that_the_applied_discount_got_retained_for_a_line_item() throws Throwable {
		System.out.println("admindiscount");
		validateAssertion(elementDisplayed(adminPrice.getAdminPricelabel()));
		
	}

	/*
	 * This function is used to verify the update cost scenario's here we change the
	 * arrival city and update cost the itinerary and wait for costed itinerary
	 */

	@Then("^change the arrival city and update cost$")
	public void change_the_arrival_city_and_update_cost() throws Throwable {
		clickAction(adminPrice.getChangePassengerInfo());
		Thread.sleep(1000);
		clickAction(icm.getDepartingCity());
		clickAction(icm.getdepartingFromCoimbatore());
		Thread.sleep(1000);
		clickAction(icm.getArrivalCityCheckBox());
		clickAction(icm.getArrivalCity());
		waitForMe(icm.getdepartingFromChennai());
		clickAction(icm.getdepartingFromChennai());
		clickAction(icm.getGcmUpdateCost());
		pollingWait(inclusion.getBookNow(), 300);

	}

	// Flight related functionalities

	// This method finds the edit icon for internal and international flight
	// separately

	@Then("^Validate that the edit icon is showing on \"([^\"]*)\" for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_for_applying_admin_price(String flight) throws Throwable {

		String flightlen = adminPrice.getFlightCount().getText();
		String removeBraces = flightlen.replaceAll("\\p{P}", "");
		int flightCount = Integer.parseInt(removeBraces.trim());
		int internalFlightCount = flightCount - 1;
		System.out.println("Internal flight count----" + internalFlightCount);
		if (flight.equals("international")) {
			try {
				if (elementDisplayed(adminPrice.getFlightDiscountIcon())) {
					clickAction(adminPrice.getFlightDiscountIcon());
				}
			} catch (NoSuchElementException e) {
				System.out.println("Discount icon is not available for International flight");
			}
		} else if (flight.equals("internal")) {
			for (int i = 2; i <= (++internalFlightCount); i++) {
				WebElement internalflightediticon = driver.findElement(
						By.xpath("(//div[@name='all-flight-panels']//i[contains(@class,'pyt-edit')])[" + i + "]"));

				internalFlightPrice = driver
						.findElement(By.xpath(
								"(//div[@name='all-flight-panels']//b[@class='color-grey-secondary'])[" + i + "]"))
						.getText();
				System.out.println(internalFlightPrice);
				if (elementDisplayed(internalflightediticon)) {
					clickAction(internalflightediticon);
					break;
				} else {
					System.out.println("Discount icon is not available for Internal flight for "
							+ (internalFlightCount++) + " flight");
				}
			}
		}
		Thread.sleep(1000);
		validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
	}

	// This function fills the parameters required to apply discount on rate match
	// modal

	@Then("^select the options from the dropdown in the rate match modal \"([^\"]*)\" for the \"([^\"]*)\"$")
	public void select_the_options_from_the_dropdown_in_the_rate_match_modal_for_the(String lineitem, String category)
			throws Throwable {

		System.out.println(adminPriceCalculation(lineitem, category));
		int adminPriceInteger = adminPriceCalculation(lineitem, category);
		adminPriceAmount = Integer.toString(adminPriceInteger);
		Thread.sleep(1000);
		typeText(adminPrice.getAdminPriceField(), adminPriceAmount);

		switch (lineitem) {
		case "all-flight-panels": {
			rateMatchFields("Source", "TBO");
			rateMatchFields("Reason", "Flights already booked by customers");
			break;
		}
		case "all-hotel-panels": {
			rateMatchFields("Source", "TBO");
			rateMatchFields("Reason", "PYT Contract Hotels");
			break;
		}
		case "all-activity-panels": {
			rateMatchFields("Source", "Viator");
			rateMatchFields("Reason", "Not available on Viator");
			break;
		}
		case "all-transfer-panels": {

			if (category.equals("train")) {
				rateMatchFields("Source", "SNCF");
				rateMatchFields("Reason", "Expensive On Product");
				break;
			} else if (category.equals("AHtransfer")) {

				rateMatchFields("Source", "Others");
				Thread.sleep(1000);
				typeText(adminPrice.getairportHotelSourceText(), "test");
				rateMatchFields("Reason", "Expensive On Product");
				break;
			}

			else if (category.equals("rentalcar")) {

				rateMatchFields("Source", "THRIFTY");
				rateMatchFields("Reason", "Expensive On Product");
			}

		}

		case "all-summary": {
			rateMatchFields("Reason", "Adding buffer");
		}

		}
		rateMatchFields("Approved By", "ARVIND_RAMAMURTI");
		rateMatchFields("Retain Cancellation Policy", "YES");
		clickAction(adminPrice.getRateMatchUpdate());
	}

	// This method finds the edit icon for activity

	@Then("^Validate that the edit icon is showing on activity for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_activity_for_applying_admin_price() throws Throwable {

		try {
			clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
			clickAction(activityPage.getActivity_ExpandActivityInclusions());

			WebElement activitiesEditIcon = driver
					.findElement(By.xpath("(//div[@name='all-activity-panels']//i[contains(@class,'pyt-edit')])[1]"));

			activityPrice = driver
					.findElement(
							By.xpath("//div[@name='all-activity-panels']//i[contains(@class,'pyt-edit')]/../span//b"))
					.getText();

			System.out.println("activityPrice---" + activityPrice);
			if (elementDisplayed(activitiesEditIcon)) {
				clickAction(activitiesEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for train");
		}

	}

//This method finds the edit icon for train

	@Then("^validate that the edit icon is showing on train for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_train_for_applying_admin_price() throws Throwable {

		try {
			WebElement trainEditIcon = driver.findElement(
					By.xpath("(//button[contains(@class,'change-train')]/../div//i[contains(@class,'pyt-edit')])[1]"));
			trainPrice = driver.findElement(By.xpath(
					"//button[contains(@class,'change-train')]/../div//i[contains(@class,'pyt-edit')]/../span/b"))
					.getText();
			System.out.println("trainPrice---" + trainPrice);
			if (elementDisplayed(trainEditIcon)) {
				clickAction(trainEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for train");
		}
	}

//This method finds the edit icon for airport-hotel transfer

	@Then("^validate that the edit icon is showing on airport-hotel transfer for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_airport_hotel_transfer_for_applying_admin_price()
			throws Throwable {

		try {
			WebElement AHtransferEditIcon = driver.findElement(By.xpath(
					"//button[contains(text(),'Change to shared')]/../../div/following::i[contains(@class,'pyt-edit')]"));
			AHPrice = driver
					.findElement(By.xpath("//button[contains(text(),'Change to shared')]/../../div//i/../span/b"))
					.getText();
			System.out.println("AHPrice---" + AHPrice);
			scrolltoElement(AHtransferEditIcon);
			Thread.sleep(1000);
			if (elementDisplayed(AHtransferEditIcon)) {
				clickAction(AHtransferEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}

//This method finds the edit icon for Rental car transfer

	@Then("^validate that the edit icon is showing on rental car transfer for applying admin price$")
	public void validate_that_the_edit_icon_is_showing_on_rental_car_transfer_for_applying_admin_price()
			throws Throwable {

		try {

			WebElement rentalCarEditIcon = driver
					.findElement(By.xpath("(//div[@name='all-transfer-panels']//i[contains(@class,'pyt-edit')])[1]"));

			rentalCarPrice = driver
					.findElement(
							By.xpath("//div[@name='all-transfer-panels']//i[contains(@class,'pyt-edit')]/../span//b"))
					.getText();
			System.out.println("rentalCarPrice---" + rentalCarPrice);
			scrolltoElement(rentalCarEditIcon);
			Thread.sleep(1000);
			if (elementDisplayed(rentalCarEditIcon)) {
				clickAction(rentalCarEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));
		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}

	/*
	 * Apart from other line item flight as specific retain logic if any of the
	 * parameters change while doing update cost flight won't retain
	 */

	@Then("^validate that the applied discount not getting retained for a \"([^\"]*)\"$")
	public void validate_that_the_applied_discount_not_getting_retained_for_a(String category) throws Throwable {
		Boolean flag = false;
		try {
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			System.out.println(adminPrice.getAdminPricelabel().isDisplayed());
			flag = adminPrice.getAdminPricelabel().isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Passed : discount price is not retained after changing departure city for---"+category);
		}
		assertFalse(flag);
	}

	@Then("^validate that the edit icon is showing for applying overall discount price$")
	public void validate_that_the_edit_icon_is_showing_for_applying_overall_discount_price() throws Throwable {

		try {

			WebElement overallPriceEditIcon = driver
					.findElement(By.xpath("//aside[@class='price-card']//p//i[contains(@class,'cursor-pointer')]"));

			overallPrice = driver.findElement(By.xpath("//aside[@class='price-card']//p")).getText();
			System.out.println("overallPrice---" + overallPrice);

			Thread.sleep(1000);
			if (elementDisplayed(overallPriceEditIcon)) {
				clickAction(overallPriceEditIcon);
			}
			Thread.sleep(1000);
			validateAssertion(elementDisplayed(adminPrice.getRateMatchPanel()));

		} catch (NoSuchElementException ex) {
			System.out.println("Discount icon is not available for Airport hotel transfer");
		}

	}
	
	/*
	 * After applying discount need to verify discount is deducted from total price
	 * and validate the total price and discount price in tooltip
	 */
	@Then("^verify if the discount is applied for entire itinerary$")
	public void verify_if_the_discount_is_applied_for_entire_itinerary() throws Throwable {

		Thread.sleep(2000);
		String postDiscountoverallPrice = driver.findElement(By.xpath("//aside[@class='price-card']//p")).getText();
		String postDiscountoverallPriceStr = postDiscountoverallPrice.replaceAll("[^\\d]", "");
		String totalPriceAmount = Integer.toString(totalAdminPrice);
        validateAssertion(totalPriceAmount.contains(postDiscountoverallPriceStr));

		WebElement infoIcon = driver.findElement(By.xpath("//span[contains(@class,'info-icon')]"));
		hoverWebelement(infoIcon);
		String postDiscount = driver.findElement(By.xpath("//div[@class='tooltip-inner']/ul/li[6]/span[2]")).getText();
		String postDiscountStr = postDiscount.replaceAll("[^\\d]", "");
		validateAssertion(postDiscountStr.contains(adminPriceAmount));

	}

	@Then("^change the transfer type of AH transfer$")
	public void change_the_transfer_type_of_AH_transfer() throws Throwable {
		clickAction(adminPrice.getTransferType());
		
	}
}
