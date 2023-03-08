//Admin login-> create the package(in Tour Package Module) -> user login -> view the package(in Tour Packages Module)

package tms.bird.practice_reference;

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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tms.ObjectRepository.AdminAdministratorPage;
import com.tms.ObjectRepository.AdminCreatePackagePage;
import com.tms.ObjectRepository.AdminHomePage;
import com.tms.ObjectRepository.AdminLoginPage;
import com.tms.ObjectRepository.AdminTourPackagePage;
import com.tms.ObjectRepository.HomePage;
import com.tms.ObjectRepository.UserSignInPage;
import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;
import com.tms.genericutility.BaseClass.ConfigClass;
import com.tms.genericutility.Misc.JavaUtility;
import com.tms.genericutility.Misc.VerificationUtility;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.enums.SpreadSheet;
import com.tms.genericutility.externalFileUtility.PropertyFileUtility;
import com.tms.genericutility.externalFileUtility.SpreadSheetUtility;
import com.tms.genericutility.webActions.JavaScriptUtility;
import com.tms.genericutility.webActions.SeleniumUtility;
import com.tms.genericutility.webActions.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01 extends ConfigClass
{
								
	@Test									//-> use @Test -> Run as TestNG
	public void adminCreatePackage_UserViewPackageTest()
	{
//						generic utilities class and common data should be declared in Base Class
		
/*	public static void main(String[] args) ->  use main ->  Run as Java Application 
	{
		PropertyFileUtility propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		SpreadSheetUtility sheetUtility = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtil= new JavaUtility();				
		SeleniumUtility seleniumUtil = new SeleniumUtility();
		WebDriverUtility webDriverUtil = new WebDriverUtility();
		VerificationUtility verifyUtil = new VerificationUtility();
		JavaScriptUtility is initialized below , after launch browser
*/		

		//		common data
/*		String browser = propUtils.getPropertyData(PropertyKey.BROWSER);
		long timeunit = Long.parseLong(propUtils.getPropertyData(PropertyKey.TIMEUNIT));
		String url = propUtils.getPropertyData(PropertyKey.URL);
		String admin_username = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_USERNAME));    // decode password   admin->YWRtaW4=
		String admin_password = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_PASSWORD));   // decode password, as password is in encrpted format  Test@123->VGVzdEAxMjM=
		String user_username = propUtils.getPropertyData(PropertyKey.USER_USERNAME);
		String user_password = propUtils.getPropertyData(PropertyKey.USER_PASSWORD);
*/

		//		Step1: Convert the physical file into java readable object
		//			FileInputStream fis= new FileInputStream("./src/test/resources/CommonData/CommonData.properties");

		//	Step2: create object for properties class
		//			Properties prop = new Properties();

		//	Step3: load all keys
		//			prop.load(fis);


		//			String url = prop.getProperty("url");
		//			String admin_username = prop.getProperty("admin_username");
		//			String admin_password = prop.getProperty("admin_password");
		//			String user_username = prop.getProperty("user_username");
		//			String user_password = prop.getProperty("user_password");
		//			int time = Integer.parseInt(prop.getProperty("timeunit"));

		//			fis.close();


		//test data		
		String sheetName = SpreadSheet.ADMIN.getSheetName();
		String expTestScriptName= "CreatePackage";
		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		
		// do changes for the below code use Map Concept
		
		String packageName = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packagename");
		String packageType = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packagetype");
		String packageLocation = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packagelocation");
		String packagePrice = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packageprice");
		String packageFeatures = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packagefeatures");
		String packageDetails = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packagedetails");
		String packageImage = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName , "packageimage");


		//			DataFormatter df = new DataFormatter();  // Data formatter is going to fetch all string, numeric data in String format 
		//
		//			Workbook wb = WorkbookFactory.create(sheetUtility);		// import org.apache.poi.ss.usermodel.WorkbookFactory;
		//
		//			Sheet sheet= wb.getSheet(sheetName); 		// import org.apache.poi.ss.usermodel.Sheet;
		//
		//			int rowCount = sheet.getLastRowNum(); // index

		//			Map<String,String> map = new HashedMap<>();


		//			for(int i=1;i<=rowCount;i++)
		//			{
		//				String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
		//
		//
		//				if(testScriptName.equalsIgnoreCase(expTestScriptName))
		//				{
		//
		//					for(int j=1;j<sheet.getRow(i).getLastCellNum(); j++)
		//					{
		//
		//						String key = df.formatCellValue(sheet.getRow(i).getCell(j));
		//
		//						String value= df.formatCellValue(sheet.getRow(i+1).getCell(j));
		//						map.put(key, value);
		//					}
		//					break;
		//				}
		//				
		//			}
		//
		//			wb.close();
		//			fis_excel.close();

		//			int random = new Random().nextInt(1000);
		//			String p_name = packageName+random;
//		String p_name =packageName+ javaUtil.getRandomNumber(1000);

		
		//		WebDriverManager.chromedriver().setup();	
		//		WebDriver driver = new ChromeDriver();
//		WebDriver driver = seleniumUtil.launchBrowser("chrome");

//		JavaScriptUtility javaScriptUtil = new JavaScriptUtility(driver);
		
		
		//		driver.manage().window().maximize();
//		webDriverUtil.maximiseWindow(driver);

		
//		driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
//		webDriverUtil.waitForPageLoad(driver);
		
		
//		driver.get(url);
//		webDriverUtil.getApplication(driver, url);

//		HomePage homePage = new HomePage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminTourPackagePage adminTourPackagePage = new AdminTourPackagePage(driver);
		AdminCreatePackagePage adminCreatePackagePage = new AdminCreatePackagePage(driver);
		AdminAdministratorPage adminAdministratorPage = new AdminAdministratorPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
//		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
//		driver.findElement(By.name("username")).sendKeys(admin_username);
//		driver.findElement(By.name("password")).sendKeys(admin_password);
				//   or like this also it can be encypted -> driver.findElement(By.name("password")).sendKeys(javaUtil.decode(admin_password));
//		driver.findElement(By.name("login")).click();

		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
//		driver.findElement(By.xpath("//span[text()=' Tour Packages']")).click();
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.CREATE);
//		driver.findElement(By.xpath("//a[text()='Create']")).click();

		
		adminCreatePackagePage.adminCreatePackagePageAction(sheetData,javaScriptUtil);
																								//		ask web pg set properly doubt to Sir
//		driver.findElement(By.id("packagename")).sendKeys(p_name);
//		driver.findElement(By.id("packagetype")).sendKeys(packageType);
//		driver.findElement(By.id("packagelocation")).sendKeys(packageLocation);
//		driver.findElement(By.id("packageprice")).sendKeys(packagePrice);
//		driver.findElement(By.id("packagefeatures")).sendKeys(packageFeatures);

//		javaScriptUtil.scrollDown();
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,600)");

//		driver.findElement(By.id("packagedetails")).sendKeys(packageDetails);
//
//		driver.findElement(By.id("packageimage")).sendKeys(packageImage);
		//	How to insert the image?

		
		adminCreatePackagePage.submitAction();
		//driver.findElement(By.xpath("//button[text()='Create']")).click();
		

		//	Doubt

		//	WebElement expected = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']"));
		//	WebElement actual = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']"));

		String expected = "Package Created Successfully";
		String actual = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']")).getText();


		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package Created Successfully");
//		if(actual.contains(expected))
//		{
//			System.out.println(p_name+"Package Created Successfully");
//		}
//		else
//		{
//			System.out.println("Package Not Created ");
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
//		driver.findElement(By.id("password")).sendKeys(user_password);
//		driver.findElement(By.name("signin")).click();

		homePage.homePageAction(LinkNames.TOUR_PACKAGES);
//		driver.findElement(By.linkText("Tour Packages")).click();

		javaScriptUtil.scrollDown();
//		jse.executeScript("window.scrollBy(0,20000)");


//		String expected = "Package viewed by User Successfully";
//		String actual = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']")).getText();


//		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package viewed by User Successfully");
//		if(actual.contains(expected))
//		{
//			System.out.println(p_name+"Package Created Successfully");
//		}
//		else
//		{
//			System.out.println("Package Not Created ");
//		}
		
		
	}

}
