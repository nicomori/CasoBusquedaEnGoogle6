package com.smartfrog.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

/**
 * this class represent the first page of the android app, where we can see the
 * login button
 * 
 * @author nicolasmori
 */
public class LoginPage extends ParentPage {

	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@WebElementLocator(androidElementType = "id", androidElementValue = "com.inovotecs.smartfrog.dev:id/recover_password_button", iosElementType = "ios", iosElementValue = "//XCUIElementTypeButton[@name='Forgot your password?']")
	public By getButtonForgetPassword() {
		return getLocator("getButtonForgetPassword");
	}
	
	@WebElementLocator(androidElementType = "id", androidElementValue = "com.inovotecs.smartfrog.dev:id/email_text", iosElementType = "xpath", iosElementValue = "//XCUIElementTypeApplication[@name='sf Dev']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField\n")
	public By getEditfieldEmail() {
		return getLocator("getEditfieldEmail");
	}

	@WebElementLocator(androidElementType = "id", androidElementValue = "com.inovotecs.smartfrog.dev:id/password_text", iosElementType = "xpath", iosElementValue = "//XCUIElementTypeApplication[@name='sf Dev']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeSecureTextField\n")
	public By getEditdddddd() {
		return getLocator("getEditdddddd");
	}

	@WebElementLocator(androidElementType = "id", androidElementValue = "com.inovotecs.smartfrog.dev:id/login_button", iosElementType = "xpath", iosElementValue = "(//XCUIElementTypeButton[@name='Log in'])[2]")
	public By getButtonLogin() {
		return getLocator("getButtonLogin");
	}

	@WebElementLocator(androidElementType = "id", androidElementValue = "com.inovotecs.smartfrog.dev:id/register_button", iosElementType = "xpath", iosElementValue = "//XCUIElementTypeButton[@name='No account yet? » Sign up now']")
	public By getButtonSignUp() {
		return getLocator("getButtonSignUp");
	}

	@WebElementLocator(androidElementType = "id", androidElementValue = "android:id/action_bar_title", iosElementType = "xpath", iosElementValue = "//XCUIElementTypeButton[@name='icon nav back light']")
	public By getButtonBack() {
		return getLocator("getButtonBack");
	}

	@WebElementLocator(androidElementType = "id", androidElementValue = "com.inovotecs.smartfrog.dev:id/imageButton", iosElementType = "", iosElementValue = "")
	public By getPopUpButtonOk() {
		return getLocator("getPopUpButtonOk");
	}

	/**
	 * This method make a success login into the mobile app. Require for that a
	 * correct user activated.
	 * 
	 * @param String
	 *            with a username
	 * @param String
	 *            with a password
	 */
	public void makeASuccessLogin(String username, String password) {
		System.out.println(
				"Starting to make a success Login with the user: " + username + " and the password: " + password + ".");
		waitForAnExplicitElement(getEditfieldEmail());
		sendKeysToLocator(getEditfieldEmail(), username);
		sendKeysToLocator(getEditdddddd(), password);
		click(getButtonLogin());
	}

	/**
	 * This method set the username into the field username
	 * 
	 * @param username
	 */
	public void fillTheFieldUsername(String username) {
		System.out.println("Starting to send the data to the app with the username: " + username);
		sendKeysToLocator(getEditfieldEmail(), username);
	}

	/**
	 * This method set the password into the field password
	 * 
	 * @param password
	 */
	public void fillTheFieldPassword(String password) {
		System.out.println("Starting to send the data to the app with the password: " + password);
		sendKeysToLocator(getEditdddddd(), password);
	}

	/**
	 * this method make the click into the button login
	 */
	public void makeClickIntoTheButtonLogin() {
		System.out.println("Starting to make click in the login button");
		click(getButtonLogin());
	}

	/**
	 * This method make click into the link Forget password in the welcome page.
	 */
	public void makeClickIntoForgotPass() {
		System.out.println("Starting to make click into Forget Password Link");
		click(getButtonForgetPassword());
	}

	/**
	 * This method make click into the button sign up.
	 */
	public void makeClickInSignUp() {
		System.out.println("Starting to make click into the sign up button");
		click(getButtonSignUp());
	}

}
