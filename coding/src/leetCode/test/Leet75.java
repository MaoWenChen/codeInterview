package leetCode.test;

public class Leet75 {
	public static void main(String[] args) {
		sortColors(new int[] {2,0,2,1,1,0});
	}
	public static void sortColors(int[] nums) {
		int i = -1;
		int j = nums.length;
		for (int k = 0; k < j; k++) {
			if (nums[k] == 0) {
				++i;
				int tmp = nums[i];
				nums[i] = nums[k];
				nums[k] = tmp;
			}else if(nums[k]==2) {
				j--; 
				int tmp = nums[j];
				nums[j] = nums[k];
				nums[k] = tmp;
				k--;
			}
		}
	}

}
