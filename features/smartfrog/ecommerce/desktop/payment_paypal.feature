@Ecommerce @Desktop @smartfrog @webshop @Core @Smoke @ClassB
Feature: Web shop payment method PayPal

  As a anonymous and registered customer
  I want to be able proceed through checkout with PayPal payment method
  So that I can use my PayPal to pay

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "Deutschland" country
  
  @jira=QA-4015 @Broken
    Scenario: Proceed to checkout as anonymous user HW country via PayPal
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
    When I choose payment method "PayPal" and click button "Weiter"
    Then I am on shop summary page
    And verify if this data is displayed correctly in the website
    		| Patrick Gremillet	 |
      	| 99					 |
   	When I agree with terms and click 'Buy now'
    Then I am redirected to PayPal payment page
    And I am enter email "paypaltest@adyen.com" and password on PayPal page
    And I agree payment on PayPal page
    And In the success purchase page, I make click in the button to see the details of the product.
	And In the user dashboard I close the popup
	And Make click in the button Mein Konto
    Then select the link of last orders
    And In the cancelation screen press the button to cancel the order
    Then verify if the message appear with the confirmation of the order is completed

	@Wip
  Scenario: Proceed to checkout as registered user HW country with saved PayPal data
    And I am logged in as "test.user+paypal@smartfrog.com" with default password on shop page
    And I click to buy "Komplettlösung"
    Then I am on cart page
    And click to checkout on cart page
    Then I am on shop user details page
    Then I see fields with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname | Company   | Street     | StrNum | Zip   | City   |
      | Herr  | Test      | User    | Smartfrog | Mohrenstr. | 34     | 10117 | Berlin |
    And I click button 'Next' on shop user details page
    Then I am on shop summary page
    And I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see proper email "test.user+paypal@smartfrog.com" on shop payment success page
    And I can see delivery address on shop success page
      | Test User     |
      | Smartfrog     |
      | Mohrenstr. 34 |
      | 10117 Berlin  |
      | Deutschland   |
    And I can see order number on shop success page
