package com.smartfrog.pageobject.web.partners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this class represent a the values and the content of the page with this url 
//https://www.sf-dev1.com/de-de/medion/

public class MedionHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public MedionHomePage(WebDriver driver) {
		super(driver);
	}

	// Section WebElements
	private By header_logo_image = By.xpath("//*[@class='promotion-logo']");
	private By header_button_shop = By.xpath("//*[@href='/de-de/shop/products']");
	
	
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
	 * This method verify the button shop of the partner and return true or false in case this is not displayed
	 * 
	 * @return boolean
	 */
	public boolean verifyButtonShopPartner() {
		System.out.println("Starting to verify if the button shop of the parther is displayed");
		return verifyIfisDisplayedX2(header_button_shop);
	}
}
