package com.smartfrog.steps.web;

import com.smartfrog.steps.StepsHelper;

import cucumber.api.java.en.And;

/**
 * @author nicolasmori
 *
 */
public class SFUserDashboardSteps extends StepsHelper {

	@And("In the user dashboard I close the popup")
	public void closeDashboardPopup() {
		sfUserDashboardPage.closePopUp();
	}

}