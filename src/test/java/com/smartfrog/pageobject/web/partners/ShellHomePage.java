package com.smartfrog.pageobject.web.partners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this class represent a the values and the content of the page with this url 
//https://shell.sf-dev1.com/de-de/

public class ShellHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public ShellHomePage(WebDriver driver) {
		super(driver);
	}

	// Section WebElements
	private By header_logo_image = By.xpath("//*[@src='/static/img/shell-logo.svg']");
	private By ShellZipcode = By.cssSelector("input[name=zipcode]");
	
	
	// Section Methods
	/**
	 * This method verify the logo of the partner and return true or false in case this is not displayed
	 * 
	 * @return boolean
	 */
	public boolean verifyLogoPartner() {
		System.out.println("Starting to verify if the logo of the parther is displayed");
		return verifyIfisDisplayedX2(header_logo_image);
	}
	
	/**
	 * This method verify the shell zipcode of the partner and return true or false in case this is not displayed
	 * 
	 * @return boolean
	 */
	public boolean verifyZipCodeFieldPartner() {
		System.out.println("Starting to verify if the zipcode edit field of the parther is displayed");
		return verifyIfisDisplayedX2(ShellZipcode);
	}
}
