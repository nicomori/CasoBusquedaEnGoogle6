@Desktop @User @webshell @shell @jira=qa-3656 @Smoke @Partner @Partner
Feature: Shell - Landingpage verification

  Background:
  	Given I detect the enviroment to execute the test
	Given I am on "Shell" landing page

  Scenario: Check the present of zipcode input on Landing page
    Then I can see the input zipcode
    And I can see Shell promotion logo

  Scenario Outline: Check content of promo section on Landing page
    Then I can see the input zipcode
    Then I can see this text "<someTextToFind>" displayed in the site
    
    Examples:
      | someTextToFind                                             |
      | Strom & Sicheres Zuhause 24                           |
      | Inkl. Gratis                                          |
      | Sicherheitspaket                                      |
      | 150                                                   |
      | 2 Jahre                                               |
      | Preisgarantie                                         |
      | Power ohne Ende und mehr Sicherheit für Ihr Zuhause!  |
      | Berechnen Sie Ihren individuellen                     |
