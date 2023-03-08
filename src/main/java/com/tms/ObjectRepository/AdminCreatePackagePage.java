package com.tms.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.genericutility.webactions.JavaScriptUtility;

public class AdminCreatePackagePage 
{
	private WebDriver driver;
	//declaration   --> declaration & initialization are  ==> Elements 
	private String linkPartiallocator = "%s";
	@FindBy(name = "submit") private WebElement adminCreateButton;
	
	/**
	 * This method is used to convert partialXpath String into WebElement 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialLocator, String replaceData)
	{
		String idLocator = String.format(partialLocator, replaceData);
		return driver.findElement(By.id(idLocator));
		
	}

//	@FindBy(id = "packagename") private WebElement adminCreatePackagePackageName_TextField;

//	@FindBy(id = "packagetype") private WebElement adminCreatePackagePackageType_TextField;
	
//	@FindBy(id = "packagelocation") private WebElement adminCreatePackagePackageLocation_TextField;
	
//	@FindBy(id = "packageprice") private WebElement adminCreatePackagePackagePrice_TextField;
	
//	@FindBy(id = "packagefeatures") private WebElement adminCreatePackagePackageFeatures_TextField;
	
//	@FindBy(id = "packagedetails") private WebElement adminCreatePackagePackageDetails_TextField;
	
//	@FindBy(id = "packageimage") private WebElement adminCreatePackagePackageImage_Button;
	


	/**
	 * This method is used for initialization
	 * @param driver
	 */
	//initialization
	public AdminCreatePackagePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	
	//utilization  ==> business logic

	/**
	 * This method is used tp set the dat in all field from excel sheet
	 * @param packageInfo
	 */
	public void adminCreatePackagePageAction(Map<String, String> packageInfo,JavaScriptUtility j)
	{
		for(Entry<String,String> keyValue : packageInfo.entrySet())
			
		{
			String key = keyValue.getKey();
			if(key.equals("packagedetails"))
			{
				j.scrollDown();
				convertToWebElement(linkPartiallocator, keyValue.getKey()).sendKeys(keyValue.getValue());
			}
			else {
				convertToWebElement(linkPartiallocator, keyValue.getKey()).sendKeys(keyValue.getValue());
			}
			
		}
	}
	

	public void submitAction()
	{
		adminCreateButton.click();
	}
}
