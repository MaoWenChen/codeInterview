package genericType;

public class ArrayOfGeneric {

	static final int SIZE = 100;
	static Generic<Integer>[] gia;

	public static void main(String[] args) {
		gia = new Generic[10];
		System.out.println(gia.getClass().getTypeName());
		gia[0] = new Generic<Integer>();

	}
}

class Generic<T> {
	
}

class CompareblePet implements Comparable<CompareblePet> {

	@Override
	public int compareTo(CompareblePet o) {
		return 0;
	}

}

class Cat extends CompareblePet implements Comparable<CompareblePet> {

}