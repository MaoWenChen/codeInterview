package format;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class NumberFormatTest {
	public static void main(String[] args) throws ParseException {
		test1();
	}

	public static void test() {
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
		System.out.println(numberFormat.format(1.2));
		numberFormat.setMaximumIntegerDigits(2);
		numberFormat.setMaximumFractionDigits(3);
		System.out.println(numberFormat.format(1.33));
		System.out.println(numberFormat.format(1.3336));
		numberFormat = NumberFormat.getNumberInstance();
		System.out.println(numberFormat.format(1.2));
		numberFormat = NumberFormat.getIntegerInstance();
		System.out.println(numberFormat.format(1.2));
		numberFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println(numberFormat.format(1.2163456));
		numberFormat = NumberFormat.getPercentInstance();
		System.out.println(numberFormat.format(12.2));
		System.out.println(numberFormat.format(32));
	}
	public static void testParse() throws ParseException {
		NumberFormat numberFormat = NumberFormat.getInstance();
		System.out.println(numberFormat.parse("6666.66"));
		numberFormat.setParseIntegerOnly(true);
		System.out.println(numberFormat.parse("6666.66"));
		numberFormat.setMinimumFractionDigits(3);
		System.out.println(numberFormat.format(66));
		numberFormat.setMinimumIntegerDigits(3);
		System.out.println(numberFormat.format(66));
		System.out.println(numberFormat.getCurrency());
		numberFormat = NumberFormat.getPercentInstance();
		numberFormat.setMaximumIntegerDigits(1);
		System.out.println(numberFormat.format(12.34));
	}
	
	public static void testdecimal() {
		DecimalFormat decimalFormat = new DecimalFormat();
		System.out.println(decimalFormat.format(12.0));
		decimalFormat.setDecimalSeparatorAlwaysShown(true);
		System.out.println(decimalFormat.format(12.0));
		decimalFormat.applyPattern("##,##.00");
		System.out.println(decimalFormat.format(12.0));
		System.out.println(decimalFormat.format(-12.0));
		decimalFormat.setMaximumIntegerDigits(1);
		System.out.println(decimalFormat.format(12.0));
		decimalFormat.applyPattern("yu00.00%");
		System.out.println(decimalFormat.format(12));
		decimalFormat.applyPattern("千分数\u2030");
		System.out.println(decimalFormat.format(0.001));
		decimalFormat.setRoundingMode(RoundingMode.UP);
		decimalFormat.applyPattern("###,##");
	//	decimalFormat.setMaximumIntegerDigits(1);
		System.out.println(decimalFormat.format(12.1));
		System.out.println(decimalFormat.format(1234));
	}
	
	public static void test1() throws ParseException {
		//测试解析附属
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.applyPattern("##.##");
		System.out.println(decimalFormat.format(12.123));
		System.out.println(decimalFormat.parse("-12.123"));
		NumberFormat format = NumberFormat.getPercentInstance();
		System.out.println(format.parse("-12.2%"));
	}
}
