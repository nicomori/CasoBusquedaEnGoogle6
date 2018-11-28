@smartfrog @Desktop @User @Wip @webapp
Feature: Footer functions

  Scenario: Unregistered user opens "FAQ" tab
    Given I am on main website page
    When I click "FAQ" on main website page
    Then I am on FAQ page
    When I choose the topic I am interested in and click "+" button on FAQ page
    Then I see description of the selected topic opens on FAQ page
    When I enter line "search" for the real topic on FAQ page
    Then I see form opens with description of indicated topic on FAQ page

  Scenario: Unregistered user opens "Contact" tab
    Given I am on main website page
    When I click "Contact" on main website page
    Then I am on Contact page
    When I enter name "John" on Contact page
    And I enter email "test@test.pl" on contact page
    And I enter subject "login" on contact page
    And I enter description "I have a problem logging in to my account" on contact page
    And I clicks "Submit" button on contact page
    Then I see confirmation message on contact page

  Scenario: Unregistered user opens "Contact" tab
    Given I am on main website page
    When I click "Contact" on main website page
    Then I am on Contact page
    When I click "Contact" link on contact page
    When I click link with email address on contact page
    Then I see email box opens

  Scenario Outline: Unregistered user checks "Imprint" tab
    Given I am on main website page
    When I click "Imprint" on main website page
    Then I am on Imprint page
    When I click "<linkName>" on Terms of service page
    Then Page opened with title "<pageTitle>" and url contains "<pageUrl>"

  Examples:
  | linkName     | pageTitle   | pageUrl       |
  | Contact      | Contact     | /contact/      |
  | ODR platform | ODR platform| /ODR-platform/ |

  Scenario: Unregistered user opens "Retail Stores" tab
    Given I am on main website page
    When I click "Retail Stores" on main website page
    Then I am on Retail Stores page
    When I click to Partners webpage link on Retail Stores page
    Then I am redirected to Partner weppage

  Scenario: Unregistered user opens "Retail Stores" tab
    Given I am on main website page
    When I click "Retail Stores" on main website page
    Then I am on Retail Stores page
    When I click link with Partners email address on Retail Stores page
    Then I see email box opens

  Scenario Outline: Unregistered user checks "Terms of service" tab
    Given I am on main website page
    When I click "Terms of service" on main website page
    Then I am on Terms of service page
    When I click "<linkName>" on Terms of service page
    Then Page opened with title "<pageTitle>" and url contains "<pageUrl>"

  Examples:
  | linkName         | pageTitle         | pageUrl            |
  | Open Source Terms| Open Source Terms |/open-source-terms/ |
  | Privacy policy   | Privacy policy    |/privacy-policy/    |
  | here             | Open Source Terms |/open-source-terms/ |


  Scenario: Unregistered user opens "Terms of service" tab
    Given I am on main website page
    When I click "Terms of service" on main website page
    Then I am on Terms of service page
    When I click adress email "tos@smartfrog.com" on Terms of service page
    Then I see email box opens

  Scenario Outline: Unregistered user checks "Privacy policy" tab
    Given I am on main website page
    When I click "Privacy policy" on main website page
    Then I am on Privacy policy page
    When I click "<linkName>" on Terms of service page
    Then The page opened with title "<pageTitle>" and url contains "<pageUrl>"

    Examples:
      | linkName         | pageTitle        | pageUrl            |
      | Cookies Policy   | Cookies Policy   | /Cookies-policy /  |
      | Terms of Service | Terms of Service |/terms-of-service / |


  Scenario: Unregistered user opens "Privacy policy" tab
    Given I am on main website page
    When I click "Privacy policy" on main website page
    Then I am on Privacy policy page
    When I click link with email address on privacy policy page
    Then I see email box opens

  Scenario: Unregistered user opens "Cookies policy" tab
    Given I am on main website page
    When I click "Cookies policy" on main website page
    Then I am on cookies policy page
    When I click link "www.google.com/analytics/learn/privacy.html." on cookies policy page
    Then I am redirected to "www.google.com/analytics/learn/privacy.html."

  Scenario: Unregistered user opens "Open source terms" tab
    Given I am on main website page
    When I click "Open source terms" on main website page
    Then I am on open source terms page
    When I click on an active links on open source terms page
    Then I am redirected to selected link

  Scenario: Unregistered user opens "Download apps" link
    Given I am on main website page
    When I click "App Store"on download apps page
    Then I am redirected to the App Store webpage

  Scenario: Unregistered user opens "Download apps" link
    Given I am on main website page
    When I click "Google Play" on download apps page
    Then I am redirected to the Google Play webpage

  Scenario: Unregistered user opens "Shipping" tab
    Given I am on main website page
    When I click "Shipping" on main website page
    Then I am on Shipping page

  Scenario: Unregistered user opens "About" tab
    Given I am on main website page
    When I click "About" on main website page
    Then I am on about page

  Scenario: Unregistered user opens "Job" tab
    Given I am on main website page
    When I click "Job" on main website page
    Then I am on job page
    When I click "Details" on job page
    Then I see job details on job page

  Scenario: Unregistered user opens "Blog" tab
    Given I am on main website page
    When I click "Blog" on main website page
    Then I am on blog page
    When I click on on an active on blog page
    Then I am redirected to selected tab

  Scenario: Unregistered user opens "Press" tab
    Given I am on main website page
    When I click "Press" on main website page
    Then I am on press page

  Scenario Outline: Unregistered user opens "Follow us" tab
    Given I am on main website page
    When I click "<iconName>" on main website page
    Then The page opened with title "<pageTitle>" and url contains "<pageUrl>"

    Examples:
      | iconName | pageTitle | pageUrl      |
      | twitter  | twitter   | /twitter /   |
      | youtube  | youtube   | /youtube /   |
      | instagram| instagram | /instagram / |
      | facebook | facebook  | /facebook /  |

