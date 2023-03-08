package tms.bird.practice;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.enums.SpreadSheet;
import com.tms.genericutility.externalfileutility.PropertyFileUtility;
import com.tms.genericutility.externalfileutility.SpreadSheetUtility;

public class Practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		
//		PropertyFileUtility pUtil = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
//		String pwd=pUtil.getPropertyData(PropertyKey.ADMIN_PASSWORD);
//		System.out.println(pwd);
//		
		SpreadSheetUtility spreadUtil = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
//		String value = spreadUtil.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage", "packagename");
//		System.out.println(value);
		Map<String, String> v = spreadUtil.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		System.out.println(v);
		
		
	}

}
