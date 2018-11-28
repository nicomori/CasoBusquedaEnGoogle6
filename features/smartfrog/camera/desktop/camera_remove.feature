@Wip @smartfrog @Desktop @camera @Smoke
Feature: Smartfrog - Camera remove

  Scenario: User sucessfull remove camera
    Given I am on advanced setting page
    And I am logged in as "test.user@example.com"
    When I click on "General" option
    And I click on "Remove camera" button
    And I click on "Yes, please remove" button
    Then My camera remove from camera list

  Scenario: User not confirm remove camera
    Given I am on advanced setting page
    And I am logged in as "test.user@example.com"
    When I click on "General" option
    And I click on "Remove camera" button
    And I click on "No" button
    Then Confirm window is closed
    And I see "General" option in advenced setting page

