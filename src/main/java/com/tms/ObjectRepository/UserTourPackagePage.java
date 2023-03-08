package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.genericutility.webactions.JavaScriptUtility;

public class UserTourPackagePage 
{
	private WebDriver driver;
	 
//	private String linkPartialXpath = "//a[.='%s']";
	 
	@FindBy(xpath="//h4[text()='Package Name: Sakleshpura']") private WebElement packageSakaleshpurName;
	@FindBy(xpath="//a[@href='package-details.php?pkgid=9']") private WebElement packageSakaleshpurDetailsLink;
		
	
	
	/**
	 * This method is used to convert partialXpath String into WebElement 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
/*	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
		
	}
*/
	

	
//	@FindBy(xpath = "//a[text()='Create']") private WebElement adminTourPackageCreate;

//	@FindBy(xpath = "//a[text()='Manage']") private WebElement adminTourPackageManage;


	/**
	 * This method is used for initialization
	 * @param driver
	 */
	//initialization
	public UserTourPackagePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for utilization
	 * @return 
	 */
	//utilization  ==> business logic
	

	public void packageSakaleshpurDetailsLinkAction(JavaScriptUtility j)
	{
		j.scrollUptoParticularWebElement(packageSakaleshpurName);
		packageSakaleshpurDetailsLink.click();
//		convertToWebElement(linkPartialXpath, linkName.getLink()).click();
	}
	
	

}
