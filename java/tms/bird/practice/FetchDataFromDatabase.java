package tms.bird.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class getDataFromDatabase {

	public static void main(String[] args) throws SQLException 
		 {

		//		Step1: create a instance for Driver --> register driver to the JDBC 
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);											// DriverManager is class

		//		DriverManager.registerDriver(new Driver());

		Connection connection=null;														//Connection is Interface

		//		Step 2: get connection -> url,un, pwd jdbc:mysql://localhost:3306/mydb

		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");


			//		Step3: create statement 
			Statement statement = connection.createStatement();							//Statement is Interface

			//		78Step4 -> execute query
			ResultSet result = statement.executeQuery("select * from employee");		// ResultSet is Interface

			//		Step5 iterate data and verify or fetch 

			while(result.next())
			{
				String empName = result.getString("emp_name");
				int empid = result.getInt(1);
				System.out.println(empName +" "+empid);
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
