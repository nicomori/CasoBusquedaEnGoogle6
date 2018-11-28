@smartfrog @Mobile @User @Wip @webapp @Smoke
Feature: Deactivate account - Mobile

  Scenario: Deactivate an account
    Given I have registered user "some@mail.com"
    And I am on main mobile page
    When I enter email as "some@mail.com" on main mobilie page
    And I enter password "pass" on main mobile page
    Then I am on mobile camera overview page
    And I am logged in as "some@mail.com" mobile camera overview page
    When I click sidebar menu icon on mobile camera overview page
    Then I see the expanded sidebar menu
    When I click "User Account" on sidebar menu
    Then I am on "User Account" page
    When I click "Suspend account" button on "User Account" page
    Then Pop up appears with the following text: "You will be logged out. Cameras will be deactivated. No further access to this account, cameras, live view and recordings is possible."
    When I click "Suspend account" button on pop up
    Then I am logged out from mobile camera overview page
    And I am on the main mobile page

  Scenario: Resign from account deactivation
    Given I have registered user "some@mail.com"
    And I am on main mobile page
    When I enter email as "some@mail.com" on main mobilie page
    And I enter password "pass" on main mobile page
    Then I am on mobile camera overview page
    And I am logged in as "some@mail.com" mobile camera overview page
    When I click sidebar menu icon on mobile camera overview page
    Then I see the expanded sidebar menu
    When I click "User Account" on sidebar menu
    Then I am on "User Account" page
    When I click "Suspend account" button on "User Account" page
    Then Pop up appears with the following text: "You will be logged out. Cameras will be deactivated. No further access to this account, cameras, live view and recordings is possible."
    When I click "Cancel" button on pop up
    Then Displayed pop up disappears
    And I am on the "User Account" page

  Scenario: Log in with disabled account
    Given I have suspended user "some@mail.com"
    And I am on main mobile page
    When I enter email as "some@mail.com" on main mobile page
    And I enter password "pass" on main mobile page
    And I click "Login" button on main mobile page
    Then Pop up appears with the following text: "Please check if your email address and password have been entered correctly"
    When I click "Ok" button
    Then I am on the log in mobile page

