package com.seleniumae.settings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebConstants {

	public final static String ENV_STAGE = "STAGE";
	public final static String ENV_PROD = "PROD";
	public final static String ENV_LATEST = "LATEST";
	public final static String ENV_SOFT_LAUNCH = "SOFTLAUNCH";

	public final static long IMPLICITLY_WAIT_TIMEOUT = 10;

	public final static int timeThreeSecondsinMS = 3000;
	public final static int timeFiveSecondsinMS = 5000;
	public final static int timeSixSecondsinMS = 6000;
	public final static int timeEightSecondsinMS = 8000;
	public final static int timeThirtySecondsinSEC = 30;
	public final static int timeTwentySecondsinSEC = 20;
	public final static int timeFivtySecondsinSEC = 50000;
	public final static int timeThirtySecondsinSECONDS = 30000;
	public final static int timeTenSecondsinMS = 10000;
	public final static int timeSevenSecondsinMS = 7000;
	public final static int fifteenSecondsinMS = 15000;

	WebDriver driver;

	static public void waitForElementToLoad(WebDriver aDriver, WebElement anElement, int timeInSecondsToWait) {
		// throws TimeoutException
		boolean staleFlag = false;
		do {
			if (staleFlag)
				staleFlag = false;

			try {
				WebDriverWait wait = new WebDriverWait(aDriver, timeInSecondsToWait);
				wait.until(ExpectedConditions.elementToBeClickable(anElement));
			} catch (NoSuchElementException e) {
				// Log.log( aDriver ).info( "Detected stale elements" );
				staleFlag = true;
				SetDelay(1000);
			}
		} while (staleFlag);

	}

	/**
	 * SetDelay
	 * 
	 * @param miliSeconds
	 */
	public static void SetDelay(int miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			System.out.println("An error happened while in sleep");
		}
	}
	
	
	


	// Check the correct page is loaded.
	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
        	Assert.fail("Page did not Complete");
        }
	}
}
