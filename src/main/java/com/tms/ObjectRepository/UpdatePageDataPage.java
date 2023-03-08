package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatePageDataPage 
{
	@FindBy(xpath = "//select[@name='menu1']") private WebElement selectMenu;
	@FindBy(xpath = "//div[@class=' nicEdit-main  ']") private WebElement aboutUsTextField;
	@FindBy(id = "submit") private WebElement updateButton;
	
	public UpdatePageDataPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

//	public void selectMenu(DropdownUt)

	/*
	public void UserPackageDetailsPageAction()
	{
		packageDatePickerFrom.sendKeys("06-02-2023");
		packageDatePickerTo.sendKeys("20-02-2023");
		packageCommentText.sendKeys("need accomodation as well");
		packageBookButton.click();
	}
	*/
}
