@FAS @RegressionTest @CostingFlow
Feature: Verify the costing flow across the product

  Scenario Outline: Validate the costing flow time period across the product.
    Given Login as a authenticated user
    And user validates the costing flow for "<region>"
    Then validate that the itinerary is created succesfully
    And user fills the GCM form
    And user validates the costing time period for "<region>"

    Examples: 
      | region      |
      #| Bali        |
      | Europe      |
      | Australia   |
      | New Zealand |
      | Thailand    |
