@webshop @Ecommerce @Desktop @smartfrog @Smoke @Core @Broken @Wip @ClassB
Feature: Web shop payment method SEPA and success page verification

  As a anonymous and registered customer
  I want to be able proceed to checkout via SEPA payment
  So that I can my SEPA card to pay

  Background:
    Given I am on landing "Deutschland" shop products page

	@jira=QA-4016
	  Scenario: Proceed to checkout as anonymous user HW country via SEPA
	    When I am select "Deutschland" country
	    When I click to buy "Komplettlösung"
	    Then I am on cart page
	    When click to checkout on cart page
	    Then I am on shop login page
	    When click "Weiter" on shop login page
	    Then I am on shop register page
	    When I enter email and repeat it as "test.user+@smartfrog.com"
	    And enter default password on shop register page
	    And click on "Jetzt registrieren" on shop register page
	    And I set newly registered user as Test in Videocloud API
	    Then I am on shop user details page
	    When enter invoice address on shop user details page and click 'Next'
	      | Title | FirstName | Surname   | Company | Street    | StrNum | Zip   | City        |
	      | Herr  | Patrick   | Gremillet |         | Rheinstr. | 99     | 76532 | Baden-Baden |
	    Then I am on shop payment page
	    When I choose payment method "Lastschrift" and click button "Weiter"
	    Then I am on 'Adyen' details page
	    When I enter name "A. Schneider" IBAN "DE87123456781234567890" on 'Adyen' page
	    And click on "Weiter" button on 'Adyen' page
	    And I am on complete 'Adyen' page
	    And click on "Weiter" button on 'Adyen' page
	    Then I am on shop summary page
	    And check invoice address on shop summary page
	      | Patrick Gremillet |
	      | Rheinstr. 99      |
	      | 76532 Baden-Baden |
	      | Deutschland       |
	    And check payment type detail on shop summary page
	      | Lastschrift    |
	      | A. Schneider   |
	      | ********* 7890 |
	    When I agree with terms and click 'Buy now'
	    Then I am on shop payment success page
	    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page
	
	  Scenario: Proceed to checkout as registered user HW country via SEPA and check email at success page
	    And I am logged in as "test.user+sepauser@smartfrog.com" with default password on shop page
	    And I click to buy "Komplettlösung"
	    Then I am on cart page
	    And click to checkout on cart page
	    Then I am on shop user details page
	    Then I see fields with default data preset for logged in user on shop user details page
	      | Title | FirstName | Surname   | Company | Street    | StrNum | Zip   | City        |
	      | Herr  | Patrick   | Gremillet |         | Rheinstr. | 99     | 76532 | Baden-Baden |
	    And I click button 'Next' on shop user details page
	    Then I am on shop summary page
	    And check payment type detail on shop summary page
	      | Lastschrift    |
	      | A. Schneider   |
	      | ********* 7890 |
	    And I agree with terms and click 'Buy now'
	    Then I am on shop payment success page
