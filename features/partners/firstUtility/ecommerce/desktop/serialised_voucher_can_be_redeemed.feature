@Smoke @Partner @FirstUtility @Ecommerce @Webshop @Desktop
Feature: FirstUtility - serialised voucher usage
	
	@jira=QA-2785
	Scenario Outline: FirstUtility - serialised voucher usage
	
	Given I detect the enviroment to execute the test
	Given I access to the webapp "<webapp>"
	And I make a success login with the user "<username>" and the pass "<password>"
	And In the Dashboard I make a click in the "<menu>" tab
	And From the submenu I access to "<subMenu>"
	Then in the dashboard of campaigns I press the button New Campaign
	And I create a new campaign for the partner "<partner>" and serialized
	Then I activate the campaign
	And I update the campaign like a FreeProduct and FreeShipping
	And I add a voucher with a generic code and the total of "<qty>" vouchers
	
	Given I access to the webapp "<secondWebApp>"
    When I click on "Claim now" button on "First Utility" landing page
    Then I am on shopping cart page
    When I enter coupon-code generated for shop cart page
    And Product and delivery should be free
	
    Examples:
      | username			| password				| menu 		| subMenu 	| partner 	| code 	| qty | webapp	| secondWebApp |		
      | nicolas.mori		| 7586ABC4610def$$@@		| Settings	| Campaign	| partner	| 123123	| 1	  | adminui	| first-utility |	