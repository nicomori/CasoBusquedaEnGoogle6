@smartfrog @Wip @MobileWeb @User @webapp @Smoke
Feature: Homepage page links

  Scenario Outline: check links at header
    Given I am on "<language>" main website page
    And I am not logged in
    When I click on "<link>" on main website page
    Then page opened with title "<pageTitle>" and url contains "<urlPart>"

    Examples:
      | language    | link            | pageTitle                  | urlPart           |
      | English     | Camera          | Camera                     | /camera/          |
      | English     | Video history   | Save video record to cloud | /video-history/   |
      | English     | Uses            | Uses                       | /uses/            |
      | English     | How it works    | How it works               | /how-it-works/    |
      | Deutschland | Kamera          | Kamera                     | /kamera/          |
      | Deutschland | Videoaufnahme   | Videoaufnahme              | /videoaufnahme/   |
