@smartfrog @Desktop @User @Wip @webapp
Feature: Account settings - newsletter

  Scenario: Login user chooses Newsletter - Subscribe
    Given I am on main website page
    When I enter email as "smartfrog@test.com" on main website page
    And I enter password "haslo123" on main website page
    And I click "Login" button on main website page
    When I click on "My account" tab on web app overview page
    Then I on account overview page
    When I click on "Unsubscribe" button on my account overview page
    Then I see that the newsslater changed for Subscribe on account overview page

  Scenario: Login user chooses Newsletter - Unsubscribe
    Given I am on main website page
    When I enter email as "smartfrog@test.com" on main website page
    And I enter password "haslo123" on main website page
    And I click "Login" button on main website page
    When I click on "My account" tab on web app overview page
    Then I on account overview page
    When I click on "Subscribe" button on my account overview page
