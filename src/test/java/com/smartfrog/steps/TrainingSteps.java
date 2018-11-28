package com.smartfrog.steps;

import cucumber.api.java.en.And;

/**
 * @author nicolasmori
 *
 */
public class TrainingSteps extends StepsHelper {

	@And("training 111111")
	public void training1112121212121222() {
		trainingPage.loginFacebook("snik_21@hotmail.com", "7586ABC4610def$$@@!!");
		
	}
	
	@And("training 222222")
	public void training11121212121222() {
		trainingPage.postSomethingInFacebook("pepe");
		
	}
	
	@And("click buy button")
	public void training_buy_button() {
		trainingPage.clickBuyButton();
		
	}

}