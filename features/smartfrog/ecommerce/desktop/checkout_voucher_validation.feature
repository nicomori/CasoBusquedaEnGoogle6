@webshop @Ecommerce @Desktop @smartfrog @Smoke @Core @jira=QA-3955 @ClassA
Feature: Web shop voucher error message validation

  As a customer
  I want to be able checkout get information that voucher invalid
  So that I can get validation message on German and English languages

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page

  Scenario Outline: voucher validation message
    When I am select "<Country>" country
    When I click shop button on "Smartfrog" landing page
    Then I click to buy "<ProductName>"
    Then I am on shopping cart page
    When I enter coupon-code "<couponCode>" on shop cart page
    When I click on link with text "<useVoucherButton>"
    Then verify if this text "<validationMessageForInvalidVoucher>" appear correctly displayed in the page

    Examples:
      | Country        | ProductName         | useVoucherButton | couponCode         | validationMessageForInvalidVoucher   |
      | United Kingdom | Surveillance Bundle | Redeem           | invalidCouponeCode | The entered coupon is invalid.       |
      | Deutschland    | Komplettlösung      | Einlösen         | invalidCouponeCode | Der eingegebene Coupon ist ungültig. |
      | United Kingdom | Surveillance Bundle | Redeem           |                    | Please enter a coupon code           |
      | Deutschland    | Komplettlösung      | Einlösen         |                    | Bitte einen Coupon-Code eingeben     |
      | United Kingdom | Camera package      | Redeem           | AUTONONQALIFIEDP   | The entered coupon is invalid.       |
      | Deutschland    | Kamera-Paket        | Einlösen         | AUTONONQALIFIEDP   | Der eingegebene Coupon ist ungültig. |
      | United Kingdom | Camera package      | Redeem           | AUTOMAXUSAGE       | The entered coupon is invalid.       |
      | Deutschland    | Kamera-Paket        | Einlösen         | AUTOMAXUSAGE       | Der eingegebene Coupon ist ungültig. |
