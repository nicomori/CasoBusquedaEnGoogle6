package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the page of my account
//https://app.sf-dev1.com/de-de/account/orders/2018-060711505
public class SFCancelationOrderSummaryPage extends ParentPage {

	public SFCancelationOrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_button_cancel_order = By.xpath("//*[contains(@ng-click,'vm.cancelOrder')]");
	private By body_message_cancel_success = By.xpath("(//*[contains(@ng-if,'vm.message')])[2]/span");

	// methods sections
	/**
	 * this method make click in the button cancel order.
	 */
	public void clickOnCancelOrder() {
		System.out.println("Starting to make click on cancel order.");
		waitForAnExplicitElement(body_button_cancel_order);
		clickJSx2(body_button_cancel_order);
	}

	/**
	 * this method make verify if the message of success cancelation appear
	 * correctly.
	 * 
	 * @return boolean if the message appear correctly.
	 */
	public boolean verifyMessageOrderCancelled() {
		System.out.println("Starting to to verfy if the message cancel order appear correctly.");
		waitForAnExplicitElement(body_message_cancel_success);
		return verifyIfisDisplayedX2(body_message_cancel_success);
	}
}
