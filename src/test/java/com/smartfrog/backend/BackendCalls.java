package com.smartfrog.backend;

import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

public class BackendCalls extends ParentPage {

	/**
	 * @param driver
	 */
	public BackendCalls(WebDriver driver) {
		super(driver);
	}

	UserRelayCustomerCare userRelayCustomerCare = new UserRelayCustomerCare();

	public void backendServices() {
		System.out.println(userRelayCustomerCare.createMobilcomUser());
	}

}
