package com.tms.genericutility.webactions;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class contains generic methods of dropdown handle
 * @author Anu H Jayaram Vivek
 *
 */

public class DropdownUtility {

	/**
	 * This method will handle dropdown based on index value
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown based on value
	 * @param element
	 * @param value
	 * @return
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 *  This method will handle dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will give all the options present in dropdown
	 * @param element
	 * @return
	 */
	public List<WebElement> getAllOptionsOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel.getOptions();
	}
	
	/**
	 * This method will return true if dropdown is multiselect
	 * @param element
	 * @return
	 */
	public boolean checkForMultiSelectDDropdown(WebElement element)
	{
		Select sel = new Select(element);
		return sel.isMultiple();
	}
	
	/**
	 * This method will deselect the option by index
	 * @param element
	 * @param index
	 */
	public void deSelectOptionInDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	
	/**
	 * This method will deselect the option by value
	 * @param element
	 * @param value
	 */
	public void deSelectOptionInDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	
	/**
	 * This method will deselect the option by visible text
	 * @param text
	 * @param element
	 */
	public void deSelectOptionInDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	/**
	 * This method will deselect all option in dropdown
	 * @param element
	 */
	public void deSelectOptionInDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}
	
	/**
	 * This method will give all the selected options of the dropdown
	 * @param element
	 */
	public void getAllSelectedOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.getAllSelectedOptions();
	}
	
	/**
	 * This method will give the only first selected options of the dropdown
	 * @param element
	 */
	public void getFirstSelectedOptionOfDropdown(WebElement element)
	{
		Select sel = new Select(element);
		sel.getFirstSelectedOption();
	}

}