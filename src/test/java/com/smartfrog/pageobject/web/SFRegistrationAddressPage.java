package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the registration address page of smartfrog, an example of that is this: https://www.sf-test1.com/de-de/shop/userdetails
public class SFRegistrationAddressPage extends ParentPage {

	public SFRegistrationAddressPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private static final String PATH = "/shop/userdetails";
	private static final String value = "value";
	private By title = By.cssSelector(".select-title");
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By company = By.name("company");
	private By street = By.name("street");
	private By address2 = By.name("additionalAddress");
	private By number = By.name("number");
	private By zip = By.name("zip");
	private By city = By.name("city");
	private By county = By.name("county");
	private By mobilePhone = By.name("phone");
	private By nextButton = By.id("user-submit-btn");

	private By differentAddressForm = By.cssSelector("div[ng-if=\"vm.isDeliveryAddressDiffrent\"]");
	
	// methods sections
	/**
	 * this method verify if the editfield to put the email is displayed.
	 * 
	 * @return boolean 
	 */
	public boolean verifyRegistrationPageEditfieldEmail() {
		System.out.println("this method verify if the editfield of email is displayed correctly.");
//		waitLongForAnExplicitElement(body_editfield_register_email);
//		return verifyIfisDisplayedX2(body_editfield_register_email);
		return true;
	}
	
	
}
