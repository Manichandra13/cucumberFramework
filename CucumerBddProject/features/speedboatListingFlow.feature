@RegressionTest @Speedboat
Feature: Speedboat Listing Page Flow
  Executes all test scenarios for verifying functionality of listing page in Maldives flow.


Scenario Outline: User flow - Verify results in Maldives listing page with price filter options
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page
  Then Click on the price filter
  And Choose price range per person as "<priceRange>"
  Then Verify that results are shown for price range "<priceRange>"

  Examples: 
    |region|departFrom|priceRange|
    |Maldives|Chennai|50to70k|
    |Maldives|Delhi|70to80k|
    |Maldives|Kolkata|Above80k|
    |Maldives|Chennai|70to80k+Above80k|


Scenario Outline: User flow - Verify results in Maldives listing page with star category filter options
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page
  Then Click on the star category filter
  And Choose star category as "<starCategory>"
  Then Verify that results are shown for star category "<starCategory>"

  Examples: 
    |region|departFrom|starCategory|
    |Maldives|Chennai|3 Star|
    |Maldives|Delhi|4 Star|
    |Maldives|Kolkata|5 Star|
    |Maldives|Kolkata|4 Star+5 Star|
    
 Scenario Outline: User flow - Verify results in Maldives listing page with villa type filter options
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page
  Then Click on the villa type filter
  And Choose villa type as "<villaType>"
  Then Verify that results are shown for villa type "<villaType>"

  Examples: 
    |region|departFrom|villaType|
    |Maldives|Chennai|Water Villa|
    |Maldives|Delhi|Beach Bungalow|
    |Maldives|Kolkata|Split Stay|
    |Maldives|Kolkata|Family Villa|
    |Maldives|Kolkata|Garden Villa|
    |Maldives|Kolkata|Water Villa+Split Stay|
    
 Scenario Outline: User flow - Verify results in Maldives listing page with meal types filter options
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page
  Then Click on the meal type filter
  And Choose meal type as "<mealType>"
  Then Verify that results are shown for meal type "<mealType>"

  Examples: 
    |region|departFrom|mealType|
    |Maldives|Chennai|Half Board|
    |Maldives|Delhi|Full Board|
    |Maldives|Kolkata|All Inclusive|
    |Maldives|Kolkata|Breakfast Only|
    |Maldives|Kolkata|Full Board+All Inclusive|
    
 Scenario Outline: User flow - Verify results in Maldives listing page with other filter options
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page
  Then Click on the Others filter
  And Choose filter type as "<otherType>"
  Then Verify that results are shown for the filter "<otherType>"

  Examples: 
    |region|departFrom|otherType|
    |Maldives|Chennai|For the Honeymooners|
    |Maldives|Delhi|Best Overwater Villa|
    |Maldives|Kolkata|Kid Friendly Resorts|
    |Maldives|Chennai|Great Indian Food|
    |Maldives|Delhi|Seaplane Only|
    |Maldives|Kolkata|Closest to Airport|
    |Maldives|Delhi|For the Honeymooners+Seaplane Only|
    
  Scenario Outline: User flow - Verify results in Maldives listing page by modifying GCM details - Departure City
    Given Login as a authenticated user
	  And Navigate to landing page for "<region>"
	  Then Verify that landing page is loaded as expected
	  Then Enter the departure location as "<departFrom>"
	  And Enter the departure date
	  Then Search for all available packages
	  Then Verify that valid results are displayed in listing page
	  Then Click on the GCM pill
	  And Enter the departure location as "<depChoice>"
	  Then Click on Search available packages
	  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|depChoice|
    |Maldives|Chennai|Delhi|
    |Maldives|Delhi|Kolkata|
  