package com.smartfrog.steps.web;

import java.util.List;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SFShopProductSteps extends StepsHelper {

	@Then("I see the product page displayed in the language \"([^\"]*)\"")
	public void verifyLanguage(String language)
	{
		Assert.assertTrue(sfShopProductsPage.verifyLanguage(language), "Language "+language+" couln't get verified");
	}
	
	@Then("I am on shop register page")
	public void verifyShopRegisterPage()
	{
		Assert.assertTrue(sfRegisterSecondPage.verifyContainerClassName(),"Error! We don't seem to see the input mask of the registration page!");
		Assert.assertTrue(sfRegisterSecondPage.verifyRegistrationPageEditfieldEmail(), "Error! We don't seem to see the email input fields");
	}
	
	@Then("I am on shopping cart page")
	public void verifyWeAreInTheCorrectSite() {
		Assert.assertTrue(sfShopProductsPage.verifyProductPage());
	}
	
	@Then("I am on shopping product page")
	public void verifyWeAreInTheCorrectSiteRepeated() {
		Assert.assertTrue(sfShopProductsPage.verifyProductPage());
	}
	
	@When("^I am select \"([^\"]*)\" country$")
	public void iAmSelectCountry(String country) {
		sfHhomePageWeb.selectCountry(country);
	}

	@Then("I click to buy \"([^\"]*)\"$")
	public void iClickToBuy(String productName) {
		sfShopProductsPage.choseProductByName(productName);
	}

	@Then("I am on cart page")
	public void verifyIfButtonShopAppear() {
		Assert.assertTrue(sfHeaderPage.verifyIfButtonShopIsDisaplayed());
	}
	
	@When("click to checkout on cart page")
	public void makeClickInTheButtonCheckOut() {
		sfShopProductsPage.makeClickInTheButtonCheckOut();
	}

	@Then("I can see \"([^\"]*)\" products on shop product page")
	public void verifyNumberOfProducts(String numbers) {
		Assert.assertTrue(sfShopProductsPage.verifyProductNumbers(numbers));
	}

	@And("I can see product \"([^\"]*)\" on shop product page")
	public void checkProductDetails(String productD) {
		Assert.assertTrue(sfShopProductsPage.verifyProductOnProductPage(productD));
	}

	@And("I can see products on shop product page")
	public void checkProductsDetailsTable(DataTable productDetails) {
		List<List<String>> data = productDetails.raw();
		Assert.assertTrue(sfShopProductsPage.verifyProductDetailsOnProductPage(data));
	}

	@When("^I enter coupon-code generated for shop cart page$")
	public void enterTheCouponCodeGenerated() {
		partnerCartPage.setTheVoucherValueAndPressInTheButtonRedeem(codeToRedeemed);
	}

	@When("^I enter coupon-code \"(.*)\" on shop cart page$")
	public void enterTheCouponCodeLikeParameter(String cupponCode) {
		partnerCartPage.setTheVoucherValueAndPressInTheButtonRedeem(cupponCode);
	}

	@And("^Product and delivery should be free$")
	public void verifyProductAndDeliveryAreZero() {
		Assert.assertTrue(partnerCartPage.verifyTheValueSubtotalIsInZero());
		Assert.assertTrue(partnerCartPage.verifyTheValueDeliveryCostIsInZero());
	}

	@Then("I am on \"(.*)\" shopping cart page")
	public void verifyIAmInTheCartPage(String somePartnerText) {
		Assert.assertTrue(partnerCartPage.verifyIfSomePartnerTextAppearCorrectly(somePartnerText));
		Assert.assertTrue(partnerCartPage.verifyIfTheMainTextExist());
	}

	@When("I click button remove product on shop cart page")
	public void removeProduct() {
		partnerCartPage.clickOnRemoveProduct();
	}

	@Then("I can see message \"([^\"]*)\" on shop cart page")
	public void cartMessage(String message) {
		Assert.assertTrue(partnerCartPage.emptyCartMessage(message));
	}

	@And("I click on button \"([^\"]*)\" on shop cart page")
	public void clickOnButtonName(String buttonName) {
		partnerCartPage.clickOnButtonByText(buttonName);
	}
	
	@When("I click on button \"(.*)\" on shop cart webpage")
	public void clickInTheButtonCheckout(String somePartnerText) {
		partnerCartPage.clickOnTheCheckOutButton();
	}
	
	@And("I can see \"([^\"]*)\" with quantity \"([^\"]*)\" and \"([^\"]*)\" in the cart page")
	public void verifyProductQuantity(String productName, String quantity, String productPrice) {
		Assert.assertTrue(partnerCartPage.checkProductQuantity(productName, quantity),
				"appear a problem at the momento to verify the product name and quantity.");
		Assert.assertTrue(partnerCartPage.checkProductPrice(productName, productPrice),
				"appear a problem at the momento to verify the product name and price.");
	}

	@And("I see product \"([^\"]*)\" with quantity \"([^\"]*)\" on cart page")
	public void verifyProductQuantityWithoutValue(String productName, String quantity) {
		Assert.assertTrue(partnerCartPage.checkProductQuantity(productName, quantity));
	}

	@And("the total price \"([^\"]*)\" is displayed on the page")
	public void verifyTotalPrice(String totalPrice) {
		Assert.assertTrue(partnerCartPage.getTotalPrice().contains(totalPrice),
				"Appear a problem at the moment to verify the total. We expect see this value inside: " + totalPrice
						+ ", and we can see in the website this value " + partnerCartPage.getTotalPrice());
	}

	@When("^I change quantity to \"([^\"]*)\" on shop cart page$")
	public void iChangeQuantityToOnShopCartPage(String quantity) {
		sfShopProductsPage.changeQuantityOfProductTo(quantity);
	}

	@And("^total price data displayed on shop cart page$")
	public void totalPriceDataDisplayedOnShopCartPage(DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		System.out.println("Starting to validate the value total");
		Assert.assertTrue(sfGenericPage.verifyAListOfElementsDisaplyedCorrectly(data));
	}

	@Then("I can see voucher item with text \"([^\"]*)\" and price \"([^\"]*)\" on shop cart page")
	public void verifyTheProductAndPrice(String productName, String productPrice) {
		Assert.assertTrue(partnerCartPage.checkProductPrice(productName, productPrice),
				"appear a problem at the moment to verify the product name and price.");
	}
}
