package com.smartfrog.steps.partners;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

/**
 * @author nicolasmori
 *
 */
public class ShellSteps extends StepsHelper {

	@And("^I can see Shell promotion logo$")
	public void iCanSeeTheLogoOfMedion() {
		Assert.assertTrue(shellHomePage.verifyLogoPartner());
	}

	@Then("^I can see the input zipcode$")
	public void iCanSeeTheInputZipcode() {
		Assert.assertTrue(shellHomePage.verifyZipCodeFieldPartner());
	}
}