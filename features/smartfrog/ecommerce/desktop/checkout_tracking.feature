@Smoke @Core @Desktop @smartfrog @Ecommerce @Wip @ClassA

Feature: Smartfrog - checkout tracking

Background:
	    Given I detect the enviroment to execute the test
		Given I am on "Smartfrog" landing page

	Scenario: verify impressions
		Then I am on home page
		Then I verify if the console running window.dataLayer we can see the event "impressions"

	Scenario: verify pdp
		Then I am on home page
		Then I make a click in the link "Details"
		Then I verify if the console running window.dataLayer we can see the event "pdp"

	Scenario: verify "loginOrRegister"
		Then I am on home page
		When I click shop button on "Smartfrog" landing page
		Then I click to buy "<productName>"
		Then I am on shopping cart page
		When click to checkout on cart page
		Then I am on the login page
		Then I verify if the console running window.dataLayer we can see the event "loginOrRegister"