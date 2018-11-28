@Smoke @Partner @Medion @User @Webshop @Webapp @Mainwebsite @Desktop @Wip

Feature: Medion - Purchase flow

  As a medion unregistered user
  I want to be able to proceed to checkout via credit card payment
  So that i can pay with my credit card
  At the end the user's information will be stored as specific column partner in database

  @jira=QA-3672
  Scenario: Not registered user E2E flow via Medion shop button
  	Given I detect the enviroment to execute the test
    Given I am on "Medion" landing page
    Then I can see just shop button on "Medion" landing page
    When I click shop button on "Medion" landing page
    And I click to buy "Komplettlösung"
    Then I am on shopping cart page

    When I click on button "Zur Kasse gehen" on shop cart webpage
    Then I am on shop login page
    When click "Weiter" on shop login page
    Then I am on shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Jetzt registrieren" on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I am on shop user details page
    When enter invoice address on shop user details page and click 'Next'
      | Title | FirstName | Surname | Company | Street     | StrNum | Zip   | City        |
      | Herr  | Test1     | Test2   |         | StreetName | 99     | 76532 | Baden-Baden |
    Then I am on shop payment page
    When I choose payment method "Kreditkarte" and click button "Weiter"
    Then I am on "Kreditkarte" payment page
    When I enter payment details for 'Credit Card' and click 'Next'
      | CardNumber       | FullName  | cvv | Month | Year |
      | 5555555555554444 | Test User | 737 | 08    | 2018 |
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Test1 Test2       |
      | Rheinstr. 99      |
      | 76532 Baden-Baden |
      | Deutschland       |
    And check payment type detail on shop summary page
      | Kreditkarte    |
      | Test User      |
      | ********* 4444 |
    When I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page
    And I can see customer service number "Deutschland 030 - 991 99 991" on success page


  @jira=QA-3673
  Scenario: Registered user E2E flow
    Given I am on Medion page
    When I click shop button on Medion landing page
    And I click to buy "Kamera-Paket"
    Then I am on cart page
    When I click on button "Zur Kasse gehen" on shop cart webpage
    Then I am on shop login page
    When I select option "Ich habe bereits ein Passwort." on shop login page
    And I enter email as "test.user+medi01@smartfrog.com" on shop login page
    And I enter password as "Test123!!!" on shop login page
    And click "Weiter" on shop login page
    And I click button "Weiter" on shop user details page
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Test1 Test2       |
      | Rheinstr. 99      |
      | 76532 Baden-Baden |
      | Deutschland       |
    And check payment type detail on shop summary page
      | Kreditkarte    |
      | Test User      |
      | ********* 4444 |
    When I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page
    And I can see customer service number "Deutschland 030 - 991 99 991" on success page
    