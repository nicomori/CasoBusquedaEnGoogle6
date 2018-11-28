package com.smartfrog.pageobject.web.partners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this class represent a the values and the content of the page with this url 
//https://www.sf-dev1.com/de-de/medion/

public class MobilcomeHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public MobilcomeHomePage(WebDriver driver) {
		super(driver);
	}

	// Section WebElements
		private By MdLogo = By.cssSelector("div.logo-header.mdsf-logo");
		private By MdLoginForm = By.cssSelector("form[name=loginForm]");
		private By MdTitle = By.cssSelector("h2[class=\"headline text-primary text-center ng-binding\"]");
		private By MdForgotPassword = By.cssSelector("[class=\"text-primary ng-binding\"]");
		private By servicePageTitle = By.cssSelector("h1");

		// Section Methods
		public void MobilcomLogoItem() {
			verifyIfisDisplayedX2(MdLogo);
		}

		public void MobilcomLoginForm() {
			verifyIfisDisplayedX2(MdLoginForm);
		}

		public void verifyTextInTheTitle(String LoginTitle) {
			verifyIfSomeLocatorContainsSomeString(MdTitle, LoginTitle);
		}

		public void verifyTextInThePasswordLink(String PasswordLink) {
			verifyIfSomeLocatorContainsSomeString(MdForgotPassword, PasswordLink);
		}

		public void clickMobilcomFooterLinks(String linkText) {
			genericClickByText(linkText);
		}

		public boolean verifyContentInTheURL(String urlPart) {
			waitSleepingTheTread(3000);
			return genericVerifyIfSomeTextAppearInTheURL(urlPart);
		}
		
		public boolean verifyContentInTheTitle(String pageTitle) {
			waitSleepingTheTread(3000);
			return genericVerifyIfSomeTextAppearInTheTitle(pageTitle);
		}
		
		public void scrollDownToTheBottom() {
			scrollDown();
		}
}
