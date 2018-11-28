package com.smartfrog.pageobject.web;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class SFGenericPage extends ParentPage {

	public SFGenericPage(WebDriver driver) {
		super(driver);
	}

	// locators sections

	// methods sections
	/**
	 * This method receive a list to validate all the elements inside appear
	 * correctly displayed in the web
	 * 
	 * @param list
	 *            of strings
	 */
	@SuppressWarnings("unused")
	public boolean verifyAListOfElementsDisaplyedCorrectly(List<List<String>> listOfStringsToVerify) {
		System.out.println("Starting to verify if the content of the list is correctly displayed in the web.");
		waitSleepingTheTread(3000);
		for (List<String> dataTableToVerify : listOfStringsToVerify) {
			for (String stringInside : dataTableToVerify) {
				if (genericVerifyIfSomeTextExist(stringInside)) {
					System.out.println("This text to verify the String: " + stringInside);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * this method make click in the symbol declared in the feature file.
	 * 
	 */
	public void genericPageMakeClickInSomeButtonContainsSomeText(String stringInTheElement) {
		genericClickByButtonContainsSomeText(stringInTheElement);
	}

	/**
	 * this method verify if the label is correctly displayed.
	 *
	 * @param someTextToVerify
	 * @return boolean
	 */
	public boolean verifyIfSomeTextAppearInTheWeb(String someTextToVerify) {
		System.out.println("this method verify if this text appear in the web: " + someTextToVerify);
		return genericVerifyIfSomeTextExist(someTextToVerify);
	}

	/**
	 * this method verify if the title contains some text
	 *
	 * @param someTextToVerify
	 * @return boolean
	 */
	public boolean verifyIfSomeTextAppearInTheTitle(String someTextToVerify) {
		System.out.println("this method verify if this text appear in the TITLE of the web: " + someTextToVerify);
		return genericVerifyIfSomeTextAppearInTheTitle(someTextToVerify);
	}

	/**
	 * this method verify if the title contains some text
	 *
	 * @param someTextToVerify
	 * @return boolean
	 */
	public boolean verifyIfSomeTextAppearWithAnExclusiveClass(String className,
			List<List<String>> listOfStringsToVerify) {
		System.out
				.println("this method verify if this class appear " + className + ", with some text appear in the web");
		genericVerifyIfAnExclusiveClassAppearWithAListOfText(className, listOfStringsToVerify);
		return true;
	}

	/**
	 * this method verify if the title contains some text
	 *
	 */
	public void thisMethodGenerateAWaiter(int someNumberToWait) {
		waitSleepingTheTread(someNumberToWait);
	}
	
	/**
	 * this method return the current date.
	 * 
	 * @return String
	 */
	public String getCurrentDate() {
		return getActualDay();
	}
	
	/**
	 * this method return the current month.
	 * 
	 * @return String
	 */
	public String getCurrentMonth() {
		return getActualMonth();
	}
	
	/**
	 * this method return the current year.
	 * 
	 * @return String
	 */
	public String getCurrentYear() {
		return getActualYear();
	}
}
