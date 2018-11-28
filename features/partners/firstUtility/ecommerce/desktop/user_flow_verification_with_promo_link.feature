@Smoke @Partner @FirstUtility @Ecommerce @Webshop @jira=QA-2790 @Desktop

Feature: FirstUtility - User flow verification with promo link

  @jira=QA-3798
  Scenario: Registered user E2E flow with First Utility link
    Given I open First Utility promotion link "/shop/cart?action=add&product_id=CamPackage&promo=first_utility&coupon=fuautotest1"
    Then I am on First Utility shopping cart page
    And total price data displayed on shop cart page
      | Total | Vat                       |
      | £0.00 | Including VAT(20%) £0.00 |
    When I click on button "Check out" on shop cart webpage
    When I select option "I already have a password" on First Utility shop login page
    And I enter email as "ls.tester91+uk1@gmail.com" on shop login page
    And I enter password as "123456" on shop login page
    When click "Continue" on shop login page
    Then I am on First Utility shop user details page
    Then I see fields of UK address form with default data preset for logged in user on shop user details page
      | Title | FirstName | Surname | Company     | Address1         | Address2     | City   | County     | PostalCode | MobileNumber |
      | Mr.   | Jack      | Johnson | TestCompany | Mohrenstrasse 34 | testAddress2 | Berlin | TestCounty | 10435      | +440987653   |
    And I click button "Next" on shop user details page
    Then I am on shop summary page
    Then check "No payment required" text is shown at Payment type section at shop summary page
    When I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see message "Many thanks for your order" on shop payment success page
    And I can see delivery time "Delivery within 3 - 5 days by DHL" on shop payment success page
    And I can see customer service number "United Kingdom 020 - 35 14 91 10" on success page



