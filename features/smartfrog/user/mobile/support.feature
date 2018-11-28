@smartfrog @Mobile @User @Wip @webapp @Smoke
Feature: Support and contact 

  Scenario: Success Searching phrases by help button
    Given I am on Camera Overview screen
    And I am logged in as "test.user@example.com"
    When I tap on the "Camera overview" button on Camera Overview screen
    Then I see list of functions on Camera Overview screen
    When I  tap “About Smartfrog/Contact” button on list of functions
    Then I am redirected to About Smartfrog/Contact screen
    When I tap “Help” button on About Smartfrog/Contact screen
    Then I am redirected to Help screen
    When I write searching phrase as “how many” on Help screen
    Then searching phrases shows on Help screen
    When I tap on the searching phrase on Help screen
    Then searching phrase opens

  Scenario: Failed searching phrases by help button
    Given I am on Camera Overview screen
    And I am logged in as "test.user@example.com"
    When I tap on the "Camera overview" button on Camera Overview screen
    Then I see list of functions on Camera Overview screen
    When I  tap “About Smartfrog/Contact” button on list of functions
    Then I am redirected to About Smartfrog/Contact screen
    When I tap “Help” button on About Smartfrog/Contact screen
    Then I am redirected to Help screen
    When I write searching phrase as “bla bla bla” on Help screen
    Then I see communique “No results found”

  Scenario: User send message by Contact support button
    Given I am on Camera Overview screen
    And I am logged in as "test.user@example.com"
    When I tap on the "Camera overview" button on Camera Overview screen
    Then I see list of functions on Camera Overview screen
    When I  tap “About Smartfrog/Contact” button on list of functions
    Then I am redirected to About Smartfrog/Contact screen
    When I tap “Help” button on About Smartfrog/Contact screen
    Then I am redirected to Help screen
    When I write searching phrase as “bla bla bla” on Help screen
    Then I see communique “No results found”
    When I tap Contact support button on Help screen
    Then I am redirected to Contact us screen
    When I write description as “I have a problem” on Contact us screen
    And I send my message
    Then I get a confirmation email message
    And I am redirected to Help screen

  Scenario: Live chat
    Given I am on Camera Overview screen
    And I am logged in as "test.user@example.com"
    When I tap on the "Camera overview" button on Camera Overview screen
    Then I see list of functions on Camera Overview screen
    When I  tap “About Smartfrog/Contact” button on list of functions
    Then I am redirected to About Smartfrog/Contact screen
    When I tap “Live chat” button on About Smartfrog/Contact screen
    Then I am redirected to Chat screen
    When I write a message as “I have a problem” on Chat screen
    And I send it
    Then I see my sent message on the top screen
    And Chat started
    When I tap “End chat” button on Chat screen
    Then I see warning message on Chat screen
    When I tap “End” button on Chat screen
    Then chat ends
    And I am redirected to About Smartfrog/Contact screen

