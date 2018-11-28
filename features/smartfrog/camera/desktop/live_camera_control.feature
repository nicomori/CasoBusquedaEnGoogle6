@smartfrog @Wip @Desktop @camera @webapp
Feature: Live camera control

  Scenario: User logged in gives the camera name on page
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button on page
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button on page
    Then I am on life view page
    When I enter name camera "camera" and click pen button on page
    Then I see new name camera as "camera" on page

  Scenario: User logged in edits the camera name on page
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button on page
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button on page
    Then I am on life view page
    And I see name camera "camera" on page
    When I enter name camera "camera1" and click pen button
    Then I see new camera name as "camera1" on page

  Scenario: User logged in removed the camera name on page
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button on page
    Then I am on life view page
    And I see name camera "camera1" on page
    When I delete camera name "camera1" and click "X" button on page
    Then I see that the camera name has been removed on page

  Scenario: User logged in switch off camera on page
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button on page
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button on page
    Then I am on life view application on page
    When I click red square button on page
    Then I see that the webcam is in standby status on page

  Scenario: User logged in switch on camera on page
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button on page
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button on page
    Then I am on life view on page
    And Webcam is in Standby status on page
