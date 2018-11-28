@webshop @Ecommerce @Desktop @smartfrog @Smoke @Core @jira=QA-3998 @ClassB
Feature: Web shop cart details page

  As a user
  I want to see proper product details on cart page
  So that I can get proper information about product, price, quantity
  
	Background:
		Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page
		
	Scenario Outline: check product details on cart page
	  	When I am select "<country>" country
	    When I click shop button on "Smartfrog" landing page
		Then I click to buy "<productName>"
	    Then I am on shopping cart page
	    And I see product details on cart page
	      | <productName> | <productDetail> | <quantity> | <productPrice> | <productDetail 2nd line> | <totalPrice> | <vat> |
    
	Examples:
	      | country			| productName         | productDetail                 	| productDetail 2nd line                  | quantity | productPrice | totalPrice | vat                        |
	      | United Kingdom 	| Surveillance Bundle | Including 24 hr video history 	| 10% discount on every subsequent camera | 1        | £4.95 / mo.  | £4.95      | Including VAT(20%)  £0.82  |
