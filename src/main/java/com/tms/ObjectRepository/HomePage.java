package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;

public class HomePage 
{
	private WebDriver driver;
	//declaration   --> declaration & initialization are  ==> Elements 
	private String linkPartialXpath = "//a[.='%s']";
	
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
	
	
//	@FindAll({@FindBy(xpath = "//a[text()='/ Sign In']"),@FindBy(linkText="Sign In")})   -> uses OR operation 
//	@findBys({@FindBy(xpath = "//a[text()='Sign Up']"),@FindBy(linkText="Sign Up")})		-> uses AND operation
	
	
//	
//	@FindBy(xpath = "//a[text()='Admin Login']") private WebElement homeAdminLoginLink;
//
//	@FindBy(xpath = "//a[text()='Sign Up']") private WebElement homeUserSignUpLink;
//
//	@FindBy(xpath = "//a[text()='/ Sign In']") private WebElement homeUserSignInLink;

	// Below are Navigation Tab Links 
	
//	@FindBy(xpath = "//a[text()='Home']") private WebElement homeNavTabLink;
//
//	@FindBy(xpath = "//a[text()='About']") private WebElement homeAboutNavTabLink;
//
//	@FindBy(xpath = "//a[text()='Tour Packages']") private WebElement homeTourPackagesNavTabLink;
//
//	@FindBy(xpath = "//a[text()='Privacy Policy']") private WebElement homePrivacyPolicyNavTabLink;
//
//	@FindBy(xpath = "//a[text()='Terms of Use']") private WebElement homeTermsofUseNavTabLink;
//
//	@FindBy(xpath = "//a[text()=' Enquiry ']") private WebElement homeEnquiryNavTabLink;
//
//	@FindBy(xpath = "//a[text()='Contact Us']") private WebElement homeContactUsNavTabLink;

//	@FindBy(xpath = "//a[text()='/ Logout']") private WebElement homeUserSignInLogout;

//	@FindBy(xpath = "//a[text()='My Tour History']") private WebElement homeUserMyTourHistoryLink;
	
	/**
	 * This method is used for initialization
	 * @param driver
	 */
	//initialization
	public HomePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for utilization
	 */
	//utilization  ==> business logic
	public void homePageAction(LinkNames linkName)
	{
		convertToWebElement(linkPartialXpath, linkName.getLink()).click();
		
//		homeAdminLoginLink.click();
//		homeUserSignUpLink.click();
//		homeUserSignInLink.click();
//		homeNavTabLink.click();
//		homeAboutNavTabLink.click();
//		homeTourPackagesNavTabLink.click();
//		homePrivacyPolicyNavTabLink.click();
//		homeTermsofUseNavTabLink.click();
//		homeEnquiryNavTabLink.click();
//		homeUserMyTourHistoryLink.click();
	}


}
