@Smoke @mobilcom @User @Partner @mobilcomWebapp @Desktop
Feature: Mobilcom - Newly created user login

	@jira=QA-3420
	Scenario: Newly created user can login to his account
 		Given I register Mobilcom user from Hotline Channel using API and open user activation URL
		Then navigate to mobilcom web apps login page
		And specify users email and password
		And click Login button
		Then the user is logged in to his account and can see camera overview screen