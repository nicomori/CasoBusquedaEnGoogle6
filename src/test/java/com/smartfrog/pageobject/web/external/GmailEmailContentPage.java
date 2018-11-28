package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class GmailEmailContentPage extends ParentPage {

	/**
	 * @param driver
	 */
	public GmailEmailContentPage(WebDriver driver) {
		super(driver);
	}

	private By SET_PASSWORD_BUTTON = By.xpath("(//tbody//center//tbody)[5]//a");

	/**
	 * this method get the link behind of the button set password.
	 * 
	 * @return
	 * 
	 * @return String with the link of the page to set the password.
	 */
	public String getLinkInsideOfButtonSetPassword() {
		System.out.println("Starting to get the url behind of the button set password.");
		return getAttributeFromLocator(SET_PASSWORD_BUTTON, "href");
	}
}