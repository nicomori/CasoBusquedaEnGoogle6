@User @smartfrog @Mobile @Wip
Feature: Welcome Wizard

  Scenario: User is reading screen "How it works"
    Given I am on application
    When I click "How it works" button on smartfrog application
    Then I see information about smartfrog on smartfrog application
    When I swipe screen on smarfrog application
