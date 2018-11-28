@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Core @jira=QA-3945 
Feature: Web shop user can buy 2 different product

  As a user
  I want to buy few different products
  So that I can choose 2 different product and get correct price
  
  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page

	@Broken @Issue=QA-3963
  Scenario Outline:
    And I click on the shop button on the mainpage
    Then I click to buy "<productName1>"
    And I am on shopping cart page
    And I can see "<productName1>" with quantity "<quantity1>" and "<price1>" in the cart page
    And I click on the shop button on the cart page
    Then I click to buy "<productName2>"
    And I am on shopping cart page
    And I can see "<productName1>" with quantity "<quantity1>" and "<price4>" in the cart page
    And I can see "<productName2>" with quantity "<quantity1>" and "<price2>" in the cart page
    And I click on the shop button on the cart page
    Then I click to buy "<productName2>"
    And I am on shopping cart page
    And I can see "<productName1>" with quantity "<quantity1>" and "<price4>" in the cart page
    And I can see "<productName2>" with quantity "<quantity2>" and "<price3>" in the cart page
    And the total price "<total>" is displayed on the page

    Examples:
      | webapp | productName1   | productName2 | quantity1 | quantity2 | price1		 	| price2		 | price3	| total	   | price4			|
      |        | Komplettlösung | Kamera-Paket | 1         | 2         | 5,95 € / mtl. 	| 149,00 €	 | 283,00 € 	| 279,94 € |  5,35 € / mtl.  |


