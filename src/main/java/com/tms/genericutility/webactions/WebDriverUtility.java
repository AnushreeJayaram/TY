package com.tms.genericutility.webactions;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains generic methods to perform all web driver related actions 
 * @author Zero Touch
 *
 */
public class WebDriverUtility {
	
	private WebDriver driver;

	/**
	 * This method will give full screen of window
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}

//	public WebDriver launchBrowser(String browser, String... s)
	public WebDriver launchBrowser(String browser, @Optional String s)
	{
		
		switch(browser)
		{
		case "chrome": 
//						if(s[0].equalsIgnoreCase("option"))
						if(s!=null)
			{
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--disable-notification");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(opt);
				break;				
			}
		
			else
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;	
			}
		
		case "firefox": 
//							if(s[0].equalsIgnoreCase("option"))
							if(s!=null)
			
		{
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--disable-notification");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(opt);
			break;				
		}
	
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;	
		}
		
		case "edge" : WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		
		default: System.out.println("Enter proper key");	
		
		}
		
		return driver;
	}
	/**
	 * This method will fetch the title of the web page
	 * @param driver
	 * @return 
	 */
	public String getTitleOfWebPage(WebDriver driver)
	{
		return driver.getTitle();
	}
	/**
	 * This method will maximize the window when its called
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method will open the application of browser
	 * @param driver
	 * @param url
	 */
	public void getApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}

	/**
	 * This method will fetch the current url of web page
	 * @param driver
	 * @return 
	 */
	public String getUrlOfWebpage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}

	/**
	 * This method will fetch the source code of web page
	 * @param driver
	 * @return 
	 */
	public String getSourceCodeOfWebpage(WebDriver driver)
	{
		return driver.getPageSource();
	}

	/**
	 * This method will close only the main window
	 * @param driver
	 */
	public void closeMainWindow(WebDriver driver)
	{
		driver.close();
	}

	/**
	 * This method will close all the window
	 * @param driver
	 */
	public void closeAllWindow(WebDriver driver)
	{
		driver.quit();
	}

	/**
	 * This method will customize the width and height of browser
	 * @param driver
	 * @param width
	 * @param height
	 * @return 
	 */
	public void setSizeOfBrowser(WebDriver driver, int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
	}

	/**
	 * This method will customize the x and y co-ordinate of browser
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void setPositionOfBrowser(WebDriver driver, int x, int y)
	{
		driver.manage().window().setPosition(new Point(x, y));
	}

	/**
	 * This method will remove the value present in web element
	 * @param element
	 */
	public void clearElement(WebElement element)
	{
		element.clear();
	}

	/**
	 * This method will return tag name of web element
	 * @param element
	 * @return 
	 */
	public String getTagNameOfElement(WebElement element)
	{
		return element.getTagName();
	}

	/**
	 * This method will wait for entire page to load for 20 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is use to wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This method will wait for element to be selected
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeSelected(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * This method will wait for the text to be present in element
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}


	/**
	 * This is a custom wait for a second to wait for elemnet to become clickable
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitForSecond(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<10)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method will handle dropdown based on index value
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown based on value
	 * @param element
	 * @param value
	 * @return
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 *  This method will handle dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will give all the options present in dropdown
	 * @param element
	 * @return
	 */
	public List<WebElement> getAllOptionsOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel.getOptions();
	}

	/**
	 * This method will return true if dropdown is multiselect
	 * @param element
	 * @return
	 */
	public boolean checkForMultiSelectDDropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel.isMultiple();
	}

	/**
	 * This method will deselect the option by index
	 * @param element
	 * @param index
	 */
	public void deSelectOptionInDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	/**
	 * This method will deselect the option by value
	 * @param element
	 * @param value
	 */
	public void deSelectOptionInDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}

	/**
	 * This method will deselect the option by visible text
	 * @param text
	 * @param element
	 */
	public void deSelectOptionInDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}

	/**
	 * This method will deselect all option in dropdown
	 * @param element
	 */
	public void deSelectOptionInDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}

	/**
	 * This method will give all the selected options of the dropdown
	 * @param element
	 */
	public void getAllSelectedOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.getAllSelectedOptions();
	}

	/**
	 * This method will give the only first selected options of the dropdown
	 * @param element
	 */
	public void getFirstSelectedOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.getFirstSelectedOption();
	}

	/**
	 * This method will perform mouse hover action 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform mouse hover action based on offset
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}

	/**
	 * This method will perform right click randomely on webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will perform right click on a particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform double click randomly on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will perform double click on particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will click randomly on web page
	 * @param driver
	 */
	public void clickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.click().perform();
	}

	/**
	 * This method will click on particular web element
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	/**
	 * This method will click and hold randomly on web page
	 * @param driver
	 */
	public void clickAndHoldAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.clickAndHold().perform();
	}

	/**
	 * This method will click and hold the particular web element
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	/**
	 * This method will release the holded web page
	 * @param driver
	 */
	public void releaseAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.release().perform();
	}

	/**
	 * This method will release the holded particular web element
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.release(element).perform();
	}

	/**
	 * This method will drag and drop from source element to target element
	 * @param driver
	 * @param srcElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement tarElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, tarElement).perform();
	}

	/**
	 * This method will drag the web element for the required x and y co-ordinate
	 * @param driver
	 * @param srcElement
	 * @param x
	 * @param y
	 */
	public void dragAndDropByAction(WebDriver driver, WebElement srcElement, int x, int y)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(srcElement, x, y);
	}

	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	Robot r;
	public void pressEnterKey()
	{
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame based on name or id
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}

	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 500)","");
	}

	/**
	 * This method will scroll up to the particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollUptoParticularWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method will scroll up to the last of the web page
	 * @param driver
	 */
	public void scrollUptoLastOfWebpage(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	/**
	 * This method will click on particular web element
	 * @param driver
	 * @param element
	 */
	public void clickUsingJavaScript(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will pass the data into text field
	 * @param driver
	 * @param element
	 * @param data
	 */
	public void passDataUsingJavaScript(WebDriver driver, WebElement element, String data)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=arguments[1];", element, data);
	}

	/**
	 * This method will navigate the application on web browser
	 * @param driver
	 * @param url
	 */
	public void navigateApplicationUsingJavaScript(WebDriver driver, String url)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method will scroll untill a particular element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);

	}

	/**
	 * This method will refresh the web page 
	 * @param driver
	 */
	public void refreshWebpageUsingJavaScript(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("history.go(0)");
	}

	/**
	 * This method will get the title of web page
	 * @param driver
	 * @return
	 */
	public Object getTitleUsingJavaScript(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		return jse.executeScript("return document.title");
	}

	/**
	 * This method will get the URL of web page
	 * @param driver
	 */
	public void getUrlUsingJavaScript(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("return document.URL");
	}

	/**
	 * This method will take screenshot and save it in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String taketheScreenShot(WebDriver driver, String screenShotName)
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\ScreenShot\\"+screenShotName+".png");
		try {
			Files.copy(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return trg.getAbsolutePath(); //used for extent reports
	}

	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> allWindows=driver.getWindowHandles();
		for(String indWindow:allWindows)
		{
			String currentWinTitle = driver.switchTo().window(indWindow).getTitle();
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}

	/**
	 * This method will handle notifications popup
	 * @param driver
	 */
	public void notificationPopup(WebDriver driver)
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
	}
}