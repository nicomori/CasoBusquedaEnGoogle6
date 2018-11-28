package com.smartfrog.pageobject.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;
public class SFRegisterAddressCorrectionPage extends ParentPage{
	
	private By address_selection = By.className("sk-address-correction__diff");
	private By header = By.xpath("/html/body/div[3]/section/div[2]/section/h4");
	private By proposal = By.xpath("/html/body/div[3]/section/div[2]/section/section/label[1]/div/p");
	private By proposedAddress = By.xpath("/html/body/div[3]/section/div[2]/section/section/label[1]/div");
	private By usersInput = By.xpath("/html/body/div[3]/section/div[2]/section/section/label[2]/div/p");
	private By usersAddress= By.xpath("/html/body/div[3]/section/div[2]/section/section/label[2]/div");
	
	public SFRegisterAddressCorrectionPage(WebDriver driver)
	{
		super(driver);
	}
	
	/**
	 * This method verifies the Arvato address page by making an address correction. Important: If there is not bolt text, that 
	 * corrects the address the entire page won't be identified!
	 * */
	public boolean verifyPage()
	{
		waitForAnExplicitElement(address_selection);
		if(driver.findElement(address_selection).isDisplayed())
		{
			System.out.println("Arvato address correction page verified! - SFRegisterAddressCorrectionPage:verifypage()");
			return true;
		}
		else
		{
			System.out.println("Error! Coulnd't verify Arvato address correction! - SFRegisterAddressCorrectionPage:verifypage()");
			return false;
			
		}
	}
	/**
	 * This method verifies the test data being displayed on the page.
	 * It does it by selecting a 2 specific elements from the input string
	 * In case you vary the array length
	 * */
	public boolean detailsAreTheSame(List<String> addressDetails)
	{
		waitForAnExplicitElement(header);
		String headerString = driver.findElement(header).getText();
		String proposalText = driver.findElement(proposal).getText();
		String proposedAddressText = driver.findElement(proposedAddress).getText();
		String usersInputText = driver.findElement(usersInput).getText();
		String usersAddressText = driver.findElement(usersAddress).getText();
		//We split the array to leave all the input titles like "name", "proposedAddress", etc
		addressDetails = addressDetails.subList(addressDetails.size()/2,addressDetails.size());
		
		for(String details : addressDetails)
		{
			//We compare both ways because sometimes the input text is longer
			//and sometimes the selected web element
			if(!(details.contains(headerString)||headerString.contains(details))		
			&&!(details.contains(proposalText)||proposalText.contains(details))
			&&!(details.contains(proposedAddressText)||proposedAddressText.contains(details))
			&&!(details.contains(usersInputText)||usersInputText.contains(details))
			&&!(details.contains(usersAddressText)||usersAddressText.contains(details)))
			{
				System.out.println("Error! "+details+" hasn't been found!  - SFRegisterAddressCorrection:detailsAreTheSame()");
				return false;
			}
		}
		System.out.println("Success: All  elements have been identified!  - SFRegisterAddressCorrection:detailsAreTheSame()");
		return true;
	}
}
