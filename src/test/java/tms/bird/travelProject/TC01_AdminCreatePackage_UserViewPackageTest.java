//Admin login-> create the package(in Tour Package Module) -> user login -> view the package(in Tour Packages Module)

package tms.bird.travelProject;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.tms.ObjectRepository.AdminAdministratorPage;
import com.tms.ObjectRepository.AdminCreatePackagePage;
import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminTourPackagePage;
import com.tms.ObjectRepository.UserSignInPage;
import com.tms.ObjectRepository.ValidationPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.BaseClass.ConfigClass;
import com.tms.genericutility.annotation.Report;
import com.tms.genericutility.enums.SpreadSheet;
import com.tms.genericutility.misc.UtilityInstanceTransfer;



@Listeners(com.tms.genericutility.listener.ExtentReportListener.class)

public class TC01_AdminCreatePackage_UserViewPackageTest extends ConfigClass {

	
	@Report(author = "Anu", category = "sanity")
	@Test // (groups="sanity") //-> use @Test -> Run as TestNG
	public void adminCreatePackage_UserViewPackageTest() {
		// test data
		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		Map<String, String> sheetData1 = sheetUtility.getData(SpreadSheet.VALIDATION.getSheetName(), "FirstScenario");
		
		report.info(UtilityInstanceTransfer.getExtentTest(),"Test Data fetched successfully");
		report.info(UtilityInstanceTransfer.getExtentTest(),sheetData+"");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminTourPackagePage adminTourPackagePage = new AdminTourPackagePage(driver);
		AdminCreatePackagePage adminCreatePackagePage = new AdminCreatePackagePage(driver);
		AdminAdministratorPage adminAdministratorPage = new AdminAdministratorPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		ValidationPage validationPage = new ValidationPage(driver);
		
		report.info(UtilityInstanceTransfer.getExtentTest(),"Required objects for POM classes created successfully");
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		Assert.assertEquals(driver.getTitle(), sheetData1.get("adminSignInTitle"),"Admin_SignIn Page is displayed");
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);

		
		Assert.assertEquals(driver.getTitle(), sheetData1.get("adminDashboardTitle"), "Admin_Dashboard Page is displayed");

		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);

		adminTourPackagePage.adminTourPackagePageAction(LinkNames.CREATE);
		Assert.assertEquals(driver.getTitle(), sheetData1.get("adminPackageCreationTitle"),"Admin_CreatePackage Page is displayed");

		adminCreatePackagePage.adminCreatePackagePageAction(sheetData, javaScriptUtil);

		adminCreatePackagePage.submitAction();

		String actual = validationPage.validationPageAction();
		Assert.assertTrue(actual.contains(sheetData1.get("expected")), actual);

		adminHomePage.adminHomePageAction(TabNames.ADMINISTRATOR);

		adminAdministratorPage.adminAdministratorPageAction(LinkNames.ADMIN_LOGOUT);

		adminLoginPage.adminBackToHomeAction();

		homePage.homePageAction(LinkNames.USER_SIGNIN);
		
		userSignInPage.userSignInAction(user_username, user_password);

		homePage.homePageAction(LinkNames.TOUR_PACKAGES);
		Assert.assertEquals(driver.getTitle(), sheetData1.get("userPackageListTitle"),"User_PackageList Page is displayed");

		javaScriptUtil.scrollDown();

	}

}
