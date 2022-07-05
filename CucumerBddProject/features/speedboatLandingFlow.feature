@RegressionTest @Speedboat
Feature: Speedboat Flow
  Executes all test scenarios for verifying functionality of Maldives flow.

Scenario Outline: User flow - Verify navigation to Maldives home page
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected

  Examples: 
    |region|
    |Maldives|
    
Scenario Outline: User flow - Verify costing from Maldives landing page with default duration and group type 
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|
    |Maldives|Chennai|
    |Maldives|Outside India|
    |Maldives|Flights Booked|
    
Scenario Outline: User flow - Verify costing from Maldives landing page with user given duration and group type 
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Enter the duration of stay as "<duration>"
  And Enter the group type as "<groupType>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|duration|groupType|
    |Maldives|Chennai|1|Family|
    |Maldives|Delhi|2|Family|
    |Maldives|Kolkata|3|Family|
    |Maldives|Bengaluru|1|Friends|
    |Maldives|Mumbai|2|Friends|
    |Maldives|Chennai|3|Friends|
    |Maldives|Delhi|1|Solo|
    |Maldives|Kolkata|2|Solo|
    |Maldives|Bengaluru|3|Solo|
    
 Scenario Outline: User flow - Verify costing from Maldives landing page with user duration as 5 or above nights and any group type 
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Enter the duration of stay as "<duration>"
  And Enter the group type as "<groupType>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|duration|groupType|
    |Maldives|Chennai|6|Family|
    |Maldives|Hyderabad|7|Family|
    |Maldives|Kolkata|8|Family|
    |Maldives|Bengaluru|9|Family|
    |Maldives|Mumbai|10|Family| 
    
  Scenario Outline: User flow - Verify costing from Maldives landing page with custom room configuration
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Add rooms to the itinerary with group type and additional room count as "<groupType>","<roomCount>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|groupType|roomCount|
    |Maldives|Chennai|Family|1|
    |Maldives|Hyderabad|Family|2|
    |Maldives|Kolkata|Family|3|
    |Maldives|Bengaluru|Family|4|
 
 Scenario Outline: User flow - Verify costing from Maldives landing page with default duration and user given pax count 
  Given Login as a authenticated user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Enter the group type as "<groupType>"
  And Enter the room config with adult and child count as "<adultCount>","<childCount>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

    Examples: 
    |region|departFrom|groupType|adultCount|childCount|
    |Maldives|Chennai|Family|2|1|
    |Maldives|Delhi|Family|2|2|
    |Maldives|Kolkata|Family|3|1|
    |Maldives|Bengaluru|Friends|3|2|
    
 Scenario Outline: Admin flow - Verify costing from Maldives landing page with default duration and group type 
  Given Login as a authenticated admin user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|
    |Maldives|Chennai|
    |Maldives|Outside India|
    |Maldives|Flights Booked|
    
Scenario Outline: Admin flow - Verify costing from Maldives landing page with user given duration and group type 
  Given Login as a authenticated admin user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Enter the duration of stay as "<duration>"
  And Enter the group type as "<groupType>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|duration|groupType|
    |Maldives|Chennai|1|Family|
    |Maldives|Delhi|2|Family|
    |Maldives|Kolkata|3|Family|
    |Maldives|Bengaluru|1|Friends|
    |Maldives|Mumbai|2|Friends|
    |Maldives|Chennai|3|Friends|
    |Maldives|Delhi|1|Solo|
    |Maldives|Kolkata|2|Solo|
    |Maldives|Bengaluru|3|Solo|
    
 Scenario Outline: Admin flow - Verify costing from Maldives landing page with user duration as 5 or above nights and any group type 
  Given Login as a authenticated admin user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Enter the duration of stay as "<duration>"
  And Enter the group type as "<groupType>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|duration|groupType|
    |Maldives|Chennai|6|Family|
    |Maldives|Hyderabad|7|Family|
    |Maldives|Kolkata|8|Family|
    |Maldives|Bengaluru|9|Family|
    |Maldives|Mumbai|10|Family| 
    
  Scenario Outline: Admin flow - Verify costing from Maldives landing page with custom room configuration
  Given Login as a authenticated admin user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Add rooms to the itinerary with group type and additional room count as "<groupType>","<roomCount>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

  Examples: 
    |region|departFrom|groupType|roomCount|
    |Maldives|Chennai|Family|1|
    |Maldives|Hyderabad|Family|2|
    |Maldives|Kolkata|Family|3|
    |Maldives|Bengaluru|Family|4|
 
 Scenario Outline: Admin flow - Verify costing from Maldives landing page with default duration and user given pax count 
  Given Login as a authenticated admin user
  And Navigate to landing page for "<region>"
  Then Verify that landing page is loaded as expected
  Then Enter the departure location as "<departFrom>"
  And Enter the departure date
  And Enter the group type as "<groupType>"
  And Enter the room config with adult count and child count as "<adultCount>","<childCount>"
  Then Search for all available packages
  Then Verify that valid results are displayed in listing page

    Examples: 
    |region|departFrom|groupType|adultCount|childCount|
    |Maldives|Chennai|Family|2|1|
    |Maldives|Delhi|Family|2|2|
    |Maldives|Kolkata|Family|3|1|
    |Maldives|Bengaluru|Friends|3|2|
