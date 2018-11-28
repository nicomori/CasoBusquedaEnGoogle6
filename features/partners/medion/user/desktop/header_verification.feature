@Smoke @Core @Partner @Medion @User @Mainwebsite @Desktop
Feature: Medion - header link verification

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Medion" landing page

  @jira=QA-3260
  Scenario Outline: Header links verification
  	When I click on link with text "<linkText>"
    And Page has title "<titlePage>" and URL is "<urlPart>"
    Then I can see just shop button on "Medion" landing page
    Then I can see "Medion" promotion logo

    Examples:
      | linkText        | titlePage                                             | urlPart           |
      | Kamera          | HD WLAN Kamera - Der Alarm f						  | /kamera/          |
      | Videoaufnahme   | Videoaufnahmen						                   | /videoaufnahme/   |
      | Einsatzbereiche | Einsatzbereiche                                       | /einsatzbereiche/ |
      | So geht         | So geht                                               | so-gehts          |
