package com.smartfrog.steps.web;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.Then;

/**
 * @author nicolasmori
 *
 */
public class SFMyAccountSteps extends StepsHelper {

	@Then("select the link of last orders")
	public void pressButtonShopInTheHeaderBar() {
		sfMyAccountPage.clickOnTheLinkLastOrders();
	}

	@Then("access to the last invoices")
	public void makeClickInTheLastInvoices() {
		sfMyAccountPage.makeClickInTheLastInvoices();
	}

	@Then("verify the date of the first invoice")
	public void verifyTheDateOfTheFirstInvoice() {
		System.out.println("Starting to compare this current date: "+sfGenericPage.getCurrentDate()+", whit this content of date in the invoice: "+sfMyAccountPage.returnDateOfTheFirstInvoice());
		Assert.assertTrue(sfMyAccountPage.returnDateOfTheFirstInvoice().contains(sfGenericPage.getCurrentDate()));
	}

	@Then("verify the month of the first invoice")
	public void verifyTheMonthOfTheFirstInvoice() {
		System.out.println("Starting to compare this current month: "+sfGenericPage.getCurrentMonth()+", whit this content of date in the invoice: "+sfMyAccountPage.returnDateOfTheFirstInvoice());
		Assert.assertTrue(sfMyAccountPage.returnDateOfTheFirstInvoice().contains(sfGenericPage.getCurrentMonth()));
	}

	@Then("verify the year of the first invoice")
	public void verifyTheYearOfTheFirstInvoice() {
		System.out.println("Starting to compare this current year: "+sfGenericPage.getCurrentYear()+", whit this content of date in the invoice: "+sfMyAccountPage.returnDateOfTheFirstInvoice());
		Assert.assertTrue(sfMyAccountPage.returnDateOfTheFirstInvoice().contains(sfGenericPage.getCurrentYear()));
	}

	@Then("verify the total amount of the first invoice, and compare with this amount: \"([^\"]*)\"")
	public void verifyTheAmountOfTheFirstInvoice(String amount) {
		System.out.println("Starting to compare this total amount: "+amount+", whit this content of the value in the invoice: "+sfMyAccountPage.returnTotalValueOfTheFirstInvoice());
		Assert.assertTrue(sfMyAccountPage.returnTotalValueOfTheFirstInvoice().contains(amount));
	}
}