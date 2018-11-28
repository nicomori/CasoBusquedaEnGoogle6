package com.smartfrog.steps.common;

import java.lang.Thread;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.smartfrog.modelclass.TestRailTestCase;
import com.smartfrog.modelclass.TestRailTestCase2;
import com.smartfrog.steps.StepsHelper;
import com.smartfrog.util.WriteAndReadFiles;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends StepsHelper {
	private long hash = 0;

	@Given("I detect the enviroment to execute the test")
	public void startingEnv() {
		deviceSelector();
	}

	@And("verify if this data is displayed correctly in the website")
	public void verifyIfAListOfStringIsDisplayedCorrectly(DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		System.out.println("Starting to validate this data is displayed correctly in the site.");
		Assert.assertTrue(sfGenericPage.verifyAListOfElementsDisaplyedCorrectly(data));
	}

	@Given("I set a new enviroment to \"(.*)\"")
	public void changeEnv(String enviroment) {
		hash = driver.hashCode();
		if (hash > 1) {
			driver.quit();
			System.out.println("Driver closed!.");
		}
		defineNewPropertyEnviroment(enviroment);
		deviceSelector();
	}

	@Given("I access to the webapp \"([^\"]*)\"")
	public void accessToSomeWebAppWithExamples(String webapp) {
		accessToSomeSpecificUrl(webapp);
	}

	@When("I click shop button on \"(.*)?\" landing page")
	public void clickOnHeaderShopButton(String partnerName) {
		partnerLandingPage.clickOnShopButton();
	}

	@And("I make click in the login button")
	public void makeClickInTheLoginButton() {
		welcomePage.clickInTheButtonLogin();
	}

	@Given("^I am on \"([^\"]*)\" landing page$")
	public void accesingToLandingPage(String partnerLanding) {
		System.out.println("Starting to access to the landing page of " + partnerLanding);
		accessToTheUrlWithoutExamples(partnerLanding);
	}

	@Then("^Page opened in new tab has title \"([^\"]*)\" and URL is \"([^\"]*)\"$")
	public void pageOpenedInNewTabHasTitleAndUrlIs(String pageTitle, String pageUrl) {
		System.out.println("Starting to change the control to other tab");
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		try {
			driver.switchTo().window(tabs.get(1));
			System.out.println("Starting to compare the url of the page: " + driver.getCurrentUrl()
					+ " ,with this string: " + pageUrl);
			Assert.assertTrue(driver.getCurrentUrl().contains(pageUrl));
			System.out.println("Starting to compare the title of the page: " + driver.getTitle()
					+ " ,with this string: " + pageTitle);
			Assert.assertTrue(driver.getTitle().contains((pageTitle)));
		} finally {
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	@Then("^I pause")
	public void pauseTheTest()
	{
		System.out.println("And here we pause :) ");
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("CommonSteps:pauseTheTest: For some reason we can't pause");
			e.printStackTrace();
		}
	}
	
	@And("^Page has title \"([^\"]*)\" and URL is \"([^\"]*)\"$")
	public void pageHasTitleAndUrlIs(String pageTitle, String pageUrl) {
		if (partnerLandingPage.verifyIfSomeTextAppearInTheTitle(pageTitle)) {
			Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheTitle(pageTitle));
		} else {
			Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheTitleWithRefresh(pageTitle));
		}

		if (partnerLandingPage.verifyIfSomeTextAppearInTheUrl(pageUrl)) {
			Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheUrl(pageUrl));
		} else {
			Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheUrlWithRefresh(pageUrl));
		}
	}

	@Then("^verify the page opened")
	public void verifyTheHeaderLogoSF() {
		System.out.println("Starting to verify if the smartfrog logo is correctly displayed.");
		Assert.assertTrue(partnerLandingPage.verifyIfTheHeaderLogoIsDisplayed());
	}

	@And("I expect to see the landing page has co-branded header")
	public void verifyThecobrandedAppearCorrectly() {
		System.out.println("Starting to verify if the cobranding is working correctly");
		Assert.assertTrue(partnerLandingPage.verifyIfTheHeaderCoBrandedTextPromotionIsDisplayed());
	}

	@Then("I can see this text \"([^\"]*)\" displayed in the site")
	public void verifyIfSomeTextAppearDisplayedInTheWeb(String someTextToVerify) {
		System.out.println(
				"Starting to verify if this text: " + someTextToVerify + " appear correctly displayed in the web.");
		if (partnerLandingPage.verifyIfSomeTextAppearInTheSite(someTextToVerify)) {
			Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheSite(someTextToVerify));
		} else {
			Assert.assertTrue(partnerLandingPage.verifyIfSomeTextAppearInTheSiteWithRefresh(someTextToVerify));
		}
	}

	@Then("^verify if this text \"([^\"]*)\" appear correctly displayed in the page")
	public void verifyIfSomeTextAppearCorrectly(String someTextToVerify) {
		Assert.assertTrue(sfGenericPage.verifyIfSomeTextAppearInTheWeb(someTextToVerify));
	}

	@And("verify if this text \"([^\"]*)\" appear in the title")
	public void verifyThePageTitle(String someTextToVerifyInTheTitle) {
		Assert.assertTrue(sfGenericPage.verifyIfSomeTextAppearInTheTitle(someTextToVerifyInTheTitle));
	}

	@And("verify if this exclusive class \"([^\"]*)\", appear in the web with this Table Of Text")
	public void verifyThePageTitle(String classNameExclusive, DataTable listOfStringsToVerify) {
		List<List<String>> data = listOfStringsToVerify.raw();
		sfGenericPage.verifyIfSomeTextAppearWithAnExclusiveClass(classNameExclusive, data);
	}

	@When("I click on link with text \"(.*)?\"")
	public void iClickInSomeLinkWithAParameterText(String textToMakeClic) {
		partnerLandingPage.makeClickInALinkGEneric(textToMakeClic);
	}

	@Then("I click in the button back in the browser")
	public void iMakeClickInTheButtonBAck() {
		partnerLandingPage.makeClickInTheButtonBack();
	}

	@Then("I can see just shop button on \"(.*)?\" landing page")
	public void partnerHeaderShopButton(String partnerName) {
		Assert.assertTrue(partnerLandingPage.verifyIfTheButtonShopAppear());
	}

	@And("I need to wait this moments: \"(.*)?\"")
	public void waitTheTread(String timeToWAit) {
		sfGenericPage.thisMethodGenerateAWaiter(Integer.parseInt(timeToWAit));
	}

	@And("example of testing")
	public void monitoring() {
		// pageHelper.monitoringChangeView();
		// Assert.assertTrue(pageHelper.validateTheElementsPIDisPresent("header_text_partnet_offer"));

		pageHelper.validateTheElementsPIDisCliclable("footer_link_retail_stores");
		pageHelper.validateTheElementsPIDifThisElementReturnAText("header_text_partnet_offer");
	}

	@And("example of 2222222222")
	public void testRail() throws FileNotFoundException {

		List<String> preconditions = new ArrayList<String>();
		List<String> steps = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();

		List<String> contentFile = WriteAndReadFiles
				.readFileToArrayLinePerLine("/Users/nicolasmori/Documents/toCreateTheCsv.txt");
		List<TestRailTestCase> listaDeTestCases = new ArrayList<TestRailTestCase>();

		for (int i = 0; i < contentFile.size(); i++) {
			TestRailTestCase testCase = new TestRailTestCase();

			// is title?
			if (contentFile.get(i).contains("==@==")) {

				if (contentFile.get(i).contains("==@==")) {
					testCase.setTitle(contentFile.get(i).replaceAll("==@==", ""));
				}

				if (contentFile.get(i + 1).contains(";| Step")) {
					testCase.setSteps(contentFile.get(i + 1).replaceAll(";", "\n"));
				}

				try {
					if (contentFile.get(i + 2).contains(";| Expected Step")) {
						testCase.setResultExpected(contentFile.get(i + 2).replaceAll(";", "\n"));
					}
				} catch (Exception e) {
					System.out.println("Fail starting the generation the exepected steps.");
				}
			}

			if (testCase.getResultExpected() == null) {
				testCase.setResultExpected("| Expected Step 1: without result expected.");
			}

			if (testCase.getTitle() != null) {
				listaDeTestCases.add(testCase);
			}

		}

		String titleName = "Some example of test case";
		int templateId = 1;
		int type_id = 4;
		int priority_id = 1;
		String estimate = "48m";
		int milestone = 1;
		String refs = "3";

		pageHelper.interfaceTestRail(1, titleName, templateId, type_id, priority_id, estimate, milestone, refs,
				preconditions, steps, expected, listaDeTestCases);
	}

	@And("example of 33333333")
	public void testRail2() throws FileNotFoundException {

		String title = null;
		int stepNumber = 1;
		// String preconditions = null;
		List<String> steps = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		String pathOfTheFile = "/Users/nicolasmori/Documents/toCreateTheCsv.txt";

		System.out.println("Location of the source file: " + pathOfTheFile);
		List<String> contentFile = WriteAndReadFiles.readFileToArrayLinePerLine(pathOfTheFile);
		List<String> listToSendToWriteInToTheFile = new ArrayList<String>();
		List<TestRailTestCase2> listaDeTestCases = new ArrayList<TestRailTestCase2>();

		TestRailTestCase2 testCase = new TestRailTestCase2();

		boolean titleCompleted = false;

		for (int i = 0; i < contentFile.size(); i++) {

			// is title?
			if (contentFile.get(i).contains("@@TITLE@@")) {
				if (titleCompleted == true) {
					testCase.setSteps(steps);
					testCase.setResultExpected(expected);
					listaDeTestCases.add(testCase);

					testCase = new TestRailTestCase2();
					steps = new ArrayList<String>();
					expected = new ArrayList<String>();
				} else {
					titleCompleted = true;
				}

				String[] data = contentFile.get(i).split("@@PRECONDITIONS@@");

				testCase.setTitle(data[0].replaceAll("@@TITLE@@", "").replaceAll("'", ""));

				testCase.setPreconditions(data[1].replaceAll("@@PRECONDITIONS@@", ""));

				stepNumber = 1;
			}

			// is an step?
			if (contentFile.get(i).contains("@@TEST_STEP@@")) {
				String[] data2 = contentFile.get(i).split("@@RESULT_EXPECTED@@");

				steps.add(data2[0].replaceAll("@@TEST_STEP@@", "Step " + stepNumber + " :"));

				expected.add("Expected result " + stepNumber + " :" + data2[1]);
				stepNumber++;
			}
		}

		listToSendToWriteInToTheFile.add("Title,Preconditions,Steps,Expected Results\n");

		// to verify what we have in the list of objects.
		for (TestRailTestCase2 testCaseIteracion : listaDeTestCases) {

			// System.out.println(testCaseIteracion.getTitle());
			listToSendToWriteInToTheFile.add("\"" + testCaseIteracion.getTitle().replaceAll("\\n", "") + "\",");

			// System.out.println(testCaseIteracion.getPreconditions());

			listToSendToWriteInToTheFile.add("\"" + testCaseIteracion.getPreconditions().replaceAll("    ", "")
					.replaceAll("        ", "").replaceAll("  ", "").replaceAll("\\n", "")+ "\",");

			listToSendToWriteInToTheFile.add("\"");
			for (String stepsDentroDelTestCase : testCaseIteracion.getSteps()) {
				// System.out.println(stepsDentroDelTestCase);
				listToSendToWriteInToTheFile.add(stepsDentroDelTestCase + "\n");
			}
			listToSendToWriteInToTheFile.add("\",".replaceAll("\\n", "").replaceAll(" ", ""));

			listToSendToWriteInToTheFile.add("\"".replaceAll("\\n", "").replaceAll(" ", ""));
			for (String stepsDentroDelTestCase : testCaseIteracion.getResultExpected()) {
				// System.out.println(stepsDentroDelTestCase);
				listToSendToWriteInToTheFile.add(stepsDentroDelTestCase + "\n");
			}
			listToSendToWriteInToTheFile.add("\"\n");

		}

		try {
			WriteAndReadFiles.writerListOfStringToFile(listToSendToWriteInToTheFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@And("generate validations from file")
	public void createValidators() throws FileNotFoundException {
		
		String serviceToValidate = "GetQuote";
		String pathWithTheOriginFile = "/Users/nicolasmori/Documents/inputFile.txt";

		String title = null;
		int stepNumber = 1;
		// String preconditions = null;
		List<String> steps = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();

		System.out.println("Location of the source file: " + pathWithTheOriginFile);
		List<String> contentFile = WriteAndReadFiles.readFileToArrayLinePerLine(pathWithTheOriginFile);
		List<String> cleanList = new ArrayList<String>();
		
		
		// limpio las lineas dejando unicamente los valores 
		// ValGetList [Number] [Something_To_Validate] With [Other_Thing_To_Validate]
		System.out.println("Starting to make all the changes in the lines");
		for (int i = 0; i < contentFile.size(); i++) {
			
			System.out.println("Starting to work with the line number: "+i);
			System.out.println(contentFile.get(i));
			String[] data = contentFile.get(i).split("_");
			
			System.out.println("Split this line in this 4 parts: ");
			System.out.println("Section 0: "+data[0]);
			System.out.println("Section 1: "+data[1]);
			System.out.println("Section 2: "+data[2]);
			System.out.println("Section 3: "+data[3]);
			
			System.out.println("=========================================");
			
			
			
			String nameFirstVariable = data[1].substring(0,1).toLowerCase()+data[1].substring(1);
			String valueToCompare = data[3].replace("1", "").replace("(", "").replace(")", "").replace(";", "");
			
			
			cleanList.add("	String "+nameFirstVariable+"String = null;\n");
			cleanList.add("	//int "+nameFirstVariable+"Integer = 0;\n");
			cleanList.add("	//double "+nameFirstVariable+"Double = 0.0;\n");
			//line for getList:
			//cleanList.add(contentFile.get(i).replace("			assertsContent"+serviceToValidate+".set", "	if (validatorContent"+serviceToValidate+".get").replace("1", "").replace(";", " == 1) {\n"));
			//line for getQuote:
			cleanList.add(contentFile.get(i).replace("			assertsContent"+serviceToValidate+".set", "	if (assertsContent"+serviceToValidate+".get").replace("(1)", "()").replace(";", " == 1) {\n"));

			cleanList.add(contentFile.get(i).replace(")", "").replace("(", "").replace("		assertsContent"+serviceToValidate+".set", "").replaceAll("_", " ").replace("Val"+serviceToValidate, "		LOGGER.info(\"Val"+serviceToValidate).replace(";", "\");\n\n"));
			
			
			cleanList.add("		try {\n");
			cleanList.add("			String pathToFindTheElement_"+data[1]+" = \"\";\n");
			
			//line for getList:
			//cleanList.add("			"+nameFirstVariable+"String = body.path(pathToFindTheElement_"+data[1]+").toString();\n\n");
			//line for getQuote:
			cleanList.add("			"+nameFirstVariable+"String = bodyGetQuote.path(pathToFindTheElement_"+data[1]+").toString();\n");
			cleanList.add("			//"+nameFirstVariable+"Integer = Integer.parseInt("+nameFirstVariable+"String);\n");
			cleanList.add("			//"+nameFirstVariable+"Double = Double.parseDouble("+nameFirstVariable+"String);\n\n");
			cleanList.add("			LOGGER.info(\"The value "+data[1]+" = \"+"+nameFirstVariable+"String);\n\n");
			
			
			
			//lines for GetList
			//cleanList.add("			if ("+nameFirstVariable+"String == null) {\n");
			//cleanList.add("				LOGGER.info(\"The value "+data[2]+" = not exist, looking for other Hotel\");\n");
			//cleanList.add("				continue;\n");
			//cleanList.add("			}\n\n");
			
			cleanList.add("		} catch (Exception e) {\n");
			cleanList.add("			LOGGER.info(\"Appear a problem in return value Val"+serviceToValidate+" "+data[1]+"\");\n\n");
			
			//line for GetList
			//cleanList.add("			continue;\n");
			cleanList.add("		}\n\n");
			
			cleanList.add("		softAssert.assertTrue(true,\"Expected result Val"+serviceToValidate+ " "+ data[1] +" With "+valueToCompare+"\");\n");
			
			cleanList.add("	}");
			
			
			cleanList.add("\n\n\n");
		}
		
		

		try {
			WriteAndReadFiles.writerListOfStringToFileWithName(cleanList, "FileVersion1WithThingsToValidate");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Teardown Section
	@After
	public void afterMethod(Scenario scenario) {
		System.out.println("Test finished!, closing the driver");
		driver.quit();

		if (scenario.isFailed()) {

			System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");

		}
	}
}
