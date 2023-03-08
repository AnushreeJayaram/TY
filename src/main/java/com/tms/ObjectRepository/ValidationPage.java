package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage 
{

	@FindBy(xpath = "//div[@class='succWrap']") private WebElement validationPath;
	@FindBy(xpath = "//table/tbody/tr[last()]/td[7]") private WebElement lastConfirmRow;
	
	
	public ValidationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used for utilization
	 */
	//utilization  ==> business logic
	
	public String lastConfirmRowAction()
	{
		return lastConfirmRow.getText();

	}
	
	public String validationPageAction()
	{
		return validationPath.getText();

	}
}
