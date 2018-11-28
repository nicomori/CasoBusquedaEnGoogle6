@Core @Smoke @Partner @Enbw @Ecommerce @Mainwebsite @Desktop
Feature: Enbw - Redirect to Smartfrog Page should occur

    @jira=QA-3377
    Scenario: When opening Enbw link redirect to Smartfrog landing page occurs
    		Given I detect the enviroment to execute the test
		Given I am on "enbw" landing page
    		Then verify the page opened
