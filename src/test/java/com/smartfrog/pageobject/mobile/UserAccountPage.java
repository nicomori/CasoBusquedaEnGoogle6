package com.smartfrog.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

/**
 * this class represent the page of the user account after make click into the
 * user option in the burguer menu.
 * 
 * @author nicolasmori
 */
public class UserAccountPage extends ParentPage {

	public UserAccountPage(WebDriver driver) {
		super(driver);
	}

	@SuppressWarnings("unused")
	private By BUTTON_CHANGE_PASS_ID = By.id("");
	@SuppressWarnings("unused")
	private By BUTTON_TIME_ZONE_ID = By.id("");
	@SuppressWarnings("unused")
	private By BUTTON_RECEIVER_NEWS_ID = By.id("");
	@SuppressWarnings("unused")
	private By BUTTON_SUSPEND_ACCOUNT_ID = By.id("");
	private By BUTTON_SIGN_OFF_ID = By.id("com.inovotecs.smartfrog.dev:id/account_button_signoff");
	private By POPUP_BUTTON_YES_ID = By.id("com.inovotecs.smartfrog.dev:id/positiveButton");
	@SuppressWarnings("unused")
	private By POPUP_BUTTON_NO_ID = By.id("com.inovotecs.smartfrog.dev:id/negativeButton");

	/**
	 * this method make the sign off.
	 */
	public void signOff() {
		waitForAnExplicitElement(BUTTON_SIGN_OFF_ID);
		click(BUTTON_SIGN_OFF_ID);
		click(POPUP_BUTTON_YES_ID);
	}
}
