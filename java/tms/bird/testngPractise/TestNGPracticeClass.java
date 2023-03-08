package tms.bird.testngPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

// A=65 Z=90, a=97 z=122, 0=48, 9=57

//@Listeners(com.tyss.genericUtility.Retry,SetTestParameter.class)

public class TestNGPracticeClass 
{
	WebDriver driver;
	
	@BeforeMethod 
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@Test(groups="sanity")
	public void test1()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.google.com");
		
	}

}
