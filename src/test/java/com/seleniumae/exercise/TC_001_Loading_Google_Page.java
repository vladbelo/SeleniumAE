package com.seleniumae.exercise;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumae.PageObjects_Google.Google_Home_Page;
import com.seleniumae.settings.BaseTest;
import com.seleniumae.settings.WebConstants;

import org.openqa.selenium.WebDriver;

public class TC_001_Loading_Google_Page {

	public WebDriver driver;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public void setUp(@Optional String browser, @Optional String url) throws MalformedURLException {
		BaseTest base = new BaseTest(browser, url);
		driver = base.getDriver();

		// driver = setupTestDriver.getDriver();

	}

	@Test
	public void Verify_Google_Page_Loads_Successffully() {
		try {
			System.out.println("Verify_that_Google_Page_Loads_Successfully_TEST() test case...");

			Assert.assertTrue(driver.getTitle().contentEquals("Google"));

			// 1. Open Browser Chrome
			// 2. Go TO: Google.com
			// base.startDriver("Chrome", "https://www.google.com");
			Thread.sleep(1500);

			// 3. Verify Page is Loaded Successfully

			// FINISH and CLEAN UP
			System.out.println("Finished with Verify_that_Google_Page_Loads_Successfully_TEST() test run!");

		} catch (Exception ee) {
			System.out.println("There was a problem: ");
			ee.printStackTrace();
			// Intentionally fail the test if any step triggers an exception
			Assert.assertEquals("A test step has failed: " + ee, "Expected all test steps to pass.");
		}
	}
}
