/**
 * 
 */
package com.smartfrog.modelclass;

import java.util.List;

/**
 * @author nicolasmori
 *
 */
public class TestRailTestCase2 {

	private String title;
	private String preconditions;
	private List<String> steps;
	private List<String> resultExpected;
	/**
	 * @description 
	 * @user nicolasmori 2018-08-07
	 * title String
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-08-07
	 * preconditions String
	 * @return the preconditions
	 */
	public String getPreconditions() {
		return preconditions;
	}
	/**
	 * @param preconditions the preconditions to set
	 */
	public void setPreconditions(String preconditions) {
		this.preconditions = preconditions;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-08-07
	 * steps List<String>
	 * @return the steps
	 */
	public List<String> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-08-07
	 * resultExpected List<String>
	 * @return the resultExpected
	 */
	public List<String> getResultExpected() {
		return resultExpected;
	}
	/**
	 * @param resultExpected the resultExpected to set
	 */
	public void setResultExpected(List<String> resultExpected) {
		this.resultExpected = resultExpected;
	}
	/**
	 * @param title
	 * @param preconditions
	 * @param steps
	 * @param resultExpected
	 */
	public TestRailTestCase2(String title, String preconditions, List<String> steps, List<String> resultExpected) {
		super();
		this.title = title;
		this.preconditions = preconditions;
		this.steps = steps;
		this.resultExpected = resultExpected;
	}
	/**
	 * 
	 */
	public TestRailTestCase2() {
		super();
	}

}
