package leetCode.test;

import java.util.HashSet;

public class Leet128 {
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		int max = 0;
		for (int i : set) {
			if (set.contains(i - 1))
				continue;
			int localMax = 0;
			while (set.contains(i++)) {
				localMax++;
				max = Math.max(max, localMax);
			}
		}
		return max;
	}
}
