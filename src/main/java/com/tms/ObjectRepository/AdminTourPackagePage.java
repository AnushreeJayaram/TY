package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;

public class AdminTourPackagePage 
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
	
	

	
//	@FindBy(xpath = "//a[text()='Create']") private WebElement adminTourPackageCreate;

//	@FindBy(xpath = "//a[text()='Manage']") private WebElement adminTourPackageManage;


	/**
	 * This method is used for initialization
	 * @param driver
	 */
	//initialization
	public AdminTourPackagePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for utilization
	 */
	//utilization  ==> business logic
	public void adminTourPackagePageAction(LinkNames linkName)
	{
		convertToWebElement(linkPartialXpath, linkName.getLink()).click();
		
//		adminTourPackageCreate.click();
//		adminTourPackageManage.click();
	}



}
