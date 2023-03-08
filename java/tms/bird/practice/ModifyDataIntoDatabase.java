package tms.bird.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataIntoDatabase {

	public static void main(String[] args) throws SQLException {

//		Step1: create a instance for Driver --> register driver to the JDBC 
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);

			//		DriverManager.registerDriver(new Driver());

		Connection connection=null;

//		Step 2: get connection -> dburl,un, pwd jdbc:mysql://localhost:3306/mydb

		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");


//		Step3: create statement 
			Statement statement = connection.createStatement();

//		Step4 -> execute query
			int result = statement.executeUpdate("insert into employee values(3000,'Krishna',60999,2206328,'Mandya');");

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

}
