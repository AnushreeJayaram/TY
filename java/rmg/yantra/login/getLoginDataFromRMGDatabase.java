

package rmg.yantra.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class getLoginDataFromRMGDatabase {

	public static void main(String[] args) throws SQLException 
	{

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
				String projName = result.getString("project_name");
		
				if(projName.equals("Selenium Yantra"))
				System.out.println("data is present in database");
			}
			
		}

		finally 
		{
			//		 Step6--> close connection
			connection.close();
			System.out.println("connection closed");
		}

	}

}
