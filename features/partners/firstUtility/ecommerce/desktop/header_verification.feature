@Core @Smoke @Partner @FirstUtility @Ecommerce @Mainwebsite @jira=QA-2312 @Desktop
Feature: First Utility header components on main page

	Scenario: First Utility landing page
	Given I detect the enviroment to execute the test
	Given I am on "First Utility" landing page
    Then Page has title "Smartfrog.com-First Utility" and URL is "/first-utility"
    And I can see First Utility promo header with text "First utility customer exclusive offer"
    And I can see Shop button on First Utility page

  	Scenario Outline: First Utility promo header is preserved on link click
    Given I detect the enviroment to execute the test
	Given I am on "First Utility" landing page
    When I click on link with text "<linkText>"
    Then Page has title "<pageTitle>" and URL is "<pageUrl>"
    #And I can see First Utility promo header with text "First utility customer exclusive offer"
    And I can see Shop button on First Utility page
    

    Examples:
      | linkText      | pageTitle                                                       | pageUrl         |
      | Camera        | Camera                                                          | /camera         |
      | Video history | Save video recordings to the cloud \| smartfrog - smartfrog.com | /video-history  |
