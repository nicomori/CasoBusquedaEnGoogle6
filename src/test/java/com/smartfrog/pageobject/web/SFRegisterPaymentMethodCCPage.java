package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;
import com.smartfrog.modelclass.CreditCardDetails;

//this page represent the shop page of smartfrog, an example of that is this: https://test.adyen.com/hpp/details.shtml?sessionValidity=2018-06-06T13%3A04Z&offset=0&shopperEmail=test.user%2B1528286583574%40smartfrog.com&paymentAmount=595&shipBeforeDate=2018-06-13&merchantSig=qTJJvdNuQHiOmmM4INQAGWT%2FueE%3D&merchantAccount=SmartfrogCOM&countryCode=DE&skinCode=jFn1LhN9&shopperLocale=de_DE&merchantReference=dev1_fc0b77bc-3e3b-449f-aad0-8ccee6f02437&currencyCode=EUR&recurringContract=RECURRING%2CONECLICK&shopperReference=8c1d7102-ed0a-41da-a0e8-4fd0e79cf2b1&shopperStatement=Kunden%20Nr.%20155869766%2C%20Bestellung%20v.%2006.06.18&brandCode=sepadirectdebit&
public class SFRegisterPaymentMethodCCPage extends ParentPage {

	public SFRegisterPaymentMethodCCPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private String PATH = "/";

	private By titleBarName = By.id("titlebarName");
	private By cardNumber = By.id("card.cardNumber");
	private By cardHolderName = By.id("card.cardHolderName");
	private By cvcCode = By.id("card.cvcCode");
	private By expiryMonth = By.id("card.expiryMonth");
	private By expiryYear = By.id("card.expiryYear");
	private By submitButton = By.cssSelector(".paySubmitcard");

	// methods sections

	/**
	 * this method complete the form sepa with the name of the person and the iban
	 * value and press the button continue.
	 * 
	 * @param String
	 *            person name
	 * @param String
	 *            iban value
	 */
	public void completeTheFormAndPressTheButtonNext(CreditCardDetails creditCardDetails) {
		System.out.println("this method complete the form credit card");
		waitForAnExplicitElement(cardNumber);
		sendKeysToLocator(cardNumber, creditCardDetails.getCardNumber());
		sendKeysToLocator(cardHolderName, creditCardDetails.getFullName());
		sendKeysToLocator(cvcCode, creditCardDetails.getCvv());
		sendKeysToLocator(expiryMonth, creditCardDetails.getMonth());
		sendKeysToLocator(expiryYear, creditCardDetails.getYear());
		clickJSx2(submitButton);
	}
	
	/**
	 * this method complete the value CVC in the credit card form.
	 * 
	 * @param String cvc code.
	 */
	public void completeTheCvcCodeAndPressContinue(String CvcCode) {
		System.out.println("this method complete the CVC code of the credit card.");
		waitForAnExplicitElement(cardNumber);
		sendKeysToLocator(cvcCode, CvcCode);
		clickJSx2(submitButton);
	}

}
