/**
 * 
 */
package com.smartfrog.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nicolasmori
 *
 */
public class Steps {

	private String content;
	private String expected;

	Map data = new HashMap();

	/**
	 * @description
	 * @user nicolasmori 2018-06-29 content String
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
//		this.content = content;
		data.put("content", content);
	}

	/**
	 * @description
	 * @user nicolasmori 2018-06-29 expected String
	 * @return the expected
	 */
	public String getExpected() {
		return expected;
	}

	/**
	 * @param expected
	 *            the expected to set
	 */
	public void setExpected(String expected) {
//		this.expected = expected;
		data.put("expected", expected);
	}

	/**
	 * @param content
	 * @param expected
	 */
	public Steps(String content, String expected) {
		super();
		this.content = content;
		this.expected = expected;
	}

	/**
	 * 
	 */
	public Steps() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Steps [content=" + content + ", expected=" + expected + "]";
	}

	// Map data = new HashMap();

	// data.put("title", "SOY DIOSSSSSSS 222222222");

}
