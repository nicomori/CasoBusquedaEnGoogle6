@Smoke @mobilcom @User @Partner @mobilcomWebapp @Desktop
Feature: Mobilcom user activation page verification feature

	@jira=QA-2003
	Scenario Outline: Mobilcom - Verification of User activation page
	
	Given I register Mobilcom user from Hotline Channel using API and open user activation URL
	Then navigate to the registration password and set the password
	And Verify the page with this text "<text to verify>"
	When Click on "<linkName>" link on Mobilcom user activation page
    Then I am on page Mobilcom "<titlePage>" and url contains "<urlPart>"
    
	Examples:
      | text to verify 			| linkName              						| titlePage                                                 | urlPart         |
      |	Benutzerkonto anlegen	| Nutzungsbedingungen   						| Nutzungsbedingungen Smartfrog für mobilcom-debitel-Kunden | /tos            |
      |	Benutzerkonto anlegen	| Datenschutzrichtlinie 						| Datenschutzrichtlinie                                     | /privacy-policy |
      |	Benutzerkonto anlegen	| Richtlinien zur Verwendung von Cookies		| Cookies-Richtlinie                                        | /cookie-policy  |
	