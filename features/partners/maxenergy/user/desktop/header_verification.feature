@User @Partner @Maxenergy @PartnerPassword @Smoke @Core @Desktop
Feature: Maxenergy - Header components on the enter password site

  @jira=QA-3679
  Scenario Outline: Header links
	Given I detect the enviroment to execute the test
	Given I am on "MaxEnergy" landing page
	Then I click on link with text "<links>"
    Then Page has title "<PageTitle>" and URL is "<urlPart>"
    And being redirected to homepage

    Examples:

      | links           | PageTitle                                                 | urlPart           |
      | Kamera          | HD WLAN Kamera - Der Alarm für´s Zuhause \| Smartfrog     | /kamera/          |
      | Videoaufnahme   | Videoaufnahmen in der Cloud speichern \| Smartfrog        | /videoaufnahme/   |
      | Einsatzbereiche | Einsatzbereiche für die Überwachungstechnik von Smartfrog | /einsatzbereiche/ |
      | So geht       | So geht´s - Smartfrog erklärt \| startklar in 5 Minuten     | /so-gehts/        |
