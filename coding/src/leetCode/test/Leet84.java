package leetCode.test;

import java.util.Stack;

public class Leet84 {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			if (!stack.isEmpty()) {
				int index = stack.peek();
				while (heights[i] < heights[index]) {
					index = stack.pop();
					int tmp = stack.isEmpty() ? 0 : stack.peek();
					max = Math.max(max, (i - tmp) * heights[index]);
					if (stack.isEmpty()) {
						break;
					}
					index = tmp;
				}
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int tmp = stack.isEmpty() ? 0 : stack.peek();
			max = Math.max(max, (heights.length - 1 - tmp) * heights[index]);
		}
		return max;
	}
}
