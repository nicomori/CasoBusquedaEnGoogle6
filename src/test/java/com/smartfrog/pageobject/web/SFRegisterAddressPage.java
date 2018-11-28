package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: 
// https://www.smartfrog.com/de-de/shop/userdetails
public class SFRegisterAddressPage extends ParentPage {

	public SFRegisterAddressPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_form_select_salutation = By.xpath("//form/select");
	private By body_form_editfield_name = By.xpath("//form/input");
	private By body_form_editfield_lastname = By.xpath("//form/input[2]");
	private By body_form_editfield_sign = By.xpath("//form/input[3]");
	private By body_form_editfield_address = By.xpath("//form/div/input");
	private By body_form_editfield_address_num = By.xpath("//form/div/input[2]");
	private By body_form_editfield_postalcode = By.xpath("//form/div[2]/input");
	private By body_form_editfield_city = By.xpath("//form/div[2]/input[2]");
	private By body_form_editfield_phone = By.cssSelector("body > div.app-container > section > div:nth-child(2) > div > div > form > div:nth-child(7) > input");
	
	private By body_secondform_select_salutation = By.xpath("(//form/select)[2]");
	private By body_secondform_editfield_name = By.xpath("((//form)[2]/input)[1]");
	private By body_secondform_editfield_lastname = By.xpath("((//form)[2]/input)[2]");
	private By body_secondform_editfield_sign = By.xpath("((//form)[2]/input)[3]");
	private By body_secondform_editfield_address = By.xpath("(//form)[2]/div/input");
	private By body_secondform_editfield_address_num = By.xpath("(//form)[2]/div/input[2]");
	private By body_secondform_editfield_postalcode = By.xpath("(//form)[2]/div[2]/input");
	private By body_secondform_editfield_city = By.xpath("(//form)[2]/div[2]/input[2]");
	private By body_secondform_editfield_phone = By.xpath("(//form)[2]/input[last()]");
	
	private By body_form_button_continue = By.xpath("//form/parent::*/button");
	private By body_form_checkbox_add_other_address = By.xpath("//input[@type='checkbox']");

	// methods sections

	/**
	 * This methods verifies the page by checking the field of the phone number, since 
	 * I believe this field is quite seldom and probably unique in its css-selector
	 * @return true if the page is the expected page
	 * @return false if the phone number field couldn't get detected and we I therefore assume the page isn't the right page
	 * */
	public boolean verifyPage()
	{
		System.out.println("SFRegisterAddressPage:verifyPage: Starting to verify the page");
		waitLongForAnExplicitElement(body_form_editfield_phone);
		if(driver.findElement(body_form_editfield_phone).isDisplayed())
		{
			System.out.println("Page verified! - SFRegisterAddressPage:verifyPage()");
			return true;
		}
		else 
		{
			System.out.println("Address registration page couldn't be verified! - SFRegisterAddressPage:verifyPage()");
			return false;
		}
	}
	
	/**
	 * this method complete the form will all the mandatories fields and make click
	 * in the button next.
	 * 
	 * @param salutationOption
	 * @param name
	 * @param lastName
	 * @param sign
	 * @param street
	 * @param streetNumber
	 * @param postalCode
	 * @param city
	 * @param phoneNumber
	 */
	public void completeFormAddress(String salutationOption, String name, String lastName, String sign, String street,
			String streetNumber, String postalCode, String city, String phoneNumber) {
		System.out.println("this method complete the form with all the mandatories fields.");
		waitForAnExplicitElement(body_form_select_salutation);
		sendKeysToLocator(body_form_select_salutation, salutationOption);
		sendKeysToLocator(body_form_editfield_name, name);
		sendKeysToLocator(body_form_editfield_lastname, lastName);
		sendKeysToLocator(body_form_editfield_sign, sign);
		sendKeysToLocator(body_form_editfield_address, street);
		sendKeysToLocator(body_form_editfield_address_num, streetNumber);
		sendKeysToLocator(body_form_editfield_postalcode, postalCode);
		sendKeysToLocator(body_form_editfield_city, city);
		sendKeysToLocator(body_form_editfield_phone, phoneNumber);
		waitSleepingTheTread(500);
		clickJSx2(body_form_button_continue);
		waitSleepingTheTread(2000);
	}

	/**
	 * this method complete the form will all the mandatories fields.
	 * 
	 * @param salutationOption
	 * @param name
	 * @param lastName
	 * @param sign
	 * @param street
	 * @param streetNumber
	 * @param postalCode
	 * @param city
	 * @param phoneNumber
	 */
	public void completeFormAddressWithoutMakeClickInNext(String salutationOption, String name, String lastName,
			String sign, String street, String streetNumber, String postalCode, String city, String phoneNumber) {
		System.out.println("this method complete the form with all the mandatories fields.");
		waitForAnExplicitElement(body_form_select_salutation);
		waitForAnExplicitElement(body_form_select_salutation);
		sendKeysToLocator(body_form_select_salutation, salutationOption);
		sendKeysToLocator(body_form_editfield_name, name);
		sendKeysToLocator(body_form_editfield_lastname, lastName);
		sendKeysToLocator(body_form_editfield_sign, sign);
		sendKeysToLocator(body_form_editfield_address, street);
		sendKeysToLocator(body_form_editfield_address_num, streetNumber);
		sendKeysToLocator(body_form_editfield_postalcode, postalCode);
		sendKeysToLocator(body_form_editfield_city, city);
		sendKeysToLocator(body_form_editfield_phone, phoneNumber);
		waitSleepingTheTread(500);
	}

	/**
	 * This method select the checkbox of add other address.
	 * 
	 */
	public void selectCheckboxOtherAddress() {
		System.out.println("Selecting the checkbox to add a new address.");
		waitForAnExplicitElement(body_form_checkbox_add_other_address);
		clickJSx2(body_form_checkbox_add_other_address);
	}
	
	/**
	 * this method complete the second form.
	 * 
	 * @param salutationOption
	 * @param name
	 * @param lastName
	 * @param sign
	 * @param street
	 * @param streetNumber
	 * @param postalCode
	 * @param city
	 * @param phoneNumber
	 */
	public void completeSecondFormAddressWithoutMakeClickInNext(String salutationOption, String name, String lastName,
			String sign, String street, String streetNumber, String postalCode, String city, String phoneNumber) {
		System.out.println("this method complete the form with all the mandatories fields.");
		waitForAnExplicitElement(body_secondform_select_salutation);
		sendKeysToLocator(body_secondform_select_salutation, salutationOption);
		sendKeysToLocator(body_secondform_editfield_name, name);
		sendKeysToLocator(body_secondform_editfield_lastname, lastName);
		sendKeysToLocator(body_secondform_editfield_sign, sign);
		sendKeysToLocator(body_secondform_editfield_address, street);
		sendKeysToLocator(body_secondform_editfield_address_num, streetNumber);
		sendKeysToLocator(body_secondform_editfield_postalcode, postalCode);
		sendKeysToLocator(body_secondform_editfield_city, city);
		sendKeysToLocator(body_secondform_editfield_phone, phoneNumber);
		waitSleepingTheTread(500);
	}
	
	/**
	 * This method make click in next.
	 * 
	 */
	public void makeClickInNext() {
		System.out.println("making click in the button next in the address registration page.");
		waitSleepingTheTread(40000);
		waitParameterTimeForAnExplicitElement(body_form_button_continue, 800);
		clickJSx2(body_form_button_continue);
		waitSleepingTheTread(3000);
	}
}
