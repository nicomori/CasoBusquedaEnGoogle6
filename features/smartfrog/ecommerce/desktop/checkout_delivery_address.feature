@webshop @Ecommerce @Desktop @smartfrog @Smoke @Core @ClassA
Feature: Web shop user can specify different delivery address

	As a desktop user
	I want to be able specify delivery address
	So that I can specify different address for delivery and for payment

	Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "Deutschland" country

	@jira=QA-4027 @nico
	Scenario: user can specify different delivery address
		When I click shop button on "Smartfrog" landing page
		Then I click to buy "Komplettlösung"
		Then I am on shopping cart page
		When click to checkout on cart page
		Then I am on shop register first page
		When click in the button continue to make the registration
	    When I enter email and repeat it as generic user
	    And enter default password on shop register page
	    When I click on link with text "Jetzt registrieren"
	    And I need to wait this moments: "3000"
	    And I set newly registered user as Test in Videocloud API
	    When enter invoice address on shop user details page without click next
	      | salutationOption	 | name		 | lastName 	 | sign	 | street   		 | streetNumber	 | postalCode  	 | city		 | phoneNumber |
	      | Herr 			 | Test1  	 | User1		 | 		 | StreetName1 	 | 111    		 | 120767		 | Berlin	 | 	      	   |
    		And select the checkbox of add a new address
    		And I need to wait this moments: "3000"
    		When I enter different delivery address on shop user details page
	      | salutationOption	 | name		 | lastName 	 | sign	 | street   		 | streetNumber	 | postalCode  	 | city		 | phoneNumber |
	      | Herr 			 | Test2  	 | User2 	 | 		 | StreetName2 	 | 222    		 | 120767		 | Munich	 | 	      	   |
    		And in the registration address page, make click in next
	    Then I am on shop payment page
	    And I need to wait this moments: "3000"
	    When I choose payment method "Credit card" and click button "Weiter"
	    When I enter payment details for 'Credit Card' and click 'Next'
	      | cardNumber       | fullName  | cvv | month | year |
	      | 5555555555554444 | Test User | 737 | 08    | 2018 |
	    Then I am on shop summary page
	    And check delivery address on shop summary page
	    		| Test2 User2	|
		 	| Munich     	|
		 	| StreetName2 	|
		 	| 222 	 		|
		 	| 120767 	 	|
		And check invoice address on shop summary page
	    		| Test1 User1	|
		 	| Berlin     	|
		 	| StreetName1 	|
		 	| 111 	 		|
		 	| 120767 	 	|
   		