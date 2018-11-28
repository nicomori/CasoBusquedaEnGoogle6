@smartfrog @Desktop @User @Wip @webapp
Feature: Header verification for logged-in user

  Scenario Outline: Check header component for logged-in user on webapp
    Given I am logged in as registered user "<userEmail>"
    And I am on camera overview page
    Then I can see menu item on camera overview page
      | <cameraMenuItemText>   |
      | <accountMenuItemText>  |
      | <shopButtonText>       |
      | <userEmail>            |
      | <logOutButtonText>     |
      | <languageSelectorText> |

    Examples:
      | userEmail        | cameraMenuItemText | accountMenuItemText | shopButtonText | logOutButtonText | languageSelectorText |
      | en.user@test.com | All cameras        | My account          | Shop           | Logout           | DE                   |
      | de.user@test.com | Meine Kameras      | Mein Konto          | Shop           | Abmelden         | EN                   |

