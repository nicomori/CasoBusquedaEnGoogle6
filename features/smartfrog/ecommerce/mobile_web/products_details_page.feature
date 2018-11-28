@Smoke @Core @smartfrog @MobileWeb @Ecommerce @jira=QA-3948
Feature: Smartfrog - products details page

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	
  Scenario: Product details page verification for Komplettlösung
  	When I click on link with text "Details"
  	Then verify if this text "Smartfrog Komplettlösung" appear correctly displayed in the page
  	And verify if this text "Komplettlösung" appear in the title
    And I can see Product Price Element is displayed with correct data
      | Smartfrog App                                       |
      | Smartfrog HD Kamera                                 |
      | Kamera Anzahl:                                      |
      | Inkl. Versandkosten                                 |
      | inkl. MwSt., auf Lager (Lieferung in 1-2 Werktagen) |
      | Live-Video rund um die Uhr                          |
      | Video-Speicherung                                   |
      | der jeweils letzten 24 Stunden                      |
      | Monatlich kündbar                                   |
      | Keine Einrichtungskosten                            |
      | Kostenloser Versand                                 |
 	And verify if this exclusive class "product-price-element", appear in the web with this Table Of Text
      | 5,		 |
      | 95		 |
      | €		 |
      | nur		 |
      