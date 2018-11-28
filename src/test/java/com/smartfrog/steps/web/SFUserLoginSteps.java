package com.smartfrog.steps.web;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

/**
 * @author nicolasmori
 *
 */
public class SFUserLoginSteps extends StepsHelper {

	@And("I am on the main website")
	public void verifyWeAreInTheCorrectSite() {
		Assert.assertTrue(sfHhomePageWeb.verifyIfTheMainTextExist());
	}
	
	@And("I am logged in as \"(.*)?\" with default password on shop page")
	public void makeACorrectLogin(String email) {
		sfHhomePageWeb.enterEmail(email);
		sfHhomePageWeb.enterPassword("Test123!!!");
		sfHhomePageWeb.makeClickInTheButtonLogin();
	}

	@Then("I enter email as \"(.*)?\" on the homepage")
	public void makeClickInTheLssogsinButton(String email) {
		sfHhomePageWeb.enterEmail(email);
	}

	@Then("I enter email as \"(.*)?\" on the shop")
	public void enterEmailInTheShop(String email) {
		sfHhomePageWeb.enterEmailShop(email);
	}

	@And("I enter password as \"(.*)?\" on the homepage")
	public void makeClickInTheLsogsinButton(String pass) {
		sfHhomePageWeb.enterPassword(pass);
	}

	@And("I enter password as \"(.*)?\" on the shop")
	public void enterPasswordInTheShop(String pass) {
		sfHhomePageWeb.enterPasswordShop(pass);
	}

	@And("I click login button page")
	public void makeClickInTheLogsinBustton() {
		sfHhomePageWeb.makeClickInTheButtonLogin();
	}

	@And("I click login button on the shop page")
	public void makeClickInTheShopLoginBustton() {
		sfHhomePageWeb.makeClickInTheShopButtonLogin();
	}

	@And("I click on the shop button on the mainpage")
	public void makeClickInTheShopButton(){
		sfHhomePageWeb.makeClickinTheButtonShop();
	}
}