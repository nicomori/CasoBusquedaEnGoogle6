/**
 * 
 */
package com.smartfrog.modelclass;

/**
 * @author nicolasmori
 *
 */
public class TestRailTestCase {

	private String title;
	private String preconditions;
	private String steps;
	private String resultExpected;
	

	/**
	 * @param title
	 * @param steps
	 * @param resultExpected
	 */
	public TestRailTestCase(String title, String steps, String resultExpected) {
		super();
		this.title = title;
		this.steps = steps;
		this.resultExpected = resultExpected;
	}

	/**
	 * 
	 */
	public TestRailTestCase() {
		super();
	}

	/**
	 * @description
	 * @user nicolasmori 2018-07-11 title String
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-07-11 steps String
	 * @return the steps
	 */
	public String getSteps() {
		return steps;
	}

	/**
	 * @param steps
	 *            the steps to set
	 */
	public void setSteps(String steps) {
		this.steps = steps;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-07-11 resultExpected String
	 * @return the resultExpected
	 */
	public String getResultExpected() {
		return resultExpected;
	}

	/**
	 * @param resultExpected
	 *            the resultExpected to set
	 */
	public void setResultExpected(String resultExpected) {
		this.resultExpected = resultExpected;
	}

	// private List<TestRailSteps> steps;
	// private List<TestRailResultExpected> resultExpected;

}
