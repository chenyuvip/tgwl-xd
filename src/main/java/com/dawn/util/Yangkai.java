package com.dawn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Yangkai
{

	public static void main(String[] args)
	{
		try
		{
			System.out.println(getCurrentTime(1, 1, "2016-10-10 10:00"));
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
	
	private static String getCurrentTime(Integer hour, Integer minute, String orderTime) throws ParseException
	{
		String pattern = "yyyy-MM-dd HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = DateUtil.parse(orderTime, pattern);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, hour*60+minute);
		
		return sdf.format(calendar.getTimeInMillis());
	}

}
