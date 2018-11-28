@Smoke @smartfrog @Desktop @Ecommerce @Wip

Feature: Smartfrog - flow retail camera
  As Smartfrog user I can register my retail camera

  Scenario: I can proceed through retail camera registration flow
    When I create new user account in Smartfrog using API
    And I set newly registered user as Test in Videocloud API
    And I create a new retail camera using API
    Then I can assign a camera to the Smartfrog user using API
    When I login to Smartfrog web application
    Then I can see Register Retail camera overlay
    When I click on "Kamera anmelden" button
    Then I am redirected to Retail Camera Registration page
    And I can see proper texts and price displayed
    When I click on 'Weiter' on Retail Camera Registration page
    Then I am on shop user details page
    When enter invoice address on shop user details page and click 'Next'
      | Title | FirstName | Surname | Company | Street     | StrNum | Zip    | City   |
      | Herr  | Test1     | Test2   |         | StreetName | 123    | 120767 | Berlin |
    Then I am on shop payment page
    And different delivery address option is not available
    When I click button 'Next' on shop user details page
    Then I am on shop payment page
    And I can see retail text is displayed on shop payment page
      | Keine Sorge, dein Zahlungsmittel wird jetzt nicht belastet.                    |
      | Wir benötigen diese Information jedoch, um ab dem 2. Monat                     |
      | den monatlichen Beitrag von 5,35 € einzuziehen, soweit vorher nicht gekündigt. |
    When I choose payment method "PayPal" and click button "Weiter"
    Then I am on shop summary page
    And I can see information that camera is free at first month
      | im ersten Monat kostenlos |
    And total price data displayed on shop summary page
    When I agree with terms and click 'Buy now'
    Then I am redirected to PayPal payment page
    And I am enter email "paypaltest@adyen.com" and password on PayPal page
    And I agree payment on PayPal page
    Then I am on shop payment success page
    And I can see message "Vielen Dank für deine Anmeldung" on shop payment success page
    And I can see information about registered retail camera on shop payment success page
      | Ab dem 2. Monat erfolgt die Bezahlung mit der gewählten Zahlungsmethode. |
    And I can see customer service number "Deutschland 030 - 991 99 991" on success page
