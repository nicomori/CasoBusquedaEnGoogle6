@Core @Smoke @mobilcom @User @Partner @mobilcomWebapp @Desktop
Feature: Mobilcom - Login Page verification

  Scenario: Mobilcom logo is displayed
  	Given I detect the enviroment to execute the test
	Given I am on "Mobilcom" landing page
    And I can see Mobilcom logo on the Mobilcom main page

  Scenario: Login form verification
  	Given I detect the enviroment to execute the test
	Given I am on "Mobilcom" landing page
    And I can see the MD Login form
    And I can see the MD title "Bei Smartfrog anmelden"
    And I can see "Passwort vergessen" in the MD login form


