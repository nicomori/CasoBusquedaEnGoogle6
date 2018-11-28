@webshop @Ecommerce @Desktop @smartfrog @Smoke @Wip
Feature: Change Payment Method

  As a registered customer
  I want to be able Change my payment method
  So I can change my payment to SEPA, Kreditkarte, or PayPal


  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario: Change payment method into SEPA for HW registered user
    When I enter email as "test.user+dev1@smartfrog.com" on shop products page
    And I enter password as "testen" on shop products page
    And I click on "Login" button
    Then I logged in as "test.user+dev1@smartfrog.com"
    And I see product "Komplettlösung", "Speichererweiterung" , "Kamera-Paket" on shop page
    When I click on "Mein Konto" button on shop page
    Then I am on user settings page
    When I click on "Zahlungsmethode ändern" button
    Then I am on shop change payment method page
    When I click on "Zahlungsmethode ändern" on shop change payment method page
    Then I can see "Zahlungsmethode" options
    And check "Zahlungsmethode"  list
      |Zahlungsmethode|
      |Lastschrift|
      |Kreditkarte|
      |PayPal|
    When I choose payment method "Lastschrift" and click button "Weiter"
    Then I am on 'Adyen' details page
    When I enter name "A. Schneider" IBAN "DE87123456781234567890" on 'Adyen' page
    And click on "Weiter" button on 'Adyen' page
    Then I am on complete 'Adyen' page
    And click on "Weiter" button on 'Adyen' page
    Then I am on shop change payment method page
    And I can see message "Zahlungsmethode erfolgreich geändert!" on shop change payment method page


  Scenario: Change payment method into Kreditkarte for HW registered user
    When I enter email as "test.user+dev1@smartfrog.com" on shop products page
    And I enter password as "testen" on shop products page
    And I click on "Login" button
    Then I logged in as "test.user+dev1@smartfrog.com"
    And I see product "Komplettlösung", "Speichererweiterung" , "Kamera-Paket" on shop page
    When I click on "Mein Konto" button on shop page
    Then I am on user settings page
    When I click on "Zahlungsmethode ändern" button
    Then I am on shop change payment method page
    When I click on "Zahlungsmethode ändern" on shop change payment method page
    Then I can see "Zahlungsmethode" options
    And check "Zahlungsmethode"  list
      |Zahlungsmethode|
      |Lastschrift|
      |Kreditkarte|
      |PayPal|
    When I choose payment method "Kreditkarte" and click button "Weiter"
    Then I am on "Kreditkarte" payment page
    When I enter payment details for "Kreditkarte" and click "Weiter"
      | Kreditkarte       | FullName  | cvv | Month | Year |
      | 5555555555554444 | Test User | 737 | 08    | 2018 |
    Then I am on shop change payment method page
    And I can see message "Zahlungsmethode erfolgreich geändert!" on shop change payment method page


  Scenario: Change payment method into PayPal for HW registered user
    When I enter email as "test.user+dev1@smartfrog.com" on shop products page
    And I enter password as "testen" on shop products page
    And I click on "Login" button
    Then I logged in as "test.user+dev1@smartfrog.com"
    And I see product "Komplettlösung", "Speichererweiterung" , "Kamera-Paket" on shop page
    When I click on "Mein Konto" button on shop page
    Then I am on user settings page
    When I click on "Zahlungsmethode ändern" button
    Then I am on shop change payment method page
    When I click on "Zahlungsmethode ändern" on shop change payment method page
    Then I can see "Zahlungsmethode" options
    And check "Zahlungsmethode"  list
      |Zahlungsmethode|
      |Lastschrift|
      |Kreditkarte|
      |PayPal|
    When I choose payment method "PayPal" and click button "Weiter"
    Then I am redirected to PayPal payment page
    And I am enter email "paypaltest@adyen.com" and password "p@ssword" on PayPal page
    And I agree payment on PayPal page
    Then I am on shop change payment method page
    And I can see message "Zahlungsmethode erfolgreich geändert!" on shop change payment method page
