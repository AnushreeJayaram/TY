package tms.bird.practice;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import com.tms.genericutility.Misc.JavaUtility;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.enums.SpreadSheet;
import com.tms.genericutility.externalFileUtility.PropertyFileUtility;
import com.tms.genericutility.externalFileUtility.SpreadSheetUtility;
import com.tms.genericutility.webActions.SeleniumUtility;

public class SelectDateInOrgCalendarTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		
		PropertyFileUtility propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		SpreadSheetUtility sheetUtil = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtil = new JavaUtility();
		SeleniumUtility seleniumUtil = new SeleniumUtility();
		
		Map<String, String> testData = sheetUtil.getData(SpreadSheet.ADMIN.getSheetName(),"CreatePackage");			//d
		
		javaUtil.consolePrint("testData");			//d
		
		int reqMonthNum = javaUtil.getMonthNumber(testData.get("reqMonth"),"MMMM");
		int reqYearNum = javaUtil.parseNumber(testData.get("reqYear"));

//		common data
		String browser = propUtils.getPropertyData(PropertyKey.BROWSER);
		long timeunit = Long.parseLong(propUtils.getPropertyData(PropertyKey.TIMEUNIT));
		String url = propUtils.getPropertyData(PropertyKey.URL);
		String admin_username = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_USERNAME));    // decode password   admin->YWRtaW4=
		String admin_password = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_PASSWORD));   // decode password, as password is in encrpted format  Test@123->VGVzdEAxMjM=
		String user_username = propUtils.getPropertyData(PropertyKey.USER_USERNAME);
		String user_password = propUtils.getPropertyData(PropertyKey.USER_PASSWORD);
		
		
		
		
	}

}
