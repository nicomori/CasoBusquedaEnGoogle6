package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class PayPalPage extends ParentPage {

	/**
	 * @param driver
	 */
	public PayPalPage(WebDriver driver) {
		super(driver);
	}

	// ## LOCATORS SECTION
	@SuppressWarnings("unused")
	private By body_frame_loginIframe = By.name("ppfniframe");
	private By body_editfield_emailField = By.id("email");
	private By body_editfield_password = By.id("password");
	private By body_button_loginButton = By.id("btnLogin");
	private By body_button_confirmButton = By.id("confirmButtonTop");
	
	private static final String PAYPAL_PASSWORD = "p@ssword";

	
	// ## METHOD SECTION
	/**
	 * This method verify if we are located correctly in the fist page of the sofort
	 * payment method.
	 * 
	 * @return boolean condition if this page is displayed correctly
	 */
	public void loginInThePaypalSite(String email) {
		System.out.println("Starting to send the value email to the site paypal.");
		waitForAnExplicitElement(body_editfield_emailField);

		clearField(body_editfield_emailField);
		sendKeysToLocator(body_editfield_emailField, email);
		sendKeysToLocator(body_editfield_password, PAYPAL_PASSWORD);
		clickJSx2(body_button_loginButton);
	}
	
	/**
	 * This method confirm the payment in paypal.
	 * 
	 */
	public void confirmPayInPaypal() {
		System.out.println("Starting to make click in the confirmation of paypal.");
		waitLongForAnExplicitElement(body_button_confirmButton);
		clickJSx2(body_button_confirmButton);
		waitSleepingTheTread(3000);
		try {
			clickJSx2(body_button_confirmButton);
		} catch (Exception e) {
			clickJSx2(body_button_confirmButton);
		}
	}
	
	/**
	 * This method confirm the payment in paypal.
	 * 
	 * @return boolean condition if this page is displayed correctly
	 */
	public boolean iAmInThePaypalPage() {
		System.out.println("Starting to verify if the field email editfield is correctly displayed in the login of paypal.");
		waitLongForAnExplicitElement(body_editfield_emailField);
		return verifyIfisDisplayedX2(body_editfield_emailField);
	}
}
