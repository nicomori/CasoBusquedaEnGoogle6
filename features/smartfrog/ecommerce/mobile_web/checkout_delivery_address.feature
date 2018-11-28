@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Core @Wip
Feature: Web shop user can specify different delivery address

  As a desktop user
  I want to be able specify delivery address
  So that I can specify different address for delivery and for payment

  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario: user can specify different delivery address
    When I am select "Deutschland" country
    And I click to buy "Komplettlösung"
    Then I am on cart page
    When click to checkout on cart page
    Then I am on shop login page
    When click "Weiter" on shop login page
    Then I am on shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Jetzt registrieren" on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I am on shop user details page
    And enter invoice address on shop user details page
      | Title | FirstName | Surname | Company | Street      | StrNum | Zip    | City   |
      | Herr  | Test1     | User1   |         | StreetName1 | 111    | 120767 | Berlin |
    When choose option "Andere Lieferanschrift" on shop user details page
    Then addition address form appears on shop user details page
    When I enter different delivery address on shop user details page
      | Title | FirstName | Surname | Company | Street      | StrNum | Zip    | City   |
      | Herr  | Test2     | User2   |         | StreetName2 | 222    | 120767 | Munich |
    And I click button "Weiter" on shop user details page
    Then I am on shop payment page
    When I choose payment method "Kreditkarte" and click button "Weiter"
    Then I am on "Kreditkarte" payment page
    When I enter payment details for 'Credit Card' and click 'Next'
      | CardNumber       | FullName  | cvv | Month | Year |
      | 5555555555554444 | Test User | 737 | 08    | 2018 |
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Test1 User1     |
      | StreetName1 111 |
      | 120767 Berlin   |
      | Deutschland     |
    And check delivery address on shop summary page
      | Test2 User2     |
      | StreetName2 222 |
      | 120767 Munich   |
      | Deutschland     |

