//User Sign up -> Sign In -> User Book Package
//Admin Login -> Admin confirm pacakage

package tms.bird.practice_reference;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminManageBookingPage;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.UserSignInPage;
import com.tms.ObjectRepository.UserSignUpPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.Misc.JavaUtility;
import com.tms.genericutility.Misc.VerificationUtility;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.enums.SpreadSheet;
import com.tms.genericutility.externalFileUtility.PropertyFileUtility;
import com.tms.genericutility.externalFileUtility.SpreadSheetUtility;
import com.tms.genericutility.webActions.JavaScriptUtility;
import com.tms.genericutility.webActions.PopupsUtility;
import com.tms.genericutility.webActions.SeleniumUtility;
import com.tms.genericutility.webActions.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03 {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
//		Utility Initialization
		PropertyFileUtility propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		SpreadSheetUtility sheetUtility = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtil = new JavaUtility(); // always initializers should be at top
		SeleniumUtility seleniumUtil = new SeleniumUtility();
		WebDriverUtility webDriverUtil = new WebDriverUtility();
																		//JavaScriptUtility is initialized after driver declaration(launch the browser) 
		PopupsUtility popupsUtil = new PopupsUtility();
		VerificationUtility verifyUtil = new VerificationUtility();

		
//		common data
		String browser = propUtils.getPropertyData(PropertyKey.BROWSER);
		long timeunit = Long.parseLong(propUtils.getPropertyData(PropertyKey.TIMEUNIT));
		String url = propUtils.getPropertyData(PropertyKey.URL);
		String admin_username = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_USERNAME));
		String admin_password = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		String user_username = propUtils.getPropertyData(PropertyKey.USER_USERNAME);
		String user_password = propUtils.getPropertyData(PropertyKey.USER_PASSWORD);

		
		// test data
		String sheetName = SpreadSheet.ADMIN.getSheetName();
		String expTestScriptName = "CreatePackage";
		String packageName = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), expTestScriptName, "packagename");
		String packageType = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), expTestScriptName, "packagetype");
		String packageLocation = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), expTestScriptName,"packagelocation");
		String packagePrice = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), expTestScriptName, "packageprice");
		String packageFeatures = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), expTestScriptName,"packagefeatures");

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
//
//		FileInputStream fis_excel= new FileInputStream("./src/test/resources/Excel/TestData.xlsx");

//		String sheetName = "user";
//		String expTestScriptName= "SignUp";
//		String sheetNameUser = SpreadSheet.USER.getSheetName();
//		String expTestScriptNameUser = "SignUp";

//		DataFormatter df = new DataFormatter();  // Data formatter is going to fetch all string, numeric data in String format 
//
//		Workbook wb = WorkbookFactory.create(fis_excel);		// import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//		Sheet sheet= wb.getSheet(sheetName); 		// import org.apache.poi.ss.usermodel.Sheet;
//
//		int rowCount = sheet.getLastRowNum(); // index
//
//		Map<String,String> map = new HashedMap<>();
//
//
//		for(int i=1;i<=rowCount;i++)
//		{
//			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
//
//
//			if(testScriptName.equalsIgnoreCase(expTestScriptName))
//			{
//
//				for(int j=1;j<sheet.getRow(i).getLastCellNum(); j++)
//				{
//
//					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
//
//					String value= df.formatCellValue(sheet.getRow(i+1).getCell(j));
//					map.put(key, value);
//				}
//				break;
//			}
//
//		}
//
//		wb.close();
//		fis_excel.close();
//		
//		int random = map.get("email") + new Random(1000);
		String pname_random = packageName + javaUtil.getRandomNumber(1000);

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = seleniumUtil.launchBrowser("chrome");
		
		JavaScriptUtility javaScriptUtil = new JavaScriptUtility(driver);

//		driver.manage().window().maximize();
		webDriverUtil.maximiseWindow(driver);

//		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		webDriverUtil.waitForPageLoad(driver);

//		driver.get(url);
		webDriverUtil.getApplication(driver, url);
		
		HomePage homePage = new HomePage(driver);
		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminManageBookingPage adminManageBookingPage = new AdminManageBookingPage(driver);

		

		homePage.homePageAction(LinkNames.USER_SIGNUP);
//		driver.findElement(By.linkText("Sign Up")).click();

		
		String sheetNameUser = SpreadSheet.USER.getSheetName();
		String expTestScriptNameUser = "SignUp";
		
	
		String fname = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "fname");
		String mobilenumber = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "mobilenumber");
		String email = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "email");
		String password = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "password");
		
		String com = sheetUtility.getData(sheetNameUser, expTestScriptNameUser, "com");
		String email_random = email + javaUtil.getRandomNumber(1000)+ com ;
		

	
		userSignUpPage.userSignUpAction(fname, mobilenumber, email_random, password);
//		driver.findElement(By.name("fname")).sendKeys(fname);
//		driver.findElement(By.name("mobilenumber")).sendKeys(mobilenumber);
//		driver.findElement(By.id("email")).sendKeys(email_random);
//		driver.findElement(By.xpath("//h3[text()='Create your account ']/following-sibling::input[@name='password']")).sendKeys(password);


//		driver.findElement(By.name("fname")).sendKeys(map.get("fname"));
//		driver.findElement(By.name("mobilenumber")).sendKeys(map.get("mobilenumber"));
//		driver.findElement(By.id("email")).sendKeys(map.get("email"));
//		driver.findElement(By.name("password")).sendKeys(map.get("password"));

		
//		driver.findElement(By.id("submit")).click();
		
		homePage.homePageAction(LinkNames.USER_SIGNIN);
//		driver.findElement(By.linkText("/ Sign In")).click();

		
		userSignInPage.userSignInAction(email_random, password);
//		driver.findElement(By.cssSelector("[placeholder='Enter your Email']")).sendKeys(email_random);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//
//		driver.findElement(By.name("signin")).click();
		
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,20)");	// scroll vertically

		
		WebElement wb = driver.findElement(By.xpath("//h4[text()='Package Name: Sakleshpura']"));
		
		javaScriptUtil.scrollUptoParticularWebElement(wb);
		//jse.executeScript("arguments[0].scrollIntoView(true)", wb);
		
		driver.findElement(By.xpath("//a[@href='package-details.php?pkgid=9']")).click();

//		jse.executeScript("window.scrollBy(0,20)");

		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06-02-2023");
		driver.findElement(By.xpath("//input[@id='datepicker1']")).sendKeys("20-02-2023");

		WebElement commentField = driver.findElement(By.xpath("//input[@name='comment']"));
		javaScriptUtil.scrollUptoParticularWebElement(commentField);
		//jse.executeScript("arguments[0].scrollIntoView(true)", commentField);
		//jse.executeScript("window.scrollBy(0,20)");

		commentField.sendKeys("need accomodation as well");
		driver.findElement(By.xpath("//button[text()='Book']")).click();

		
		String expected = "Booked Successfully";
		String actual = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		
		verifyUtil.partialVerify(actual, expected, "TC", "Package Booked Successfully");
//		if (actual.contains(expected)) {
//			System.out.println(pname_random + "Package Booked Successfully ");
//		} else {
//			System.out.println(pname_random +"Package not Booked  ");
//		}

		homePage.homePageAction(LinkNames.USERSIGNIN_LOGOUT);
//		driver.findElement(By.linkText("/ Logout")).click();

		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
//		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
//		driver.findElement(By.name("username")).sendKeys(admin_username);
//		driver.findElement(By.name("password")).sendKeys(admin_password);
//		driver.findElement(By.name("login")).click();

		adminHomePage.adminHomePageAction(TabNames.MANAGE_BOOKING);
//		driver.findElement(By.xpath("//span[text()='Manage Booking']")).click();

		
		javaUtil.performWebpageZoomOut();
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_MINUS);
//		r.keyRelease(KeyEvent.VK_MINUS);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_MINUS);
//		r.keyRelease(KeyEvent.VK_MINUS);
//		r.keyRelease(KeyEvent.VK_CONTROL);
		
		javaScriptUtil.scrollDown();
		//jse.executeScript("window.scrollBy(0,20000)";

		
		adminManageBookingPage.adminManageBookingPageAction();
//		driver.findElement(By.xpath("//table/tbody/tr[last()]/td[last()]//a[text()='Confirm']")).click();

//		Alert a = driver.switchTo().alert();
//		a.accept();
		popupsUtil.confirmAlert(driver);
		

		String expected1 = "Booking Confirm successfully";
		String actual1 = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();

		verifyUtil.partialVerify(actual1, expected1, "TC", "Booking Confirmed Successfully");
//		if (actual1.contains(expected1)) {
//			System.out.println(pname_random +"Booking Confirmed Successfully ");
//		} else {
//			System.out.println(pname_random+ "Booking Not Confirmed ");
//		}

	}

}