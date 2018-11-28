@Wip @smartfrog @Desktop @camera @webapp @Core @Smoke
Feature: Smartfrog - Dashboard cameras list

  Scenario: User want to smartfrog cam
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have not any cameras
    When I click on "Available soon" button on account overview page
    Then I am on Setting up the Smartfrog Cam on account overview page
    When I click on "Notify when available" button on account overview page
    Then I get email with confirmation about notify when smartfrog cam will be Available

  Scenario: User close Setting up the Smartfrog Cam on account overview page
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have not any cameras
    When I click on "Available soon" button on account overview page
    Then I am on Setting up the Smartfrog Cam on account overview page
    When I click on "Closed" button on account overview page
    Then screen Setting up the Smartfrog Cam is closed on account overview page

  Scenario: User want to have webcam on your laptop
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have not any cameras
    When I click on "Connect webcam" button
    Then I see information about to blocked access to laptop camera from smartfrog site
    When I click on on blocked element
    And I click on "Allow" option
    And I click on new window "Allow" checkbox
    Then I see window with cameras correctly work

  Scenario: User want to buy camera
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have not any cameras
    When I click on "Buy Now" button
    Then I am redirected to Shop site

  Scenario: User connect camera to storage subscription
    Given I am on a main website page
    And I am logged in as "test.user@example.com"
    And I have not any cameras
    And I have a storage subscription
    When I click on "Assign Camera" button
    Then I see new window with drpo-down list

  Scenario: User want to check last order
    Given I am on a setting account page
    And I am logged in as "test.user@example.com"
    When I click on "View my last order" link
    Then I see last order

  Scenario: User want to check all orders
    Given I am on a setting account page
    And I am logged in as "test.user@example.com"
    When I click on "View all orders" link
    Then I see all orders

  Scenario: User want to check invoices
    Given I am on a setting account page
    And I am logged in as "test.user@example.com"
    When I click on "Invoices" link
    Then I see invoices page


