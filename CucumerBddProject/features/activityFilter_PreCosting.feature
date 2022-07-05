@Activities @RegressionTest @Set1
Feature: Filter validation of Activity filter - Pre Costing

  Scenario Outline: Activity Filter Validation Slot Wise For Time Slot Filters
    Given Login as a authenticated user
    #Commenting the recently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    #	And user clicks the package itinerary from home page
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user clicks the activity slot "<slot>"
    And verify all filters from "<filterType>"
    Then apply "<slot>" filter and validate the filter applied successfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user clicks the activity slot "<slot>"
    Then apply "<slot>" filter and validate the filter applied successfully

    Examples: 
      | region    | slot            | filterType |
      | Australia | Morning         | timeslot   |
      | Australia | Noon            | timeslot   |
      | Australia | Evening         | timeslot   |
      | Europe    | Morning to Noon | timeslot   |
      | Europe    | Noon to Evening | timeslot   |
      | Europe    | Full Day        | timeslot   |

  Scenario Outline: Activity Filter Validation Slot Wise For Activity Duration Filter
    Given Login as a authenticated user
    #Commenting the recently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    #And user clicks the package itinerary from home page
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user clicks the activity slot "<slot>"
    And verify all filters from "<filterType>"
    Then apply "<filterValue>" filter and validate the filter applied successfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user clicks the activity slot "<slot>"
    Then apply "<filterValue>" filter and validate the filter applied successfully

    Examples: 
      | region    | slot            | filterType        | filterValue |
      | Europe    | Morning         | activity duration | Quarter Day |
      | Australia | noon            | activity duration | Half Day    |
      | Europe    | Evening         | activity duration | Full Day    |
      | Europe    | Morning to Noon | activity duration | Quarter Day |
      | Australia | Noon to Evening | activity duration | Half Day    |
      | Europe    | Full Day        | activity duration | Full Day    |

  Scenario Outline: Activity Filter Validation Slot Wise For Transfer Filter
    Given Login as a authenticated user
    #Commenting the recently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    #And user clicks the package itinerary from home page
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user clicks the activity slot "<slot>"
    And verify all filters from "<filterType>"
    Then apply "<filterValue>" filter and validate the filter applied successfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user clicks the activity slot "<slot>"
    Then apply "<filterValue>" filter and validate the filter applied successfully

    Examples: 
      | region    | slot            | filterType | filterValue  |
      | Europe    | Morning         | transfer   | Included     |
      | Australia | noon            | transfer   | Not Included |
      | Europe    | Evening         | transfer   | Not Included |
      | Australia | Morning to Noon | transfer   | Included     |
      | Europe    | Noon to Evening | transfer   | Not Included |
      | Australia | Full Day        | transfer   | Not Included |

  Scenario Outline: Activity Filter Validation Slot Wise For Group Type
    Given Login as a authenticated user
    #Commenting the recently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    #And user clicks the package itinerary from home page
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user clicks the activity slot "<slot>"
    And verify all filters from "<filterType>"
    Then apply "<filterValue>" filter and validate the filter applied successfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user clicks the activity slot "<slot>"
    Then apply "<filterValue>" filter and validate the filter applied successfully

    Examples: 
      | region    | slot            | filterType | filterValue |
      | Australia | Morning         | group type | Shared      |
      | Europe    | noon            | group type | Private     |
      | Australia | Evening         | group type | Shared      |
      | Europe    | Morning to Noon | group type | Shared      |
      | Australia | Noon to Evening | group type | Private     |
      | Europe    | Full Day        | group type | Shared      |

  Scenario Outline: Activity Filter Validation Slot Wise For  Interest Filter
    Given Login as a authenticated user
    #Commenting the recently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    #And user clicks the package itinerary from home page
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user clicks the activity slot "<slot>"
    And verify all filters from "<filterType>"
    Then apply "<filterValue>" filter and validate the filter applied successfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user clicks the activity slot "<slot>"
    Then apply "<filterValue>" filter and validate the filter applied successfully

    Examples: 
      | region    | slot            | filterType | filterValue         |
      | Australia | Morning         | interest   | Art & Culture       |
      | Europe    | noon            | interest   | Adventure & Outdoor |
      | Australia | Evening         | interest   | Food & Nightlife    |
      | Europe    | Morning to Noon | interest   | Shopping & Leisure  |
      | Australia | Noon to Evening | interest   | Art & Culture       |
      | Europe    | Full Day        | interest   | Adventure & Outdoor |

  Scenario Outline: Activity Filter Validation Slot Wise For Other Filter
    Given Login as a authenticated user
    #Commenting the recently booked itinerary step since its removed in homepage revamp
    #And user clicks recently booked itinerary
    #And user clicks the package itinerary from home page
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user clicks the activity slot "<slot>"
    And verify all filters from "<filterType>"
    Then apply "<filterValue>" filter and validate the filter applied successfully
    And user fills the GCM form
    And Check an itinerary got successfully costed
    And user navigate to itinerary page
    And user clicks the activity slot "<slot>"
    Then apply "<filterValue>" filter and validate the filter applied successfully

    Examples: 
      | region    | slot            | filterType | filterValue        |
      | Australia | Morning         | other      | Top Highlight      |
      | Europe    | noon            | other      | Kid Friendly       |
      | Australia | Evening         | other      | Fast Selling       |
      | Europe    | Morning to Noon | other      | Less explored gems |
      | Australia | Noon to Evening | other      | Self Exploration   |
      | Europe    | Full Day        | other      | Top Highlight      |
