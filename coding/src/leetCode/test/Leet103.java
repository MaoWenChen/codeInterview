package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet103 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		dfs(root, 0, res, true);
		return res;
	}
	
	public void dfs(TreeNode node , int level, List<List<Integer>> res, boolean isleft) {
		if (node!=null) {
			if (res.size()<=level) {
				res.add( new ArrayList<>());
			}
			if (isleft) {
				res.get(level).add(node.val);
			}else {
				res.get(level).add(0, node.val);
			}
			dfs(node.left, level+1, res, !isleft);
			dfs(node.right, level+1, res, !isleft);
		}
	}
}
