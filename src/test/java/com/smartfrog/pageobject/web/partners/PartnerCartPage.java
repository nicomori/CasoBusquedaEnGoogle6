package com.smartfrog.pageobject.web.partners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

//this class represent the values and the content of the cart page with this url 
//https://www.sf-dev1.com/en-gb/shop/cart?promo=first_utility&action=add&product_id=CamPackage

public class PartnerCartPage extends ParentPage {

	/**
	 * @param driver
	 */
	public PartnerCartPage(WebDriver driver) {
		super(driver);
	}

	private By body_label_your_shopping_cart = By.xpath("//*[@pid='body_label_your_shopping_cart']");
	private By editfield_voucher_input = By.xpath("//*[@pid='voucher_input']");
	private By button_voucher_redeem = By.xpath("//*[@pid='voucher_redeem']");
	private By body_value_onetimecost = By.xpath("//*[@pid='body_value_onetimecost']");
	private By body_value_monthlycost = By.xpath("//*[@pid='body_value_monthlycost']");
	private By body_value_subtotal = By.xpath("//*[@pid='body_value_subtotal']");
	private By body_value_deliverycost = By.xpath("//*[@pid='body_value_deliverycost']");
	private By body_value_total = By.xpath("//*[@pid='body_value_total']");
	private By body_button_checkout = By.xpath("//*[@pid='body_button_checkout']");
	private By remove_product = By.xpath("//*[@pid='product_remove']");
	private By SHOP_LOGIN_BUTTON = By.cssSelector(".fk-header__btn-shop");
	private By productItemBody = By.xpath("//*[@pid='body_cluster_item_details']");

	/**
	 * This method return true or false in case if the element label "Your Shopping
	 * Cart" appear correctly displayed.
	 * 
	 * @return boolean
	 */
	public Boolean verifyIfTheMainTextExist() {
		System.out.println("Starting to verify if the main text label exist correctly.");
		waitSleepingTheTread(3000);
		return verifyIfisDisplayedX2(body_label_your_shopping_cart);
	}

	/**
	 * This value verify if the cost of value Monthly Cost is equal to zero.
	 * 
	 * @return true or false
	 */
	public Boolean verifyTheValueMonthlyCostIsInZero() {
		System.out.println("Starting to verify if the value montly cost is equal to zero.");
		return verifyIfSomeStringContainsZeroDotZeroZeroValueInside(getTextByLocator(body_value_monthlycost));
	}

	/**
	 * This value verify if the cost of value Delivery Cost is equal to zero.
	 * 
	 * @return true or false
	 */
	public Boolean verifyTheValueDeliveryCostIsInZero() {
		System.out.println("Starting to verify if the value delivery cost is equal to zero.");
		return verifyIfSomeStringContainsZeroDotZeroZeroValueInside(getTextByLocator(body_value_deliverycost));
	}

	/**
	 * This value verify if the cost of value Total Cost is equal to zero.
	 * 
	 * @return true or false
	 */
	public Boolean verifyTheValueTotalCostIsInZero() {
		System.out.println("Starting to verify if the value total cost is equal to zero.");
		return verifyIfSomeStringContainsZeroDotZeroZeroValueInside(getTextByLocator(body_value_total));
	}

	/**
	 * This value verify if the cost of value subtotal is equal to zero.
	 * 
	 * @return true or false
	 */
	public Boolean verifyTheValueSubtotalIsInZero() {
		System.out.println("Starting to verify if Subtotal is equal to 0.00.");
		return verifyIfSomeStringContainsZeroDotZeroZeroValueInside(getTextByLocator(body_value_subtotal));
	}

	/**
	 * This value verify if the cost of value One Time Cost is equal to zero.
	 * 
	 * @return true or false
	 */
	public Boolean verifyTheValueOneTimeCostIsInZero() {
		System.out.println("Starting to verify if one time cost is equal to 0.00.");
		return verifyIfSomeStringContainsZeroDotZeroZeroValueInside(getTextByLocator(body_value_onetimecost));
	}

	/**
	 * This method retrieve true or false if we can see correctly the partner bar
	 * 
	 * @return true or false
	 */
	public Boolean verifyIfSomePartnerTextAppearCorrectly(String somePartnerText) {
		System.out.println("Starting to verify if we can see some text in the website, this text: " + somePartnerText);
		waitSleepingTheTread(3000);
		return genericVerifyIfSomeTextExistInsideOfTheAlternativeTag(somePartnerText);
	}

	/**
	 * This method set the voucher valur and press in the button redeem in the cart.
	 * 
	 * @param String
	 *            with vouchedCode
	 */
	public void setTheVoucherValueAndPressInTheButtonRedeem(String vouchedCode) {
		System.out.println("This method send the value of the vaucher: " + vouchedCode);
		waitSleepingTheTread(5000);
		sendKeysToLocator(editfield_voucher_input, vouchedCode);
		clickJSx2(button_voucher_redeem);
		waitSleepingTheTread(1000);
	}

	/**
	 * this method make click in the button checkout.
	 */
	public void clickOnTheCheckOutButton() {
		System.out.println("Making click in the button checkout");
		waitForAnExplicitElement(body_button_checkout);
		click(body_button_checkout);
	}

	public void clickOnRemoveProduct() {
		System.out.println("This method remove product from the cart page");
		waitSleepingTheTread(3000);
		click(remove_product);
	}

	public Boolean emptyCartMessage(String message) {
		System.out.println("This method check the message of a empty cart");
		waitSleepingTheTread(777);
		return genericVerifyIfSomeTextExist(message);
	}

	public void clickOnButtonByText(String buttonName) {
		System.out.println("This Method click on a button by text");
		waitSleepingTheTread(3000);
		genericClickByText(buttonName);
	}

	public void makeClickinTheButtonShopOnTheCartPage() {
		System.out.println("Making click in the button shop");
		waitForAnExplicitElement(SHOP_LOGIN_BUTTON);
		clickJSx2(SHOP_LOGIN_BUTTON);
	}

	public Boolean checkProductQuantity(String productName, String quantity) {
		System.out.println("This Method check the product name and quantity");

		String searchProduct = "//*[@pid='body_cluster_item_details'][%s]//*[@pid='product_name'][contains(text(),'%s')]";
		String productQuantity = "//*[@pid='body_cluster_item_details'][%s]//*[@pid='product_quantity']/*[2]";
		String pQuantity;
		boolean y = false;

		waitSleepingTheTread(3000);
		String cQuantity = null;

		Integer numbElements = countElements(productItemBody);

		if (numbElements != 0) {
			/** Element found **/
			for (int i = 1; i <= numbElements; i++) {
				By check = By.xpath(String.format(searchProduct, i, productName));
				y = verifyIfisDisplayed(check);
				if (y == true) {
					By checkQuantity = By.xpath(String.format(productQuantity, i));
					pQuantity = getFirstDropDownItem(checkQuantity);
					waitSleepingTheTread(1000);
					cQuantity = pQuantity.replaceAll("[^\\d.]", "");
					waitSleepingTheTread(1000);
					if (cQuantity.equals(quantity)) {
						y = true;
					} else {
						y = false;
					}
					break;
				}
			}
		}
		return y;
	}

	public Boolean checkProductPrice(String productName, String productPrice) {
		System.out.println("This Method check the price of a product");

		String searchProduct = "//*[@pid='body_cluster_item_details'][%s]//*[@pid='product_name'][contains(text(),'%s')]";
		String locatorProductPrice = "//*[@pid='body_cluster_item_details'][%s]//*[@pid='product_price']";
		boolean x = false;
		String pPrice = null;

		waitSleepingTheTread(3000);
		Integer numbElements = countElements(productItemBody);

		if (numbElements != 0) {
			for (int i = 1; i <= numbElements; i++) {
				try {
					By check = By.xpath(String.format(searchProduct, i, productName));
					waitSleepingTheTread(1000);
					x = verifyIfisDisplayed(check);
					if (x == true) {
						waitSleepingTheTread(1000);
						pPrice = getTextByLocator(By.xpath(String.format(locatorProductPrice, i)));
						if (productPrice.equals(pPrice)) {
							x = true;
						} else {
							x = false;
						}
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		System.out.println("Price finded: " + pPrice);
		System.out.println("Price expected: " + productPrice);
		return x;
	}

	public Boolean checkTotalPrice(String totalPrice) {
		String locatorTotalPrice = "//*[@pid='body_value_total'][contains(text(),'%s')]";
		System.out.println("This Method check the price ");
		waitForAnExplicitElement(body_value_subtotal);
		By check = By.xpath(String.format(locatorTotalPrice, totalPrice));
		return genericVerifyIfSomeElementExist(check);
	}

	public String getTotalPrice() {
		System.out.println("Starting to return the price total disaplyed in the web");
		return getTextByLocator(body_value_total);
	}
}
