package gluecode;

import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import utils.Kernel;



public class SpeedboatGlue extends Kernel {
	
	boolean isPaxChanged;
	
	private void setPaxChange(boolean value) {
		isPaxChanged = value;
	}
	
	private boolean getPaxChange() {
		return isPaxChanged;
	}
	
	@Given("^Navigate to landing page for \"([^\"]*)\"$")
	public void navigate_to_landing_page_for(String region) throws Throwable {
		clickAction(hp.getstartPlanningNowButton(), "Click planning now button ");
		typeText(cp.getlandingSearchBox(), region);
		if (elementDisplayed(sbLand.getMaldivesInPdg()))
		{
				clickAction(sbLand.getMaldivesInPdg(), "Region selection");
				Thread.sleep(2000);
			}
	}

	@Then("^Verify that landing page is loaded as expected$")
	public void verify_that_landing_page_is_loaded_as_expected() throws Throwable {
		boolean result = false;
		String regionUrlPattern = "maldives-tour-packages";
		if(getCurrentUrl().contains(regionUrlPattern)) {
			result = true;
			System.out.println("Maldives landing page loaded successfully");
			}
	}
	
	@Then("^Enter the duration of stay as \"([^\"]*)\"$")
	public void enter_speedboat_duration(String duration) throws Throwable {
		int nights = Integer.parseInt(duration);
		
		clickAction(sbLand.getSbDuration());
		if(nights >= 5) {
			for(int i=1; i<=6; i++)
			{
				clickAction(sbLand.sbAddCustomDuration());
				String durationText = sbLand.getSbDuration().getAttribute("value");
				if(durationText.contains(duration)) {
					break;}
				else {continue;}
			}
		}
		else {
		switch(duration) {
			case "1": 
				clickAction(sbLand.sbChoose1Night());
				break;
			case "2": 
				clickAction(sbLand.sbChoose2Nights());
				break;
			case "3": 
				clickAction(sbLand.sbChoose3Nights());
				break;
			case "4": 
				clickAction(sbLand.sbChoose4Nights());
				break;
			}
		}
		
	}
	
	@Then("^Add rooms to the itinerary with group type and additional room count as \"([^\"]*)\",\"([^\"]*)\"$")
	public void change_speedboat_room_config(String groupType, String roomCount) throws Throwable{
		int rooms = Integer.parseInt(roomCount);
		clickJavaScriptElement(sbLand.getSbPax());
		switch(groupType) {
		case "Couple": 
			clickJavaScriptElement(sbLand.sbChooseCoupleGcm());
			break;
		case "Family": 
			clickJavaScriptElement(sbLand.sbChooseFamilyGcm());
			break;
		case "Friends": 
			clickJavaScriptElement(sbLand.sbChooseFriendsGcm());
			break;
		case "Solo" : 
			clickJavaScriptElement(sbLand.sbChooseSoloGcm());
			break;
		}
		if(rooms >= 1) {
			for(int i=1; i<=6; i++)
			{
				clickJavaScriptElement(sbLand.sbAddNewRoom());
				List <WebElement> roomsAdded = new ArrayList <WebElement>();
				roomsAdded = driver.findElements(By.xpath("//div[contains(@class,'gcm-room-config')]//*/span[contains(text(),'Room')]"));
				if(roomsAdded.size() == rooms + 1) {
					clickAction(sbLand.sbSaveRoomConfig());
					break;}
				else {continue;}
			}
		}
		
	}	
	
	@Then("^Enter the group type as \"([^\"]*)\"$")
	public void enter_speedboat_group_type(String groupType) throws Throwable {
		System.out.println("Choosing group type " + groupType);
		clickAction(sbLand.getSbPax());
		switch(groupType) {
			case "Couple": 
				clickAction(sbLand.sbChooseCoupleGcm());
				save_gcm_config();
				break;
			case "Family": 
				clickAction(sbLand.sbChooseFamilyGcm());
				save_gcm_config();
				break;
			case "Friends": 
				clickAction(sbLand.sbChooseFriendsGcm());
				save_gcm_config();
				break;
			case "Solo" : 
				clickAction(sbLand.sbChooseSoloGcm());
				save_gcm_config();
				break;
		}
		
	}
	
	public void save_gcm_config() throws Throwable {
		if(elementDisplayed(sbLand.sbSaveRoomConfig())) {
			clickAction(sbLand.sbSaveRoomConfig());}
		else {System.out.println("Save config not visible. Moving with further steps");}
	}
	
	@Then("^Enter the departure location as \"([^\"]*)\"$")
	public void enter_speedboat_departure_loation(String departFrom) throws Throwable {
		String depCode = "";
		if(departFrom.contentEquals("Outside India")) {
			depCode = "departing from Outside India";}
		else if(departFrom.contentEquals("Flights Booked")) {
			depCode = "I have booked my flights already";}
		else {depCode = departureCities.get(departFrom);}
		if(elementDisplayed(sbLand.getSbDepartureCity())) {
			clickJavaScriptElement(sbLand.getSbDepartureCity());}
		else {
			clickJavaScriptElement(sbList.getListingGCMDepartureCity());
		}
		choose_city_dynamically(departFrom, depCode);
	}
	
	@Then("^Click on Search available packages$")
	public void select_search_available_packages() throws Throwable {
		scrollToView(sbList.getSelectAvailablePackages());
		clickAction(sbList.getSelectAvailablePackages());
	}
		
	public void choose_city_dynamically(String departFrom, String depCode) throws Throwable{
		try {
			clickAction(driver.findElement(By.xpath("//*[contains(text(),'" + depCode + "')]")));}
		catch(Exception ex) {
			clickAction(sbLand.sbSearchForCity());
			typeText(sbLand.sbSearchForCity(),departFrom);
			clickAction(driver.findElement(By.xpath("//*[contains(text(),'" + depCode + "')]")));
		}
		
	}
	
	@Then("^Enter the departure date$")
	public void enter_speedboat_departure_date() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 200);");
		clickAction(sbLand.getSbDepartureDate());
		clickAction(sbLand.sbGoToNextMonth());
		clickAction(sbLand.sbChooseTravelDate());
	}
	
	@Then("^Click on the price filter$")
	public void choose_price_range_filter() throws Throwable {
		clickAction(sbList.getPriceFilter());
	}
	
	@Then("^Choose price range per person as \"([^\"]*)\"$")
	public void choose_price_range_option(String priceRange) throws Throwable {
		switch(priceRange) {
		case "50to70k":
			clickAction(sbList.get50to70kPriceFilter());
			break;
		case "70to80k":
			clickAction(sbList.get70to80kPriceFilter());
			break;
		case "Above80k":
			clickAction(sbList.getAbove80kPriceFilter());
			break;
		case "70to80k+Above80k":
			List<String> priceList = Arrays.asList(priceRange.split("+"));
			int i = 0;
			for (i=0;i<priceList.size();i++) {
				if(priceList.get(i) == "50to70k") {clickAction(sbList.get50to70kPriceFilter());}
				else if(priceList.get(i) == "70to80k") {clickAction(sbList.get70to80kPriceFilter());}
				else if(priceList.get(i) == "Above80k"){clickAction(sbList.getAbove80kPriceFilter());}
			}
			break;
		}
		clickAction(sbList.getApplyChosenFilter());
		
	}
	
	@Then("^Search for all available packages$")
	public void search_available_packages() throws Throwable {
		clickAction(sbLand.chooseSearchForPackages());
	}
	
	@Then("^Click on the GCM pill$")
	public void choose_gcm_pill() throws Throwable {
		clickAction(sbList.getGCMPill());
	}
	
	@Then("^Click on the Book now button$")
	public void get_book_now_button() throws Throwable {
		clickAction(sbCost.getBookNow());
	}
	
	@Then("^Verify that valid results are displayed in listing page$")
	public void verify_results_in_listing_page() throws Throwable {
		String parentWindow = switchWindows();
		if(getCurrentUrl().contains("/listing")) {
			waitForMe(sbList.getUnlockDeal());
			System.out.println("Successfully routed to listing page and finished costing");
		}
	}
	
	@Then("^Verify that valid results are displayed in costed details page$")
	public void verify_results_in_costed_page() throws Throwable {
		Set<String> windows = driver.getWindowHandles();
		boolean flag = true;
		if(getCurrentUrl().contains("/get-cost")) {
			waitForMe(sbCost.getBookNow());
			System.out.println("Successfully routed to costed details page");
		}
//		if(getCurrentUrl().contains("/get-cost")) {					/* This code can be used if we include test case for
//			while(flag) {												login from the uncosted resort details page */
//				if(windows.size()>1) {
//				String parentWindow = switchWindows();
//				waitForMe(sbCost.getBookNow());
//				System.out.println("Successfully routed to costed details page");
//				flag = false;
//				}
//			}
//		}
	}
	
	@Then("^Verify that results are shown for price range \"([^\"]*)\"$")
	public void verify_price_filter_results(String priceRange) throws Throwable {
		String urlPrice = "";
		switch(priceRange){
		case "50to70k":
			urlPrice = "50to70";
			break;
		case "70to80k":
			urlPrice = "70to80";
			break;
		case "Above80k":
			urlPrice= "above80";
			break;
		case "70to80k+Above80k":
			urlPrice = "70to80,above80";
			break;
		}
		if(getCurrentUrl().contains("&price=" + urlPrice)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}
	
	@Then("^Click on the star category filter$")
	public void choose_star_category_filter() throws Throwable {
		clickAction(sbList.getStarFilter());
	}
	
	@And("^Choose star category as \"([^\"]*)\"$")
	public void choose_star_category_option(String starCategory) throws Throwable {
		switch(starCategory) {
		case "3 Star":
			clickAction(sbList.get3StarFilter());
			break;
		case "4 Star":
			clickAction(sbList.get4StarFilter());
			break;
		case "5 Star":
			clickAction(sbList.get5StarFilter());
			break;
		case "4 Star+5 Star":
			List<String> starList = Arrays.asList(starCategory.split(","));
			int i = 0;
			for (i=0;i<starList.size();i++) {
				if(starList.get(i) == "3 Star") {clickAction(sbList.get3StarFilter());}
				else if(starList.get(i) == "4 Star") {clickAction(sbList.get4StarFilter());}
				else if(starList.get(i) == "5 Star"){clickAction(sbList.get5StarFilter());}
			}
			break;
		}
		clickAction(sbList.getApplyChosenFilter());
	}
	
	@Then("^Verify that results are shown for star category \"([^\"]*)\"$")
	public void verify_star_category_results(String starCategory) throws Throwable {
		String urlStar = "";
		switch(starCategory){
		case "3 Star":
			urlStar = "3";
			break;
		case "4 Star":
			urlStar = "4";
			break;
		case "5 Star":
			urlStar = "5";
			break;
		case "4 Star+5 Star":
			urlStar = "4,5";
			break;
		}
		if(getCurrentUrl().contains("&star=" + urlStar)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}
	
	@Then("^Click on the villa type filter$")
	public void choose_villa_type_filter() throws Throwable {
		clickAction(sbList.getVillaFilter());
	}
	
	@And("^Choose villa type as \"([^\"]*)\"$")
	public void choose_villa_type_option(String villaType) throws Throwable {
		switch(villaType) {
		case "Water Villa":
			clickAction(sbList.getWaterVillaFilter());
			break;
		case "Beach Bungalow":
			clickAction(sbList.getBeachBungalowFilter());
			break;
		case "Split Stay":
			clickAction(sbList.getSplitStayFilter());
			break;
		case "Garden Villa":
			clickAction(sbList.getGardenVillaFilter());
			break;
		case "Family Stay":
			clickAction(sbList.getFamilyVillaFilter());
			break;
		case "Water Villa+Split Stay":
			List<String> starList = Arrays.asList(villaType.split("+"));
			int i = 0;
			for (i=0;i<starList.size();i++) {
				if(starList.get(i) == "Water Villa") {clickAction(sbList.getWaterVillaFilter());}
				else if(starList.get(i) == "Beach Bungalow") {clickAction(sbList.getBeachBungalowFilter());}
				else if(starList.get(i) == "Split Stay"){clickAction(sbList.getSplitStayFilter());}
				else if(starList.get(i) == "Garden Villa"){clickAction(sbList.getGardenVillaFilter());}
				else if(starList.get(i) == "Family Villa"){clickAction(sbList.getSplitStayFilter());}
			}
			break;
		}
		clickAction(sbList.getApplyChosenFilter());
	}
	
	@Then("^Verify that results are shown for villa type \"([^\"]*)\"$")
	public void verify_villa_type_results(String villaType) throws Throwable {
		String urlVilla = "";
		switch(villaType){
		case "Water Villa":
			urlVilla = "WATER_VILLA";
			break;
		case "Beach Bungalow":
			urlVilla = "BEACH_BUNGALOW";
			break;
		case "Split Stay":
			urlVilla = "SPLIT_STAY";
			break;
		case "Garden Villa":
			urlVilla = "GARDEN_VILLA";
			break;
		case "Family Stay":
			urlVilla = "FAMILY_VILLA";
			break;
		case "Water Villa+Split Stay":
			urlVilla = "WATER_VILLA,SPLIT_STAY";
			break;
		}
		if(getCurrentUrl().contains("&villa=" + urlVilla)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}
	
	
	@Then("^Click on the Others filter$")
	public void choose_others_filter() throws Throwable {
		clickAction(sbList.getOthersFilter());
	}
	
	@And("^Choose filter type as \"([^\"]*)\"$")
	public void choose_others_filter_option(String otherType) throws Throwable {
		switch(otherType) {
		case "For the Honeymooners":
			clickAction(sbList.getForHoneymoonersFilter());
			break;
		case "Best Overwater Villa":
			clickAction(sbList.getBestOverwaterVillaFilter());
			break;
		case "Kid Friendly Resorts":
			clickAction(sbList.getKidFriendlyResortsFilter());
			break;
		case "Great Indian Food":
			clickAction(sbList.getGreatIndianFoodFilter());
			break;
		case "Seaplane Only":
			clickAction(sbList.getSeaplaneOnlyFilter());
			break;
		case "Closest to Airport":
			clickAction(sbList.getClosestToAirportFilter());
			break;
		case "For the Honeymooners+Seaplane Only":
			List<String> otherList = Arrays.asList(otherType.split("+"));
			int i = 0;
			for (i=0;i<otherList.size();i++) {
				if(otherList.get(i) == "For the Honeymooners") {clickAction(sbList.getForHoneymoonersFilter());}
				else if(otherList.get(i) == "Best Overwater Villa") {clickAction(sbList.getBestOverwaterVillaFilter());}
				else if(otherList.get(i) == "Kid Friendly Resorts"){clickAction(sbList.getKidFriendlyResortsFilter());}
				else if(otherList.get(i) == "Great Indian Food"){clickAction(sbList.getGreatIndianFoodFilter());}
				else if(otherList.get(i) == "Seaplane Only"){clickAction(sbList.getSeaplaneOnlyFilter());}
				else if(otherList.get(i) == "Closest to Airport"){clickAction(sbList.getClosestToAirportFilter());}
			}
			break;
		}
		clickAction(sbList.getApplyChosenFilter());
	}
	
	@Then("^Verify that results are shown for the filter \"([^\"]*)\"$")
	public void verify_filter_results(String otherType) throws Throwable {
		String urlOtherFilter = "";
		switch(otherType){
		case "For the Honeymooners":
			urlOtherFilter = "honeymoon-special";
			break;
		case "Best Overwater Villa":
			urlOtherFilter = "overwater-villa";
			break;
		case "Seaplane Only":
			urlOtherFilter = "seaplane-only";
			break;
		case "Great Indian Food":
			urlOtherFilter = "great-indian-food";
			break;
		case "Kid Friendly Resorts":
			urlOtherFilter = "kid-friendly";
			break;
		case "Closest to Airport":
			urlOtherFilter = "closest-to-airport";
			break;
		
		}
		if(getCurrentUrl().contains("&villa=" + urlOtherFilter)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}
	
	@Then("^Click on the meal type filter$")
	public void choose_meal_type_filter() throws Throwable {
		clickAction(sbList.getMealFilter());
	}
	
	@And("^Choose meal type as \"([^\"]*)\"$")
	public void choose_meal_filter_option(String mealType) throws Throwable {
		switch(mealType) {
		case "Half Board":
			clickAction(sbList.getHalfBoardFilter());
			break;
		case "Full Board":
			clickAction(sbList.getFullBoardFilter());
			break;
		case "All Inclusive":
			clickAction(sbList.getBreakfastOnlyFilter());
			break;
		case "Breakfast Only":
			clickAction(sbList.getAllInclusiveFilter());
			break;
		case "Full Board+All Inclusive":
			List<String> mealList = Arrays.asList(mealType.split("+"));
			int i = 0;
			for (i=0;i<mealList.size();i++) {
				if(mealList.get(i) == "Half Board") {clickAction(sbList.getHalfBoardFilter());}
				else if(mealList.get(i) == "Full Board") {clickAction(sbList.getFullBoardFilter());}
				else if(mealList.get(i) == "Breakfast Only"){clickAction(sbList.getBreakfastOnlyFilter());}
				else if(mealList.get(i) == "All Inclusive"){clickAction(sbList.getAllInclusiveFilter());}
			}
			break;
		}
		clickAction(sbList.getApplyChosenFilter());
	}
	
	@Then("^Verify that results are shown for meal type \"([^\"]*)\"$")
	public void verify_meal_filter_results(String mealType) throws Throwable {
		String urlMealFilter = "";
		switch(mealType){
		case "Half Board":
			urlMealFilter = "HB";
			break;
		case "Full Board":
			urlMealFilter = "FB";
			break;
		case "Breakfast Only":
			urlMealFilter = "BB";
			break;
		case "All Inclusive":
			urlMealFilter = "AI";
			break;
		
		}
		if(getCurrentUrl().contains("&meal=" + urlMealFilter)) {
			System.out.println("Successfully returned relevant results in listing page");
		}
	}
	
	@Then("^Enter the room config with adult count and child count as \"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_custom_pax_speedboat(String adultCount, String childCount) throws Throwable {
		int adults = Integer.parseInt(adultCount);
		int children = Integer.parseInt(childCount);
		System.out.println("Updating adult count as " + adults + " and child count as " + children);
		int ageToSelect = 0;
		clickAction(sbLand.getSbPax());
		clickAction(sbLand.sbChooseFamilyGcm());
		if(adults > 2) {
			for(int i=3;i<=adults;i++) {
				clickAction(sbLand.sbAddAdultToPax());}}
		if(children >= 1) {	
			for(int j=1;j<=children;j++) {
				clickAction(sbLand.sbAddChildToPax());
				ageToSelect = j+4;
				clickAction(driver.findElement(By.xpath("(//select[contains(@class,'ChildAge')]/option["+ageToSelect+"])["+j+"]")));
			}
		}
		clickAction(sbLand.sbSaveRoomConfig());
	}
	
	@And("^Verify that resort details page is opened$")
	public void verify_resort_details_page_load() throws Throwable {
		if(getCurrentUrl().contains("-maldives-resort")) {
			System.out.println("Successfully navigated to the uncosted resort details page");
		}
	}
	
	@Then("^Click on a resort card for the category \"([^\"]*)\"$")
	public void select_resort_card_from_category(String category) throws Throwable {
		switch(category)
		{
		case "For the Honeymooners":
			scrollToView(sbLand.sbChooseHoneymoonResort());
			clickAction(sbLand.sbChooseHoneymoonResort());
			break;
		case "Best Overwater Villa":
			scrollToView(sbLand.sbChooseOverwaterResort());
			clickAction(sbLand.sbChooseOverwaterResort());
			break;
		case "Kid Friendly Resorts":
			scrollToView(sbLand.sbChooseKidFriendlyResort());
			clickAction(sbLand.sbChooseKidFriendlyResort());
			break;
		case "Great Indian Food":
			scrollToView(sbLand.sbChooseIndianFoodResort());
			clickAction(sbLand.sbChooseIndianFoodResort());
			break;
		case "Seaplane Only":
			scrollToView(sbLand.sbChooseSeaplaneResort());
			clickAction(sbLand.sbChooseSeaplaneResort());
			break;
		case "Closest to Airport":
			scrollToView(sbLand.sbChooseAirportResort());
			clickAction(sbLand.sbChooseAirportResort());
			break;
		}
	}
	
	@Then("^Click on Check Availability button$")
	public void click_check_availability_option() throws Throwable {
		scrollToView(sbUncost.getCheckAvailability());
		clickAction(sbUncost.getCheckAvailability());
	}
	
	@Then("^Click on change room option$")
	public void click_change_room_option() throws Throwable {
		scrollToView(sbCost.getChangeRoom());
		clickAction(sbCost.getChangeRoom());
	}

	@Then("^Choose a room from the alternate full stay options available$")
	public void choose_alternate_full_stay_room_option() throws Throwable {
		List<WebElement> roomList = sbCost.getFullStayRoomList();
		if(roomList.size() >= 1) {
			clickAction(sbCost.getAlternateFullStayRoom());
			waitForMe(sbCost.getBookNow());
		}
		else {
			System.out.println("There are no alternate full stay room options available");
		}
	}
	
	@Then("^Choose a room from the alternate split stay options available$")
	public void choose_alternate_split_stay_room_option() throws Throwable {
		if(elementDisplayed(sbCost.chooseSplitStayTab())) {
			clickAction(sbCost.chooseSplitStayTab());
			List<WebElement> roomList = sbCost.getSplitStayRoomList();
			if(roomList.size() >= 1) {
				clickAction(sbCost.getAlternateSplitStayRoom());
				waitForMe(sbCost.getBookNow());
			}
			else {
				System.out.println("There are no alternate split stay room options available");
			}
		}
		else {System.out.println("There are no split stay room options available for the given resort");}
	}
}
