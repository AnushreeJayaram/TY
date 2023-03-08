package com.tms.genericutility.enums;

/**
 * This enum contains keys which are used in Excel file(SpreadSheet file)
 * @author Anu H Jayaram Vivek
 *
 */
public enum SpreadSheet 
{
	ADMIN("admin"),USER("user"),VALIDATION("validation");
	
	String key;
	
	
	/**
	 * This method is used to set the key
	 * @param key
	 */
	private SpreadSheet(String key)
	{
		this.key=key;
	}
	
	/**
	 * This method is used to get the key
	 * @return
	 */
	
	public String getSheetName()
	{
		return key;
	}
	

}
