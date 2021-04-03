package oop;

public class ConstructorTest {

	public static void main(String[] args) {
		new SubClass();
	}
}

class SuperClass {
	private int i = 1;

	public SuperClass() {
		init1();
		init2();
		init();
	}

	private void init1() {
		System.out.println("SuperClass Private" + i);
	}

	protected void init() {
		System.out.println("SuperClass protected" + i);
	}

	public static void init2() {
		System.out.println("SuperClass static");
	}
}

class SubClass extends SuperClass {
	private int i = 2;
	
	SubClass(){
		init1();
		init2();
		init();
	}
	
	
	private void init1() {
		System.out.println("SubClass Private" + i);
	}

	protected void init() {
		System.out.println("SubClass protected" + i);
	}

	public static void init2() {
		System.out.println("SubClass static");
	}

}