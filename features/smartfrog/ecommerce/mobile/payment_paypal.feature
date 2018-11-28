@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - payment paypal

Scenario: create a new user and put paypal like a payment method
	Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "Deutschland" country
	When I click shop button on "Smartfrog" landing page
	Then I click to buy "Komplettlösung"
	Then I am on shopping cart page
	When click to checkout on cart page
	Then press in the button "Weiter"
	Then in the register page, create a generic user and complete all the fields
	Then press in the button "Weiter"
	Then in the address form complete all fields	
	Then press in the button "Weiter"
	Then I am on payment method page
	And I select the second option of Paypal
	Then press in the button "Weiter"
	Then I am on summary page
	