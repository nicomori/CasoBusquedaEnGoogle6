@User @Partner @Maxenergy @PartnerPassword @Smoke @Core @Desktop
Feature: Maxenergy - Footer components on enter password site

  @jira=QA-3678
  Scenario Outline: Footer links
  	Given I detect the enviroment to execute the test
	Given I am on "MaxEnergy" landing page
	When I click on link with text "<linkText>"
    And Page has title "<pageTitle>" and URL is "<pageUrl>"
    Then verify the page opened

    Examples:
      | linkText                       | pageTitle                                     | pageUrl                 |
      | Häufig gestellte Fragen (FAQ) | Häufig gestellte Fragen (FAQ)                 | support.smartfrog.com   |
      | Support                       | Support \| Smartfrog                          | /support                |
      | Kontakt                       | Kontakt \| Smartfrog                          | /kontakt                |
      | Impressum                     | Impressum                                     | /impressum              |
      | Bezugsquellen                 | Distributoren                                 | /bezugsquellen/         |
      | Open Source                   | Open Source Terms                             | /open-source/           |
      | Versand                       | Liefergebiete und Versandkosten bei Smartfrog | /versand/               |
      | Über uns                      | Über uns \| das Smartfrog Team                | /ueber-uns/             |
      | Jobs                          | Jobs                                          | /jobs/                  |
      | Blog                          | Smartfrog Blog                                | blog.smartfrog.com      |
      | Presse                        | Pressebereich                                 | /presse/                |

   Scenario Outline: Footer links
  	Given I detect the enviroment to execute the test
	Given I am on "MaxEnergy" landing page
	When I click on link with text "<linkText>"
    And Page opened in new tab has title "<pageTitle>" and URL is "<pageUrl>"
    Then verify the page opened

    Examples:
      | linkText                       | pageTitle                                     | pageUrl                 |
      | Cookies                       | Cookies                                       | /cookies                |
      | Nutzungsbedingungen           | Nutzungsbedingungen - Smartfrog               | /nutzungsbedingungen/   |
      | Datenschutzrichtlinie         | Datenschutzrichtlinie - Smartfrog             | /datenschutzrichtlinie/ |