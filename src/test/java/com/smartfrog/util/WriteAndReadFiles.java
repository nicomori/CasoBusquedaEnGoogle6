package com.smartfrog.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteAndReadFiles {

	public static String stringInsideOfAFile = null;

	public static String readAFileAndStoreInString(String pathAndFileName) {
		System.out.println("Starting to read the file: " + pathAndFileName);
		try {
			stringInsideOfAFile = new Scanner(new File(pathAndFileName)).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			System.out.println("appear an error at the moment to get the text inside of the file: " + pathAndFileName);
		}
		return stringInsideOfAFile;
	}

	public static void writerListOfStringToFile(List<String> theArray) throws IOException {
		System.out.println("Starting to write the File");
		FileWriter writer = new FileWriter("/Users/nicolasmori/Documents/export.csv");
		for (String str : theArray) {
			writer.write(str);
			// writer.write(str + "\n");
		}
		writer.close();
		System.out.println("Finish to write the File");
	}
	
	public static void writerListOfStringToFileWithName(List<String> theArray, String someNameOfFile) throws IOException {
		System.out.println("Starting to write the File");
		FileWriter writer = new FileWriter("/Users/nicolasmori/Documents/"+someNameOfFile+".csv");
		for (String str : theArray) {
			writer.write(str);
			// writer.write(str + "\n");
		}
		writer.close();
		System.out.println("Finish to write the File");
	}

	public static List<String> readFileToArraySpaceXSpace() throws FileNotFoundException {
		List<String> theArray = new ArrayList<String>();

		System.out.println("Starting to read the File");
		Scanner s = new Scanner(new File("/Users/nicolasmori/Documents/bestday_2_of_6.txt"));

		while (s.hasNext()) {
			theArray.add(s.next());
		}
		s.close();
		System.out.println("Finish to read the File");

		return theArray;
	}

	public static List<String> readFileToArrayLinePerLine(String pathOfTheFile) throws FileNotFoundException {
		List<String> theArray = new ArrayList<String>();

		System.out.println("Starting to read the File");

		// Open the file
		FileInputStream fstream = new FileInputStream(pathOfTheFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		// Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console

				theArray.add(Normalizer.normalize(strLine, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""));

				// without normalized
				// theArray.add(strLine);
				 System.out.println("this line is readed and completed!! ==> "+strLine);
			}

			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish to read the File");

		return theArray;
	}
}
