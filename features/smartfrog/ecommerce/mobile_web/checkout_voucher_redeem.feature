@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Core @jira=QA-3987
Feature: Web shop voucher Money Value, Free Product, Free Billing Cycle

  As a customer
  I want to be able checkout with money voucher
  So that I can specify voucher and get proper discount

	Background:
	    Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page
		Given I am logged in as "test.user@smartfrog.com" with default password on shop page
		Then press the button shop in the header bar in the dashboard of the user logged 
		Then I click to buy "Komplettlösung"
		Then I am on shopping cart page
	
  Scenario Outline: vouchers verification test for "Money Value" and "Free Product"
	When I enter coupon-code "<voucherName>" on shop cart page
    Then I can see voucher item with text "Voucher" and price "<voucherPrice>" on shop cart page
    And the total price "0,00" is displayed on the page
    
    Examples:
      | voucherName     | voucherPrice | total              | vat                      |
      | QAVALUE01       | -10,00 €     | Gesamtsumme 0,35 € | inkl. MwSt. (19%) 0,06 € |
    
