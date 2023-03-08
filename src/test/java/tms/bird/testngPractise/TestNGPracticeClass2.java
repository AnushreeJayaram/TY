package tms.bird.testngPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.genericutility.BaseClass.BaseClassPractice;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGPracticeClass2 extends BaseClassPractice
{
	
	@Test(groups="sanity")
	public void test1()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.google.com");
		
	}
	
	@Test(groups="sanity")
	public void test2()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.gmail.com");
		Assert.fail();
	}
	
	@Test(groups="sanity")
	public void test3()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.flipkart.com");
		
	}

}
