package format;

import java.util.Calendar;
import java.util.Locale;

public class CalendarTest {
	
	public static void main(String[] args) {
//		Calendar calendar = test4();
//		test(calendar);
//		test2(calendar);
//		test(calendar);
		System.out.println(System.getProperty("user.dir"));
	}

	public static void test(Calendar calendar) {
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.getTimeInMillis());
		
	}
	
	public static void test1(Calendar calendar) {
		calendar.set(Calendar.YEAR, 1990);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 1);
		calendar.set(Calendar.SECOND, 1);
	}
	
	public static void test2(Calendar calendar) {
		calendar.add(Calendar.YEAR, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.HOUR_OF_DAY, -1);
		calendar.add(Calendar.MINUTE, -1);
		calendar.add(Calendar.SECOND, -1);
	}
	public static void test3(Calendar calendar) {
		calendar.roll(Calendar.YEAR, 1);
		calendar.roll(Calendar.DAY_OF_MONTH, 3);
	}
	
	public static Calendar test4() {
		Calendar calendar = Calendar.getInstance(Locale.US);
		System.out.println(calendar.getActualMaximum(Calendar.DATE));
		System.out.println(calendar.getActualMinimum(Calendar.HOUR));
		System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CHINA));
		System.out.println(calendar.getDisplayName(Calendar.YEAR, Calendar.LONG, Locale.CHINA));
		System.out.println(calendar.getFirstDayOfWeek());
		calendar.clear();
		return calendar;
	}
}
