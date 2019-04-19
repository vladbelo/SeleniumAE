package com.seleniumae.settings;
/*
 * Author Vladimir Belonenko 04/16/2019 
 */

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	private WebDriver driver = null;
	private String browser = null;
	private String url = null;

	
	// Cross Browsing Testing Option: Chrome, Firefox or Edge.
	public BaseTest(String browser, String url) {
		this.browser = browser;
		this.url = url;
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");

			final FirefoxProfile firefox = new FirefoxProfile();
			firefox.setPreference("xpinstall.signatures.required", false);
			firefox.setPreference("browser.startup.homepage_override.mstone", "ignore");
			firefox.setPreference("startup.homepage_welcome_url.additional", "about:blank");
			driver = new FirefoxDriver();

			driver.get(url);

		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-automation", "test-type=browser", "--disable-plugins", "--disable-infobars",
					"--disable-notifications", "start-maximized");
			driver = new ChromeDriver(options);
			driver.get(url);

		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			// create Edge instance
			driver = new EdgeDriver();
			driver.get(url);
		} else {
			// If no browser passed throw exception
			// throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String getBrowser() {
		return this.browser;
	}

	public String getBaseUrl() {
		return this.url;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	@AfterClass
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
