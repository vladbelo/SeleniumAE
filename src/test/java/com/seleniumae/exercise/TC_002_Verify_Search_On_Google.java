package com.seleniumae.exercise;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumae.PageObjects_Google.Google_Home_Page;
import com.seleniumae.settings.BaseTest;
import com.seleniumae.settings.WebConstants;

public class TC_002_Verify_Search_On_Google {
	WebDriver driver;
	
	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public void setUp(@Optional("browser") String browser, @Optional("url") String url) {
		BaseTest base = new BaseTest(browser, url);
		driver = base.getDriver();

	}

	@Test
	public void Google_Search_Links() {
		try {
			System.out.println("Verify_that_Google_Page_Loads_Successfully_TEST() test case...");

			//BaseTest base = new BaseTest();
			Google_Home_Page home = new Google_Home_Page(driver);
			

			// 1. Open Browser Chrome
			// 2. Go TO: Google.com
			//base.startDriver("chrome", "http://www.google.com/");
             Thread.sleep(3000);
	
			// 3. Search for Mobile Integration Workgroup
			home.selectSearchBox();

			// 4. Verify the first Link is
			home.linkSearch("https://miwtech.com/", 1);

			// FINISH and CLEAN UP
			System.out.println("Finished with Verify_that_Google_Link_Passed_TEST() test run!");

		} catch (Exception ee) {
			System.out.println("There was a problem: ");
			ee.printStackTrace();
			// Intentionally fail the test if any step triggers an exception
			Assert.assertEquals("A test step has failed: " + ee, "Expected all test steps to pass.");
		}
	}
}
