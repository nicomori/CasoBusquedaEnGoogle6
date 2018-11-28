package com.smartfrog.steps.partners;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import junit.framework.Assert;

/**
 * @author nicolasmori
 *
 */
public class MedionSteps extends StepsHelper {
	
	@And("^I can see Medion promotion logo$")
	public void iCanSeeTheLogoOfMedion() {
		Assert.assertTrue(medionHomePage.verifyLogoPartner());
	}
	
	@And("^I can see just shop button on Medion landing page$")
	public void iCanSeeTheShopButtonOfMedion() {
		Assert.assertTrue(medionHomePage.verifyButtonShopPartner());
	}
}