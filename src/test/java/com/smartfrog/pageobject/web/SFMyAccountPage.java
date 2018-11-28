package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the page of my account
//https://app.sf-dev1.com/de-de/account/overview
public class SFMyAccountPage extends ParentPage {

	public SFMyAccountPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	@SuppressWarnings("unused")
	private By body_link_change_email = By.xpath("//*[contains(@href,'/de-de/account/email')]");
	private By body_link_last_invoices = By.xpath("//*[contains(@href,'account/invoices')]");
	private By body_link_orders_last = By.xpath("//*[contains(@href,'/account/orders/')]");
	
	//sections invoices
	private By invoices_body_table_firstline_date = By.xpath("(//tr)[2]/td[2]");
	private By invoices_body_table_firstline_value = By.xpath("(//tr)[2]/td[3]");
	
	// methods sections
	/**
	 * this method make click in the link last order.
	 */
	public void clickOnTheLinkLastOrders() {
		System.out.println("Starting to make click link, last order.");
		try {
			waitForAnExplicitElement(body_link_orders_last);
			clickJSx2(body_link_orders_last);
		} catch (Exception e) {
			clickJSx2(body_link_last_invoices);
			waitSleepingTheTread(3000);
			refreshBrowser();
			waitSleepingTheTread(3000);
			refreshBrowser();
			waitSleepingTheTread(3000);
			clickBrowserButtonBack();
			waitLongForAnExplicitElement(body_link_orders_last);
			clickJSx2(body_link_orders_last);
		}
	}
	
	/**
	 * this method make click in the last invoices.
	 */
	public void makeClickInTheLastInvoices() {
		System.out.println("Starting to make click in the last invoices.");
		waitForAnExplicitElement(body_link_last_invoices);
		clickJSx2(body_link_last_invoices);
	}
	
	/**
	 * this method return the date of the first invoices line
	 */
	public String returnDateOfTheFirstInvoice() {
		System.out.println("Starting to find the value inside of the field date of invoices.");
		waitSleepingTheTread(8000);
		return getTextByLocator(invoices_body_table_firstline_date);
	}
	
	/**
	 * this method return the total value of the first invoices line
	 */
	public String returnTotalValueOfTheFirstInvoice() {
		System.out.println("Starting to find the value inside of the field total value of invoices.");
		refreshBrowser();
		waitSleepingTheTread(8000);
		System.out.println(getTextByLocator(invoices_body_table_firstline_value));
		waitForAnExplicitElement(invoices_body_table_firstline_value);
		return getTextByLocator(invoices_body_table_firstline_value);
	}
}
