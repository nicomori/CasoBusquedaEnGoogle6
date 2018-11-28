package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class AdminUIDevicesAddDevice extends ParentPage {

	/**
	 * @param driver
	 */
	public AdminUIDevicesAddDevice(WebDriver driver) {
		super(driver);
	}

	private By SERIAL_NUMBER_EDITFIELD = By.xpath("//*[contains(@id,'serialnumber')]");

	public void makeClickInTheButtonAddNewDevice() {
		System.out.println("Adding a new Device");
		click(SERIAL_NUMBER_EDITFIELD);
	}
}
