@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - checkout order confirmation


  Scenario Outline: user can see the order summary
    Given I detect the enviroment to execute the test
    And I make click in the login button
    When I enter email as "<userEmail>" on mobile login page
    And I enter password as "<password>" on mobile login page
    And I tap login button on mobile login page
    Then I am redirected to welcome page
    And I tap on "<cameraOverview>"  button
    And I tap on hamburger button
    And I tap on "<shop>" button
    And I tap to buy "Komplettlösung"
    And I tap on the checkout button
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
    And I click on "Jetzt Kaufen"
    Then I am on the order confirmation page
    And I can see message "Many thanks for your order" on shop payment success page

    Examples:
      | userEmail                      | password   | cameraOverview |  | shop |
      #| test.user+dev100@smartfrog.com | Test123!!! | Camera Overview| Shop |
      #| test.user+dev100@smartfrog.com | Test123!!! | Kamera-Übersicht| Smartfrog Cam kaufen |