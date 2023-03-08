package com.tms.genericutility.misc;

import com.aventstack.extentreports.ExtentTest;

public class UtilityInstanceTransfer 
{
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	/**
	 * 
	 * @return
	 */
	public static ExtentTest getExtentTest()
	{
		return extentTest.get();
	}

	/**
	 * 
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest)
	{
		extentTest.set(setExtentTest);
	}
}
