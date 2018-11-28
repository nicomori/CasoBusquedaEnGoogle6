@smartfrog @Wip @Desktop @User @webapp @Smoke
Feature: Link for mobile app

  Scenario: User install app by App Store link on account overview page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    When I click on "Connect smartphone camera" button on account overview page
    Then I am on Set up your smartphone screen on account overview page
    When I click on "Download on the App Store" button on account overview page
    Then I am redirected to Smartfrog Cam & Baby Monitor application in App Store

  Scenario: User install app by Google Play link on account overview page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    When I click on "Connect smartphone camera" button on account overview page
    Then I am on Set up your smartphone screen on account overview page
    When I click on "Android App on Google Play" button on account overview page
    Then I am redirected to Smartfrog Cam & Baby Monitor application in Google Play on account overview page

  Scenario: User close Set up your smartphone screen on account overview page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    When I click on "Connect smartphone camera" button on account overview page
    Then I am on Set up your smartphone screen on account overview page
    When I click in "Close" button on account overview page
    Then screen Set up your smartphone is closed on account overview page
