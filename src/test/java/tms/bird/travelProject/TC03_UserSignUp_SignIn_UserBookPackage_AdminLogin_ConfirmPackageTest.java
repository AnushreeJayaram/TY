//User Sign up -> Sign In -> User Book Package
//Admin Login -> Admin confirm pacakage

package tms.bird.travelProject;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManageBookingPage;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.UserPackageDetailsPage;
import com.tms.ObjectRepository.UserSignInPage;
import com.tms.ObjectRepository.UserSignUpPage;
import com.tms.ObjectRepository.UserTourPackagePage;
import com.tms.ObjectRepository.ValidationPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.BaseClass.ConfigClass;
import com.tms.genericutility.annotation.Report;
import com.tms.genericutility.enums.SpreadSheet;

public class TC03_UserSignUp_SignIn_UserBookPackage_AdminLogin_ConfirmPackageTest extends ConfigClass
{

	@Report(author="Shree")
	
	@Test(groups={"regression","major"})
	public void userSignUp_SignIn_UserBookPackage_AdminLogin_ConfirmPackageTest()
	{
				
		// test data
		Map<String, String> sheetdata = sheetUtility.getData(SpreadSheet.VALIDATION.getSheetName(), "ThirdScenario");

		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminManageBookingPage adminManageBookingPage = new AdminManageBookingPage(driver);
		UserPackageDetailsPage userPackageDetailsPage = new UserPackageDetailsPage(driver);
		HomePage homePage = new HomePage(driver);
		UserTourPackagePage userTourPackagePage = new UserTourPackagePage(driver);
		ValidationPage validationPage = new ValidationPage(driver);
		SoftAssert sf = new SoftAssert();
		
		homePage.homePageAction(LinkNames.USER_SIGNUP);
		
		String sheetNameUser = SpreadSheet.USER.getSheetName();
		String expTestScriptNameUser = "SignUp";
		
		String fname = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "fname");
		String mobilenumber = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "mobilenumber");
		String email = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "email");
		String com = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "com");
		String email_random = email + javaUtil.getRandomNumber(1000)+ com ;
		
		String password = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "password");
			
		userSignUpPage.userSignUpAction(fname, mobilenumber, email_random, password);
		
		homePage.homePageAction(LinkNames.USER_SIGNIN);
		
		userSignInPage.userSignInAction(email_random, password);
		
		homePage.homePageAction(LinkNames.TOUR_PACKAGES);
		sf.assertEquals(driver.getTitle(), sheetdata.get("userPackageListTitle"),"User_PackageList Page is displayed");

		userTourPackagePage.packageSakaleshpurDetailsLinkAction(javaScriptUtil);
		
		userPackageDetailsPage.UserPackageDetailsPageAction();
		
		String expected = sheetdata.get("expected");
		String actual = validationPage.validationPageAction();
		Assert.assertTrue(actual.contains(expected), actual);


		homePage.homePageAction(LinkNames.USERSIGNIN_LOGOUT);
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		sf.assertEquals(driver.getTitle(), sheetdata.get("adminSignInTitle"),"Admin_SignIn Page is displayed");
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);

		adminHomePage.adminHomePageAction(TabNames.MANAGE_BOOKING);
System.out.println(driver.getTitle());
		
		
		javaUtil.performWebpageZoomOut();
		
		javaScriptUtil.scrollDown();
		
		adminManageBookingPage.adminManageBookingPageAction();

		popupsUtil.confirmAlert(driver);
		

		String expected1 = sheetdata.get("expected_msg");
		String actual1 = validationPage.validationPageAction();
		sf.assertTrue(actual1.contains(expected1), actual1);		


	}

}