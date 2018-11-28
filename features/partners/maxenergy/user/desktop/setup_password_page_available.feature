@User @PartnerPassword @Smoke @Partner @Maxenergy @Desktop
Feature: Maxenergy - Setup password page available

  @jira=QA-3537
  Scenario: Enter-Password form verfication
    Given I am on the MaxEnergy enter password site
    And I can see the MAX enter-password form
    And I can see the MAX title "Passwort festlegen"
    And I can see the "Passwort festlegen" button in the MAX enter-password form

  @jira=QA-3678
  Scenario Outline: Links in Enter-Password form verification
    Given I am on the MaxEnergy enter password site
    And I can see the MAX enter-password form
    When I click on "<links>" in the password form
    Then Page opened in new tab has title "<pageTitle>" and URL is "<urlPart>"
    And I can see the SF logo on the page

    Examples:

    |links                                  | pageTitle                         | urlPart                 |
    |Nutzungsbedingungen                    | Nutzungsbedingungen               | /nutzungsbedingungen/   |
    |Datenschutzrichtlinie                  | Datenschutzrichtlinie             | /datenschutzrichtlinie/ |
    |Richtlinien zur Verwendung von Cookies | Cookies                           | /cookies/               |
