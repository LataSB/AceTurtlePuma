package com.puma.UtillLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage implements IAutoConst {
	public WebDriver driver;
	public void verifyTitle(WebDriver driver,String title)
	{
	
		String ETitle=driver.getTitle();
		Reporter.log(ETitle, true);
		try
		{
			Assert.assertEquals(title, ETitle);
			Reporter.log("Expected title is matching with Actual title", true);
		}
		catch (Exception e) {
			Reporter.log("Actuall title is not matching with Expected title", true);
		}
		
	}
	public void verifyElement(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, ETO);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("The element is visible", true);
		}
		catch (Exception e) {
			Reporter.log("Element still not visible after 50000 ms", true);
		}
	}
	public void VerifyElementIsClickable(WebDriver driver,WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, ETO);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log("The element is clickable", true);
			element.click();
		}
		catch (Exception e) {
			Reporter.log("Element is still not clickable after 50000 ms", true);
		}
	}

}
