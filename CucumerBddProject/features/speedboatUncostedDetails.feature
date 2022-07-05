#This feature file covers all scenarios for the uncosted resort details page in Maldives flow#

@RegressionTest @Speedboat
Feature: Speedboat Uncosted Resort Details Flow

  Scenario Outline: User flow - Choose resorts from all categories in landing page and cost them
    Given Login as a authenticated user
    And Navigate to landing page for "<region>"
    And Verify that landing page is loaded as expected
    Then Click on a resort card for the category "<category>"
    And Verify that resort details page is opened
    Then Click on Check Availability button
    And Enter the departure location as "<depChoice>"
    And Enter the departure date
    Then Click on Search available packages
    And Verify that valid results are displayed in costed details page
    
  	Examples: 
	    |region|category|depChoice|
	    |Maldives|For the Honeymooners|Chennai|
	    |Maldives|Best Overwater Villa|Delhi|
	    |Maldives|Kid Friendly Resorts|Kolkata|
	    |Maldives|Great Induan Food|Bengaluru|
	    |Maldives|Seaplane Only|Mumbai|
	    |Maldives|Closest to Airport|Chennai|


