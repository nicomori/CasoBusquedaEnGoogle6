@local_testing @generateValidations @Desktop
Feature: FirstUtility - serialised voucher usage
	
  Scenario Outline: FirstUtility - serialised voucher usage
	
	Given I detect the enviroment to execute the test
    And generate validations from file
    
    
  Examples:
      | webapp  	  	   	| pageTitle                                      | pageUrl             |
      | first-utility  	| Support                                        | /support/           |
      
      
      
      
