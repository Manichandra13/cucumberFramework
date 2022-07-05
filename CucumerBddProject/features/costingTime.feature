@RegressionTest @CostingFlow
Feature: Verify the costing flow average time across the product



Scenario Outline: Validate the costing flow time period across the product
    When calculate the costing time"<region>","<departFrom>"
    Examples: 
     | region      |departFrom|
     #| Bali        |Chennai|
     | Europe      |Chennai|
     | Australia   |Chennai|
     | New Zealand |Chennai|
     | Thailand    |Chennai|
