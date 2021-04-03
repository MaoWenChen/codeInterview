package leetCode.test;

public abstract class Leet45 {
	public static void main(String[] args) {
		System.out.println(jump(new int[] {2,3,1,1,4}));
	}

	public static int jump(int[] nums) {
		if (nums.length==0) {
			return 0 ;
		}
		int curMax = -1;
		int nextMax = 0;
		int count = -1;
		for(int i = 0;i<nums.length;i++) {
			if(curMax<i) {
				count++;
				curMax = nextMax;
			}
			nextMax = Math.max(nextMax, nums[i]+i);
		}
		return count;
	}
}
