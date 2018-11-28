package com.smartfrog.steps.partners;

import java.util.List;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nicolasmori
 *
 */
public class PartnerGenericSteps extends StepsHelper {

	@Then("I can see promo section component on \"(.*)?\" landing page with header \"(.*)?\"")
	public void partnerHeaderText(String partnerName, String textToFind) {
		Assert.assertTrue(partnerLandingPage.verifyTheCorrectDeployOfSomeGenericText(textToFind));
	}

	@And("^I can see promo section component contains$")
	public void iCanSeePromoSectionComponentContains(DataTable promoTextsTable) {
		List<String> promoTexts = promoTextsTable.asList(String.class);
		firstUtilityHomePage.verifyPromoSectionData(promoTexts);
	}

	@And("^I can see \"([^\"]*)\" badge component on \"([^\"]*)\" page$")
	public void iCanSeeBadgeComponentOnFirstUtilityPage(String badgeCount, String partnerName) {
		int badgeAmount = Integer.valueOf(badgeCount);
		firstUtilityHomePage.verifyFirstUtilityBadge(badgeAmount);
	}

	@Then("I can see \"(.*)?\" promotion logo")
	public void verifyTheHeaderPartnerLogo(String partnerName) {
		Assert.assertTrue(partnerLandingPage.verifyIfTheHeaderCoBrandedPartnerLogoIsDisplayed());
	}

	@Then("click on the shop/redeem button")
	public void clickOnHeaderShopButton() {
		partnerLandingPage.clickOnTheCartIcon();
	}

	@And("being redirected to homepage")
	public void verifyWeAreInTheHomePage() {
		Assert.assertTrue(partnerLandingPage.verifyIfTheHeaderLogoIsDisplayed());
	}
}