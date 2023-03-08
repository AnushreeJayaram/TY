//insert data in database, check it in database. Then verify whether inserted data is present in UI

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

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

//insert or create or add project into DB, validate in DB that whether project is added
//validate in UI , whether project is added or not


public class SC02_RMGDatabaseCreate 
{
	public static void main(String[] args) throws SQLException  
	{
		String p_id = "TY_PROJ_"+ new Random().nextInt(1000);
		String actProjectName ="Selenium Yantra"+ new Random().nextInt(1000);

		Connection connection = null;

		try 
		{

			//		Step1: create a instance for Driver --> register driver to the JDBC

			Driver dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);											// DriverManager is class

			//		Step 2: get connection -> url,un, pwd jdbc:mysql://localhost:3306/mydb



			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");


			//		Step3: create statement 
			Statement statement = connection.createStatement();							

			//		Step4 -> execute query
			int result = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size) values('"+p_id+"','Anu','08/02/2023','"+actProjectName+"','Created',3); ");


			//			or insert can be added like below also
			//			"insert into project(project_id,created_by,created_on,project_name,status,team_size) "values('"+p_id+"','Anu','08/02/2023','"+actProjectName+"','Created',3); ");



			//		Step5 iterate data and verify or fetch 
			if(result==1)
				System.out.println("project added successfully");



			ResultSet result2 = statement.executeQuery("select * from project");		


			//		Step5 iterate data and verify or fetch 
			while(result2.next())
			{
				String projectName = result2.getString("project_name");  // project_name column from the project database

				if(projectName.equals(actProjectName))
					System.out.println("data is present in database");
				break;
			}

		}

		catch(Exception e)
		{

		}

		finally 
		{
			//		 Step6--> close connection
			connection.close();
			System.out.println("connection closed");
		}

		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://rmgtestingserver:8084/welcome");

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();


		driver.findElement(By.linkText("Projects")).click();

		List<WebElement> allProjectName = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

		for(WebElement projectName:allProjectName)
		{
			String expProjectName = projectName.getText();
			if(expProjectName.equals(actProjectName))
			{
				System.out.println(expProjectName+"    Project added successfully");
				break;
			}
		}

	}



}

