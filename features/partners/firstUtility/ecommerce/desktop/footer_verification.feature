@Core @Smoke @Partner @FirstUtility @Mainwebsite @jira=QA-2312 @Desktop @Ecommerce
Feature: First Utility footer components on main page

  Background:
    Given I detect the enviroment to execute the test
	Given I am on "First Utility" landing page

  Scenario Outline: Footer links
    When I click on link with text "<linkText>"
    Then Page opened in new tab has title "<pageTitle>" and URL is "<pageUrl>"
    And I can see First Utility promo header with text "First utility customer exclusive offer"
    And I can see Shop button on First Utility page

    Examples:
      | linkText          | pageTitle                                      | pageUrl             |
      | Support           | Support                                        | /support/           |
      | Contact           | Contact                                        | /contact/           |
      | Imprint           | Imprint                                        | /imprint/           |
      | Retail Stores     | Distributors                                   | /distributors/      |
      | Terms of service  | Terms of service - Smartfrog                   | /terms-of-service/  |
      | Privacy policy    | Privacy Policy - Smartfrog                     | /privacy-policy/    |
      | Cookies policy    | Cookies Policy                                 | /cookies-policy/    |
      | Open source terms | Open Source Terms                              | /open-source-terms/ |
      | Shipping          | Delivery areas and delivery costs at Smartfrog | /shipping/          |
      | About             | About us \| the team at Smartfrog              | /about/             |
      | Jobs              | Jobs                                           | /jobs/              |
      | Press             | Press Room                                     | /press/             |





