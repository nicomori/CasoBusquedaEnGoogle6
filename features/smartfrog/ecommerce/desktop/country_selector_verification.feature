 @smartfrog @Desktop @Ecommerce 
Feature: User can change a country and see correct language depending on country selected

	@jira=QA-4032
  Scenario Outline: I can see country selector,change country and see the change on the shop page
  	
  	Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "<country>" country
	Then press the button shop in the header bar in the dashboard of the user logged
	Then I am on shopping product page
    Then I see the product page displayed in the language "<language>"
    And I can see the url part "<urlPart>"
    And I can see the country selector displaying "<country>"

    Examples:
      | language | country        | urlPart              |
      | German   | Deutschland    | /de-de/shop/products |
      | English  | United Kingdom | /en-gb/shop/products |


	@noah222
  Scenario Outline: I can select a different country
  Given I detect the enviroment to execute the test
    Given I am on "Smartfrog" landing page
    When I click country selector
    Then I can see list of countries with country flags
    #the next command is necessary to close the country selector, otherwise the 'When I am select "<country>" country'
    #will close the menue with the first click and won't be able to select a country
    Then I click country selector
    When I am select "<country>" country
    Then I see the product page displayed in the language "<language>"
    And I can see the url part "<urlPart>"
    

    Examples:
      | language | country        | urlPart              |
      | English  | United Kingdom | /en-gb				 |
      | German   | Deutschland    | /de-de				 |