package com.tms.genericutility.misc;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.externalfileutility.PropertyFileUtility;

public class ReportUtility {
	private ExtentReports report;
//	private ExtentTest test;

	public ReportUtility() {
		init();
	}

	/**
	 * This is parameterized constructor
	 * 
	 * @param filepath
	 * @param title
	 * @param reportName
	 * @param browserName
	 */

	// public void init()

	public void init()
//	public ReportUtility(String filepath, String title, String reportName, String browserName)
	{

		PropertyFileUtility propUtils = null;

			propUtils = new PropertyFileUtility(FrameworkConstants.REPORT_PROPERTY_FILE_PATH);
			String overrideOrNot= propUtils.getPropertyData(PropertyKey.OVERRIDEREPORT);
			
			String randomName="";
			if(overrideOrNot.equalsIgnoreCase("no"))
			{
				randomName ="_"+ new JavaUtility().getCurrentDateTime();
			}


		ExtentSparkReporter spark = new ExtentSparkReporter(
				FrameworkConstants.EXTENT_REPORT_FOLDER_PATH + "extentReport" + randomName + ".html");
		// in the constructor itself create template

		spark.config().setDocumentTitle(propUtils.getPropertyData(PropertyKey.EXTENTREPORTTITLE));
		spark.config().setDocumentTitle(propUtils.getPropertyData(PropertyKey.EXTENTREPORTNAME));
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", propUtils.getPropertyData(PropertyKey.BROWSER)); // pass key & value
		report.setSystemInfo("OS", System.getProperty("os.name"));

	}

	/**
	 * This method is used to createTest report
	 * 
	 * @param testName
	 */
	public void createTest(String testName) {
		ExtentTest test = report.createTest(testName);
		UtilityInstanceTransfer.setExtentTest(test);
	}

	/**
	 * This method is used to fail report
	 * 
	 * @param message
	 */
	public void fail(ExtentTest test, String message) {
		test.fail(message);
		System.out.println(message);
	}

	/**
	 * This method give name information about author
	 * 
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names) {
		test.assignAuthor(names);
	}

	/**
	 * This method is used to addCategory
	 * 
	 * @param names
	 */
	public void addCategory(ExtentTest test, String... names) {
		test.assignCategory(names);
	}

	/**
	 * This method is used for fail
	 * 
	 * @param errorMessage
	 */
//	public void fail(Throwable errorMessage)
//	{
//		test.fail(errorMessage);
//		System.out.println(errorMessage);
//	}

	/**
	 * This method is used for skip
	 * 
	 * @param errorMessage
	 */
	public void skip(ExtentTest test, String message, Throwable errorMessage) {
		test.skip(message);
		test.skip(errorMessage);
		System.out.println(message);
	}

	/**
	 * This method is used for pass
	 * 
	 * @param message
	 */
	public void pass(ExtentTest test, String message) {
		test.pass(message);
		System.out.println(message);
	}

	/**
	 * This method is used for warning
	 * 
	 * @param message
	 */
	public void warn(ExtentTest test, String message) {
		test.warning(message);
		System.out.println(message);
	}

	/**
	 * This method is used for skip
	 * 
	 * @param message
	 */
	public void skip(ExtentTest test, Throwable errorMsg, String message) {
		test.skip(message);
		test.skip(errorMsg);
		System.out.println(message);
	}

	/**
	 * This method is used for information
	 * 
	 * @param message
	 */
	public void info(ExtentTest test, String message) {
		test.info(message);
		System.out.println(message);
	}

	/**
	 * This method is used to take screenshot
	 * 
	 * @param screenShotPath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenshot(ExtentTest test, String screenShotPath, String title, String strategy) {
		if (strategy.equalsIgnoreCase("base64")) {
			test.addScreenCaptureFromBase64String(screenShotPath, title);
		} else {
			test.addScreenCaptureFromPath(screenShotPath, title);
		}
	}

	/**
	 * This method is used to saveReport
	 */
	public void saveReport() {
		report.flush();
	}

}
