package com.smartfrog.pageobject.web.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class GmailHomePage extends ParentPage {

	/**
	 * @param driver
	 */
	public GmailHomePage(WebDriver driver) {
		super(driver);
	}

	private By RECEIVED_EMAIL_ROWS = By.xpath("((//table)[5]/tbody/tr/td[6]/div/div)[1]");
	private By EMAIL_RECEIVER = By.xpath("//span[contains(@email,'gmail.com')]");
	private By EMAIL_RECEIVER_NEW_EMAIL = By.xpath("//td[8]");
	private By GOOGLE_LOGO = By.xpath("//a[@href='#inbox']");
	private By SELECT_ALL_CHECKBOX = By.xpath("//div[@role='button']//span[@role='checkbox']");
	private By BAR_TRASH_BUTTON = By.xpath("(//div[@role='button' and contains(@style,'user-select: none;')])[6]");

	/**
	 * this method make click in the checkbox select all.
	 */
	public void selectAllElements() {
		System.out.println("Starting to make click in the icon select all.");
		clickJSx2(GOOGLE_LOGO);
		clickJSx2(SELECT_ALL_CHECKBOX);
	}

	/**
	 * this method make click in the icon Trash.
	 */
	public void clickInIconDeleteAll() {
		System.out.println("Making click in the icon trash.");
		clickJSx2(BAR_TRASH_BUTTON);
	}

	/**
	 * this method is going to wait until an specific email to some specific
	 * receiver arrive.
	 * 
	 * @param String
	 *            with the receiver email address.
	 */
	public void waitForAnEmailWithSpecificReceiverAndAccess(String receiverEmailAddress) {
		boolean theCorrectEmailIsHere = false;
		int trying = 0;

		System.out.println(
				"Waiting for the reception of the email with the receiver email equal to, " + receiverEmailAddress);
		waitSleepingTheTread(2000);

		do {
			System.out.println("Verify if I can see a email.");
			try {
				if (verifyIfisDisplayedX2(RECEIVED_EMAIL_ROWS)) {
					System.out.println("Verify if the email is the receiver email. making click in the email row.");
					// inside of the email
					click(RECEIVED_EMAIL_ROWS);
					System.out.println("In the email body we are going to check the receiver.");
					System.out.println("We are looking for this email receiver: " + receiverEmailAddress + "#");
					String emailFinded = getAttributeFromLocator(EMAIL_RECEIVER, "data-hovercard-id");

					System.out.println("And we find in the new email this address: " + emailFinded + "#");

					if (emailFinded.contains(receiverEmailAddress)) {
						System.out.println("We find the correct email and we are making click in the email.");
						clickJSx2(EMAIL_RECEIVER_NEW_EMAIL);
						theCorrectEmailIsHere = true;
						System.out.println("We have the access to the email.");
					} else {
						System.out.println(
								"An email is here, but not with the correct receiver. Deleting all the emails in the folder");
						try {
							click(GOOGLE_LOGO);
						} catch (Exception e) {
							click(GOOGLE_LOGO);
						}
						selectAllElements();
						clickInIconDeleteAll();
					}
				} else {
					if (trying < 18) {
						System.out.println("We are waiting 30 sec until the correct email appear");
						waitSleepingTheTread(20000);
						refreshBrowser();
						waitSleepingTheTread(10000);

						By buttonYesGmailSecurityQuestions = By.xpath("//*[contains(text(),'Sí')]");

						if (verifyIfisDisplayed(buttonYesGmailSecurityQuestions)) {
							click(buttonYesGmailSecurityQuestions);
						}

						trying++;
					} else {
						System.out.println("We try more of 40 times to receive the emails, in 20 minutes.");
						return;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("STATUS OF THE VARIABLE THECORRECTEMAILISHERE = " + theCorrectEmailIsHere);
		} while (theCorrectEmailIsHere != true);
	}
}