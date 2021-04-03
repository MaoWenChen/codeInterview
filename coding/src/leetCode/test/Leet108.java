package leetCode.test;

import java.util.Arrays;

public class Leet108 {
	
	public static void main(String[] args) {
		System.out.println(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length==0) {
			return null;
		}
		int mid = nums.length/2;
		TreeNode root = new TreeNode(nums[mid]);
		int[] left =  mid<=0?new int[0]: Arrays.copyOfRange(nums, 0, mid);
		int[] right = mid>=nums.length-1?new int[0]:Arrays.copyOfRange(nums, mid+1,nums.length);
		root.left = sortedArrayToBST(left);
		root.right = sortedArrayToBST(right);
		return root;
	}
}
