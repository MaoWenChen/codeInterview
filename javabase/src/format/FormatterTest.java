package format;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;

public class FormatterTest {
	public static void main(String[] args) {
		test2();
	}

	public static void test() {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("%4$2s %2$2s %1$2s", "a", "b", "c", "d");
		System.out.println(sb.toString());
		formatter.format(Locale.FRANCE, "e=%+10.4f", Math.E);
		System.out.println(sb.toString());
		formatter.format("Amount gained or lost since last statement: $ %(,.2f", Math.PI);
		System.out.println(sb.toString());
	}

	public static void test1() {
		System.out.format("Local time %tT", Calendar.getInstance());
		System.err.format("Unable to open file '%1$s':%2$s", "666","777");
		Calendar c = new GregorianCalendar();
		String s = String.format("Duke's Birthday: %1$tb %1$te, %1$tY", c);
		System.out.println(s);
	}
	
	public static void test2() {
		System.out.println(String.format("%d", 99));
		System.out.println(String.format("%2$5x", 16,15));
		System.out.println(String.format("%10o", 13));
		System.out.println(String.format("%-10o", 13));
		System.out.println(String.format("%010d", 12));
		System.out.println(String.format("%2$-10.2f", 1,10.2));
		System.out.println(String.format("%2$+010.2f", 1,10.2));
		System.out.println(String.format("%,d", 100000));
		System.out.println(String.format("|%,10d|", 10000));
		System.out.println(String.format("%(d", 36));
		System.out.println(String.format("%d", -36));
		System.out.println(String.format("%(d", -36));
		System.out.println(String.format("%o", 12));
		System.out.println(String.format("%x", 12));
		System.out.println(String.format("%X", 12));
		System.out.println(String.format("%b", 0));
		System.out.println(String.format("%#o", 12));
		System.out.println(String.format("%#x", 12));
		System.out.println(String.format("%s", "hello word"));
		System.out.println(String.format("%5s", "hello word"));
		System.out.println(String.format("%.5s", "hello word"));
		System.out.println(String.format("%20.5s", "hello word"));
	}
}
