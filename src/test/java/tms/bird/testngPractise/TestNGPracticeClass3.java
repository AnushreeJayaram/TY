package tms.bird.testngPractise;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.genericutility.BaseClass.BaseClassPractice;

import io.github.bonigarcia.wdm.WebDriverManager;

//final implementation

public class TestNGPracticeClass3 extends BaseClassPractice
{
	@BeforeMethod
	public void setup(Method m)
	{
		System.out.println(m.getName());
	}
	
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
