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
public class MobilcomSteps extends StepsHelper {

	@And("^I can see Mobilcom logo on the Mobilcom main page$")
	public void iCanSeeMobilcomLogo() {
		mobilcomeHomePage.MobilcomLogoItem();
	}

	@And("^I can see the MD Login form$")
	public void checkLoginForm() {
		mobilcomeHomePage.MobilcomLoginForm();
	}

	@And("^I can see the MD title \"([^\"]*)\"$")
	public void iCanSeeMdTitle(String pageTitle) {
		mobilcomeHomePage.verifyContentInTheTitle(pageTitle);
	}

	@And("^I can see \"([^\"]*)\" in the MD login form$")
	public void iCanSeeForgotPassword(String someTextInThePassword) {
		mobilcomeHomePage.verifyTextInThePasswordLink(someTextInThePassword);
	}

	@When("^I click on \"([^\"]*)\" on Mobilcom main page$")
	public void openMdFootLink(String footerLink) {
		mobilcomeHomePage.scrollDownToTheBottom();
		mobilcomeHomePage.clickMobilcomFooterLinks(footerLink);
	}

	@Then("^Page Mobilcom has title \"([^\"]*)\" and URL is \"([^\"]*)\"$")
	public void checkMdFooterLinks(String pageTitle, String urlPart) {
		Assert.assertTrue("Service page title is incorrect : ", mobilcomeHomePage.verifyContentInTheTitle(pageTitle));
		Assert.assertTrue("Service url is incorrect : ", mobilcomeHomePage.verifyContentInTheURL(urlPart));
	}
}