@Transfers @InclusionsFlow  @RegressionTest @Trains @Set2
Feature: Validating Trains feature in the inclusion page
 

#This test case verifies changing trains as an user

@SmokeTest  
Scenario Outline: User Flow validating the change view options on train 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And  Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that the alternate train is selected

	Examples: 
		|region|
		|Rome|
		
		
#This test case verifies choosing a 1-stop Train using the filter option as an user

@SmokeTest
Scenario Outline: User Flow Choose One-Stop Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that one stop Train option is chosen

	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing a No-stop train using the filter option as an user

  
Scenario Outline: User Flow Choose No-Stop Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that no stop Train option is chosen succeffully

	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing a Two-stop flight using the filter option as an admin user

 		
Scenario Outline: User Flow Choose Two-Stop Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that two stop Train option is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing an early morning train for onward journey as an user
	
  
Scenario Outline: User Flow Choose Onward Early Morning Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then  validate that early morning trains option for onward journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
	
#This test case verifies choosing an early morning flight for return journey as an user
		
 
Scenario Outline: User Flow Choose Return Early Morning Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that early morning trains option for return journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing an onward morning train for onward journey as an user

 	
Scenario Outline: User Flow Choose Onward Morning Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that morning trains option for onward journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing an return morning train for return journey as an user		
	
 
Scenario Outline: User Flow Choose Return Morning Trains Validation  
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that morning trains option for return journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing an onward mid-day train for onward journey as an user	
	
 		
Scenario Outline: User Flow Choose Onward Mid-day Trains Validation
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that mid-day trains option for onward journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing an return mid-day train for return journey as an user	

 		
Scenario Outline:  User Flow Choose Return Mid-day Trains Validation
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that mid-day trains option for return journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		
#This test case verifies choosing an onward night train for onward journey as an user	

 	
Scenario Outline: User Flow Choose Onward Night Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that night trains option for onward journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
		

#This test case verifies choosing an evening train for onward journey as an user	
			
 		
Scenario Outline: User Flow Choose Return evening Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that evening trains option for onward journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
			
#This test case verifies choosing an evening train for return journey as an user	
			
 		
Scenario Outline: User Flow Choose Return evening Trains Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page 
	Then validate that the Train section is displayed
	Then validate that evening trains option for return journey is chosen succeffully
	
	Examples: 
		|region|
		|Rome|
			