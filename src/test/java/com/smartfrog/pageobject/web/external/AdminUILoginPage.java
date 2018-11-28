package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class AdminUILoginPage extends ParentPage {

	/**
	 * @param driver
	 */
	public AdminUILoginPage(WebDriver driver) {
		super(driver);
	}

	private By USERNAME_EDIT_FIELD = By.name("username");
	private By PASSWORD_EDIT_FIELD = By.name("password");
	private By SUBMIT_BUTTON = By.xpath("//button[contains(@type,'submit')]");

	public void makeSuccessLogin(String username, String password) {
		System.out.println("Starting to make the success login");
//		waitForAnExplicitElement(USERNAME_EDIT_FIELD);
//		waitSleepingTheTread(5555555);
		
		sendKeysToLocator(USERNAME_EDIT_FIELD, username);
		sendKeysToLocator(PASSWORD_EDIT_FIELD, password);
		click(SUBMIT_BUTTON);
	}
}
