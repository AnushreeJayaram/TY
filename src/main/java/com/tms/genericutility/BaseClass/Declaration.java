package com.tms.genericutility.BaseClass;

import org.openqa.selenium.WebDriver;

import com.tms.genericutility.externalfileutility.PropertyFileUtility;
import com.tms.genericutility.externalfileutility.SpreadSheetUtility;
import com.tms.genericutility.misc.JavaUtility;
import com.tms.genericutility.misc.ReportUtility;
import com.tms.genericutility.misc.VerificationUtility;
import com.tms.genericutility.webactions.InteractionUtility;
import com.tms.genericutility.webactions.JavaScriptUtility;
import com.tms.genericutility.webactions.PopupsUtility;
import com.tms.genericutility.webactions.SeleniumUtility;
import com.tms.genericutility.webactions.WaitUtility;
import com.tms.genericutility.webactions.WebDriverUtility;
import com.aventstack.extentreports.ExtentTest;
import com.tms.ObjectRepository.HomePage;

/**
 * This class contains declaration of all generic utilities and common data and common page
 * @author Anu H Jayaram Vivek
 *
 */
public class Declaration 
{
//utility initialization
	protected PropertyFileUtility propUtils;
	protected SpreadSheetUtility sheetUtility;
	public JavaUtility javaUtil;
	public SeleniumUtility seleniumUtil;
	protected WebDriverUtility webDriverUtil;
	protected VerificationUtility verifyUtil;
	protected WaitUtility waitUtil;
	protected JavaScriptUtility javaScriptUtil;
	protected InteractionUtility interactUtil;
	protected PopupsUtility popupsUtil;
	public WebDriver driver;
	protected HomePage homePage;

//common data
	protected String browser;
	protected long timeunit;
	protected String url;
	protected String admin_username;
	protected String admin_password;
	protected String user_username;
	protected String user_password;
	
	public ExtentTest test;
	public ReportUtility report;
}
