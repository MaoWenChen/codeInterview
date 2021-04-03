package genericType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ArrayTest {
	public static void main(String[] args) {
//		test();
		Object[] objs = new Object[2];
		objs[0] = 1;
		objs[1] = "123";
		HashMap<String, Integer> map = new HashMap<>();
		map.keySet();
		map.values();
		TreeMap<String, Integer> sMap = new TreeMap<>();
		sMap.comparator();
		LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>();
		ArrayList<String> ls = new ArrayList<>();
		ls.add("a");
		ls.add("c");
		System.out.println(Arrays.toString(ls.toArray()));
		Integer[] is = ls.toArray(new Integer[0]);
		System.out.println(Arrays.toString(is));

	}

	private static void test1() {
		double a = 1.0 - 0.9;
		double b = 0.8 - 0.7;
		System.out.println(a == b);

		Integer[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(Arrays.binarySearch(arr, 2));
		System.out.println(Arrays.binarySearch(arr, 2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		}));
		System.out.println(arr[0]);
	}

	@SuppressWarnings("unchecked")
	private static void test() {
		List[] list = new List[10];
		List<String>[] ls = (List<String>[]) list;
		list[1] = new ArrayList<Integer>();
		list[0] = new ArrayList<String>();
		ls[2] = new ArrayList<String>();

		Object[] objs1 = new Object[2];
		Object[] objs = ls;

		objs1[0] = new String("22");
		objs1[1] = list;
		list = (List[]) objs1;// 不能把父类型的转换成子类型；运行时报错
		objs[4] = new String("66666");// 编译不报错；运行报错，因为创建的是保存list的数组

	}
}
