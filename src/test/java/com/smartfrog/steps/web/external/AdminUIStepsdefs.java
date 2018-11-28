package com.smartfrog.steps.web.external;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AdminUIStepsdefs extends StepsHelper {

	@And("I make a success login with the user \"([^\"]*)\" and the pass \"([^\"]*)\"$")
	public void IAmOnShellPag2e(String username, String password) {
		adminUILoginPage.makeSuccessLogin(username, password);
	}

	@And("In the Dashboard I make a click in the \"([^\"]*)\" tab$")
	public void IAmOnShellPag2e(String menuOption) {
		adminUIDashboardPage.clickOnAMenu(menuOption);
	}

	@And("From the submenu I access to \"([^\"]*)\"$")
	public void IAmOnShellPadg2e(String subMenuOption) {
		adminUIDashboardPage.clickOnAMenu(subMenuOption);
	}

	@Then("in the dashboard of campaigns I press the button New Campaign")
	public void IAmOnSheldlPadg2e() {
		adminUICampaignsDashboard.clickInNewCampaignButton();
	}

	@And("I create a new campaign for the partner \"([^\"]*)\" and serialized")
	public void IAmOnShdeldlPadg2e(String patern) {
		String campaignName = "Automation_" + System.currentTimeMillis();
		String descriptioncampaignName = campaignName + " This is the description.";
		adminUICampaignsDashboard.sucessFillFormNewCampaign(campaignName, descriptioncampaignName);
	}

	@Then("I activate the campaign")
	public void activateTheCampaign() {
		adminUICampaignDetails.activateCampaign();
	}

	@And("I update the campaign like a FreeProduct and FreeShipping")
	public void updateTheCampaignLikeAFreeproduct() {
		adminUICampaignDetails.addOrUpdateFreeProdAndFreeShipping();
	}

	@And("I add a voucher with a generic code and the total of \"([^\"]*)\" vouchers")
	public void getTheCodeToRedeem(String qty) {
		codeToRedeemed = adminUICampaignDetails.addVoucher(qty);
	}
}
