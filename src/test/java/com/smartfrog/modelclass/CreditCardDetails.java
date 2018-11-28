package com.smartfrog.modelclass;

public class CreditCardDetails {

	private String cardNumber;
	private String fullName;
	private String cvv;
	private String month;
	private String year;
	
	/**
	 * @param cardNumber
	 * @param fullName
	 * @param cvv
	 * @param month
	 * @param year
	 */
	public CreditCardDetails(String cardNumber, String fullName, String cvv, String month, String year) {
		super();
		this.cardNumber = cardNumber;
		this.fullName = fullName;
		this.cvv = cvv;
		this.month = month;
		this.year = year;
	}
	/**
	 * 
	 */
	public CreditCardDetails() {
		super();
	}
	
	
	/**
	 * @description 
	 * @user nicolasmori 2018-06-13
	 * cardNumber String
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-06-13
	 * fullName String
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-06-13
	 * cvv String
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-06-13
	 * month String
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @description 
	 * @user nicolasmori 2018-06-13
	 * year String
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	

}
