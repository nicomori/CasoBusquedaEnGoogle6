@smartfrog @User @Mobile @Core @Smoke
Feature: Forgot password - mobile

  As a registered user
  I want to be able to proceed forgot password functionality via mobile app
  So that I can reset my password on mobile browser

  Scenario: Reset password as registered user via mobile app
    Given Application is opened in android device
    And I am on English mobile home page
    When I tap "Log in" button on mobile home page
    Then I am redirected to mobile login page
    When I tap "Forgot Password" text on mobile login page
    Then I am redirected to forgot password page
    When I enter email on forgot password page
      | Email                         |
      | nico.automation.arg@gmail.com |
    And I tap on "Send Link" button on forgot password page
    Then pop up is displayed with text "Recovery email sent"
    And tap on OK button
    And i am redirected back to mobile login page

  Scenario: Verify email and reset password on mobile browser
    Given Chrome mobile browser is opened in android device
    And I am on my gmail inbox
    When I tap on Forgot Password email
    Then I am redirected to Forgot Password email page
    When I tap "Reset Password" button on email page
    Then I am redirected to Reset Password page on mobile browser
    When I enter repeat password on reset password page
      | Enter password | Confirm password |
      | Test123!!!     | Test123!!!       |
    And I tap on "Save new password" button
    Then I am redirected to browser incompability page
    And I can see this text "You are using a mobile device"
