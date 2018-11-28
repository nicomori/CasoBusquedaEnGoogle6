@Wip @smartfrog @Ecommerce @MobileWeb @webshop @Core @Smoke @Wip
Feature: Web shop payment method SOFORT and success page verification

  As a anonymous and registered customer
  I want to be able proceed to checkout with Sofortüberweisung payment

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "Smartfrog" landing page
	When I am select "Deutschland" country
  
  @jira=QA-3999 @Wip
  Scenario: Proceed to checkout as anonymous user HW country with Sofortüberweisung
    When I click shop button on "Smartfrog" landing page
	Then I click to buy "<productName>"
	Then I am on shopping cart page
	When click to checkout on cart page
    
    
    Then I am on shop login page
    When click "Weiter" on shop login page
    Then I am on shop register page
    #When I enter email and repeat it as "test.user+@smartfrog.com"
    #And enter default password on shop register page
    #And click on "Jetzt registrieren" on shop register page
    #And I set newly registered user as Test in Videocloud API
    #Then I am on shop user details page
    #When enter invoice address on shop user details page and click 'Next'
      #| Title | FirstName | Surname   | Company | Street    | StrNum | Zip   | City        |
      #| Herr  | Patrick   | Gremillet |         | Rheinstr. | 99     | 76532 | Baden-Baden |
    #Then I am on shop payment page
    #When I choose payment method "Sofort" and click button "Weiter"
    #Then I am on shop summary page
    #And check invoice address on shop summary page
      #| Patrick Gremillet |
      #| Rheinstr. 99      |
      #| 76532 Baden-Baden |
      #| Deutschland       |
    #And payment type is "Sofort" detail on shop summary page
    #When I agree with terms and click 'Buy now'
    #Then I am redirected to Sofortüberweisung payment page
    #Then I login to Sofortüberweisung page
    #And I select bank account on Sofortüberweisung page
    #And I enter TAN on Sofortüberweisung page
    #Then I am on shop payment success page
    #And I can see message "Vielen Dank für deine Bestellung" on shop payment success page

  @Broken
  Scenario: Proceed to checkout as registered user HW country with saved Sofortüberweisung data
    And I am logged in as "ls.tester91+sofort@gmail.com" with default password on shop page
    And I click to buy "Komplettlösung"
    Then I am on cart page
    And click to checkout on cart page
    Then I am on shop user details page
    Then I see fields with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname   | Company   | Street    | StrNum | Zip   | City        |
      | Herr  | Patrick   | Gremillet | Smartfrog | Rheinstr. | 99     | 76532 | Baden-Baden |
    And I click button 'Next' on shop user details page
    Then I am on shop summary page
    When I click on change payment method button on shop Check page
    Then I am on shop change payment method page
    When I choose payment method "Sofort" and click button "Weiter"
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Patrick Gremillet |
      | Smartfrog         |
      | Rheinstr. 99      |
      | 76532 Baden-Baden |
      | Deutschland       |
    And payment type is "Sofort" detail on shop summary page
    When I agree with terms and click 'Buy now'
    Then I am redirected to Sofortüberweisung payment page
    Then I login to Sofortüberweisung page
    And I select bank account on Sofortüberweisung page
    And I enter TAN on Sofortüberweisung page
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Bestellung" on shop payment success page

