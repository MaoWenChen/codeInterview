package base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DoubleTest {

	public static void main(String[] args) {
		System.out.println(Byte.class==byte.class);
		System.out.println(Byte.class);
		System.out.println(byte.class);
		
		testScole();
	}

	// 测试浮点数保留几位小数四舍五入
	public static void testScole() {
		// 1.
		BigDecimal a = new BigDecimal(1.2345);
		System.out.println(a.setScale(2, RoundingMode.HALF_UP).doubleValue());
		// 2.
		NumberFormat b = NumberFormat.getInstance();
		b.setMaximumFractionDigits(2);
		b.setRoundingMode(RoundingMode.UP);
		System.out.println(b.format(1.2345));
		// 3.
		DecimalFormat c = new DecimalFormat("#.00");
		System.out.println(c.format(1.2345));
		// 4.
		System.out.println(String.format("%.2f", 1.2345));
	}

	// 浮点数比较要用bigdecimal来比较
	public static void testEquals() {
		double a = 0.9 - .8;
		double b = .8 - .7;
		System.out.println("a=" + a + ": b=" + b + " : a==b:" + (a == b));
		Double c = new Double(0.9 - .8);
		Double d = new Double(.8 - .7);
		System.out.println(c.equals(d));

		BigDecimal ba = new BigDecimal("1.0");
		BigDecimal bb = new BigDecimal("0.9");
		BigDecimal bc = new BigDecimal("0.8");
		BigDecimal bx = ba.subtract(bb);// 0.1
		BigDecimal by = bb.subtract(bc);// 0.1
		System.out.println(bx.equals(by));// true

	}

	public static void test1() {
		double d = 0.000012345678987654321;
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(122);
		System.out.println(format.format(d));
	}

	public static void test() {
		double d = 1.12345678987654321;// 浮点数的有效位数为不算小数点并重第一个不为0的数字算起一共16-17位
		System.out.println(d);
		Double d1 = new Double(1.12345678987654321);
		System.out.println(d1);
		d1 = Double.valueOf("0.012345678987654321");
		System.out.println(d1);
		d1 = 100.012345678987654321;
		System.out.println(d1);
		d1 = 0.00000000000000012345678987654321;
		System.out.println(d1);
		float f = 321.12345678987654321f;// 浮点数的有效位数为不算小数点并重第一个不为0的数字算起一共7-8位
		System.out.println(f);
		f = 1.12345678987654321f;
		System.out.println(f);
		f = 0.0012345678987654321f;
		System.out.println(f);
	}
}
