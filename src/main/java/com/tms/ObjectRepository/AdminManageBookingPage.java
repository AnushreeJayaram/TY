package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminManageBookingPage 
{
	@FindBy(xpath = "//table/tbody/tr[last()]/td[last()]//a[text()='Confirm']") private WebElement confirmButton;

	
	public AdminManageBookingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void adminManageBookingPageAction()
	{
		confirmButton.click();
	}
	
}
