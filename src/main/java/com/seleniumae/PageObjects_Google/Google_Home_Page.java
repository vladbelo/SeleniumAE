package com.seleniumae.PageObjects_Google;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumae.settings.WebConstants;

public class Google_Home_Page {

	private WebDriver driver;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Google_Home_Page(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, WebConstants.IMPLICITLY_WAIT_TIMEOUT);
	}

	/**
	 * This is Google Page Page Objects
	 */
	private static final String SEARCHTEXT = "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input";
	@FindBy(xpath = SEARCHTEXT)
	private WebElement SearchText_Engine;

	private static final String GOOGLESEARCHBUTTON = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]";
	@FindBy(xpath = GOOGLESEARCHBUTTON)
	private WebElement Search_Buttons;

	private static final String SEARCHLINKS = "//*[@id=\"rso\"]/div/div";
	@FindBy(xpath = SEARCHLINKS)   
	private WebElement SearchLinks_Page;
	
	

	private static final String GOOGLETEXT = "//*[@id=\"hplogo\"]";
	@FindBy(xpath = GOOGLETEXT)
	private WebElement GoogleTextLogo;
	

	/**
	 * Google Page Methods
	 */
	public void verify_GoogleLogo() {
		WebConstants.waitForElementToLoad(driver,  GoogleTextLogo, 60);
		Assert.assertEquals( GoogleTextLogo.isEnabled(), true, "Google Logo Exist");
		System.out.println("Google Page Verified");
		WebConstants.SetDelay(1000);
	}

//  Selecting Google Search Text :
	public void selectSearchBox(String type) {
		System.out.println("Verify Search Engine Text");
		SearchText_Engine.click();
		SearchText_Engine.sendKeys(type);
		SearchText_Engine.sendKeys(Keys.ENTER);
		System.out.println("Success Passed");

	}
	
	public void verifyGoolgePage()
	{
	    new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains("Google"));
	    String home = "Google";
	    if (driver.getTitle().equalsIgnoreCase(home))
	        System.out.println("Its the correct Google Page");
	    else
	        System.out.println("Not a Goolge Page");
	}

	// Select First Link
	public void linkSearch(String check, int index) {
		List<WebElement> loops = driver.findElements(By.tagName("a"));
		java.util.Iterator<WebElement> i = loops.iterator();

		int j = 0;
		while (i.hasNext()) {
			WebElement loop = i.next();

			if (loop.getAttribute("Mobile Integration WorkGroup").contains(check)) {
				j++;
			}

			if (loop.getAttribute("Mobile Integration WokrGroup").contains(check) && j == index) {
				loop.click();
				break;
			}
		}

	}
}
