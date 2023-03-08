package com.tms.genericutility.webactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used for Wait Utility
 * @author Anu H Jayaram Vivek
 *
 */
public class WaitUtility 
{
	private WebDriverWait wait;
	private WebDriver driver;
	
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public WaitUtility(WebDriver driver, long timeout)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, timeout);
	}
	
	/**
	 * 
	 * @param milisecond
	 */
	public void pause(long milisecond)
	{
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public void waitForElementLoad(WebDriver driver,long timeout)
	{
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}


	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public void waitElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitUntilVisible(String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		
	}
	
	public void waitUntilClickable(String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		
	}
	
	public void waitUntilInvisible(String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
		
	}
	
	public void waitUntilInvisibleOfText(String xpath,String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementWithText((By.xpath(xpath)), text));
		
	}
	
	
	
	
}
