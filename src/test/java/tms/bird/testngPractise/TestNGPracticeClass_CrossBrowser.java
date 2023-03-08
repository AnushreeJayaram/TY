package tms.bird.testngPractise;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.genericutility.BaseClass.BaseClassPractice;

import io.github.bonigarcia.wdm.WebDriverManager;

//final implementation

public class TestNGPracticeClass_CrossBrowser extends BaseClassPractice
{

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.get("google");
	}
}
