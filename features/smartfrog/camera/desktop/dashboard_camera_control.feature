@Wip @smartfrog @Desktop @camera @Smoke
Feature: Smartfrog - Dashboard camera control

  Scenario: User turn on Notebook camera
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have camera in offline status
    When I click on "Connect webcam" button
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status

  Scenario: User change camera name
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have camera in live status
    When I click on text field
    And I delete default camera name
    And I enter new naame as "Room 3"
    Then I see new name on my camera

  Scenario: User open live-view page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have camera in live status
    When I click on "Live-view" button
    Then I see live-view page with large preview

  Scenario: User open Recordings page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have camera in live status
    When I click on "Recordings" button
    Then I see recordings page

  Scenario: User open Upgrade page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have camera in live status
    When I click on "Upgrade" button
    Then I see pop-up with Upgrade video storage information