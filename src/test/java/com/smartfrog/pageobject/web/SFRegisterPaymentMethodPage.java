package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: https://www.sf-dev1.com/de-de/shop/register
public class SFRegisterPaymentMethodPage extends ParentPage {

	public SFRegisterPaymentMethodPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_form_radiobutton_direct_banking = By.xpath("//input[@value='sepadirectdebit']");
	private By body_form_radiobutton_credit_card = By.xpath("//input[@value='card']");
	private By body_form_radiobutton_paypal = By.xpath("//input[@value='paypal']");
	private By body_form_radiobutton_sofort = By.xpath("//input[@value='directEbanking']");
	@SuppressWarnings("unused")
	private By body_form_button_back = By.xpath("//section/div[2]/button");
	private By body_form_button_continue = By.xpath("//section/div[2]/button[2]");

	// methods sections
	/**
	 * this method select the radio button to select
	 */
	public void selectPaymentMethod(String paymentMethod) {
		System.out.println("Starting to press the radio button: "+paymentMethod);
		if(paymentMethod.contains("ofort")) {
			selectSofort();
		} else if(paymentMethod.contains("redit")) {
			selectCreditCard();
		} else if(paymentMethod.contains("ayPal")) {
			selectPayPal();
		} else if(paymentMethod.contains("epa")) {
			selectDirectBank();
		} else {
			selectCreditCard();
		}
	}
	
	/**
	 * this method verify if we are in the page of payments.
	 */
	public boolean verifyIfIAmInThePaymentPage() {
		System.out.println("this method let us know if we are in the payment registration page.");
		waitForAnExplicitElement(body_form_button_continue);
		return verifyIfisDisplayedX2(body_form_button_continue);
	}
	
	/**
	 * this method select the radio button direct bank.
	 */
	public void selectDirectBank() {
		System.out.println("this method select the radio button select direct bank. And press the continue button.");
		clickJSx2(body_form_radiobutton_direct_banking);
		waitSleepingTheTread(1500);
		clickJSx2(body_form_button_continue);
		waitSleepingTheTread(3000);
	}

	/**
	 * this method select the radio button credit card.
	 */
	public void selectCreditCard() {
		System.out.println("this method select the radio button select credit card. And press the continue button.");
		waitSleepingTheTread(3000);
		clickJSx2AndRefreshInCaseWeNeed(body_form_radiobutton_credit_card);
		waitSleepingTheTread(1500);
		clickJSx2(body_form_button_continue);
		waitSleepingTheTread(3000);
	}

	/**
	 * this method select the radio button paypal.
	 */
	public void selectPayPal() {
		System.out.println("this method select the radio button select paypal. And press the continue button.");
		waitForAnExplicitElement(body_form_radiobutton_paypal);
		clickJSx2(body_form_radiobutton_paypal);
		waitSleepingTheTread(1500);
		clickJSx2(body_form_button_continue);
	}

	/**
	 * this method select the radio button sofort.
	 */
	public void selectSofort() {
		System.out.println("this method select the radio button select sofort. And press the continue button.");
		waitForAnExplicitElement(body_form_radiobutton_sofort);
		clickJSx2(body_form_radiobutton_sofort);
		waitSleepingTheTread(1500);
		clickJSx2(body_form_button_continue);
		waitSleepingTheTread(3000);
	}
	
	/**
	 * this method make click in continue.
	 */
	public void makeClickInTheButtonContinue() {
		System.out.println("this method select the radio button select direct bank. And press the continue button.");
		waitForAnExplicitElement(body_form_button_continue);
		clickJSx2(body_form_button_continue);
		waitSleepingTheTread(3000);
	}
}
