package genericType;

import java.lang.reflect.Array;

public class BorderTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Drived2 drived2 = new Drived2();
		drived2.set("123456");
		System.out.println(drived2.get());
		
	}

}

class GenericBase<T> {
	private T element;

	public void set(T arg) {
		element = arg;
	}

	public T get() {
		return element;
	}
}

class Drived1<T> extends GenericBase<T> {
}

class Drived2 extends GenericBase {
}