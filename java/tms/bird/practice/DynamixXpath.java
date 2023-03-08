package tms.bird.practice;

public class DynamixXpath {

	public static void main(String[] args) 
	{
	
//		Dynamic can be done in 2 ways
		
//		1st way
		String linkXpath="//a[.='###']";
		String xpath = linkXpath.replace("###", "Admin Login");
		System.out.println(xpath);

//		2nd way
		String partialXpath ="//a[.='%s']";
		String x = String.format(partialXpath, "Admin Login");
		System.out.println(x);
	}

}
