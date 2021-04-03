package leetCode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leet46 {
	private List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		dfs(0, nums);
		return lists;

	}

	private void dfs(int cur, int[] nums) {
		if (cur == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			lists.add(list);
		} else {
			for(int i = cur;i<nums.length;i++) {
				swap(cur, i, nums);
				dfs(cur+1, nums);
				swap(cur, i, nums);
			}
		}
	}

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
