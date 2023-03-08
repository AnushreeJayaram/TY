package tms.bird.testngPractise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tms.genericutility.misc.JavaUtility;
import com.tms.genericutility.webactions.SeleniumUtility;

public class TestNGPractice
{
	public SeleniumUtility seleniumUtil;
	public JavaUtility javaUtil;
	public WebDriver driver;
	
	@AfterSuite
	public void suiteTearDown()
	{
		System.out.println("AfterSuite");
	}
	
	@AfterTest
	public void testTearDown()
	{
		System.out.println("AfterTest");
	}
	
	@AfterClass
	public void classTearDown()
	{
		System.out.println("AfterClass");
	}
	
	@AfterMethod
	public void methodTearDown()
	{
		System.out.println("AfterMethod");
	}
	
	@BeforeSuite
	public void suiteSetup()
	{
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void testSetup()
	{
		System.out.println("BeforeTest");
		seleniumUtil = new SeleniumUtility();
		javaUtil = new JavaUtility();
		driver = seleniumUtil.launchBrowser("chrome");
	}
	
	@BeforeClass
	public void classSetup()
	{
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void methodSetup()
	{
		System.out.println("BeforeMethod");
	}
	
	@Test
	public void test()
	{
		System.out.println("Test");
	}
//	Order of execution
/*	BeforeSuite
	BeforeTest
	BeforeClass
	BeforeMethod
	Test
	AfterMethod
	AfterClass
	AfterTest
	AfterSuite
*/	
}
