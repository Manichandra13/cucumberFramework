@CustomerEngagement @CBR @RegressionTest @Set1
Feature: Validating Call Back request Feature  

#Validation of existing user submission of CBR from the landing page 
@RegressionTest @SmokeTest
Scenario: Existing User Posting CBR From Landing Page
    Given Login as a authenticated user
    When  user click on talk to us button in lading page
    And   verify the name email and mobile number field disabled
    And   post cbr form
    Then  Verify the cbr posted successfully
 
##Commented out the scenario due to signup data dependency
####Validation of new user submission of CBR from the landing page should create new user
##@RegressionTest   
##Scenario Outline: New User Posting CBR From Landing Page 
##    Given user land on home page without login
##    When  user click on talk to us button in lading page
##    And   user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
##    And   post cbr form
##    Then  verify the user should logged in successfully
##    
##    Examples:
##    |name|mobileNumber|email|
##    |mobile|9992222234|email01@gamil.com|
##    
#    
#    
# 
#Validation of Existing user trying to submit the CBR form with new email and existing registered number
#Validation of Existing user trying to submit the CBR form with existing registered email and New number
@RegressionTest  
 Scenario Outline: Posting CBR With Combination of New And Registered Credential From Landing page
   Given user land on home page without login
    When user click on talk to us button in lading page
    And   user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
    And  post cbr form
    Then Validate the alert message
    Examples:
     |name|mobileNumber|email|
     |new email existing number|6383589200|qaemail903143@gsgs.com|
     |existing email new number|9578222121|meenatchi@pickyourtrail.com|
  

#
#Validation of existing user submission of CBR from the Itinerary page before costing 
@RegressionTest @SmokeTest
   Scenario: Existing User Posting CBR From Itinerary Before Costing 
	Given Login as a authenticated user 
	And   user clicks the package itinerary from home page 
	And   user opens the cbr from itinerary 
	And   verify the name email and mobile number field disabled 
	And   post cbr form 
	Then  Verify the cbr posted successfully from itinerary 
	
	
# #Commented out the scenario due to signup data dependency 
###Validation of new user submission of CBR from the itinerary page before costing should create new user
##@RegressionTest
## Scenario Outline: New User Posting CBR From Itinerary Page Before Costing 
##    Given user land on home page without login 
##	 And  user clicks recently booked itinerary
##	Then  validate that the itinerary is created succesfully 
##	And   user opens the cbr from itinerary 
##	And   user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
##	And   post cbr form 
##	Then  Verify the cbr posted successfully from itinerary 
##	Then  verify the user should logged in successfully
##    
##   Examples: 
##		|name|mobileNumber|email|
##		|New user cbr|9992222298|qaemail3450@gmail.com|
#		
#Validation of Existing user trying to submit the CBR form with New email and existing registered number from itinerary page before costing
#Validation of Existing user trying to submit the CBR form with existing registered email and New number from itinerary page before costing
@RegressionTest  
 Scenario Outline: Posting CBR With Combination of New And Registered Credential From Itinerary Page before costing 
    Given user land on home page without login
	And  user clicks the package itinerary from home page 
	And  user opens the cbr from itinerary 
	And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
	And  post cbr form 
	Then Validate the alert message 
      Examples: 
		|name|mobileNumber|email|
		|new email existing number|6383589200|qaemail903940@gsgs.com|
		|existing email new number|9578222121|meenatchi@pickyourtrail.com|
 
		

		
#Validation existing user posting CBR from itinerary page after costing 		
@RegressionTest @SmokeTest 
  Scenario Outline: Existing User Posting CBR From Itinerary Page After costing	
  	Given Login as a authenticated user
     When  user validates the costing flow for "<region>" 
     Then  validate that the itinerary is created succesfully 
     And  user fills the GCM form 
     And   Check an itinerary got successfully costed
     And  user navigate to itinerary page 
     And  user opens the cbr from itinerary 
     And  verify the name email and mobile number field disabled
     And  post cbr form
    Then  Verify the cbr posted successfully from itinerary 
     
	Examples: 
		|region|
		|Australia| 	
		
#Validation existing user posting CBR from inclusions page after costing 	
@RegressionTest 
	Scenario Outline: Existing User Posting CBR From Inclusions Page After costing
	 Given Login as a authenticated user		
     When  user validates the costing flow for "<region>" 
     Then  validate that the itinerary is created succesfully 
     And  user fills the GCM form 
     And  Check an itinerary got successfully costed
     And  user opens the cbr from inclusions 
     And  verify the name email and mobile number field disabled
     And  post cbr form
     Then Verify the cbr posted successfully from itinerary  
     
    Examples: 
		|region|
		|Europe| 
			
@RegressionTest	@SmokeTest	
 Scenario: Existing User Posting CBR From Packages Page		
	Given Login as a authenticated user
	And   user navigate to packages page
	When  user click on packages page cbr
	And   verify the name email and mobile number field disabled
    And   post cbr form
    Then  validate the user submitted the cbr successfully
 
##Commented out the scenario due to signup data dependency  
##@RegressionTest
##  Scenario Outline: New User Posting CBR From packages Page  
##  Given user navigate to packages page
##  When  user click on packages page cbr
##  And   user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
##  And   post cbr form 
##  Then validate the user submitted the cbr successfully
##  
##  Examples:
##  |name|mobileNumber|email|
##    |CBR|944700253|qaemail04@gsgs.com|
##  

#Existing User Posting CBR with New mail and Authenticated Number From Package Page
#Existing User Posting CBR With Authenticated Mail and New Number From Package Page
@RegressionTest
   Scenario Outline: Posting CBR With Combination of New And Registered Credential From Package Page
   Given user navigate to packages page
    When  user click on packages page cbr
    And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
    And  post cbr form
    Then Validate the alert message
     Examples:
     |name|mobileNumber|email|
     |new email existing number|6383589200|qaemail9037240@gsgs.com|
     |existing email new number|9578222121|meenatchi@pickyourtrail.com|

   
@RegressionTest	@SmokeTest
 Scenario: Existing User Posting CBR From Vacations Page		
	Given Login as a authenticated user
	When redirect to vacations page 
	And  user click on vacations page cbr
	And   verify the name email and mobile number field disabled
    And   post cbr form
    Then  validate the alert message in vacations cbr
    
## Commented out the scenario due to signup data dependency  
##@RegressionTest
##  Scenario Outline: New User Posting CBR From Vacations Page 
##  Given user land on home page without login
##  When Scroll down and click Explore Australia button in the landing page 
##  And   verify the user land on vacations page 
##  And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
##  And   post cbr form 
##  Then  validate the user submitted the cbr successfully
##  Then  verify the user should logged in successfully
##    Examples:
##    |name|mobileNumber|email|
##    |mobile|9344700267|email09@gamil.com|
## 
#
#
#Existing User Posting CBR with New mail and Authenticated Number From Vacations Page
#Existing User Posting CBR With Authenticated Mail and New Number From Vacations Page
@RegressionTest 
   Scenario Outline: Posting CBR With Combination of New And Registered Credential From Vacations Page
    Given user land on home page without login
    When redirect to vacations page
     And  user click on vacations page cbr
     And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
     And  post cbr form
     Then Validate the alert message
      Examples:
     |name|mobileNumber|email|
     |new email existing number|6383589200|qaemail90376240@gsgs.com|
     |existing email new number|9578222121|meenatchi@pickyourtrail.com|
 

# Validation of packages page exit intent auto CBR 
#Feature removed from prod
#Scenario: Validate The Exit Intent Auto CBR For Packages Page For Existing User
   #Given Login as a authenticated user
#	When user navigate to packages page
#	And  user moves the cursor to url tab
#	And  verify the name email and mobile number field disabled
    #And  post cbr form
    #Then validate the user submitted the cbr successfully

##Commented out the scenario due to signup data dependency    
##  Scenario Outline:  Validate The Exit Intent Auto CBR for Packages Page for New User
##    Given user land on home page without login
##	When  user navigate to packages page
##	And   user moves the cursor to url tab
##   And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
##    And   post cbr form 
##   Then   validate the user submitted the cbr successfully
##   Examples:
##   |name|mobileNumber|email|
##    |CBR|944700259|qaemail08@gsgs.com|
#
#
#
#Validate The Exit Intent Auto CBR for Packages Page(New mail and Authenticated Number)
#Validate The Exit Intent Auto CBR for Packages Page (Authenticated Mail and New Number)
#Feature removed from prod
#Scenario Outline: Posting CBR With Combination of New And Registered Credential From  Packages Page(Exit intent popup)
    #Given Login as a authenticated user
#	When  user navigate to packages page
#	And   user moves the cursor to url tab
    #And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
    #And  post cbr form
    #Then Validate the alert message
    #Examples:
     #|name|mobileNumber|email|
     #|new email existing number|6383589200|qaemail903240@gsgs.com|
     #|existing email new number|9876982990|meenatchi@pickyourtrail.com|
  

    
#  validation of Vacations page Exit intent auto CBR 
#Feature removed from prod
    #Scenario: Validate The Exit Intent Auto CBR For Vacations Page For Existing User
    #Given Login as a authenticated user
#	When user navigate to packages page
#	And  user moves the cursor to url tab
#	And  verify the name email and mobile number field disabled
    #And  post cbr form
    #Then validate the user submitted the cbr successfully
    
    
##Commented out the scenario due to signup data dependency     
##  Scenario Outline: Validate The Exit Intent Auto CBR for Vacation Page for New User
##     Given user land on home page without login
##    When Scroll down and click Explore Australia button in the landing page 
##    And   verify the user land on vacations page 
##	And   user moves the cursor to url tab
##    And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
##    And   post cbr form 
##    Then   validate the user submitted the cbr successfully
##     Examples:
##   |name|mobileNumber|email|
##    |CBR|944700352|qaemail06@gsgs.com|
#    
#   
#  Validate The Exit Intent Auto CBR for vacations Page(New mail and Authenticated Number)
#  Validate The Exit Intent Auto CBR for Vacations Page (Authenticated Mail and New Number)
#Feature removed from prod
  #Scenario Outline: Posting CBR With Combination of New And Registered Credential From Vacations Page(Exit intent popup)
    #Given user land on home page without login
#	When  user navigate to packages page
#	And   user moves the cursor to url tab
    #And  user fill the cbr value in the form"<name>","<mobileNumber>","<email>"
    #And  post cbr form
    #Then Validate the alert message
    #Examples:
     #|name|mobileNumber|email|
     #|new email existing number|6383589200|qaemail903240@gsgs.com|
     #|existing email new number|9876982990|meenatchi@pickyourtrail.com|
  
