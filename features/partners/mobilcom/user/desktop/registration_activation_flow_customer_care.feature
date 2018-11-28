@Smoke @mobilcom @User @Partner @mobilcomWebapp @Userrelay @Desktop
Feature: Mobilcom - Registration and activation flow from MD Customer Care

  @jira=QA-1960
  Scenario: Mobilcom user creation from Hotline channel using API endpoint and verification of activation URL
    When I register Mobilcom user from Hotline Channel using API and open user activation URL
    Then I am redirected to Mobilcom user activation page and I see header "Benutzerkonto anlegen"
    And I can see user data at Mobilcom user activation page
      | Mr              |
      | Test User       |
      | Mohrenstr. 34   |
      | test            |
      | 10117 Berlin DE |
    And I can see user email is displayed at Mobilcom user activation page
    When I specify my password and click Register Now button
    Then I am redirected to Mobilcom Registration Success page and I see the header "Registrierung erfolgreich"
    And I can see delivery information at Mobilcom Registration Success page "Ihre mobilcom-debitel Smartfrog Kamera wird in 1-2 Tagen versendet."
