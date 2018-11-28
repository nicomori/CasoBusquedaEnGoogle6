@Smoke @Partner @FirstUtility @Ecommerce @Webshop @jira=QA-3538 @Desktop @Broken
Feature: FirstUtility - User flow verification with claim now button

  Scenario: Not registered user E2E flow with Claim Now button
    Given I am on First Utility landing page
    When I click on Claim now button on First Utility landing page
    Then I am on First Utility shopping cart page
    When I enter coupon-code "fuautomation1" on First Utility shop cart page
    And click on button "Redeem" on shop cart page
    Then I can see voucher item with text "Voucher" and price "-£119.00" on shop cart page
    And total price data displayed on shop cart page
      | Total | Vat                       |
      | £0.00 | Including VAT(20%)  £0.00 |
    When I click on button "Check out" on shop cart webpage
    Then I am on First Utility shop login page
    When click "Continue" on shop login page
    Then I am on First Utility shop register page
    When I enter email and repeat it as "test.user+@smartfrog.com"
    And enter default password on shop register page
    And click on "Register now" on shop register page
    And I set newly registered user as Test in Videocloud API
    Then I am on First Utility shop user details page
    When I enter invoice address on UK user details page and click 'Next'
      | Title | FirstName | Surname | Company     | Address1         | Address2     | City   | County     | PostalCode | MobileNumber |
      | Mr.   | Jack      | Johnson | TestCompany | Mohrenstrasse 34 | testAddress2 | Berlin | TestCounty | 10435      | +440987653   |
    Then I am on First Utility shop summary page
    And check invoice address on shop summary page
      | Jack Johnson     |
      | TestCompany      |
      | Mohrenstrasse 34 |
      | testAddress2     |
      | 10435 Berlin     |
      | TestCounty       |
      | United Kingdom   |
    Then check "No payment required" text is shown at Payment type section at shop summary page
    When I agree with terms and click 'Buy now'
    Then I am on shop payment success page
    And I can see message "Many thanks for your order" on shop payment success page
    And I can see delivery time "Delivery within 3 - 5 days by DHL" on shop payment success page
    And I can see customer service number "United Kingdom 020 - 35 14 91 10" on success page
