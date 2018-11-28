@webshop @Ecommerce @Desktop @smartfrog @Smoke
Feature: Web shop registered user can see proper set of product for users from HW, NHW1, NHW2 countries

  As a registered user from HW, NHW1, NHW2 countries
  I want to see proper set of product for my country
  So that I can see correct products set as registered user

  Scenario Outline: I can see proper set of product as registered user for HW country
    Given I detect the enviroment to execute the test
    Given I access to the webapp "<webapp>"
    And I am on the main website
    Then I click on the shop button on the mainpage
    Then I am on shopping product page
    Then I enter email as "<userEmail>" on the shop
    And I enter password as "<password>" on the shop
    And I click login button on the shop page
    Then I can see "<numbers>" products on shop product page
    And I can see products on shop product page
      | Komplettlösung                 | Kamera-Paket                  |
      | der jeweils letzten 24 Stunden | der jeweils letzten 4 Stunden |
      | Monatlich kündbar              | Kein Abo                      |
      | Keine Einrichtungskosten       | Keine Einrichtungskosten      |
      | Kostenloser Versand            | Zzgl. Versandkosten           |
      | 5,                             | 149                           |
      | 95                             |                               |
      | im Monat                       | einmalig                      |
      | Jetzt kaufen                   | Jetzt kaufen                  |

    Examples:
      | webapp | userEmail                                   | password   | numbers |
      |        | test.user+productverification@smartfrog.com | Test123!!! | 2       |

  Scenario Outline: I can see proper set of product as registered user for HW country with camera
    Given I detect the enviroment to execute the test
    Given I access to the webapp "<webapp>"
    And I am on the main website
    Then I click on the shop button on the mainpage
    Then I am on shopping product page
    Then I enter email as "<userEmail>" on the shop
    And I enter password as "<password>" on the shop
    And I click login button on the shop page
    Then I can see "<numbers>" products on shop product page
    And I can see products on shop product page
      | Komplettlösung                 | Kamera-Paket                  | Speichererweiterung                 |
      | der jeweils letzten 24 Stunden | der jeweils letzten 4 Stunden | Video-Speicher der jeweils letzten: |
      | Monatlich kündbar              | Kein Abo                      | 2,                                  |
      | Keine Einrichtungskosten       | Keine Einrichtungskosten      | 65                                  |
      | Kostenloser Versand            | Zzgl. Versandkosten           | im Monat                            |
      | 5,                             | 134                           | Video-Speicher kaufen               |
      | 35                             |                               |                                     |
      | im Monat                       | einmalig                      |                                     |
      | Jetzt kaufen                   | Jetzt kaufen                  |                                     |

    Examples:
      | webapp | userEmail                          | password   | numbers |
      |        | test.user+withCamera@smartfrog.com | Test123!!! | 3       |
