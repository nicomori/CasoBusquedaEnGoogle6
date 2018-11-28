@Ecommerce @MobileWeb @smartfrog @webshop @Core @Smoke @Wip
Feature: Web shop payment method PayPal

  As a anonymous and registered customer
  I want to be able proceed through checkout with PayPal payment method
  So that I can use my PayPal to pay

  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario: Proceed to checkout as anonymous user HW country via PayPal
    When I am select "Deutschland" country
    When I click to buy "Komplettlösung"
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
      | Title | FirstName | Surname | Company | Street     | StrNum | Zip    | City   |
      | Herr  | Test1     | Test2   |         | StreetName | 123    | 120767 | Berlin |
    Then I am on shop payment page
    When I choose payment method "PayPal" and click button "Weiter"
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Test1 Test2    |
      | StreetName 123 |
      | 120767 Berlin  |
      | Deutschland    |
    And payment type is "PayPal" detail on shop summary page
    When I agree with terms and click 'Buy now'
    Then I am redirected to PayPal payment page
    And I am enter email "paypaltest@adyen.com" and password on PayPal page
    And I agree payment on PayPal page
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page
    And I can see customer service number "Deutschland 030 - 991 99 991" on success page


  Scenario: Proceed to checkout as registered user HW country with saved PayPal data
    And I am logged in as "test.user+paypal@smartfrog.com" with default password on shop page
    And I click to buy "Komplettlösung"
    Then I am on cart page
    And click to checkout on cart page
    Then I am on shop user details page
    Then I see fields with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname | Company   | Street     | StrNum | Zip   | City   |
      | Herr  | Test      | User    | Smartfrog | Mohrenstr. | 34     | 10117 | Berlin |
    And I click button 'Next' on shop user details page
    Then I am on shop summary page
    And I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see proper email "test.user+paypal@smartfrog.com" on shop payment success page
    And I can see delivery address on shop success page
      | Test User     |
      | Smartfrog     |
      | Mohrenstr. 34 |
      | 10117 Berlin  |
      | Deutschland   |
    And I can see order number on shop success page
