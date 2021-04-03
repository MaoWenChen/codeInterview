package leetCode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leet47 {

	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		dfs(0, nums);
		return res;
	}

	public void dfs(int cur, int[] nums) {
		if (cur == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			res.add(list);
		} else {
			for (int i = cur; i < nums.length; i++) {
				if (cur != i && nums[i] == nums[i - 1]) {
					continue;
				}
				swap(nums, cur, i);
				dfs(cur + 1, nums);
				swap(nums, cur, i);
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}


}
