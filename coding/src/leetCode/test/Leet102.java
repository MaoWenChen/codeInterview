package leetCode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> lists = new ArrayList<>();
		if (root == null) {
			return lists;
		}
		List<Integer> list = new ArrayList<>();
		TreeNode last = root;
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			list.add(node.val);
			if (node.left!= null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node == last) {
				lists.add(list);
				list = new ArrayList<>();
				if (!queue.isEmpty()) {
					last = queue.getLast();
				}
				
			}
		}
		return lists;
	}

}
