@mainwebsite @smartfrog @MobileWeb @User @Wip @Smoke
Feature: Language Selector

  Scenario Outline: Change language on camera overview page
    Given I am logged in as registered user "<userEmail>"
    And I am on camera overview page
    When I click on "<defaultLanguageButton>" button on camera overview page
    Then I see language list on camera overview page
    When I choose "<languageToSelect>" language on camera overview page
    Then account language is changed to "<selectedLanguage>" on account overview page

    Examples:
      | userEmail                  | defaultLanguageButton | languageToSelect | selectedLanguage |
      | user.with.EN@smartfrog.com | EN                    | Deutsch          | DE               |
      | user.with.DE@smartfrog.com | DE                    | English          | EN               |


  Scenario: Set Default language after logout
    Given I am logged in as registered user "en.user.@smartfrog.com"
    And I am on camera overview page
    When I click on "EN" button on camera overview page
    Then I see language list on camera overview page
    When I choose "Deutsch" language on camera overview page
    Then account language is changed to "DE" on account overview page
    When I am click on "Abmelden" button on camera overview page
    And I am logged in as registered user "en.user.@smartfrog.com"
    And I am on camera overview page
    Then I see default language is "EN" on camera overview page





 
