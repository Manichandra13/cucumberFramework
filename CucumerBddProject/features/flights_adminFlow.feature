@Flights @InclusionsFlow @RegressionTest @Set2
Feature: Flights Admin Flow 
 Verify the flights flow across the product

#This test case verifies changing international flights as an admin user

@SmokeTest
Scenario Outline: Admin Flow Change Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed
#	Then validate that the Flight section is displayed
	Then validate whether Flight change is selected
	Then validate changing the flight is done
#	Then validate the flight change view
	
	Examples: 
		|region|departFrom|
		|Thailand|Chennai|
		
#This test case verifies changing international flights using smart filter option as an admin user
		
@SmokeTest
Scenario Outline: Admin Flow Change Flights With Smart Filter Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate that the Flight section is displayed
	Then validate whether Flight change is selected
	Then validate that smart filtered flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|Australia|Chennai|
		
#This test case verifies choosing a Direct international flight using the filter option as an admin user

Scenario Outline: Admin Flow Choose Direct Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate whether Flight change is selected
	Then validate that direct flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|singapore|Chennai|
		

#This test case verifies choosing a 1-stop flight using the filter option as an admin user
	
Scenario Outline: Admin Flow Choose One-Stop Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate whether Flight change is selected
	Then validate that one stop flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
	
#This test case verifies choosing a 2-stop flight using the filter option as an admin user
Scenario Outline: Admin Flow Choose Two-Stop Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that two stop flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|New Zealand|Chennai|
	
#This test case verifies choosing an early morning flight for onward journey as an admin user
	
Scenario Outline: Admin Flow Choose Onward Early Morning Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that early morning flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Singapore|Chennai|

#This test case verifies choosing an early morning flight for return journey as an admin user

Scenario Outline: Admin Flow Choose Return Early Morning Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that early morning flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Singapore|Chennai|
	
#This test case verifies choosing a morning flight for onward journey as an admin user
	
Scenario Outline: Admin Flow Choose Onward Morning Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that morning flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|

		
#This test case verifies choosing a morning flight for return journey as an admin user

Scenario Outline: Admin Flow Choose Return Morning Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that morning flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a mid-day flight for onward journey as an admin user
		
Scenario Outline: Admin Flow Choose Onward Mid-day Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that mid-day flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Australia|Chennai|

#This test case verifies choosing a mid-day flight for return journey as an admin user

Scenario Outline: Admin Flow Choose Return Mid-day Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that mid-day flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Thailand|Chennai|
				
#This test case verifies choosing a night flight for onward journey as an admin user
Scenario Outline: Admin Flow Choose Onward Night Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that night flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Mumbai|
			
#This test case verifies choosing a night flight for return journey as an admin user

Scenario Outline: Admin Flow Choose Return Night Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that night flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a refundable international flight as an admin user


Scenario Outline: Admin Flow Choose Refundable Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that refundable option for flights is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a non-refundable international flight as an admin user

Scenario Outline: Admin Flow Choose Non Refundable Flights Validation 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that non refundable option for flights is chosen succeffully

	Examples: 
		|region|departFrom|
		|Singapore|Chennai|
		
#This test case verifies choosing 'Show More' option for international flight as an admin user
Scenario Outline: Admin Flow Choose Flight From More Available Options in Flight Card
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate whether Flight change is selected
	Then validate that more flight options in a flight card is displayed
	Then validate that flight is chosen from displayed options

	Examples: 
		|region|departFrom|
		|New Zealand|Chennai|
		
		
#This test case verifies changing an internal flight as an admin user
@SmokeTest
Scenario Outline: Admin Flow Change Internal Flight
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate that internal flight is changed successfully

	Examples: 
		|region|departFrom|
		|Sydney|Chennai|
		
		
#This test case verifies choosing flight after changing internal flight provider as an admin user
Scenario Outline: Admin Flow Change Internal Flight Provider
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate that internal flight provider is changed successfully

	Examples: 
		|region|departFrom|
		|New Zealand|Chennai|		