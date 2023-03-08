package tms.bird.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
//		Step1: Convert the physical file into java readable object
		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData/CommonData.properties");
		
//		Step2: create object for properties class
		Properties prop = new Properties();
		
//		Step3: load all keys
		prop.load(fis);
		
//		Step4 -> Fetch data
		String password = prop.getProperty("password");
		System.out.println(password);
		
//		Step5: close input Stream
		fis.close();
		prop.clear();

	}

}
