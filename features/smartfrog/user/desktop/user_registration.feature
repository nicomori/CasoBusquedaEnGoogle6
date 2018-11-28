@smartfrog @Desktop @User @Wip @webapp @Core @Smoke
Feature: User Registration

  Scenario: User registers account correctly from registration page
    Given I am on main website page
    And I am not registered
    And I am not logged in
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I enter "test@test.pl" on shop register page
    And I enter "test@test.pl" on shop register page
    And I enter "Test123!" on shop register page
    And I choose country "United Kingdom" on shop register page
    And I click on "Register now" button on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I see Welcome Wizard on web app overview page
    And I get confirmation e-mail
    And I am logged in on web app overview page

  Scenario: User registers account correctly from main website page
    Given I am on main website page
    And I am not registered
    And I am not logged in
    When I enter "test@test.pl" on web app overview page
    And I enter "test@test.pl" on web app overview page
    And I enter "Test123!" on web app overview page
    And I choose country "United Kingdom" on web app overview page
    And I click on "Register now" button on web app overview page
    And I set newly registered user as Test in Videocloud API
    Then I see Welcome Wizard on web app overview page
    And I get confirmation e-mail
    And I am logged in on web app overview page

  Scenario: User registers account with all empty fields on desktop
    Given I am on main website page
    And I am not registered
    And I am not logged in
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I leave "Email address" empty on shop register page
    And I leave "Repeat email address" empty on shop register page
    And I leave "Password" empty on shop register page
    And I do not choose country on shop register page
    Then I am not able to click "Register now" button on shop register page

  Scenario: User registers account with empty Email address on desktop
    Given I am on main website page
    And I am not registered
    And I am not logged in
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I leave "Email address" empty on shop register page
    And I enter "test@test.pl" on shop register page
    And I enter "Test123!" on shop register page
    And I choose country "United Kingdom" on web app overview page
    Then I am not able to click "Register now" button on shop register page

  Scenario: User registers account with empty Repeat email address on desktop
    Given I am on main website page
    And I am not registered
    And I am not logged in
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I leave "Email address" empty on shop register page
    And I leave "Repeat email address" empty on shop register page
    And I enter "Test123!" on shop register page
    And I choose country "United Kingdom" on web app overview page
    Then I am not able to click "Register now" button on shop register page

  Scenario: User registers account with empty Password on desktop
    Given I am on main website page
    And I am not registered
    And I am not logged in
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I enter "test@test.pl" empty on shop register page
    And I leave "Repeat email address" empty on shop register page
    And I leave "Password" empty on shop register page
    And I choose country "United Kingdom" on web app overview page
    Then I am not able to click "Register now" button on shop register page

  @jira=QA-3413
  Scenario: User registers account correctly from registration page
    Given I am on main website page
    And I am anonymous customer without account
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I enter email "some@mail.com" on shop register page
    And I enter repeat email "some@mail.com" on shop register page
    And I enter password "pass" on shop register page
    And I choose country "United Kingdom" on shop register page
    And I click on "Register now" button on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I see Welcome Wizard on web app overview page
    And I get confirmation e-mail
    And I am logged in on web app overview page

  Scenario Outline: User registration fields validation
    Given I am on main website page
    And I am anonymous customer without account
    When I click on "Create free account" button on main web app page
    Then I am on shop register page
    When I enter email "<emailField>" on shop register page
    And I enter repeat email "<repeatEmailField>" on shop register page
    And I enter password "<passwordField>" on shop register page
    And I choose country "<countryOption>" on web app overview page
    Then I am not able to click "Register now" button on shop register page

    Examples:
      | emailField    | repeatEmailField | passwordField | countryOption  |
      |               |                  |               |                |
      | some@mail.com |                  | pass          | United Kingdom |
      |               | some@mail.com    | pass          | United Kingdom |
