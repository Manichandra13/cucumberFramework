@FAS @Transfers @InclusionsFlow @RegressionTest @RentalCar @Set3
Feature: Validatation of Rental car 

@SmokeTest
Scenario Outline: User Change The Rental Car From The Itinerary 
      Given Login as a authenticated user
      And user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And user fills the GCM form
      And Check an itinerary got successfully costed
      Then validate that the Transfer section is displayed
      And user click on transfer tab
      And change the rental car
      Then validate the rental car changed succesfully
    
    
   Examples: 
		|region|
		|New Zealand|

		
##TC-157
Scenario Outline: Verify The User Change The Insurance Type Of The Rental Car
      Given Login as a authenticated user
      And   user validates the costing flow for "<region>"
      Then  validate that the itinerary is created succesfully
      And   user fills the GCM form
      And   Check an itinerary got successfully costed
      Then  validate that the Transfer section is displayed
      Then  user change the insurance and validate the insurance applied successfully
      
    
    
   Examples: 
		|region|
		|New Zealand|
		

#TC-158
Scenario Outline: Economy Filter Validation For The Rental Car
      Given Login as a authenticated user
      And user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And user fills the GCM form
      And Check an itinerary got successfully costed
      Then validate that the Transfer section is displayed
      And  user click on transfer tab
      Then apply economy filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|   

#TC-159		
Scenario Outline: Compact Filter Validation For The Rental Car
     Given Login as a authenticated user
      And user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And user fills the GCM form
      And Check an itinerary got successfully costed
      Then validate that the Transfer section is displayed
      And user click on transfer tab
      Then apply compact filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|   

#TC-160
Scenario Outline: Value standard Filter Validation For The Rental Car
      Given Login as a authenticated user
      And user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And user fills the GCM form
      And Check an itinerary got successfully costed
      Then validate that the Transfer section is displayed
      And user click on transfer tab
      Then apply value standard filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|   
#TC-161
Scenario Outline: Standard Filter Validation For The Rental Car
      Given Login as a authenticated user
      And user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And user fills the GCM form
      And Check an itinerary got successfully costed
      And user click on transfer tab
      Then apply standard filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|   
		
#TC-162		
Scenario Outline: Value suv (awd) Filter Validation For The Rental Car
      Given Login as a authenticated user
      And user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And user fills the GCM form
      And Check an itinerary got successfully costed
      And user click on transfer tab
      Then apply value suv (awd) filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  

#TC-163		
Scenario Outline: Executive Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply executive filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  

#TC-164		
Scenario Outline: SUV Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply suv filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  

@SmokeTest
Scenario Outline: Intermediate 4×4 Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply intermediate filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  

#TC-166		
Scenario Outline: Large 4x4 Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply large filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  

#TC-167
Scenario Outline: Premium 4x4 Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply premium filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  
		
#TC-168
Scenario Outline: Eleven seater van Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply seater van filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  
		
 
#TC-169	
Scenario Outline: Suited For Five Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply suited for five filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  
		
#TC-170			
 Scenario Outline: Suited For Seven Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply suited for seven filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|  

#TC-171		
Scenario Outline: Suited For Eleven Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply suited for eleven filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand| 
		
#TC-172		
Scenario Outline: Automatic Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply automatic filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|   
#TC-173		
Scenario Outline: Air Conditioning Filter Validation For The Rental Car
      Given Login as a authenticated user
      And  user validates the costing flow for "<region>"
      Then validate that the itinerary is created succesfully
      And  user fills the GCM form
      And  Check an itinerary got successfully costed
      And  user click on transfer tab
      Then apply air conditioning filter and validate the filter applied successfully
   Examples: 
		|region|
		|New Zealand|   
 
		
