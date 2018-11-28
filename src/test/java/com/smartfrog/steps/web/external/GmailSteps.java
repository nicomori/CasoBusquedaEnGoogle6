package com.smartfrog.steps.web.external;

import com.smartfrog.framework.ParentScenario;

import cucumber.api.java.en.And;

/**
 * @author nicolasmori
 *
 */
public class GmailSteps extends ParentScenario {

	@And("in the editfield email set this account \"(.*)?\"")
	public void makeClickInTheLsodgindButton(String user) {
		gmailLoginEmailPage.loginIntoTheApp(user);
	}

	@And("in the editfield password set this password \"(.*)?\"")
	public void makeCldickInTheLsodginButton(String password) {
		gmailLoginPassPage.loginIntoTheApp(password);
	}

	@And("make click in the button login")
	public void makeClickInTheLoginButton(String username) {
		loginPage.fillTheFieldUsername(username);
	}
}