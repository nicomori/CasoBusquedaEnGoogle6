package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class SofortPage extends ParentPage {

	/**
	 * @param driver
	 */
	public SofortPage(WebDriver driver) {
		super(driver);
	}

	//## LOCATORS SECTION
	//first page
	private By body_editfield_kontonummer = By.xpath("//input[contains(@name,'LOGINNAME')]");
	private By body_editfield_pin = By.xpath("(//input[contains(@name,'USER_PIN')])[2]");
	private By body_button_continue_firstpage = By.xpath("//button");
	
	//second page
	private By body_radiobutton_1 = By.xpath("(//input[contains(@name,'sender_account_number_technical')])[1]");
	private By body_button_continue_secondpage = By.xpath("//button");
	
	//last page
	private By body_editfield_tan = By.xpath("(//input[contains(@name,'tan')])[2]");
	private By body_checkbox_terms = By.xpath("//input[@type='checkbox']");
	private By body_button_continue_lastpage = By.xpath("//button");
	
	
	//## METHODS SECTION
	//first page
	/**
	 * This method verify if we are located correctly in the fist page of the sofort payment method.
	 * 
	 * @return boolean condition if this page is displayed correctly
	 */
	public boolean iAmInTheSofortFirstPage() {
		System.out.println("Starting to verify if we are in the first page of sofort payment method.");
		waitForAnExplicitElement(body_editfield_kontonummer);
		return verifyIfisDisplayedX2(body_editfield_kontonummer);
	}
	
	/**
	 * This method make the login in the sofort payment method site.
	 * 
	 * @param kontonummer
	 * @param pin
	 */
	public void makeTheLoginInSofort(String kontonummer, String pin) {
		System.out.println("Starting to make the success login");
		waitForAnExplicitElement(body_editfield_kontonummer);
		sendKeysToLocator(body_editfield_kontonummer, kontonummer);
		sendKeysToLocator(body_editfield_pin, pin);
		clickJSx2(body_button_continue_firstpage);
	}
	
	//second page
	/**
	 * This method verify if we are located correctly in the fist page of the sofort payment method.
	 * 
	 * @return boolean condition if this page is displayed correctly
	 */
	public boolean iAmInTheSofortSecondPage() {
		System.out.println("Starting to verify if we are in the first page of sofort payment method.");
		waitForAnExplicitElement(body_radiobutton_1);
		return verifyIfisDisplayedX2(body_radiobutton_1);
	}
	
	/**
	 * This method select the first radiobutton in the list of accounts and press in the button continue.
	 */
	public void selectFirstAccountAndContinue() {
		System.out.println("Starting to select the second radiobutton and make click in continue");
		waitForAnExplicitElement(body_radiobutton_1);
		clickJSx2(body_radiobutton_1);
		clickJSx2(body_button_continue_secondpage);
	}
	
	//last page
	/**
	 * This method verify if we are located correctly in the fist page of the sofort payment method.
	 * 
	 * @return boolean condition if this page is displayed correctly
	 */
	public boolean iAmInTheSofortLastPage() {
		System.out.println("Starting to verify if we are in the last page of sofort payment method.");
		waitForAnExplicitElement(body_editfield_tan);
		return verifyIfisDisplayedX2(body_editfield_tan);
	}
	
	/**
	 * This method send the value TAN to the site, and press in the checkbox terms and make click in continue.
	 * 
	 * @param tan
	 */
	public void setTanAndMakeClickInContinue(String tan) {
		System.out.println("Starting to select the first radiobutton and make click in continue");
		waitForAnExplicitElement(body_editfield_tan);
		sendKeysToLocator(body_editfield_tan, tan);
		clickJSx2(body_checkbox_terms);
		clickJSx2(body_button_continue_lastpage);
	}
}
