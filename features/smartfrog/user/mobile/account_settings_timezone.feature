@smartfrog @Mobile @User @Wip @webapp
Feature: Account settings - time zone

  Scenario: Login user changing Time Zone
    Given I am on application
    When I click "Already registered? >> Log in" button on Smartfrog application
    Then I am on Log in tab smartfrog application
    When I enter email as "test@testy.com" on Log in smartfrog application tab
    And I enter password as "haslo123" on Log in tab smartfrog application
    And I enter "Log in" button on Log in  smartfrog application tab
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I choose "User account" option on smartfrog application tab
    Then I am on user account option on smartfrog application tab
    When I click "Time Zone" button on user account option on smartfrog application tab
    When I choose "Europe/Warsaw" time zone on user account option on smartfrog application tab
