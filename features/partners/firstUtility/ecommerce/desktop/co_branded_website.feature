@Core @Smoke @Partner @FirstUtility @Ecommerce @Mainwebsite @jira=QA-2250 @Desktop

Feature: FirstUtility - Co-branded website

  	Background:
	  	Given I detect the enviroment to execute the test
	    Given I am on "First Utility" landing page

	Scenario: Badge component on landing FU page
    		Then I can see "2" badge component on "First Utility" page
    	
	Scenario: Check content of promo section on Landing page
	    Then I can see promo section component on "First Utility" landing page with header "At a glance: Loyalty Reward worth £123"
	    And I can see promo section component contains
	      | Downloadable Smartfrog App            |
	      | Smartfrog HD Cam with many functions |
	      | Live View & Cloud Storage            |
	      | Only for loyal customers             |
	      
	Scenario Outline: Badge component FU site pages
	    When I click on link with text "<linkText>"
	    And I can see "1" badge component on "First Utility" page
	    Then I click in the button back in the browser
	    When I click on "Claim now" button on "First Utility" landing page
	    Then I am on "First Utility" shopping cart page
    
	    Examples:
	      | linkText      |
	      | Camera        |
	      | Video history |
	      | Uses          |
	      | How it works  |