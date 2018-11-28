@Desktop @User @WebApp @Wip @smartfrog @Smoke
Feature: Account settings - password

  Scenario: Login user changing password
    Given I am on main website page
    When I enter email as "smartfrog@test.com" on main website page
    And I enter password "haslo123" on main website page
    And I click "Login" button on main website page
    When I click on "My account" tab on web app overview page
    Then I on account overview page
    When I click on "Change password" with "Password" on account password page
    Then I am on password email page
    When I enter Current password  "haslo123"" on account password page
    And I enter new password  "haslo456" on account password page
    And I enter confirm new password with "haslo456" on account password page
    And I click on "Change password" button on account password page
    Then I see the message "Password has been changed." on account password page
