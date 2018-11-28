@smartfrog @Desktop @User @Wip @webapp @Smoke @Core
Feature: Login functionality verification

  Scenario Outline: Login form verification
    Given I am on "<language>" webbapp login page
    And I can see the title "<loginFormTitle>" on web app login page
    And I can see links on web app login page
      | "<forgotPasswordLink>" |
      | "<createAccountLink>"  |
    Examples:
      | language | loginFormTitle         | forgotPasswordLink    | createAccountLink        |
      | English  | Login at Smartfrog     | Forgot your password? | Create free account      |
      | Deutsch  | Bei Smartfrog Anmelden | Passwort vergessen?   | Noch kein Benutzerkonto? |

  @jira=QA-3468
  Scenario Outline: Login as registered user
    Given I already registered with Smartfrog as "test.user+staging1@smartfrog.com"
    Given I am on "<language>" webbapp login page
    When I enter my email "<userEmail>" and default password on web app login page
    And I click login "<loginButtonText>" on web app login page
    Then I am on camera overview page
    Examples:
      | language | userEmail                        | loginButtonText |
      | English  | test.user+staging1@smartfrog.com | Login           |
      | Deutsch  | test.user+staging1@smartfrog.com | Anmelden        |

  Scenario Outline: Login as user with incorrect credentials
    Given I am on "<language>" webbapp login page
    When I enter my email "<userEmail>" on web app login page
    When I enter password "<password>" on web app login page
    And I click login "<loginButtonText>" on web app login page
    Then I see error message "<errorMessageText>" on web app login page
    Examples:
      | language | userEmail        | password | loginButtonText | errorMessageText                |
      | English  | example@mail.com | hgdsaj   | Login           | Please check your entries.      |
