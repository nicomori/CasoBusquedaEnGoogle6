@smartfrog @MobileWeb @User @Wip @webapp
Feature: Forget password

  @jira=QA-3472
  Scenario Outline: Reset password webapp happy path
    Given I am on "<language>" webbapp login page
    And I click "<linkName>" link on login page
    Then I am on webapp password reset page
    And I can see dialog icon title "<dialogTitle>" on webapp password reset page
    And I can see message "<contentMessage>" on webapp password reset page
    When I enter "<userEmail>" on webapp password reset page
    And click on button "<sendEmailButton>" on webapp password reset page
    Then I can see message "<sendMailConfirmatioText>" on webapp password reset page
    And I got email with password reset link

    Examples:
      | language | linkName              | dialogTitle           | contentMessage                                                    | userEmail             | sendEmailButton          | sendMailConfirmatioText                                                                                      |
      | English  | Forgot your password? | Forgot your password? | Which email address was used to register your Smartforg account?  | some.email.@gmail.com | Send link via email      | If your email is registered, you will recive an email to recovery your password.                             |
      | Deutsch  | Passwort vergessen?   | Passwort vergessen?   | Mit welcher E-Mail-Adresse wurde das Smartfrog Konto registriert? | some.email.@gmail.com | Link per E-Mail zusenden | E-Mail zur Passwort-Wiederherstellung wurde erfolgreich versendet, falls die E-Mail Adresse registriert war. |


  Scenario Outline: Reset password webapp field validation
    Given I am on "<language>" webbapp login page
    And I click "<linkName>" link on login page
    Then I am on webapp password reset page
    When I enter "<userEmail>" on webapp password reset page
    And click on button "<sendEmailButton>" on webapp password reset page
    Then I can see error message "<errorMessage>" on webapp password reset page

    Examples:
      | language | linkName              | userEmail | sendEmailButton          | errorMessage                    |
      | English  | Forgot your password? | dsada     | Send link via email      | Please check your entries.      |
      | Deutsch  | Passwort vergessen?   |           | Link per E-Mail zusenden | Bitte überprüfe deine Eingaben. |



  Scenario: Login with wrong password registered user
      Given I have registered user “test.user@example.com”
      And I am on main website page
      When I enter email as “test.user@example.com” on main website page
      And I enter password “incorectpass” on main website page
      And I click “Login” button on main website page
      Then I am on web app login page
      And I see error message “Please check your entries.” on web app login page

    Scenario: Login with wrong email address registered user
      Given I have registered user “test.user@example.com”
      And I am on main website page
      When I enter incorrect email as “wrong@mail” on main website page
      And I enter correct password "Password" on main website page
      And I click “Login” button on main website page
      Then I am on web app login page
      And I see error message “Please check your entries.” on web app login page

