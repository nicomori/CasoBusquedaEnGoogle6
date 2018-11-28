package com.smartfrog.pageobject.web.partners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this class represent a the values and the content of the page with this url 
//https://www.sf-dev1.com/de-de/enbw-geschenk

public class EnbwHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public EnbwHomePage(WebDriver driver) {
		super(driver);
	}

	private By promo_section_enbw = By.xpath("(//*[@class='enbw-vip-price'])[1]");

	/**
	 * this method validate if promo section is displayed
	 * 
	 * @return true in case the we can see correctly the promo section
	 */
	public boolean verifyPromoSectionIsDisplayed() {
		return verifyIfisDisplayedX2(promo_section_enbw);
	}
}
