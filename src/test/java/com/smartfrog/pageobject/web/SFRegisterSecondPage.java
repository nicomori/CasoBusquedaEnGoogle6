package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: https://www.sf-dev1.com/de-de/shop/register
public class SFRegisterSecondPage extends ParentPage {

	public SFRegisterSecondPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_editfield_register_email = By.xpath("//*[contains(@pid,'register_email')]");
	private By body_editfield_register_repeat_email = By.xpath("//*[contains(@pid,'register_repeat_email')]");
	private By body_editfield_password = By.xpath("//*[contains(@pid,'input_password')]");
	private By body_select_country = By.xpath("//*[contains(@pid,'register_country_selector')]");
	private By body_button_continue = By.xpath("//*[contains(@pid,'register_action')]");
	private By input_container_class = By.xpath("//*[contains(@class,'sk-form-container')]");
	// methods sections
	/**
	 * this method verify if the editfield to put the email is displayed.
	 * 
	 * @return boolean 
	 */
	public boolean verifyRegistrationPageEditfieldEmail() {
		System.out.println("SFRegisterSecondPage:verifyRegistrationPageEditfieldEmail: Verifying the visibility of the first email field.");
		waitLongForAnExplicitElement(body_editfield_register_email);
		if(verifyIfisDisplayed(body_editfield_register_email))
		{
			System.out.println("SFRegisterSecondPage:verifyRegistrationPageEditfieldEmail: First email field visible.");
			if(verifyIfisDisplayed(body_editfield_register_repeat_email))
			{
				System.out.println("SFRegisterSecondPage:verifyRegistrationPageEditfieldEmail: Second email field also visible.");
				return true;
			}
			else
			{
				System.out.println("SFRegisterSecondPage:verifyRegistrationPageEditfieldEmail: Second email field NOT visible.");
				return false;
			}
		}
		else
		{
			System.out.println("SFRegisterSecondPage:verifyRegistrationPageEditfieldEmail: First email field NOT visible.");
			return false;
		}
	}
	
	public boolean verifyContainerClassName()
	{
		System.out.println("SFRegisterSecondPage:verifyContainerClassName: Verifying the input container");
		waitForAnExplicitElement(input_container_class);
		try {
			driver.findElement(input_container_class);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("SFRegisterFirstPage:verifySFRegisterFirstPage: Page couldn't get verified");
			return false;
		}
		return true;
	}
	
	/**
	 * this method send the email to the first and the second field.
	 * 
	 * @param String with the email address.
	 */
	public void sendEmailToTheFirstFieldAndTheSecond(String email) {
		System.out.println("this method set the email "+email+" in editfield, and in the second.");
		sendKeysToLocator(body_editfield_register_email, email);	
		sendKeysToLocator(body_editfield_register_repeat_email, email);
	}
	
	
	
	/**
	 * this method send the email to the first and the second field.
	 * 
	 * @param String with the email address.
	 */
	public String sendGenericEmailToTheFirstFieldAndTheSecond() {
		String genericEmail = "test.user+"+System.currentTimeMillis()+"@smartfrog.com";
		System.out.println("this method set the email "+genericEmail+" in editfield, and in the second.");
		sendKeysToLocator(body_editfield_register_email, genericEmail);	
		sendKeysToLocator(body_editfield_register_repeat_email, genericEmail);
		return genericEmail;
	}
	
	/**
	 * this method send the password to the correct field.
	 * 
	 * @param String with the password.
	 */
	public void sendPassword(String password) {
		System.out.println("this method set the password "+password+" in editfield.");
		sendKeysToLocator(body_editfield_password, password);	
	}
	
	/**
	 * this method send the default password to the correct field.
	 * 
	 * @param String with the password.
	 */
	public void sendDefaultPassword() {
		System.out.println("this method set the default password in editfield.");
		sendKeysToLocator(body_editfield_password, "Test123!!!");	
	}
}
