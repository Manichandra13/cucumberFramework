@FAS @Sandune @RegressionTest @Set3
Feature: Validation of hotels flow for sandune - Common Filters

  #This testcase is to validate if the user able to remove the default hotel and add the new hotel for sandune flow
  @SmokeTest @PostBuild
  Scenario Outline: User validation for default hotel in an inclusion page under sandune flow
    Given Login as a authenticated admin user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user views the details of the hotel
    Then user removes the hotel and confirms
    And user Adds an hotel
    Then validates hotel added succesfully

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This testcase is to validate if the user able to add the split stay hotel for sandune flow
  @SmokeTest
  Scenario Outline: User adds the split stay hotel in an inclusion page under sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user adds the split stay hotel
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This testcase is to validate if the user able to delete the split stay hotel for sandune flow
  Scenario Outline: User delete the split stay hotel in an inclusion page under sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user adds the split stay hotel
    And user delete the split stay hotel selected

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     |

  #This testcase is to validate if the user able to add the split stay hotel at the beginning of stay for sandune flow
  Scenario Outline: User adds the split stay hotel at the beginning of stay under sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user selects the "<orderofstay>"
    Then user Validate that the split stay hotel is added according to the "<orderofstay>"

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details | orderofstay      |
      | dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     | at the beginning |

  #This testcase is to validate if the user able to add the split stay hotel at the end of stay for sandune flow
  Scenario Outline: User adds the split stay hotel at the end of stay under sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user selects the "<order of stay>"
    Then user Validate that the split stay hotel is added according to the "<orderofstay>"

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details | order_of_stay |
      | dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     | at the end    |

  #This testcase is to validate the duration of stay options for split stay hotel for sandune flow
  Scenario Outline: User Validates the duration of stay options for split stay under sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    Then user Validate that the duration option is less than the total duration of stay for split stay hotel

    Examples: 
      | region | dubai_month | dep_city | dep_date | no_of_nights | pax_details | order_of_stay |
      | dubai  | JAN         | Chennai  |       22 | 5 - 8 nights | Partner     | at the end    |

  #Login as admin user and  validate that
  #No of hotels displayed in the header and actual no of hotels are equal
  #Remove Hotel
  #Add Hotel
  @SmokeTest @RegressionTest @PostBuild
  Scenario Outline: Admin Flow of Hotel validation on sandune flow
    Given Login as a authenticated admin user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user views the details of the hotel
    Then user removes the hotel and confirms
    And user Adds an hotel
    Then validates hotel added succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #Login as Registered  user and  validate that
  #No of hotels displayed in the header and actual no of hotels are equal
  #Remove Hotel does not exist
  #Change the existing hotel to other hotel
  @SmokeTest @RegressionTest
  Scenario Outline: User Flow of hotel Validation on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And user views the details of the hotel
    And user changes the hotel and select an alternative
    Then validates hotel added succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #Login as Registered  user and  validate that
  #No of hotels displayed in the header and actual no of hotels are equal
  #Remove Hotel does not exist
  #Change the existing hotel to other hotel
  @SmokeTest @RegressionTest
  Scenario Outline: Hotel smart filters Validation on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    Then user compares no of hotels displayed in the container and against the number of hotel cards in the itinerary
    And check hotel options available in the alternate
    And user applies the pyt smart filters

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #This scenario includes 4 test cases, users clicks 2 star , 3 star, 4 star , 5 star and verify the filter applied successfully by using filter tag in that page on sandune flow
  Scenario Outline: Hotel Star Filters Validation In Hotel Alternate Page on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply the star filters and validate the filter applied succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #This scenario includes 3 test cases, user click the free breakfast filter, free Wifi filter and AC filter on sandune flow
  Scenario Outline: Validate The Inclusions Filters In Hotel Alternate Page- Free BF,Free wifi, AC filter on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply the inclusions filters in hotel alternate and validate the filter applied successfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #Validation of refundable and non refundable filter on sandune flow, This scenarion includes 2 test cases
  Scenario Outline: Refundable and Non-Refundable Filter Validation on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply the refundable filter in map view and validate the filter applied succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #This scenario includes 6 test cases
  Scenario Outline: Hotel type Filters Validation Hotel Alternate Page on sandune flow including- hotel, unique stay, budget, Apartment, privatepool vila filter on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply the hotel filter in map view and validate the filter applied succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  Scenario Outline: Pyt Exclusive Filter-Admin feature for sandune flow
    Given Login as a authenticated admin user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply the exclusive filter and validate the filter applied succesfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #This scenario includes 2 test case
  Scenario Outline: Apply The Sorting To The Hotels In Hotel Alternate - Chepeast First Sort, High Rated Sort on sandune flow
    Given Login as a authenticated user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply sorting and validate the sort applied successfully

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |

  #This scenario includes 2 test case
  Scenario Outline: Apply The Source Provider Filter on sandune flow
    Given Login as a authenticated admin user
    And User selects the region "<region>" from destination options
    #And User selects the departing city "<dep_city>" from the dropdown
    And User chooses the month "<dubai_month>" for the trip
    And User selects the departure date "<dep_date>"
    And User selects the no.of.nights "<no_of_nights>" stay options
    And User selects the passenger details "<pax_details>" for the trip
    And User selects the activities from the activities list
    Then User validates the itinerary is created successfully
    Then User Validate that the hotel section is displayed
    And check hotel options available in the alternate
    Then apply source provider filter and validate the appropriate source provider selected

    Examples: 
      | region | dubai_month | dep_date | no_of_nights | pax_details |
      | dubai  | JAN         |       22 | 5 - 8 nights | Partner     |
