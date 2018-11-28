package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: https://test.adyen.com/hpp/pay.shtml?sessionValidity=2018-06-06T14%3A40Z&offset=0&shopperEmail=test.user%2B1528286583574%40smartfrog.com&paymentAmount=1130&shipBeforeDate=2018-06-13&merchantSig=uukRwd1m7t6BuB2HHVhIwoBMoUo%3D&merchantAccount=SmartfrogCOM&countryCode=DE&skinCode=jFn1LhN9&shopperLocale=de_DE&allowedMethods=card&merchantReference=dev1_c23e224b-48e2-4a0c-a75e-b578628f26cf&currencyCode=EUR&recurringContract=RECURRING%2CONECLICK&shopperReference=8c1d7102-ed0a-41da-a0e8-4fd0e79cf2b1&shopperStatement=Kunden%20Nr.%20155869766%2C%20Bestellung%20v.%2006.06.18&
public class SFRegisterPaymentMethodSepaPage extends ParentPage {

	

	public SFRegisterPaymentMethodSepaPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_form_editfield_cardnumber = By.xpath("//input[contains(@id,'cardNumber')]");
	private By body_form_editfield_name = By.xpath("//input[contains(@id,'cardHolderName')]");
	private By body_form_editfield_cvccode = By.xpath("//input[contains(@id,'cvcCode')]");
	private By body_form_select_experity_month = By.xpath("//select[contains(@id,'expiryMonth')]");
	private By body_form_select_experity_year = By.xpath("//select[contains(@id,'expiryYear')]");
	private By body_form_button_continue = By.xpath("(//input[contains(@name,'pay')])[2]");

	@SuppressWarnings("unused")
	private By body_form_button_back_firstpage = By.xpath("//input[contains(@id,'Back')]");

	// methods sections

	/**
	 * this method complete the form credit card with the name of the person and the
	 * values of the credit card.
	 * 
	 * @param String
	 *            credit card number
	 * @param String
	 *            person name
	 * @param String
	 *            cvc number
	 * @param String
	 *            experity mont
	 * @param String
	 *            experity year
	 */
	public void completeTheFormAndPressTheButtonNext(String creditCardNumber, String personName, String cvcNumber,
			String experityMonth, String experityYear) {
		System.out.println("this method complete the form of credit card and press in the button next.");
		waitForAnExplicitElement(body_form_editfield_cardnumber);
		sendKeysToLocator(body_form_editfield_cardnumber, creditCardNumber);
		sendKeysToLocator(body_form_editfield_name, personName);
		sendKeysToLocator(body_form_editfield_cvccode, cvcNumber);
		sendKeysToLocator(body_form_select_experity_month, experityMonth);
		sendKeysToLocator(body_form_select_experity_year, experityYear);
		clickJSx2(body_form_button_continue);
	}

}
