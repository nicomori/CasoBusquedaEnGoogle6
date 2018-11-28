package com.smartfrog.steps.web;

import java.util.List;

import org.testng.Assert;

import com.smartfrog.backend.VideocloudAdminController;
import com.smartfrog.backend.VideocloudDevicesController;
import com.smartfrog.backend.VideocloudTokenGenerator;
import com.smartfrog.modelclass.Address2;
import com.smartfrog.modelclass.CreditCardDetails;
import com.smartfrog.pageobject.web.SFRegisterAddressPage;
import com.smartfrog.steps.StepsHelper;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nicolasmori
 *
 */
public class SFRegistrationSteps extends StepsHelper {

	private VideocloudDevicesController devicesController = new VideocloudDevicesController();
	private VideocloudTokenGenerator tokenController = new VideocloudTokenGenerator();
	private VideocloudAdminController adminController = new VideocloudAdminController();
	private String userEmail;
	private String cameraUUID;

	@Then("I am on shop payment page")
	public void verifyIfIAmInThePaymentMethodRegistrationPage() {
		Assert.assertTrue(sfRegisterPaymentMethodPage.verifyIfIAmInThePaymentPage());
	}

	@Then("I am on shop register first page")
	public void verifyWeAreInTheCorrectSite() {
		Assert.assertTrue(sfRegisterFirstPage.verifyEditfieldEmail());
	}
	
	@When("I am on shop user details page")
	public void verifyUserDetailPage()
	{
		Assert.assertTrue(sfRegisterAddressPage.verifyPage(), "Error! We are not on the shop user details page");
	}

	@When("click in the button continue to make the registration")
	public void inTheFirstRegistrationPageMakeClickInTheButtonContinue() {
		sfRegisterFirstPage.makeClickInTheButtonContinue();
	}
	
	@When("click on \"(.*?)\" on shop register page")
	public void registerInSpecificLanguage(String buttonName)
	{
		sfRegisterFirstPage.clickOnRegisterButtonInSpecificLanguage(buttonName);
	}
	
	@Then("In the registration payment method, make click in continue")
	public void inThePaymentSelectionScreenMakeClickInContinue() {
		sfRegisterPaymentMethodPage.makeClickInTheButtonContinue();
	}

	@When("I choose payment method \"(.*?)\" and click button \"(.*?)\"")
	public void selectThePaymentMethodInTheRegistrationFlow(String paymentMethod, String buttonName) {
		sfRegisterPaymentMethodPage.selectPaymentMethod(paymentMethod);
	}

	@And("^I enter payment details for 'Credit Card' and click 'Next'$")
	public void iEnterPaymentDetailsForCreditCardAndClickNext(List<CreditCardDetails> creditCardDetails) {
		for (CreditCardDetails creditCardDetails2 : creditCardDetails) {
			sfRegisterPaymentMethodCCPage.completeTheFormAndPressTheButtonNext(creditCardDetails2);
		}
	}
	
	@When("In the page of the credit card, set this code CVC \"(.*?)\" and press continue")
	public void inThePAgeOfTheCreditCardSetTheValueCvcCodeAndPressConitnue(String cvcCode) {
		sfRegisterPaymentMethodCCPage.completeTheCvcCodeAndPressContinue(cvcCode);
	}
	

	@When("I agree with terms and click 'Buy now'")
	public void agreeTheTermsAndPressInBuyNow() {
		sfRegisterSummaryPage.enableCheckOutAndMakeClicInTheButtonCheckout();
	}
	
	@When("I am on arvato address correction page")
	public void verifyArvatoAddressCorrectionPage()
	{
		Assert.assertTrue(sfRegisterAddressCorrectionPage.verifyPage(),"Error! Arvato address correction apge not recognized.");
	}

	@Then("I am on shop summary page")
	public void verifyIfWeAreInTheSummaryRegistrationPage() {
		sfRegisterSummaryPage.summaryVerifyIfTheButtontCheckoutExist();
	}

	@When("I enter email and repeat it as \"(.*?)\"")
	public void sendEmailToTheCorrectField(String emailAddress) {
		sfRegisterSecondPage.sendEmailToTheFirstFieldAndTheSecond(emailAddress);
	}

	@When("I enter email and repeat it as generic user")
	public void sendTheGenericUserToTheCorrectField() {
		genericEmail = sfRegisterSecondPage.sendGenericEmailToTheFirstFieldAndTheSecond();
	}
	
	@When("I set the current address \"(.*?)\" as generic email address")
	public void setTheCurrentMailAddressAsGlobalGeneric(String email)
	{
		genericEmail = email;
	}

	@And("enter default password on shop register page")
	public void setDefaultPassword() {
		sfRegisterSecondPage.sendDefaultPassword();
	}

	@And("^I set newly registered user as Test in Videocloud API$")
	public void iSetNewlyRegisteredUswerAsTestInVideocloudAPI() throws Throwable {
		System.out.println("SFRegistrationSteps:iSetNewlyRegisteredUswerAsTestInVideocloudAPI: "+genericEmail);
		String adminToken = tokenController.generateAdminUserToken();
		this.adminController.updateTestUserFlag(genericEmail, adminToken);
	}

	@And("^enter invoice address on shop user details page and click 'Next'$")
	public void enterInvoiceAddressOnShopUserDetailsPageAndClickNext(List<Address2> userAddressDetails) {
		for (Address2 user : userAddressDetails) {
			sfRegisterAddressPage.completeFormAddress(user.getSalutationOption(), user.getName(), user.getLastName(),
					user.getSign(), user.getStreet(), user.getStreetNumber(), user.getPostalCode(), user.getCity(),
					user.getPhoneNumber());
		}
	}
	
	@And("^I can see arvato address correction options for Invoice address$")
	public void checkArvatoAddressCorrection(List<String> addressDetails )
	{
		Assert.assertTrue(sfRegisterAddressCorrectionPage.detailsAreTheSame(addressDetails),"Error! The address correction couldn't get verified");
	} 

	@And("^enter invoice address on shop user details page without click next$")
	public void enterInvoiceAddressOnShopUserDetailsPage(List<Address2> userAddressDetails) {
		for (Address2 user : userAddressDetails) {
			sfRegisterAddressPage.completeFormAddressWithoutMakeClickInNext(user.getSalutationOption(), user.getName(),
					user.getLastName(), user.getSign(), user.getStreet(), user.getStreetNumber(), user.getPostalCode(),
					user.getCity(), user.getPhoneNumber());
		}
	}

	@And("select the checkbox of add a new address")
	public void addANewAddress() {
		sfRegisterAddressPage.selectCheckboxOtherAddress();
	}
	
	@And("in the registration address page, make click in next")
	public void makeClickInNext() {
		sfRegisterAddressPage.makeClickInNext();
	}

	@And("^I enter different delivery address on shop user details page$")
	public void completeSecondFormAddressWithoutMakeClickInNext(List<Address2> userAddressDetails2) {
		for (Address2 user2 : userAddressDetails2) {
			sfRegisterAddressPage.completeSecondFormAddressWithoutMakeClickInNext(user2.getSalutationOption(), user2.getName(),
					user2.getLastName(), user2.getSign(), user2.getStreet(), user2.getStreetNumber(), user2.getPostalCode(),
					user2.getCity(), user2.getPhoneNumber());
		}
	}

	@And("check invoice address on shop summary page")
	public void verifyInvoiceAddress(DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		System.out.println("Starting to validate this data is displayed correctly in the site.");
		Assert.assertTrue(sfRegisterSummaryPage.validateInvoiceAddress(data));
	}
	
	
	@And("check delivery address on shop summary page")
	public void verifyDeliveryAddress(DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		System.out.println("Starting to validate this data is displayed correctly in the site.");
		Assert.assertTrue(sfRegisterSummaryPage.validateDeliveryAddress(data));
	}
	
	@And("In the process to buy a product make the login with this user \"(.*?)\" and pass \"(.*?)\"")
	public void makeLoginInTheProcessToBuyAProduct(String username, String password) {
		sfRegisterFirstPage.makeLoginWithParametersInTheShopProcess(username, password);
	}
}