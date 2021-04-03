package genericType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovariantArrays {

	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();

		for (int i = 0; i < 2; i++) {
			System.out.println(fruit[i].getClass().getSimpleName());
		}

		// fruit[2] = new Fruit(); 编译期间通过，运行时报java.lang.ArrayStoreException
		// List<Fruit> flist = new ArrayList<Apple>();编译不通过
		List<Fruit> tList = new ArrayList<>();
		List<? extends Fruit> fList = new ArrayList<Apple>();// 这种转型不能添加任何对象，只能获取数据
		List<Orange> test = (List<Orange>) fList;
		test.add(new Orange());
//		编译通不过
//		fList.add(new Apple());
//		fList.add(new Fruit());
//		fList.add(new Object());
		fList.add(null);
		System.out.println(fList.get(0));
		System.out.println(fList.get(1));
		fList = Arrays.asList(new Apple(), new Fruit(), new Jonathan());

		for (Fruit f : fList) {
			System.out.println(f.getClass().getSimpleName());
		}
		// *******************************华丽的分割线
		List<? super Apple> aList = new ArrayList<>();
		// 只能存入Apple的子类
		aList.add(new Apple());
		aList.add(new Jonathan());
//		aList.add(new Fruit()); 编译错误
		System.out.println(aList.get(0));// 获取出来的是Object数据

	}

}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}
