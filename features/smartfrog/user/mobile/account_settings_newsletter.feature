@smartfrog @Mobile @User @Wip @webapp
Feature: Account settings - newsletter

  Scenario: Login user swich on newsletter
    Given I am on application
    When I click "Already registered? >> Log in" button on Smartfrog application
    Then I am on Log in tab smartfrog application
    When I enter email as "test@testy.com" on Log in smartfrog application tab
    And I enter password as "haslo123" on Log in tab smartfrog application
    And I enter"Log in" button on Log in  smartfrog application tab
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I choose "User account" option on smartfrog application tab
    Then I am on user account option on smartfrog application tab
    When I swich on "Receive newsslater" button pn user account option on smartfrog application tab
    Then I see button is "orange" on user account option on smartfrog application tab

  Scenario: Login user swich off newsletter
    Given I am on application
    When I click "Already registered? >> Log in" button on Smartfrog application
    Then I am on Log in tab smartfrog application
    When I enter email as "test@testy.com" on Log in smartfrog application tab
    And I enter password as "haslo123" on Log in tab smartfrog application
    And I enter"Log in" button on Log in  smartfrog application tab
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I choose "User account" option on smartfrog application tab
    Then I am on user account option on smartfrog application tab
    When I swich of "Receive newsslater" button on user account option on smartfrog application tab
