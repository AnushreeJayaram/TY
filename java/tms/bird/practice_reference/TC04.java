//user sign in -> book the package -> admin login -> confirm the booking 
//	-> user view confirmed status in My Tour History

package tms.bird.practice_reference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tms.ObjectRepository.AdminAdministratorPage;
import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManageBookingPage;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.UserPackageDetailsPage;
import com.tms.ObjectRepository.UserSignInPage;
import com.tms.ObjectRepository.UserTourPackagePage;
import com.tms.ObjectRepository.ValidationPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.Misc.JavaUtility;
import com.tms.genericutility.Misc.VerificationUtility;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.externalFileUtility.PropertyFileUtility;
import com.tms.genericutility.externalFileUtility.SpreadSheetUtility;
import com.tms.genericutility.webActions.InteractionUtility;
import com.tms.genericutility.webActions.JavaScriptUtility;
import com.tms.genericutility.webActions.PopupsUtility;
import com.tms.genericutility.webActions.SeleniumUtility;
import com.tms.genericutility.webActions.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC04
{

	public static void main(String[] args)  
	{
		PropertyFileUtility propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		SpreadSheetUtility sheetUtility = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtil = new JavaUtility();
		SeleniumUtility seleniumUtil = new SeleniumUtility();
		WebDriverUtility webDriverUtil = new WebDriverUtility();
		VerificationUtility verifyUtil = new VerificationUtility();
		//JavaScriptUtility is initialized after driver declaration(launch the browser)
		PopupsUtility popupsUtil = new PopupsUtility(); 
		
//		common data
		String browser = propUtils.getPropertyData(PropertyKey.BROWSER);
		long timeunit = Long.parseLong(propUtils.getPropertyData(PropertyKey.TIMEUNIT));
		String url = propUtils.getPropertyData(PropertyKey.URL);
		String admin_username = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_USERNAME));
		String admin_password = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		String user_username = propUtils.getPropertyData(PropertyKey.USER_USERNAME);
		String user_password = propUtils.getPropertyData(PropertyKey.USER_PASSWORD);
		
		
//		//		Step1: Convert the physical file into java readable object
//		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData/CommonData.properties");
//
//		//	Step2: create object for properties class
//		Properties prop = new Properties();
//
//		//	Step3: load all keys
//		prop.load(fis);
//
//		String url = prop.getProperty("url");
//		String admin_username = prop.getProperty("admin_username");
//		String admin_password = prop.getProperty("admin_password");
//		String user_username = prop.getProperty("user_username");
//		String user_password = prop.getProperty("user_password");
//		int time = Integer.parseInt(prop.getProperty("timeunit"));
//
//		fis.close();

		
		
//		WebDriverManager.chromedriver().setup();	
		//		WebDriver driver = new ChromeDriver();
		WebDriver driver = seleniumUtil.launchBrowser("chrome");

		JavaScriptUtility javaScriptUtil = new JavaScriptUtility(driver);
		
		//		driver.manage().window().maximize();
		seleniumUtil.maximizeBrowser();

//		driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
		webDriverUtil.waitForPageLoad(driver);
		
		
//		driver.get(url);
		webDriverUtil.getApplication(driver, url);
	

		HomePage homePage = new HomePage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		UserTourPackagePage userTourPackagePage = new UserTourPackagePage(driver);
		UserPackageDetailsPage userPackageDetailsPage = new UserPackageDetailsPage(driver);
		ValidationPage validationPage = new ValidationPage(driver);
		AdminManageBookingPage adminManageBookingPage = new AdminManageBookingPage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminAdministratorPage adminAdministratorPage = new AdminAdministratorPage(driver);
		
		driver.get(url);

		homePage.homePageAction(LinkNames.USER_SIGNIN);
//		driver.findElement(By.linkText("/ Sign In")).click();
		

		userSignInPage.userSignInAction(user_username, user_password);
//		driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys(user_username);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(user_password);
//		driver.findElement(By.name("signin")).click();

		
		homePage.homePageAction(LinkNames.TOUR_PACKAGES);
//		click on tour packages
		
//		javaScriptUtil.scrollAction() can be used for below

//		driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=13']")).click();
		
//		WebElement webDetails = driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=13']"));
//		javaScriptUtil.scrollAction(webDetails);
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,20)");


//		WebElement webDatePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//		javaScriptUtil.scrollAction(webDatePicker);
//		jse.executeScript("window.scrollBy(0,20)");

		
//		javaScriptUtil.scrollAction() can be used
		
		userPackageDetailsPage.UserPackageDetailsPageAction();
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06-02-2023");
//		driver.findElement(By.xpath("//input[@id='datepicker1']")).sendKeys("20-02-2023");

		
//		WebElement webComment = driver.findElement(By.xpath("//input[@name='comment']"));
//		javaScriptUtil.scrollAction(webComment);
//		jse.executeScript("window.scrollBy(0,20)");
		
//		driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("need accomodation as well");
//		driver.findElement(By.xpath("//button[text()='Book']")).click();

		String expected = "Booked Successfully";
		
		String actual = validationPage.validationPageAction();
//		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();

		verifyUtil.partialVerify(actual, expected, "TC", "Package Booked Successfully");
//		if(actual.contains(expected))
//		{
//			System.out.println("Package Booked Successfully ");
//		}
//		else
//		{
//			System.out.println("Package not Booked  ");
//		}

		homePage.homePageAction(LinkNames.USERSIGNIN_LOGOUT);
//		driver.findElement(By.linkText("/ Logout")).click();

		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
//		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
//		driver.findElement(By.name("username")).sendKeys(admin_username);
//		driver.findElement(By.name("password")).sendKeys(admin_password);
//		driver.findElement(By.name("login")).click();

		adminHomePage.adminHomePageAction(TabNames.MANAGE_BOOKING);
//		driver.findElement(By.xpath("//span[text()='Manage Booking']")).click();

	
		javaScriptUtil.scrollDown();
//		jse.executeScript("window.scrollBy(0,20000)");

		javaUtil.performWebpageZoomOut();
//		zoom out to make sure that window size is zoomed out, to identify confirm button
		
		adminManageBookingPage.adminManageBookingPageAction();	
//		driver.findElement(By.xpath("//table/tbody/tr[last()]/td[last()]//a[text()='Confirm']")).click();

		popupsUtil.confirmAlert(driver);
//		Alert a = driver.switchTo().alert();	
//		a.accept();

		
		String expected1 = "Booking Confirm successfully";
		String actual1 = validationPage.validationPageAction();
//		String actual1 = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();

		verifyUtil.partialVerify(actual1, expected1, "TC", "Booking Confirmed Successfully ");
//		if(actual1.contains(expected1))
//		{
//			System.out.println("Booking Confirmed Successfully ");
//		}
//		else
//		{
//			System.out.println("Booking Not Confirmed ");
//		}


		adminHomePage.adminHomePageAction(TabNames.ADMINISTRATOR);
//		driver.findElement(By.xpath("//span[text()='Administrator']")).click();
		
		adminAdministratorPage.adminAdministratorPageAction(LinkNames.ADMIN_LOGOUT);
//		driver.findElement(By.xpath("//a[text()=' Logout']")).click();

		adminLoginPage.adminBackToHomeAction();
//		driver.findElement(By.xpath("//a[text()='Back to home']")).click();

	
		homePage.homePageAction(LinkNames.USER_SIGNIN);
//		driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
		
		userSignInPage.userSignInAction(user_username, user_password);
//		driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys(user_username);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(user_password);
//		driver.findElement(By.name("signin")).click();
	
		
		driver.findElement(By.linkText("My Tour History")).click();

		String expected_status="Confirmed";
		String actual_status = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[7]")).getText();

		verifyUtil.exactVerify(actual_status, expected_status, "TC", "Booking confirmed view from user");
//		if(actual_status.equals(expected_status))
//			System.out.println("Booking confirmed view from user");
//
//		else
//			System.out.println("Booking not confirmed view from user");



	}

}