package com.tms.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tms.ObjectRepository.enums.LinkNames;

//This Object repository has elements & business actions

public class UserSignInPage {

	// declaration --> declaration & initialization are ==> Elements

	@FindBy(css = "[placeholder='Enter your Email']")
	private WebElement user_SignIn_EmailTextField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement user_SignIn_PasswordTextField;

	@FindBy(name = "signin")
	private WebElement user_SignIn_Button;

	
	

	// initialization
	public UserSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public void userSignInAction(String email, String password) {
		user_SignIn_EmailTextField.sendKeys(email);
		user_SignIn_PasswordTextField.sendKeys(password);
		user_SignIn_Button.click();
	}


}
