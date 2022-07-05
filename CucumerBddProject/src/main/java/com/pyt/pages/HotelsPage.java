package com.pyt.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsPage {

	@FindBy(xpath = "//div[@name='all-hotel-panels']//section[@class='inclusion-box cursor-pointer  null']//i[contains(@class,'pyt-serif-info')]")
	WebElement hotel_viewDetails;

	@FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
	WebElement hotel_removeHotelButton;

	@FindBy(xpath = "//*[text()='You have removed this hotel from itinerary!']")
	WebElement hotel_hotelRemovedMessage;

	@FindBy(xpath = "(//div[@name='all-hotel-panels']//button[contains(text(),'Add')])[1]")
	WebElement hotel_addHotelButton;

	@FindBy(xpath = "(//section[contains(@class,'hotel_card')])[1]")
	WebElement hotel_replaceHotelCardAlternate;

	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement detailsPageAddToItinneraryButton;

	@FindBy(xpath = "//button[contains(text(),'Change Hotel')]")
	WebElement hotel_ChangeHotelButton;

	// Trip adviser rating icon text in hotel alternate page
	@FindBy(xpath = "(//b[text()='On Trip Advisor'])[1]")
	WebElement onTripAdvisorHotelIcon;

	// Agoda rating icon text in hotel alternate page
	@FindBy(xpath = "(//b[text()='On Agoda'])[1]")
	WebElement onAgodaHotelIcon;

	// PYT Exclusive tag in the hotel card in hotel alternate page
	@FindBy(xpath = "//section[contains(@class,'hotel_card')]//*[contains(text(),'PYT EXCLUSIVE')]")
	WebElement pytExclusiveTagHotelCard;

	// PYT exclusive is toggle will display only for admin, clicking on this filter
	// will only display supplier hotels
	@FindBy(xpath = "(//div[contains(@class,'TopStickyFilterStyles')]//span)[2]")
	WebElement pytExclusiveToggle;

	// Hotel card in the alternate list
	@FindBy(xpath = "//section[contains(@class,'hotel_card')]")
	List<WebElement> hotelCardInAlternate;

	// Room name text of the 1st one in the expanded view (current selection)
	@FindBy(xpath = "(//div[@id='root']//div[@class='hotel-inner-card']//p[contains(@class,'main-text')])[1]")
	WebElement firstRoomNameHotelDetails;

	// Second room name of the expanded view of the room in hotel details page
	@FindBy(xpath = "(//div[@id='root']//div[@class='hotel-inner-card']//p[contains(@class,'main-text')])[2]")
	WebElement secondRoomNameHotelDetails;

	// First room name xpath in the side card of the hotel details page
	@FindBy(xpath = "(//div[@id='root']//aside[@class='update-card']//ul//span)[1]")
	WebElement firstRoomNameSideCardHotelDetails;

	// first room name in not expanded view
	@FindBy(xpath = "(//div[@class='hotel-main-card ']//p[contains(@class,'main-text')])[1]")
	WebElement firstRoomNameNoExpandViewHotel;

	// Use this element to get room count from the hotel details page
	@FindBy(xpath = "//div[@class='hotel-main-card ']")
	WebElement roomCountInHotelDetails;

	// first replace button in the hotel card of map view alternate page
	@FindBy(xpath = "(//section[contains(@class,'hotel_card')]//button[contains(text( ),'Replace')])[1]")
	WebElement replaceButtonHotelCardAlternate;

	// Back to itinerary link in the hotel alternate and details page
	@FindBy(xpath = "//button[@class='back-link']")
	WebElement BackToItineraryHotel;

	// First select room button in the hotel details page
	@FindBy(xpath = "(//button[contains(text(),'Select')])[1]")
	WebElement selectRoomButtonHotelDetails;

	// Show more room option in hotel details page
	@FindBy(xpath = "//button[contains(text( ),'Show more rooms')]")
	WebElement showMoreRoomsHotelDetail;

	// Choose for more option link if the room view collapsed
	@FindBy(xpath = "//a[contains(text( ),'Choose for more options')]")
	WebElement chooseMoreOptionHotelDetails;

	// Retain this room link if the room view expanded
	@FindBy(xpath = "//a[contains(text( ),'Retain this room')]")
	WebElement retainRoomOptionHotelDetails;

	// our pick filter
	@FindBy(xpath = "(//div[contains(@class,'TopStickyFilterStyles')]//span)[1]")
	WebElement ourPickFilterHotel;

	// Top recommended hotel tag in hotel card if the user clicks the our pick
	// filter
	@FindBy(xpath = "//span[contains(@class,'TopRecommended')]")
	WebElement topRecommendedTagFilterHotel;

	// Filter button in the header of the hotel alternate page , on clicking this
	// user have the access to all type of filter
	@FindBy(xpath = "//div[contains(text(),'Filter')]")
	WebElement headerFilterHotelButton;

	// Sort button in the header of the hotel alternate page(price and rate sort)
	@FindBy(xpath = "//div[contains(text(),'Sort ')]")
	WebElement headerSortHotelButton;

	// Source provider button in the header of the hotel alternate page( Admin only
	// can access this filter to switch source provider of hotel)
	@FindBy(xpath = "//div[contains(text(),'Source Provider')]")
	WebElement headerSourceProviderHotelButton;

	// Cheapest first sorting
	@FindBy(xpath = "(//li[contains(@class,'SortHotelModal__SortItem')])[1]")
	WebElement cheapestFirstHotelSort;

	// Best rated first sorting
	@FindBy(xpath = "(//li[contains(@class,'SortHotelModal__SortItem')])[2]")
	WebElement bestReatedFirstSort;

	// Source prodiver agoda filter (Admin only feature)
	@FindBy(xpath = "//label[@title='AGODA']//span")
	WebElement agodaHotelFilter;

	// Source provider Expedia filter(Admin only feature)
	@FindBy(xpath = "//label[@title='EXPEDIA']//span")
	WebElement expediaHotelFilter;

	// Non refundable icon text in hotel card in hotel alternates
	@FindBy(xpath = "//section[contains(@class,'hotel_card')]//span[text()='Non-Refundable']")
	WebElement nonRefundableHotelCardIcon;

	// Refundable icon text in hotel card in hotel alternate
	@FindBy(xpath = "//section[contains(@class,'hotel_card')]//span[(text()='Refundable')]")
	WebElement refundableHotelCardIcon;

	
	// Nearbyfiter label
	@FindBy(xpath = "//label[contains(text(),'Nearby Attractions')]")
	WebElement nearByAttractionFilterLabel;

    // Current hotel name in the inclusions
	@FindBy(xpath = "//div[@id='root']//section//a")
	WebElement currentHotelNameInAlternate;

	// Rating sorting filter
	@FindBy(xpath = "//li[(text()='Best Rated First')]")
	WebElement ratingSortingHotel;

	// price sorting filter
	@FindBy(xpath = "//li[(text()='Cheapest First')]")
	WebElement priceSortingHotel;

	// Search box in the hotel
	@FindBy(xpath = "//input[@placeholder='Find a hotel']")
	WebElement searchBoxInHotel;

	// Filter pills After applying the filter
	@FindBy(xpath = "//span[@class='tag-sm round']")
	WebElement filterPillsHotel;

	// close symbol of hotel filter pill to deselect the filter
	@FindBy(xpath = "//span[@class='tag-sm round']//following-sibling::i")
	WebElement closeHotelFilterPill;

	// Change button in the hotel card inclusions page
	@FindBy(xpath = "//div[contains(@name,'all-hotel-panels')]//button[contains(text(),'Change')]")
	WebElement changeHotelInclusion;

	// Map views of the hotel filter xpaths
	// Smart filter button
	@FindBy(xpath = "(//div[contains(text( ),'Smart Filter')])[1]")
	WebElement smartFilterButtonMapHotel;

	// Smart filter toggle check in the map view of the hotel alternate
	@FindBy(xpath = "//div[@class='pull-right']//label[@class='switch']")
	WebElement smartFilterToggleMapHotel;

	// Top recommended tag in the hotel card if the smart filter applied
	@FindBy(xpath = "//b[contains(text( ),'Top Recommended')]")
	WebElement topRecommendedTagHotelCard;

	// Ac check box filter in map view of hotel alternate
	@FindBy(xpath = "//div[contains(text( ),'Inclusions')]//span[contains(text( ),'Air conditioning')]")
	WebElement acFilterMapHotel;

	// Free breakfast check box filter in map view of hotel alternate
	@FindBy(xpath = "//div[contains(text( ),'Inclusions')]//span[contains(text( ),'Free breakfast')]")
	WebElement freeBreakfastFilterMapHotel;

	// Free wifi check box filter in map view of hotel alternate
	@FindBy(xpath = "//div[contains(text( ),'Inclusions')]//span[contains(text( ),'Free wifi')]")
	WebElement freeWifiFilterMapHotel;

	// Near by Attraction filter in the map view of alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Nearby Attractions')]")
	WebElement nearByFilterButtonMapHotel;

	// First option in the near by filter in the map view of alternate hotel
	@FindBy(xpath = "(//div[contains(text( ),'Nearby Attractions')]//span)[1]")
	WebElement firstNearbyFilterOption;

	// Refundable check box filter in the map view of the alternate hotel
	@FindBy(xpath = "(//div[contains(text( ),'Cancellation Policy')]//span[contains(text( ),'Refundable')])[1]")
	WebElement refundableFilterMapHotel;

	// Non-Refundable check box filter in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Cancellation Policy')]//span[contains(text( ),'Non Refundable')]")
	WebElement nonRefundableFilterMapHotel;

	// Type filter button in the map of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]")
	WebElement typeFilterButtonMapHotel;

	// Hotel filter under the type filter in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]//span[contains(text( ),'Hotel')]")
	WebElement hotelFilterMapHotel;

	// Apartment filter under the type filter in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]//span[contains(text( ),'Apartment')]")
	WebElement apartmentFilterMapHotel;

	// Budget filter under the type filter in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]//span[contains(text( ),'Budget')]")
	WebElement budgetFilterMapHotel;

	// unique stay under the type filter in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]//span[contains(text( ),'Unique stays')]")
	WebElement uniqueStayFilterMapHotel;

	// villa stay under the type filter in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]//span[contains(text( ),'Villa')]")
	WebElement villaFilterMapHotel;

	// private pool villa under the type filter in the map view of the alternate
	// hotel
	@FindBy(xpath = "//div[contains(text( ),'Type')]//span[contains(text( ),'Private pool villa')]")
	WebElement privatePoolFilterMapHotel;

	// Price slider in the map view of the alternate hotel
	@FindBy(xpath = "//div[contains(text( ),'Total Price')]")
	WebElement totelPriceFilterMapHotel;

	public WebElement getOurPickFilterHotel() {
		return ourPickFilterHotel;
	}

	public WebElement getTopRecommendedTagFilterHotel() {
		return topRecommendedTagFilterHotel;
	}

	public WebElement getHeaderFilterHotelButton() {
		return headerFilterHotelButton;
	}

	public WebElement getFirstRoomNameNoExpandViewHotel() {
		return firstRoomNameNoExpandViewHotel;
	}

	public WebElement getRoomCountInHotelDetails() {
		return roomCountInHotelDetails;
	}

	public WebElement getFirstRoomNameSideCardHotelDetails() {
		return firstRoomNameSideCardHotelDetails;
	}

	public WebElement getSecondRoomNameHotelDetails() {
		return secondRoomNameHotelDetails;
	}

	public WebElement getFirstRoomNameHotelDetails() {
		return firstRoomNameHotelDetails;
	}

	public WebElement getReplaceButtonHotelCardAlternate() {
		return replaceButtonHotelCardAlternate;
	}

	public WebElement getBackToItineraryHotel() {
		return BackToItineraryHotel;
	}

	public WebElement getSelectRoomButtonHotelDetails() {
		return selectRoomButtonHotelDetails;
	}

	public WebElement getShowMoreRoomsHotelDetail() {
		return showMoreRoomsHotelDetail;
	}

	public WebElement getChooseMoreOptionHotelDetails() {
		return chooseMoreOptionHotelDetails;
	}

	public WebElement getRetainRoomOptionHotelDetails() {
		return retainRoomOptionHotelDetails;
	}

	public WebElement getSmartFilterButtonMapHotel() {
		return smartFilterButtonMapHotel;
	}

	public WebElement getSmartFilterToggleMapHotel() {
		return smartFilterToggleMapHotel;
	}

	public WebElement getTopRecommendedTagHotelCard() {
		return topRecommendedTagHotelCard;
	}

	public WebElement getAcFilterMapHotel() {
		return acFilterMapHotel;
	}

	public WebElement getFreeBreakfastFilterMapHotel() {
		return freeBreakfastFilterMapHotel;
	}

	public WebElement getFreeWifiFilterMapHotel() {
		return freeWifiFilterMapHotel;
	}

	public WebElement getNearByFilterButtonMapHotel() {
		return nearByFilterButtonMapHotel;
	}

	public WebElement getFirstNearbyFilterOption() {
		return firstNearbyFilterOption;
	}

	public WebElement getRefundableFilterMapHotel() {
		return refundableFilterMapHotel;
	}

	public WebElement getNonRefundableFilterMapHotel() {
		return nonRefundableFilterMapHotel;
	}

	public WebElement getTypeFilterButtonMapHotel() {
		return typeFilterButtonMapHotel;
	}

	public WebElement getHotelFilterMapHotel() {
		return hotelFilterMapHotel;
	}

	public WebElement getApartmentFilterMapHotel() {
		return apartmentFilterMapHotel;
	}

	public WebElement getBudgetFilterMapHotel() {
		return budgetFilterMapHotel;
	}

	public WebElement getUniqueStayFilterMapHotel() {
		return uniqueStayFilterMapHotel;
	}

	public WebElement getVillaFilterMapHotel() {
		return villaFilterMapHotel;
	}

	public WebElement getPrivatePoolFilterMapHotel() {
		return privatePoolFilterMapHotel;
	}

	public WebElement getTotelPriceFilterMapHotel() {
		return totelPriceFilterMapHotel;
	}

	public WebElement getChangeHotelInclusion() {
		return changeHotelInclusion;
	}

	public WebElement getFilterPillsHotel() {
		return filterPillsHotel;
	}

	public WebElement getHotel_viewDetails() {
		return hotel_viewDetails;
	}

	public WebElement getHotel_replaceHotelCardAlternate() {
		return hotel_replaceHotelCardAlternate;
	}

	public WebElement getDetailsPageAddToItinneraryButton() {
		return detailsPageAddToItinneraryButton;
	}

	public WebElement getHotel_ChangeHotelButton() {
		return hotel_ChangeHotelButton;
	}

	public WebElement getNearByAttractionFilterLabel() {
		return nearByAttractionFilterLabel;
	}


	public WebElement getCurrentHotelNameInAlternate() {
		return currentHotelNameInAlternate;
	}

	public WebElement getRatingSortingHotel() {
		return ratingSortingHotel;
	}

	public WebElement getPriceSortingHotel() {
		return priceSortingHotel;
	}

	public WebElement getSearchBoxInHotel() {
		return searchBoxInHotel;
	}

	public WebElement gethotel_ChangeHotelButton() {
		return hotel_ChangeHotelButton;
	}

	public WebElement getHotel_removeHotelButton() {
		return hotel_removeHotelButton;
	}

	public WebElement getHotel_hotelRemovedMessage() {
		return hotel_hotelRemovedMessage;
	}

	public WebElement getHotel_addHotelButton() {
		return hotel_addHotelButton;
	}

	public WebElement gethotel_replaceHotelCardAlternate() {
		return hotel_replaceHotelCardAlternate;
	}

	public WebElement gethotel_detailsPageAddToItinneraryButton() {
		return detailsPageAddToItinneraryButton;
	}

	public WebElement getCloseHotelFilterPill() {
		return closeHotelFilterPill;
	}

	public List<WebElement> getHotelCardInAlternate() {
		return hotelCardInAlternate;
	}

	public WebElement getPytExclusiveToggle() {
		return pytExclusiveToggle;
	}

	public WebElement getPytExclusiveTagHotelCard() {
		return pytExclusiveTagHotelCard;
	}

	public WebElement getHeaderSourceProviderHotelButton() {
		return headerSourceProviderHotelButton;
	}

	public WebElement getHeaderSortHotelButton() {
		return headerSortHotelButton;
	}

	public WebElement getCheapestFirstHotelSort() {
		return cheapestFirstHotelSort;
	}

	public WebElement getBestReatedFirstSort() {
		return bestReatedFirstSort;
	}

	public WebElement getAgodaHotelFilter() {
		return agodaHotelFilter;
	}

	public WebElement getExpediaHotelFilter() {
		return expediaHotelFilter;
	}

	public WebElement getNonRefundableHotelCardIcon() {
		return nonRefundableHotelCardIcon;
	}

	public WebElement getRefundableHotelCardIcon() {
		return refundableHotelCardIcon;
	}

	public WebElement getOnTripAdvisorHotelIcon() {
		return onTripAdvisorHotelIcon;
	}

	public WebElement getOnAgodaHotelIcon() {
		return onAgodaHotelIcon;
	}

}
