@smartfrog @User @Mobile @Core @Smoke
Feature: Forgot password - mobile

  As a registered user
  I want to be able to proceed forgot password functionality via mobile app
  So that I can reset my password

  Scenario Outline: Reset password as registered user
    Given Application is opened
    And I am on "<language>" mobile home page
    When I tap "<loginButtonText>" button on mobile home page
    Then I am redirected to mobile login page
    When I tap "<forgotPasswordText>" on mobile login page
    Then I am redirected to forgot password page
    When I enter email as "<userEmail>" on forgot password page
    And I tap  on "<sendLinkButtonText>" button on forgot password page
    Then pop up is displayed with "<successPopupText>" texts
    And tap on "OK" button
    And i am redirected back to mobile login page

    Examples:
      | language | loginButtonText | userEmail                      | sendLinkButtonText       | successPopupText                 |
      | Deutsch  | login           | test.user+dev100@smartfrog.com | Link per E-mail zusenden | Wiederherstellungs-E-Mail gesendet |
      | English  | log in          | test.user+dev100@smartfrog.com | Send link by email       | Recovery email sent                |