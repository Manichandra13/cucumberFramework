@FAS @Sandune @RegressionTest @Set3
Feature: Sandune Flow
Validation of airport-hotel and hotel-airport transfer type

  #This testcase is to verify the transfer type as Private
  Scenario Outline: End to End user PDG flow validation for sandune
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    Then validate that the Transfer section is displayed
    Then validate that the user able to change the transfer type "<transfer_type>"

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details | transfer_type |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     | Private       |

  #This testcase is to verify the transfer type as Shared
  Scenario Outline: End to End user PDG flow validation for sandune
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User navigates from itinerary to inclusion page
    Then validate that the Transfer section is displayed
    Then validate that the user able to change the transfer type "<transfer_type>"

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details | transfer_type |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     | shared        |
