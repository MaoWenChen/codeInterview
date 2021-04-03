package leetCode.test;

import java.util.Arrays;
import java.util.List;

public class Leet120 {

	public static void main(String[] args) {

		List<List<Integer>> lists = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
		minimumTotal(lists);
	
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			for (int i = triangle.size() - 2; i >= 0; i--) {
				List<Integer> ts = triangle.get(i);
				List<Integer> tmp = triangle.get(i + 1);
				for (int j = 0; j < ts.size(); j++) {
					ts.set(j, ts.get(j) + Math.min(tmp.get(j), tmp.get(j + 1)));
				}
			}
		}
		return triangle.get(0).get(0);

	}

}
