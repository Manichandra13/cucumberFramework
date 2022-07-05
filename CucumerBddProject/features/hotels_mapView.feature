@FAS @Hotels @InclusionsFlow @RegressionTest @Set2

Feature: Hotel - Map view filter validation across the Product


#Login as admin user and  validate that 
#No of hotels displayed in the header and actual no of hotels are equal
#Remove Hotel
#Add Hotel 
@SmokeTest @RegressionTest @PostBuild
Scenario Outline: Admin Flow of Hotel validation
	Given Login as a authenticated admin user 
	And  user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And  user fills the GCM form 
	And  Check an itinerary got successfully costed 
	Then validate that the Hotel section is displayed 
	Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary 
	And user views the details of the hotel 
	Then user removes the hotel and confirms
	And user Adds an hotel 
	Then validates hotel added succesfully
	
	Examples: 
		|region|
		|Rome|
		

#Login as Registered  user and  validate that 
#No of hotels displayed in the header and actual no of hotels are equal
#Remove Hotel does not exist
#Change the existing hotel to other hotel 
@SmokeTest @RegressionTest
Scenario Outline: User Flow of hotel Validation 
	Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	Then validate that the Hotel section is displayed 
	Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary 
	And user views the details of the hotel 
	And user changes the hotel and select an alternative
	Then validates hotel added succesfully
	
	Examples: 
		|region|
		|Rome|

	
		
		
#Login as Registered  user and  validate that 
#No of hotels displayed in the header and actual no of hotels are equal
#Remove Hotel does not exist
#Change the existing hotel to other hotel 
@SmokeTest @RegressionTest
Scenario Outline: Hotel smart filters Validation
	Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	Then validate that the Hotel section is displayed 
	Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary 
	And check hotel options available in the alternate
	And user applies the pyt smart filters 
	
	
	Examples: 
		|region|
		|Europe|

Scenario Outline: User Update Room Validation
    Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And user views the details of the hotel 
	And user change the room
	Then validate the room changed successfully	
	Examples: 
		|region|
		|Europe|
			
			

# This scenario includes 4 test cases, users clicks 2 star , 3 star, 4 star , 5 star and verify the filter applied successfully by using filter tag in that page 
Scenario Outline: Hotel Star Filters Validation In Hotel Alternate Page
	Given Login as a authenticated user
    And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And check hotel options available in the alternate
	Then apply the star filters and validate the filter applied succesfully
	
	
	
	Examples: 
		|region|
		|Europe|

# This scenario includes 3 test cases, user click the free breakfast filter, free Wifi filter and AC filter 	
Scenario Outline: Validate The Inclusions Filters In Hotel Alternate Page- Free BF,Free wifi, AC filter
	Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And check hotel options available in the alternate
	Then apply the inclusions filters in hotel alternate and validate the filter applied successfully		
		
	Examples: 
		|region|
		|Europe|



#Validation of refundable and non refundable filter , This scenarion includes 2 test cases
Scenario Outline: Refundable and Non-Refundable Filter Validation 
	Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And check hotel options available in the alternate
	Then apply the refundable filter in map view and validate the filter applied succesfully		
		
	Examples: 
		|region|
		|Europe|



# This scenario includes 6 test cases 
Scenario Outline: Hotel type Filters Validation Hotel Alternate Page including- hotel, unique stay, budget, Apartment, privatepool vila filter
	Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And check hotel options available in the alternate
	Then apply the hotel filter in map view and validate the filter applied succesfully		
		
	Examples: 
		|region|
		|Europe|
		




Scenario Outline: Pyt Exclusive Filter-Admin feature
  Given Login as a authenticated admin user 
  And user validates the costing flow for "<region>" 
  Then validate that the itinerary is created succesfully 
  And user fills the GCM form 
  And Check an itinerary got successfully costed  
  And validate that the Hotel section is displayed 
  And check hotel options available in the alternate
  Then apply the exclusive filter and validate the filter applied succesfully		
		
	Examples: 
   | region | 
   |Australia|
   
   
# This scenario includes 2 test case 
Scenario Outline: Apply The Sorting To The Hotels In Hotel Alternate - Chepeast First Sort, High Rated Sort
	Given Login as a authenticated user
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And check hotel options available in the alternate
    Then apply sorting and validate the sort applied successfully
    
    Examples: 
		|region|
		|Australia|

		
 # This scenario includes 2 test case 
 Scenario Outline: Apply The Source Provider Filter 
	Given Login as a authenticated admin user 
	And user validates the costing flow for "<region>" 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And Check an itinerary got successfully costed  
	And validate that the Hotel section is displayed 
	And check hotel options available in the alternate
	Then apply source provider filter and validate the appropriate source provider selected

	 Examples: 
		|region|
		|Australia|
		

