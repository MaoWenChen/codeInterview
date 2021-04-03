package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet113 {
	
	public static void main(String[] args) {
		Leet113 leet = new Leet113();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		root.left.left=new TreeNode(11);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(2);		
		System.out.println(leet.pathSum(root, 22));
	}
	
	List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		dfs(root, sum, new ArrayList<>());
		return lists;
	}

	public void dfs(TreeNode node, int sum, List<Integer> list) {
		if (node == null) {
			return;
		} else if (node.left == null && node.right == null) {
			if (sum == node.val) {
				list.add(sum);
				lists.add(new ArrayList<>(list));
				list.remove(list.size()-1);
			}
			return;
		} else {
			list.add(node.val);
			dfs(node.left, sum - node.val, list);
			dfs(node.right, sum - node.val, list);
			list.remove(list.size() - 1);
		}

	}
}
