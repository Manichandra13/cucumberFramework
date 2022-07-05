package com.pyt.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ActivityPage {

    
	@FindBy(xpath = "//div[@name='all-activity-panels']//button//i[1]")
	WebElement activity_ViewDetails;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement activity_RemoveButton;

	@FindBy(xpath = "//button[contains(text(),'Change Activity')]")
	WebElement activity_ChangeButton;

	@FindBy(xpath = "(//div[contains(@class,'activity-alter-card')])[1]")
	WebElement activity_ChangeAlternateActivity;

	@FindBy(xpath = "//button[contains(text(),'Add to itinerary')]")
	WebElement activity_AddToItineraryButton;
	
	//Activity slots in the itinerary page 
	@FindBy(xpath="(//div[@class='card_inner_row col-sm-12 col-md-12 clickable'])[1]")
	WebElement activity_FirstFullDaySlot;
	
	@FindBy(xpath="(//div[@class='card_inner_row col-sm-8 col-md-8 clickable'])[1]")
	WebElement activity_FirstHalfDaySlot;
	
	@FindBy(xpath="(//div[@class='card_inner_row col-sm-4 col-md-4 clickable'])[1]")
	WebElement activity_FirstQuarterDaySlot;
	
	//View similar button in activity slider to access the activity alternate page
	@FindBy(xpath="//button[contains(text(),'Find More Activities')]")
	WebElement activitySlider_ViewSimilar;
	
	//View details button in the activity slider to access the activity details page 
	@FindBy(xpath="//button[contains(text(),'View details')]")
	WebElement activitySlider_ViewDetails;
	
	//Remove button in the activity slider 
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement activitySlider_Remove;
	
	//Add activity button in the activity slider,The button is only accessible if the user removed the activity
	@FindBy(xpath="//button[contains(text(),'Add Activity')]")
	WebElement activitySlider_AddActivity;
	
	//After user reomved the activity from activity slider the text will display in the slider "Activity removed" 
	@FindBy(xpath="//p[contains(text(),'Activity Removed')]")
	WebElement activitySlider_AfterRemove;
	
	//Right arrow in the activity slider 
	@FindBy(xpath="//i[contains(@class,'pyt-chevron-right')]")
	WebElement activitySlider_RightArrow;
	
	//Left arrow in the activity slider
	@FindBy(xpath="//i[contains(@class,'pyt-chevron-left')]")
	WebElement activitySlider_LeftArrow;
	
	//Search box in the activity alternate page 
	@FindBy(xpath="//div[contains(@class,'search')]/descendant::input")
	WebElement activityAlternate_SearchBox;
	
	//Activity Cards in the alternate page 
	@FindBy(xpath="//div[@class='activity-alter-card']")
	WebElement activityAlternate_Cards;
	
	//Activity Choose button in alternate page hover on Activity card
	@FindBy(xpath="//button[contains(text(),'Choose')]")
	WebElement activityAlternate_Choose;
	
	//Activity updated/added/removed/ success message notification
	@FindBy(xpath="//div[@class='msg-notification bottom-left']/p[@class='with-close']")
	WebElement activity_CrudSuccessMsgNoti;
	
	//Time slot filters in Activity alternate page 
	@FindBy(xpath="//a[text()='Morning']")
	WebElement activity_MorningTimeSlotFilter;
	
	@FindBy(xpath="//a[text()='Afternoon']")
	WebElement activity_AfternoonTimeSlotFilter;
	
	@FindBy(xpath="//a[text()='Evening']")
	WebElement activity_EveningTimeSlotFilter;
	
	//Activity Duration filter in Alternate page
	@FindBy(xpath="//a[text()='Quarter Day']")
	WebElement activity_QuarterDayDurationFilter;
	
	@FindBy(xpath="//a[text()='Half Day']")
	WebElement activity_HalfDayDurationFilter;
	
	@FindBy(xpath="//a[text()='Full Day']")
	WebElement activity_FullDayDurationFilter;
	
	//Activity transfer included/not included filter in alternate page 
	@FindBy(xpath="//a[@value='transferIncluded']")
	WebElement activity_TranferIncludedFilter;
	
	@FindBy(xpath="//a[@value='transferNotIncluded']")
	WebElement activity_TranferNotIncludedFilter;
	
	//Group type filter shared/private filter
	@FindBy(xpath="//a[@value='shared']")
	WebElement activity_SharedFilter;
	
	@FindBy(xpath="//a[@value='private']")
	WebElement activity_PrivateFilter;
	
	//Interest filter from activity alternate page
	@FindBy(xpath="//a[text()='Art & Culture']")
	WebElement activity_ArtAndCulture;
	
	@FindBy(xpath="//a[text()='Adventure & Outdoor']")
	WebElement activity_AdventureAndOutdoor;
	
	@FindBy(xpath="//a[text()='Food & Nightlife']")
	WebElement activity_FoodAndNightlife;
	
	@FindBy(xpath="//a[text()='Shopping & Leisure']")
	WebElement activity_ShoppingAndLeisure;
	
	//Other filter section in activity alternate page 
	@FindBy(xpath="//a[text()='Top Highlight']")
	WebElement activity_TopHighlightsFilter;
	
	@FindBy(xpath="//a[text()='Kid Friendly']")
	WebElement activity_KidFriendlyFilter;
	
	@FindBy(xpath="//a[text()='Fast Selling']")
	WebElement activity_FastSellingFilter;
	
	@FindBy(xpath="//a[text()='Less explored gems']")
	WebElement activity_LessExploredGemsFilter;
	
	@FindBy(xpath="//a[text()='Self Exploration']")
	WebElement activity_SelfExplorationFilter;
	
	//Activity Smart filter
	
	@FindBy(xpath="//span[contains(@class,'slider')]")
	WebElement activity_SmartFilter;
	
	//Activtiy tab in the inclusions header with count of the activity
	@FindBy(xpath="//li/a[contains(text(),'Activity ')]")
	WebElement activity_InclusionsHeader;
	
	//View all activities button in Inclusion page
	@FindBy(xpath="//button[contains(text(),'View all')]")
	WebElement activity_ExpandActivityInclusions;
	
	//Show less activity button in inclusions page
	@FindBy(xpath="//button[contains(text(),'Show less activities')]")
	WebElement activity_ShowLessInclusions;
	
	//Activity 1st Card in inclusions page 
	@FindBy(xpath="//div[contains(@name,'all-activity-panels')]//section[1]")
	WebElement activity_InclusionsfirstCard;
	
	//Activity slider close 
	@FindBy(xpath="//div[contains(@class,'offcanvas-bg fade-in')]")
	WebElement activity_SliderClose;
	
	//Filter pills in the alternate page 
	@FindBy(xpath="//span[@class='tag-sm round']")
	WebElement activity_FilterPill;
	
	//Self exploration tag in the alternate activity card
	@FindBy(xpath=" //b[contains(text(),'Self Exploration')]")
	WebElement selfExplorationTag;
	
	@FindBy(xpath="(//div[contains(@class,'activity-alter-card')]//span)[1]")
	WebElement nameOfActivityFirstCardAlternate;
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm']")
	List<WebElement> activityCountInInclusions;
	
	@FindBy(xpath="//button[contains(text(),'Back to itinerary')]")
	WebElement backToItineraryInAlternate;
	
	@FindBy(xpath="//*[contains(text(),'Retry')]")
	List<WebElement> retryCountInInclusions;

	
	public WebElement getBackToItineraryButtonInAlternate() {
		return backToItineraryInAlternate;
	}

	
	public WebElement getNameOfActivityFirstCardAlternate() {
		return nameOfActivityFirstCardAlternate;
	}

	public WebElement getSelfExplorationTag() {
		return selfExplorationTag;
	}

	public WebElement getActivity_FilterPill() {
		return activity_FilterPill;
	}

	public WebElement getActivity_SliderClose() {
		return activity_SliderClose;
	}

	public WebElement getActivity_InclusionsfirstCard() {
		return activity_InclusionsfirstCard;
	}

	public WebElement getActivity_InclusionsHeader() {
		return activity_InclusionsHeader;
	}

	public WebElement getActivity_ExpandActivityInclusions() {
		return activity_ExpandActivityInclusions;
	}

	public WebElement getActivity_ShowLessInclusions() {
		return activity_ShowLessInclusions;
	}

	public WebElement getActivity_MorningTimeSlotFilter() {
		return activity_MorningTimeSlotFilter;
	}

	public WebElement getActivity_AfternoonTimeSlotFilter() {
		return activity_AfternoonTimeSlotFilter;
	}

	public WebElement getActivity_EveningTimeSlotFilter() {
		return activity_EveningTimeSlotFilter;
	}

	public WebElement getActivity_QuarterDayDurationFilter() {
		return activity_QuarterDayDurationFilter;
	}

	public WebElement getActivity_HalfDayDurationFilter() {
		return activity_HalfDayDurationFilter;
	}

	public WebElement getActivity_FullDayDurationFilter() {
		return activity_FullDayDurationFilter;
	}

	public WebElement getActivity_TranferIncludedFilter() {
		return activity_TranferIncludedFilter;
	}

	public WebElement getActivity_TranferNotIncludedFilter() {
		return activity_TranferNotIncludedFilter;
	}

	public WebElement getActivity_SharedFilter() {
		return activity_SharedFilter;
	}

	public WebElement getActivity_PrivateFilter() {
		return activity_PrivateFilter;
	}

	public WebElement getActivity_ArtAndCulture() {
		return activity_ArtAndCulture;
	}

	public WebElement getActivity_AdventureAndOutdoor() {
		return activity_AdventureAndOutdoor;
	}

	public WebElement getActivity_FoodAndNightlife() {
		return activity_FoodAndNightlife;
	}

	public WebElement getActivity_ShoppingAndLeisure() {
		return activity_ShoppingAndLeisure;
	}

	public WebElement getActivity_TopHighlightsFilter() {
		return activity_TopHighlightsFilter;
	}

	public WebElement getActivity_KidFriendlyFilter() {
		return activity_KidFriendlyFilter;
	}

	public WebElement getActivity_FastSellingFilter() {
		return activity_FastSellingFilter;
	}

	public WebElement getActivity_LessExploredGemsFilter() {
		return activity_LessExploredGemsFilter;
	}

	public WebElement getActivity_SelfExplorationFilter() {
		return activity_SelfExplorationFilter;
	}

	public WebElement getActivity_SmartFilter() {
		return activity_SmartFilter;
	}

	public void setActivity_RemoveButton(WebElement activity_RemoveButton) {
		this.activity_RemoveButton = activity_RemoveButton;
	}

	public WebElement getActivity_CrudSuccessMsgNoti() {
		return activity_CrudSuccessMsgNoti;
	}

	public WebElement getActivity_ViewDetails() {
		return activity_ViewDetails;
	}

	public WebElement getActivity_FirstFullDaySlot() {
		return activity_FirstFullDaySlot;
	}

	public WebElement getActivity_FirstHalfDaySlot() {
		return activity_FirstHalfDaySlot;
	}

	public WebElement getActivity_FirstQuarterDaySlot() {
		return activity_FirstQuarterDaySlot;
	}

	public WebElement getActivitySlider_ViewSimilar() {
		return activitySlider_ViewSimilar;
	}

	public WebElement getActivitySlider_ViewDetails() {
		return activitySlider_ViewDetails;
	}

	public WebElement getActivitySlider_Remove() {
		return activitySlider_Remove;
	}

	public WebElement getActivitySlider_AddActivity() {
		return activitySlider_AddActivity;
	}

	public WebElement getActivitySlider_AfterRemove() {
		return activitySlider_AfterRemove;
	}

	public WebElement getActivitySlider_RightArrow() {
		return activitySlider_RightArrow;
	}

	public WebElement getActivitySlider_LeftArrow() {
		return activitySlider_LeftArrow;
	}

	public WebElement getActivityAlternate_SearchBox() {
		return activityAlternate_SearchBox;
	}

	public WebElement getActivityAlternate_Cards() {
		return activityAlternate_Cards;
	}

	public WebElement getActivityAlternate_Choose() {
		return activityAlternate_Choose;
	}
	
	public WebElement getActivity_viewDetails() {
		return activity_ViewDetails;
	}

	public WebElement getActivity_RemoveButton() {
		return activity_RemoveButton;
	}

	public WebElement getActivity_ChangeButton() {
		return activity_ChangeButton;
	}

	public WebElement getActivity_ChangeAlternateActivity() {
		return activity_ChangeAlternateActivity;
	}

	public WebElement getActivity_AddToItineraryButton() {
		return activity_AddToItineraryButton;
	}

	public List<WebElement> getActivityCountInInclusions() {
		return activityCountInInclusions;
	}

	public List<WebElement> getRetryCountInInclusions() {
		return retryCountInInclusions;
	}
}
