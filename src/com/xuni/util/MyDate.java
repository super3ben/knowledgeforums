package com.xuni.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	public static Date getCurrentDate()  {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String format = df.format(System.currentTimeMillis());
		 Date parse = null;
		try {
			parse = df.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return parse;
	}
}
