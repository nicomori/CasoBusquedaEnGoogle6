@smartfrog @MobileWeb @User @Wip @webapp @Smoke
Feature: Logged-out header

  Background:
    Given I am on main website page
    And I am not logged in

  Scenario: "Create free account" link action
    When I click the "Create free account" link
    Then I am on registration page

  Scenario: "Forgot password?" link action
    When I click the "Forgot password?" link
    Then I am on reset password page

  Scenario: "Login" button action
    When The "Email address" field or "Email address" and "Password" fields are empty
    And I click the "Login" button
    Then I am on service navigation "Login at Smartfrog" page
    And The "Email address" and "Password" fields are marked red

  Scenario: "Login" button action
    When The "Email address" field is filled
    And The "Password" field is empty
    And I click the "Login" button
    Then I am on the reset password page
    And The "Email address" and "Password" fields are marked red

  Scenario: "Shop" button action
    When I click the "Shop" button
    Then I am on shop products page

  Scenario: "Shoping cart" button action
    When I click the "Shopping cart" button
    Then I am on the shopping cart page
    And I see my shopping cart content

