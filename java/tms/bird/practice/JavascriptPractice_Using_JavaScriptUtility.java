package tms.bird.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tms.genericutility.webActions.JavaScriptUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptPractice_Using_JavaScriptUtility {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		JavaScriptUtility javascriptUtil = new JavaScriptUtility(driver);
		javascriptUtil.launchApplication("http://rmgtestingserver:8888/");
		
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement userPassword = driver.findElement(By.name("user_password"));
		WebElement login =  driver.findElement(By.id("submitButton"));
		
		javascriptUtil.sendKeys(userName, "admin");
		javascriptUtil.sendKeys(userPassword, "admin");
		javascriptUtil.click(login);
		
//		js.executeScript("arguments[0].value=arguments[1]", userName,"admin");
//		js.executeScript("arguments[0].value=arguments[1]", userPassword,"admin");
//		js.executeScript("arguments[0].click()", login);
//		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		javascriptUtil.scrollDown();
		
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");		// near document it is +
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		javascriptUtil.scrollUp();
		
//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");		// near document it is -
		
		WebElement ele = driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities')]"));
		javascriptUtil.scrollUptoParticularWebElement(ele);

	}

}
