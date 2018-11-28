@Desktop @User @WebApp @Wip @smartfrog @Smoke
Feature: Account settings - email address

  Scenario: Login user changing email address
    Given I am on main website page
    When I enter email as "smartfrog@test.com" on main website page
    And I enter password "haslo123" on main website page
    And I click "Login" button on main website page
    When I click on "My account" on webapp overview page
    Then I on account overview page
    When I click on "Change email address" on account overview page
    Then I am on account email page
    When I enter email "smartfrog1@test.pl" on account email page
    And  I enter repeat email "smartfrog1@test.pl" on account page
    And  I click on "Save" button on account page
    Then I see the message "Email has been changed" on account page
