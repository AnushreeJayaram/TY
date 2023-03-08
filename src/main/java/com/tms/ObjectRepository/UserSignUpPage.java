package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;

//This Object repository has elements & business actions 

public class UserSignUpPage 
{
	//declaration   --> declaration & initialization are  ==> Elements 
	
	@FindBy(name = "fname") private WebElement user_SignUP_FnameTextField;
	
	@FindBy(name = "mobilenumber") private WebElement user_SignUP_MobileNumTextField;
	
	@FindBy(id = "email") private WebElement user_SignUP_EmailTextField;
	
	@FindBy(xpath = "//h3[text()='Create your account ']/following-sibling::input[@name='password']") private WebElement user_SignUP_PasswordTextField;
	
	@FindBy(id = "submit") private WebElement user_SignUP_SubmitButton;
	
	//initialization
	
	public UserSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void userSignUpAction(String name, String mobile, String email, String password)
	{
		user_SignUP_FnameTextField.sendKeys(name);
		user_SignUP_MobileNumTextField.sendKeys(mobile);
		user_SignUP_EmailTextField.sendKeys(email);
		user_SignUP_PasswordTextField.sendKeys(password);
		user_SignUP_SubmitButton.click();
	}
	
}
