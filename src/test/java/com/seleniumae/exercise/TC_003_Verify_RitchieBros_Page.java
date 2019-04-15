package com.seleniumae.exercise;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.seleniumae.PageObjects_rbAuction.RB_Auction_Page;
import com.seleniumae.settings.BaseTest;
import com.seleniumae.settings.WebConstants;

public class TC_003_Verify_RitchieBros_Page extends BaseTest {
	WebDriver driver;
	
  @Test
  public void Richie_Bros_Site() {
	  try {
			System.out.println("Verify_that_Google_Page_Loads_Successfully_TEST() test case...");
			// WebDriver driver;

		
			BaseTest base = new BaseTest();
			RB_Auction_Page ritchie = new RB_Auction_Page(driver);

			// 1. Open Browser Chrome
			// 2. Go TO: "https://www.rbauction.com
			base.startDriver("firefox", "https://www.rbauction.com");
			WebConstants.SetDelay(3000);
			
			// 3. Select Search Menu
			ritchie.clickSearchMenu();
			
			//4. Select Category : Excavator
			ritchie.selectCategory("Excavators");
			
			//5. Select Make Type: CATERPILLAR
			ritchie.selectMake("CATERPILLER");
			
			//6 Minimum Year 
			ritchie.selectMinYear("2016");
			//5. Maximum year
			ritchie.selectMaxYear("2019");
			
			//7. Verify the List
			ritchie.verifyListOfExperience();
			
			// FINISH and CLEAN UP
			System.out.println("Finished with Verify_that_Ritchie_Bros_Passed_TEST() test run!");

		} catch (Exception ee) {
			System.out.println("There was a problem: ");
			ee.printStackTrace();
			// Intentionally fail the test if any step triggers an exception
			Assert.assertEquals("A test step has failed: " + ee, "Expected all test steps to pass.");
		}
	}
  }

