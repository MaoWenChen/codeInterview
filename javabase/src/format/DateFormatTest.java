package format;

import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.CharacterIterator;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateFormatTest {
	public static void main(String[] args) throws ParseException {
		test7();
	}

	public static void test() throws ParseException {
		System.out.println("\uFFFF");
		System.out.printf("%d", 4);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse("9999-13-32 17:00:00");
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(date));
	}

	public static void test1() {
		Scanner scanner = new Scanner(System.in);
		scanner.nextBigInteger();
	}

	public static void test2() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
		System.out.println(dateFormat.format(new Date()));
		AttributedCharacterIterator aIterator = dateFormat.formatToCharacterIterator(new Date());
		System.out.println(aIterator.current());
		System.out.println(aIterator.getAllAttributeKeys());
	}

	public static void test3() {
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
		System.out.println(dateFormat.format(new Date()));
		AttributedCharacterIterator aIterator = dateFormat.formatToCharacterIterator(new Date());
		System.out.println(aIterator.current());
		System.out.println(aIterator.getAllAttributeKeys());
		while (aIterator.getIndex() != aIterator.getEndIndex()) {
			System.out.println(aIterator.next());
		}

	}

	public static void test4() {
		DateFormat dateFormat = DateFormat.getInstance();
		System.out.println(dateFormat.format(new Date()));

	}

	public static void test5() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM,MM'hhhh',YYYYYYYY,yyy,SSSSS,k,Z,z,X 中国，HHHHH",
				Locale.CHINA);
		simpleDateFormat.setDateFormatSymbols(DateFormatSymbols.getInstance());
		System.out.println(simpleDateFormat.format(new Date()));
		SimpleDateFormat s1 = new SimpleDateFormat("HHH:HH:m:s");
		Date date = s1.parse("5:6:66:01t");
		System.out.println(date);
		System.out.println(new SimpleDateFormat("y-M-d h:m:s").format(date));
		System.out.println(new SimpleDateFormat("y").parse("19"));
	}

	public static void test6() {
		System.out.println(Calendar.getInstance().getWeekYear());
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println(Calendar.getInstance().get(Calendar.DATE));
		System.out.println(Calendar.getInstance().get(Calendar.HOUR));
		System.out.println(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
		System.out.println(Calendar.getInstance().get(Calendar.MONTH));
	}
	
	public static void test7() {
		DateFormat dateFormat = DateFormat.getInstance();
		Date now = new Date();
		System.out.println(dateFormat.format(now));
		StringBuffer stringBuffer = new StringBuffer();
		FieldPosition pos = new FieldPosition(DateFormat.DAY_OF_WEEK_FIELD);
		dateFormat.format(now, stringBuffer, pos);
		System.out.println(stringBuffer.toString());
		stringBuffer.delete(0, stringBuffer.length());
		pos.setBeginIndex(2);
		pos.setEndIndex(0);
		dateFormat.format(now, stringBuffer, pos);
		System.out.println(stringBuffer.toString());
		
		//解析
		try {
			System.out.println(dateFormat.parseObject(stringBuffer.toString()));
			System.out.println(dateFormat.parseObject(stringBuffer.toString(),new ParsePosition(DateFormat.DAY_OF_YEAR_FIELD)));
			System.out.println(dateFormat.parseObject(stringBuffer.toString(),new ParsePosition(DateFormat.ERA_FIELD)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
