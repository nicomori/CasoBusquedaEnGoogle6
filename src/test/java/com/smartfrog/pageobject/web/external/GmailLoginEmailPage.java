package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class GmailLoginEmailPage extends ParentPage {

	/**
	 * @param driver
	 */
	public GmailLoginEmailPage(WebDriver driver) {
		super(driver);
	}

	private By EMAIL_EDITFIELD = By.id("identifierId");
	private By NEXT_BUTTON = By.id("identifierNext");

	/**
	 * this method set the user and make click in the button next.
	 * 
	 * @param String
	 *            with the user
	 */
	public void loginIntoTheApp(String user) {
		System.out.println("Starting to send the user: " + user + " to the userField");
		waitForAnExplicitElement(EMAIL_EDITFIELD);
		sendKeysToLocator(EMAIL_EDITFIELD, user);
		click(NEXT_BUTTON);
	}
}