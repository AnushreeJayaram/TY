package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;

// This Object repository has elements & business actions 
public class AdminLoginPage 
{
	
	//declaration   --> declaration & initialization are  ==> Elements 
		
	@FindBy(name = "username") private WebElement adminUserNameTextField;
	
	@FindBy(name = "password") private WebElement adminPasswordTextField;
	
	@FindBy(name = "login") private WebElement adminSignInButton;
	
	@FindBy(xpath = "//a[text()='Back to home']") private WebElement adminBackToHomeLink;
	
//	@FindAll({@FindBy(xpath = "//a[text()='/ Sign In']"),@FindBy(linkText="Sign Up")}) private WebElement userSignInButton;  //return 1 webelement
	
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//utilization  ==> business logic
	public void adminLoginPageAction(String username, String password)
	{
		
		adminUserNameTextField.sendKeys(username);
		adminPasswordTextField.sendKeys(password);
		adminSignInButton.click();	
	}
	public void adminBackToHomeAction()
	{
		adminBackToHomeLink.click();
	}

	
	
	
}
