@smartfrog @User @Mobile @Core @Smoke
Feature: User login verification - Mobile

  As a registered user
  I want to be able to login on my SF account via mobile app

  @pocIos
  Scenario Outline:  Login as registered user
    Given I detect the enviroment to execute the test
    And I make click in the login button
    When I enter email as "<userEmail>" on mobile login page
    And I enter password as "<password>" on mobile login page
    And I tap login button on mobile login page
    
    Examples:
      | language | loginButtonText | userEmail                      | password   | appPackage						| url 						| mailAccount 					| passwordMail		|	
      #| English  | login           | test.user+dev100@smartfrog.com | Test123!!! | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|
      #| Deutsch  | log in          | test.user+dev100@smartfrog.com | Test123!!! | 								|							|								|					|
      | English  | login           | test.user+dev100@smartfrog.com | Test123!!! | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|


  @pocAndroid
  Scenario Outline:  Login as registered user
    Given I detect the enviroment to execute the test
    And I make click in the login button
    When I enter email as "<userEmail>" on mobile login page
    And I enter password as "<password>" on mobile login page
    And I tap login button on mobile login page
    Then make the mobile logout process
    
    Examples:
      | language | loginButtonText | userEmail                      | password   | appPackage						| url 						| mailAccount 					| passwordMail		|	
      #| English  | login           | test.user+dev100@smartfrog.com | Test123!!! | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|
      #| Deutsch  | log in          | test.user+dev100@smartfrog.com | Test123!!! | 								|							|								|					|
      | English  | login           | test.user+dev100@smartfrog.com | Test123!!! | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|

      
  @pocWeb
  Scenario Outline:  Login as registered user
    Given I detect the enviroment to execute the test
    Given I am on "smartfrog" landing page
    Then I enter email as "<userEmail>" on the homepage
    And I enter password as "<password>" on the homepage
    And I click login button page
    
    Examples:
      | language | loginButtonText | userEmail                    | password   | appPackage					| url 						| mailAccount 					| passwordMail		|	
      | English  | login           | ls.tester91+dev1@gmail.com	 | Test123!!! | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|
    
  
  @pocBackend
  Scenario Outline:  Login as registered user
    Given example test backend
    
    Examples:
      | language | loginButtonText | userEmail                    | password   | appPackage					| url 						| mailAccount 					| passwordMail		|	
      | English  | login           | ls.tester91+dev1@gmail.com	 | Test123!!! | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|
        

  @pocIntegration
  Scenario Outline:  Login as registered user
    Given example test backend
    Given I detect the enviroment to execute the test
    Given I am on "smartfrog" landing page
    Then I enter email as "<userEmail>" on the homepage
    And I enter password as "<password>" on the homepage
    And I click login button page
    Given I set a new enviroment to "ios"
    And I make click in the login button
    When I enter email as "<userEmail>" on mobile login page
    And I enter password as "<password>" on mobile login page
    And I tap login button on mobile login page
    
    Examples:
      | language | loginButtonText | userEmail                    | password   | appPackage					| url 						| mailAccount 					| passwordMail		|	
      | English  | login           | ls.tester91+dev1@gmail.com	 | 123456 | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|

   @pocIntegration2
   Scenario Outline:  Login as registered user
    Given example test backend
    Given I detect the enviroment to execute the test
    Given I am on "smartfrog" landing page
    Then I enter email as "<userEmail>" on the homepage
    And I enter password as "<password>" on the homepage
    And I click login button page
    Given I set a new enviroment to "android"
    And I make click in the login button
    When I enter email as "<userEmail>" on mobile login page
    And I enter password as "<password>" on mobile login page
    And I tap login button on mobile login page
    Then make the mobile logout process
    
    Examples:
      | language | loginButtonText | userEmail                    | password   | appPackage					| url 						| mailAccount 					| passwordMail		|	
      | English  | login           | ls.tester91+dev1@gmail.com	 | 123456 | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|
 
 
  @pocIntegration3
  Scenario Outline:  Login as registered user
    Given example test backend
    Given I detect the enviroment to execute the test
    #Then I enter email as "<userEmail>" on the homepage
    #And I enter password as "<password>" on the homepage
    #And I click login button page
    
    Examples:
      | language | loginButtonText | userEmail                    | password   | appPackage					| url 						| mailAccount 					| passwordMail		|	
      | English  | login           | ls.tester91+dev1@gmail.com	 | 123456 | com.inovotecs.smartfrog.dev 	| https://mail.google.com	| nico.automation.arg@gmail.com	| a45224610b	 		|
 
 
 
   