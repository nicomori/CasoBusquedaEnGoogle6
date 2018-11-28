@Wip @Ecommerce @MobileWeb @smartfrog @Core

Feature: Smartfrog - checkout order confirmation

  As a user i want to complete the purchase and see the order confirmation

  Background:
    Given I detect the enviroment to execute the test
    Given I am on "Smartfrog" landing page


  Scenario Outline: user can see the order summary
    When I click on the shop button on the mainpage
    Then I am on shopping product page
    And I can see products on shop product page
    When I click to buy "<productName>"
    Then I am on shopping cart page
    And I click on the checkout button
    Then I am on shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Register now" on shop register page
    Then I am on shop user details page
    When I enter invoice address on DE user details page and click 'Next'
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
    And I click on "Jetzt Kaufen"
    Then I am on the order confirmation page
    And I can see message "Many thanks for your order" on shop payment success page



    Examples:
      | productName    |
      | Komplettlösung |
