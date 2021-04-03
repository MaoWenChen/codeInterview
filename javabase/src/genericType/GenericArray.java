package genericType;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericArray<T> {
	private T[] array;

	@SuppressWarnings("unchecked")
	public GenericArray(int size) {
		array = (T[]) new Object[size];
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return array[index];
	}

	public T[] rep() {
		return array;
	}

	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<>(10);
		// Integer[] ia = gai.rep(); 底层创建的是object数组,所有运行时会报错
		Object[] oa = gai.rep();
		System.out.println(Arrays.toString(oa));
	}
}
