package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class AdminUIDevicesDashboard extends ParentPage {

	/**
	 * @param driver
	 */
	public AdminUIDevicesDashboard(WebDriver driver) {
		super(driver);
	}

	private By ADD_DEVICE_BUTTON = By.xpath("//*[contains(@value,'Add Device')]");

	public void makeClickInTheButtonAddNewDevice() {
		System.out.println("Adding a new Device");
		click(ADD_DEVICE_BUTTON);
	}
}
