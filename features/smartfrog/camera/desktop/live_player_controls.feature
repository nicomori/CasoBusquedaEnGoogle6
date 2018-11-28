@smartfrog @Wip @Desktop @camera @webapp @Smoke
Feature: Live player controls

  Scenario: User logged in changes size image on page - image is bigger
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
    When I click "+"" button on page
    Then I see, size image is bigger on page

  Scenario: User logged in changes size image on page - image is smaller
    Given I am on main website page
    When When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button on page
    Then I am on life view page
    When I click ""-"" on page
    Then I see, size image is smaller on page

  Scenario: User logged in stops life transmission on page
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
    When I click pause button on page
    Then I see the transmission on life is stop on page

  Scenario: User logged in start life transmission on page
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button
    Then I am on life view page
    When I click play button on page
    Then I see live stream is start on page

  Scenario: Logged in user checks if the speaker is working
    Given I am on main website page
    When I logged in as "smartfrog@test.com" on main website page
    Then I am on account overview page
    And I have camera in offline status on page
    When I click on "Connect webcam" button
    Then I see window where I have preview and information about using camera
    When I minimalize window
    Then Camera has live status on page
    When I click "Life-view" button
    Then I am on life view page
    When I click speaker button on page
    Then I can change the volume

  Scenario: Logged in user checks if the microphone is working
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
    When I click microphone button on page
    Then I can switch on or switch off

  Scenario: Logged in user checks that the date and time are correct
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
    When I click play button on page
    Then I see live stream is start on page and I see correct data and time

  Scenario: Logged in user checks fullscreen option
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

 Scenario: Login as registered user on shop landing page and verify live streaming components
    Given I am logged in as registered user "user.with.camera.5.95@gmail.com"
    And I am on camera overview page
    When I click on "Live-Ansicht" button on camera with name "Active"
    Then I am on 'Live-view' page
    When I change camera name to "Test 123" on 'Live-view' page
    And click anywhere on 'Live-view' page
    Then camera name is "Test 123" on 'Live-view' page
    When I click on "Recording" icon on Video container on 'Live-view' page
    Then the status is changed to "Standby" icon on Video container on 'Live-view' page
