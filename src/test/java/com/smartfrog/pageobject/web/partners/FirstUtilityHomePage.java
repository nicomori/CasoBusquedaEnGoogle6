package com.smartfrog.pageobject.web.partners;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smartfrog.framework.ParentPage;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

//this class represent a the values and the content of the page with this url 
//https://www.sf-dev1.com/en-gb/first-utility

public class FirstUtilityHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public FirstUtilityHomePage(WebDriver driver) {
		super(driver);
	}

	private By body_button_claim = By.xpath("(//*[contains(text(),'Claim now')])[1]");
	private static final By PROMO_TEXTS = By
			.cssSelector("div.element3.enbw-vip-promo-section div.columns div.description");
	private static final By BADGE_SELECTOR = By.cssSelector("div.first-utility-banner");
	private By header_button_cart_icon = By.xpath("//*[@pid='header_button_cart_icon']");
	
	/**
	 * 
	 */
	public void makeClickInTheButtonClaimNow() {
		System.out.println("Making click in the button claim now button");
		waitSleepingTheTread(3333);
		clickX2(body_button_claim);
		waitSleepingTheTread(3333);
	}

	/**
	 * @param promoTextsTable
	 */
	public void verifyPromoSectionData(List<String> promoTextsTable) {
		List<WebElement> promoElements = driver.findElements(PROMO_TEXTS);
		Set<String> promoTexts = new HashSet<String>();

		for (WebElement promoElement : promoElements) {
			String innerText = promoElement.getText();
			String text = innerText.replace("\n", " ").trim();
			promoTexts.add(text);
		}

		boolean allTextsPresent = promoTexts.containsAll(promoTextsTable);
		boolean noExtraTexts = promoTextsTable.containsAll(promoTexts);

		Assert.assertTrue("Not all texts are on the page", allTextsPresent);
		Assert.assertTrue("There are extra texts on the page", noExtraTexts);
	}

	/**
	 * @param badgeAmount
	 */
	public void verifyFirstUtilityBadge(int badgeAmount) {
		List<WebElement> elements = driver.findElements(BADGE_SELECTOR);
		Assert.assertTrue(elements.size() == badgeAmount);
		for (WebElement element : elements) {
			element.isDisplayed();
		}
	}
	
	
	
	/**
	 * this method validate if you can see the button cart in the homepage.
	 * 
	 * @return true in case the we can see correctly the button cart in the homepage.
	 */
	public boolean verifyIconCart() {
		return verifyIfisDisplayedX2(header_button_cart_icon);
	}
	
}
