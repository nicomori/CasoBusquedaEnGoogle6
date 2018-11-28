@webshop @Ecommerce @Desktop @smartfrog @Smoke @Core @jira=QA-3944  @ClassB
Feature: Web shop delete product from cart

  As a user
  I want to remove product from cart page
  So that I can click on remove button and delete product from cart
  
  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page

  Scenario Outline: cancel product from cart page
    And I click on the shop button on the mainpage
    Then I click to buy "<productName>"
    Then I am on cart page
    When I click button remove product on shop cart page
    Then I can see message "<message>" on shop cart page
    And I click on button "<buttonName>" on shop cart page
    Then I am on shopping product page

    Examples:
      | productName    | message        | buttonName |
      | Komplettlösung | Dein Warenkorb | Zum Shop   |
