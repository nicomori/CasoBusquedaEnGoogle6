 package com.smartfrog.steps.backend;

import com.smartfrog.framework.ParentScenario;

import cucumber.api.java.en.Given;

/**
 * @author nicolasmori
 *
 */
public class BackendSteps extends ParentScenario {

	@Given("example test backend")
	public void makeClickInTheLogsinBustton() {
		System.out.println("this is an example of backend testing");
		backendCalls.backendServices();
	}

}