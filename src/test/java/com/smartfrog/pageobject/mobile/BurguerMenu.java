package com.smartfrog.pageobject.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartfrog.framework.ParentPage;

/**
 * this class represent the first page of the android app, where we can see the
 * login button
 * 
 * @author nicolasmori
 */
public class BurguerMenu extends ParentPage {

	public BurguerMenu(WebDriver driver) {
		super(driver);
	}

	@SuppressWarnings("unused")
	private By MENUITEM_SMARTFROG_CAMERA = By.id("");
	@SuppressWarnings("unused")
	private By MENUITEM_SMARTFROG_ALERTS = By.id("");
	@SuppressWarnings("unused")
	private By MENUITEM_SMARTFROG_SAVED_CLIPS = By.id("");
	@SuppressWarnings("unused")
	private By MENUITEM_CONNECT_COONECT_ANOTHER = By.id("");
	@SuppressWarnings("unused")
	private By MENUITEM_CONNECT_USE_SMARTPHONE = By.id("");
	@SuppressWarnings("unused")
	private By MENUITEM_CONNECT_SHOP = By.id("");
	private By MENUITEM_GENERAL_ACCOUNT = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.LinearLayout[10]/android.widget.TextView");
	@SuppressWarnings("unused")
	private By MENUITEM_GENERAL_GUIDE = By.id("");
	@SuppressWarnings("unused")
	private By MENUITEM_GENERAL_ABOUT = By.id("");

	/**
	 * this method make click in the button user account in the burguer menu.
	 */
	public void clickOnUserAccount() {
		waitForAnExplicitElement(MENUITEM_GENERAL_ACCOUNT);
		click(MENUITEM_GENERAL_ACCOUNT);
	}
}
