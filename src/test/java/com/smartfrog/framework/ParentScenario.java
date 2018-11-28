package com.smartfrog.framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.smartfrog.backend.BackendCalls;
import com.smartfrog.backend.UserRelayCustomerCare;
import com.smartfrog.pageobject.PageHelper;
import com.smartfrog.pageobject.TrainingPage;
import com.smartfrog.pageobject.mobile.BurguerMenu;
import com.smartfrog.pageobject.mobile.HomePage;
import com.smartfrog.pageobject.mobile.LoginPage;
import com.smartfrog.pageobject.mobile.UserAccountPage;
import com.smartfrog.pageobject.mobile.WelcomeAfterLoginPage;
import com.smartfrog.pageobject.mobile.WelcomePage;
import com.smartfrog.pageobject.web.SFCancelationOrderSummaryPage;
import com.smartfrog.pageobject.web.SFCheckoutConfirmationPage;
import com.smartfrog.pageobject.web.SFGenericPage;
import com.smartfrog.pageobject.web.SFHeaderPage;
import com.smartfrog.pageobject.web.SFHomePage;
import com.smartfrog.pageobject.web.SFLoginPage;
import com.smartfrog.pageobject.web.SFMyAccountPage;
import com.smartfrog.pageobject.web.SFProductDetailsPage;
import com.smartfrog.pageobject.web.SFRegisterAddressCorrectionPage;
import com.smartfrog.pageobject.web.SFRegisterAddressPage;
import com.smartfrog.pageobject.web.SFRegisterFirstPage;
import com.smartfrog.pageobject.web.SFRegisterPaymentMethodCCPage;
import com.smartfrog.pageobject.web.SFRegisterPaymentMethodPage;
import com.smartfrog.pageobject.web.SFRegisterPaymentMethodSepaPage;
import com.smartfrog.pageobject.web.SFRegisterSecondPage;
import com.smartfrog.pageobject.web.SFRegisterSummaryPage;
import com.smartfrog.pageobject.web.SFShopProductsPage;
import com.smartfrog.pageobject.web.SFUserDashboardPage;
import com.smartfrog.pageobject.web.external.AdminUICampaignDetails;
import com.smartfrog.pageobject.web.external.AdminUICampaignsDashboard;
import com.smartfrog.pageobject.web.external.AdminUIDashboardPage;
import com.smartfrog.pageobject.web.external.AdminUILoginPage;
import com.smartfrog.pageobject.web.external.GmailEmailContentPage;
import com.smartfrog.pageobject.web.external.GmailHomePage;
import com.smartfrog.pageobject.web.external.GmailLoginEmailPage;
import com.smartfrog.pageobject.web.external.GmailLoginPassPage;
import com.smartfrog.pageobject.web.external.PayPalPage;
import com.smartfrog.pageobject.web.external.SofortPage;
import com.smartfrog.pageobject.web.partners.EnbwHomePage;
import com.smartfrog.pageobject.web.partners.FirstUtilityHomePage;
import com.smartfrog.pageobject.web.partners.MedionHomePage;
import com.smartfrog.pageobject.web.partners.MobilcomeHomePage;
import com.smartfrog.pageobject.web.partners.PartnerCartPage;
import com.smartfrog.pageobject.web.partners.PartnerLandingPage;
import com.smartfrog.pageobject.web.partners.ShellHomePage;
import com.smartfrog.util.SelectorBrowser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * This Class is created for make a helper for all the pages, and all the parts
 * of the a native app, or for execute all the drivers. And for create all the
 * objects of pages, or objects created in all the pages.
 * 
 */

public class ParentScenario {

	protected static WebDriver driver;

	// Mobile Apps
	protected static WelcomePage welcomePage;
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static BurguerMenu burguerMenu;
	protected static WelcomeAfterLoginPage welcomeAfterLoginPage;
	protected static UserAccountPage userAccountPage;

	// External Webs
	protected static GmailEmailContentPage gmailEmailContentPage;
	protected static GmailLoginPassPage gmailLoginPassPage;
	protected static GmailHomePage gmailHomePage;
	protected static GmailLoginEmailPage gmailLoginEmailPage;
	protected static AdminUILoginPage adminUILoginPage;
	protected static AdminUIDashboardPage adminUIDashboardPage;
	protected static AdminUICampaignsDashboard adminUICampaignsDashboard;
	protected static AdminUICampaignDetails adminUICampaignDetails;
	protected static FirstUtilityHomePage firstUtilityHomePage;
	protected static PartnerCartPage partnerCartPage;
	protected static EnbwHomePage enbwHomePage;
	protected static MedionHomePage medionHomePage;
	protected static MobilcomeHomePage mobilcomeHomePage;
	protected static ShellHomePage shellHomePage;

	// ECommerce Webs
	protected static SFHomePage sfHhomePageWeb;
	protected static PageHelper pageHelper;
	protected static PartnerLandingPage partnerLandingPage;
	protected static SFShopProductsPage sfShopProductsPage;
	protected static SFLoginPage sfLoginPage;
	protected static SFRegisterFirstPage sfRegisterFirstPage;
	protected static SFRegisterSecondPage sfRegisterSecondPage;
	protected static SFProductDetailsPage sfProductDetailsPage;
	protected static SFGenericPage sfGenericPage;
	protected static SFHeaderPage sfHeaderPage;
	protected static SFUserDashboardPage sfUserDashboardPage;
	protected static SFRegisterAddressPage sfRegisterAddressPage;
	protected static SFRegisterAddressCorrectionPage sfRegisterAddressCorrectionPage;
	protected static SFRegisterPaymentMethodPage sfRegisterPaymentMethodPage;
	protected static SFRegisterSummaryPage sfRegisterSummaryPage;
	protected static SFRegisterPaymentMethodCCPage sfRegisterPaymentMethodCCPage;
	protected static SFRegisterPaymentMethodSepaPage sfRegisterPaymentMethodSepaPage;
	protected static SofortPage sofortPage;
	protected static SFMyAccountPage sfMyAccountPage;
	protected static SFCheckoutConfirmationPage sfCheckoutConfirmationPage;
	protected static SFCancelationOrderSummaryPage sfCancelationOrderSummaryPage;
	protected static PayPalPage payPalPage;

	protected static TrainingPage trainingPage;

	// Backend
	protected static UserRelayCustomerCare userRelayCustomerCare = new UserRelayCustomerCare();
	protected static BackendCalls backendCalls = new BackendCalls(driver);

	/**
	 * this method create the object driver for Android.
	 * 
	 * @param uuid
	 *            of the device to use.
	 */
	public void startAndroidApp() {
		try {
			if (System.getProperty("uuid").equals(null)) {
				System.out.println("Please define the variable \"uuid\" in your execution MVN command with "
						+ "the uuid of your device, something like a string with numbers, you can get "
						+ "the correct uuid executing this in the terminal: \"adb devices\", "
						+ "get just the code in the left side");
				System.exit(0);
			}

			if (System.getProperty("appPackage").equals(null)) {
				System.out.println("Please define the variable \"appPackage\" in your execution MVN command with "
						+ "the appPackage of your app, something like \"com.inovotecs.smartfrog.dev\"");
				System.exit(0);
			}

			if (System.getProperty("appFilePath").equals(null)) {
				System.out.println("Please define the variable \"appFilePath\" in your execution MVN command with "
						+ "the path to your ipa file something like: /Users/[username]/base.apk");
				System.exit(0);
			}

			if (System.getProperty("appWaitActivity").equals(null)) {
				System.out.println("Please define the variable \"appWaitActivity\" in your execution MVN command with "
						+ "the appPackage of your app, something like \"com.inovotecs.frogcam.startup.StartupActivity\"");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println(
					"Please define correctly the Maven variables -Duuid, -DappPackage, -DappFilePath and -DappWaitActivity");
			System.exit(0);
		}

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, System.getProperty("appPackage"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("appFilePath"));
		cap.setCapability("noReset", false);
		cap.setCapability("deviceName", "Android");
		cap.setCapability("appWaitActivity", System.getProperty("appWaitActivity"));

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (Exception e) {
			System.out.println("Exeption at the moment to generate the driver = " + e);
		}

		welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		burguerMenu = new BurguerMenu(driver);
		welcomeAfterLoginPage = new WelcomeAfterLoginPage(driver);
		userAccountPage = new UserAccountPage(driver);
	}

	/**
	 * this method create the object driver for Ios.
	 * 
	 * @param uuid
	 *            of the device to use.
	 */
	public void startIOSApp() {
		try {
			if (System.getProperty("appFilePath").equals("")) {
				System.out.println("Please define the variable \"appFilePath\" in your execution MVN command with "
						+ "the path to your ipa file something like: /Users/[username]/sfdev.ipa");
				System.exit(0);
			}

			if (System.getProperty("deviceName").equals(null)) {
				System.out.println("Please define the variable \"deviceName\" in your execution MVN command with "
						+ "the name of your device, something like: iPhone 8, or similiar, you can get "
						+ "the correct name executing this in the terminal: \"instruments -s devices\", "
						+ "usually if this is a real device you can find upstair, get just the name of "
						+ "the device without the os version");
				System.exit(0);
			}

			if (System.getProperty("uuid").equals(null)) {
				System.out.println("Please define the variable \"uuid\" in your execution MVN command with "
						+ "the uuid of your device, something like a long long string with numbers and letter, you can get "
						+ "the correct uuid executing this in the terminal: \"instruments -s devices\", "
						+ "usually if this is a real device you can find upstair, get just the code in the right of "
						+ "the device without the os version, and the name");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println(
					"Please define correctly the Maven variables -Duuid, -DdeviceName, -DappFilePath and -DappFilePath");
			System.exit(0);
		}

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.APP, System.getProperty("appFilePath"));
		cap.setCapability("noReset", false);
		cap.setCapability("deviceName", System.getProperty("deviceName"));
		cap.setCapability("automationName", "XCUITest");
		cap.setCapability("udid", System.getProperty("uuid"));
		cap.setCapability("xcodeOrgId", "8P69Z778XV");
		cap.setCapability("xcodeSigningId", "iPhone Developer");

		try {
			driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (Exception e) {
			System.out.println("Exeption at the moment to generate the driver = " + e);
		}

		welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		burguerMenu = new BurguerMenu(driver);
		welcomeAfterLoginPage = new WelcomeAfterLoginPage(driver);
		userAccountPage = new UserAccountPage(driver);
	}

	public void startBrowser() {
		System.out.println("Starting driver for Browser Chrome");
		driver = SelectorBrowser.createDriverWithoutCapabilities("Chrome", driver);

		sfHhomePageWeb = new SFHomePage(driver);
		backendCalls = new BackendCalls(driver);
		adminUILoginPage = new AdminUILoginPage(driver);
		adminUIDashboardPage = new AdminUIDashboardPage(driver);
		adminUICampaignsDashboard = new AdminUICampaignsDashboard(driver);
		adminUICampaignDetails = new AdminUICampaignDetails(driver);
		firstUtilityHomePage = new FirstUtilityHomePage(driver);
		partnerCartPage = new PartnerCartPage(driver);
		pageHelper = new PageHelper(driver);
		partnerLandingPage = new PartnerLandingPage(driver);
		enbwHomePage = new EnbwHomePage(driver);
		medionHomePage = new MedionHomePage(driver);
		mobilcomeHomePage = new MobilcomeHomePage(driver);
		shellHomePage = new ShellHomePage(driver);

		sfGenericPage = new SFGenericPage(driver);
		sfProductDetailsPage = new SFProductDetailsPage(driver);
		sfShopProductsPage = new SFShopProductsPage(driver);
		sfLoginPage = new SFLoginPage(driver);
		sfRegisterFirstPage = new SFRegisterFirstPage(driver);
		sfRegisterSecondPage = new SFRegisterSecondPage(driver);
		sfHeaderPage = new SFHeaderPage(driver);
		sfUserDashboardPage = new SFUserDashboardPage(driver);
		sfRegisterAddressPage = new SFRegisterAddressPage(driver);
		sfRegisterAddressCorrectionPage = new SFRegisterAddressCorrectionPage(driver);
		sfRegisterPaymentMethodPage = new SFRegisterPaymentMethodPage(driver);
		sfRegisterSummaryPage = new SFRegisterSummaryPage(driver);
		sfRegisterPaymentMethodCCPage = new SFRegisterPaymentMethodCCPage(driver);
		sfRegisterPaymentMethodSepaPage = new SFRegisterPaymentMethodSepaPage(driver);
		sofortPage = new SofortPage(driver);
		sfCheckoutConfirmationPage = new SFCheckoutConfirmationPage(driver);
		sfMyAccountPage = new SFMyAccountPage(driver);
		sfCancelationOrderSummaryPage = new SFCancelationOrderSummaryPage(driver);
		payPalPage = new PayPalPage(driver);

		trainingPage = new TrainingPage(driver);
	}

	/**
	 * this method help us to change the property of testing type.
	 * 
	 * @param propertyEnv
	 */
	public void defineNewPropertyEnviroment(String propertyEnv) {
		System.out.println("Starting to define a new Testing Type property with the name: " + propertyEnv);
		System.setProperty("testingType", propertyEnv);
	}

	/**
	 * this method select the driver to create, depending of the maven property
	 * "testingType" in the command to execute.
	 * 
	 */
	public void deviceSelector() {
		try {
			System.out.println("Starting to identify the type of device test.");
			if (System.getProperty("testingType").equals("android")) {
				System.out.println("Starting a testing of Android.");
				startAndroidApp();
			}

			if (System.getProperty("testingType").equals("ios")) {
				System.out.println("Starting a testing of Ios.");
				startIOSApp();
			}

			if (System.getProperty("testingType").equals("web")) {
				System.out.println("Starting a testing of Web.");
				startBrowser();
			}

			if (System.getProperty("testingType").equals("backend")) {
				System.out.println("Starting a testing of Backend.");
			}

			if (System.getProperty("testingType").equals("e2e")) {
				System.out.println("Starting a testing of Backend.");
				startBrowser();
			}
		} catch (Exception e) {

			System.out.println(e);

			System.out.println("\n\n\n Please define correctly the Maven variables -DtestingType, you "
					+ "need include in this, android, or ios, or web, or backend, or e2e");
			driver.quit();
			System.exit(0);
		}
	}

	/**
	 * this method access to some specific url after the enviroment of the site and
	 * the lenguaje
	 * 
	 * @param url
	 */
	public void accessToSomeSpecificUrl(String webapp) {
		System.out.println("Starting to access to this specific url: " + webapp);

		if (webapp.toLowerCase().contains("mail")) {
			driver.get("https://mail.google.com");
		}

		if (webapp.toLowerCase().contains("dmin")) {
			try {
				if (System.getProperty("env").contains("test")) {
					driver.get("https://admin.dir.sf-test1.com");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://admin.dir.sf-dev1.com");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env") + ", but we can work "
							+ "with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 3");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 1");
				driver.quit();
				System.exit(0);
			}
		}

		if (webapp.toLowerCase().contains("first")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/en-gb/first-utility");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/en-gb/first-utility");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/en-gb/first-utility");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 4");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 2");
				driver.quit();
				System.exit(0);
			}
		}

		if (webapp.toLowerCase().isEmpty()) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com");
				} else {
					System.out.println("\nAppear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 5");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 3");
				driver.quit();
				System.exit(0);
			}
		}

		System.out.println(
				"Appear a problem in the variable of the feature webapp, we are expecting null to E-Commerce, first to first-utility, mail to gmail or adminui, but we detect you are using this: "
						+ webapp + ", please verify the content and change.");
	}

	public void accessToTheUrlWithoutExamples(String partnerName) {
		// FirstUtility Section
		if (partnerName.toLowerCase().contains("irst")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/en-gb/first-utility");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/en-gb/first-utility");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/en-gb/first-utility");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 6");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 4");
				driver.quit();
				System.exit(0);
			}
		}

		// Enbw Section
		if (partnerName.toLowerCase().equals("enbw")) {
			try {
				if (System.getProperty("env").contains("martfrog")) {
					driver.get("https://www.smartfrog.com/de-de/enbw");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/de-de/enbw");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/de-de/enbw");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 8");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 8");
				driver.quit();
				System.exit(0);
			}
		}

		// Medion Section
		else if (partnerName.toLowerCase().contains("medion")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/de-de/medion/");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/de-de/medion");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/de-de/medion");
				} else {
					System.out.println("\nAppear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 7");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 5");
				driver.quit();
				System.exit(0);
			}
		}

		// Mobilcom Section
		else if (partnerName.toLowerCase().contains("obilcom")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://md.smartfrog.com/de-de/");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://md.sf-test1.com/de-de/");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://md.sf-dev1.com/de-de/");
				} else {
					System.out.println("\nAppear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 1");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 6");
				driver.quit();
				System.exit(0);
			}
		}

		// SmartFrog Section
		if (partnerName.toLowerCase().contains("mart")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/de-de");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/de-de");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/de-de");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there.2");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 7");
				driver.quit();
				System.exit(0);
			}
		}

		// enbw-geschenk Section
		if (partnerName.toLowerCase().contains("eschenk")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/de-de/enbw-geschenk");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/de-de/enbw-geschenk");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/de-de/enbw-geschenk");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 9");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 9");
				driver.quit();
				System.exit(0);
			}
		}

		// Max Energy Section
		if (partnerName.toLowerCase().contains("axenergy")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://www.smartfrog.com/de-de/partner/passwort-einsetzen");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://www.sf-test1.com/de-de/partner/passwort-einsetzen");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://www.sf-dev1.com/de-de/partner/passwort-einsetzen");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 10");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 10");
				driver.quit();
				System.exit(0);
			}
		}

		// Shell Section
		if (partnerName.toLowerCase().contains("hell")) {
			try {
				if (System.getProperty("env").contains("smartfrog")) {
					driver.get("https://shell.smartfrog.com/de-de/");
				} else if (System.getProperty("env").contains("test")) {
					driver.get("https://shell.sf-test1.com/de-de/");
				} else if (System.getProperty("env").contains("dev")) {
					driver.get("https://shell.sf-dev1.com/de-de/");
				} else {
					System.out.println("\n\n\n Appear a problem in the variable \"env\" you set " + "this value: "
							+ System.getProperty("env")
							+ ", but we can work with values like sf-dev1.com, sf-test1.com, or smartfrog.com, please take a look there. 11");
					driver.quit();
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(
						"\nPlease define correctly the Maven variables \"-Denv\", you need include in this, sf-dev1.com, or sf-test1.com, or smartfrog.com 11");
				driver.quit();
				System.exit(0);
			}
		}
	}
}