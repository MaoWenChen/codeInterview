package leetCode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet107 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		Leet107 leet107 = new Leet107();
		System.out.println(leet107.levelOrderBottom(root));
	}

	private LinkedList<List<Integer>> lists = new LinkedList<>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return lists;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		TreeNode tmp = null;
		List<Integer> list = new ArrayList<Integer>();;
		stack.add(root);
		while (!stack.isEmpty()) {
			tmp = stack.remove();
			if (tmp.left!=null) {
				stack.add(tmp.left);
			}
			if(tmp.right!=null) {
				stack.add(tmp.right);
			}
			list.add(tmp.val);
			if (tmp == node) {
				lists.addFirst(list);
				list = new ArrayList<Integer>();
				node = stack.peekLast();
			}
			
		}
		return lists;

	}

}
