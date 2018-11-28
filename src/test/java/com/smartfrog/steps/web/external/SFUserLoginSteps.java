package com.smartfrog.steps.web.external;

import com.smartfrog.framework.ParentScenario;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author nicolasmori
 *
 */
public class SFUserLoginSteps extends ParentScenario {

	@Then("I enter email as \"(.*)?\" on the homepage 1111111")
	public void makeClickInTheLssogsinButton(String email) {
		sfHhomePageWeb.enterEmail(email);
	}

	@And("I enter password as \"(.*)?\" on the homepage 2222222222")
	public void makeClickInTheLsogsinButton(String pass) {
		sfHhomePageWeb.enterPassword(pass);
	}

	@And("I click login button page 2222222222")
	public void makeClickInsssTheLogsinBustton() {
		sfHhomePageWeb.makeClickInTheButtonLogin();

	}

}