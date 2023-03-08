//Fetch the data from excel 

package tms.bird.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataFromExcel3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String expTestScriptName = "SelectOrganizationListTest";
		String expKey="orgName";
		
		DataFormatter df = new DataFormatter();

		FileInputStream fis = new FileInputStream("./src/test/resources/Excel/TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);		// import org.apache.poi.ss.usermodel.WorkbookFactory;

		Sheet sheet= wb.getSheet("Organization"); 		// import org.apache.poi.ss.usermodel.Sheet;

		int rowCount = sheet.getLastRowNum(); // index
		System.out.println(rowCount);
		
		String value="";
		
		for(int i=1;i<=rowCount;i++)
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			System.out.println(testScriptName);
			
			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{
				short cellCount = sheet.getRow(i).getLastCellNum();
				
				for(int j=0;j<cellCount; j++)
				{
					
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expKey))
					{
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
//						break;
					}
				}
				
				break;
				
			}
			
		}
		
		System.out.println(value);

		wb.close();
		fis.close();

	}

}
