// insert or create or add project into UI, validate in UI whether project is added
// validate in DB , whether project is added or not


package rmg.yantra.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SC01_LoginGetLoginDataFromRMGDatabase 
{
	public static void main(String[] args) throws InterruptedException, SQLException 
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

		//		Step1: create a instance for Driver --> register driver to the JDBC 
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);											// DriverManager is class

		//		Step 2: get connection -> url,un, pwd jdbc:mysql://localhost:3306/mydb

		Connection connection = null;
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");


			//		Step3: create statement 
			Statement statement = connection.createStatement();							

			//		Step4 -> execute query
			ResultSet result = statement.executeQuery("select * from project");		


			//		Step5 iterate data and verify or fetch 
			while(result.next())
			{
				String projName1 = result.getString("project_name");  // project_name column from the project database

				if(projName1.equals(projName))
					System.out.println("data is present in database");
			}

		}

		finally 
		{
			//		 Step6--> close connection
			connection.close();
			driver.quit();
			System.out.println("connection closed");
		}

	}



}

//Null pointer Exception-> if connection is not done , then we get this exception

