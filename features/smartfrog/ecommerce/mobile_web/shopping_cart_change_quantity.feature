@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Core @jira=QA-3959
Feature: Web shop change product quantity on cart details page

  As a user
  I want to change product quantity from cart page
  So that I can change product quantity on cart and get proper price

	Background:
	    Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page
		When I am select "Deutschland" country
		When I click shop button on "Smartfrog" landing page
   		Then I click to buy "Komplettlösung"
   		Then I am on shopping cart page
   		And I see product "Komplettlösung" with quantity "1" on cart page
	
  Scenario: change product quantity on cart page
    When I change quantity to "2" on shop cart page
    And I see product "Komplettlösung" with quantity "2" on cart page
    And total price data displayed on shop cart page
      | total     			| vat                      	|
      | Gesamtsumme			| inkl. MwSt.			  	|
      | 11,30				| (19%) 						|
      | €					| 1,80						|

  Scenario: shopping cart badge is getting updated according to product quantity
    Then I can see "1" quantity near cart icon on cart page
    When I change quantity to "3" on shop cart page
    Then I can see "3" quantity near cart icon on cart page
