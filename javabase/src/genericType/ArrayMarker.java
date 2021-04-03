package genericType;

import java.lang.reflect.Array;

public class ArrayMarker<T> {

	private Class<T> kind;

	public ArrayMarker(Class<T> kind) {
		this.kind = kind;
	}

	@SuppressWarnings("unchecked")
	T[] create(int size) {
		return (T[]) Array.newInstance(kind, size);
	}
}
