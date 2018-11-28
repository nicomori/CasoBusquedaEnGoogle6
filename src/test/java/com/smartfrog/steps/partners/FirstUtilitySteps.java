package com.smartfrog.steps.partners;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

/**
 * @author nicolasmori
 *
 */
public class FirstUtilitySteps extends StepsHelper {

	@When("^I click on \"([^\"]*)\" button on \"([^\"]*)\" landing page$")
	public void iClickOnButtonClaimNowButtonOnFirstUtilityLandingPage(String buttonText, String parterName) {
		firstUtilityHomePage.makeClickInTheButtonClaimNow();
	}

	@Then("^I can see First Utility promo header with text \"([^\"]*)\"$")
	public void iCanSeePromoHeaderWithText(String headerText) {
		System.out.println("Starting to verify if this test " + headerText + " appear correctly in deployed");
		Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheSite(headerText));
	}

	@And("^I can see Shop button on First Utility page$")
	public void iCanSeeShopButtonOnFirstUtilityPage() {
		Assert.assertTrue(firstUtilityHomePage.verifyIconCart());
	}
}