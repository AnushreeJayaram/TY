package com.tms.ObjectRepository.enums;

public enum TabNames 
{
//	admin pg tabs
	TOUR_PACKAGES(" Tour Packages"),    // admin Tour Package
	MANAGE_USERS("Manage Users"),
	MANAGE_BOOKING("Manage Booking"),
	MANAGE_ISSUES("Manage Issues"),
	MANAGE_ENQUIRIES("Manage Enquiries"),
	MANAGE_PAGES("Manage Pages"),
	ADMINISTRATOR("Administrator");
	
private String tabName;
	
	private TabNames(String tabName)
	{
		this.tabName=tabName;
	}
	
	public String getTab()
	{
		return tabName;
	}
	

}
