package tms.bird.testngPractise;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportPratice 
{
	
	
	@Test
	public void report()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/extentReport.html");	// this class contains only template
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(spark);	// will store in temporary memory
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", System.getProperty("os, name"));
		report.setSystemInfo("Reporter", "Anu");
		
		
		ExtentTest abcTest = report.createTest("abc");
		abcTest.log(Status.FAIL, "TestCase Fail");
		abcTest.log(Status.PASS, "TestCase PASS");
		abcTest.log(Status.INFO, "TestCase INFO");
		abcTest.log(Status.WARNING, "TestCase WARNING");
		abcTest.log(Status.SKIP, "TestCase SKIP");
		
		ExtentTest xyzTest =report.createTest("xyz");
		xyzTest.log(Status.INFO, "TestCase INFO1");
		xyzTest.log(Status.INFO, "TestCase INFO2");
		xyzTest.log(Status.INFO, "TestCase INFO3");
		xyzTest.log(Status.INFO, "TestCase INFO4");
		xyzTest.log(Status.INFO, "TestCase INFO5");
		
		
		ExtentTest pqr =report.createTest("pqr");
		pqr.fail("TestCase Fail");
		pqr.pass("TestCase Pass");
		pqr.info("TestCase Info");
		pqr.skip("TestCase skip");
		pqr.warning("TestCase warning");
		
		report.flush();	// will store in permanent memory
	}

}
