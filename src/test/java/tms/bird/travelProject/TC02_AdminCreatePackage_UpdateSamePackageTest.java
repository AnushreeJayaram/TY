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
import com.tms.genericutility.annotation.Report;
import com.tms.genericutility.enums.SpreadSheet;



public class TC02_AdminCreatePackage_UpdateSamePackageTest extends ConfigClass
{
	@Report(author="Anu")
	
	@Test 				//(groups={"regression","major"})
	public void adminCreatePackage_UpdateSamePackageTest()
	{	
		//test data		
		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		Map<String, String> sheetData1 = sheetUtility.getData(SpreadSheet.VALIDATION.getSheetName(), "SecondScenario");
		
// POM utilization 
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminTourPackagePage adminTourPackagePage = new AdminTourPackagePage(driver);
		AdminCreatePackagePage adminCreatePackagePage = new AdminCreatePackagePage(driver);
		AdminManagePackagePage adminManagePackagePage = new AdminManagePackagePage(driver);
		AdminUpdatePackagePage adminUpdatePackagePage = new AdminUpdatePackagePage(driver);
		ValidationPage validationPage = new ValidationPage(driver); 
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		Assert.assertEquals(driver.getTitle(),sheetData1.get("adminSignInTitle") , "Admin_SignIn Page is displayed");
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
		Assert.assertEquals(driver.getTitle(),sheetData1.get("adminDashboardTitle") , "Admin_Dashboard Page is displayed");
		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.CREATE);
		Assert.assertEquals(driver.getTitle(),sheetData1.get("adminPackageCreationTitle") , "Admin_CreatePackage Page is displayed");
		
		adminCreatePackagePage.adminCreatePackagePageAction(sheetData,javaScriptUtil);
		adminCreatePackagePage.submitAction();
	
		String expected = sheetData1.get("expected");
		String actual = validationPage.validationPageAction(); 
		Assert.assertTrue(actual.contains(expected), actual);
		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.MANAGE);
		Assert.assertEquals(driver.getTitle(),sheetData1.get("adminManagePackageTitle") , "Admin_ManagePackage Page is displayed");
		
		String expTestScriptName1= "ManagePackage";
		
		String packageType1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagetype");			// using only this
		
		adminManagePackagePage.viewDetailsButtonClickAction(javaScriptUtil);
		
		adminUpdatePackagePage.adminUpdatePackagePageAction(packageType1);
		javaScriptUtil.scrollAction();

		adminUpdatePackagePage.updateButtonAction();

		String manage_expected = sheetData1.get("expectedUpdate");
		String manage_actual = validationPage.validationPageAction(); 
		Assert.assertTrue(manage_actual.contains(manage_expected), manage_actual);
	

	}

}
