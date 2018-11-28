@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - checkout voucher redeem

  As a customer
  I want to be able checkout with money voucher
  So that I can specify voucher and get proper discount

  Background:
    Given I detect the enviroment to execute the test
    Given I am logged in as "test.user@smartfrog.com" with default password on shop page

  Scenario Outline: vouchers verification test for "Money Value"
    When I click on the menu
    Then I click on the shop button
    Then I am on mobile shopping product page
    And I choose "Komplettloesung" and click on "Jetzt Kaufen"
    Then I am on mobile shopping cart page
    When I enter coupon-code "<voucherName>" on shop cart page
    Then I can see voucher item with text "Gutschein" and price "<voucherPrice>" on shop cart page
    And the total price "4,35" is displayed on the page

    Examples:
      | voucherName | voucherPrice |
      | QAVALUE01   | -1 €         |