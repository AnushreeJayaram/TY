package com.tms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPackageDetailsPage 
{
	@FindBy(xpath = "//input[@id='datepicker']") private WebElement packageDatePickerFrom;
	@FindBy(xpath = "//input[@id='datepicker1']") private WebElement packageDatePickerTo;
	@FindBy(xpath = "//input[@name='comment']") private WebElement packageCommentText;
	@FindBy(xpath = "//button[text()='Book']") private WebElement packageBookButton;
	
	public UserPackageDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public void UserPackageDetailsPageAction()
	{
		packageDatePickerFrom.sendKeys("06-02-2023");
		packageDatePickerTo.sendKeys("20-02-2023");
		packageCommentText.sendKeys("need accomodation as well");
		packageBookButton.click();
	}
}
