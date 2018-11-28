@mainwebsite @smartfrog @Desktop @User @Wip
Feature: Welcome Wizard

  Scenario: Welcome Wizard shows after registration for HW country
    Given I am on web app "English" login page
    When I click on "Create free account" button on login page
    Then I on web app registration page
    And I enter user details on registration page
      | email                    | repeatEmail              | password | country        |
      | test.user+@smartfrog.com | test.user+@smartfrog.com | test     | United Kingdom |
    And I click on "Register now" on registration page
    Then I am on camera overview page
    And I can see 'Welcome Wizard'
    And I can see "1" slide on 'Welcome Wizard'
    And I can see text "Record LIVE" and "Watch anywhere" on 'Welcome Wizard'
    And I can see navigation component and button "Try it now" on 'Welcome Wizard'
    And I can see text on "Record LIVE" on 'Welcome Wizard'
      | Smartfrog Cam |
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "2" slide on 'Welcome Wizard'
    And I can see text "Keep an eye on things at home" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "3" slide on 'Welcome Wizard'
    And I can see text "See what your pats are doing" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "4" slide on 'Welcome Wizard'
    And I can see text "Keep your children in sight" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "5" slide on 'Welcome Wizard'
    And I can see text "Keep in touch with the grandparents" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "6" slide on 'Welcome Wizard'
    And I can see text "The easiest way to protect your home and family" on 'Welcome Wizard'
    When I click on close button on 'Welcome Wizard'
    Then I am on camera overview page


  Scenario: Welcome Wizard shows after registration for NHW1 country
    Given I am on web app "English" login page
    When I click on "Create free account" button on login page
    Then I on web app registration page
    And I enter user details on registration page
      | email                    | repeatEmail              | password | country |
      | test.user+@smartfrog.com | test.user+@smartfrog.com | test     | Ukraine |
    And I click on "Register now" on registration page
    Then I am on camera overview page
    And I can see 'Welcome Wizard'
    And I can see "1" slide on 'Welcome Wizard'
    And I can see text "Record LIVE" and "Watch anywhere" on 'Welcome Wizard'
    And I can see text on "Record LIVE" on 'Welcome Wizard'
      | Old smartphone |
      | Smartfrog Cam  |
      | Webcam         |
    And I can see navigation component and button "Try it now" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "2" slide on 'Welcome Wizard'
    And I can see switching between hardware camera, smart phone, notebook
    And I can see text "Keep an eye on things at home" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "3" slide on 'Welcome Wizard'
    And I can see text "See what your pats are doing" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "4" slide on 'Welcome Wizard'
    And I can see text "Keep your children in sight" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "5" slide on 'Welcome Wizard'
    And I can see text "Keep in touch with the grandparents" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "6" slide on 'Welcome Wizard'
    And I can see text "The easiest way to protect your home and family" on 'Welcome Wizard'
    When I click on "Try it now" button on 'Welcome Wizard'
    Then I am on camera overview page


  Scenario: Welcome Wizard shows after registration for NHW1 country
    Given I am on web app "English" login page
    When I click on "Create free account" button on login page
    Then I on web app registration page
    And I enter user details on registration page
      | email                    | repeatEmail              | password | country  |
      | test.user+@smartfrog.com | test.user+@smartfrog.com | test     | Djibouti |
    And I click on "Register now" on registration page
    Then I am on camera overview page
    And I can see 'Welcome Wizard'
    And I can see "1" slide on 'Welcome Wizard'
    And I can see text "Record LIVE" and "Watch anywhere" on 'Welcome Wizard'
    And I can see text on "Record LIVE" on 'Welcome Wizard'
      | Old smartphone |
      | Webcam         |
    And I can see navigation component and button "Try it now" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "2" slide on 'Welcome Wizard'
    And I can see switching between smart phone, notebook
    And I can see text "Keep an eye on things at home" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "3" slide on 'Welcome Wizard'
    And I can see text "See what your pats are doing" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "4" slide on 'Welcome Wizard'
    And I can see text "Keep your children in sight" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "5" slide on 'Welcome Wizard'
    And I can see text "Keep in touch with the grandparents" on 'Welcome Wizard'
    When I click on "Arrow right" on 'Welcome Wizard'
    Then I can see "6" slide on 'Welcome Wizard'
    And I can see text "The easiest way to protect your home and family" on 'Welcome Wizard'
    When I click on "Try it now" button on 'Welcome Wizard'
    Then I am on camera overview page
