@FAS @CustomerEngagement @RegressionTest @Testimonial @Set2
Feature: Testimonial Feature 
	Verify that the testimonial feature validation across the product
	
#This test case validates the landing page testimonials
#landing page testimonials Flow changed completely, Need to write new test cases
#@RegressionTest @test
#Scenario: Testimonials Validation from Landing page 
#Then User validates the testimonial from landing page  
#
#This test case validates the packages page testimonials
#
#@RegressionTest	
#Scenario: Testimonials Validation from Packages page 
#Then User validates the testimonial from packages page 
#
#This test case validates the vacations page testimonials
#
#@SmokeTest @RegressionTest @Testimonial
#Scenario: Testimonials Validation from vacations page 
#Then User validates the testimonial from vacations page 

#This test case valdiates the combination of theme and region filter
@RegressionTest	@Testimonial1
Scenario Outline:Testimonial Filter Validation of trips for all Regions
Then User Validating Testimonial Filter for "<trip>" theme for different regions

Examples: 
		|trip|
		|Honeymoon|
		|Family|
		|Solo|
	  |Group|
		|All trips|

#This test case validates the reset filter
@RegressionTest		@SmokeTest
Scenario Outline:Testimonial Reset Filter Validation for trip
Then User Validating Testimonial Reset Filter for "<trip>" theme

Examples: 
		|trip|
		|Honeymoon|
		|Family|
		|Solo|
	  |Group|
		|All trips|

#This test case validates the rating/recent filter
@RegressionTest		
Scenario Outline: Testimonial Rating/Recent Filter Validation for trip
Then User Validating Testimonial Rating/Recent Filter for "<trip>" theme

Examples: 
		|trip|
		|Honeymoon|
		|Family|
		|Solo|
	  |Group|
		|All trips|		
		
		