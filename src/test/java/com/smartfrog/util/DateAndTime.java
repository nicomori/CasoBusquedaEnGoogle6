package com.smartfrog.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {

	public static String getDateAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH mm ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
