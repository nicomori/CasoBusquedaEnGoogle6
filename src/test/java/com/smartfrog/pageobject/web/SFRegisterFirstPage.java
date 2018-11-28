package com.smartfrog.pageobject.web;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: 
// https://www.smartfrog.com/de-de/shop/login?next=%2Fde-de%2Fshop%2Fuserdetails
public class SFRegisterFirstPage extends ParentPage {

	public SFRegisterFirstPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_editfield_login_email = By.xpath("//*[contains(@pid,'login_email')]");
	@SuppressWarnings("unused")
	private By body_radiobutton_newuser = By.xpath("//*[contains(@pid,'login_new_user')]/input");
	@SuppressWarnings("unused")
	private By body_radiobutton_existing_user = By.xpath("//*[contains(@pid,'login_existant_user')]/input");
	@SuppressWarnings("unused")
	private By body_editfield_password = By.xpath("//*[contains(@pid,'input_password')]");
	private By body_button_continue = By.xpath("//*[contains(@pid,'login_action')]");
	private By body_button_register = By.xpath("//*[contains(@pid,'register_action')]");


	// methods sections
	/**
	 * this method verify if the editfield to put the email.
	 * 
	 * @return boolean
	 */
	public boolean verifyEditfieldEmail() {
		System.out.println("this method verify if the editfield of email is displayed correctly.");
		waitForAnExplicitElement(body_editfield_login_email);
		return verifyIfisDisplayedX2(body_editfield_login_email);
	}

	/**
	 * this method make click in the continue button.
	 */
	public void makeClickInTheButtonContinue() {
		System.out.println("make click in continue.");
		clickJSx2(body_button_continue);
		waitSleepingTheTread(2000);
	}
	
	
	/**
	 * This method clicks on the "Register Now" button (like the upper method "makeClickInTheButtonContinue")
	 * but tries to recognize the button by its name and compares it with the 
	 * @param buttonName
	 * */
	public void	clickOnRegisterButtonInSpecificLanguage(String buttonName)
	{
		System.out.println("Click on register with name: "+buttonName+" - SFRegisterFirstPage:clickOnRegisterButtonInSpecificLanguage()");
		if(driver.getPageSource().contains(buttonName))
		{
			click(body_button_register);
			System.out.println(" - giving 2 seconds time to finish registration! - SFRegisterFirstPage:clickOnRegisterButtonInSpecificLanguage()");
			waitSleepingTheTread(2000);
		}
		else
		{
			System.out.println("Error! Registration button with name "+buttonName+" hasn't been found! - SFRegisterFirstPage:clickOnRegisterButtonInSpecificLanguage()");
		}
		
		
		
	}

	/**
	 * this method make click in the existing user radiobutton.
	 */
	public void selectRadioButtonUserExist() {
		System.out.println("Starting to select the radiobutton of existing user.");
		waitForAnExplicitElement(body_radiobutton_existing_user);
		clickJSx2(body_radiobutton_existing_user);
		waitSleepingTheTread(2000);
	}

	/**
	 * this method make login in the shop process with an existing user.
	 *
	 * @param username
	 * @param password
	 */
	public void makeLoginWithParametersInTheShopProcess(String username, String password) {
		System.out.println("Starting to make login in the process of shop products, with an existing user and pass.");
		waitForAnExplicitElement(body_editfield_login_email);
		sendKeysToLocator(body_editfield_login_email, username);
		sendKeysToLocator(body_editfield_password, password);
	}
}
