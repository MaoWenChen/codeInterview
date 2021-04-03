package leetCode.test;

import java.util.LinkedList;
import java.util.Queue;

public class Leet114 {
	
	private Queue<TreeNode> queue = new LinkedList<TreeNode>();
	
	public void flatten(TreeNode root) {
		preorder(root);
		queue.poll();
		TreeNode node = root;
		while(!queue.isEmpty()) {
			node.right = queue.poll();
			node = node.right;
		}
	}
	
	public void preorder(TreeNode node) {
		if (node!= null) {
			queue.add(node);
			preorder(node.left);
			preorder(node.right);
			node.left = null;
			node.right = null;
		}
	}

}
