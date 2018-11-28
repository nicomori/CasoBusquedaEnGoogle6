@Ecommerce @Desktop @smartfrog @Core @ClassA

Feature: Smartfrog - checkout order summary

  	As a user i want to see my order summary before i complete the purchase

Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "Deutschland" country

	@jira=QA-4034 @nico
	Scenario Outline: user can see the order summary
	    When I click shop button on "Smartfrog" landing page
	Then I click to buy "Komplettlösung"
	Then I am on shopping cart page
	When click to checkout on cart page
	Then I am on shop register first page
    When click in the button continue to make the registration
    When I enter email and repeat it as generic user
    And enter default password on shop register page
    When I click on link with text "Jetzt registrieren"
    And I need to wait this moments: "5000"
    And I set newly registered user as Test in Videocloud API
    When enter invoice address on shop user details page and click 'Next'
      | salutationOption	 | name		 | lastName 	 | sign	 | street   		 | streetNumber	 | postalCode  	 | city        | phoneNumber |
      | Herr 			 | Patrick  	 | Gremillet	 | 		 | Rheinstr.	 	 | 99    		 | 76532			 | Baden-Baden | 	        |
    Then I am on shop payment page
    When I choose payment method "Credit card" and click button "Weiter"
    When I enter payment details for 'Credit Card' and click 'Next'
      | cardNumber       | fullName  | cvv | month | year |
      | 5555555555554444 | Test User | 737 | 08    | 2018 |
    Then I am on shop summary page
    And verify if this data is displayed correctly in the website
    		| Patrick Gremillet	 |
      	| 99					 |
      	| Test User     		 |
      	| ********* 4444		 |
	When I agree with terms and click 'Buy now'
	And Verify if we can see corretly displayed the success confirmation page
	And In the success purchase page, I make click in the button to see the details of the product.
	And In the user dashboard I close the popup
	And Make click in the button Mein Konto
    Then select the link of last orders
    And In the cancelation screen press the button to cancel the order
    Then verify if the message appear with the confirmation of the order is completed
	
	    Examples:
	      | productName    |
	      | Komplettlösung |
