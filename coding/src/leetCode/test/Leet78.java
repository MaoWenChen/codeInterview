package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet78 {
	
	public static void main(String[] args) {
		Leet78 leet78 = new Leet78();
		int[] nums = new int[] {1,2,3};
		System.out.println(leet78.subsets(nums));
	}

	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		dfs(0, nums, new ArrayList<>());
		return res;
	}

	public void dfs(int cur, int[] nums, List<Integer> list) {
		if (cur==nums.length) {
			res.add(new ArrayList<>(list));
		}else {
			dfs(cur+1, nums, list);
			list.add(nums[cur]);
			dfs(cur+1, nums, list);
			list.remove(list.size()-1);
			
		}
	}

}
