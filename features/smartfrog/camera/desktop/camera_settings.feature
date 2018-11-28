@Smoke @Wip @smartfrog @Desktop @camera
Feature: Smartfrog - Camera settings

  Scenario: User active audio
    Given I am on a advanced setting page
    And I am logged in as "test.user@example.com"
    When I click on "Audio" checkbox
    Then I see active "Noise detection" checkbox
    When I change volume level
    Then My changes are saved.

  Scenario: User active motion detection
    Given I am on a advanced setting page
    And I am logged in as "test.user@example.com"
    When I click on "Motion detection" checkbox
    And I change detection level
    Then My changes are saved.

  Scenario: User active noise detection
    Given I am on a advanced setting page
    And I am logged in as "test.user@example.com"
    And I have active "Audio" checkbox
    When I click on "Noise detection" checkbox
    And I change noise detection level
    Then My changes are saved.

  Scenario: User change video quality
    Given I am on a advanced setting page
    And I am logged in as "test.user@example.com"
    When I click on "Video quality" drop down list
    And I change quality level to "High"
    Then My changes are saved.


