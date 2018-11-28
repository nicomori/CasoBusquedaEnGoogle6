@Mobile @smartfrog @Ecommerce @Core @Wip
Feature: Smartfrog - checkout delivery address

  As a mobile  user
  I want to be able specify delivery address
  So that I can specify different address for delivery and for payment

  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario: user can specify different delivery address
   Given logged out user opens mobile app 
   And logged out user tap on log in button 
   And logged out user enter <email>
   And logged out user enter <password>
   |email                    | password        | 
   |test.user+@smartfrog.com | pswd            |
   When logged out user click on submit 
   Then user is auto logged in 
    When user tap on Shop link in side menu
    Then user redirected to Shop ramp view
    And user click to buy "Komplettlösung"
    Then user on cart page
    When user click to checkout on cart page
    Then user on shop user details page
    And  user enter invoice address on shop user details page
      | Title | FirstName | Surname | Company | Street      | StrNum | Zip    | City   |
      | Herr  | Test1     | User1   |         | StreetName1 | 111    | 120767 | Berlin |
    When choose option "Andere Lieferanschrift" on shop user details page
    Then addition address form appears on shop user details page
    When user  enter different delivery address on shop user details page
      | Title | FirstName | Surname | Company | Street      | StrNum | Zip    | City   |
      | Herr  | Test2     | User2   |         | StreetName2 | 222    | 120767 | Munich |
    And user  click button "Weiter" on shop user details page
    Then user  on Shop Payment page
    When user  choose payment method "Kreditkarte" and click button "Weiter"
    Then user am on "Kreditkarte" payment page
    When user enter payment details for 'Credit Card' and click 'Next'
      | CardNumber       | FullName  | cvv | Month | Year |
      | 5555555555554444 | Test User | 737 | 08    | 2018 |
    Then  user land  on Shop Summary page
    Then  assert invoice address on shop summary page
      | Test1 User1     |
      | StreetName1 111 |
      | 120767 Berlin   |
      | Deutschland     |
    And assert delivery address on shop summary page
      | Test2 User2     |
      | StreetName2 222 |
      | 120767 Munich   |
      | Deutschland     |
