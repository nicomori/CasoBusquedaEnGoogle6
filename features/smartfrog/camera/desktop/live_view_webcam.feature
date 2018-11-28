@smartfrog @Wip @Desktop @camera @webapp @Smoke @Core
Feature: Smartfrog - Live view webcam

  Scenario: User logged in checks life transmission on page
    Given I am on main website page
    When When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status
    When I click on "Connect webcam" button on page
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button
    Then I am on life view page
    When I click  pause button on page
    Then I see the transmission on life is stop on page

  Scenario: User logged in start life transmission on page
    Given I am on main website page
    When When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button on page
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button
    Then I am on life view page
