@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - shopping cart remove products

  Scenario Outline:  remove product from shopping cart
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
    When I click button remove product on shop cart page
    And I can see message "Your cart is empty" on shop cart page

    Examples:
      | userEmail                      | password   | cameraOverview |  | shop |
      #| test.user+dev100@smartfrog.com | Test123!!! | Camera Overview| Shop |
      #| test.user+dev100@smartfrog.com | Test123!!! | Kamera-Übersicht| Smartfrog Cam kaufen |
      | English  | login           | test.user+dev100@smartfrog.com | Test123!!! |

