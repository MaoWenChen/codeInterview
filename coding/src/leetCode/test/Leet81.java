package leetCode.test;

public class Leet81 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 3, 1 };
		System.out.println(search(nums, 5));
	}

	public static boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[end] == nums[mid] || nums[mid] == nums[start]) {
				for (int i = start; i <= end; i++) {
					if (nums[i] == target) {
						return true;
					}
				}
				return false;
			} else if (nums[end] > nums[mid]) {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}

			} else {
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}

			}
		}
		return false;
	}
}
