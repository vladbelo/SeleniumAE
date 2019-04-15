package com.seleniumae.PageObjects_rbAuction;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.TestException;


import com.seleniumae.settings.WebConstants;



public class RB_Auction_Page {
	
	private WebDriver driver;

	// static Assert hardAssert = new Assert();

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public RB_Auction_Page(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, WebConstants.IMPLICITLY_WAIT_TIMEOUT);
	}

	/**
	 * This is Ritchies Bros Page Objects
	 */
	private static final String SEARCHBUTTON = "//*[@id=\"adv-toggle-down\"]";
	@FindBy(xpath =  SEARCHBUTTON )
	private WebElement SearchDownButton;

	private static final String CATEGORY = "//*[@id=\"yui_3_4_0_1_1555334512048_43\"]";
	@FindBy(xpath = CATEGORY)
	private WebElement CategorySelectValue;


	private static final String YEARMIN = "//*[@id=\"adv-year-min\"]";
	@FindBy(xpath = YEARMIN )
	private WebElement YearMins;
	
	private static final String YEARMAX= "//*[@id=\"adv-year-max\"]";
	@FindBy(xpath = YEARMAX )
	private WebElement YearMaxs; 
	
	private static final String MAKE = "//*[@id=\"adv-make\"]";
	@FindBy(xpath = MAKE)
	private WebElement Makes;
	
	private static final String LISTRESULTS = "//*[@id=\"yui_3_4_0_1_1555339094505_34\"]/div[3]/div[3]";
	@FindBy(xpath = LISTRESULTS)
	private List<WebElement> ListResultss;
	
	
	public void clickSearchMenu() throws TestException {
		WebConstants.waitForElementToLoad(driver, SearchDownButton, 30);
		Assert.assertTrue(SearchDownButton.isEnabled(), "Search Down Button is not Accessible");
		SearchDownButton.click();
		System.out.println("Category Button Selected");
		WebConstants.SetDelay(5000);
	}
	
	public void selectCategory(String exc) throws TestException {
		WebConstants.waitForElementToLoad(driver,CategorySelectValue, 30);
		Assert.assertTrue(CategorySelectValue.isEnabled(), " Category Buttons is not enabled");
		CategorySelectValue.click();
		WebConstants.SetDelay(2000);
		// Selecting Excavator
		Select dropdown = new Select(CategorySelectValue);  
		dropdown.selectByVisibleText(exc);
		System.out.println("Category Button Selected");
		WebConstants.SetDelay(5000);
	}
	
	//Selecting Min Year 
	public void selectMinYear(String type) {
		WebConstants.waitForElementToLoad(driver,YearMins, 30);
		System.out.println("Select Min Year");
		YearMins.click();
		YearMins.sendKeys(type);
		System.out.println("Success Passed");

	}
	
	//Selecting Max Year
	public void selectMaxYear(String type) {
		WebConstants.waitForElementToLoad(driver, YearMaxs, 30);
		System.out.println("Select Max Yeart");
		 YearMaxs.click();
		 YearMaxs.sendKeys(type);
		System.out.println("Success Passed");

	}
	//Select Make
	public void selectMake(String type) {
		WebConstants.waitForElementToLoad(driver, Makes, 30);
		System.out.println("Select Make");
		Makes.click();
		Makes.sendKeys(type);
		System.out.println("Success Passed");

	}
	//Verifying Lists of Experience
	public void verifyListOfExperience(){
	System.out.println("verifying list of CaterPillar items is displayed or not...");
	Assert.assertEquals(this.ListResultss.size()>0,"Experience List is not displayed");
	System.out.println("List of experience is displayed");
	
	}
}
