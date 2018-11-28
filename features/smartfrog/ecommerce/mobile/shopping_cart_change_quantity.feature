@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - shopping cart change quantity

  Scenario Outline: change product quantity from shopping cart
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
    Then I am redirected to shop cart page
    And I see product "Komplettlösung" with quantity "1" on cart page
    When I change quantity to "2" on shop cart page
    And I see product "Komplettlösung" with quantity "2" on cart page
    And total price data displayed on shop cart page
      | total     			| vat                      	|
      | Gesamtsumme			| inkl. MwSt.			  	|
      | 11,30				| (19%) 						|
      | €					| 1,80						|

    Examples:
      | userEmail                      | password   | cameraOverview |  | shop |
      #| test.user+dev100@smartfrog.com | Test123!!! | Camera Overview| Shop |
      #| test.user+dev100@smartfrog.com | Test123!!! | Kamera-Übersicht| Smartfrog Cam kaufen |