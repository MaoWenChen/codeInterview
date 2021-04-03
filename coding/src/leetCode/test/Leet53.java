package leetCode.test;

public class Leet53 {
	//O(n)
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0 ;
		}
		int maxSum = nums[0];
		int sum = 0;
		for(int i = 0;i<nums.length;i++) {
			if (sum<0) {
				sum = nums[i];
			}else {
				sum +=nums[i];
			}
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

}
