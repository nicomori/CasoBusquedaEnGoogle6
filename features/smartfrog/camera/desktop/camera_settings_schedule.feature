@Smoke @Wip @smartfrog @Desktop @camera
Feature: Camera schedule

  Scenario: User enter camera schedule
    Given I am on advanced setting page
    And I am logged in as "test.user@example.com"
    When I click on "Camera schedule" checkbox
    And I enter in "Weekdays/Start time" field value "22:00"
    And I enter in "Weekdays/End time" field value "24:00"
    And I enter in "Weekend/Start time" field value "20:00"
    And I enter in "Weekend/End time" field value "02:00"
    Then My changes are saved

