@smartfrog @User @Mobile @Core @Smoke
Feature: User registration verification - Mobile

  As anonymous customer
  I want to be able to register via SF Mobile app
  So that i can create and verify my account

  Scenario: User registers account correctly on mobile
    Given Application is opened in android device
    And I am on English mobile home page
    When I tap on "Sign up now" button on mobile home page
    Then I am on mobile registration page
    When I enter account data on mobile registration page
      | Email                         | Confirm Email                 | Password   |
      | nico.automation.arg@gmail.com | nico.automation.arg@gmail.com | Test123!!! |
    And I tap on country list on mobile registration page
    Then I am on country list page
    When I tap United Kingdom on country list page
    Then I am on mobile registration page
    When I click "Sign up for free" button on mobile registration page
    Then I am redirected to English mobile welcome page

  Scenario: Verify email account on mobile browser
    Given Chrome mobile browser is opened in android device
    And I am on my gmail inbox
    When I tap on Welcome email
    Then I am redirected to Welcome email page
    When I tap on "Confirm email address" button
    Then I am redirected to email confirmation page
    And I can see "Email address confirmed"
    And I can see this text "You are using a mobile device"