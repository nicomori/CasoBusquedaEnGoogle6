package com.smartfrog.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;
import com.smartfrog.util.DateAndTime;
import com.smartfrog.util.ScreenshotCreator;

/**
 * this class represent the first page of the android app, where we can see the
 * login button
 * 
 * @author nicolasmori
 */
public class WelcomePage extends ParentPage {

	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	private By IMAGE_LOGOTYPE_ID = By.id("com.inovotecs.smartfrog.dev:id/imageView");
	@SuppressWarnings("unused")
	private By BUTTON_HOW_IT_WORKS_ID = By.id("com.inovotecs.smartfrog.dev:id/tour_button");
	@SuppressWarnings("unused")
	private By BUTTON_REGISTER_NOW_ID = By.id("com.inovotecs.smartfrog.dev:id/button_register");
	private By BUTTON_LOG_IN_ID = By.id("com.inovotecs.smartfrog.dev:id/button_login");

	@SuppressWarnings("unused")
	private By IMAGE_LOGOTYPE_NAME_IOS = By.name("logo_welcome");
	@SuppressWarnings("unused")
	private By IMAGE_LOGOTYPE_XPATH_IOS = By.xpath("//XCUIElementTypeImage[@name='logo_welcome']");
	@SuppressWarnings("unused")
	private By BUTTON_HOW_IT_WORKS_XPATH_IOS = By.xpath("//XCUIElementTypeButton[@name='How it works']");
	@SuppressWarnings("unused")
	private By BUTTON_REGISTER_NOW_XPATH_IOS = By.xpath("//XCUIElementTypeButton[@name='Sign up now']");
	@SuppressWarnings("unused")
	private By BUTTON_LOG_IN_XPATH_IOS = By.xpath("//XCUIElementTypeButton[@name='Log in']");
	
	/**
	 * this method make click in the button Log In.
	 */
	public void clickInTheButtonLogin() {
		System.out.println("Waiting until the button Login appear.");
		if (System.getProperty("testingType").equals("android")) {
			waitLongForAnExplicitElement(IMAGE_LOGOTYPE_ID);
			waitSleepingTheTread(5555);
			ScreenshotCreator.createScreenshot(driver, "SmartFrog - " + DateAndTime.getDateAndTime());
			click(BUTTON_LOG_IN_ID);
		}else {
			waitLongForAnExplicitElement(IMAGE_LOGOTYPE_XPATH_IOS);
			click(BUTTON_LOG_IN_XPATH_IOS);
			waitSleepingTheTread(5555);
		}
	}
}
