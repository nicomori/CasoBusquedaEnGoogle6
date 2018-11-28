package com.smartfrog.steps.web;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nicolasmori
 *
 */

public class SFHeaderSteps extends StepsHelper {

	@Then("I can see \"([^\"]*)\" quantity near cart icon on cart page")
	public void verifyInTheShopLoginWeAreInTheCorrectSite(String quantityNumber) {
		Assert.assertTrue(sfHeaderPage.getQuantityNearCartIcon().equals(quantityNumber),
				"Appear a problem to verify the correct value expected in the Cart Icon, we expect: " + quantityNumber
						+ " ,and we can see the current value is: " + sfHeaderPage.getQuantityNearCartIcon());
	}

	@Then("press the button shop in the header bar in the dashboard of the user logged")
	public void pressButtonShopInTheHeaderBar() {
		sfUserDashboardPage.pressButtonShop();
	}

	@And("Make click in the button Mein Konto")
	public void makingClickInTheButtonMeinKonto() {
		sfUserDashboardPage.clickOnMyAccount();
	}

	@Then("in the dashboard of the user change the lenguage to \"([^\"]*)\"")
	public void changeTheLenguageInTheDashboard(String lenguageToChange) {
		if (lenguageToChange.toLowerCase() == "english") {
			sfUserDashboardPage.selectLenguageEnglish();
		} else if (lenguageToChange.toLowerCase() == "german") {
			sfUserDashboardPage.selectLenguageGerman();
		} else {
			sfUserDashboardPage.selectLenguageGerman();
		}
	}

	@Then("Make login from the header, with this user \"([^\"]*)\" and this password \"([^\"]*)\"")
	public void makeLoginFromTheHeaderWithParameters(String username, String password) {
		sfHeaderPage.makeLoginFromTheHeader(username, password);
	}

	@And("I click on the shop button on the cart page")
	public void makeClickInTheShopButton() {
		sfHeaderPage.pressButtonShop();
	}
	
	@And("I can see the url part \"([^\"]*)\"")
	public void verifyURLPart(String url_part)
	{
		Assert.assertTrue(sfHeaderPage.verifyLanguageURL(url_part),url_part+" didn't get recognized");
	}

	@When("I click country selector")
	public void clickOnCountrySelector()
	{
		sfHeaderPage.clickOnCountrySelector();
	}
	
	@Then("I can see list of countries with country flags")
	public void verifyVisibilityOfCountryList()
	{
		Assert.assertTrue(sfHeaderPage.verifyVisibilityOfCountryList(),"Error: List of countries was not visible");
	}
	@And("I can see the country selector displaying \"([^\"]*)\"")
	public void verifyCurrentCountry(String expectedCountry)
	{
		Assert.assertTrue(sfHeaderPage.verifyCountry(expectedCountry),expectedCountry+" didn't get verified as a country");
	}
}