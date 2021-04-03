package leetCode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet94 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			} else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}
	List<Integer> lists = new ArrayList<>();
	public List<Integer> inorderTraversal1(TreeNode root) {
		dfs(root);
		return lists;
	}
	public void dfs(TreeNode root) {
		if (root==null) {
			return;
		}
		dfs(root.left);
		lists.add(root.val);
		dfs(root.right);
	}
}
