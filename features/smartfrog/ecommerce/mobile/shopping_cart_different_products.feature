@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - shopping cart different products

  Scenario Outline: shop 2 diffrent products in shopping cart
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
    And I tap back button on shop cart page
    And I tap to buy "Kamera-Paket"
    And I can see "<productName1>" with quantity "<quantity1>" and "<price1>" in the cart page
    And I can see "<productName2>" with quantity "<quantity2>" and "<price2>" in the cart page
    And the total price "<total>" is displayed on the page

    Examples:
      | userEmail                      | password   | cameraOverview   | shop                 | productName1   | productName2 | quantity1 | quantity2 | price1       | price2  | total    |
      | test.user+dev100@smartfrog.com | Test123!!! | Camera Overview  | Shop                 | Komplettlösung | Kamera-Paket | 1         | 1         | 5,95 € / mtl. | 149,00 € | 145,94 € |
      | test.user+dev100@smartfrog.com | Test123!!! | Kamera-Übersicht | Smartfrog Cam kaufen |
