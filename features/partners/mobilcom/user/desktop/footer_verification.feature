@mobilcomwebapp @Desktop @Core @mobilcom @Smoke @User @Partner
Feature: Mobilcom - footer links verification

  Scenario Outline: Footler links
  	Given I detect the enviroment to execute the test
	Given I am on "Mobilcom" landing page
    When I click on "<links>" on Mobilcom main page
    Then Page Mobilcom has title "<PageTitle>" and URL is "<urlPart>"

    Examples:
      | links                 | PageTitle                  | urlPart                   |
      | Support               | Support	                  | /static/support           |
      | Datenschutzrichtlinie | Datenschutzrichtlinie      | /static/privacy-policy    |
      | Cookies               | Cookies-Richtlinie         | /static/cookie-policy     |
      | Open Source           | Open Source Terms          | /static/open-source-terms |
      | Impressum             | Impressum                  | /static/imprint           |
