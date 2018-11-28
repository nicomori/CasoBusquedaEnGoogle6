@smartfrog @Mobile @User @Wip @webapp
Feature: User guide

  Scenario: Login user reading "User guide"
    Given I am on application
    When I click "Already registered? >> Log in" button on Smartfrog application
    Then I am on Log in tab smartfrog application
    When I enter email as "test@testy.com" on Log in smartfrog application tab
    And I enter password as "haslo123" on Log in tab smartfrog application
    And I enter"Log in" button on Log in  smartfrog application tab
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I click "User quide" button on smartfrog application
    Then I see information about smartfrog on smartfrog application
    When I swipe screen on smarfrog application
