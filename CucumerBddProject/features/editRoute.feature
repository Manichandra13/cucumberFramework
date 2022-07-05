@ItineraryFlow @RegressionTest @Set1
Feature: Edit Route Modal in the itinerary 
 Validate the functionality of each element in the edit route modal
 
 
@RegressionTest @SmokeTest
 Scenario Outline: Validate the edit route modal by removing the city 
  Given Login as a authenticated admin user 
  And user validates the costing flow for "<region>" 
 Then validate that the itinerary is created succesfully 
 Then Click on customize option and validate if the city is removed or not
 
 
 Examples:
 |region|
 |Rome|
 
 
@RegressionTest @SmokeTest
Scenario Outline: Validate the edit route modal by Adding the city 
  Given Login as a authenticated admin user 
  And user validates the costing flow for "<region>" 
 Then validate that the itinerary is created succesfully 
 Then Click on customize option and validate if the city is added or not
 
 
 Examples:
 |region|
 |Rome|
 
@RegressionTest @SmokeTest
 Scenario Outline: Validate the edit route modal by Replacing the city 
 Given Login as a authenticated admin user 
  And user validates the costing flow for "<region>" 
 Then validate that the itinerary is created succesfully 
 Then Click on customize option and validate if the city is replaced by another city or not
 
 
 Examples:
 |region|
 |Rome|
 
 @RegressionTest @SmokeTest
 Scenario Outline: Validate the edit route modal by adding a night
  Given Login as a authenticated admin user 
  And user validates the costing flow for "<region>" 
 Then validate that the itinerary is created succesfully 
 Then Click on customize option and validate if the night is added or not
 
 
 Examples:
 |region|
 |Rome|
 
@RegressionTest @SmokeTest 
 Scenario Outline: Validate the edit route modal by removing a night
  Given Login as a authenticated admin user 
  And user validates the costing flow for "<region>" 
 Then validate that the itinerary is created succesfully 
 Then Click on customize option and validate if the night is removed or not
 
 
 Examples:
 |region|
 |Rome|
 