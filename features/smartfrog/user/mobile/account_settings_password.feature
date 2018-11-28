@smartfrog @Mobile @User @Wip @webapp @Smoke
Feature: Account settings - password

  Scenario: Login user changing password
    Given I am on application
    When I click "Already registered? >> Log in" button on Smartfrog application
    Then I am on Log in tab smartfrog application
    When I enter email as "test@testy.com"” on Log in smartfrog application tab
    And I enter password as "haslo123" on Log in tab smartfrog application
    And I enter"Log in" button on Log in smartfrog application tab
    Then I am on smartfrog application
    When I click "Camera overview" button on smartfrog application tab
    Then I am on cameras on smartfrog application tab
    When I choose "User account" option on smartfrog application tab
    Then I am on user account option on smartfrog application tab
    When I click on "Change password" button on smartfrog application tab
    Then I am on change password tab on smartfrog application
    When I enter "Old password" with "testy123" on change password tab on smartfrog application
    And I enter "New password" with "test987" on change password tab on smartfrog application
    And I fill "Confirm new password" with "test987" on change password tab on smartfrog application
    And I click Change password" button on change password tab on smartfrog application
    And I see message "Password successfuly changed!" on change password tab on smartfrog application
    And I click "OK" button on change password tab on smartfrog application
    Then I am on user account option on smartfrog application tab

Scenario: Login success registered user
    Given I have registered user "test.user@example.com"
    And I am on main webapp screen
    When I click on the "Log in" button on main webapp screen
    Then I am redirected to login webapp screen
    When I enter "email" as "test.user@example.com" on webapp login screen
    And I enter "password" as "Password" on webapp login screen
    And I click on the "Log In" button on webapp login screen
    Then I see main webapp screen  where I can choose the camera
    And I am logged in as “some@mail.com” on webapp camera overview screen

  Scenario: Success changing password by forget password button registered user
    Given I have registered user “test.user@example.com”
    And I am on main webapp screen
    When I click on the "Log in" button on main webapp screen
    Then I am redirected to webapp login screen
    When I click "Password forgotten" button on Login screen
    Then I am redirected to Password forgotten screen
    When I enter correct email address as "test.user@example.com" on Password forgotten screen
    Then I see green check on Password forgotten screen
    When I click "Send link by email" button on Password forgotten screen
    Then I see confirmation message on Password forgotten screen
    And I get email message
    When I click "Reset password" button on received email
    Then I see new tab in web browser where I can enter New password as “Password”
    When I enter Create password as "Password" on New password page
    And I enter Confirm password as "Password" on New password page
    Then I see green inscription on New password page
    When I click "Saved new password" button on New password page
    Then my password has changed
    And I get email message
    And I am redirected to main website page
    And I am not logged in

