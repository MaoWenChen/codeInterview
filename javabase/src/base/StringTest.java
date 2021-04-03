package base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Arrays;

public class StringTest {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(Test1.class.getDeclaredFields()));
		System.out.println(Arrays.toString(Test1.class.getFields()));
		for(Field f:Test1.class.getDeclaredFields()) {
			System.out.println(Arrays.toString(f.getDeclaredAnnotations()));
		}
		for(Field f:Test1.class.getDeclaredFields()) {
			System.out.println(Arrays.toString(f.getAnnotations()));
		}
		assert 1!=2:"fdsa";
	}
	
	public static void test() {
		String s ="𡃁妹";
		System.out.println(s.length());
		System.out.println(s.getBytes().length);
		System.out.println(s.toCharArray().length);
		System.out.println(s.codePoints().count());
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
	}

}
class Test1{
	
	@Deprecated
	@Test2
	private int age;
	
	private String name;
	
	@Retention(RetentionPolicy.RUNTIME)
	 private @interface Test2{
		
	}
}