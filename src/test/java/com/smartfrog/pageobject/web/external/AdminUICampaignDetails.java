package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class AdminUICampaignDetails extends ParentPage {

	/**
	 * @param driver
	 */
	public AdminUICampaignDetails(WebDriver driver) {
		super(driver);
	}

	private By UPDATE_BUTTON = By.xpath("//input[@value='Update']");
	private By ADD_BUTTON = By.xpath("//input[@value='Add']");
	private By EDIT_BUTTON = By.xpath("//input[@value='Edit']");
	private By SAVE_BUTTON = By.xpath("//input[@value='Save']");
	private By ENABLE_CHECKBOX = By.xpath("//input[@ng-model='editCampaignDetails.enabled']");
	private By MODAL_ADD_BONUS_SELECT = By.xpath("//select[@ng-model='res.bonusType']");
	private By MODAL_ADD_BONUS_MONEYVALUE_OPTION = By.xpath("//option[@value='FreeProduct']");
	private By MODAL_ADD_BONUS_FREEPRODUCT_OPTION = By.xpath("//option[@value='FreeProduct']");
	private By MODAL_ADD_BONUS_AMOUNT_EUR_EDITFIELD = By.xpath("//input[@ng-model='res.moneyValue.amounts.EUR']");
	private By MODAL_ADD_BONUS_FREESHIPPING_CHECKBOX = By.xpath("//input[@ng-model='res.freeProduct.freeShipping']");
	private By MODAL_ADD_VOUCHER_CODE_EDITFIELD = By.xpath("//input[@ng-model='res.code']");
	private By MODAL_ADD_VOUCHER_MAX_EDITFIELD = By.xpath("//input[@ng-model='res.usageMax']");
	private By MODAL_ADD_BUTTON = By.xpath("(//input[@value='Add'])[1]");

	public void addOrUpdateMoneyValue() {
		System.out.println("Adding or updating the bonus like a Money Value type.");
		click(UPDATE_BUTTON);
		click(MODAL_ADD_BONUS_SELECT);
		click(MODAL_ADD_BONUS_MONEYVALUE_OPTION);
		sendKeysToLocator(MODAL_ADD_BONUS_AMOUNT_EUR_EDITFIELD, "100");
		click(MODAL_ADD_BUTTON);
	}

	public void addOrUpdateFreeProdAndFreeShipping() {
		System.out.println("Adding or updating the bonus like a Free Product with free shipping type.");
		click(UPDATE_BUTTON);
		click(MODAL_ADD_BONUS_SELECT);
		click(MODAL_ADD_BONUS_FREEPRODUCT_OPTION);
		click(MODAL_ADD_BONUS_SELECT);
		click(MODAL_ADD_BONUS_FREESHIPPING_CHECKBOX);
		click(MODAL_ADD_BUTTON);
	}

	public String addVoucher(String maxUses) {
		String voucherCode = Long.toString(System.currentTimeMillis());
		System.out.println("Adding a new Voucher with the code " + voucherCode);
		waitSleepingTheTread(500);
		waitForAnExplicitElement(ADD_BUTTON);
		clickJS(ADD_BUTTON);
		sendKeysToLocator(MODAL_ADD_VOUCHER_CODE_EDITFIELD, voucherCode);
		sendKeysToLocator(MODAL_ADD_VOUCHER_MAX_EDITFIELD, maxUses);
		click(MODAL_ADD_BUTTON);
		return voucherCode;
	}

	public void activateCampaign() {
		System.out.println("Start to activate campaign");
		waitForAnExplicitElement(EDIT_BUTTON);
		clickJSx2(EDIT_BUTTON);
		waitForAnExplicitElement(ENABLE_CHECKBOX);
		waitSleepingTheTread(2000);
		clickJSx2(ENABLE_CHECKBOX);
		clickJSx2(SAVE_BUTTON);
	}
}
