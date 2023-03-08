//Admin login-> create the package(in Tour Package Module) -> user login -> view the package(in Tour Packages Module)

package tms.bird.travelProject;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import com.tms.genericutility.enums.SpreadSheet;

//@Listeners(com.tms.genericutility.Retry.SetTestParameter.class)

public class TC01_AdminCreatePackage_UserViewPackageTest extends ConfigClass 
{
								
	@Test(groups="sanity")									//-> use @Test -> Run as TestNG
	public void adminCreatePackage_UserViewPackageTest()
	{
		//test data		
		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminTourPackagePage adminTourPackagePage = new AdminTourPackagePage(driver);
		AdminCreatePackagePage adminCreatePackagePage = new AdminCreatePackagePage(driver);
		AdminAdministratorPage adminAdministratorPage = new AdminAdministratorPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		ValidationPage validationPage = new ValidationPage(driver);
		SoftAssert sf = new SoftAssert();
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.CREATE);
		
		adminCreatePackagePage.adminCreatePackagePageAction(sheetData,javaScriptUtil);
																								//		ask web pg set properly doubt to Sir
		
		adminCreatePackagePage.submitAction();

		String expected = "Package Created Successfully";
	

		String actual = validationPage.validationPageAction();
		//String actual = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']")).getText();

		sf.assertTrue(actual.contains(expected), actual);  //-> Soft Assert
//		Assert.assertTrue(actual.contains(expected), actual);		//->Hard Assert
//		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package Created Successfully");
		
		adminHomePage.adminHomePageAction(TabNames.ADMINISTRATOR);	
		
		adminAdministratorPage.adminAdministratorPageAction(LinkNames.ADMIN_LOGOUT);
		
		adminLoginPage.adminBackToHomeAction();

		homePage.homePageAction(LinkNames.USER_SIGNIN);
		
		userSignInPage.userSignInAction(user_username, user_password);

		homePage.homePageAction(LinkNames.TOUR_PACKAGES);

		javaScriptUtil.scrollDown();
		
	}

}
