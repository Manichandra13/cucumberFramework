package gluecode;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.pyt.pages.BookingReviewPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import utils.Kernel;

public class LivePriceScreenGlue extends Kernel {

	public static List<WebElement> InclusionLineItemCard;
	public static List<WebElement> livePriceCard;
    public static int inclusionCount;
	public static int liveCount = 0;
	UserFloGlue usePas = new UserFloGlue();

	@And("^get the count of the inclusions card count from the inclusions page$")
	public void get_the_count_of_the_inclusions_card_count_from_the_inclusions_page() throws Throwable {
		inclusionCount = 0;
		int len = activityPage.getActivityCountInInclusions().size();
		System.out.println("Total Num of Items: " + len);
		for (int count = 0; count < len; count++) {
			String cnt = activityPage.getActivityCountInInclusions().get(count).getText();
			cnt = cnt.substring(1, 2);
			int activityCount = Integer.parseInt(cnt);
			inclusionCount = inclusionCount + activityCount;
		}
		try {
			if (elementDisplayed(inclusion.getVisaAddButton())) {
				inclusionCount = inclusionCount - 1;
			}
		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("Visa add button not found");
		}
		try {
			int retryCount = activityPage.getRetryCountInInclusions().size();
			inclusionCount = inclusionCount - retryCount;

		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("Retry button not available");
		}
		try {
			clickAction(inclusion.getActivityTabInclusions(), "user clicks on the activity tab in inclusiosn page ");
			Thread.sleep(1000);
			clickAction(activityPage.getActivity_ExpandActivityInclusions());
			Thread.sleep(2000);
			int selfActCount = driver.findElements(By.xpath("//*[text()=' Self Exploration']")).size();
			System.out.println("Self Exploration count :" + selfActCount);
			inclusionCount = inclusionCount - selfActCount;

		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("Retry button not available");
		}
		try {
			int alertCardCount = driver.findElements(By.xpath("//*[contains(@class,'pyt-alert-square')]")).size();
			inclusionCount = inclusionCount - alertCardCount;

		} catch (NoSuchElementException e) {
			// ReporteraddStepLog("Retry button not available");
		}

		System.out.println("InclusionLineItemCard  == " + inclusionCount);

	}

	@And("^get the count of the inclusions card from the live price page$")
	public void get_the_count_of_the_inclusions_card_from_the_live_price_page() throws Throwable {

		waitUntil(psp.getMakePaymentLivePrice(), 50);
		validate_String_Contains(getCurrentUrl(), "booking-review/");
		clickAction(psp.getShowMoreButtonInLivePrice());

		livePriceCard = driver.findElements(By.xpath("//div[@class='clearfix review-table']//a"));
		liveCount = livePriceCard.size();
		System.out.println("livePriceCard === " + liveCount);

	}

	@Then("^validate the both count are same$")
	public void validate_the_both_count_are_same() throws Throwable {
		boolean retval = false;
		// ReporteraddStepLog("Count from Inclusion page : "+inclusionCount);
		// ReporteraddStepLog("Count from live page review page : "+liveCount);
		if (inclusionCount == liveCount) {
			retval = true;
		} else {
			retval = false;
		}
		assertTrue(retval);
	}

	@And("^apply the coupon and verify the application of discount$")
	public void validate_the_kajalpyt_coupon_application() throws Throwable {
		String totalCost = getText(psp.getTotalCost());
		String totalresult = totalCost.replaceAll("[-+.^:,₹]", "");
		System.out.println(totalresult);
		clickAction(psp.getApplyCoupon());
		typeText(psp.getEnterCoupon(), "KAJALPYT");
		clickAction(psp.getApplyCode());
		String appliedDiscount = getText(psp.getTotalCost());
		String appliedDiscountResult = appliedDiscount.replaceAll("[-+.^:,₹]", "");
		int totalresultParsed = integerParser(totalresult);
		int appliedDiscountResultParsed = integerParser(appliedDiscountResult);
		assertEquals(totalresultParsed - 5000, appliedDiscountResultParsed, "The KAJALPYT coupon is applied");

	}
	
	public void validate_the_activity_removed_successfully() throws Throwable {
		boolean isReomved = verifyExactText(activityPage.getActivitySlider_AfterRemove(), "Activity Removed!");
		Assert.assertTrue(isReomved);
		clickAction(activityPage.getActivity_SliderClose(),"User clicks on out side the silder to close");
	}
	
	//Handling the sold-out scenario for activities in the live price screen
	
	@Then("^user Verifies if there is any sold out line item in the live price screen$")
	public void user_Verifies_if_there_is_any_sold_out_line_item_in_the_live_price_screen() throws Throwable {
		
		//If Change booking CTA displayed there are sold-out line items in the live price screen.
		
		if(elementDisplayed(booingReview.getChangeBooking())){
			clickAction(booingReview.getChangeBooking());
			Thread.sleep(1000);
			clickAction(booingReview.getItineraryButton());
			
			//Collect all the sold out activities from the itinerary page and remove that activities
			
			List<WebElement> soldOutActivities = driver.findElements(By.xpath("//span[contains(@class,'sold-out')]"));
			for(int i=0; i<soldOutActivities.size(); i++)

			{
				Thread.sleep(2000);
				System.out.println(soldOutActivities.size());
				String soldOutSlot= soldOutActivities.get(i).getText();
				System.out.println(" sold out activities name : " + soldOutSlot);
				soldOutActivities.get(i).click();
				clickAction(activityPage.getActivitySlider_Remove());
				validate_the_activity_removed_successfully();

			}
			
			//After removing the activities navigate to booking flow and initialize payment from live price screen
			
			clickAction(booingReview.getInclusionButton());
			Thread.sleep(2000);
			clickAction(pdgtreco.waitForCosting());
			clickAction(pdgflowp.getcontinue_to_book_button(), "User clicks continue to book");
			usePas.user_fills_passenger_details();
			validateAssertion(elementDisplayed(booingReview.getmakePaymentButton()));
			usePas.user_initializes_Payment();
		}
		
		// If there is no "change booking" CTA in the booking live price screen proceed with bookings
		
		else if(elementDisplayed(booingReview.getmakePaymentButton())){
			usePas.user_initializes_Payment();

		}

	}







}
