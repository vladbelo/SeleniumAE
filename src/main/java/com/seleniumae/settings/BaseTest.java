package com.seleniumae.settings;
/*
 * Author Vladimir Belonenko 04/16/2019 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	public static Wait<WebDriver> wait;
	public static String url;
	WebDriver driver;

	// Cross Browsing Testing Option: Chrome, Firefox or Edge.
	public void startDriver(String browser, String Url) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.firefox.marionette",
					"C:\\Users\\vlad\\Downloads\\Selenium_Basics\\geckodriver.exe");

			final FirefoxProfile firefox = new FirefoxProfile();
			firefox.setPreference("xpinstall.signatures.required", false);
			firefox.setPreference("browser.startup.homepage_override.mstone", "ignore");
			firefox.setPreference("startup.homepage_welcome_url.additional", "about:blank");
			driver = new FirefoxDriver();

			driver.get(Url);

		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-automation", "test-type=browser", "--disable-plugins", "--disable-infobars",
					"--disable-notifications", "start-maximized");
			driver = new ChromeDriver(options);
			driver.get(Url);

		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			// create Edge instance
			driver = new EdgeDriver();
			driver.get(Url);
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown(WebDriver driver) {
		quitDriver(driver);
	}

	protected static void quitDriver(WebDriver driver) {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception ee) {
			System.out.println("Teardown failed with the following error: " + ee);
			;
		}
	}

}
