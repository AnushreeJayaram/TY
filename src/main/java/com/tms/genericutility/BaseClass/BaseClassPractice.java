package com.tms.genericutility.BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tms.genericutility.misc.JavaUtility;
import com.tms.genericutility.webactions.SeleniumUtility;

/**
 * This class is used for BaseClassPractice using TestNG Annotations
 * @author Anu H Jayaram Vivek
 *
 */
public class BaseClassPractice
{
	public SeleniumUtility seleniumUtil;
	public JavaUtility javaUtil;
	public WebDriver driver;
	
	/**
	 * The method suiteTearDown will execute AfterSuite 
	 */
	@AfterSuite
	public void suiteTearDown()
	{
		System.out.println("AfterSuite");
	}
	
	/**
	 * The method testTearDown will execute AfterTest 
	 */
	@AfterTest
	public void testTearDown()
	{
		System.out.println("AfterTest");
		driver.close();
	}
	
	/**
	 * The method classTearDown will execute AfterClass 
	 */
	@AfterClass
	public void classTearDown()
	{
		System.out.println("AfterClass");
	}
	
	/**
	 * The method methodTearDown will execute AfterMethod 
	 */
	@AfterMethod
	public void methodTearDown()
	{
		System.out.println("AfterMethod");
	}
	
	/**
	 * The method suiteSetup will execute before BeforeSuite Annotation 
	 */
	@BeforeSuite
	public void suiteSetup()
	{
		System.out.println("BeforeSuite");
	}
	
	/**
	 * The method testSetup will execute before BeforeTest Annotation 
	 */
	@BeforeTest
	public void testSetup()
	{
		System.out.println("BeforeTest");
		seleniumUtil = new SeleniumUtility();
		javaUtil = new JavaUtility();
		driver = seleniumUtil.launchBrowser("chrome");
	}
	
	/**
	 * The method classSetup will execute before BeforeClass Annotation 
	 */
	@BeforeClass
	public void classSetup()
	{
		System.out.println("BeforeClass");
	}
	
	/**
	 * The method methodSetup will execute before BeforeMethod Annotation
	 */
	@BeforeMethod
	public void methodSetup()
	{
		System.out.println("BeforeMethod");
	}
	
	
}
