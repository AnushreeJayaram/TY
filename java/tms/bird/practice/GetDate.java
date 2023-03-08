package tms.bird.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.tms.genericutility.Misc.JavaUtility;

public class GetDate {

	public static void main(String[] args) throws ParseException {

/* simple		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String date = sdf.format(new Date());
		System.out.println(date);
*/
		
/*		String dateString ="01_Mar_2020";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(dateString));
		
		cal.add(Calendar.DAY_OF_MONTH, -3);
		
		String date = sdf.format(cal.getTime());
		System.out.println(date);
*/
		JavaUtility javaUtil = new JavaUtility();
		System.out.println(javaUtil.getCurrentDateTime());  // to print place  it in SOP stmt

	}

}
