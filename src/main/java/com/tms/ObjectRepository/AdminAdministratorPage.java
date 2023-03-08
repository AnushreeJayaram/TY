package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;
import com.tms.ObjectRepository.enums.TabNames;

public class AdminAdministratorPage 
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
	

//	@FindBy(xpath = "//a[text()=' Logout']") private WebElement adminAdministratorLogoutLink;

//	@FindBy(xpath = "//a[text()=' Profile']") private WebElement adminAdministratorProfileLink;


	/**
	 * This method is used for initialization
	 * @param driver
	 */
	//initialization
	public AdminAdministratorPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for utilization
	 */
	//utilization  ==> business logic
	public void adminAdministratorPageAction(LinkNames linkName)
	{
		convertToWebElement(linkPartialXpath, linkName.getLink()).click();
		
//		adminAdministratorLogoutLink.click();
//		adminAdministratorProfileLink.click();



	}


}
