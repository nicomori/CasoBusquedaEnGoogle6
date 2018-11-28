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

public class FindService extends StepsHelper {
	private long hash = 0;

	@Given("search the name of the service to define this in the execution")
	public void locatorNameOfService() throws FileNotFoundException {
		

		String serviceToValidate = "GetQuote";
		String pathWithTheOriginFile = "/Users/nicolasmori/Documents/inputFile.txt";

		String title = null;
		int stepNumber = 1;
		// String preconditions = null;
		List<String> steps = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();

		System.out.println("Location of the source file: " + pathWithTheOriginFile);
		List<String> contentFile = WriteAndReadFiles.readFileToArrayLinePerLine(pathWithTheOriginFile);
		
		
		
		
		
	}

	
	
	
	@And("generate dddddddddddd")
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
