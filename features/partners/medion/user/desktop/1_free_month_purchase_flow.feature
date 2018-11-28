@Smoke @Partner @Medion @User @Webshop @Webapp @Mainwebsite @Desktop @Wip
Feature: Medion - 1 Month Free Purchase E2E - flow

  As a medion unregistered user
  I want to be able to proceed to checkout for a limited campaign
  So that I can get 1 month free subscription

  @jira=QA-3771
  Scenario: Proceed to checkout as medion customer for limited campaign
    Given I am on Medion page
    When I click on button Jetzt einlösen button on Medion landing page
    Then I am on Medion campaign shopping cart page and it contains coupon "1 Freimonat(e) Komplettlösung"
    When I click on button "Zur Kasse gehen" on shop cart webpage
    Then I am on shop login page
    When click "Weiter" on shop login page
    Then I am on shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Jetzt registrieren" on shop register page
    Then I am on shop user details page
    When enter invoice address on shop user details page
      | Title | FirstName | Surname | Company | Street      | StrNum | Zip    | City        |
      | Herr  | Test1     | Test2   |         | StreetName  | 99     | 76532  | Baden-Baden |
      | Herr  | Test1     | User1   |         | StreetName1 | 111    | 120767 | Berlin      |
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
    When I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page
    And I can see customer service number "Deutschland 030 - 991 99 991" on success page