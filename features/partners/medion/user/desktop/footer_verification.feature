@User @Core @Smoke @Partner @Medion @Mainwebsite @Desktop
Feature: Medion footer components on main page

  Background:
  	Given I detect the enviroment to execute the test
	Given I am on "Medion" landing page

  @jira=QA-3680
  Scenario Outline: Footer links verification
  	When I click on link with text "<linkText>"
    And Page has title "<titlePage>" and URL is "<urlPart>"
    And I can see Medion promotion logo
    And I can see just shop button on Medion landing page
    
    Examples:
      | linkText              | titlePage                       | urlPart                 |
      | Support               | Support                         | /support/               |
	  | Kontakt               | Kontakt                         | /kontakt/               |
      | Impressum             | Impressum                       | /impressum/             |
      | Bezugsquellen         | Distributoren                   | /bezugsquellen/         |
      | Nutzungsbedingungen   | Nutzungsbedingungen             | /nutzungsbedingungen/   |
      | Datenschutzrichtlinie | Datenschutzrichtlinie           | /datenschutzrichtlinie/ |
      | Cookies               | Cookies                         | /cookies/               |
      | Open source           | Open Source                     | /open-source/           |
      #| Versand               | Liefergebiete und Versandkosten | /versand/               | maintenance
      | Über uns              | Über uns                        | /ueber-uns/             |




