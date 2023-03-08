package com.tms.genericutility.misc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * JavaUtility is one class in generic utility, which contains java specific methods which can be used 
 * across the test scripts/ application 
 * @author Anu H Jayaram Vivek
 *
 */
public class JavaUtility 
{
	private SimpleDateFormat sdf;
	private Calendar cal;
	Robot r;
	
	/**
	 * This method   generate random number
	 * @param boundaryValue
	 * @return
	 */
	public int getRandomNumber(int boundaryValue)
	{
		return new Random().nextInt(boundaryValue);
	}
	
	/**
	 * This method will print the statement
	 * @param output
	 */
	public void consolePrint(Object output)
	{
		System.out.println(output);
	}
	
	/**
	 * This method is used to convert into integer
	 * @param s
	 * @return
	 */
	public int parseNumber(String s)
	{
		return Integer.parseInt(s);
	}
	
	/**
	 * this method will generate the current system date
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}

	/**
	 * This method will generate the current system Date , time in specific format
	 * @return
	 */
	public String getSystemDateInFormate()
	{
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInFormat = date+" "+month+" "+year+" "+time;
		return dateInFormat;
	}
	
	/**
	 * This method is used to convert month name into month number
	 * please specify the pattern as below specified
	 * MMMM ---> month full name(January,February, March...)
	 * MMM ---> month short name(Jan, Feb Mar...)
	 * @param monthName
	 * @param pattern
	 * @return
	 */                         //Jan               MMM
	public int getMonthNumber(String monthName, String pattern)
	{
		int monthNumber = DateTimeFormatter.ofPattern(pattern.toUpperCase())
		.withLocale(Locale.ENGLISH)
		.parse(monthName)
		.get(ChronoField.MONTH_OF_YEAR);
		return monthNumber;
	}
	
	
	/**
	 * This method is used to generate current Date & time in standard format -dd_MM_yyyy_HH_mm_ss
	 * @return
	 */
	public String getCurrentDateTime()
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return sdf.format(new Date());									// import Date from java.util
	}
	
	/**
	 *  This method is used to generate current Date & time in user specified format
	 * @param pattern
	 * @return
	 */
	public String getCurrentDateTime(String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	/**
	 * This method is used to either add or subtract for the user mentioned days
	 * @param days
	 * @return
	 */
	public String addOrSubtractDate(int days)
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());	
		
	}
		
	/**
	 * This method is used to either add or subtract for the user mentioned date & along with the days
	 * @param date
	 * @param days
	 * @return
	 */
	
	public String addOrSubtractDate(String date, int days) 
	{
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());	
		
	}
	
//  @throws ParseException	
//	public String addOrSubtractDate(String date, int days) throws ParseException
//	{
//		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy");
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(sdf.parse(date));
//		cal.add(Calendar.DAY_OF_MONTH, days);
//		return sdf.format(cal.getTime());	
//		
//	}

	/**
	 * This method is used to split
	 * @param s
	 * @param strategy
	 * @return
	 */
	public String[] split(String s, String strategy)
	{
		return s.split(strategy);
	}
	
	/**
	 * This method is used to decrypt the String 
	 * @param s
	 * @return
	 */
	public String decode(String s)
	{
		return new String(Base64.getDecoder().decode(s.getBytes()));
	}
	
	/**
	 * This method is used to encrypt the String
	 * @param s
	 * @return
	 */
	public String encode(String s)
	{
		return new String(Base64.getEncoder().encode(s.getBytes()));
	}
	
	/**
	 * This method is used to ZoomOut the WebPage Window
	 */
	public void performWebpageZoomOut()
	{
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_MINUS);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

//	The given below is assignment 
	/**
	 * This method will return current date
	 * @return
	 */

	public String getCurrentDate()
	{
		sdf = new SimpleDateFormat();
		cal = Calendar.getInstance();
		String date = sdf.format(cal.getTime());
		return date;
	}
	
	/**
	 * This generic method will return the date in particular pattern
	 * @param d
	 * @param pattern
	 * @return
	 */
	public String getStringDate(String d, String pattern)
	{
		sdf = new SimpleDateFormat(pattern);
		cal= Calendar.getInstance();
		
		try {
			cal.setTime(sdf.parse(d));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		String date = sdf.format(cal.getTime());
		return date;
	}

	/**
	 * This generic method will add specific no of days to current date
	 * @param noofdays
	 * @param pattern
	 * @return
	 */
	public String addDayToCurrentDate(int noofdays, String pattern)
	{
		sdf = new SimpleDateFormat(pattern);
		cal = Calendar.getInstance();
		
		String date = sdf.format(cal.getTime());
		
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		return(sdf.format(cal.getTime()));
	}
	
	
	/**
	 * This generic method will subtract specific no of days to current date
	 * @param noofdays
	 * @param pattern
	 * @return
	 */
	public String subtractDayToCurrentDate(int noofdays, String pattern)
	{
		sdf = new SimpleDateFormat(pattern);
		cal = Calendar.getInstance();
		
		String date = sdf.format(cal.getTime());
		
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		return(sdf.format(cal.getTime()));
	}
	
	
	/**
	 * This generic method will add specific no of days to specified date  
	 * @param dateString
	 * @param noofdays
	 * @return
	 */
	public String addDayToDate(String dateString,int noofdays)
	{
		String date="";
		sdf = new SimpleDateFormat("dd_MMM_yyyy");
		cal = Calendar.getInstance();
		
		try {
			cal.setTime(sdf.parse(dateString));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * This generic method will subtract specific no of days to specified date  
	 * @param dateString
	 * @param noofdays
	 * @return
	 */
	public String subtractDayToDate(String dateString,int noofdays)
	{
		String date="";
		sdf = new SimpleDateFormat("dd_MMM_yyyy");
		cal = Calendar.getInstance();
		
		try {
			cal.setTime(sdf.parse(dateString));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
	


	
}






















