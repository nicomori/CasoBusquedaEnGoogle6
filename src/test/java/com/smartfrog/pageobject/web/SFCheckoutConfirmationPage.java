package com.smartfrog.pageobject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the confirmation of the purchase is completed, an example of that is this: https://www.sf-dev1.com/de-de/shop/success?checkout=3378b6dd-f8d1-4a0f-8680-c3494cb14f97
public class SFCheckoutConfirmationPage extends ParentPage {
	public SFCheckoutConfirmationPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_title_confirmation = By.xpath("//h1[@id='banner-title']");
	private By body_subtitle_confirmation = By.xpath("//*[@id='order-confirmation']");
	private By body_button_cameradesc = By.xpath("(//button)[1]/following-sibling::a");
	
	

	// methods sections
	/**
	 * this method make click in the camera description button.
	 * 
	 */
	public void iMakeClickInTheButtonToCameraDescription() {
		System.out.println("Starting to make click in the camera description.");
		waitLongForAnExplicitElement(body_button_cameradesc);
		clickJSx2(body_button_cameradesc);
	}

	/**
	 * this method verify if we are in the confirmation purchase page.
	 * 
	 * @return boolean.
	 */
	public boolean iAmInTheConfirmationPurcharsePage() {
		System.out.println("Starting to verify if we are in the confirmation purchase page.");
		waitLongForAnExplicitElement(body_title_confirmation);
		return verifyIfisDisplayedX2(body_title_confirmation);
	}
	
	/**
	 * this method verify if we can see correctly the title
	 * 
	 * @return boolean.
	 */
	public boolean verifyIfTheTitleAppearCorrectly() {
		System.out.println("Starting to verify if we can see the title correctly.");
		waitLongForAnExplicitElement(body_title_confirmation);
		return verifyIfisDisplayedX2(body_title_confirmation);
	}
	
	/**
	 * this method verify if we can see correctly the subtitle
	 * 
	 * @return boolean.
	 */
	public boolean verifyIfTheSubtitleAppearCorrectly() {
		System.out.println("Starting to verify if we can see the subtitle correctly.");
		waitLongForAnExplicitElement(body_subtitle_confirmation);
		return verifyIfisDisplayedX2(body_subtitle_confirmation);
	}
}
