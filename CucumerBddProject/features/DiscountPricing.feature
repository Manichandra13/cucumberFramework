@RegressionTest @Pricing @DiscountPricing @Set1
Feature: Applying admin price for each line item

  #Hotel Scenario
  Scenario Outline: Verify if admin able to apply discount for a hotel
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Hotel section is displayed
    Then Validate that the edit icon is showing for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | lineitem         | category |
      | Europe   | Chennai    | all-hotel-panels | common   |

  Scenario Outline: Applied discount should be retained after changing the departure city for the hotel
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Hotel section is displayed
    Then Validate that the edit icon is showing for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region | departFrom | lineitem         | category |
      | Europe   | Chennai    | all-hotel-panels | common   |

  Scenario Outline: Applied discount should be retained after changing the arrival city
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Hotel section is displayed
    Then Validate that the edit icon is showing for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region | departFrom | lineitem         | category |
      | Europe   | Chennai    | all-hotel-panels | common   |

  #Flight Scenario
  #International flight scenarios
  Scenario Outline: Verify if admin able to apply discount for a International flight
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Flight section is displayed
    Then Validate that the edit icon is showing on "<flight>" for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | lineitem          | flight        | category |
      | Europe   | Chennai    | all-flight-panels | international | common   |

  Scenario Outline: Applied discount should not get retained after changing the departure city for international flight
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that the Flight section is displayed
    Then Validate that the edit icon is showing on "<flight>" for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for flight

    Examples: 
      | region | departFrom | lineitem          | flight        | category |
      | Europe   | Chennai    | all-flight-panels | international | common   |

  Scenario Outline: Verify if admin able to apply discount for a Internal flight
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that internal flight section is displaying
    Then Validate that the edit icon is showing on "<flight>" for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | flight   | category | lineitem          |
      | Europe | Chennai    | internal | internal | all-flight-panels |

  #Internal flight scenarios
  Scenario Outline: Applied discount should not get retained after changing the departure city for internal flight
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    Then validate that internal flight section is displaying
    Then Validate that the edit icon is showing on "<flight>" for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount not getting retained for a "<category>"

    Examples: 
      | region | departFrom | flight   | category | lineitem          |
      | Europe | Chennai    | internal | internal | all-flight-panels |

  #Activity scenario
  Scenario Outline: Verify if admin able to apply discount for a activity
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Activity section is displayed
    Then Validate that the edit icon is showing on activity for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | lineitem            | category |
      | Europe | Chennai    | all-activity-panels | activity |

  Scenario Outline: Applied discount should be retained after changing the departure city for the activity
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Activity section is displayed
    Then Validate that the edit icon is showing on activity for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region | departFrom | lineitem            | category |
      | Europe | Chennai    | all-activity-panels | common   |

  Scenario Outline: Applied discount should be retained after changing the arrival city for the activity
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Activity section is displayed
    Then Validate that the edit icon is showing on activity for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region | departFrom | lineitem            | category |
      | Europe | Chennai    | all-activity-panels | common   |

  #Transfer scenario
  #Train scenario
  Scenario Outline: Verify if admin able to apply discount for a train
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Train section is displayed
    Then validate that the edit icon is showing on train for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region | departFrom | lineitem            | category |
      | Europe   | Chennai    | all-transfer-panels | train    |

  Scenario Outline: Applied discount should be retained after changing the departure city for the train
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Train section is displayed
    Then validate that the edit icon is showing on train for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region | departFrom | lineitem            | category |
      | Europe   | Chennai    | all-transfer-panels | train    |

  Scenario Outline: Applied discount should be retained after changing the arrival city for the train
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    Then validate that the Train section is displayed
    Then validate that the edit icon is showing on train for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region | departFrom | lineitem            | category |
      | Europe   | Chennai    | all-transfer-panels | train    |

  #airport-Hotel transfer
  Scenario Outline: Verify if admin able to apply discount for a airport-hotel transfer
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on airport-hotel transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region    | departFrom | lineitem            | category   |
      | Australia | Chennai    | all-transfer-panels | AHtransfer |

  Scenario Outline: Applied discount should be retained after changing the departure city for the airport-hotel transfer
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on airport-hotel transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region    | departFrom | lineitem            | category   |
      | Australia | Chennai    | all-transfer-panels | AHtransfer |

  Scenario Outline: Applied discount should be retained after changing the arrival city for the airport-hotel transfer
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on airport-hotel transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region    | departFrom | lineitem            | category   |
      | Australia | Chennai    | all-transfer-panels | AHtransfer |

  Scenario Outline: Applied discount should not get retained after changing the transfer type
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on airport-hotel transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the transfer type of AH transfer
    Then validate that the applied discount not getting retained for a "<category>"

    Examples: 
      | region    | departFrom | lineitem            | category   |
      | Australia | Chennai    | all-transfer-panels | AHtransfer |

  #Rental car scenario
  Scenario Outline: Verify if admin able to apply discount for a rental car
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on rental car transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing

    Examples: 
      | region      | departFrom | lineitem            | category  |
      | New Zealand | Chennai    | all-transfer-panels | rentalcar |

  Scenario Outline: Applied discount should be retained after changing the departure city for Rental car
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on rental car transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the departure city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region      | departFrom | lineitem            | category  |
      | New Zealand | Chennai    | all-transfer-panels | rentalcar |

  Scenario Outline: Applied discount should be retained after changing the arrival city for Rental car
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing on rental car transfer for applying admin price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify the admin price label is showing
    Then change the arrival city and update cost
    Then validate that the applied discount got retained for a line item

    Examples: 
      | region      | departFrom | lineitem            | category  |
      | New Zealand | Chennai    | all-transfer-panels | rentalcar |

  #Scenario Outline: User flow - Verify costing from Bali landing page with custom room configuration
    #Given Login as a authenticated admin user
    #And Navigate to landing page for bali "<region>"
    #Then Verify that landing page is loaded as expected for Bali
    #Then Enter the departure location as  for bali "<departFrom>"
    #And Enter the departure date for bali
    #And Add rooms to the bali itinerary with group type and additional room count as "<groupType>","<roomCount>"
    #Then Search for all available packages for bali
    #Then Verify that valid results are displayed in listing page
    #And Click on Hotel card
    #Then Verify the appearance of inclusions page
    #Then validate that the Hotel section is displayed
    #Then Validate that the edit icon is showing for applying admin price
#
    #Examples: 
      #| region | departFrom | groupType | roomCount |
      #| Bali   | Chennai    | Family    |         2 |

  Scenario Outline: Verify if admin able to apply overall discount for an itinerary
    Given Login as a authenticated admin user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form for "<departFrom>"
    And Check an itinerary got successfully costed
    And user clicks inclusion page
    And validate that the edit icon is showing for applying overall discount price
    Then select the options from the dropdown in the rate match modal "<lineitem>" for the "<category>"
    Then verify if the discount is applied for entire itinerary

    Examples: 
      | region      | departFrom | lineitem    | category |
      | New Zealand | Chennai    | all-summary | price    |
