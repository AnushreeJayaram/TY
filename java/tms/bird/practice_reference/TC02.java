//Admin created the package & updated for the same created package

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
import com.tms.ObjectRepository.AdminManagePackagePage;
import com.tms.ObjectRepository.AdminTourPackagePage;
import com.tms.ObjectRepository.AdminUpdatePackagePage;
import com.tms.ObjectRepository.HomePage;
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

public class TC02 extends ConfigClass
{

	@Test
	public void adminCreatePackage_UpdateSamePackageTest()
	{
	
/*	public static void main(String[] args)  
	{
		PropertyFileUtility propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		SpreadSheetUtility sheetUtility = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtil= new JavaUtility();				// always initializers should be at top
		SeleniumUtility seleniumUtil = new SeleniumUtility();
		WebDriverUtility webDriverUtil = new WebDriverUtility();
		VerificationUtility verifyUtil = new VerificationUtility();
*/		
	

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
//		
		//test data		
		String sheetName = SpreadSheet.ADMIN.getSheetName();
		String expTestScriptName= "CreatePackage";
		Map<String, String> sheetData = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "CreatePackage");
		
		
		String packageName = sheetUtility.getData(sheetName,expTestScriptName , "packagename");
		String packageType = sheetUtility.getData(sheetName,expTestScriptName , "packagetype");
		String packageLocation = sheetUtility.getData(sheetName,expTestScriptName , "packagelocation");
		String packagePrice = sheetUtility.getData(sheetName,expTestScriptName , "packageprice");
		String packageFeatures = sheetUtility.getData(sheetName,expTestScriptName , "packagefeatures");
		
		String packageDetails = sheetUtility.getData(sheetName,expTestScriptName , "packagedetails");
		String packageImage = sheetUtility.getData(sheetName,expTestScriptName , "packageimage");
		
		
		
//		FileInputStream fis_excel= new FileInputStream("./src/test/resources/Excel/TestData.xlsx");
//		
//		String sheetName = "admin";
//		String expTestScriptName= "CreatePackage";
//		String expTestScriptName1= "ManagePackage";
//		
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

//		wb.close();
//		fis_excel.close();

		
//		int random = new Random().nextInt(1000);
//		String p_name = map.get("packagename")+random;
		String p_name =packageName+ javaUtil.getRandomNumber(1000);

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
/*		WebDriver driver = seleniumUtil.launchBrowser("chrome");
*/	
		JavaScriptUtility javaScriptUtil = new JavaScriptUtility(driver);
	
//		driver.manage().window().maximize();
		webDriverUtil.maximiseWindow(driver);
			
		
//		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		webDriverUtil.waitForPageLoad(driver);


//		driver.get(url);
		webDriverUtil.getApplication(driver, url);

		
		HomePage homePage = new HomePage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminTourPackagePage adminTourPackagePage = new AdminTourPackagePage(driver);
		AdminCreatePackagePage adminCreatePackagePage = new AdminCreatePackagePage(driver);
		AdminManagePackagePage adminManagePackagePage = new AdminManagePackagePage(driver);
		AdminUpdatePackagePage adminUpdatePackagePage = new AdminUpdatePackagePage(driver);
		
		
		homePage.homePageAction(LinkNames.ADMIN_LOGIN);
//		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		
		adminLoginPage.adminLoginPageAction(admin_username, admin_password);
//		driver.findElement(By.name("username")).sendKeys(admin_username);
//		driver.findElement(By.name("password")).sendKeys(admin_password);
//		driver.findElement(By.name("login")).click();

		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
//		driver.findElement(By.xpath("//span[text()=' Tour Packages']")).click();  // Tour Packages of Admin
		
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.CREATE);
//		driver.findElement(By.xpath("//a[text()='Create']")).click();

		
		adminCreatePackagePage.adminCreatePackagePageAction(sheetData,javaScriptUtil);
//		driver.findElement(By.id("packagename")).sendKeys(p_name);
//		driver.findElement(By.id("packagetype")).sendKeys(packageType);  
//		driver.findElement(By.id("packagelocation")).sendKeys(packageLocation);				//map.get("packagelocation") -> using map
//		driver.findElement(By.id("packageprice")).sendKeys(packagePrice);
//		driver.findElement(By.id("packagefeatures")).sendKeys(packageFeatures);

//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,600)");

//		javaScriptUtil.scrollAction();

//		driver.findElement(By.id("packagedetails")).sendKeys(packageDetails);
//		driver.findElement(By.id("packageimage")).sendKeys(packageImage);


		adminCreatePackagePage.submitAction();
//		driver.findElement(By.xpath("//button[text()='Create']")).click();

		
		String expected = "Package Created Successfully";
		String actual = driver.findElement(By.xpath("//div[text()=':Package Created Successfully ']")).getText();


		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package Created Successfully");
//		if(actual.contains(expected))
//		{
//			System.out.println(p_name+"   Package Created Successfully");
//		}
//		else
//		{
//			System.out.println("Package Not Created ");
//		}
		
		
//		DataFormatter df1 = new DataFormatter();  // Data formatter is going to fetch all string, numeric data in String format 
//
//		Workbook wb1 = WorkbookFactory.create(fis1);		// import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//		Sheet sheet1= wb.getSheet(sheetName); 		// import org.apache.poi.ss.usermodel.Sheet;

//		int rowCount1 = sheet.getLastRowNum(); // index

//		again above statements not required
		
//		Map<String,String> map1 = new HashedMap<>();
//		
//		
//		for(int i=1;i<=rowCount;i++)
//		{
//			String testScriptName1 = df.formatCellValue(sheet.getRow(i).getCell(0));
//
//
//			if(testScriptName1.equalsIgnoreCase(expTestScriptName1))
//			{
//
//				for(int j=1;j<sheet.getRow(i).getLastCellNum(); j++)
//				{
//
//					String key1 = df.formatCellValue(sheet.getRow(i).getCell(j));
//
//					String value1= df.formatCellValue(sheet.getRow(i+1).getCell(j));
//					map1.put(key1, value1);
//				}
//				break;
//			}
//			
//		}
//
//		wb.close();
//		fis_excel.close();

		
		
		adminHomePage.adminHomePageAction(TabNames.TOUR_PACKAGES);
//		driver.findElement(By.xpath("//span[text()=' Tour Packages']")).click();
		
		adminTourPackagePage.adminTourPackagePageAction(LinkNames.MANAGE);
//		driver.findElement(By.xpath("//a[text()='Manage']")).click();
		
		String sheetName1 = SpreadSheet.ADMIN.getSheetName();
		String expTestScriptName1= "ManagePackage";
		Map<String, String> sheetData1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(), "ManagePackage");
		
		
		String packageName1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagename");
		String packageType1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagetype");			// using only this
		String packageLocation1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagelocation");
		String packagePrice1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packageprice");
		String packageFeatures1 = sheetUtility.getData(SpreadSheet.ADMIN.getSheetName(),expTestScriptName1 , "packagefeatures");
		
		WebElement web = driver.findElement(By.xpath("//tbody/tr[last()]"));
//		jse.executeScript("arguments[0].scrollIntoView(true)",web);

		javaScriptUtil.scrollUptoParticularWebElement(web);

		//	country is India
		//	span[text()=' India']
		//	(//span[text()=' India'])[1]/../..//button[1]
		//	driver.findElement(By.xpath("(//span[text()='Switzerland'])[1]/../..//button[1]"));

		
		adminManagePackagePage.viewDetailsButtonClickAction(javaScriptUtil);
//		driver.findElement(By.xpath("//tbody/tr[last()]/td[7]/descendant::button[text()='View Details']")).click();;

		
		adminUpdatePackagePage.adminUpdatePackagePageAction(packageType1);
//		driver.findElement(By.id("packagetype")).clear();
//		driver.findElement(By.id("packagetype")).sendKeys(packageType1);

//		jse.executeScript("window.scrollBy(0,600)");
		javaScriptUtil.scrollAction();

		
		adminUpdatePackagePage.updateButtonAction();
//		driver.findElement(By.name("submit")).click();

		String manage_expected = "Package Updated Successfully";
		String manage_actual = driver.findElement(By.xpath("//div[text()=':Package Updated Successfully ']")).getText();

		verifyUtil.partialVerify(actual, expected, "ELEMENT", "Package Updated Successfully");

//		if(manage_actual.contains(manage_expected))
//		{
//			System.out.println(p_name+"   Package Updated Successfully");
//		}
//		else
//		{
//			System.out.println("Package Not Updated ");
//		}

		

	}

}
