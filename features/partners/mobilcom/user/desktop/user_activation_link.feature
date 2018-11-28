@Smoke @mobilcom @User @Partner @mobilcomWebapp @UserRelay @Desktop
Feature: Mobilcom - User activation link
	
	@jira=QA-3419
	Scenario: User activation link can be used only one time
		When I register Mobilcom user from Hotline Channel using API and open user activation URL
    		And Specify user password and click Jetzt Registerieren
    		And Open the activation link one more time
        Then I should see an error message