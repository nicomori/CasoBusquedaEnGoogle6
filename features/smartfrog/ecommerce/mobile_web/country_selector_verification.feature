@Wip @smartfrog @MobileWeb @Ecommerce
Feature: User can change a country and see correct language depending on country selected


  Scenario Outline: I can see country selector on shop ramp and select a different country
    Given I am on shop ramp page "<country>"
    Then I can see shop ramp page is displayed in "<language>"
    And I can see "<urlPart>"
    When I click country selector on shop ramp
    Then I can see list of countries with country flags
    And I can see that country selector is displaying "<country>"

    Examples:
      | language | country        | urlPart              |
      | English  | United Kingdom | /en-gb/shop/products |
      | German   | Deutschland    | /de-de/shop/products |

  Scenario Outline: I can select a different country
    Given I am on shop ramp page
    When I click country selector on shop ramp
    Then I can see list of countries with country flags
    When I click on "<country>"
    Then I can see shop ramp page is displayed in "<language>"
    And I can see "<urlPart>"

    Examples:
      | language | country        | urlPart              |
      | English  | United Kingdom | /en-gb/shop/products |
      | German   | Deutschland    | /de-de/shop/products |
