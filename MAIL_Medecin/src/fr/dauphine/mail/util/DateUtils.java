package fr.dauphine.mail.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date strToDate(String date) {
		Date ret = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			ret = formatter.parse(date);
		} catch (ParseException ex) {

		}
		return ret;
	}

	public static String dateToStr(Date date) {
		String ret = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ret = formatter.format(date);
		return ret;
	}


}
