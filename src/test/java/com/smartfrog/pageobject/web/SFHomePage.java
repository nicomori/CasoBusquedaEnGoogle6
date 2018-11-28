package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class SFHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public SFHomePage(WebDriver driver) {
		super(driver);
	}

	private By EMAIL_EDITFIELD_CSS = By.xpath("//*[@name='user']");
	private By EMAIL_SHOP_EDITFIELD_CSS = By.cssSelector("body > div.app-container > header > div > div > form > div:nth-child(1) > input");
	private By PASS_EDITFIELD_CSS = By.xpath("//*[@name='pass']");
	private By PASS_SHOP_EDITFIELD_CSS = By.xpath("//*[@name='password']");
	private By LOGIN_BUTTON = By.cssSelector(".input-wrap.submit");
	private By SHOP_LOGIN_BUTTON = By.xpath("/html/body/div[3]/header/div/div/a[1]");
	private By countryDropDown = By.cssSelector("#dLabel");
	private By countrySelector = By.cssSelector("#country-selector-new");

	private static final By BODY_LABEL = By.cssSelector(".mainWrap.desktop");
	private static final By BADGE_SELECTOR = By.cssSelector("div.first-utility-banner");
	private static final By SHOP_BUTTON_LOCATOR = By.cssSelector("li.shop a");
	private static final By PROMO_SECTION_LOCATOR = By.cssSelector("div.element3.enbw-vip-promo-section");
	private static final By PROMO_HEADER_LOCATOR = By
			.cssSelector("h3.headline-element-main.headline-element-main--first-utility");
	private static final By PROMO_TEXTS = By
			.cssSelector("div.element3.enbw-vip-promo-section div.columns div.description");
	private static final By CLAIM_NOW_LOCATOR = By.cssSelector("a.button.button--first-utility");
	private static final By FU_SHOPPING_CART_HEADER = By.cssSelector("div.promo-inner.ng-binding");
	private static final By FU_NEWSHOP_SHOPPING_CART_HEADER = By.cssSelector(".first-utility__headline");
	private static final String TEXT_COMPONENT = "//*[contains(text(),'%s')]";
	

	public void selectCountry(String country) {
		System.out.println("Starting to change the country selector to the country: " + country);
		click(countryDropDown);
		genericClickByText(country);
	}

	public Boolean verifyIfTheMainTextExist() {
		System.out.println("Starting to verify if the main text label exist correctly.");
		waitLongForAnExplicitElement(BODY_LABEL);
		return verifyIfisDisplayedX2(BODY_LABEL);
	}

	public void makeClickInTheButtonLogin() {
		System.out.println("Making click in the button login");
		click(LOGIN_BUTTON);
		waitSleepingTheTread(6000);
	}

	public void makeClickInTheShopButtonLogin() {
		System.out.println("Making click in the button login");
		waitForAnExplicitElement(SHOP_LOGIN_BUTTON);
		click(SHOP_LOGIN_BUTTON);
	}

	public void enterEmail(String email) {
		System.out.println("Sending the value " + email + " to the editfield email.");
		waitForAnExplicitElement(EMAIL_EDITFIELD_CSS);
		sendKeysToLocator(EMAIL_EDITFIELD_CSS, email);
	}

	public void enterEmailShop(String email) {
		System.out.println("Sending the value " + email + " to the editfield email.");
		waitForAnExplicitElement(EMAIL_SHOP_EDITFIELD_CSS);
		sendKeysToLocator(EMAIL_SHOP_EDITFIELD_CSS, email);
	}

	public void enterPassword(String pass) {
		System.out.println("Sending the value " + pass + " to the editfield email.");
		waitForAnExplicitElement(PASS_EDITFIELD_CSS);
		sendKeysToLocator(PASS_EDITFIELD_CSS, pass);
	}

	public void enterPasswordShop(String pass) {
		System.out.println("Sending the value " + pass + " to the editfield email.");
		waitForAnExplicitElement(PASS_SHOP_EDITFIELD_CSS);
		sendKeysToLocator(PASS_SHOP_EDITFIELD_CSS, pass);
	}

	public void makeClickinTheButtonShop() {
		System.out.println("Making click in the button shop");
		click(SHOP_BUTTON_LOCATOR);
	}
}
