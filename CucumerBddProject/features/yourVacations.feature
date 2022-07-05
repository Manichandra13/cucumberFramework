@FAS @CustomerEnagagement @RegressionTest @Set3
Feature: Verify the Your vacations page scenarios 

#Validating the Your vacations page
@SmokeTest
Scenario: Existing User Login From Home Page Should Redirect To Your Vacations Page 
	When Login as a authenticated user without redirect to homepage 
	Then validate the user land on your vacations page 
	

	
#Deleting the saved itinerary as a user
Scenario: User Delete The Saved Itinerary From Your Vacations Page 
	Given Login as a authenticated user without redirect to homepage 
	When  validate the user land on your vacations page 
	And   user opens saved itinerary 
	And   user rename the itinerary 
	And   user delete the itinerary 
	Then  validate the itinerary got deleted successfully 
	
	#Renaming the saved itinerary as a user
Scenario: User Rename The Saved Itinerary From Your Vacations Page 
	Given Login as a authenticated user without redirect to homepage 
	When  validate the user land on your vacations page 
	And   user opens saved itinerary 
	And   user rename the itinerary 
	Then  validate the itinerary got renamed successfully
	
Scenario: Verify The Booked Itinerary From Your Vacations Page 
	Given Login as a authenticated user without redirect to homepage 
	When  validate the user land on your vacations page 
	And   user opens the booked itinerary in your vacations page 
	Then  validate the itinerary shouldn't customizable 
	
Scenario: User Selects The Saved itinerary And Updating The Cost Of The Itinerary 
	Given Login as a authenticated user without redirect to homepage 
	When  validate the user land on your vacations page 
	And   user opens saved itinerary 
	And   select the itinerary from saved itinerary page 
	Then  do update cost if the itinerary is stale costed 
	 
	
Scenario Outline: Verify After First Payment User Should Redirect to Your Vacations Page 
	Given Login as a authenticated user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user fills the GCM form 
	And user checks all the alerts and clicks continue to book 
	And get the itinerary id
	And user fills in the passenger details 
    Then user Verifies if there is any sold out line item in the live price screen
    And user makes the first payment 
	And user fills the card details and make payment 
	Then validate that the payment is success 
	Then user should redirect to your vacations page from payment success page 
	
	Examples: 
		|region|
		|Europe|
		
Scenario: Verify User Can Able To Make Second Payment From Your Vacations Page 
	Given Login as a authenticated user without redirect to homepage 
	When  validate the user land on your vacations page 
	And   user navigates the booked itinerary in your vacations page
	And   user navigates to payment tab 
	And   user makes second payment from your vacations 
	And   user fills the card details and make payment 
	Then validate that the payment is success 
	Then user should redirect to your vacations page from payment success page 
	
	
Scenario: Verify User Can Able To Make Third Payment From Your Vacations Page 
	Given Login as a authenticated user without redirect to homepage 
	When  validate the user land on your vacations page 
	And   user navigates the booked itinerary in your vacations page
	And   user navigates to payment tab 
	And   user makes third payment from your vacations page 
	And   user fills the card details and make payment 
	Then  validate that the payment is success 
	Then  user should redirect to your vacations page from payment success page
	
	