package tms.bird.testngPractise;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tms.genericutility.constants.FrameworkConstants;
import com.tms.genericutility.misc.ReportUtility;
import com.tms.genericutility.misc.UtilityInstanceTransfer;

public class ExtentReportPratice 
{
	
	
	@Test
	public void report()
	{
		
		ReportUtility report = new ReportUtility();
		report.init();
		
		
		report.createTest("test1");
		report.info(UtilityInstanceTransfer.getExtentTest(), "a1");
		report.info(UtilityInstanceTransfer.getExtentTest(), "b1");
		report.info(UtilityInstanceTransfer.getExtentTest(), "c1");
		
		report.createTest("test2");
		report.info(UtilityInstanceTransfer.getExtentTest(), "a2");
		report.info(UtilityInstanceTransfer.getExtentTest(), "b2");
		report.info(UtilityInstanceTransfer.getExtentTest(), "c2");
		
		report.saveReport();
	}

}
