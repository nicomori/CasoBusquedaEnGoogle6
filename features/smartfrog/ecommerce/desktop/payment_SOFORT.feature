@smartfrog @Ecommerce @Desktop @webshop @BadCore @Smoke
Feature: Web shop payment method SOFORT and success page verification

  As a anonymous and registered customer
  I want to be able proceed to checkout with Sofortüberweisung payment

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "Deutschland" country
  
  @jira=QA-3999
    Scenario: Proceed to checkout as anonymous user HW country with Sofortüberweisung
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
    When I choose payment method "Sofort" and click button "Weiter"
    Then I am on shop summary page
    And verify if this data is displayed correctly in the website
    		| Patrick Gremillet	 |
      	| 99					 |
      	| Sofort				 |
    When I agree with terms and click 'Buy now'
    And I am in the website of sofort, in the first page
	And in the sofort page I set this kontonumber "123456789" and this pin "1234" and press in continue
	And I am in the website of sofort, in the second page
	And in the second page of sofort select the first radiobutton, and press in continue
	And I am in the website of sofort, in the last page
	Then in the last page of the sofort site, set this tan value "12345" and select the checkbox and press continue
    And In the success purchase page, I make click in the button to see the details of the product.
	And In the user dashboard I close the popup
	And Make click in the button Mein Konto
    Then select the link of last orders
    And In the cancelation screen press the button to cancel the order
    Then verify if the message appear with the confirmation of the order is completed

  @Broken
  Scenario: Proceed to checkout as registered user HW country with saved Sofortüberweisung data
    And I am logged in as "ls.tester91+sofort@gmail.com" with default password on shop page
    And I click to buy "Komplettlösung"
    Then I am on cart page
    And click to checkout on cart page
    Then I am on shop user details page
    Then I see fields with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname   | Company   | Street    | StrNum | Zip   | City        |
      | Herr  | Patrick   | Gremillet | Smartfrog | Rheinstr. | 99     | 76532 | Baden-Baden |
    And I click button 'Next' on shop user details page
    Then I am on shop summary page
    When I click on change payment method button on shop Check page
    Then I am on shop change payment method page
    When I choose payment method "Sofort" and click button "Weiter"
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Patrick Gremillet |
      | Smartfrog         |
      | Rheinstr. 99      |
      | 76532 Baden-Baden |
      | Deutschland       |
    And payment type is "Sofort" detail on shop summary page
    When I agree with terms and click 'Buy now'
    Then I am redirected to Sofortüberweisung payment page
    Then I login to Sofortüberweisung page
    And I select bank account on Sofortüberweisung page
    And I enter TAN on Sofortüberweisung page
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page
