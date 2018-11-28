@Smoke @smartfrog @MobileWeb @Ecommerce @Wip

Feature: Smartfrog - checkout channel tracking
  As a Marketing manager
  I want to make sure that GTM events are fired properly during checkout
  So that I can track the conversions

Scenario: check that GTM events are fired during checkout process
  Given I am on the main website
  And GTM fires "impressions" tag
  When I click on "Details" link at main web site
  Then GTM fires "pdp" event
  When I click on "Shop" button at main web site header
  Then I am on landing "Deutschland" shop products page
  When I click to buy "Komplettlösung"
  Then I am on cart page
  And GTM fires "addToCart" event
  When click to checkout on cart page
  Then I am on shop login page
  And GTM fires "loginOrRegister" event
  When I expand "loginOrRegister" event
  Then I can see "ecommerce" event and "products" event
  When I expand "products" event
  Then I can see data related to the shopping cart within the event
    | category     | id              | name             | price | quantity |
    | subscription | LeasePackage_1d | LeasePackage_1d" | 5.95  | 1        |
  When click "Weiter" on shop login page
  Then I am on shop register page
  And GTM fires "register" event
  When I enter email and repeat it as "test.user+@smartfrog.com"
  And enter default password on shop register page
  And click on "Jetzt registrieren" on shop register page
  Then I am on shop user details page
  And GTM fires "address" event
  When enter invoice address on shop user details page and click 'Next'
    | Title | FirstName | Surname   | Company | Street    | StrNum | Zip   | City        |
    | Herr  | Patrick   | Gremillet |         | Rheinstr. | 99     | 76532 | Baden-Baden |
  Then I am on shop payment page
  And GTM fires "payment" event
  When I choose payment method "Lastschrift" and click button "Weiter"
  Then I am on 'Adyen' details page
  When I enter name "A. Schneider" IBAN "DE87123456781234567890" on 'Adyen' page
  And click on "Weiter" button on 'Adyen' page
  And I am on complete 'Adyen' page
  And click on "Weiter" button on 'Adyen' page
  Then I am on shop summary page
  And GTM fires "summary" event


