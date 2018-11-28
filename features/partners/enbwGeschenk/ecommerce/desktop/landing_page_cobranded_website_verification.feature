@Core @Smoke @Partner @EnbwGeschenk @Ecommerce @Mainwebsite @Desktop
Feature: EnbwGeschenk - Cobranded website verification

  @jira=QA-3508
  Scenario: landing page - cobranded website verification
  	Given I detect the enviroment to execute the test
	Given I am on "Enbw eschenk" landing page
	Then verify the page opened
    And I expect to see the landing page has co-branded header
    And I expect to see the promo section is displayed
