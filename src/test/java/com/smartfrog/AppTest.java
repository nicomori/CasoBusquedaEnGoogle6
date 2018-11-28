package com.smartfrog;

import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Automations for Smartfrog.
 */
@CucumberOptions(plugin = { "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json",
		"junit:target/surefire-reports/cucumber-junit.xml" }, features = "features", tags = "@regression", glue = {
				"com.smartfrog.steps" })
public class AppTest extends AbstractTestNGCucumberTests {
	
	@Parameters({ "parallelStatus" })
	public AppTest(String parallelStatus) {
		System.out.println("Reading the parallel status");
		System.out.println(parallelStatus);
	}
}
