//User Sign up -> Sign In -> User Book Package
//Admin Login -> Admin confirm pacakage

package tms.bird.travelProject;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
import com.tms.genericutility.enums.SpreadSheet;

public class TC03_UserSignUp_SignIn_UserBookPackage_AdminLogin_ConfirmPackageTest extends ConfigClass
{

	@Test(groups={"regression","major"})
	public void userSignUp_SignIn_UserBookPackage_AdminLogin_ConfirmPackageTest()
	{
				
		// test data
//		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
//		String expTestScriptName = "CreatePackage";
//		String packageName = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), expTestScriptName, "packagename");
	
		
//		String sheetName = SpreadSheet.ADMIN.getSheetName();
//		String expTestScriptName = "CreatePackage";

		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminManageBookingPage adminManageBookingPage = new AdminManageBookingPage(driver);
		UserPackageDetailsPage userPackageDetailsPage = new UserPackageDetailsPage(driver);
		HomePage homePage = new HomePage(driver);
		UserTourPackagePage userTourPackagePage = new UserTourPackagePage(driver);
		ValidationPage validationPage = new ValidationPage(driver);

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
  

		userTourPackagePage.packageSakaleshpurDetailsLinkAction(javaScriptUtil);
		
//		WebElement wb = driver.findElement(By.xpath("//h4[text()='Package Name: Sakleshpura']"));	
//		javaScriptUtil.scrollUptoParticularWebElement(wb);
		
//		driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=9']")).click();

		userPackageDetailsPage.UserPackageDetailsPageAction();
		
/*		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06-02-2023");
		driver.findElement(By.xpath("//input[@id='datepicker1']")).sendKeys("20-02-2023");

		WebElement commentField = driver.findElement(By.xpath("//input[@name='comment']"));
		javaScriptUtil.scrollUptoParticularWebElement(commentField);
	
		commentField.sendKeys("need accomodation as well");
		driver.findElement(By.xpath("//button[text()='Book']")).click();
	*/
		
		String expected = "Booked Successfully";
		String actual = validationPage.validationPageAction();
//		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		
		Assert.assertTrue(actual.contains(expected), actual);
		
//		verifyUtil.partialVerify(actual, expected, "TC", "Package Booked Successfully");


		homePage.homePageAction(LinkNames.USERSIGNIN_LOGOUT);
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);

		adminHomePage.adminHomePageAction(TabNames.MANAGE_BOOKING);
		
		javaUtil.performWebpageZoomOut();
		
		javaScriptUtil.scrollDown();
		
		adminManageBookingPage.adminManageBookingPageAction();

		popupsUtil.confirmAlert(driver);
		

		String expected1 = "Booking Confirm successfully";
		String actual1 = validationPage.validationPageAction();

		Assert.assertTrue(actual1.contains(expected1), actual1);
		
//		verifyUtil.partialVerify(actual1, expected1, "TC", "Booking Confirmed Successfully");


	}

}