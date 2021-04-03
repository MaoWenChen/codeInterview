package genericType;

public class SelfBounded<T extends SelfBounded<T>> {

	public static void main(String[] args) {
		A a = new A();
		a.set(new A());
		a = a.set(new A()).get();
		a = a.get();
		C c = new C();
		c = c.setAndGet(new C());
	}

	T element;

	SelfBounded<T> set(T arg) {
		element = arg;
		return this;

	}

	T get() {
		return element;
	}
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<B> {
}

class C extends SelfBounded<C> {
	C setAndGet(C arg) {
		set(arg);
		return get();
	}
}

class D {
}

/*
 * cant do this class E extends SelfBounded<D>{}
 */

class F extends SelfBounded {
}

interface GenericGetter<T extends GenericGetter<T>> {
	T get();
}

interface Getter extends GenericGetter<Getter> {
}

class TestGenericGetter {
	void test(Getter g) {
		Getter result = g.get();
		GenericGetter gic = g.get();
	}
}
