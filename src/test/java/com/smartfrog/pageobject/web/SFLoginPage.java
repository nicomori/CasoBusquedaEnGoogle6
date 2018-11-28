package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: https://www.sf-dev1.com/de-de/shop/login
public class SFLoginPage extends ParentPage {

	public SFLoginPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By shopbody_label_registration = By.xpath("//form/parent::section/h3");
	private By shopbody_editfield_email = By.xpath("//form[@name]//*[contains(@type,'email')]");
	private By shopbody_button_submit = By.xpath("//button[@type='submit']");

	// methods sections
	/**
	 * this method verify if the label is correctly displayed.
	 */
	public boolean shopVerifyIfTheMainTextExist() {
		System.out.println("this method verify if the title of the page appear correctly");
		waitForAnExplicitElement(shopbody_label_registration);
		return verifyIfisDisplayedX2(shopbody_label_registration);
	}

	/**
	 * this method send the data email to the email editfield.
	 * 
	 * @param String
	 *            with a email.
	 */
	public void shopFillTheEditFieldEmail(String stringToSend) {
		System.out.println("starting to send the value: " + stringToSend);
		sendKeysToLocator(shopbody_editfield_email, stringToSend);
	}

	/**
	 * making click in the button submit.
	 */
	public void shopClickInTheButtonSubmit(String textInTheButton) {
		System.out.println("Starting to make click in the button submit");
		waitSleepingTheTread(3000);
		genericClickByText(textInTheButton);
	}
}
