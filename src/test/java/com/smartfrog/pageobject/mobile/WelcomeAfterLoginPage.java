package com.smartfrog.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

/**
 * this class represent the first page after the concrete the login succesfuly
 * and access to the app.
 * 
 * @author nicolasmori
 */
public class WelcomeAfterLoginPage extends ParentPage {

	/**
	 * @param driver
	 */
	public WelcomeAfterLoginPage(WebDriver driver) {
		super(driver);
	}

	private By BUTTON_CAMERA_OVERVIEW_ID = By.id("com.inovotecs.smartfrog.dev:id/camera_overview_button");
	@SuppressWarnings("unused")
	private By BUTTON_CONNECT_FURTER_ID = By.id("com.inovotecs.smartfrog.dev:id/connect_cam_button");
	@SuppressWarnings("unused")
	private By BUTTON_BUY_FURTHER_ID = By.id("Com.inovotecs.smartfrog.dev:id/buy_cam_button");
	@SuppressWarnings("unused")
	private By BUTTON_HOW_IT_WORKS = By.id("com.inovotecs.smartfrog.dev:id/tour_button");

	/**
	 * this method make click into the camera overview button.
	 */
	public void makeClickInCameraOverviewButton() {
		System.out.println("Starting to make click into the button camera overview button.");
		waitForAnExplicitElement(BUTTON_CAMERA_OVERVIEW_ID);
		click(BUTTON_CAMERA_OVERVIEW_ID);
	}
}
