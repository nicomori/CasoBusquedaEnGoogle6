@Desktop @User @WebApp @smartfrog @Smoke @jira=QA-3744
Feature: Forgot Password

  Scenario: Forgot Password - email verification
    Given Go to smartfrog.com
	When click on Forgot password
	And enter a valid email address
	And click on 'Send link via email'
	Then check the mail account if a mail arrived
	Then open the mail and click on 'Reset password'
	
