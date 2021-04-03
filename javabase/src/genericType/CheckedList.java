package genericType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
	@SuppressWarnings("unchecked")
	public static void oldStleMethod(List probablyDogs) {
		probablyDogs.add(new Catt());
	}

	public static void main(String[] args) {

		List<Dog> dogList1 = new ArrayList<Dog>();
		oldStleMethod(dogList1);
		List<Dog> dogList2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStleMethod(dogList2);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Dog dog = dogList1.get(0);
		} catch (Exception e) {
			System.err.println(e);
		}
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Catt());
		pets.add(new Dog());
		oldStleMethod(pets);
	}

}

class Pet {
}

class Catt extends Pet {
}

class Dog extends Pet {
}
