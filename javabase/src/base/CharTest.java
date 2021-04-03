package base;

import java.math.BigDecimal;
import java.nio.charset.Charset;

public class CharTest {
	public static void main(String[] args) {

		test2();
	}

	public static void test1() {
		String c = "a";
		System.out.println(Character.codePointAt(c, 0));
		System.out.println(Integer.toHexString(Character.codePointAt("中国", 0)));
		System.out.println(Integer.toHexString("中国".getBytes(Charset.forName("utf-8"))[0]));

		BigDecimal bigDecimal = new BigDecimal(.1);
		System.out.println(bigDecimal);
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(.1)));
	}

	public static void test2() {
		System.out.println(Character.digit('9', 10));
		System.out.println(Character.isLetter(Character.MAX_VALUE));
		System.out.println(Character.TYPE);
		
		System.out.println(Character.getName(0x2F81A));
		System.out.println(Character.toChars(0x2F81A));
		System.out.println(Character.toChars(0x2F81A).length);

	}
}
