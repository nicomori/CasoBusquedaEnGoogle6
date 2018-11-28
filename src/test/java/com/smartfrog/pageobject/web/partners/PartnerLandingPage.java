package com.smartfrog.pageobject.web.partners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this class represent the values and the content of the generic landing page for partners, this is and example of the url where we can see this page:
//https://www.sf-dev1.com/en-gb/first-utility

public class PartnerLandingPage extends ParentPage {

	/**
	 * @param driver
	 */
	public PartnerLandingPage(WebDriver driver) {
		super(driver);
	}

	// Section WebElments
	private By header_button_shop = By.xpath("//*[@class='shop']");
	private By header_button_cart_icon = By.xpath("//*[@pid='header_button_cart_icon']");
	private By header_image_logoSF = By.xpath("//a[@class='logo']");
	private By header_text_partner_name = By.xpath("//*[@pid='header_text_partner_name']");
	private By logo_partner = By.xpath("//*[@class='promotion-logo']");

	// Section Methods
	/**
	 * This method return true or false in case some text is correctly displayed
	 *
	 * @param String
	 *            with the text to verify
	 * @return boolean
	 */
	public Boolean verifyTheCorrectDeployOfSomeGenericText(String textToVerify) {
		waitSleepingTheTread(2000);
		return genericVerifyIfSomeTextExist(textToVerify);
	}

	/**
	 * this method make click in some text received by parameter.
	 * 
	 * @param textToMakeClick
	 */
	public void makeClickInALinkGEneric(String textToMakeClick) {
		System.out.println("Starting to make click in this text: " + textToMakeClick);
		scrollDownToTheBottom();
		genericClickByText(textToMakeClick);
	}

	/**
	 * make click in the button back
	 */
	public void makeClickInTheButtonBack() {
		clickBrowserButtonBack();
	}

	/**
	 * verify if the button shop in the header is displayed
	 * 
	 * @return boolean condition
	 */
	public boolean verifyIfTheButtonShopAppear() {
		return verifyIfisDisplayedX2(header_button_shop);
	}

	/**
	 * this method make click in shop button
	 * 
	 */
	public void clickOnShopButton() {
		System.out.println("Starting to make click on the button Shop");
		waitForAnExplicitElement(header_button_shop);
		click(header_button_shop);
	}

	/**
	 * verify if some text appear in the web
	 * 
	 * @param String
	 *            with the text to find
	 * @return boolean condition
	 */
	public boolean verifyIfSomeTextAppearInTheSite(String textToVerify) {
		return genericVerifyIfSomeTextExist(textToVerify);
	}

	/**
	 * verify if some text appear in the URL
	 * 
	 * @param String
	 *            with the text to find in the URL
	 * @return boolean condition
	 */
	public boolean verifyIfSomeTextAppearInTheUrl(String textToVerify) {
		return genericVerifyIfSomeTextAppearInTheURL(textToVerify);
	}

	/**
	 * verify if some text appear in the URL, making a refresh in the middle and
	 * waiting for a couple of seconds
	 * 
	 * @param String
	 *            with the text to find in the URL
	 * @return boolean condition
	 */
	public boolean verifyIfSomeTextAppearInTheUrlWithRefresh(String textToVerify) {
		driver.navigate().refresh();
		waitSleepingTheTread(3000);
		return genericVerifyIfSomeTextAppearInTheURL(textToVerify);
	}

	/**
	 * verify if some text appear in the Title
	 * 
	 * @param String
	 *            with the text to find in the title
	 * @return boolean condition
	 */
	public boolean verifyIfSomeTextAppearInTheTitle(String textToVerify) {
		return genericVerifyIfSomeTextAppearInTheTitle(textToVerify);
	}

	/**
	 * verify if some text appear in the Title, making a refresh in the middle and
	 * waiting for a couple of seconds
	 * 
	 * @param String
	 *            with the text to find in the title
	 * @return boolean condition
	 */
	public boolean verifyIfSomeTextAppearInTheTitleWithRefresh(String textToVerify) {
		driver.navigate().refresh();
		waitSleepingTheTread(3000);
		return genericVerifyIfSomeTextAppearInTheTitle(textToVerify);
	}
	
	/**
	 * verify if some text appear in the site, making a refresh in the middle and
	 * waiting for a couple of seconds
	 * 
	 * @param String
	 *            with the text to find in the title
	 * @return boolean condition
	 */
	public boolean verifyIfSomeTextAppearInTheSiteWithRefresh(String stringToVerify) {
		driver.navigate().refresh();
		waitSleepingTheTread(3000);
		return genericVerifyIfSomeTextExist(stringToVerify);
	}

	/**
	 * This method verify if the logo header is correctly displayed
	 * 
	 * @return boolean
	 */
	public Boolean verifyIfTheHeaderLogoIsDisplayed() {
		waitSleepingTheTread(2000);
		return verifyIfisDisplayedX2(header_image_logoSF);
	}

	/**
	 * This method verify if the cobranded header text is correctly displayed
	 * 
	 * @return boolean
	 */
	public Boolean verifyIfTheHeaderCoBrandedTextPromotionIsDisplayed() {
		waitSleepingTheTread(1000);
		return verifyIfisDisplayedX2(header_text_partner_name);
	}

	/**
	 * This method verify if the cobranded logo header is correctly displayed
	 * 
	 * @return boolean
	 */
	public Boolean verifyIfTheHeaderCoBrandedPartnerLogoIsDisplayed() {
		waitSleepingTheTread(1000);
		return verifyIfisDisplayedX2(logo_partner);
	}

	/**
	 * This method make click in the header shop button
	 */
	public void clickOnTheShopButton() {
		waitSleepingTheTread(2000);
		clickJSx2(header_button_shop);
	}

	/**
	 * This method make click in the header icon cart
	 */
	public void clickOnTheCartIcon() {
		waitSleepingTheTread(2000);
		clickJSx2(header_button_cart_icon);
	}
}
