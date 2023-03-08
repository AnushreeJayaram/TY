//Fetch the data from excel 

package tms.bird.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataFromExcel3_MultipleValues {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		String sheetName = "Organization";
		String expTestScriptName= "SelectOrganizationListTest";
		String expKey = "OrgName";


		DataFormatter df = new DataFormatter();  // Data formatter is going to fetch all string, numeric data in String format 

		FileInputStream fis = new FileInputStream("./src/test/resources/Excel/TestData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);		// import org.apache.poi.ss.usermodel.WorkbookFactory;

		Sheet sheet= wb.getSheet(sheetName); 		// import org.apache.poi.ss.usermodel.Sheet;

		int rowCount = sheet.getLastRowNum(); // index

		List<String> dataList = new ArrayList<String>();



		for(int i=1;i<=rowCount;i++)
		{
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));


			if(testScriptName.equalsIgnoreCase(expTestScriptName))
			{

				for(int j=0;j<sheet.getRow(i).getLastCellNum(); j++)
				{

					String key = df.formatCellValue(sheet.getRow(i).getCell(j));

					if(key.equalsIgnoreCase(expKey))
					{
						for(int k=i+1; ;k++)
						{
							String data = df.formatCellValue(sheet.getRow(i+1).getCell(j));
							if(data.equals("")){
								break;
							}
							else
							{
								dataList.add(data);
							}
						}
						break;
					}
				}break;
			}
			
		}

		System.out.println(dataList);

		wb.close();
		fis.close();

	}

}
