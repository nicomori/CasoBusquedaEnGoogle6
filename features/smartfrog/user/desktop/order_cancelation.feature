@smartfrog @Desktop @User @Wip @webapp @Smoke @Core
Feature: Order Cancellation

  Scenario Outline: User cancels order
    Given I am logged in as registered user "<userEmail>"
    And user has at least one order available for cancellation
    And I am on camera overview page
    When I click on "<accountMenuItemText>" on camera overview page
    Then I am on account overview page
    When I click on link "<viewAllOrdersText>" on account overview page
    Then I am on orders page
    When I click on order number with status "<chargedStatusText>" on orders page
    Then I am on order details page
    When I click on "<cancelButtonText>" button on order details page
    Then I can see message "<cancelNotificationText>" on order details page
    And button "<cancelButtonText>" not available
    When I click "<closeButtonText>" button on order details page
    Then I am on orders page
    And I can see order change status to "<canceledStatusText>" on orders page

    Examples:
      | userEmail        | accountMenuItemText | viewAllOrdersText         | chargedStatusText | cancelButtonText      | cancelNotificationText     | closeButtonText | canceledStatusText |
      | en.user@mail.com | My Account          | View all Orders           | Charged           | Cancel Order          | Order has been canceled    | Close           | Canceled           |
