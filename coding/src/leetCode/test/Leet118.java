package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>(numRows);
		List<Integer> list = null;
		for (int i = 0; i < numRows; i++) {
			list = new ArrayList<>();
			list.add(1);
			lists.add(list);
			for (int j = 1; j <= i; j++) {
				if (lists.get(i-1).size()>j) {
					list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
				}else {
					list.add(lists.get(i-1).get(j-1));
				}
				
			}
		}
		return lists;

	}

}
