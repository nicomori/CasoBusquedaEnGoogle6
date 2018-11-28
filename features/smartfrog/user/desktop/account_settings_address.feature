@smartfrog @Desktop @User @Wip @webapp @Smoke
Feature: Account settings - address

  Scenario: Login user changing address
    Given I am on main website page
    When I enter email as "smartfrog@test.com" on main website page
    And I enter password "haslo123" on main website page
    And I click "Login" button on main website page
    When I click on "My account" tab on web app overview page
    Then I on account overview page
    When I click on "Change invoice address" on account addrees page
    And I enter account details on account overview page
      | salutation | FirstName | SecondName | Company | Street   | StrNumber | ZIP   | City   | MobilePhone |
      | Mr.        | Mary      | Kowalski   | Onwelo  | Moherstr | 12        | 12390 | Berlin | 1245634     |
    And I click "Save" button on account addrees page
