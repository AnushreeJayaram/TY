package com.tms.genericutility.misc;
/**
 * VerificationUtility is one class in generic utility, which contains specific Verification methods 
 * @author Anu H Jayaram Vivek
 *
 */

public class VerificationUtility 
{
	
	/**
	 * This method is used for exact verification 
	 * @param actual
	 * @param expected
	 * @param strategy
	 * @param pageOrElementOrTCname
	 */
	public void exactVerify(String actual, String expected,String strategy, String pageOrElementOrTCname)
	{
		String pass="";
		String fail="";
		
		switch(strategy.toUpperCase())
		{
		case "TC": 
			pass= " TC is Pass";
			fail= " TC is Fail";
			break;
			
		case "PAGE":
			pass=" Page Displayed";
			fail=" Page not Displayed";
			break;
			
		case "ELEMENT":
			pass=" is showing";
			fail=" is not showing";
			break;
			
		default:
			break;
		}
		
		if(actual.equals(expected))
		{
			System.out.println(pageOrElementOrTCname + pass);
		}
		else
		{
			System.out.println(pageOrElementOrTCname + fail);
		}
	}

	
	/**
	 * This method is used for partial verification 
	 * @param actual
	 * @param expected
	 * @param strategy
	 * @param pageOrElementOrTCname
	 */
	public void partialVerify(String actual, String expected,String strategy, String pageOrElementOrTCname)
	{
		String pass="";
		String fail="";
		
		switch(strategy.toUpperCase())
		{
		case "TC": 
			pass= " TC is Pass";
			fail= " TC is Fail";
			break;
			
		case "PAGE":
			pass=" Page Displayed";
			fail=" Page not Displayed";
			break;
			
		case "ELEMENT":
			pass=" is showing";
			fail=" is not showing";
			break;
			
		default:
			break;
		}
		
		if(actual.contains(expected))
		{
			System.out.println(pageOrElementOrTCname + pass);
		}
		else
		{
			System.out.println(pageOrElementOrTCname + fail);
		}
	}

}
