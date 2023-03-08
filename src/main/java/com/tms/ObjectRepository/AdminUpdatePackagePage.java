package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUpdatePackagePage 
{
	@FindBy(id = "packagetype") private WebElement adminUpdatePackagePackageType_TextField;
	@FindBy(name = "submit") private WebElement adminUpdatePackageUpdateButton;
	
	public AdminUpdatePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void adminUpdatePackagePageAction(String data)
	{
		adminUpdatePackagePackageType_TextField.clear();
		adminUpdatePackagePackageType_TextField.sendKeys(data);
	}
	
	public void updateButtonAction()
	{
		adminUpdatePackageUpdateButton.click();
	}
	
}
