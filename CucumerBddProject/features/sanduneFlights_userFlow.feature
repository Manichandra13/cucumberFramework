@FAS @Sandune @RegressionTest @HotelsFlights @Set3
Feature: Flights User Flow for sandune
  Verify the flights flow in sandune flow

  ### User flow scenarios ###
  #This test case verifies changing flights as a regular user in sandune flow
  @SmokeTest @PostBuild
  Scenario Outline: User Flow Change Flights Validation under sandune flow
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
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate changing the flight is done
    Then validate the flight change view

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies changing flights using smart filter option as a regular user in sandune flow
  @SmokeTest
  Scenario Outline: User Flow Change Flights With Smart Filter Validation under sandune flow
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
    Then validate that the Flight section is displayed
    Then validate whether Flight change is selected
    Then validate that smart filtered flight option is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a Direct flight using filter option as a regular user in sandune flow
  Scenario Outline: User Flow Choose Direct Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that direct flight option is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a 1-stop flight using the filter option as an admin user in sandune flow
  Scenario Outline: Admin Flow Choose One-Stop Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that one stop flight option is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a 2-stop flight using filter option as a regular user in sandune flow
  Scenario Outline: User Flow Choose Two-Stop Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that two stop flight option is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing an early morning international flight for onward journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Onward Early Morning Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that early morning flight option for onward journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing an early morning international flight for return journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Return Early Morning Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that early morning flight option for return journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a morning international flight for onward journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Onward Morning Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that morning flight option for onward journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a morning international flight for return journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Return Morning Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that morning flight option for return journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a mid-day international flight for onward journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Onward Mid-day Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that mid-day flight option for onward journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a mid-day international flight for return journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Return Mid-day Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that mid-day flight option for return journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a night international flight for onward journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Onward Night Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that night flight option for onward journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a night international flight for return journey as a regular user in sandune flow
  Scenario Outline: User Flow Choose Return Night Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that night flight option for return journey is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a refundable international flight as a regular user in sandune flow
  Scenario Outline: User Flow Choose Refundable Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that refundable option for flights is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This test case verifies choosing a non-refundable international flight as a regular user in sandune flow
  Scenario Outline: User Flow Choose Non Refundable Flights Validation under sandune flow
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
    Then validate whether Flight change is selected
    Then validate that non refundable option for flights is chosen succeffully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JUN         | Chennai  |       22 | 5 - 8 nights | Partner     |
