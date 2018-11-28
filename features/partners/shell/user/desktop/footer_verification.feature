@Partner @shell @Smoke @Desktop @Core @webshell @User @Partner
Feature: Shell - footer components verification

  Background:
  	Given I detect the enviroment to execute the test
	Given I am on "Shell" landing page

  @jira=QA-3677
  Scenario Outline: Footer links
    When I click on link with text "<linkName>"    
    Then Page opened in new tab has title "<pageTitle>" and URL is "<urlPart>"
    And I can see Shell promotion logo

    Examples:
      | linkName    | pageTitle		| urlPart                   |
      | Über uns    | ber uns		| /ueber-uns                |
      | Kontakt     | Kontakt		| /kontakt                  |
      | Energiemix  | Energiemix		| /energiemix               |
      | AGB         | Rechtliche		| /rechtliche-informationen |
