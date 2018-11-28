@smartfrog @Desktop @User @Smoke @Core @Wip
Feature: Smartfrog - tracking GTM

	Background:
	    Given I detect the enviroment to execute the test

	Scenario Outline: verify the GTM
		When I visit this page "<page>"
		Then verify in the console if we can see this "<gtm-code>" with the command window.google_tag_manager
		
	Examples:
	| page 											 | gtm-code		 |
	| https://www.smartfrog.com/de-de/				 | GTM-T67TRW	 |
	| https://www.sf-test1.com/de-de/				 | GTM-T9HRQJ	 |
	| https://www.sf-dev1.com/de-de/					 | GTM-N58H7S	 |
	| https://app.smartfrog.com/de-de/				 | GTM-T67TRW	 |
	| https://app.sf-test1.com/de-de/				 | GTM-T9HRQJ	 |
	| https://app.sf-dev1.com/de-de/					 | GTM-N58H7S	 |
	| https://www.smartfrog.com/de-de/shop/products	 | GTM-T67TRW	 |
	| https://www.sf-test1.com/de-de/shop/products	 | GTM-T9HRQJ	 |
	| https://www.sf-dev1.com/de-de/shop/products	 | GTM-N58H7S	 |
