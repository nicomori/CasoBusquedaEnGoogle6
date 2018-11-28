package com.smartfrog.pageobject.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the summary registration page of smartfrog, an example of that is this: https://www.sf-dev1.com/de-de/shop/summary?checkout=52eb820a-622c-42c7-95e1-f4bfbc245b69&paymentMethod=directEbanking
public class SFRegisterSummaryPage extends ParentPage {

	public SFRegisterSummaryPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_button_checkout = By.xpath("//form//button");
	private By body_checkbox_legal = By.xpath("//form/label/input");
	private By body_text_invoice_address = By.id("invoice-address");
	private By body_text_delicery_address = By.id("delivery-address");
	
	
	
	

	// methods sections
	/**
	 * this method retrive the text inside of invoice address.
	 */
	public String returnInvoiceAddress() {
		System.out.println("this method retrive the text inside of invoice address");
		waitForAnExplicitElement(body_text_invoice_address);
		return getTextByLocator(body_text_invoice_address);
	}
	
	/**
	 * this method retrive the text inside of delivery address.
	 */
	public String returnDeliveryAddress() {
		System.out.println("this method retrive the text inside of delivery address");
		waitForAnExplicitElement(body_text_delicery_address);
		return getTextByLocator(body_text_delicery_address);
	}
	
	/**
	 * this method validate the text inside of delivery address.
	 */
	public boolean validateDeliveryAddress(List<List<String>> listOfStringsToVerify) {
		System.out.println("this method validate the text inside of delivery address");
		waitSleepingTheTread(3000);
		for (List<String> dataTableToVerify : listOfStringsToVerify) {
			for (String stringInside : dataTableToVerify) {
				if (returnDeliveryAddress().contains(stringInside)) {
					System.out.println("This text to verify the String: " + stringInside);
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * this method validate the text inside of invoice address.
	 */
	public boolean validateInvoiceAddress(List<List<String>> listOfStringsToVerify) {
		System.out.println("this method validate the text inside of invoice address");
		waitSleepingTheTread(3000);
		for (List<String> dataTableToVerify : listOfStringsToVerify) {
			for (String stringInside : dataTableToVerify) {
				if (returnInvoiceAddress().contains(stringInside)) {
					System.out.println("This text to verify the String: " + stringInside);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * this method verify if the button checkout is correctly displayed.
	 */
	public boolean summaryVerifyIfTheButtontCheckoutExist() {
		System.out.println("this method verify if the button checkout of the page appear correctly");
		waitForAnExplicitElement(body_button_checkout);
		return verifyIfisDisplayedX2(body_button_checkout);
	}
	
	/**
	 * this method enable the legal checkbox and make click in the button checkout.
	 */
	public void enableCheckOutAndMakeClicInTheButtonCheckout() {
		System.out.println("this method verify if the button checkout of the page appear correctly");
		waitForAnExplicitElement(body_checkbox_legal);
		clickJSx2(body_checkbox_legal);
		waitSleepingTheTread(500);
		clickJSx2(body_button_checkout);
	}	
}
