//Admin created the package & updated for the same created package

package tms.bird.travelProject;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tms.ObjectRepository.AdminCreatePackagePage;
import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManagePackagePage;
import com.tms.ObjectRepository.AdminTourPackagePage;
import com.tms.ObjectRepository.AdminUpdatePackagePage;
import com.tms.ObjectRepository.ValidationPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.BaseClass.ConfigClass;
import com.tms.genericutility.enums.SpreadSheet;



public class TC02_AdminCreatePackage_UpdateSamePackageTest extends ConfigClass
{

	@Test(groups={"regression","major"})
	public void adminCreatePackage_UpdateSamePackageTest()
	{	
		//test data		
		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		
// POM utilization // doubt 
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminTourPackagePage adminTourPackagePage = new AdminTourPackagePage(driver);
		AdminCreatePackagePage adminCreatePackagePage = new AdminCreatePackagePage(driver);
		AdminManagePackagePage adminManagePackagePage = new AdminManagePackagePage(driver);
		AdminUpdatePackagePage adminUpdatePackagePage = new AdminUpdatePackagePage(driver);
		ValidationPage validationPage = new ValidationPage(driver); 
		SoftAssert sf = new SoftAssert();
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.CREATE);

		
		adminCreatePackagePage.adminCreatePackagePageAction(sheetData,javaScriptUtil);

		adminCreatePackagePage.submitAction();
	
		String expected = "Package Created Successfully";
		String actual = validationPage.validationPageAction(); 
	
		sf.assertTrue(actual.contains(expected), actual);
//		Assert.assertTrue(actual.contains(expected), actual);
		
//		String actual = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']")).getText();


//		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package Created Successfully");
		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.MANAGE);
		
//		String sheetName1 = SpreadSheet.ADMIN.getSheetName();
		String expTestScriptName1= "ManagePackage";
//		Map<String, String> sheetData1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "ManagePackage");
		
//		String packageName1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagename");
		String packageType1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagetype");			// using only this
//		String packageLocation1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagelocation");
//		String packagePrice1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packageprice");
//		String packageFeatures1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagefeatures");
		
//		WebElement web = driver.findElement(By.xpath("//tbody/tr[last()]"));
//
//		javaScriptUtil.scrollUptoParticularWebElement(web);
		
		adminManagePackagePage.viewDetailsButtonClickAction(javaScriptUtil);
		
		adminUpdatePackagePage.adminUpdatePackagePageAction(packageType1);
		javaScriptUtil.scrollAction();

		
		adminUpdatePackagePage.updateButtonAction();

		String manage_expected = "Package Updated Successfully";
		String manage_actual = validationPage.validationPageAction(); 
//		String manage_actual = driver.findElement(By.xpath("//div[text()=':Package Updated Successfully ']")).getText();

		sf.assertTrue(manage_actual.contains(manage_expected), manage_actual);
//		Assert.assertTrue(manage_actual.contains(manage_expected), manage_actual);
		
//		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package Updated Successfully");
	

	}

}
