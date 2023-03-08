package com.tms.genericutility.BaseClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.externalfileutility.PropertyFileUtility;
import com.tms.genericutility.externalfileutility.SpreadSheetUtility;
import com.tms.genericutility.listener.ExtentReportListener;
import com.tms.genericutility.misc.JavaUtility;
import com.tms.genericutility.misc.VerificationUtility;
import com.tms.genericutility.webactions.InteractionUtility;
import com.tms.genericutility.webactions.JavaScriptUtility;
import com.tms.genericutility.webactions.PopupsUtility;
import com.tms.genericutility.webactions.SeleniumUtility;
import com.tms.genericutility.webactions.WebDriverUtility;
import com.tms.ObjectRepository.HomePage;


/**
 * This class contains TestNG configuration of common actions
 * @author Anu H Jayaram Vivek
 *
 */
// BaseClass

public class ConfigClass extends Declaration
{
	/**
	 * This method is used to initiallize the generic utilities class and common data
	 * This method is used to launch the browser and application
	 */
	
	@Parameters(value="browser")				//import org.testng.annotations.Parameters;
	@BeforeClass(alwaysRun = true)
	public void bcConfigSetup(@Optional String browser)
	{
		
//		generic utilities
		propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		sheetUtility = new SpreadSheetUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
//		waitUtil = new WaitUtility();
		webDriverUtil = new WebDriverUtility();
		popupsUtil = new PopupsUtility();
		javaUtil= new JavaUtility();				// always initializers should be at top
		verifyUtil = new VerificationUtility();
		report=ExtentReportListener.sreport;
		
		
//common data

		if(browser==null || browser.isEmpty() || browser.equals(""))
		{
			browser = propUtils.getPropertyData(PropertyKey.BROWSER);	
		}
		this.browser=browser;		
		
//		driver = webDriverUtil.launchBrowser(propUtils.getPropertyData(PropertyKey.BROWSER),"");
		driver = webDriverUtil.launchBrowser(browser,"");
		seleniumUtil = new SeleniumUtility();
		timeunit = Long.parseLong(propUtils.getPropertyData(PropertyKey.TIMEUNIT));
		url = propUtils.getPropertyData(PropertyKey.URL);
		admin_username = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_USERNAME));    // decode password   admin->YWRtaW4=
		admin_password = javaUtil.decode(propUtils.getPropertyData(PropertyKey.ADMIN_PASSWORD));   // decode password, as password is in encrpted format  Test@123->VGVzdEAxMjM=
		user_username = propUtils.getPropertyData(PropertyKey.USER_USERNAME);
		user_password = propUtils.getPropertyData(PropertyKey.USER_PASSWORD);
		
		homePage = new HomePage(driver);
		javaScriptUtil = new JavaScriptUtility(driver);
		interactUtil = new InteractionUtility(driver);
		webDriverUtil.maximiseWindow(driver);
		webDriverUtil.waitForPageLoad(driver);    // timeunit can be considered
		webDriverUtil.getApplication(driver, url);

	}
	
	/**
	 * This method is used to close the browser
	 */
	@AfterClass(alwaysRun = true)
	public void acConfigTearDown()
	{
		driver.quit();
		sheetUtility.close();
	}
	
	
}


