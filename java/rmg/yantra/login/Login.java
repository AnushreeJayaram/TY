package rmg.yantra.login;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login 
{
		
	public static void main(String[] args) throws InterruptedException 
	{
		
	String projName = "Selenium Yantra"+ new Random().nextInt(1000);
		
	WebDriverManager.chromedriver().setup();	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://rmgtestingserver:8084/welcome");
	
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	driver.findElement(By.linkText("Projects")).click();
	
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	
//	to check in aplln -> [name='projectName']
	
	driver.findElement(By.name("projectName")).sendKeys(projName);
	driver.findElement(By.name("createdBy")).sendKeys("Anu");
	
	WebElement sListBox = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name='status']"));
	
	Select s = new Select(sListBox);
	s.selectByVisibleText("Created");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
//	List<WebElement> tablevalues = driver.findElements(By.xpath("//table/tbody/tr/td"));  
//	for changing table dynamically use above one
	
	List<WebElement> tablevalues = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
	
	for(WebElement value:tablevalues)
	{
		String text = value.getText();
		if(text.equals(projName))
			System.out.println(projName+"    Project added successfully");
	}

	}
}
	