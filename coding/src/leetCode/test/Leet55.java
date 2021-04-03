package leetCode.test;

public class Leet55 {
	public static void main(String[] args) {
		System.out.println(canJump1(new int[] { 2, 0, 1, 0, 1 }));
	}

	public static boolean canJump(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		boolean[] res = new boolean[nums.length];
		res[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = i + 1, len = nums[i] + i; j <= len && j < nums.length; j++) {
				if (res[j]) {
					res[i] = true;
					break;
				}
			}
		}
		return res[0];
	}

	public static boolean canJump1(int[] nums) {
		int maxStep = 0;

		for (int i = 0; i < nums.length&&i<=maxStep; i++) {
			maxStep = Math.max(maxStep, i + nums[i]);
			if (maxStep >= nums.length - 1) {
				return true;
			}
		}
		return maxStep == nums.length;
	}

}
