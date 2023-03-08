package com.tms.genericutility.webactions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains generic methods of javaScript 
 * @author Anu H Jayaram Vivek
 *
 */
public class JavaScriptUtility {
	
	/**
	 * Declaring JavascriptExecutor globally
	 */
	JavascriptExecutor jse ;
	
	/**
	 * Typecating JavascriptExecutor globally, as it is required for all methods in this utility
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver)
	{
		jse = (JavascriptExecutor)driver;
	}

	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction()
	{
		
		jse.executeScript("window.scrollBy(0, 500)","");
	}
	
	/**
	 * This method will scroll up to the particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollUptoParticularWebElement( WebElement element)
	{
		
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	/**
	 * This method will scroll up to the last of the web page
	 * @param driver
	 */
	public void scrollDown()
	{
		
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	/**
	 * This method will scroll up to the starting of the web page
	 * @param driver
	 */
	public void scrollUp()
	{
		jse.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}
	
	
	/**
	 * This method will click on particular web element
	 * @param driver
	 * @param element
	 */
	public void click(WebElement element)
	{
	
		jse.executeScript("arguments[0].click();", element);
	}
	
	/**
	 * This method will pass the data into text field
	 * @param driver
	 * @param element
	 * @param data
	 */
	public void sendKeys( WebElement element, String data)
	{
		
		jse.executeScript("arguments[0].value=arguments[1];", element, data);
	}

	/**
	 * This method will navigate the application on web browser
	 * @param driver
	 * @param url
	 */
	public void launchApplication( String url)
	{
	
		jse.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * This method will scroll untill a particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction( WebElement element)
	{
		
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
	
	/**
	 * This method will refresh the web page 
	 * @param driver
	 */
	public void refresh()
	{
		
		jse.executeScript("history.go(0)");
	}
	
	/**
	 * This method will get the title of web page
	 * @param driver
	 * @return
	 */
	public Object getTitle()
	{
		
		return jse.executeScript("return document.title");
	}
	
	/**
	 * This method will get the URL of web page
	 * @param driver
	 */
	public void getUrl()
	{
		
		jse.executeScript("return document.URL");
	}


	public void highlight(WebElement element)
	{
		jse.executeScript("arguments[0].setAttribute('style','border:6px dotted red;');", element);
	}
}