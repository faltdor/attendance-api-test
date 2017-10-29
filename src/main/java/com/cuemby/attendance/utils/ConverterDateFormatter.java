package com.cuemby.attendance.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class ConverterDateFormatter {

	public static final SimpleDateFormat DDMMYYY = new SimpleDateFormat("dd-MM-yyyy");
	public static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");

	public static final Date getDateFromString(String dateToParse, SimpleDateFormat formatter)
			throws ParseException, DateTimeParseException {
		
		
		Date date = formatter.parse(dateToParse);

		return date;
	}

}
