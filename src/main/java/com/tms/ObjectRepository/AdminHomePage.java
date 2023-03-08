package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;

public class AdminHomePage 
{
	private WebDriver driver;
	//declaration   --> declaration & initialization are  ==> Elements 
	private String linkPartialXpath = "//span[.='%s']";
	
	
	/**
	 * This method is used to convert partialXpath String into WebElement 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
		
	}
	
	
//	@FindAll({@FindBy(xpath = "//a[text()='/ Sign Up']"),@FindBy(linkText="Sign Up")})   -> uses OR operation 
//	@findBys({@FindBy(xpath = "//a[text()='/ Sign In']"),@FindBy(linkText="Sign In")})		-> uses AND operation
	
	

//	@FindBy(xpath = "//span[text()=' Tour Packages']") private WebElement adminHomeTourPackagesLink;

//	@FindBy(xpath = "//span[text()='Manage Users']") private WebElement adminHomeManageUsersLink;
	
//	@FindBy(xpath = "//span[text()='Manage Booking']") private WebElement adminHomeManageBookingLink;
//
//	@FindBy(xpath = "//span[text()='Manage Issues']") private WebElement adminHomeManageIssuesLink;
//
//	@FindBy(xpath = "//span[text()='Manage Enquiries']") private WebElement adminHomeManageEnquiriesLink;
//
//	@FindBy(xpath = "//span[text()='Manage Pages']") private WebElement adminHomeManagePagesLink;
//
//	@FindBy(xpath = "//span[text()='Administrator']") private WebElement adminHomeAdministratorLink;


	/**
	 * This method is used for initialization
	 * @param driver
	 */
	//initialization
	public AdminHomePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for utilization
	 */
	//utilization  ==> business logic
	public void adminHomePageAction(TabNames tabName)
	{
		convertToWebElement(linkPartialXpath, tabName.getTab()).click();
		
//		adminHomeTourPackagesLink.click();
//		adminHomeManageUsersLink.click();
//		adminHomeManageBookingLink.click();
//		adminHomeManageIssuesLink.click();
//		adminHomeManageEnquiriesLink.click();
//		adminHomeManagePagesLink.click();
//		adminHomeAdministratorLink.click();


	}


}
