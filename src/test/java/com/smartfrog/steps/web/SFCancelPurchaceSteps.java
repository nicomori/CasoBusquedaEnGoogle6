package com.smartfrog.steps.web;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author nicolasmori
 *
 */
public class SFCancelPurchaceSteps extends StepsHelper {

	@And("In the success purchase page, I make click in the button to see the details of the product.")
	public void makeClickInTheButtonCameraDescription() {
		sfCheckoutConfirmationPage.iMakeClickInTheButtonToCameraDescription();
	}

	@And("Verify if we can see corretly displayed the success confirmation page")
	public void verifyThePageCheckoutConfirmation() {
		Assert.assertTrue(sfCheckoutConfirmationPage.iAmInTheConfirmationPurcharsePage());
		Assert.assertTrue(sfCheckoutConfirmationPage.verifyIfTheSubtitleAppearCorrectly());
		Assert.assertTrue(sfCheckoutConfirmationPage.verifyIfTheTitleAppearCorrectly());
	}

	@And("In the cancelation screen press the button to cancel the order")
	public void makeClickInTheButtonToCancelTheOrder() {
		sfCancelationOrderSummaryPage.clickOnCancelOrder();
	}

	@Then("verify if the message appear with the confirmation of the order is completed")
	public void verifyTheMessageWithTheCancelIsCompleted() {
		Assert.assertTrue(sfCancelationOrderSummaryPage.verifyMessageOrderCancelled());
		Assert.assertTrue(sfCancelationOrderSummaryPage.verifyMessageOrderCancelled());
	}

}