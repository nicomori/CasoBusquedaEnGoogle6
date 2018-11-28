@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Core @jira=QA-3975
Feature: Web shop voucher could be deleted

  As a customer
  I want to be able cancel voucher
  So that I can get click and cancel button

	Background:
	    Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page

	Scenario Outline: voucher validation message
	    When I am select "<Country>" country
	    When I click shop button on "Smartfrog" landing page
	    	Then I click to buy "<ProductName>"
	    	Then I am on shopping cart page
	    	When I enter coupon-code "QAVALUE01" on shop cart page
	    	Then I can see voucher item with text "Gutschein" and price "-10,00 €" on shop cart page
	    And the total price "0,00" is displayed on the page
	    And I need to wait this moments: "5000"
	    When I click on link with text "Entfernen"
	    And I need to wait this moments: "7000"
	    And the total price "5,95" is displayed on the page

	Examples:
      | ProductName 		| Country 		| 
      | Komplettlösung 	| Deutschland 	| 
