@FAS @AdminFlow @PostBuild @RegressionTest @Set1
Feature: Admin Itinerary Flow 
 Verify the itinerary flow across the product

            

@SmokeTest @RegressionTest
Scenario Outline: Admin Flow Inclusions Page Validation 
Given Login as a authenticated admin user
 And user validates the costing flow for "<region>"
 Then validate that the itinerary is created succesfully
And user fills the GCM form for "<departFrom>"
 And user clicks inclusion page
 Then validate that the Flight section is displayed
 Then validate that the Hotel section is displayed
 Then validate that the Activity section is displayed
 Then validate that the Transfer section is displayed
 Then validate that the Visa and insurance section is displayed
 Then validate that the Summary section is displayed
 Then validate that the Pass section is displayed
  Examples:
 |region|departFrom|
 |Rome|Chennai|



#scenario will check for the admin features available
@SmokeTest @RegressionTest
Scenario Outline: End to End user PDG flow validation
 Given Login as a authenticated admin user
 And user validates the costing flow for "<region>"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin      
 Examples:
 |region|
 |Europe|
 
 #scenario will validate the share itinerary admin features available
 @SmokeTest @RegressionTest
Scenario Outline: End to End user PDG flow validation
 Given Login as a authenticated admin user
 And user validates the costing flow for "<region>"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin

          
 Examples:
 |region|
 |Australia|
 
  #Enable Split Pricing
 @SmokeTest @RegressionTest
 Scenario: Admin split pricing workflow validation
 Given Login as a authenticated admin user
 And user validates the costing flow for "Australia"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin
Then Validate the split pricing workflow

 # Share itinerary WorkFlow 
 @SmokeTest @RegressionTest
 Scenario: Admin share Itinerary validation
 Given Login as a authenticated admin user
 And user validates the costing flow for "Australia"
 Then validate that the itinerary is created succesfully
 And user fills the GCM form
 Then Validate the admin Features 1 send to plato 2 Get Better Cost 3 Share Itinerary 4 Share PDF 5 CAncelation policy for admin
Then Validate the share itinerary workflow


 
 
 
 
 
 
 