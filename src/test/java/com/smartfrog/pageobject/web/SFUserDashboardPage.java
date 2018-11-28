package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the page of my account
//https://app.sf-dev1.com/de-de/account/overview
public class SFUserDashboardPage extends ParentPage {

	public SFUserDashboardPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By header_button_shop = By.xpath("//*[contains(@href,'/shop/products')]");
	private By body_popup_button_close = By.xpath("//*[contains(@pid,'body_popup_button_close_x')]");
	private By header_selector_leanguage = By.xpath("(//*[contains(@class,'sfc-country-select')])[1]");
	private By header_option_german = By.xpath("(//*[contains(@class,'sfc-country-select')])[1]//li[1]");
	private By header_option_english = By.xpath("(//*[contains(@class,'sfc-country-select')])[1]//li[2]");
	private By header_button_my_account = By.xpath("//*[contains(@pid,'header_button_my_account')]");

	// methods sections
	/**
	 * this method make click in the button SHOP.
	 */
	public void pressButtonShop() {
		System.out.println("Starting to press the button Shop");
		waitSleepingTheTread(2000);
		if (verifyIfisDisplayedX2(body_popup_button_close)) {
			clickJSx2(body_popup_button_close);
		}
		waitSleepingTheTread(1000);
		clickX2(header_button_shop);
	}

	/**
	 * this method select the lenguage german.
	 */
	public void selectLenguageGerman() {
		System.out.println("Stating to send the lenguage to select german.");
		clickJSx2(header_selector_leanguage);
		waitSleepingTheTread(500);
		clickJSx2(header_option_german);
		waitSleepingTheTread(3000);
	}

	/**
	 * this method select the lenguage english.
	 */
	public void selectLenguageEnglish() {
		System.out.println("Stating to send the lenguage to select english.");
		clickJSx2(header_selector_leanguage);
		waitSleepingTheTread(500);
		clickJSx2(header_option_english);
		waitSleepingTheTread(3000);
	}

	/**
	 * this method close the pop up making click in the X in the right corner.
	 */
	public void closePopUp() {
		System.out.println("Starting to close the popup.");
		waitSleepingTheTread(2000);
		if (verifyIfisDisplayedX2(body_popup_button_close)) {
			clickJSx2(body_popup_button_close);
		}
		waitSleepingTheTread(1000);
	}

	/**
	 * this method make click in the button my account
	 */
	public void clickOnMyAccount() {
		System.out.println("Starting to make click in the button my account.");
		waitForAnExplicitElement(header_button_my_account);
		clickJSx2(header_button_my_account);
	}
}
