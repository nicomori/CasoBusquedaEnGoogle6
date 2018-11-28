package com.smartfrog.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this page represent the page of my account
//https://app.sf-dev1.com/de-de/account/overview
public class TrainingPage extends ParentPage {

	public TrainingPage(WebDriver driver) {
		super(driver);
	}

	// locators sections
	private By body_editfield_username = By.xpath("//*[@data-testid='royal_email']");
	private By body_editfield_password = By.xpath("//*[@data-testid='royal_pass']");
	private By body_button_login = By.xpath("//*[@data-testid='royal_login_button']");

	private By body_editfield_post = By.xpath("//*[@id=\"js_8w\"]/div[1]/div/div[1]/div[2]/div/div/div");
	private By body_editfield_post2 = By.xpath("//*[@id=\"js_8w\"]/div[1]/div/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div");
	private By body_button_post = By.xpath("//*[@id=\"js_8w\"]/div[2]/div[3]/div[2]/span/button");

	private By buy_button = By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div/a[1]");
	
	private By coupon_field = By.xpath("/html/body/div[3]/div/div/div[2]/div/section[3]/div/section[1]/div[1]/input");
	// methods sections
	/**
	 * this method make login
	 */
	public void loginFacebook(String emailFacebook, String password) {
		System.out.println("Starting to make login.");
		waitForAnExplicitElement(body_editfield_username);
		sendKeysToLocator(body_editfield_username, emailFacebook);
		sendKeysToLocator(body_editfield_password, password);
		clickJSx2(body_button_login);
	}
	
	/**
	 * This method makes a post
	 * @param text - the text you want to post
	 */
	public void postSomethingInFacebook(String text) {
		System.out.println("Starting to make post.");
		waitForAnExplicitElement(body_editfield_post);
		clickJSx2(body_button_post);
		sendKeysToLocator(body_editfield_post2, text);
		clickJSx2(body_button_post);
	}
	
	
	
	/**
	 * This method clicks the buy button on the main page
	 */
	public void clickBuyButton() {
		System.out.println("Click buy button");
		waitForAnExplicitElement(buy_button);
		clickJSx2(buy_button);
		waitForAnExplicitElement(coupon_field);
		clickJSx2(coupon_field);
		sendKeysToLocator(coupon_field, "aaaaaaaaaaaaaaa");
		waitSleepingTheTread(5555555);
		
		}
	
	
}
