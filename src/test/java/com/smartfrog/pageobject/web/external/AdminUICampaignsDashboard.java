package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class AdminUICampaignsDashboard extends ParentPage {

	/**
	 * @param driver
	 */
	public AdminUICampaignsDashboard(WebDriver driver) {
		super(driver);
	}

	private By NEW_CAMPAIGN_BUTTON = By.xpath("//*[contains(@value,'New Campaign')]");

	private By NEW_CAMPAIGN_POPUP_NAME_EDIT_FIELD = By.xpath("//input[@ng-model='newCampaign.name']");
	private By NEW_CAMPAIGN_POPUP_DESCRIPTION = By.xpath("//input[@ng-model='newCampaign.description']");
	private By NEW_CAMPAIGN_POPUP_UNDEFINED_LIST = By.xpath("//select[@ng-model='newCampaign.partnerName']");
	private By NEW_CAMPAIGN_POPUP_FU_SELECT_OPTION = By.xpath("//option[@value='First Utility']");
	private By NEW_CAMPAIGN_POPUP_CREATE_BUTTON = By.xpath("//input[@value='Create']");

	public void clickInNewCampaignButton() {
		System.out.println("Making click in the New Campaign Button");
		click(NEW_CAMPAIGN_BUTTON);
	}

	public void sucessFillFormNewCampaign(String name, String description) {
		System.out.println("Start to fill the form of the new campaign");
		sendKeysToLocator(NEW_CAMPAIGN_POPUP_NAME_EDIT_FIELD, name);
		sendKeysToLocator(NEW_CAMPAIGN_POPUP_DESCRIPTION, description);
		click(NEW_CAMPAIGN_POPUP_UNDEFINED_LIST);
		click(NEW_CAMPAIGN_POPUP_FU_SELECT_OPTION);
		click(NEW_CAMPAIGN_POPUP_CREATE_BUTTON);
	}
}
