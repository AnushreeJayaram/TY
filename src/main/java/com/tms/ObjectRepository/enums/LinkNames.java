package com.tms.ObjectRepository.enums;

public enum LinkNames 
{
//	Home links
	ADMIN_LOGIN("Admin Login"),
	USER_SIGNUP("Sign Up"),
	USER_SIGNIN("/ Sign In"),
	HOME("Home"),
	ABOUT("About"),
	TOUR_PACKAGES("Tour Packages"),
	PRIVACY_POLICY("Privacy Policy"),
	TERMS_OF_USE("Terms of Use"),
	ENQUIRY(" Enquiry "),
	CONTACT_US("Contact Us"),
	CREATE("Create"),
	MANAGE("Manage"),	
	ADMIN_LOGOUT(" Logout"),
	USERSIGNIN_LOGOUT("/ Logout"),
	MY_TOUR_HISTORY("My Tour History");
	
	
	private String linkName;
	
	private LinkNames(String linkName)
	{
		this.linkName=linkName;
	}
	
	public String getLink()
	{
		return linkName;
	}

}
