package com.smartfrog.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.smartfrog.modelclass.TestRailTestCase;
import com.smartfrog.util.APIClient;

public class PageHelper {

	protected WebDriver driver;

	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}

	protected void changeOfTab(int tabToChange) {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public boolean validateTheElementsPIDisPresent(String somePidString) {
		System.out.println("Starting to verify if the PID with the name: " + somePidString + " is displayed correctly");
		return driver.findElement(By.xpath("//*[@pid='" + somePidString + "']")).isDisplayed();
	}

	public void validateTheElementsPIDisCliclable(String somePidString) {
		System.out.println("Starting to verify if the PID with the name: " + somePidString + " is clickable correctly");
		WebElement element = driver.findElement(By.xpath("//*[@pid='" + somePidString + "']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("Starting to wait a moment in the new url");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		driver.navigate().back();
		System.out.println("and we back.");
	}

	public boolean validateTheElementsPIDifThisElementReturnAText(String somePidString) {
		System.out.println("Starting to verify if the PID with the name: " + somePidString + " return a text");
		String text = driver.findElement(By.xpath("//*[@pid='" + somePidString + "']")).getText();
		if (text.length() > 0) {
			System.out.println("We find a String inside of the element, with this text: " + text);
			return true;
		} else {
			System.out.println("the element PID: " + somePidString + " dont have a string inside.");
			return false;
		}
	}

	public void interfaceTestRail(int sectionNumber, String titleName, int templateId, int type_id, int priority_id, String estimate,
			int milestone, String refs, List<String> preconditions, List<String> steps, List<String> expected,
			List<TestRailTestCase> listaDeTestCases) {

		System.out.println("Starting the interface with testrail");
		APIClient client = new APIClient("https://bdexample.testrail.io//");
		client.setUser("nicolas.mori+1@gmail.com");
		client.setPassword("123123123");
		
//		APIClient client = new APIClient("https://nicomori.testrail.io//");
//		client.setUser("nicolas.mori@gmail.com");
//		client.setPassword("a4610b");

		JSONObject obj = new JSONObject();

		obj.put("title", titleName);
		obj.put("template_id", templateId);
		obj.put("type_id", type_id);
		obj.put("priority_id", priority_id);
		obj.put("estimate", estimate);
		obj.put("milestone_id", milestone);
		obj.put("refs", refs);

		String preconditionsTitleToSend = "|||:Preconditions\n";
		String stepsTitleToSend = "|||:Steps\n";
		String expectedTitleToSend = "|||:Expected Results\n";
		
		int numberOfTestCase=0;

		try {
			for (TestRailTestCase test : listaDeTestCases) {

				
				List<String> partsOfSteps = Arrays.asList(test.getSteps().split("\n"));
				List<String> partsOfExpected = Arrays.asList(test.getResultExpected().split("\n"));
				
				//Format for Automation String section:
				String stepsInAStringForAutomationFile = "";
				String resultsInAStringForAutomationFile = "";
				
				for (int g = 1; g < partsOfSteps.size(); g++) {
					stepsInAStringForAutomationFile = stepsInAStringForAutomationFile +"	  * <li>"+partsOfSteps.get(g)+"</li>\n" ;
				}
				
				for (int h = 1; h < partsOfExpected.size(); h++) {
					resultsInAStringForAutomationFile = resultsInAStringForAutomationFile +"	  * <li>"+partsOfExpected.get(h)+"</li>\n" ;
				}
				
				
				String automationSteps = "\n" + 
						"	 /**\n" + 
						"	  * <ul>\n" + 
						"	  * <li>"+test.getTitle().substring(13, test.getTitle().length())+"</li>\n" + 
						"	  * <li>BDAY-"+test.getTitle().substring(0, 12)+"</li>\n" + 
						"	  * <li>Preconditions :</li>\n" + 
						"	  * <ul>\n" + 
						"	  * <li> User is navigated to correct locale/environment</li>\n" + 
						"	  * </ul>\n" + 
						"	  * <li>Steps</li>\n" + 
						"	  * <ul>\n" + 
						stepsInAStringForAutomationFile +
						"	  * </ul>\n" + 
						"	  * <li>Expected Results</li>\n" + 
						"	  * <ul>\n" + 
						resultsInAStringForAutomationFile +
						"	  * </ul>\n" + 
						"	  * </ul>\n" + 
						"	 */";
				
				//Format for the TestRails Fields:
				String stepsInAStringForTheTestRailsFields = "";
				String resultsInAStringTheTestRailsFields = "";
				
				for (int i = 1; i < partsOfSteps.size(); i++) {
					stepsInAStringForTheTestRailsFields = stepsInAStringForTheTestRailsFields +"|"+partsOfSteps.get(i)+"\n" ;
				}
				
				for (int t = 1; t < partsOfExpected.size(); t++) {
					resultsInAStringTheTestRailsFields = resultsInAStringTheTestRailsFields +"|"+partsOfExpected.get(t)+"\n" ;
				}
				
				obj.put("title", test.getTitle().substring(14, test.getTitle().length()));
				obj.put("custom_steps", stepsTitleToSend+stepsInAStringForTheTestRailsFields);
				obj.put("custom_expected", expectedTitleToSend+resultsInAStringTheTestRailsFields);
				obj.put("custom_preconds", preconditionsTitleToSend+"||User is navigated to correct locale/environment");
				obj.put("custom_automation_steps", automationSteps);
				
				System.out.println("Starting to send the test case number: "+numberOfTestCase);
				JSONObject r = (JSONObject) client.sendPost("add_case/"+sectionNumber, obj);
				System.out.println("Test case: "+numberOfTestCase+", sended correctly.");
				
				numberOfTestCase++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
