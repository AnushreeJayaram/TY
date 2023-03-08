package tms.bird.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SetOrModifyDataIntoDatabase 
{
	/*   Generic method 	
	public void setOrModifyDataIntoDatabase(String url, String username, String password, String sql)
	{
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		
		Connection con = DriverManager.getConnection(url,username,password);
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(sql);
		
		if(result==1)
		{
			System.out.println("Data added successfully");
		}
		con.close();
	}
	*/

	/*
	public static void main(String[] args)   // throws SQLException 
//	use either throws or try catch
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

			//		Step4 -> execute query
//			int result = statement.executeUpdate("create table Kantara( "firstName varchar(30)", "lastName varchar(30)", "rollNo varchar(20)","DOB date");");		// ResultSet is Interface

			//		Step5 iterate data and verify or fetch 

			if(result==1)
			{
				System.out.println("Data added successfully");
			}
			
		}

		finally 
		{

			//		 Step6--> close connection
			connection.close();
			System.out.println("connection closed");
		}

	}
*/
}
