//Fetch the data from excel by using DataFormatter -> we can fetch String, number 

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



public class FetchDataFromExcel_UsingDataFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		DataFormatter df = new DataFormatter();
		
//		Step1: Convert excel file into readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel/TestData.xlsx");

//		Step2: open excel
		Workbook wb = WorkbookFactory.create(fis);		// import org.apache.poi.ss.usermodel.WorkbookFactory;
		
//		Step3: get control on the sheet
		Sheet sheet= wb.getSheet("Organization"); 		// import org.apache.poi.ss.usermodel.Sheet;
		
//		Step4: get the control on the row
		Row row = sheet.getRow(3); 						//import org.apache.poi.ss.usermodel.Row;  // get index
		
//		Step5: get the control on the cell
		Cell cell = row.getCell(1);						//import org.apache.poi.ss.usermodel.Cell;  // get column
		
//		Step6: Fetch data
		String data = df.formatCellValue(cell);
	
		
//		Step7: utilize data
		System.out.println(data);
		
//		Step8: close stream, workbook
		wb.close();
		fis.close();
		
	}

}
