package com.smartfrog.modelclass;

public class Labels {

	private String label;

	/**
	 * @description
	 * @user nicolasmori 2018-05-08 label String
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Labels [label=" + label + "]";
	}
}
