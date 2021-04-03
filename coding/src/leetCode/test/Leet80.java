package leetCode.test;

import java.util.HashMap;
import java.util.Map;

public class Leet80 {
	public int removeDuplicates(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 0);
			}
			map.put(nums[i], map.get(nums[i]) + 1);
			if (map.get(nums[i]) <= 2) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}
	
	public int removeDuplicates1(int[] nums) {
		if (nums.length==0) {
			return 0;
		}
		int preNum = nums[0];
		int times = 1;
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]==preNum) {
				times++;
			}else {
				preNum = nums[i];
				times = 1;
			}
			if (times<=2) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}

}
