@Smoke @Core @Partner @Medion @User @Mainwebsite @Desktop
Feature: Medion - Landing page verification

  Background:
  	Given I detect the enviroment to execute the test
    Given I am on "Medion" landing page

  @jira=QA-3259
  Scenario: Check the present of medion partner header on Landing page
    Then I can see just shop button on "Medion" landing page
    And I can see "Medion" promotion logo

