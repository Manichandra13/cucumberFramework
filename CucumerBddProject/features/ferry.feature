@FAS @Transfers @InclusionsFlow @Ferry @RegressionTest @Set1
Feature: Ferry Flow 
 Verify the Ferry flow across the product

@SmokeTest @RegressionTest
Scenario Outline: Validate the ferry transfer in the Inclusion page
	Given Login as a authenticated admin user 
	And user validates the costing flow for ferry "<region>" 
	Then validate that the itinerary is created succesfully 
	And user chooses the alternate transfer as ferry in the Itinerary page
	And user fills the GCM form 
	And Check an itinerary got successfully costed
	And user clicks inclusion page
	Then validate that the Ferry section is displayed
	Then validate the ferry is changed

	Examples: 
		|region|
		|Thailand|