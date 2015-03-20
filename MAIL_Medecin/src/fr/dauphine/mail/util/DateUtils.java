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

	public static String dateTimeToStr(Date date) {
		String ret = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		ret = formatter.format(date);
		return ret;
	}

	public static Date getEndOfDay(Date day) {
		return getEndOfDay(day, Calendar.getInstance());
	}

	public static Date getEndOfDay(Date day, Calendar cal) {
		if (day == null)
			day = new Date();
		cal.setTime(day);
		cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
		return cal.getTime();
	}

}
