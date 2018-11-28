package com.smartfrog.steps.web;

import java.util.List;

import org.testng.Assert;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;

public class SFProductDetailsSteps extends StepsHelper {

	@And("I can see Product Price Element is displayed with correct data")
	public void producPriceVerificator(DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		Assert.assertTrue(sfGenericPage.verifyAListOfElementsDisaplyedCorrectly(data),
				"Appear a problem at the moment to verify a text displayed.");
	}

	@And("I see product details on cart page")
	public void producPriceVeriddficator(DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		Assert.assertTrue(sfGenericPage.verifyAListOfElementsDisaplyedCorrectly(data),
				"Appear a problem at the moment to verify a text displayed.");
	}
}
