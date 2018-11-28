@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - checkout order summary

  As a user i want to see my order summary before i complete the purchase

  Background:
    Given I detect the enviroment to execute the test
    Given I am logged in as "test.user@smartfrog.com" with default password on shop page

  Scenario Outline: vouchers verification test for "Money Value"
    When I click on the menu
    Then I click on the shop button
    Then I am on mobile shopping product page
    And I choose "Komplettloesung" and click on "Jetzt Kaufen"
    Then I am on mobile shopping cart page
    And I click on "Zur Kasse Gehen"
    Then I am on shop user details page
    When I enter invoice address on DE user details page and click 'Weiter'
      | Anrede | Vorname | Nachname | Firma | Strasse    | Nr  | PLZ   | Ort    | Handynummer |
      | Herr   | Test    | QA       |       | Mohrenstr. | 344 | 10117 | Berlin |             |
    Then I am on shop payment page
    When I choose payment method "Kreditkarte" and click button "Weiter"
    Then I am on "Kreditkarte" payment page
    When I enter payment details for 'Kreditkarte' and click 'Weiter'
      | Kartennummer        | Name des karteninhabers | CVV | Monat | Jahr |
      | 4111 1111 1111 1111 | visa                    | 737 | 10    | 2020 |
    And I click on "Weiter"
    Then I am on shop summary page
