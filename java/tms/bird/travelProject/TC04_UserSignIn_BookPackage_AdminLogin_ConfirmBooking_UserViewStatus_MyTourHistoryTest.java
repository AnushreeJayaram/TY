//user sign in -> book the package -> admin login -> confirm the booking 
//	-> user view confirmed status in My Tour History

package tms.bird.travelProject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tms.ObjectRepository.AdminAdministratorPage;
import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManageBookingPage;
import com.tms.ObjectRepository.UserPackageDetailsPage;
import com.tms.ObjectRepository.UserSignInPage;
import com.tms.ObjectRepository.UserTourPackagePage;
import com.tms.ObjectRepository.ValidationPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.BaseClass.ConfigClass;

public class TC04_UserSignIn_BookPackage_AdminLogin_ConfirmBooking_UserViewStatus_MyTourHistoryTest extends ConfigClass
{

	@Test(groups="sanity")
	public void userSignIn_BookPackage_AdminLogin_ConfirmBooking_UserViewStatus_MyTourHistoryTest()
	{
		
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		UserTourPackagePage userTourPackagePage = new UserTourPackagePage(driver);
		UserPackageDetailsPage userPackageDetailsPage = new UserPackageDetailsPage(driver);
		ValidationPage validationPage = new ValidationPage(driver);
		AdminManageBookingPage adminManageBookingPage = new AdminManageBookingPage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminAdministratorPage adminAdministratorPage = new AdminAdministratorPage(driver);
	

		homePage.homePageAction(LinkNames.USER_SIGNIN);

		userSignInPage.userSignInAction(user_username, user_password);

		
		homePage.homePageAction(LinkNames.TOUR_PACKAGES);
		
		userTourPackagePage.packageSakaleshpurDetailsLinkAction(javaScriptUtil);
		
		userPackageDetailsPage.UserPackageDetailsPageAction();
		

		String expected = "Booked Successfully";
		
		String actual = validationPage.validationPageAction();


		verifyUtil.partialVerify(actual, expected, "TC", "Package Booked Successfully");


		homePage.homePageAction(LinkNames.USERSIGNIN_LOGOUT);


		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);


		adminHomePage.adminHomePageAction(TabNames.MANAGE_BOOKING);


	
		javaScriptUtil.scrollDown();


		javaUtil.performWebpageZoomOut();

		
		adminManageBookingPage.adminManageBookingPageAction();	


		popupsUtil.confirmAlert(driver);


		
		String expected1 = "Booking Confirm successfully";
		String actual1 = validationPage.validationPageAction();
//		String actual1 = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();

		
		verifyUtil.partialVerify(actual1, expected1, "TC", "Booking Confirmed Successfully ");


		javaScriptUtil.scrollUp();
		
		adminHomePage.adminHomePageAction(TabNames.ADMINISTRATOR);

		
		adminAdministratorPage.adminAdministratorPageAction(LinkNames.ADMIN_LOGOUT);


		adminLoginPage.adminBackToHomeAction();


	
		homePage.homePageAction(LinkNames.USER_SIGNIN);

		
		userSignInPage.userSignInAction(user_username, user_password);

			
		driver.findElement(By.linkText("My Tour History")).click();

		String expected_status="Confirmed";
		String actual_status = validationPage.lastConfirmRowAction();
//		String actual_status = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[7]")).getText();

		verifyUtil.exactVerify(actual_status, expected_status, "TC", "Booking confirmed view from user");
//		if(actual_status.equals(expected_status))
//			System.out.println("Booking confirmed view from user");
//
//		else
//			System.out.println("Booking not confirmed view from user");



	}

}