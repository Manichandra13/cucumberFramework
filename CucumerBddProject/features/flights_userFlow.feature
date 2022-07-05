@Flights @InclusionsFlow @RegressionTest @Set2
Feature: Flights User Flow 
 Verify the flights flow across the product

### User flow scenarios ###
#
#This test case verifies changing flights as a regular user
@SmokeTest @PostBuild
Scenario Outline: User Flow Change Flights Validation 
	Given Login as a authenticated user 
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
		|Europe|Chennai|
		

#This test case verifies changing flights using smart filter option as a regular user
@SmokeTest	
Scenario Outline: User Flow Change Flights With Smart Filter Validation 
	Given Login as a authenticated user 
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
		
#This test case verifies choosing a Direct flight using filter option as a regular user
	
Scenario Outline: User Flow Choose Direct Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that direct flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a 1-stop flight using the filter option as an admin user
	
Scenario Outline: Admin Flow Choose One-Stop Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate whether Flight change is selected
	Then validate that one stop flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a 2-stop flight using filter option as a regular user

Scenario Outline: User Flow Choose Two-Stop Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that two stop flight option is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing an early morning international flight for onward journey as a regular user

Scenario Outline: User Flow Choose Onward Early Morning Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that early morning flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|

#This test case verifies choosing an early morning international flight for return journey as a regular user

Scenario Outline: User Flow Choose Return Early Morning Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that early morning flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a morning international flight for onward journey as a regular user		

Scenario Outline: User Flow Choose Onward Morning Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate whether Flight change is selected
	Then validate that morning flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|

#This test case verifies choosing a morning international flight for return journey as a regular user

Scenario Outline: User Flow Choose Return Morning Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that morning flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
	#This test case verifies choosing a mid-day international flight for onward journey as a regular user

Scenario Outline: User Flow Choose Onward Mid-day Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that mid-day flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Australia|Chennai|

#This test case verifies choosing a mid-day international flight for return journey as a regular user
	
Scenario Outline: User Flow Choose Return Mid-day Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>"
	And Check an itinerary got successfully costed 
	Then validate whether Flight change is selected
	Then validate that mid-day flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
#This test case verifies choosing a night international flight for onward journey as a regular user

Scenario Outline: User Flow Choose Onward Night Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that night flight option for onward journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Australia|Chennai|

#This test case verifies choosing a night international flight for return journey as a regular user

Scenario Outline: User Flow Choose Return Night Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that night flight option for return journey is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
	
	
#This test case verifies choosing a refundable international flight as a regular user

Scenario Outline: User Flow Choose Refundable Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that refundable option for flights is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|

#This test case verifies choosing a non-refundable international flight as a regular user

Scenario Outline: User Flow Choose Non Refundable Flights Validation 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form for "<departFrom>" 
	And Check an itinerary got successfully costed
	Then validate whether Flight change is selected
	Then validate that non refundable option for flights is chosen succeffully

	Examples: 
		|region|departFrom|
		|Europe|Chennai|
		
		