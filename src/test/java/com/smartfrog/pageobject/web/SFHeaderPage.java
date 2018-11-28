package com.smartfrog.pageobject.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.smartfrog.framework.ParentPage;

//this page represent the header of all the pages of smartfrog where we can find the elements like the button shop etc
public class SFHeaderPage extends ParentPage {

	public SFHeaderPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By iconQuantity = By.xpath("//*[contains(@class,'cart__counter')]");
	private By header_button_shop = By.xpath("//*[contains(@href,'shop/products')]");
	private By header_editfield_usermail = By.xpath("//*[@name='user']");
	private By header_editfield_password = By.xpath("//*[@name='pass']");
	private By header_button_login = By.xpath("(//*[@type='submit'])[1]");
	
	private By countrySelector = By.xpath("//*[@id=\"dLabel\"]");
	private By selectedCountry = By.xpath("(//div/div/p)[1]");
	private By countryList = By.xpath("//*[@id=\"country-selector-new\"]/li");
	// methods sections
	/**
	 * @return
	 */
	public String getQuantityNearCartIcon() {
		System.out.println("Starting to get the elements number in the icon of the cart.");
		waitSleepingTheTread(2000);
		return getTextByLocator(iconQuantity);
	}

	/**
	 * @return
	 */
	public void pressButtonShop() {
		System.out.println("Starting to press the button Shop");
		waitForAnExplicitElement(header_button_shop);
		clickX2(header_button_shop);
	}

	/**
	 * This method make the login from the header.
	 * 
	 * @param username
	 * @param password
	 */
	public void makeLoginFromTheHeader(String username, String password) {
		System.out
				.println("makeing login with the header, with this user: " + username + " and this pass: " + password);
		waitForAnExplicitElement(header_editfield_usermail);
		sendKeysToLocator(header_editfield_usermail, username);
		sendKeysToLocator(header_editfield_password, password);
		clickJSx2(header_button_login);
	}
	
	/**
	 * this method verify if the button shop appear.
	 * 
	 * @return boolean
	 */
	public boolean verifyTheHeaderShopButton() {
		System.out.println("Starting to verify if the button shop appear correctly in the header");
		waitForAnExplicitElement(header_button_shop);
		return verifyIfisDisplayed(header_button_shop);
	}
	
	/**
	 * this method verifies the visibility of the shop button
	 * 
	 * @return boolean
	 */
	public boolean verifyIfButtonShopIsDisaplayed() {
		System.out.println("Starting to verify if the button shop appear correctly in the header");
		waitForAnExplicitElement(header_button_shop);
		return verifyIfisDisplayed(header_button_shop);
	}
	
	/**
	 * This method verifies, whether the list of countries is visible when I click on the country selector
	 * 
	 * @return boolean
	 */
	public boolean verifyVisibilityOfCountryList()
	{
		System.out.println("Starting to verify the visibility of the list of countries in the header");
		List<WebElement> countries = driver.findElements(countryList);
		System.out.println("========================================================================");
		int i=1;
		for(WebElement country: countries)
		{
			if(country.isDisplayed()==false)
				return false;

			if(i%3==0)
				System.out.println(country.getText());
			else
			{
				System.out.format("%-20s",country.getText());
			}
			i++;
		}
		System.out.println("\n------------------------------------------------------------------------");
		System.out.println(countries.size()+" countries were found");
		System.out.println("========================================================================");
		return true;
	}
	
	public void clickOnCountrySelector()
	{
		System.out.println("Starting to click on country selector");
		click(countrySelector);
	}
	
	public boolean verifyCountry(String country)
	{
		if(getTextByLocator(selectedCountry).equals(country))
			return true;
		else
			return false;
	}
	public boolean verifyLanguageURL(String url_fragment)
	{
		String current_url = driver.getCurrentUrl();
		if(current_url.contains(url_fragment))
			return true;
		else 
			return false;
	}
	
}
