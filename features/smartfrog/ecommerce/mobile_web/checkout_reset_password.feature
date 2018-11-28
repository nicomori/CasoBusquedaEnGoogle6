@webshop @Ecommerce @MobileWeb @smartfrog @Smoke @Broken
Feature: Mobile Web shop reset password page content

  As a customer
  I want to reset password
  So that I can get reset password page

  Scenario Outline: validate content on reset password page
    Given I am on "<language>" shop reset password page
    Then I can see form name "<formName>" on reset password page
    And I can see main form message "<mainMessage>" on reset password page

    Examples:
      | language    | formName              | mainMessage                                                       |
      | English     | Forgot your password? | Which email address was used to register your Smartfrog account?  |
      | Deutschland | Passwort vergessen?   | Mit welcher E-Mail-Adresse wurde das Smartfrog Konto registriert? |

  Scenario Outline: validate message after send email
    Given I am on "<language>" shop reset password page
    When I enter email as "<email>" on reset password page
    And I click on button "<buttonName>" on reset password page
    Then I see message "<message>" on reset password page

    Examples:
      | language | email                         | buttonName          | message                                                                                                 |
      | English  | test.user+reset@smartfrog.com | Send link via email | If the email address was already registered in our system then a password recovery email has been sent. |

  Scenario Outline: links from login page to reset password page
    Given I am on "<language>" shop login page
    And I select option "<option>" on shop login page
    When click "<linkResetPassword>" on shop login page
    Then I am on shop reset password page

    Examples:
      | language | option                    | linkResetPassword     |
      | English  | I already have a password | Forgot your password? |
      #| Deutschland | Ich habe bereits ein Passwort. | Passwort vergessen?   |

  Scenario Outline: links from login page to reset password page
    Given I am on "<language>" shop login page
    And I select option "<option>" on shop login page
    When click "<linkResetPassword>" on shop login page
    Then I am on shop reset password page

    Examples:
      | language    | option                         | linkResetPassword   |
      #| English     | I already have a password      | Forgot your password? |
      | Deutschland | Ich habe bereits ein Passwort. | Passwort vergessen? |

  Scenario Outline: get reset password from shop home page
    When I am on "<language>" shop product page
    And I click on button "<registrationTextLink>" on shop products page
    Then I am on shop reset password page

    Examples:
      | language    | registrationTextLink |
      | Deutschland | Passwort vergessen?  |
