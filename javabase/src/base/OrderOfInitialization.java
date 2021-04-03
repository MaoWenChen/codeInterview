package base;

import java.util.Arrays;

public class OrderOfInitialization {
	public static void main(String[] args) {
		House h = new House();
		System.out.println(h.sw.i);
		test(new String[]{"1","2"});
	}
	
	public static void test(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}

class Window {
	public int i;
	public Window(int i) {
		System.out.println("Windo Marker " + i);
		this.i = i;
	}
}

class House {
	Window w1 = new Window(1);
	static {
		sw = new Window(13);
	}
	static Window sw = new Window(24);
	static {
		Window sw1 = new Window(35);
	}

	public House() {
		System.out.println("House()");
		w3 = new Window(33);
	}

	Window w2 = new Window(2);
	{
		w3 = new Window(77);
	}
	Window w3 = new Window(3);

}