package Genericutility;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * This class consits of generic methods related to java
 * @author sushma.goud
 */




public class JavaUtility {

	/**
	 * this method will return the current system dat in specific format
	 * @return
	 * 
	 */
	
	
	
	public  String getSystemDateInFormat()
	{
		Date d=new Date(0);
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String date=sf.format(d);
		return date;
		// TODO Auto-generated method stub

	}

}
