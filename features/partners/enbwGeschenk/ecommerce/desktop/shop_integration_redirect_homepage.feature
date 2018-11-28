@Core @Smoke @Partner @EnbwGeschenk @Ecommerce @Mainwebsite @Desktop
Feature: EnbwGeschenk - Shop Link Redirection to Homepage

	@jira=QA-3509
	Scenario: shop integration: should go to homepage without error
  	Given I detect the enviroment to execute the test
	Given I am on "Enbw geschenk" landing page
    And I expect to see the landing page has co-branded header
  	Then click on the shop/redeem button
  	And being redirected to homepage
	