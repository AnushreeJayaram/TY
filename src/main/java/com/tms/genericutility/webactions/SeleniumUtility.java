package com.tms.genericutility.webactions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.tms.genericutility.misc.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains generic methods of Selenium utility
 * @author Anu H Jayaram Vivek
 *
 */
public class SeleniumUtility {

	
		private WebDriver driver;
		
//			public SeleniumUtility(WebDriver driver){
//				
//			this.driver=driver;
//		}
		
		/**
		 * This method is used to execute the program in different browser
		 * @param browser
		 * @return
		 */
		public WebDriver launchBrowser(String browser)
		{
			switch(browser)
			{
			case "chrome": WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
							break;
			
			case "firefox": WebDriverManager.firefoxdriver().setup();
							driver = new FirefoxDriver();
							break;
			
			case "ie": 	WebDriverManager.iedriver().setup();
							driver = new InternetExplorerDriver();
							break;
			
			case "edge": 	WebDriverManager.edgedriver().setup();
							driver = new EdgeDriver();					
							break;
			
			
			default : 		System.out.println("Enter propery key");
							break;
			
			}
			
			return driver;
			
		}
		
		/**
		 * This method is used to maximize the browser window
		 */
		public void maximizeBrowser()
		{
			driver.manage().window().maximize();
		}
		
		public void reSizeBrowser(int width,int height)
		{
			driver.manage().window().setSize(new Dimension(width, height));
		}
		
		/**
		 * This method is used to apply implicit wait and launch application
		 * @param url
		 */
		public void launchApplication(String url)
		{
			driver.get(url);
		}
		
		/**
		 * 
		 * @param width
		 * @param height
		 */
		public void resizeBrowser(int width,int height)
		{
			driver.manage().window().setSize(new Dimension(width,height));
		}
		
		/**
		 * This method is used to get Screenshot of Web Pages
		 * @param testScriptName
		 * @param javaUtil
		 * @return
		 * @throws IOException
		 */
		public String getScreenshot(String testScriptName, JavaUtility javaUtil) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File("./screenshot/pages/"+testScriptName+"_"+javaUtil.getCurrentDateTime()+".png");
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath();
		}
		
		
		/**
		 * This method is used to get Screenshot of Web elements
		 * @param element
		 * @param elementName
		 * @param javaUtil
		 * @return
		 * @throws IOException
		 */
		public String getScreenshot(WebElement element, String elementName, JavaUtility javaUtil) throws IOException
		{
			
			File src = element.getScreenshotAs(OutputType.FILE);
			File dst = new File("./screenshot/elements/"+elementName+"_"+javaUtil.getCurrentDateTime()+".png");
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath();
		}
		
		/**
		 * This method is used to take screenshot in encrypted way 
		 * @return
		 */
		public String getScreenshot()
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			String path = ts.getScreenshotAs(OutputType.BASE64);
			return path;
		}
		
		
		
		
		/**
		 *  This method is used to close  all the  tabs
		 */
		public void closeBrowser()
		{
			driver.quit();
		}
		
		
		/**
		 * This method is used to close the current tab
		 */
		public void closeTab()
		{
			driver.close();
		}
	}


