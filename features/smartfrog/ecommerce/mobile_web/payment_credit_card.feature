@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Core @Broken @Wip
Feature: Web shop payment method Credit Card

  As a anonymous and registered customer
  I want to be able proceed to checkout via Credit Card payment
  So that I can my Credit Card card to pay

  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario: Proceed to checkout as anonymous user HW country via Credit Card
    When I am select "Ireland" country
    And I click to buy "Surveillance Bundle"
    Then I am on cart page
    When click to checkout on cart page
    Then I am on shop login page
    When click "Continue" on shop login page
    Then I am on shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Register now" on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I am on shop user details page
    When I enter invoice address on UK user details page and click 'Next'
      | Title | FirstName | Surname | Company     | Address1         | Address2     | City   | County     | PostalCode | MobileNumber |
      | Mr.   | Jack      | Johnson | TestCompany | Mohrenstrasse 34 | testAddress2 | Berlin | TestCounty | 10435      | +440987653   |
    Then I am on shop payment page
    When I choose payment method "Credit Card" and click button "Next"
    Then I am on "Credit card" payment page
    When I enter payment details for 'Credit Card' and click 'Next'
      | CardNumber       | FullName  | cvv | Month | Year |
      | 5555555555554444 | Test User | 737 | 08    | 2018 |
    Then I am on shop summary page
    And check invoice address on shop summary page
      | Jack Johnson     |
      | TestCompany      |
      | Mohrenstrasse 34 |
      | testAddress2     |
      | 10435 Berlin     |
      | TestCounty       |
      | Ireland          |
    And check payment type detail on shop summary page
      | Credit Card    |
      | Test User      |
      | ********* 4444 |
    When I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see message "Many thanks for your order" on shop payment success page
    And I can see customer service number "Ireland 01 - 903 60 62" on success page


  Scenario: Proceed to checkout as registered user HW country via Credit Card
    And I am logged in as "test.user+iecc@smartfrog.com" with default password on shop page
    And I click to buy "Surveillance Bundle"
    Then I am on cart page
    And click to checkout on cart page
    Then I am on shop user details page
    Then I see fields of UK address form with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname | Company     | Address1         | Address2     | City   | County     | PostalCode | MobileNumber |
      | Mr.   | Jack      | Johnson | TestCompany | Mohrenstrasse 34 | testAddress2 | Berlin | TestCounty | 10435      | +440987653   |
    And I click button 'Next' on shop user details page
    Then I am on shop summary page
    And I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see proper email "test.user+iecc@smartfrog.com" on shop payment success page
    And I can see delivery address on shop success page
      | Jack Johnson     |
      | TestCompany      |
      | Mohrenstrasse 34 |
      | testAddress2     |
      | 10435 Berlin     |
      | TestCounty       |
      | Ireland          |
