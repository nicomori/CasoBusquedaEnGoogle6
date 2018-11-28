package com.smartfrog.pageobject.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the shop page of smartfrog, an example of that is this: https://www.sf-dev1.com/de-de/shop/products
public class SFShopProductsPage extends ParentPage {

	public SFShopProductsPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private static final String TEXT_COMPONENT_BUTTON = "//*[contains(text(),'%s')]/following-sibling::div['%s']//button";
	private static final String TEXT_COMPONENT_SEARCH = "//*[contains(text(),'%s')]";
	private By body_button_href = By.xpath("//*[contains(@href,'/shop/product/')]");
	private By products = By.xpath("//*[contains(@class,'fk-col sk-products-container__product sm4 xs12')]");
	private By productQuantity = By.xpath("//*[@pid='product_quantity']/select");
	private By body_value_total = By.xpath("//*[@pid='body_value_total']");
	private By body_button_checkout = By.xpath("//*[@pid='body_button_checkout']");
	
	private By german_language_web_element = By.xpath("//*[contains(@href,'datenschutz')]");
	private By english_language_web_element = By.xpath("//*[contains(@href,'privacy')]");
	
	// methods sections
	/**
	 * This method make click in the checkout button
	 */
	public void makeClickInTheButtonCheckOut() {
		System.out.println("Starting to make click in the checkout button");
		waitForAnExplicitElement(body_button_checkout);
		clickJSx2(body_button_checkout);
	}

	public boolean verifyLanguage(String language)
	{
		System.out.println("Starting to verify language "+language);
		switch(language.toLowerCase()) 
		{
			case "english":
				if(driver.findElement(english_language_web_element)!=null)
				{
					return true;
				}
				else 
				{
					System.out.println("Error: "+language+" language web element missing. Language couldn't get verified");
					return false;
				}

			case "german": 
				if(driver.findElement(german_language_web_element)!=null)
				{
					return true;
				}
				else 
				{
					System.out.println("Error: "+language+" language web element missing. Language couldn't get verified");
					return false;
				}
			default: return false;
			
		}
			
	}
	
	/**
	 * @param quantity
	 */
	public void changeQuantityOfProductTo(String quantity) {
		selectOptionByString(productQuantity, quantity);
	}

	/**
	 * this method get the value of the total amout like an string and return that.
	 * 
	 * @return String with the total amout
	 */
	public String getTotalValue() {
		System.out.println("Starting to get the value in the total amount");
		return getTextByLocator(body_value_total);
	}

	/**
	 * this method make click in the button checkout.
	 * 
	 */
	public void clickInButtonCheckout() {
		System.out.println("Starting to make click in the button checkout");
		clickJSx2(body_button_checkout);
		waitSleepingTheTread(3000);
	}

	/**
	 * this method make click in the button buy depending of the product we select,
	 * this require like a parameter witch element we want buy, and whitch len
	 * 
	 * @param productName
	 */
	public void choseProductByName(String productName) {
		System.out.println(
				"Starting to make click in the button BUY in the product page, in the product name: " + productName);
		String index_3 = "3";
		String index_4 = "4";

		try {
			waitForAnExplicitElement(By.xpath(String.format(TEXT_COMPONENT_BUTTON, productName, index_3)));
			clickJSx2(By.xpath(String.format(TEXT_COMPONENT_BUTTON, productName, index_3)));
		} catch (Exception e) {
			waitForAnExplicitElement(By.xpath(String.format(TEXT_COMPONENT_BUTTON, productName, index_4)));
			clickJSx2(By.xpath(String.format(TEXT_COMPONENT_BUTTON, productName, index_4)));
		}

	}

	/**
	 * @return
	 */
	public Boolean verifyProductPage() {
		System.out.println("Starting to verify if product page exist correctly.");
		waitSleepingTheTread(3000);
		return verifyIfisDisplayed(body_button_href);
	}

	/**
	 * this method count the number of elements this require a parameter how many
	 * elements we expect
	 */
	
	public Boolean verifyProductNumbers(String numbers) {
		System.out.println("Starting to verify if numbers of products are correctly.");
		waitSleepingTheTread(1000);
		int count = countElements(products);
		String counter = Integer.toString(count);
		System.out.println(count+" products found");
		if (numbers.equals(counter)) {
			System.out.println(counter+" were expected. Successful!");
			return true;
		} else {
			System.out.println(counter+" were expected. Test failed!");
			return false;
		}
	}

	/**
	 * this method search a specific text
	 */
	public Boolean verifyProductOnProductPage(String productD) {
		System.out.println("Starting to verify if element is there:" + productD);
		By check = By.xpath(String.format(TEXT_COMPONENT_SEARCH, productD));
		waitLongForAnExplicitElement(check);
		return verifyIfisDisplayed(check);
	}

	/**
	 * this method search a specific text from a table
	 */
	public Boolean verifyProductDetailsOnProductPage(List<List<String>> test1) {
		boolean y;
		int z = 0;

		for (int i = 0; i < test1.size(); i++) {
			for (int x = 0; x < test1.get(i).size(); x++) {
				By check = By.xpath(String.format(TEXT_COMPONENT_SEARCH, test1.get(i).get(x)));
				y = verifyIfisDisplayed(check);
				if (y == false) {
					System.out.println("Text-Component is missing:" + test1.get(i).get(x));
					z++;
				}
			}
		}
		if (z == 0) {
			return true;
		} else {
			return false;
		}
	}
}
