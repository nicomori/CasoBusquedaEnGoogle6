@webshop @Ecommerce @Desktop @smartfrog @Smoke
Feature: Web shop Login\Logout as registered user

  As a registered customer
  I want to be able Login\Logout
  So that I can log in\log out to site

  Background:
    Given I am on landing "Deutschland" shop products page


  Scenario: Login as registered user on shop landing page
    When I enter email as "test.user+0000@smartfrog.com" on shop products page
    And I enter password as "Test123!!!" on shop products page
    And I click on "Login" button
    Then I logged in as "test.user+0000@smartfrog.com"

  Scenario: Login as registered user on shop login page
    When I am select "Deutschland" country
    And I click to buy "Komplettlösung"
    Then I am on cart page
    When click to checkout on cart page
    Then I am on shop login page
    When I select option "Ich habe bereits ein Passwort." on shop login page
    And I enter email as "test.user+0001@smartfrog.com" on shop login page
    And I enter password as "Test123!!!" on shop login page
    And click "Weiter" on shop login page
    Then I am on shop user details page
    Then I see fields with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname | Company   | Street       | StrNum | Zip     | City   |
      | Herr  | Test      | User    | SmartFrog | Mohrenstraße | 34     | D-10117 | Berlin |

  Scenario: Logout as registered customer
    And I am logged in as "test.user+0000@smartfrog.com" with default password on shop page
    And I am on shop products page
    When I click 'Logout' button on shop products page
    Then I am at main 'Smartfrog' page
    And I am logged out on main 'Smartfrog' page

