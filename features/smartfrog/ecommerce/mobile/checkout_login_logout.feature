@Mobile @smartfrog @Ecommerce @Core
Feature: Smartfrog - checkout login logout

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
