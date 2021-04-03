package format;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ResourceBundle;

public class ChoiceFormatTest {

	public static void main(String[] args) {
		test2();
	}

	public static void test() {
		double[] limits = { 1, 2, 3, 4, 5, 6, 7 };
		String[] dayOfWeekNames = { "sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		ChoiceFormat format = new ChoiceFormat(limits, dayOfWeekNames);
		ParsePosition status = new ParsePosition(0);
		for (double i = 0.0; i <= 8.0; ++i) {
			status.setIndex(0);
			System.out.println(i + "->" + format.format(i) + "->" + format.parse(format.format(i), status));
		}
		System.out.println(format.toPattern());
	}

	public static void test1() {
		double[] filelimits = { 0, 1, 2 };
		String[] filepart = { "are no files", "is one file", "are {2} files" };
		ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
		Format[] testFormats = { fileform, null, NumberFormat.getInstance() };
		MessageFormat pattform = new MessageFormat("There {0} on {1}");
		pattform.setFormats(testFormats);
		Object[] testArgs = { null, "ADisk", null };
		for (int i = 0; i < 4; ++i) {
			testArgs[0] = new Integer(i);
			testArgs[2] = testArgs[0];
			System.out.println(pattform.format(testArgs));
		}
	}

	public static void test2() {
		ChoiceFormat fmt = new ChoiceFormat(
				"-1#is negative| 0#is zero or fraction | 1#is one |1.0<is 1+ |2#is two |2<is more than 2.");
		System.out.println("Formatter Pattern : " + fmt.toPattern());

		System.out.println("Format with -INF : " + fmt.format(Double.NEGATIVE_INFINITY));
		System.out.println("Format with -1.0 : " + fmt.format(-1.0));
		System.out.println("Format with 0 : " + fmt.format(0));
		System.out.println("Format with 0.9 : " + fmt.format(0.9));
		System.out.println("Format with 1.0 : " + fmt.format(1));
		System.out.println("Format with 1.5 : " + fmt.format(1.5));
		System.out.println("Format with 2 : " + fmt.format(2));
		System.out.println("Format with 2.1 : " + fmt.format(2.1));
		System.out.println("Format with NaN : " + fmt.format(Double.NaN));
		System.out.println("Format with +INF : " + fmt.format(Double.POSITIVE_INFINITY));

	}
}
