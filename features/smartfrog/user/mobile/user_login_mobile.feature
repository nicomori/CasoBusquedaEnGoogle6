@smartfrog @User @Mobile @Core @Smoke
Feature: User login verification - Mobile

  As a registered user
  I want to be able to login on my SF account via mobile app

  Scenario: Login as registered user
    Given Application is opened in android device
    And I am on English mobile home page
    When I tap "Log in" button on mobile home page
    Then I am redirected to mobile login page
    When I enter account data
      | Email                         | Password   |
      | nico.automation.arg@gmail.com | Test123!!! |
    And I tap "Log in" button on mobile login page
    Then I am redirected to English mobile welcome page
