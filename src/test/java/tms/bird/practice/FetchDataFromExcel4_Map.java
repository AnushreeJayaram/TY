//Fetch the data from excel 

package tms.bird.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataFromExcel4_Map {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String sheetName = "Excel4";
		String expTestScriptName= "OrganizationContactList";
		

		DataFormatter df = new DataFormatter();  // Data formatter is going to fetch all string, numeric data in String format 

		FileInputStream fis = new FileInputStream("./src/test/resources/Excel/TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);		// import org.apache.poi.ss.usermodel.WorkbookFactory;

		Sheet sheet= wb.getSheet(sheetName); 		// import org.apache.poi.ss.usermodel.Sheet;

		int rowCount = sheet.getLastRowNum(); // index

		Map<String,String> map = new HashedMap<>();
		
		
		for(int i=1;i<=rowCount;i++)
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));


			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{

				for(int j=1;j<sheet.getRow(i).getLastCellNum(); j++)
				{

					String key = df.formatCellValue(sheet.getRow(i).getCell(j));

					String value= df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
			
		}

		System.out.println(map.get("LastName")+"   =======>"+map.get("DepartmentName"));

		wb.close();
		fis.close();

	}

}
