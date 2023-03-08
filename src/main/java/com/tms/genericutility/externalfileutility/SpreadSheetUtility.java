package com.tms.genericutility.externalfileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * To create SpreadSheetUtility / ExcelUtility
 * @author Anu H Jayaram Vivek
 *
 */

public class SpreadSheetUtility 
{		
	//	DataFormatter df = new DataFormatter();				
	private DataFormatter df;
	private Workbook wb;

	//	public Map<String, String> getData;

	/**
	 * Constructor is deprecated
	 */
	@Deprecated
	public SpreadSheetUtility()							
	{

	}

	/**
	 * This is parameterized constructor 
	 * @param fileName
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public SpreadSheetUtility(String fileName) 	
	{
		initialize(fileName);
	}



	/**
	 * To Fetch the data from Excel file using TestCaseName
	 * @param sheetName
	 * @param exptestCaseName
	 * @return
	 */
	public Map<String,String> getData(String sheetName,String exptestCaseName)
	{
		Sheet sheet = wb.getSheet(sheetName);    // import org.apache.poi.sl.usermodel.Sheet;

		int rowCount = sheet.getLastRowNum();		//index

		//		Map<String,String> map = new HashedMap<>();
		Map<String, String> map = new  HashMap<String,String>();
		for(int i=1; i<=rowCount;i++)
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(exptestCaseName))
			{
				for(int j=1; j<sheet.getRow(i).getLastCellNum();j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					if(key.equals(""))break;
					map.put(key, value);
				}
				break;
			}
		}

		return map;

	}

	/**
	 * This method is used to Fetch the data from Excel, based on keys
	 * @param sheetName
	 * @param exptestCaseName
	 * @param expectedKey
	 * @return
	 */

	public String getData(String sheetName,String expTestScriptName,String expectedKey)
	{
		Sheet sheet = wb.getSheet(sheetName);    // import org.apache.poi.sl.usermodel.Sheet;

		int rowCount = sheet.getLastRowNum();		//index

		String value="";
		int testScriptCounter=0;
		int keyCounter=0;


		for(int i=1; i<=rowCount;i++)
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{
				testScriptCounter++;

				for(int j=1; j<sheet.getRow(i).getLastCellNum();j++)
				{
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));

					if(key.equalsIgnoreCase(expectedKey))
					{
						keyCounter++;

						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}

				break;
			}
		}

		if(keyCounter==0)
		{
			if(testScriptCounter==0)
			{
				value = "please give proper testScript key'"+expTestScriptName+"' ";
			}
			else
			{
				value = "please give proper testScript key'"+expectedKey+"' ";
			}
		}
		//System.out.println("value fetched from excel==>"+ value);					// doubts -> sir has mentioned this one
		return value;



	}

	//	@Deprecated
	//	public void initialize(String filePath)		// sir, has not included this one 
	//	{
	//		FileInputStream fis = new FileInputStream(filePath);
	//			wb = WorkbookFactory.create(fis);
	//			fis.close();
	//		
	//		
	//	}

	/**
	 * This method is used to initialize , it takes filePath as an parameter
	 * @param filePath
	 */
	private void initialize(String filePath)		// sir, has not included this one 
	{
		//		using throws EncypedDocumentException, IO Exception

		//		FileInputStream fis = new FileInputStream(filePath);
		//		wb = WorkbookFactory.create(fis);
		//		fis.close();

		//		below is using try catch 
		df = new DataFormatter();

		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filePath);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		} 
		try 
		{
			fis.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}


	}

	/**
	 * This method is used to fetch the formatted String using Data Formatter from Excel based on RownIndex, CellIndex
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	public String getData(String sheetName, int rowIndex, int cellIndex)
	{
		String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
	}

	/**
	 * This method is used to close the workbook
	 * @throws IOException
	 */
	public void close()
	{
		try {
			wb.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 *  This method is used to fetch the Data from Excel based on RownIndex, CellIndex
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 */

	public void setData(String sheetName,int rowIndex,int cellIndex)
	{
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);
	}


	/**
	 * This method is used to write to the ExcelFile 
	 * @param fileOutputPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public void saveData(String fileOutputPath) throws FileNotFoundException, IOException
	{
		wb.write(new FileOutputStream(fileOutputPath));
	}
}
