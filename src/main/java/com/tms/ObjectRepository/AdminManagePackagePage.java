package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.genericutility.webactions.JavaScriptUtility;

public class AdminManagePackagePage 
{
	@FindBy(xpath = "//tbody/tr[last()]/td[7]/descendant::button[text()='View Details']") private WebElement viewDetailsButton;
	@FindBy(xpath = "//tbody/tr[last()]") private WebElement lastRow;
	
//	@FindBy(xpath="//span[text()=' Tour Packages']") private WebElement viewDetailsButton;
	
	public AdminManagePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void viewDetailsButtonClickAction(JavaScriptUtility j)
	{
		j.scrollUptoParticularWebElement(lastRow);
		viewDetailsButton.click();
	}
	
}
