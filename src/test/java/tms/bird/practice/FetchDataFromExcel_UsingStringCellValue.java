//Fetch the data from excel by using StringCellValue -> can fetch only String but not numeric. it will give IllegalStateException

package tms.bird.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class FetchDataFromExcel_UsingStringCellValue {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
//		Step1: Convert excel file into readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel/TestData.xlsx");

//		Step2: open excel
		Workbook wb = WorkbookFactory.create(fis);		// import org.apache.poi.ss.usermodel.WorkbookFactory;
		
//		Step3: get control on the sheet
		Sheet sheet= wb.getSheet("Organization"); 		// import org.apache.poi.ss.usermodel.Sheet;
		
//		Step4: get the control on the row
		Row row = sheet.getRow(1); 						//import org.apache.poi.ss.usermodel.Row;
		
		
//		Step5: get the control on the cell
		Cell cell = row.getCell(1);						//import org.apache.poi.ss.usermodel.Cell;
		
//		Step6: Fetch data
		String data = cell.getStringCellValue();
	
//	double data = cell.getNumericCellValue();
	
//		Step7: utilize data
		System.out.println(data);
		
//		Step8: close stream, workbook
		wb.close();
		fis.close();
		
	}

}
