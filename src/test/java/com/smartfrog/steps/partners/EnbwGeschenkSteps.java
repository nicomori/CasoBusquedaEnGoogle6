package com.smartfrog.steps.partners;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import junit.framework.Assert;

/**
 * @author nicolasmori
 *
 */
public class EnbwGeschenkSteps extends StepsHelper {
	@And("^I expect to see the promo section is displayed")
	public void iCanSeeCorrectyThePromoSection() {
		System.out.println("Starting to verify if we can see correctly the promo section");
		Assert.assertTrue(enbwHomePage.verifyPromoSectionIsDisplayed());
	}
}