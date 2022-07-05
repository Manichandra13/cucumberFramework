@FAS @Activities @ItineraryFlow @RegressionTest @Set1
Feature: Activities Precosting Flow 
	Verify the Activity flow pre-costing With Pre-Login/Post-Login

#Background:
#Given Login as a authenticated user



#Verify the Activity slider presents
@RegressionTest @SmokeTest 
Scenario Outline: Verify the activity slider   
    Given Login as a authenticated user 
	 And  user validates the costing flow for "<region>" 
	 Then validate that the itinerary is created succesfully 
    Then validate the activity slider in the itinerary page
		
Examples: 
		|region|
		|Australia|			






# Precosting, Postlogin - User Changing activity in full day slot using activity slider from alternate page
@RegressionTest @SmokeTest 
Scenario Outline: User Changes activity using activity slider Before Costing in Full Day Slot
    Given Login as a authenticated user
    When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully 
	And  user change and validate the activity in full day slot 	
Examples: 
		|region|
		|Europe|
 
## Pre-costing, Post-login - User Changing activity in half day slot using activity slider
@RegressionTest 
Scenario Outline: User Changes activity using activity slider Before Costing in Half Day Slot
    Given Login as a authenticated user
    When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully 
	And  user change and validate the activity in half day slot
Examples: 
		|region|
		|Australia|
			
## Pre-costing, Post-login - User Changing activity in quarter day slot using activity slider
@RegressionTest
Scenario Outline: User Changes activity using activity slider Before Costing in Quarter Day Slot
   Given Login as a authenticated user
   When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully 
	And  user change and validate the activity in quater day slot
	     	
Examples: 
		|region|
		|Europe|
		
		
		
		
		
		

## Precosting, Postlogin - User adding activity in full day slot from alternate page 
@RegressionTest	@SmokeTest
Scenario Outline: User Add the Activity Before Costing in Full Day Slot 
	Given Login as a authenticated user 
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user add the activity in full day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Europe|	
		
## Precosting, Postlogin - User adding activity in half day slot from alternate page 
@RegressionTest	
Scenario Outline: User Add the Activity Before Costing in Full Day Slot 
	Given Login as a authenticated user 
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user add the activity in half day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Europe|	
		
## Precosting, Postlogin - User adding activity in quarter day slot from alternate page 
@RegressionTest		
Scenario Outline: User Add the Activity Before Costing in Quarter Day Slot 
	Given Login as a authenticated user 
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user add the activity in quarter day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Europe|
		
		
		
		



#  Precosting, Postlogin - User Remove activity in Full day slot from Activity slider 
@RegressionTest @SmokeTest
 Scenario Outline: User Remove the full Day Activity From Slider Before Costing
   Given Login as a authenticated user
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
   Then user remove the full day activity and validate the activity removed
  
	Examples: 
		|region|
		|Europe|	
		
#Precosting, Postlogin - User Remove activity in half day slot from Activity slider
@RegressionTest
Scenario Outline: User Remove the Half Day Activity From Slider Before Costing
   Given Login as a authenticated user
   When user validates the costing flow for "<region>" 
   And  validate that the itinerary is created succesfully 
   Then  user remove the half day activity and validate the activity removed 
   
   
   Examples: 
		|region|
		|Australia|
	
#Precosting, Postlogin - User Remove activity in quarter day slot from Activity slider	
@RegressionTest	
Scenario Outline: User Remove the Quarter Day Activity From Slider Before Costing
   Given Login as a authenticated user
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
   Then user remove the quarter day activity and validate the activity removed 
  
   Examples: 
		|region|
		|Australia|	


#PreCosting,PreLogin -User removing and adding activity using slider in Quarter day slot
@RegressionTest @SmokeTest
Scenario Outline: User Add Activity Using Activity Slider In Quarter Day Slot Before Costing 			
	Given Login as a authenticated user
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
    And  user remove the quarter day activity and validate the activity removed 
	And  Add activity using slider from itinerary 
	Then validate the activity added in itinerary successfully 
	
	Examples: 
		|region|
		|Australia|


#PreCosting,PreLogin -User removing and adding activity using slider in half day slot	
@RegressionTest
Scenario Outline: User Add Activity Using Activity Slider In Half Day Slot Before Costing	
    Given Login as a authenticated user
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
	And  user remove the half day activity and validate the activity removed 
	And  Add activity using slider from itinerary	
	Then validate the activity added in itinerary successfully 
	
	Examples: 
	|region|
	|Europe|	
	
#PreCosting,PreLogin -User removing and adding activity using slider in full day slot
@RegressionTest
Scenario Outline: User Add Activity Using Activity Slider In Full Day Slot Before Costing
    Given Login as a authenticated user
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
	And user remove the full day activity and validate the activity removed
    And  Add activity using slider from itinerary	
	Then validate the activity added in itinerary successfully 
	
	Examples: 
	|region|
	|Europe|	
	
	
	
	
	
	
	
##Precosting, Prelogin - User Changing activity in full day slot using activity slider	
@RegressionTest @SmokeTest
Scenario Outline: User Changes activity using activity slider Before login in Full Day Slot
   Given  user land on home page without login
    When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully 
	And  user change and validate the activity in full day slot 	
Examples: 
		|region|
		|Europe|
				
# Pre-costing, pre-login - User Changing activity in half day slot using activity slider 
@RegressionTest 
Scenario Outline: User Changes activity using activity slider Before Login in Half Day Slot
	Given  user land on home page without login
	When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully 
	And  user change and validate the activity in half day slot			
Examples: 
		|region|
		|Europe|
				
# Pre-costing, Pre-login - User Changing activity in Quarter day slot using activity slider
@RegressionTest		
Scenario Outline: User Changes activity using activity slider Before Login in Quarter Day Slot
	 Given  user land on home page without login
     When user validates the costing flow for "<region>"
	 Then validate that the itinerary is created succesfully 
	 And  user change and validate the activity in quater day slot
Examples: 
	|region|
	|Europe|
				






		
# Precosting, Prelogin - User adding activity in full day slot from alternate page 
@RegressionTest @SmokeTest
Scenario Outline: User Add the Activity Before Costing in Full Day Slot 
   Given  user land on home page without login
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user add the activity in full day slot 
	Then validate the activity added in itinerary successfully 

	Examples: 
		|region|
		|Europe|	
		
# Precosting, Prelogin - User adding activity in half day slot from alternate page 
@RegressionTest	
Scenario Outline: User Add the Activity Before Costing in Full Day Slot 
    Given  user land on home page without login
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user add the activity in half day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Europe|	
		
# Precosting, Prelogin - User adding activity in quarter day slot from alternate page
@RegressionTest 
Scenario Outline: User Add the Activity Before Costing in Quarter Day Slot 
    Given  user land on home page without login
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user add the activity in quarter day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Europe|




#  Precosting, Prelogin - User Remove activity in Full day slot from Activity slider 
@RegressionTest @SmokeTest
 Scenario Outline: User Remove the full Day Activity From Slider
   Given user land on home page without login
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
   Then user remove the full day activity and validate the activity removed
  
	Examples: 
		|region|
		|Europe|
			
#  Precosting, Prelogin - User Remove activity in half day slot from Activity slider 
@RegressionTest	
Scenario Outline: User Remove the Half Day Activity From Slider
   Given  user land on home page without login
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
   Then user remove the half day activity and validate the activity removed 
   
   
   Examples: 
		|region|
		|Australia|
		
#  Precosting, Prelogin - User Remove activity in Quarter day slot from Activity slider 
@RegressionTest		
Scenario Outline: User Remove the Quarter Day Activity From Slider
   Given  user land on home page without login
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
    Then user remove the quarter day activity and validate the activity removed 
   
   
   Examples: 
		|region|
		|Australia|
		
		
		
#PreCosting,preLogin -User removing and adding activity using slider in Quarter day slot
@RegressionTest @SmokeTest
Scenario Outline: User Add Activity Using Activity Slider In Quarter Day Slot 			
	Given user land on home page without login
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
    And  user remove the quarter day activity and validate the activity removed 
	And  Add activity using slider from itinerary 
	Then validate the activity added in itinerary successfully 
	
	Examples: 
		|region|
		|Australia|


#PreCosting,preLogin -User removing and adding activity using slider in half day slot
@RegressionTest	
Scenario Outline: User Add Activity Using Activity Slider In Half Day Slot	
    Given user land on home page without login
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
	And  user remove the half day activity and validate the activity removed 
   	And  Add activity using slider from itinerary	
	Then validate the activity added in itinerary successfully 
	
	Examples: 
	|region|
	|Australia|	
	
#PreCosting,preLogin -User removing and adding activity using slider in full day slot
@RegressionTest 
Scenario Outline: User Add Activity Using Activity Slider In Full Day Slot	
    Given user land on home page without login
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
	And  user remove the full day activity and validate the activity removed
    And  Add activity using slider from itinerary	
	Then validate the activity added in itinerary successfully 
	
	Examples: 
	|region|
	|Australia|	
	
	
#Validation of the activity search box  
Scenario Outline: Validation of Activity Search Box Before Costing
    Given user land on home page without login
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
    And  user remove the full day activity and validate the activity removed
    And  user search for the activity 
	Then validate the activity search box 
	
	
	Examples: 
	|region|
	|Australia|	

