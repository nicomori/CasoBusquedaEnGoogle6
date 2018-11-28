@webshop @Ecommerce @Desktop @smartfrog @Smoke @Core @Broken @Wip @ClassA
Feature: Web shop registration page should be available by links

  As a anonymous customer
  I want to be registered at site
  So that I can get registration form by links

  Background:
    Given I am on landing "Deutschland" shop products page

  Scenario Outline: get registration form during checkout process
    When I am select "<country>" country
    And I click to buy "<productName>"
    And click to checkout on cart page
    And click "<button>" on shop login page
    Then I am on shop register page

    Examples:
      | country     | productName         | button   |
      | Deutschland | Komplettlösung      | Weiter   |
      | Ireland     | Surveillance Bundle | Continue |

  Scenario Outline: get registration form shop home page
    When I am select "<country>" country
    When I click on button "<registrationTextLink>" on shop products page
    Then I am on shop register page

    Examples:
      | country     | registrationTextLink     |
      | Deutschland | Noch kein Benutzerkonto? |

  Scenario Outline: shop register page has proper content
    Given I am visit "<language>" shop register page
    Then I can see form name "<formName>" on shop register page
    And I can see main form message "<mainMessage>" on shop register page
    And I can see agreement text "<disclaimerText>" on shop register page

    Examples:
      | language    | formName | mainMessage                                            | disclaimerText                                                                                                                                                                                          |
      | English     | Register | Please enter your email address and choose a password: | By clicking Register Now, you agree to our Terms of Service and that you have read and agree to our Privacy Policy, including our Cookies Policy and details of how we contact you.                     |
      | Deutschland | Anmelden | Bitte E-Mail-Adresse eingeben und Passwort wählen:     | Mit Klicken auf „Jetzt registrieren“ stimmst du den Nutzungsbedingungen zu und bestätigst, dass du die Datenschutzrichtlinie und die Richtlinien zur Verwendung von Cookies zur Kenntnis genommen hast. |

  Scenario Outline: check DE forms links on shop register page
    Given I am visit "<language>" shop register page
    When I click on link "<linkName>" on shop register page
    Then Page opened in new tab has title "<pageTitle>" and URL is "<urlPart>"

    Examples:
      | language    | linkName                               | pageTitle                         | urlPart                 |
      | Deutschland | Nutzungsbedingungen                    | Nutzungsbedingungen - Smartfrog   | /nutzungsbedingungen/   |
      | Deutschland | Datenschutzrichtlinie                  | Datenschutzrichtlinie - Smartfrog | /datenschutzrichtlinie/ |
      | Deutschland | Richtlinien zur Verwendung von Cookies | Cookies                           | /cookies/               |

  @jira=QA-3797
  Scenario Outline: check EN forms links on shop register page
    Given I am visit "<language>" shop register page
    When I click on link "<linkName>" on shop register page
    Then Page opened in new tab has title "<pageTitle>" and URL is "<urlPart>"

    Examples:
      | language | linkName         | pageTitle                    | urlPart            |
      | English  | Terms of Service | Terms of service - Smartfrog | /terms-of-service/ |
      | English  | Privacy Policy   | Privacy Policy - Smartfrog   | /privacy-policy/   |

  Scenario Outline: validation message for registered user for EN and DE
    Given I am visit "<language>" shop register page
    When I enter email and repeat it as "test.user+dev12@smartfrog.com" on shop register page
    And enter default password on shop register page
    And click on "<buttonName>" on shop register page
    Then I can see validation message "<errorMessage>"

    Examples:
      | language    | errorMessage                                                           | buttonName         |
      | Deutschland | Für test.user+dev12@smartfrog.com existiert bereits ein Benutzerkonto. | Jetzt registrieren |
      | English     | Username test.user+dev12@smartfrog.com already exists.                 | Register now       |

  Scenario Outline: fields pop-up helper appears when you click on field
    Given I am visit "<language>" shop register page
    When I click into 'Email' field on shop register page
    Then I can see pop-up with message "<evmailPopUp>"
    When I click into 'Repeat Email' field on shop register page
    Then I can see pop-up with message "<repeatEmailPopUp>"
    When I click into 'Create Password' field on shop register page
    Then I can see pop-up with message "<passwordPopUp>"

    Examples:
      | language    | evmailPopUp                      | repeatEmailPopUp                    | passwordPopUp                                                              |
      | English     | Email address must: be valid     | Email address must: match           | Password must have: min 6 chars max 64 chars Weak Password                 |
      | Deutschland | E-Mail Adresse muss: gültig sein | E-Mail Adresse muss: übereinstimmen | Passwort muss enthalten: min. 6 Zeichen max. 64 Zeichen Schwaches Passwort |

  Scenario Outline: password pop-up helper message validation
    Given I am visit "<language>" shop register page
    When I enter password as "veryweak" on shop registration page
    Then I can see pop-up with helper message "<veryWeak>"
    When I enter password as "weak1234" on shop registration page
    Then I can see pop-up with helper message "<strong>"
    When I enter password as "weak1234!" on shop registration page
    Then I can see pop-up with helper message "<strong>"
    When I enter password as "Weak1234!" on shop registration page
    Then I can see pop-up with helper message "<veryStrong>"

    Examples:
      | language | veryWeak      | strong        | veryStrong      |
      | English  | Weak Password | Good Password | Strong Password |
