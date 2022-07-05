@FAS @Activities @InclusionsFlow @RegressionTest @Set1
Feature: Activities PostCosting Flow 
Verify the Activity flow of post costing


#Verify the Activity slider presents
@RegressionTest @SmokeTest
Scenario Outline: Verify the activity slider post costing
    Given Login as a authenticated user 
	 And  user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	 And  user fills the GCM form 
	 And  user navigate to itinerary page
    Then validate the activity slider in the itinerary page
		
Examples: 
		|region|
		|Australia|	


#User Changing activity in full day slot using activity slider from alternate page
@RegressionTest @SmokeTest
Scenario Outline: User Changes activity using activity slider After Costing in Full Day Slot
    Given Login as a authenticated user
    When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully 
	And  user fills the GCM form 
	And  user navigate to itinerary page
	And  user change and validate the activity in full day slot 
	
Examples: 
		|region|
		|Australia|
		
#User Changing activity in half day slot using activity slider
@RegressionTest		
Scenario Outline: User Changes activity using activity slider After Costing in Half Day Slot
    Given Login as a authenticated user
    When user validates the costing flow for "<region>"
	Then validate that the itinerary is created succesfully
	And  user fills the GCM form 
	And  user navigate to itinerary page 
	And  user change and validate the activity in half day slot
	
	Examples: 
		|region|
		|Australia|	
		
#User Changing activity in quarter day slot using activity slider
@RegressionTest
Scenario Outline: User Changes activity using activity slider After Costing in Quarter Day Slot
   Given Login as a authenticated user
   When user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully 
   And  user fills the GCM form 
   And  user navigate to itinerary page 
   And  user change and validate the activity in quater day slot
	     	
Examples: 
		|region|
		|Europe|	

#User adding activity in full day slot from alternate page 	
@RegressionTest	@SmokeTest
Scenario Outline: User Add the Activity After Costing in Full Day Slot 
	Given Login as a authenticated user 
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user fills the GCM form 
    And  user navigate to itinerary page 
	And  user add the activity in full day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Thailand|	

#User adding activity in half day slot from alternate page 	
@RegressionTest	
Scenario Outline: User Add the Activity After Costing in Full Day Slot 
	Given Login as a authenticated user 
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully
	And  user fills the GCM form 
    And  user navigate to itinerary page  
	And  user add the activity in half day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Australia|	
		
#User adding activity in quarter day slot from alternate page 
@RegressionTest		
Scenario Outline: User Add the Activity After Costing in Quarter Day Slot 
	Given Login as a authenticated user 
	When user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user fills the GCM form 
    And  user navigate to itinerary page 
	And  user add the activity in quarter day slot 
	Then validate the activity added in itinerary successfully 
	Examples: 
		|region|
		|Europe|
		
#User Remove activity in Full day slot from Activity slider 
@RegressionTest @SmokeTest
 Scenario Outline: User Remove the full Day Activity From Slider After Costing
   Given Login as a authenticated user
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
   And  user fills the GCM form 
   And  Check an itinerary got successfully costed
   And  user navigate to itinerary page 
   And  user remove the full day activity and validate the activity removed 
  
   
	Examples: 
		|region|
     	|Europe|	
		
#User Remove activity in half day slot from Activity slider
@RegressionTest
Scenario Outline: User Remove the Half Day Activity From Slider After Costing
   Given Login as a authenticated user
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully
   And  user fills the GCM form 
  And  Check an itinerary got successfully costed
   And  user navigate to itinerary page  
   And  user remove the half day activity and validate the activity removed 
  
   
   Examples: 
		|region|
		|Australia|
	
#User Remove activity in quarter day slot from Activity slider	
@RegressionTest	
Scenario Outline: User Remove the Quarter Day Activity From Slider After Costing
   Given Login as a authenticated user
   When user validates the costing flow for "<region>" 
   Then validate that the itinerary is created succesfully 
   And  user fills the GCM form 
   And  Check an itinerary got successfully costed
   And  user navigate to itinerary page 
   And  user remove the quarter day activity and validate the activity removed 
 
   
   Examples: 
		|region|
		|Australia|
			

@RegressionTest @SmokeTest
Scenario Outline: User Change the Activity Post Costing via alternate Page In Inclusions Page
	Given Login as a authenticated user
	And   user validates the costing flow for "<region>" 
	Then  validate that the itinerary is created succesfully 
	And   user fills the GCM form 	
	Then validate that the itinerary is created succesfully 
    Then validate that the Activity section is displayed
    And  user change the activity from inclusions via alternate page
   Then  validate the activity added from inclusions successfully
    
	Examples: 
	|region|
	|Australia|	

@RegressionTest @SmokeTest
	Scenario Outline: User Change the Activity Post Costing via details page In Inclusions Page
	Given Login as a authenticated user
	And   user validates the costing flow for "<region>" 
	Then  validate that the itinerary is created succesfully 
	And   user fills the GCM form 	
    Then validate that the itinerary is created succesfully 
    Then  validate that the Activity section is displayed
    And   user change the activity from inclusions via details page
    Then  validate the activity added from inclusions successfully
    
	Examples: 
	|region|
	|Australia|			
			
						
@RegressionTest	@SmokeTest	
Scenario Outline:  Verify the user remove the activity from the inclusions 
	Given Login as a authenticated admin user 
	And  user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user fills the GCM form
    Then validate that the itinerary is created succesfully  
	And  user clicks inclusion page 
	Then validate that the Activity section is displayed
	Then validate the activity removal flow

   Examples: 
		|region|
		|Rome|
		
#Validation of the activity search box 
Scenario Outline: Validation of Activity Search Box After Costing
    Given Login as a authenticated user
    When user validates the costing flow for "<region>" 
    Then validate that the itinerary is created succesfully 
    And  user fills the GCM form 
    Then validate that the itinerary is created succesfully 
    And  user navigate to itinerary page
    And  user remove the full day activity and validate the activity removed 
    And  user search for the activity 
    Then validate the activity search box 
	
	
	Examples: 
	|region|
	|Australia|	




