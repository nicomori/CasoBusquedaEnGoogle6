@Wip @Desktop @User @WebApp @smartfrog @Smoke
Feature: Deactivate account

  Scenario: Deactivate an account
    Given I have registered user "some@mail.com"
    And I am on main website page
    When I enter email as "some@mail.com" on main website page
    And I enter password "pass" on main website page
    And I click "Login" button on main website page
    Then I am on web app camera overview page
    And I am logged in as "some@mail.com" on web app camera overview page
    When I click on "My account" tab on web app camera overview page
    Then I am on account overview page
    When I click "Disable account" on account overview page
    Then Pop up appears with the following text: "Do you really want to suspend your account? You will be logged out. Cameras will be deactivated. No further access to this account, cameras, live view and recordings is possible."
    When I click "Yes" button on pop up
    Then I am logged out from web app camera overview page
    And main website page is displayed

  Scenario: Resign from account deactivation
    Given I have registered user "some@mail.com"
    And I am on main website page
    When I enter email as "some@mail.com" on main website page
    And I enter password "pass" on main website page
    And I click "Login" button on main website page
    Then I am on web app camera overview page
    And I am logged in as "some@mail.com" on web app camera overview page
    When I click "My account" tab on web app camera overview page
    Then I am on account overview page
    When I click "Disable account" on account overview page
    Then Pop up appears with the following text: "Do you really want to suspend your account? You will be logged out. Cameras will be deactivated. No further access to this account, cameras, live view and recordings is possible."
    When I click "Cancel" button on pop up
    Then Displayed pop up disappears
    And I am on account overview page

  Scenario: Log in with disabled account
    Given I have disabled user "some@mail.com"
    And I am on main website page
    When I enter email as "some@mail.com" on main website page
    And I enter password "pass" on main website page
    And I click "Login" button on main website page
    Then I have no possibility to log in for disabled user "some@mail.com"
    And I am still on main website page