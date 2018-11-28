package com.smartfrog.steps.web;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author nicolasmori
 *
 */
public class SFExternalPaymentSteps extends StepsHelper {

	@And("in the sofort page I set this kontonumber \"(.*)\" and this pin \"(.*)\" and press in continue")
	public void sofortSetKontonummerAndPIN(String kontonummer, String pin) {
		sofortPage.makeTheLoginInSofort(kontonummer, pin);
	}

	@And("in the second page of sofort select the first radiobutton, and press in continue")
	public void sofortSetKontonummerAndPIN() {
		sofortPage.selectFirstAccountAndContinue();
	}

	@Then("in the last page of the sofort site, set this tan value  and select the checkbox and press continue")
	public void verifyWe3AreInTheCorrectSite(String tan) {
		sofortPage.setTanAndMakeClickInContinue(tan);
	}

	@And("I am in the website of sofort, in the first page")
	public void verifyWeAreInTheFirstPageOfSofortCorrectSite() {
		Assert.assertTrue(sofortPage.iAmInTheSofortFirstPage());
	}

	@And("I am in the website of sofort, in the second page")
	public void verifyWeAreInTheSecondPageOfSofortCorrectSite() {
		Assert.assertTrue(sofortPage.iAmInTheSofortSecondPage());
	}

	@And("I am in the website of sofort, in the last page")
	public void verifyWeAreInTheLastPageOfSofortCorrectSite() {
		Assert.assertTrue(sofortPage.iAmInTheSofortLastPage());
	}

	@Then("I am redirected to PayPal payment page")
	public void iAmInThePaypalPage() {
		Assert.assertTrue(payPalPage.iAmInThePaypalPage());
	}

	@And("I am enter email \"(.*)\" and password on PayPal page")
	public void inThePaypalPageSetTheEmail(String emailPaypal) {
		payPalPage.loginInThePaypalSite(emailPaypal);
	}

	@And("I agree payment on PayPal page")
	public void iConfirmThePaymentInPaypal() {
		payPalPage.confirmPayInPaypal();
	}
	
	
}