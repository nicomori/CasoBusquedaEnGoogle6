@webshop @Ecommerce @Desktop @smartfrog @Smoke @Broken
Feature: Web shop unregistered user can see proper set of product for HW, NHW1, NHW2 countries

  As a user from HW, NHW1, NHW2 countries
  I want to see proper set of product for my country
  So that I can see correct products set

  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario: I can see proper set of products for HW countries with German Language
    When I am select "Deutschland" country
    Then I can see "2" products on shop products page
    And I can see product details on shop product page
      | productName    | productLink  | productPrice        | buyButton    |
      | Komplettlösung | Mehr Details | nur 5,95€ im Monat1 | Jetzt kaufen |
      | Kamera-Paket   | Mehr Details | nur 149€ einmalig   | Jetzt kaufen |

  Scenario: I can see proper set of products for HW countries with English Language
    When I am select "United Kingdom" country
    Then I can see "2" products on shop products page
    And I can see product details on shop product page
      | productName         | productLink  | productPrice               | buyButton |
      | Surveillance Bundle | More details | Only 4.95£ a month1        | Buy now   |
      | Camera package      | More details | Only 119£ one time payment | Buy now   |

  Scenario Outline: I can see proper set of products for NHW1 and NHW2 countries
    When I am select "<country>" country
    Then I can see "3" products on shop products page
    And I can see product details on shop product page
      | productName     | productLink  | productPrice    | buyButton    |
      | 4-hour package  | More details | <4hourPackage>  | Use for free |
      | 24-hour package | More details | <24hourPackage> | Buy now      |
      | 7-day package   | More details | <7dayPackage>   | Buy now      |

    Examples:
      | country | 4hourPackage  | 24hourPackage       | 7dayPackage         |
      | Italy   | 0,00€ a month | Only 2,95€ a month1 | Only 5,95€ a month1 |
      | Canada  | 0.00$ a month | Only 3.49$ a month1 | Only 6.99$ a month1 |

    #I can propose option create file with list of countries and each time randomly select one country from list
