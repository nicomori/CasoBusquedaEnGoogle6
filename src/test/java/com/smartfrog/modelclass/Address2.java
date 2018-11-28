package com.smartfrog.modelclass;

public class Address2 {

	private String salutationOption;
	private String name;
	private String lastName;
	private String sign;
	private String street;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String phoneNumber;

	/**
	 * 
	 */
	public Address2() {
		super();
	}

	/**
	 * @param salutationOption
	 * @param name
	 * @param lastName
	 * @param sign
	 * @param street
	 * @param streetNumber
	 * @param postalCode
	 * @param city
	 * @param phoneNumber
	 */
	public Address2(String salutationOption, String name, String lastName, String sign, String street,
			String streetNumber, String postalCode, String city, String phoneNumber) {
		super();
		this.salutationOption = salutationOption;
		this.name = name;
		this.lastName = lastName;
		this.sign = sign;
		this.street = street;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 salutationOption String
	 * @return the salutationOption
	 */
	public String getSalutationOption() {
		return salutationOption;
	}

	/**
	 * @param salutationOption
	 *            the salutationOption to set
	 */
	public void setSalutationOption(String salutationOption) {
		this.salutationOption = salutationOption;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 name String
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 lastName String
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 sign String
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign
	 *            the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 street String
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 streetNumber String
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber
	 *            the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 postalCode String
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 city String
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @description
	 * @user nicolasmori 2018-05-28 phoneNumber String
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
