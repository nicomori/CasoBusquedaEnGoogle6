@smartfrog @Mobile @User @Wip @webapp @Smoke @Core
Feature: User Registration

  @Mobile @SFUser @WebApp
  Scenario: User registers account correctly on mobile
    Given application is opened
    And I am not registered
    And I am not logged in
    When I click on "Register now" button on main screen
    Then I am on registration screen
    When I enter "test@test.pl" on registration screen
    And I enter "test@test.pl" on registration screen
    And I enter "Test123!" on registration screen
    And I click on "Country" drop down bar
    Then I am on country list screen
    When I tick the "United Kingdom" checkbox on country list screen
    And I click on "<Country" button
    Then I am on registration screen
    When I click on "Register free" button
    Then I am on main screen
    And I get confirmation e-mail
    And I am logged in on main screen

  @Mobile @SFUser @WebApp
  Scenario: User registers account with all empty fields on mobile
    Given application is opened
    And I am not registered
    And I am not logged in
    When I click on "Register now" button on main screen
    Then I am on registration screen
    When I leave "Email address" empty on registration screen
    And leave "Repeat email address" empty on registration screen
    And leave "Password" empty on registration screen
    And leave "Country" empty on registration screen
    And click on "Register free" button on registration screen
    Then I see error message "Recheck entered data" on registration screen

  @Mobile @SFUser @WebApp
  Scenario: User registers account with empty Email address on mobile
    Given application is opened
    And I am not registered
    And I am not logged in
    When I click on "Register now" button on main screen
    Then I am on registration screen
    When I leave "Email address" empty on registration screen
    And I enter "test@test.pl" on registration screen
    And I enter "Test123!" on registration screen
    And I click on "Country" drop down bar
    Then I am on country list screen
    When I tick the "United Kingdom" checkbox on country list screen
    And I click on "<Country" button
    Then I am on registration screen
    When I click on "Register free" button on registration screen
    Then I see error message "Recheck entered data" on registration screen


  @Mobile @SFUser @WebApp
  Scenario: User registers account with empty Repeat email address on mobile
    Given application is opened
    And I am not registered
    And I am not logged in
    When I click on "Register now" button on main screen
    Then I am on registration screen
    When I leave "Email address" empty on registration screen
    And I leave "Repeat email address" empty on registration screen
    And I enter "Test123!" on registration screen
    And I click on "Country" drop down bar
    Then I am on country list screen
    When I tick the "United Kingdom" checkbox on country list screen
    And I click on "<Country" button
    Then I am on registration screen
    When I click on "Register free" button on registration screen
    Then I see error message "Recheck entered data" on registration screen

  @Mobile @SFUser @WebApp
  Scenario: User registers account with empty Password on mobile
    Given application is opened
    And I am not registered
    And I am not logged in
    When I click on "Register now" button on main screen
    Then I am on registration screen
    When I enter "test@test.pl"
    And I leave "Repeat email address" empty
    And I leave "Password" empty
    And I click on "Country" drop down bar
    Then I am on country list screen
    When I tick the "United Kingdom" checkbox on country list screen
    And I click on "<Country" button
    Then I am on registration screen
    And I am not able to click "Register now" button on registration screen

    #need review
Scenario: User registers account correctly on mobile
Given application is opened
And I am anonymous customer without account
When I click on "Register now" button on main screen
Then I am on registration screen
When I enter email "some@mail.com" on registration screen
And I enter repeat email "some@mail.com" on registration screen
And I enter password "pass" on registration screen
And I click on country list screen
Then I am on country list screen
When I choose the "United Kingdom" on country list screen
And I click on "Country" button
Then I am on registration screen
When I click "Sign up for free" button on registration screen
Then I am on choose page
And I get confirmation e-mail
And I am logged in on main screen

Scenario Outline: User registration fields validation
Given application is opened
And I am anonymous customer without account
When I click on "Register now" button on main screen
Then I am on registration screen
When I enter email "<emailField>" on registration screen
And I enter repeat email "<repeatEmailField>" on registration screen
And I enter password "<passwordField>" on registration screen
And I click on country list screen
Then I am on country list screen
When I choose country "<countryOption>" on registration screen
And I click on "Country" button
Then I am on registration screen
When I click "Sign up for free" button on registration screen
Then I see error message "Recheck entered data" on registration screen

Examples:
      | emailField    | repeatEmailField | passwordField | countryOption  |
      |               |                  |               |                |
      | some@mail.com |                  | pass          | United Kingdom |
      |               | some@mail.com    | pass          | United Kingdom |
      | some@mail.com | some@mail.com    |               | United Kingdom |
      | some@mail.com | some@mail.com    | pass          |                |

