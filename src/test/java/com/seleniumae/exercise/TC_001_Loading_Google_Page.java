package com.seleniumae.exercise;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;



import com.seleniumae.settings.BaseTest;
import com.seleniumae.settings.WebConstants;

public class TC_001_Loading_Google_Page extends BaseTest {
	WebDriver driver;

	@Test
	public void Verify_Google_Page_Loads_Successffully() {
		try {
			System.out.println("Verify_that_Google_Page_Loads_Successfully_TEST() test case...");
			// WebDriver driver;

			WebConstants web = new WebConstants();
			BaseTest base = new BaseTest();
			

			// 1. Open Browser Chrome
			// 2. Go TO: Google.com
			base.startDriver("chrome", "http://www.google.com/");
			WebConstants.SetDelay(5000);
	

			// 3. Verify Page is Loaded Successfully
			web.waitForPageLoaded();

			
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
