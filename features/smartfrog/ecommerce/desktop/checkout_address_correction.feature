@webshop @Ecommerce @Desktop @smartfrog @Smoke @Wip @checkout_address_correction
Feature: Arvato address correction verification

  As a regular user
  I want to see my delivery or invoice address corrected in case my input contains typos

  Background:
  	Given I detect the enviroment to execute the test
    Given I am on "Smartfrog" landing page

  Scenario: Proceed to checkout as anonymous user HW country and verify that address correction is applied for invoice address
    When I am select "Deutschland" country
    Then I click shop button on "Smartfrog" landing page
    When I click to buy "Komplettlösung"
    Then I am on cart page
    When click to checkout on cart page
    Then I am on shop login page
    When click "Weiter" on shop login page
    Then I am on shop register page
    When I enter email and repeat it as generic user
    And enter default password on shop register page 
    And click on "Jetzt registrieren" on shop register page
    #And I set newly registered user as Test in Videocloud API
    Then I am on shop user details page
    And enter invoice address on shop user details page and click 'Next'
      | salutationOption 	| name 			| lastName   	| sign 		| street       | streetNumber 	| postalCode   	| city        	|	phoneNumber	|
      | Herr  						| Patrick   | Gremillet 	| -       | Rheinstrasse | 99     				| 76532 				| Baden-Baden 	| 123123123		|
    Then I am on arvato address correction page
    And I can see arvato address correction options for Invoice address
      | header             | proposal         | proposedAddress                 | usersInput     | usersAddress                       |
      | Rechnungsanschrift | Unser Vorschlag: | Rheinstr. 99, 76532 Baden-Baden | Deine Eingabe: | Rheinstrasse 99, 76532 Baden-Baden |
    #When I click 'Next' on arvato address correction page
    #Then I am on shop payment page
    #When I choose payment method "Credit Card" and click button "Next"
    #Then I am on "Credit card" payment page
    #When I enter payment details for 'Credit Card' and click 'Next'
    #  | CardNumber       | FullName  | cvv | Month | Year |
    #  | 5555555555554444 | Test User | 737 | 08    | 2018 |
    #Then I am on shop summary page
    #And check invoice address on shop summary page
    #  | Patrick Gremillet |
    #  | Rheinstr. 99      |
    #  | 76532 Baden-Baden |
    #  | Deutschland       |
    #And I agree with terms and click 'Buy now'
    #Then I am on shop payment success page


  #Scenario: Proceed to checkout as anonymous user HW country and verify that address correction is applied for delivery address
    #When I am select "Deutschland" country
    #And I click to buy "Komplettlösung"
    #Then I am on cart page
    #When click to checkout on cart page
    #Then I am on shop login page
    #When click "Weiter" on shop login page
    #Then I am on shop register page
    #When I enter email and repeat it as "test.user+@smartfrog.com"
    #And enter default password on shop register page
    #And click on "Jetzt registrieren" on shop register page
    #Then I am on shop user details page
    #And enter invoice address on shop user details page
     # | Title | FirstName | Surname   | Company | Street    | StrNum | Zip   | City        |
      #| Herr  | Patrick   | Gremillet |         | Rheinstr. | 99     | 76532 | Baden-Baden |
    #When choose option "Andere Lieferanschrift" on shop user details page
    #Then addition address form appears on shop user details page
    #When I enter different delivery address on shop user details page
    #  | Title | FirstName | Surname | Company | Street       | StrNum | Zip   | City   |
    #  | Frau  | Test      | User    |         | Mohrenstraße | 34     | 10117 | Berlin |
    #And I click button "Weiter" on shop user details page
    #Then I am on arvato address correction page
    #And I can see arvato address correction options for Delivery address

