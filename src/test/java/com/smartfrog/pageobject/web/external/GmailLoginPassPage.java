package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class GmailLoginPassPage extends ParentPage {

	/**
	 * @param driver
	 */
	public GmailLoginPassPage(WebDriver driver) {
		super(driver);
	}

	private By PASS_EDITFIELD = By.xpath("//input[@name='password']");
	private By NEXT_BUTTON = By.id("passwordNext");

	/**
	 * this method set the password and make click in the button next
	 * 
	 * @param String
	 *            with the pass
	 */
	public void loginIntoTheApp(String pass) {
		System.out.println("Starting to send the password: " + pass);
		waitForAnExplicitElement(PASS_EDITFIELD);
		sendKeysToLocator(PASS_EDITFIELD, pass);
		click(NEXT_BUTTON);
	}
}
