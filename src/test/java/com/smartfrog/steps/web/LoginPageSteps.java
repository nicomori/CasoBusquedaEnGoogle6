package com.smartfrog.steps.web;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nicolasmori
 *
 */
public class LoginPageSteps extends StepsHelper {

	@Then("^I am on shop login page$")
	public void verifyInTheShopLoginWeAreInTheCorrectSite() {
		Assert.assertTrue(sfLoginPage.shopVerifyIfTheMainTextExist());
	}

	@When("click \"(.*)\" on shop login page")
	public void makeInTheShopLoginClickOnContinue(String nameButton) {
		sfLoginPage.shopClickInTheButtonSubmit(nameButton);
	}

	@Then("in the shop login process, make click in the radiobutton of existing user")
	public void makeClinckInTheRadioButtonOfExistingUser() {
		sfRegisterFirstPage.selectRadioButtonUserExist();
	}
}