package com.tms.genericutility.externalfileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.tms.genericutility.enums.PropertyKey;


/**
 * This class contains reusable methods for handle propertyFile
 * @author Anu H Jayaram Vivek
 *
 */

public class PropertyFileUtility 
{
		
		private Properties prop;

//		make use of try catch block, instead of throws
		
		
		/**
		 * This constructor will initialize the property file
		 * @param filePath
		 */
		
//		public PropertyFileUtility(String filePath) throws IOException			// In mock we have to write using throws Exception
//		{
//				FileInputStream fisProperty = null;
//				fisProperty = new FileInputStream(filePath);
//				prop = new Properties();	
//				prop.load(fisProperty);
//				fisProperty.close();
//		}
		
		public PropertyFileUtility(String filePath)  
		{
			FileInputStream fisProperty = null;
			try {
				fisProperty = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			prop = new Properties();
			
			try {
				
				prop.load(fisProperty);
				fisProperty.close();
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		
		
		/**
		 * This constructor is used to createobject for class
		 */
		public PropertyFileUtility()  
		{
		
		}
		
		
		/**
		 * This method is used to initialize Property File
		 * @deprecated new PropertyUtility(String filePath)
		 * @param filePath
		 * @throws IOException
		 */
		@Deprecated
		
		public void intiallizePropertyFileUtility(String filePath)
		{
		FileInputStream fisProperty = null;
		try {
			fisProperty = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fisProperty);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fisProperty.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		public String getPropertyData(PropertyKey key)
		{
			String keyString = key.name().toLowerCase();
			String value = prop.getProperty(keyString,"please give proper key '"+keyString+"'").trim();
			return value;
		}

	

}
