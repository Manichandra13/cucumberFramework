@FAS @Activities @RegressionTest @PostCosting @Set1
Feature: Filter validation of Activity filter - Post Costing 

Scenario Outline:
Activity Filter Validation For Time Slot Filters After costing In Inclusions page 
	Given Login as a authenticated user 
	#Commenting the rencently booked itinerary step since its removed in homepage revamp 
	#And user clicks recently booked itinerary
	And user clicks the package itinerary from home page 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	And validate that the Activity section is displayed 
	And user navigate to activity alternate page from the inclusions page 
	And verify all filters from "<filterType>" 
	Then apply "<slot>" filter and validate the filter applied successfully 
	
	Examples: 
		| filterType | slot    |
		| timeslot   | Morning |
		
Scenario Outline:
Activity Filter Validation For Activity Duration After costing In Inclusions page 
	Given Login as a authenticated user 
	#Commenting the rencently booked itinerary step since its removed in homepage revamp 
	And user clicks the package itinerary from home page 
	Then validate that the itinerary is created succesfully 
	And user fills the GCM form 
	And validate that the Activity section is displayed 
	And user navigate to activity alternate page from the inclusions page 
	And verify all filters from "<filterType>" 
	Then apply "<filterValue>" filter and validate the filter applied successfully 
	
	Examples: 
		| filterType        | filterValue |
		| activity duration | Quarter Day |
		
Scenario Outline:
Activity Filter Validation For Transfer After costing In Inclusions page 
	Given Login as a authenticated user 
	#Commenting the rencently booked itinerary step since its removed in homepage revamp 
	And user clicks the package itinerary from home page 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	And validate that the Activity section is displayed 
	And user navigate to activity alternate page from the inclusions page 
	And verify all filters from "<filterType>" 
	Then apply "<filterValue>" filter and validate the filter applied successfully 
	
	Examples: 
		| filterType | filterValue |
		| transfer   | Included    |
		
Scenario Outline:
Activity Filter Validation For Group Type After costing In Inclusions page 
	Given Login as a authenticated user 
	#Commenting the rencently booked itinerary step since its removed in homepage revamp 
	And user clicks the package itinerary from home page 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	And validate that the Activity section is displayed 
	And user navigate to activity alternate page from the inclusions page 
	And verify all filters from "<filterType>" 
	Then apply "<filterValue>" filter and validate the filter applied successfully 
	
	Examples: 
		| filterType | filterValue |
		| group type | Shared      |
		
Scenario Outline:
Activity Filter Validation For Interests After costing In Inclusions page 
	Given Login as a authenticated user 
	#Commenting the rencently booked itinerary step since its removed in homepage revamp 
	And user clicks the package itinerary from home page 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	And validate that the Activity section is displayed 
	And user navigate to activity alternate page from the inclusions page 
	And verify all filters from "<filterType>" 
	Then apply "<filterValue>" filter and validate the filter applied successfully 
	
	Examples: 
		| filterType | filterValue   |
		| interest   | Art & Culture |
		
Scenario Outline:
Activity Filter Validation For Other Filters After costing In Inclusions page 
	Given Login as a authenticated user 
	#Commenting the rencently booked itinerary step since its removed in homepage revamp 
	And user clicks the package itinerary from home page 
	And user fills the GCM form 
	And Check an itinerary got successfully costed 
	And validate that the Activity section is displayed 
	And user navigate to activity alternate page from the inclusions page 
	And verify all filters from "<filterType>" 
	Then apply "<filterValue>" filter and validate the filter applied successfully 
	
	Examples: 
		| filterType | filterValue      |
		| other      | Self Exploration |
