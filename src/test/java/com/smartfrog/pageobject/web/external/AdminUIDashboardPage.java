package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class AdminUIDashboardPage extends ParentPage {

	/**
	 * @param driver
	 */
	public AdminUIDashboardPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAMenu(String menuName) {
		System.out.println("Access to the menu " + menuName);
		waitSleepingTheTread(3000);
		genericClickByText(menuName);
	}

	public void clickOnASubMenu(String subMenuName) {
		System.out.println("Access to the subMenu " + subMenuName);
		genericClickByText(subMenuName);
	}
}
