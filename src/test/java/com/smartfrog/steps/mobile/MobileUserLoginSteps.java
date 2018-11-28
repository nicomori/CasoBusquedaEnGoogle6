package com.smartfrog.steps.mobile;

import com.smartfrog.framework.ParentScenario;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nicolasmori
 *
 */
public class MobileUserLoginSteps extends ParentScenario {

	@When("I enter email as \"(.*)?\" on mobile login page")
	public void makeClickInTheLsodginButton(String username) {
		loginPage.fillTheFieldUsername(username);
	}

	@And("I enter password as \"(.*)?\" on mobile login page")
	public void makeClickInTheLoginBustton(String password) {
		loginPage.fillTheFieldPassword(password);
	}

	@And("I tap login button on mobile login page")
	public void makeClickInTheLogsinButton() {
		loginPage.makeClickIntoTheButtonLogin();
	}

	@Then("make the mobile logout process")
	public void logoutProcess() {
		welcomeAfterLoginPage.makeClickInCameraOverviewButton();
		homePage.makeClickInTheBurgerMenuButton();
		burguerMenu.clickOnUserAccount();
		userAccountPage.signOff();
	}

}