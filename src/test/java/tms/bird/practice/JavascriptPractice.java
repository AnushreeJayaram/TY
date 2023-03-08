package tms.bird.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptPractice {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("window.location='http://rmgtestingserver:8888/'");
		WebElement userName = driver.findElement(By.name("user_name"));
		WebElement userPassword = driver.findElement(By.name("user_password"));
		WebElement login =  driver.findElement(By.id("submitButton"));
		
		js.executeScript("arguments[0].value=arguments[1]", userName,"admin");
		js.executeScript("arguments[0].value=arguments[1]", userPassword,"admin");
		js.executeScript("arguments[0].click()", login);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");		// near document it is +
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");		// near document it is -
		
		
		
	}

}
