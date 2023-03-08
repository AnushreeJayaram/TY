package com.tms.genericutility.webactions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * This class contains generic methods of Actions class
 * @author Anu H Jayaram Vivek
 *
 */

public class InteractionUtility {
	private Actions act;

	/**
	 * This constructor is use to initialize the driver of Actions class
	 * @param driver
	 */
	public InteractionUtility(WebDriver driver)
	{
		act = new Actions(driver);
	}
	
	/**
	 * This method will perform mouse hover action 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebElement element)
	{
		act.moveToElement(element).perform();
	}
	

	/**
	 * This method will perform mouse hover action based on offset
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebElement element, int x, int y)
	{
		act.moveToElement(element, x, y).perform();
	}
	
	/**
	 * This method will perform right click randomely on webpage
	 * @param driver
	 */
	public void rightClickAction()
	{
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebElement element)
	{
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click randomly on web page
	 * @param driver
	 */
	public void doubleClickAction()
	{
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebElement element)
	{
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will click randomly on web page
	 * @param driver
	 */
	public void clickAction()
	{
		act.click().perform();
	}
	
	/**
	 * This method will click on particular web element
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebElement element)
	{
		act.click(element).perform();
	}
	
	/**
	 * This method will click and hold randomly on web page
	 * @param driver
	 */
	public void clickAndHoldAction()
	{
		act.clickAndHold().perform();
	}
	
	/**
	 * This method will click and hold the particular web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebElement element)
	{
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will release the holded web page
	 * @param driver
	 */
	public void releaseAction()
	{
		act.release().perform();
	}
	
	/**
	 * This method will release the holded particular web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebElement element)
	{
		act.release(element).perform();
	}
	
	/**
	 * This method will drag and drop from source element to target element
	 * @param driver
	 * @param srcElement
	 */
	public void dragAndDropAction(WebElement srcElement, WebElement tarElement)
	{
		act.dragAndDrop(srcElement, tarElement).perform();
	}
	
	/**
	 * This method will drag the web element for the required x and y co-ordinate
	 * @param driver
	 * @param srcElement
	 * @param x
	 * @param y
	 */
	public void dragAndDropByAction(WebElement srcElement, int x, int y)
	{
		act.dragAndDropBy(srcElement, x, y);
	}

	/**
	 * This method will perform for enter operation
	 */
	public void enter()
	{
		act.keyDown(Keys.ENTER).perform();
	}
}