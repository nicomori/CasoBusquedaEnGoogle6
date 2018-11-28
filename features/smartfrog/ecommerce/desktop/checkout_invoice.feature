@smartfrog @Desktop @Ecommerce @Smoke @Core @ClassA

Feature: Invoice verification

  As a anonymous and registered customer
  i want to be able to buy a cam and get a invoice

	@jira=QA-4030 @Issue=@INTR-92 @Broken
    Scenario Outline: A anonymous user can buy a cam and get a invoice
    		Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page
		When I am select "Deutschland" country
      	When I click shop button on "Smartfrog" landing page
		Then I click to buy "<productName>"
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
		Then access to the last invoices
		And I need to wait this moments: "333333333"
		
		#When i am on the User information page
		#Then i click on "Alle Rechnungen ansehen"
		#When i am on the invoice page
		#Then i click on the last invoice of the current day
		#And i see the invoice with the correct "<QTY>", "<description>" , "<billingcycle>", "<discount>", "<price>" , "<total>"

      Examples:
        | productName    | QTY | description              | billingcycle | discount | price      | total      |
        | Komplettlösung | 1 x | Smartfrog Komplettlösung | Monatlich    |          | 5.95 EUR   | 5.95 EUR   |
        | Kamera-Paket   | 1 x | Smartfrog Cam            | Einmalig     |          | 149.00 EUR | 149.00 EUR |


	@jira=QA-4031
    Scenario Outline: A registered user with save payment data can buy a cam and get a invoice
    		Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page
		When I am select "Deutschland" country
		And I click on the shop button on the cart page
      	Then I click to buy "<productName>"
      	Then click to checkout on cart page
      	Then in the shop login process, make click in the radiobutton of existing user
      	And In the process to buy a product make the login with this user "ls.tester91+dev1@gmail.com" and pass "123456"
        When click in the button continue to make the registration
        And in the registration address page, make click in next
        When I agree with terms and click 'Buy now'
		And Verify if we can see corretly displayed the success confirmation page
		And In the success purchase page, I make click in the button to see the details of the product.
		And In the user dashboard I close the popup
		And Make click in the button Mein Konto
		Then access to the last invoices
		Then verify the date of the first invoice
		Then verify the month of the first invoice
		Then verify the year of the first invoice
		Then verify the total amount of the first invoice, and compare with this amount: "<price>"
		
		And Make click in the button Mein Konto
    		Then select the link of last orders
    		And In the cancelation screen press the button to cancel the order
    		Then verify if the message appear with the confirmation of the order is completed
	
      Examples:
        | productName    | QTY | description              | billingcycle | discount | price	 | total	 |
        | Komplettlösung | 1 x | Smartfrog Komplettlösung | Monatlich    | 10%      | 5.35	 | 5.35	 |
        #| Kamera-Paket   | 1 x | Smartfrog Cam            | Einmalig     | 10%      | 139		 | 139	 |


     Scenario: A anonymous user can buy a full-price-cam with a voucher code and get a invoice
       #Then I click to buy "Kamera-Paket"
       #When I am on cart page
       #When I enter coupon-code "QAFREEPROD1" on shop cart page
       #And click on button "Einlösen" on shop cart page
       #Then click to checkout on cart page
       #When I am on shop login page
       #When click "Weiter" on shop login page
       #Then I am on shop register page
       #When I enter email and repeat it as "test.user+@smartfrog.com"
       #And enter default password on shop register page
       #And click on "Jetzt registrieren" on shop register page
       #Then I am on shop user details page
       #When enter invoice address on shop user details page and click 'Next'
         #| Title | FirstName | Surname | Company | Street     | StrNum | Zip    | City   |
         #| Herr  | Test      | Test    |         | Street     | 123    | 12345  | City   |
       #Then I am on shop summary page
       #And I agree with terms and click 'Buy now'
       #When I am on shop payment success page
       #Then i click on "zur Kameraübersicht"
       #When i am on the Camera Overview
       #Then i click on "Mein Konto"
       #When i am on the User information page
       #Then i click on "Alle Rechnungen ansehen"
       #When i am on the invoice page
       #Then i click on the last invoice of the current day
       #And i see the invoice with the correct description
        #| ANY. | BESCHREIBUNG  | ZEITRAUM | RABATT | STÜCKPREIS | TOTAL       |
        #| 1 x  | Smartfrog Cam | Einmalig |        | 149.00 EUR | 149.00 EUR  |
        #| 1 x  | Coupon        | Einmalig |        |            | -149.00 EUR |



