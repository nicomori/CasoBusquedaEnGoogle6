package com.smartfrog.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

/**
 * this class represent the first page of the android app, where we can see the
 * login button
 * 
 * @author nicolasmori
 */
public class HomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@SuppressWarnings("unused")
	private By IMAGE_LOGO_ID = By.id("com.inovotecs.smartfrog.dev:id/imageView");
	@SuppressWarnings("unused")
	private By BUTTON_ACCEPT_ID = By.id("com.inovotecs.smartfrog.dev:id/accept_button");
	@SuppressWarnings("unused")
	private By BUTTON_LOGOUT_ID = By.id("com.inovotecs.smartfrog.dev:id/logout_button");
	@SuppressWarnings("unused")
	private By POPUP_LOGOUT_BUTTON_YES_ID = By.id("com.inovotecs.smartfrog.dev:id/negativeButton");
	@SuppressWarnings("unused")
	private By POPUP_LOGOUT_BUTTON_NO_ID = By.id("com.inovotecs.smartfrog.dev:id/positiveButton");
	@SuppressWarnings("unused")
	private By LINK_TERMS_AND_SERVICES_ID = By.id("");
	@SuppressWarnings("unused")
	private By LINK_PRIVACY_POLICY_ID = By.id("");
	@SuppressWarnings("unused")
	private By LINK_COOKIE_POLICY_ID = By.id("");
	@SuppressWarnings("unused")
	private By LINK_HOW_WE_MAY_CONTACT_YOU_ID = By.id("");
	private By BUTTON_BURGUER_ID = By.id("android:id/up");

	/**
	 * This method make a success login into the mobile app. Require for that a
	 * correct user activated.
	 * 
	 */
	public void makeClickInTheBurgerMenuButton() {
		System.out.println("Starting to make click into the menu burguen menu");
		waitSleepingTheTread(15000);
		waitForAnExplicitElement(BUTTON_BURGUER_ID);
		click(BUTTON_BURGUER_ID);
	}

}
