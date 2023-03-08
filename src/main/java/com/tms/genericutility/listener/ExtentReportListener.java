package com.tms.genericutility.listener;

import java.io.IOException;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tms.genericutility.BaseClass.BaseClassPractice;
import com.tms.genericutility.BaseClass.ConfigClass;
import com.tms.genericutility.annotation.Report;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.enums.PropertyKey;
import com.tms.genericutility.externalfileutility.PropertyFileUtility;
import com.tms.genericutility.misc.JavaUtility;
import com.tms.genericutility.misc.ReportUtility;
import com.tms.genericutility.misc.UtilityInstanceTransfer;

/**
 * 
 * @author Anu H Jayaram Vivek
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener
{
	//ITestResult-> to fetch the data during Runtime 
	private ReportUtility report;
	public static ReportUtility sreport;

	/**
	 * 
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart --->  Suite");

		report = new ReportUtility();
		
		sreport = report;
	}


	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onStart  -->  Suite");
		report.saveReport();
	}


	/**
	 * before executing the tag
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart  -->  Test");

		/*		PropertyFileUtility propUtils = null;

//		try {
			propUtils = new PropertyFileUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}


		report = new ReportUtility(FrameworkConstants.EXTENT_REPORT_PATH,	
				propUtils.getPropertyData(PropertyKey.EXTENTREPORTTITLE),
				propUtils.getPropertyData(PropertyKey.EXTENTREPORTNAME),
				propUtils.getPropertyData(PropertyKey.BROWSER));
		 */	
	}

	/**
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.category());
	}

	/**
	 * 
	 */
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is pass");
		//		report.pass(result.getMethod().getMethodName()+"is pass");

	}

	/**
	 * 
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");

		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"is failed");
		//		report.fail(result.getMethod().getMethodName()+"is failed");	
		//		report.fail(result.getThrowable());

		String screenShotPath = null;

		//		try {
		//			screenShotPath = BaseClassPractice.class.cast(result.getMethod().getInstance()).seleniumUtil.getScreenshot(
		//					result.getMethod(). getRealClass().getSimpleName(),
		//					BaseClassPractice.class.cast(result.getMethod().getInstance()).javaUtil);
		//		} catch (IOException e) {
		//		
		//			e.printStackTrace();
		//		}


		screenShotPath = ConfigClass.class.cast(result.getMethod().getInstance()).seleniumUtil.getScreenshot();	

		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(), screenShotPath, result.getMethod().getMethodName(), "base64");
		//		report.attachScreenshot(screenShotPath, result.getMethod().getMethodName(), "base64");		

	}

	/**
	 * 
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");

		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+"is skipped",result.getThrowable());

		//		report.skip(result.getMethod().getMethodName()+"is skipped");
		//		report.skip(result.getThrowable());

	}

	/**
	 * 
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");

	}

	/**
	 * 
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}


	/**
	 * 
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish  --->  Test");
		//		report.saveReport();
	}


}
