package leetCode.test;

import java.util.Stack;

public class Leet85 {

	public static void main(String[] args) {
		Leet85 leet85 = new Leet85();
		char[][] arg = new char[][] { { '1','1' } };
		System.out.println(leet85.maximalRectangle(arg));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length==0) {
			return 0 ;
		}
		int[] nums = new int[matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '0') {
					nums[j] = 0;
				} else {
					nums[j] += 1;
				}
			}
			max = Math.max(max, max(nums));
		}
		return max;
	}

	public int max(int[] nums) {

		int max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty()) {
				int tmp = stack.peek();
				if (nums[tmp] > nums[i]) {
					stack.pop();
					int pre = stack.isEmpty() ? -1 : stack.peek();
					max = Math.max(max, (pre==-1?(i - pre):(i-pre-1))* nums[tmp]);
				} else {
					break;
				}
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int tmp = stack.pop();
			int pre = stack.isEmpty() ? -1 : stack.peek();
			max = Math.max(max, (nums.length-pre-1)* nums[tmp]);

		}
		return max;
	}
}
