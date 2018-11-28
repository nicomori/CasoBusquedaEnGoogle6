@smartfrog @Desktop @User @Wip @webapp @Smoke
Feature: Zendesk widget verification for webapp

  @jira=QA-3478
  Scenario Outline: Zendesk widget is available on webapp overview page
    Given I am logged in as registered user "<userEmail>"
    And I am on camera overview page
    Then I can see text 'Zendesk widget' with text "<zendeskWidgetText>" on camera overview page

    Examples:
      | userEmail             | zendeskWidgetText |
      | en.user@smartfrog.com | Help              |
      | de.user@smartfrog.com | Hilfe             |


  Scenario Outline: Zendesk widget is available on all pages of web app
    Given I am logged in as registered user "<userEmail>"
    And I am on camera overview page
    When I am on webbapp page "<pageUrlEnding>"
    Then I can see text 'Zendesk widget' with text "<zendeskWidgetText>" on camera overview page

    Examples:
      | userEmail         | pageUrlEnding                  | zendeskWidgetText |
      | en.user@email.com | /savedclips/                   | Help              |
      | en.user@email.com | /events/                       | Help              |
      | en.user@email.com | /account/overwie/              | Help              |
      | en.user@email.com | /liveview/camera_id/live       | Help              |
      | en.user@email.com | /liveview/camera_id/recordings | Help              |
      | de.user@email.com | /savedclips/                   | Hilfe             |
      | de.user@email.com | /events/                       | Hilfe             |
      | de.user@email.com | /account/overwie/              | Hilfe             |
      | de.user@email.com | /liveview/camera_id/live       | Hilfe             |
      | de.user@email.com | /liveview/camera_id/recordings | Hilfe             |
