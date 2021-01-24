package com.wenkai.server.complexicatest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AvailableDateUtil {

	public static boolean checkDateAvailable(String originDate) throws ParseException
	{
		
		//Original Date format: yyyy-MM-dd
		boolean result = true;
		
		//String dateFormat = "yyyy-MM-dd";
		//String originDateTime = originDate + " " + "00:00:00";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date originDateD = df.parse(originDate);
		//String currentDateSdf=df.format(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(originDateD);
		long time1 = cal.getTimeInMillis();
		cal.setTime(new Date());
		long time2 = cal.getTimeInMillis();
		long betweenDaysLong=(time2-time1)/(1000*3600*24);
		int betweenDaysInt = Integer.parseInt(String.valueOf(betweenDaysLong));
		
		if(betweenDaysInt > 5 || betweenDaysInt < 0)
		{
			result = false;
		}
		
		return result;
	}
}
