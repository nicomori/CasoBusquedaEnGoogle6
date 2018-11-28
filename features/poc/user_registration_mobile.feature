@smartfrog @User @Mobile @Core @Smoke
Feature: User registration verification - Mobile

  As anonymous customer
  I want to be able to register via SF Mobile app
  So that I can use to manage my account

  Scenario Outline: User registers account correctly on mobile
    Given Application is opened
    And I am on I am on "<language>" mobile home page
    When I tap on "<registerButtonText>" button on mobile home page
    Then I am on mobile registration page
    When I enter email "<userEmail>" on mobile registration page
    And I enter repeat email "<repeatUserEmail>" on mobile registration page
    And I enter password "<password>" on mobile registration page
    And I tap on country list on mobile registration page
    Then I am on country list page
    When I tap the "<countryOption>" on country list page
    Then I am on mobile registration page
    When I click "<registerButtonText2>" button on mobile registration screen
    Then I am redirected to "<language>" mobile welcome page


    Examples:
      | language | registerButtonText | userEmail              | repeatUserEmail        | password   | countryOption  | registerButtonText2    |
      | Deutsch  | Jetzt registrieren | testmail@smartfrog.com | testmail@smartfrog.com | Test123!!! | United Kingdom | Kostenlos registrieren |
      | English  | Sign up now        | testmail@smartfrog.com | testmail@smartfrog.com | Test123!!! | United Kingdom | Sign up for free       |