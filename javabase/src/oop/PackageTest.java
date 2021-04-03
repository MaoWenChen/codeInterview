package oop;

import baseTest.pack.PackageTest1;

public class PackageTest {

	int i = 3;

	public static void main(String[] args) {
		PackageTest1 test = new PackageTest1();
		// System.out.println(test.i);父包不能访问子包中的包访问权限的成员
	}
}

class Test extends SuperTest {
	{
		i = 1;
	}
	public final int i;
	public static final int a;
	public static final String s ;
	static {
		a = 2;
		s = "123";
	}

	Test() {
		super(1);

	}

	public void test() {

	}
}

class SuperTest {

	SuperTest(int i) {
		System.out.println(i);
	}
}
