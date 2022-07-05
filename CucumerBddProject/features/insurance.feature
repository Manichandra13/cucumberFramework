@InclusionsFlow @Insurance @RegressionTest @Set2
Feature: Insurance validation in inclusion

@PostBuild
Scenario Outline: Remove Insurance From The Inclusions 
  Given Login as a authenticated user
  When user validates the costing flow for "<region>"
  And validate that the itinerary is created succesfully
	And user fills the GCM form for "<departFrom>"
  And Check an itinerary got successfully costed
  And user scroll down and remove the insurance from the inclusions page 
  Then validate the insurance got removed successfully
  
  
  Examples:
 |region|departFrom|
 |Europe|Chennai|
 
 Scenario Outline: Change The Insurance Type In The Inclusions 
   Given Login as a authenticated user
   When user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully 
	 And user fills the GCM form for "<departFrom>"
   And Check an itinerary got successfully costed
   And user scroll down and remove the insurance from the inclusions page 
   And user click the change button in the insurance card 
   And select the alternate insurance type
   Then verify the insurance type changed successfully
   
 Examples:
 |region|departFrom|
 |Australia|Chennai|
 
 Scenario Outline: Add The Insurance In The Inclusions
  Given  Login as a authenticated user
   When user validates the costing flow for "<region>"
   Then validate that the itinerary is created succesfully 
	 And user fills the GCM form for "<departFrom>"
   And  Check an itinerary got successfully costed
   And  user scroll down and remove the insurance from the inclusions page
   And  user add the insurance
   Then verify insurance added successfully
   
  Examples:
 |region|departFrom|
 |Australia|Chennai|