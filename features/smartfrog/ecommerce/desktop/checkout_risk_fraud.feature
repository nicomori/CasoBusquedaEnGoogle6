@webshop @Ecommerce @Desktop @smartfrog @Smoke
Feature: Web shop Risk $ Fraud. Arvato SEPA IBAN verification

  As product owner
  I want to have SEPA bank account check
  So that I can get verification when customer enter IBAN number

  Background:
    Given I am on landing "Deutschland" shop products page

  @Broken
  Scenario: Proceed to checkout as anonymous user HW country via SEPA valid address bad IBAN
    When I am select "Deutschland" country
    And I click to buy "Komplettlösung"
    Then I am on cart page
    When click to checkout on cart page
    Then I am on shop login page
    When click "Weiter" on shop login page
    Then I am on shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Jetzt registrieren" on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I am on shop user details page
    When enter invoice address on shop user details page and click 'Next'
      | Title | FirstName | Surname   | Company | Street    | StrNum | Zip   | City        |
      | Herr  | Patrick   | Gremillet |         | Rheinstr. | 99     | 76532 | Baden-Baden |
    Then I am on shop payment page
    When I choose payment method "Lastschrift" and click button "Weiter"
    Then I am on 'Adyen' details page
    When I enter name "A. Schneider" IBAN "DE52100208900002626853" on 'Adyen' page
    And click on "Weiter" button on 'Adyen' page
    And I am on complete 'Adyen' page
    And click on "Weiter" button on 'Adyen' page
    Then I am on shop change payment method page
    And I can see message on shop change payment method page
      | Es tut uns leid                                                             |
      | Im Moment können wir dir SEPA Lastschrift nicht als Bezahlmethode anbieten. |
    When I click on "Weiter" on shop change payment method page
    Then I am on shop payment page

